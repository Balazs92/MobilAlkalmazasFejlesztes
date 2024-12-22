package com.example.androidvizsgaminta2;

import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidvizsgaminta2.Expense;
import com.example.androidvizsgaminta2.ExpenseAdapter;
import com.example.androidvizsgaminta2.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Expense> expenseList;
    private ExpenseAdapter adapter;
    private SharedPreferences sharedPreferences;
    private TextView totalLabel;  // Az összeg megjelenítéséhez használt TextView
    private static final String PREFS_NAME = "ExpensePrefs";
    private static final String KEY_EXPENSES = "expenses";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        totalLabel = findViewById(R.id.total_label);  // Total TextView inicializálása
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        // Betöltés vagy alapértelmezett adatok beállítása
        expenseList = loadExpenses();
        if (expenseList.isEmpty()) {
            initializeDefaultExpenses();
        }

        adapter = new ExpenseAdapter(this, expenseList);
        listView.setAdapter(adapter);

        // Az összeg frissítése
        updateTotal();
    }

    // Az összeg kiszámítása és megjelenítése
    private void updateTotal() {
        float total = 0;
        for (Expense expense : expenseList) {
            total += expense.getAmount();
        }
        // Az összeg frissítése a TextView-ban
        totalLabel.setText(String.format("Total: $%.2f", total));
    }

    private List<Expense> loadExpenses() {
        String json = sharedPreferences.getString(KEY_EXPENSES, null);
        if (json == null) {
            return new ArrayList<>();
        }
        Type type = new TypeToken<List<Expense>>() {}.getType();
        return new Gson().fromJson(json, type);
    }

    private void saveExpenses() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String json = new Gson().toJson(expenseList);
        editor.putString(KEY_EXPENSES, json);
        editor.apply();
    }

    private void initializeDefaultExpenses() {
        expenseList.add(new Expense("Groceries", 50.00f, "Food"));
        expenseList.add(new Expense("Utilities", 100.00f, "Bills"));
        expenseList.add(new Expense("Transportation", 30.00f, "Transportation"));
        expenseList.add(new Expense("Entertainment", 20.00f, "Entertainment"));
        expenseList.add(new Expense("Clothing", 40.00f, "Shopping"));
        saveExpenses();
    }

    private void addRandomExpense() {
        Expense randomExpense = new Expense("Random Expense", (float) (Math.random() * 100), "Misc");
        expenseList.add(randomExpense);
        adapter.notifyDataSetChanged();
        saveExpenses();
        updateTotal();  // Az összeg frissítése
        Toast.makeText(this, "Random expense added", Toast.LENGTH_SHORT).show();
    }

    private void clearAllExpenses() {
        expenseList.clear();
        adapter.notifyDataSetChanged();
        saveExpenses();
        updateTotal();  // Az összeg frissítése
        Toast.makeText(this, "All expenses cleared", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_expense) {
            addRandomExpense();
            return true;
        } else if (item.getItemId() == R.id.clear_all) {
            clearAllExpenses();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}

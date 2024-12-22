package com.example.androidvizsgaminta2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidvizsgaminta2.Expense;
import com.example.androidvizsgaminta2.R;

import java.util.List;

public class ExpenseAdapter extends ArrayAdapter<Expense> {

    private Activity context;
    private List<Expense> expenseList;

    public ExpenseAdapter(@NonNull Context context, List<Expense> expenses) {
        super(context, R.layout.listview_row, expenses);
        this.context = (Activity) context;
        this.expenseList = expenses;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.listview_row, null, true);

        TextView description = view.findViewById(R.id.description);
        TextView amount = view.findViewById(R.id.amount);
        TextView category = view.findViewById(R.id.category);

        Expense expense = expenseList.get(position);

        description.setText(expense.getDescription());
        amount.setText(String.format("$%.2f", expense.getAmount()));
        category.setText(expense.getCategory());

        // Kattintás esemény hozzáadása
        view.setOnClickListener(v -> {
            Intent intent = new Intent(context, ExpenseDetailsActivity.class);
            intent.putExtra("title", expense.getDescription());
            intent.putExtra("amount", expense.getAmount());
            intent.putExtra("category", expense.getCategory());
            context.startActivity(intent);
        });

        return view;
    }



}

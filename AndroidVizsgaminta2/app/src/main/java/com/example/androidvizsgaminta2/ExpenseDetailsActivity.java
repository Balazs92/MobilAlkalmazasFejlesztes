package com.example.androidvizsgaminta2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExpenseDetailsActivity extends AppCompatActivity {

    private TextView titleLabel, amountLabel, categoryLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_details);

        titleLabel = findViewById(R.id.title_label);
        amountLabel = findViewById(R.id.amount_label);
        categoryLabel = findViewById(R.id.category_label);

        // Adatok átadása az Intentből
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        float amount = intent.getFloatExtra("amount", 0);
        String category = intent.getStringExtra("category");

        // Adatok megjelenítése
        titleLabel.setText("Title: " + title);
        amountLabel.setText("Amount: $" + String.format("%.2f", amount));
        categoryLabel.setText("Category: " + category);
    }
}

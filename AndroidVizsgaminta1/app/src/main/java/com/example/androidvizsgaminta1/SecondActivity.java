package com.example.androidvizsgaminta1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewGreen;
    private int clickCount = 0; // Ez a zöld érték
    private TextView textViewClicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewClicks = findViewById(R.id.textViewClicks);
        textViewGreen = findViewById(R.id.textViewClicks); // A TextView a zöld értékhez

        Button buttonOk = findViewById(R.id.buttonOk);
        Button buttonCancel = findViewById(R.id.buttonCancel);

        // Az Intent-ből átadott zöld érték beállítása
        Intent intent = getIntent();
        String greenValue = intent.getStringExtra("greenValue"); // Zöld érték átvétele
        textViewGreen.setText(greenValue); // Állítsuk be a zöld szöveget

        // "Ok" gomb eseménykezelése: zöld érték visszaküldése
        buttonOk.setOnClickListener(v -> {
            // Visszaküldjük a zöld értéket a MainActivity-nek
            Intent resultIntent = new Intent();
            resultIntent.putExtra("greenValue", greenValue); // Átadjuk a zöld értéket
            setResult(RESULT_OK, resultIntent); // Eredmény visszaadása
            finish(); // Vissza a MainActivity-be
        });

        // "Cancel" gomb eseménykezelése
        buttonCancel.setOnClickListener(v -> {
            setResult(RESULT_CANCELED); // Ha Cancel történt, az eredmény jelezése
            finish(); // Vissza a MainActivity-be
        });
    }

    // Kattintások számának növelése, ha szükséges a másik értékhez
    public void incrementClickCount() {
        clickCount++; // A kattintások számának növelése
        textViewClicks.setText("Kattintások száma: " + clickCount); // Frissítjük a TextView-t
    }
}

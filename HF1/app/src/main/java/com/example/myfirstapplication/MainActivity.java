package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText number1 = findViewById(R.id.editTextText);
        EditText number2 = findViewById(R.id.editTextText2);
        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        TextView resultView = findViewById(R.id.textView6);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Számok beolvasása és konvertálása
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());

                    // Összeadás
                    double result = num1 + num2;

                    // Eredmény megjelenítése
                    resultView.setText("Eredmény: " + result);
                } catch (NumberFormatException e) {
                    // Hibakezelés, ha nem számokat adtak meg
                    Toast.makeText(MainActivity.this, "Kérjük, adjon meg érvényes számokat!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Számok beolvasása és konvertálása
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());

                    // Kivonás
                    double result = num1 - num2;

                    // Eredmény megjelenítése
                    resultView.setText("Eredmény: " + result);
                } catch (NumberFormatException e) {
                    // Hibakezelés, ha nem számokat adtak meg
                    Toast.makeText(MainActivity.this, "Kérjük, adjon meg érvényes számokat!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Számok beolvasása és konvertálása
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());

                    // osztas
                    double result = num1 / num2;

                    // Eredmény megjelenítése
                    resultView.setText("Eredmény: " + result);
                } catch (NumberFormatException e) {
                    // Hibakezelés, ha nem számokat adtak meg
                    Toast.makeText(MainActivity.this, "Kérjük, adjon meg érvényes számokat!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Számok beolvasása és konvertálása
                    double num1 = Double.parseDouble(number1.getText().toString());
                    double num2 = Double.parseDouble(number2.getText().toString());

                    // szorzas
                    double result = num1 * num2;

                    // Eredmény megjelenítése
                    resultView.setText("Eredmény: " + result);
                } catch (NumberFormatException e) {
                    // Hibakezelés, ha nem számokat adtak meg
                    Toast.makeText(MainActivity.this, "Kérjük, adjon meg érvényes számokat!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
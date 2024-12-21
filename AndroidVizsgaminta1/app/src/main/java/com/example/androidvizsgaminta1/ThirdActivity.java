package com.example.androidvizsgaminta1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class ThirdActivity extends AppCompatActivity {

    TextView textViewSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textViewSelected = findViewById(R.id.textViewSelected);

        // Dynamikusan betöltött fragment
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            MyFragment fragment = new MyFragment();
            transaction.replace(R.id.fragmentContainer, fragment);
            transaction.commit();
        }
    }

    public void updateTextView(String selectedItem) {
        textViewSelected.setText(selectedItem);
    }
}

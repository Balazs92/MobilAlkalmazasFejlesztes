package com.example.activitystatesavetwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText; // EditText változó
    private CheckBox checkBox; // CheckBox változó

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText); // Objektum inicializálása
        checkBox = findViewById(R.id.checkBox); // Objektum inicializálása
        Button button = findViewById(R.id.button);

        // Állapot visszaállítása
        if (savedInstanceState != null) {
            editText.setText(savedInstanceState.getString("editTextValue"));
            checkBox.setChecked(savedInstanceState.getBoolean("checkBoxChecked"));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //Állapot mentése
        outState.putString("editTextValue", editText.getText().toString());
        outState.putBoolean("checkBoxChecked", checkBox.isChecked());
    }
}

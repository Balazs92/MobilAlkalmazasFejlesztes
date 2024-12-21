package com.example.androidvizsgaminta1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button buttonIncrease1, buttonIncrease2, buttonSecondActivity, buttonThirdActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        buttonIncrease1 = findViewById(R.id.buttonIncrease1);
        buttonIncrease2 = findViewById(R.id.buttonIncrease2);
        buttonSecondActivity = findViewById(R.id.buttonSecondActivity);
        buttonThirdActivity = findViewById(R.id.buttonThirdActivity);

        buttonIncrease1.setOnClickListener(v -> {
            int value = Integer.parseInt(editText1.getText().toString());
            value++;
            editText1.setText(String.valueOf(value));
        });

        buttonIncrease2.setOnClickListener(v -> {
            int value = Integer.parseInt(editText2.getText().toString());
            value++;
            editText2.setText(String.valueOf(value));
        });

        buttonSecondActivity.setOnClickListener(v -> {
            
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            String greenValue = editText2.getText().toString();
            intent.putExtra("greenValue", greenValue);
            startActivityForResult(intent, 1);
        });

        buttonThirdActivity.setOnClickListener(v -> {
            // Navigálás a ThirdActivity-re
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
        });

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        int savedValue1 = sharedPreferences.getInt("editText1", 0);
        int savedValue2 = sharedPreferences.getInt("editText2", 0);

        editText1.setText(String.valueOf(savedValue1));
        editText2.setText(String.valueOf(savedValue2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_save) {
            saveData();
            return true;
        } else if (id == R.id.action_reset) {
            resetData();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("editText1", Integer.parseInt(editText1.getText().toString()));
        editor.putInt("editText2", Integer.parseInt(editText2.getText().toString()));
        editor.apply();
    }

    private void resetData() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("editText1", 0);
        editor.putInt("editText2", 0);
        editor.apply();

        editText1.setText("0");
        editText2.setText("0");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // Ha az "OK" gombra kattintottak
                String greenValue = data.getStringExtra("greenValue"); // A zöld érték
                Toast.makeText(this, "Kattintások száma: " + greenValue, Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                // Ha a "Cancel" gombra kattintottak
                Toast.makeText(this, "A Cancel gombra kattintottál", Toast.LENGTH_LONG).show();
            }
        }
    }
}

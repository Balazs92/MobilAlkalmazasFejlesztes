package com.example.hf4;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class MainActivity extends AppCompatActivity {
    String[] nameArray = {"EUR", "USD", "GBP", "AUD",
            "CAD", "CHF", "DKK", "HUF"};

    String[] infoArray = {
            "Euro",
            "Dollar american",
            "Lira sterlina",
            "Dollar australian",
            "Dollar canadian",
            "Franc elvetian",
            "Coroana daneza",
            "Forint maghiar",
    };

    Integer[] imageArray = {R.drawable.euflag,
            R.drawable.usd,
            R.drawable.england,
            R.drawable.aud,
            R.drawable.canada,
            R.drawable.elvetia,
            R.drawable.denmark,
            R.drawable.hungary,
    };

    String[] buyArray = {
            "4.9", "4.5", "5.6", "3.1",
            "3.5", "4.3", "0.7", "0.012"
    };

    String[] sellArray = {
            "5.1", "4.7", "5.8", "3.3",
            "3.7", "4.5", "0.9", "0.014"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ablak insets kezelés
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });

        // ListView inicializálása és adapter beállítása
        ListView list = findViewById(R.id.customListView);
        CustomAdapter adapter = new CustomAdapter(this, nameArray, infoArray, imageArray,buyArray, sellArray);
        list.setAdapter(adapter);
    }
}

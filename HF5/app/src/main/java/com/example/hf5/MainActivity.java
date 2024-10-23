package com.example.hf5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> stringList;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        stringList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.listView)));

        listView = findViewById(R.id.listView);
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList);
        listView.setAdapter(myAdapter);


        registerForContextMenu(listView);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        View selectedItemView = listView.getChildAt(info.position);

        int itemId = item.getItemId();
        if (itemId == R.id.piros) {
            selectedItemView.setBackgroundColor(Color.RED);
            return true;
        } else if (itemId == R.id.zold) {
            selectedItemView.setBackgroundColor(Color.GREEN);
            return true;
        } else if (itemId == R.id.sarga) {
            selectedItemView.setBackgroundColor(Color.YELLOW);
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.rendez) {

            Collections.sort(stringList);
            myAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Lista rendezve", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.torol) {

            stringList.clear();
            myAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Lista törölve", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}

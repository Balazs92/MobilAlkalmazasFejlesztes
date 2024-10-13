package com.example.tablelayout2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText ProductCode = findViewById(R.id.EditText);
        EditText ProductName = findViewById(R.id.EditText2);
        EditText ProductPrice = findViewById(R.id.EditText3);
        TextView Products = findViewById(R.id.textView2);

        Button buttonAddProduct = findViewById(R.id.Button);
        Button buttonCancel = findViewById(R.id.Button2);
        Button buttonShowProducts = findViewById(R.id.button);

        buttonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct(ProductCode, ProductName, ProductPrice);
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields(ProductCode, ProductName, ProductPrice);
            }
        });

        buttonShowProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProducts(Products);
            }
        });
    }

    private void addProduct(EditText ProductCode, EditText ProductName, EditText ProductPrice) {
        String code = ProductCode.getText().toString();
        String name = ProductName.getText().toString();
        double price = Double.parseDouble(ProductPrice.getText().toString());

        Product product = new Product(code, name, price);
        productList.add(product);
        clearFields(ProductCode, ProductName, ProductPrice);
    }

    private void clearFields(EditText editTextProductCode, EditText editTextProductName, EditText editTextProductPrice) {
        editTextProductCode.setText("");
        editTextProductName.setText("");
        editTextProductPrice.setText("");
    }

    private void showProducts(TextView textViewProducts) {
        StringBuilder products = new StringBuilder();
        for (Product product : productList) {
            products.append(product.toString()).append("\n");
        }
        textViewProducts.setText(products.toString());
    }
}

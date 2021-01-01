package com.guy.tentaofgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guy.tentaofgo.models.Product;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    private static final String PRODUCT_LIST = "product list";
    private String name;
    private Float size;
    private Float price;
    private ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        loadData();
        System.out.println(products);
        findViewById(R.id.bt_add_product).setOnClickListener((View.OnClickListener) v -> {

            EditText editName = (EditText) findViewById(R.id.et_product_name);
            EditText editSize = (EditText) findViewById(R.id.et_product_size);
            EditText editPrice = (EditText) findViewById(R.id.et_product_price);
            convertAndPlacementProductValues(editName, editSize, editPrice);

            findViewById(R.id.bt_add_product).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Product product = new Product(name, size, price);
                    System.out.println(product);
                    products.add(product);
                    saveData();
                    finish();
                }
            });

        });

    }

    private void saveData() {
        SharedPreferences sp = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        Gson gson = new Gson();
        String json = gson.toJson(products);
        editor.putString(PRODUCT_LIST, json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sp = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sp.getString(PRODUCT_LIST, null);
        Type type = new TypeToken<ArrayList<Product>>() {}.getType();
        products = gson.fromJson(json, type);

        if(products == null){
            products = new ArrayList<>();
        }
    }

    private void convertAndPlacementProductValues(EditText editName, EditText editSize, EditText editPrice) {
        name = editName.getText().toString();
        size = Float.parseFloat(editSize.getText().toString());
        price = Float.parseFloat(editPrice.getText().toString());
    }

}
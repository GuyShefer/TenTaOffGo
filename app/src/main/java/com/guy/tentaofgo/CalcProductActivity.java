package com.guy.tentaofgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guy.tentaofgo.models.CalcProd;
import com.guy.tentaofgo.models.Product;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CalcProductActivity extends AppCompatActivity {

    private CalcProd calcProd;
    private List<Product> products;
    private static final String PRODUCT_LIST = "product list";
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_product);
        loadData();
        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<Product> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, products);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void loadData() {
        SharedPreferences sp = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sp.getString(PRODUCT_LIST, null);
        Type type = new TypeToken<ArrayList<Product>>() {
        }.getType();
        products = gson.fromJson(json, type);

        if (products == null) {
            products = new ArrayList<>();
        }
    }

    public void addNewCalcProd(View v) {
        Product product = (Product) spinner.getSelectedItem();
        String productName = product.getName();
        float amountInMeters = Float.parseFloat(((EditText) findViewById(R.id.et_product_amount)).getText().toString());
        float discount = Float.parseFloat(((EditText) findViewById(R.id.et_product_discount)).getText().toString());
        float totalAmount = calcTotalAmount(amountInMeters, product.getSize());
        float totalPrice = calcTotalPrice(totalAmount, product.getPrice(), discount);
        calcProd = new CalcProd(productName, amountInMeters, discount, totalPrice, totalAmount);
        OrderActivity.addNewProd(calcProd);
        finish();
    }

    private float calcTotalAmount(float amountInMeters, float size) {
        return amountInMeters / size;
    }

    private float calcTotalPrice(float totalAmount, float price, float discount) {
        if (discount > 0) {
            return totalAmount * price * (1.00f - discount / 100);
        }
        return totalAmount * price;
    }
}
package com.guy.tentaofgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.guy.tentaofgo.models.CalcProd;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private static List<CalcProd> orderList;
    private ListView listView;
    private OrderListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initList();
        findViewById(R.id.bt_add_to_order).setOnClickListener(v -> startCalcProductActivity());

        fillListViewWithOrderList();

        findViewById(R.id.bt_clear_order).setOnClickListener(v -> {
            orderList.clear();
            fillListViewWithOrderList();
        });

    }

    private void fillListViewWithOrderList() {
        listView = (ListView) findViewById(R.id.list_view);
        adapter = new OrderListAdapter(this, R.layout.adapter_view_layout, orderList);
        listView.setAdapter(adapter);
    }

    private void initList() {
        if(orderList == null){
            orderList = new ArrayList<>();
        }
    }

    private void startCalcProductActivity() {
        Intent intent = new Intent(this, CalcProductActivity.class);
        startActivity(intent);
    }

    public static void addNewProd(CalcProd calcProd){
        orderList.add(calcProd);
    }
}
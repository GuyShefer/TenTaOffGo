package com.guy.tentaofgo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.guy.tentaofgo.models.CalcProd;

import java.util.List;

public class OrderListAdapter extends ArrayAdapter<CalcProd> {

    private Context mContext;
    private int mResource;

    public OrderListAdapter(@NonNull Context context, int resource, @NonNull List<CalcProd> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String productName = getItem(position).getProductName();
        float amountInMeters = getItem(position).getAmountInMeters();
        float discount = getItem(position).getDiscount();
        float totalPrice = getItem(position).getTotalPrice();
        float totalAmount = getItem(position).getTotalAmount();

        CalcProd calcProd = new CalcProd(productName, amountInMeters, discount, totalPrice, totalAmount);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvProdName = (TextView) convertView.findViewById(R.id.tv_product_name);
        TextView tvAmountInMeters = (TextView) convertView.findViewById(R.id.tv_amount_in_meters);
        TextView tvDiscount = (TextView) convertView.findViewById(R.id.tv_discount);
        TextView tvTotalPrice = (TextView) convertView.findViewById(R.id.tv_total_price);
        TextView tvTotalAmount = (TextView) convertView.findViewById(R.id.tv_total_amount);

        tvProdName.setText(productName);
        tvAmountInMeters.setText(String.valueOf(amountInMeters));
        tvDiscount.setText(String.valueOf(discount));
        tvTotalPrice.setText(String.valueOf(totalPrice));
        tvTotalAmount.setText(String.valueOf(totalAmount));

        return convertView;
    }
}

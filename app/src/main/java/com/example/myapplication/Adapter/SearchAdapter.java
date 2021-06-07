package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Product;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<Product> searchList;

    public SearchAdapter() {
        searchList = new ArrayList<>();
    }

    public void setSearchList(List<Product> searchList) {
        this.searchList = searchList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row_search, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        Product p = searchList.get(position);
        if (p != null) {
            holder.tv1.setText("Tên sản phẩm: " + p.getTen());
            holder.tv2.setText("Hạn sử dụng: " + p.getNgay());
            holder.tv3.setText("Mô tả: " + p.getMota());
        } else
            return;
    }

    @Override
    public int getItemCount() {
        if (searchList != null)
            return searchList.size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv1, tv2, tv3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv11);
            tv2 = itemView.findViewById(R.id.tv12);
            tv3 = itemView.findViewById(R.id.tv13);
        }
    }
}

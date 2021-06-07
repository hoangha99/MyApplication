package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.Model.Product;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class AddAdapter extends RecyclerView.Adapter<AddAdapter.ViewHolder> {

    private List<Product> mlist;
    private MainActivity mainActivity;

    public AddAdapter(MainActivity m) {
        mainActivity = m;
        mlist = new ArrayList<>();
    }

    public List<Product> getList() {
        return mlist;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.my_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AddAdapter.ViewHolder holder, int position) {
        Product p = mlist.get(position);
        if (p != null) {
            holder.tv1.setText("Tên sản phẩm: " + p.getTen());
            holder.tv2.setText("Hạn sử dụng: " + p.getNgay());
            holder.tv3.setText("Mô tả: " + p.getMota());
            holder.btDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mlist.remove(position);
                    mainActivity.list = mlist;
                    notifyDataSetChanged();
                }
            });
        } else
            return;
    }


    @Override
    public int getItemCount() {
        if (mlist != null)
            return mlist.size();
        else
            return 0;
    }

    public void add(Product p) {
        mlist.add(p);
        notifyDataSetChanged();
        mainActivity.list = mlist;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv1, tv2, tv3;
        private Button btDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            btDelete = itemView.findViewById(R.id.btnDelete);

        }
    }
}

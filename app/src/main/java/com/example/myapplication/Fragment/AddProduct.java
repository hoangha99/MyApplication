package com.example.myapplication.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.AddAdapter;
import com.example.myapplication.MainActivity;
import com.example.myapplication.Model.Product;
import com.example.myapplication.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddProduct extends Fragment {

    private RecyclerView recyclerView;
    private AddAdapter addAdapter;
    private EditText ten, ngay, mota;
    private Button add;
    public MainActivity mainActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_product, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        addAdapter = new AddAdapter((MainActivity) getActivity());
        recyclerView.setAdapter(addAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isValidDate(ngay.getText().toString())) {
                }
                if(ten.getText().toString().equals("")) Toast.makeText(getContext(), "Không để trống tên sản phẩm", Toast.LENGTH_LONG).show();
                if(mota.getText().toString().equals("")) Toast.makeText(getContext(), "Không để trống mô tả sản phẩm", Toast.LENGTH_LONG).show();
                Product p = new Product(ten.getText().toString(), ngay.getText().toString(), mota.getText().toString());
                addAdapter.add(p);
                addAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Thêm thành công !", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void init(View v) {
        ten = v.findViewById(R.id.edTen);
        ngay = v.findViewById(R.id.edNgay);
        mota = v.findViewById(R.id.edMota);
        add = v.findViewById(R.id.btnAdd);
        recyclerView = v.findViewById(R.id.recyclerView);

        ngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int mYear = calendar.get(Calendar.YEAR);
                int mMonth = calendar.get(Calendar.MONTH);
                int mDay = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        ngay.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                }, mYear, mMonth, mDay);
                dialog.show();
            }
        });
    }

    private boolean isValidDate(String strDate) {
        if (strDate.trim().equals("")) {
            return true;
        } else {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
            sdfrmt.setLenient(false);

            try {
                Date javaDate = sdfrmt.parse(strDate);
            } catch (ParseException e) {
                Toast.makeText(getContext(), "Sai định dạng ngày !", Toast.LENGTH_LONG).show();
                return false;
            }
            return true;
        }
    }
}
package com.example.myapplication.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.SearchAdapter;
import com.example.myapplication.MainActivity;
import com.example.myapplication.Model.Product;
import com.example.myapplication.Adapter.AddAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchProduct extends Fragment {

    private RecyclerView recyclerView;
    private EditText editText;
    private SearchAdapter searchAdapter;
    private List<Product> list;
    

    public SearchProduct() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intView(view);

        searchAdapter = new SearchAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(searchAdapter);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void afterTextChanged(Editable s) {
                List<Product> tList=new ArrayList<>();
                String name=editText.getText().toString();
                tList = list.stream().filter(x -> x.getTen().equals(name)).collect(Collectors.toList());
                searchAdapter.setSearchList(tList);
            }
        });

    }
    private void intView(View v) {
        recyclerView=v.findViewById(R.id.rv);
        editText=v.findViewById(R.id.name);
    }
    @Override
    public void onResume() {
        super.onResume();
        list = ((MainActivity)getActivity()).list;
    }
}
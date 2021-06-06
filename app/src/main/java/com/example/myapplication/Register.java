package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Database.DataUser;
import com.example.myapplication.Model.User;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Register extends AppCompatActivity {

    private EditText name, username, pass, ngay;
    Button button;
    DataUser dataUser;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRegister();
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void doRegister(){
        if(name.getText().toString().equals("") ||ngay.getText().toString().equals("")
                ||username.getText().toString().equals("") ||pass.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try{
                Date date = formatter.parse(ngay.getText().toString());
                if(dataUser.isHasUsername(username.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Tên tài khoản đã tồn tại !", Toast.LENGTH_LONG).show();
                    return;
                }
                User us = new User(name.getText().toString(), date , username.getText().toString(), pass.getText().toString());
                dataUser.addUser(us);
                Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(), "Ngày sai định dạng", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void init(){
        name = findViewById(R.id.name);
        ngay = findViewById(R.id.ngay);
        username = findViewById(R.id.us);
        pass = findViewById(R.id.passw);
        button=findViewById(R.id.btRegister);
        dataUser = new DataUser(getApplicationContext());

        ngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mYear = 1999;
                int mMonth = 0;
                int mDay = 1;
                DatePickerDialog dialog = new DatePickerDialog(Register.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        ngay.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
                dialog.show();
            }
        });
    }
}
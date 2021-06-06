package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Database.DataUser;

public class Login extends AppCompatActivity {
    private EditText username, pass;
    private Button login, register;

    private DataUser dataUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        dataUser = new DataUser(getApplicationContext());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("") && pass.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập tên tài khoản mật khẩu !", Toast.LENGTH_LONG).show();
                }
                if(!dataUser.checkLogin(username.getText().toString(), pass.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Tài khoản không tồn tại !", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent =  new Intent(Login.this, MainActivity.class);
                    intent.putExtra("username", username.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private void init(){
        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
    }
}
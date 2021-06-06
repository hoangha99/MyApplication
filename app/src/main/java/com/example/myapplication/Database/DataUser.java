package com.example.myapplication.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.myapplication.Model.User;

import java.time.LocalDate;
import java.util.Date;

public class DataUser extends SQLiteOpenHelper {

    private Context context;

    public DataUser(@Nullable Context context) {
        super(context, "user.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS user (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(50)," +
                "date_of_birth VARCHAR(50)," +
                "username VARCHAR(50)," +
                "password VARCHAR(50))";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addUser(User user) {
        String query = "INSERT INTO User(name, date_of_birth,username, password) VALUES (?, ?, ?, ?)";

        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL(query, new String[]{user.getName(), user.getDateOfBirth().toString(), user.getUsername(), user.getPass()});
    }

    public int delete(int id) {
        SQLiteDatabase sql = getWritableDatabase();
        return sql.delete("user", "id = ? ", new String[]{String.valueOf(id)});
    }


//    @RequiresApi(api = Build.VERSION_CODES.O)
//    public User findByUsername(String key) {
//        User user;
//        String query = "ten = ?";
//        SQLiteDatabase sql = getReadableDatabase();
//
//        Cursor cursor = sql.query("User", null, query, new String[]{":" + key}, null, null, null);
//
//        String dateOfBirth = cursor.getString(2).trim();
//
//
//        user = new User(cursor.getInt(0),cursor.getString(1), localDate, cursor.getString(3), cursor.getString(4));
//        return user;
//    }

    public Boolean isHasUsername(String us){
        SQLiteDatabase sql = getReadableDatabase();
        Cursor cursor = sql.rawQuery("Select * from user where username = '" + us+"'",null);
        if (cursor.getCount()==0) return false;
        return true;
    }

    public Boolean checkLogin(String us, String pass){
        SQLiteDatabase sql = getReadableDatabase();
        Cursor cursor = sql.rawQuery("Select * from user where username = '" + us+"' "+"and password = '"+pass+"'",null);
        if (cursor.getCount()==0) return false;
        return true;
    }


}

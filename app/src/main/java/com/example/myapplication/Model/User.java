package com.example.myapplication.Model;


import java.time.LocalDate;
import java.util.Date;

public class User {
    private int id;
    private String name;
    private Date dateOfBirth;
    private String username;
    private String pass;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public User(String name, Date dateOfBirth, String username, String pass) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.pass = pass;
    }
}

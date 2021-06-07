package com.example.myapplication.Model;

public class Product {
    String ten, ngay, mota;

    public Product(String ten, String ngay, String mota) {
        this.ten = ten;
        this.ngay = ngay;
        this.mota = mota;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}

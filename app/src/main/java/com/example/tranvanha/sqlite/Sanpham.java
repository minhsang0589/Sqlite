package com.example.tranvanha.sqlite;

public class Sanpham {
private  String masp;
private  String tensp;
private int giatien;

    public Sanpham(String masp, String tensp, int giatien) {
        this.masp = masp;
        this.tensp = tensp;
        this.giatien = giatien;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGiatien() {
        return giatien;
    }

    public void setGiatien(int giatien) {
        this.giatien = giatien;
    }
}

package com.example.examsqlite;

public class SinhVien {
    String ten;
    String masv;
    String diem;

    public SinhVien(String ten, String masv, String diem) {
        this.ten = ten;
        this.masv = masv;
        this.diem = diem;
    }

    public SinhVien() {

    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }
}

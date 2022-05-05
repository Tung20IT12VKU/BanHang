package com.example.loginfirebase.model;

public class Users {
    private int id;
    private String hoten;
    private String idtaikhoan;
    private String ngaysinh;
    private String diachi;

    public Users() {
    }

    public Users(int id, String hoten, String idtaikhoan, String ngaysinh, String diachi) {
        this.id = id;
        this.hoten = hoten;
        this.idtaikhoan = idtaikhoan;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getIdtaikhoan() {
        return idtaikhoan;
    }

    public void setIdtaikhoan(String idtaikhoan) {
        this.idtaikhoan = idtaikhoan;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}

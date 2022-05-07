package com.example.loginfirebase.model;

public class Toi {
    private int id;
    private int image;
    private String ten;

    public Toi() {
    }

    public Toi(int id, int image, String ten) {
        this.id = id;
        this.image = image;
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}

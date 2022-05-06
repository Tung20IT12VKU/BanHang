package com.example.loginfirebase.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int id;
    private String imageSanpham;
    private String tenSanpham;
    private float giaSanpham;
    private static String key;

    public SanPham() {
    }

    public SanPham(int id, String imageSanpham, String tenSanpham, float giaSanpham) {
        this.id = id;
        this.imageSanpham = imageSanpham;
        this.tenSanpham = tenSanpham;
        this.giaSanpham = giaSanpham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageSanpham() {
        return imageSanpham;
    }

    public void setImageSanpham(String imageSanpham) {
        this.imageSanpham = imageSanpham;
    }

    public String getTenSanpham() {
        return tenSanpham;
    }

    public void setTenSanpham(String tenSanpham) {
        this.tenSanpham = tenSanpham;
    }

    public float getGiaSanpham() {
        return giaSanpham;
    }

    public void setGiaSanpham(float giaSanpham) {
        this.giaSanpham = giaSanpham;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

package com.example.loginfirebase.model;

import java.io.Serializable;

public class DanhMuc implements Serializable {
    private int id;
    private String image;
    private String tendanhmuc;

    public DanhMuc() {
    }

    public DanhMuc(int id, String image, String tendanhmuc) {
        this.id = id;
        this.image = image;
        this.tendanhmuc = tendanhmuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }
}

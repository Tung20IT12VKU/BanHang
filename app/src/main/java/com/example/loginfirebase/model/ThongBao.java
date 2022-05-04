package com.example.loginfirebase.model;

public class ThongBao {
    String image;
    String title;
    String chitiet;

    public ThongBao() {
    }

    public ThongBao(String image, String title, String chitiet) {
        this.image = image;
        this.title = title;
        this.chitiet = chitiet;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }
}

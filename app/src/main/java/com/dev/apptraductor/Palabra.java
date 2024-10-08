package com.dev.apptraductor;

public class Palabra {
    private String espanol, ingles;
    private int img;

    public Palabra(String espanol, String ingles, int img) {
        this.espanol = espanol;
        this.ingles = ingles;
        this.img = img;
    }

    public String getEspanol() {
        return espanol;
    }

    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

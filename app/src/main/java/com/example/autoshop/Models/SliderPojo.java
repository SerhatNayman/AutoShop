package com.example.autoshop.Models;

public class SliderPojo {

    private String resim;

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    @Override
    public String toString() {
        return "SliderPojo{" +
                "resim='" + resim + '\'' +
                '}';
    }
}

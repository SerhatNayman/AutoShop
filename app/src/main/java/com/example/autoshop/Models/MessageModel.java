package com.example.autoshop.Models;

public class MessageModel {

    private String from,Mesaj,to;

    public MessageModel(String from, String mesaj, String to) {
        this.from = from;
        Mesaj = mesaj;
        this.to = to;
    }

    public MessageModel() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMesaj() {
        return Mesaj;
    }

    public void setMesaj(String mesaj) {
        Mesaj = mesaj;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}

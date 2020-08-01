package com.example.mail.entity;

public class Mail {
    private int id;
    private String toWho;
    private String fromWho;
    private String theme;
    private String text;

    public Mail() {
    }

    public Mail(int id, String toWho, String fromWho, String theme, String text) {
        this.id = id;
        this.toWho = toWho;
        this.fromWho = fromWho;
        this.theme = theme;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }

    public String getFromWho() {
        return fromWho;
    }

    public void setFromWho(String fromWho) {
        this.fromWho = fromWho;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

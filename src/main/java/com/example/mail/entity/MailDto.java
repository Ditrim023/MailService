package com.example.mail.entity;

public class MailDto {
    private String receiver;
    private String theme;
    private String text;

    public MailDto() {
    }

    public MailDto(String receiver, String theme, String text) {
        this.receiver = receiver;
        this.theme = theme;
        this.text = text;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
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

    @Override
    public String toString() {
        return "MailDto{" +
                "receiver='" + receiver + '\'' +
                ", theme='" + theme + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

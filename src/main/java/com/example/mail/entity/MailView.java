package com.example.mail.entity;

public class MailView {
    private int id;
    private String owner;
    private String companion;
    private String mailType;
    private String theme;
    private String text;
    private String dateCreate;

    public MailView() {
    }

    public MailView(int id, String owner, String companion, String mailType, String theme, String text, String dateCreate) {
        this.id = id;
        this.owner = owner;
        this.companion = companion;
        this.mailType = mailType;
        this.theme = theme;
        this.text = text;
        this.dateCreate = dateCreate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCompanion() {
        return companion;
    }

    public void setCompanion(String companion) {
        this.companion = companion;
    }

    public String getMailType() {
        return mailType;
    }

    public void setMailType(String mailType) {
        this.mailType = mailType;
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

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }
}

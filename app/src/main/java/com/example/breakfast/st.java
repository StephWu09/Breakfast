package com.example.breakfast;

public class st {
    private int id;
    private String account;
    private String pass;
    public st(int id, String account, String pass) {
        this.id = id;
        this.account = account;
        this.pass = pass;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    @Override
    public String toString() {
        return "St{"+"id="+id+", account='"+account+'\''+", pass='"+pass+'\''+'}';
    }
}
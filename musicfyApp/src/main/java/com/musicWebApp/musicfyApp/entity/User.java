package com.musicWebApp.musicfyApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuEmailId() {
        return uEmailId;
    }

    public void setuEmailId(String uEmailId) {
        this.uEmailId = uEmailId;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Id
    @GeneratedValue
    int uid;
    String uName;

    String uEmailId;

    String uPassword;



}

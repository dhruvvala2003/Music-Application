package com.musicWebApp.musicfyApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.id.IncrementGenerator;

@Entity
public class Mp3Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer mid;

    String name;
    String pathh;

    public String getPathh() {
        return pathh;
    }

    public void setPathh(String pathh) {
        this.pathh = pathh;
    }

    public Mp3Files()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

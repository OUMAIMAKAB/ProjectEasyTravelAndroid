package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Utilisateur implements Serializable {
    private int id;
    private String nom;
    private String image;
    private String email;
    private String password;
    private List<Link> links=new ArrayList<Link>();

    public Utilisateur(String nom, String email, String password){
        this.nom = nom;
        this.email = email;
        this.password = password;
    }

    public Utilisateur(String nom, String image, String email, String password) {
        this.nom = nom;
        this.image = image;
        this.email = email;
        this.password = password;
    }

    public Utilisateur(String nom, String image) {
        this.nom = nom;
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

}

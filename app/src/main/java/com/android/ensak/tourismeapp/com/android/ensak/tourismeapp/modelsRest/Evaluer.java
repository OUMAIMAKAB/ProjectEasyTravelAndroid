package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Evaluer implements Serializable {


    private String commentaire;
    private int idRestaurant;
    private List<Link> links = new ArrayList<Link>();
    private int idUtilisateur;

    public Evaluer(String commentaire, int idRestaurant, List<Link> links, int idUtilisateur) {
        this.commentaire = commentaire;
        this.idRestaurant = idRestaurant;
        this.links = links;
        this.idUtilisateur = idUtilisateur;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}

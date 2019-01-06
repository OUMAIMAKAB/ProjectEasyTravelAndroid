package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse;

import java.io.Serializable;

public class Element implements Serializable {
    private String nameElement;
    private int imageElement;
    private String descriptionElement;

    public Element(String nameElement, int imageElement) {
        this.nameElement = nameElement;
        this.imageElement = imageElement;
    }

    public Element(String nameElement, int imageElement, String descriptionElement) {
        this.nameElement = nameElement;
        this.imageElement = imageElement;
        this.descriptionElement = descriptionElement;
    }

    public void setDescriptionElement(String descriptionElement) {
        this.descriptionElement = descriptionElement;
    }

    public String getDescriptionElement() {

        return descriptionElement;
    }

    public String getNameElement() {
        return nameElement;
    }

    public int getImageElement() {
        return imageElement;
    }

    public void setNameElement(String nameElement) {
        this.nameElement = nameElement;
    }

    public void setImageElement(int imageElement) {
        this.imageElement = imageElement;
    }
}

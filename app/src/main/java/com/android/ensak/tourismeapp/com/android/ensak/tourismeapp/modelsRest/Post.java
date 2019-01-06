package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest;

import java.io.Serializable;

public class Post  implements Serializable {


    private String texte;


    public Post(String texte) {
        this.texte = texte;
    }



    @Override
    public String toString() {
        return "Post{" +

                ", texte = " + texte +
                '}';


    }



    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

}

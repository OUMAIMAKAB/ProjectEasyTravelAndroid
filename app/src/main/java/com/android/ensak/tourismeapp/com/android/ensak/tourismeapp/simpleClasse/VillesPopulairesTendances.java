package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse;

public class VillesPopulairesTendances {
    private int imageVille;
    private String nameVille;

    public VillesPopulairesTendances(int imageVille, String nameVille) {
        this.imageVille = imageVille;
        this.nameVille = nameVille;
    }

    public int getImageVille() {
        return imageVille;
    }

    public String getNameVille() {
        return nameVille;
    }

    public void setImageVille(int imageVille) {
        this.imageVille = imageVille;
    }

    public void setNameVille(String nameVille) {
        this.nameVille = nameVille;
    }
}

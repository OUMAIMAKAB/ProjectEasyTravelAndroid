package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Artisanat;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Banque;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.CentreDeChange;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Evaluer;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Gastronomie;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Hopital;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Logement;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Pharmacie;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Post;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Restaurant;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Transport;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Utilisateur;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Ville;

import java.util.ArrayList;
import java.util.List;

public class GlobalClass {
    public static List<Ville> listVilles= new ArrayList<Ville>();
    public static ArrayList<Monument> listVilleMonuments= new ArrayList<Monument>();
    public static List<Artisanat> listVilleArtisanats=new ArrayList<Artisanat>();
    public static List<Banque> listVilleBanques=new ArrayList<Banque>();
    public static List<CentreDeChange> listVilleCentreDeChanges=new ArrayList<CentreDeChange>();
    public static List<Gastronomie> listVilleGastronomies= new ArrayList<Gastronomie>();
    public static List<Hopital> listVilleHopitals=new ArrayList<Hopital>();
    public static List<Logement> listVilleLogements=new ArrayList<Logement>();
    public static List<Pharmacie> listVillePharmacies=new ArrayList<Pharmacie>();
    public static List<Restaurant> listVilleRestaurants=new ArrayList<Restaurant>();
    public static List<Transport> listVilleTransports=new ArrayList<Transport>();
    public static List<Utilisateur> listUtilisateurs= new ArrayList<Utilisateur>();
    public static List<Evaluer> listEvaluer=new ArrayList<Evaluer>();
    public static Utilisateur user;
    public static Utilisateur userUpdate;
    public static String urlServerImages= "http://192.168.1.9:8085/images/";
    public static int idPositionVilleCourante;


	public static List<Post> listPost = new ArrayList<>();
    public static Post pst;
    public static Post pstUpdate;

    public static int idUtilisateurCourant;
    public static int idUtilisateurCourantConnecte;

}

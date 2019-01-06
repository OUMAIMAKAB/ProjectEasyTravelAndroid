package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse;

import android.content.Context;
import android.content.res.TypedArray;

import com.android.ensak.tourismeapp.R;

import java.util.ArrayList;

public class AppUtility {
    private String [] monumentsRabatNames;
    private TypedArray monumentsRabatDrawable;
    private String [] monumentsRabatDescriptions;
    private String [] nomVillesPopulaires;
    private TypedArray drawableVillesPopulaires;
    private String [] nomVillesPatrimoineUnesco;
    private TypedArray drawablePatrimoineUnesco;
    private ArrayList<VillesPopulairesTendances> listeVillesPopulaires;
    private ArrayList<VillesPopulairesTendances> listeVillesPatrimoineUnesco;
    private ArrayList<Element> monumentsRabat;
    int index;

    private Context context;
    private static AppUtility appUtility;

    private AppUtility(Context context){
        this.context=context;
        monumentsRabatNames=context.getResources().getStringArray(R.array.monumentsRabatNames);
        monumentsRabatDrawable=context.getResources().obtainTypedArray(R.array.monumentsRabatDrawable);
        monumentsRabatDescriptions=context.getResources().getStringArray(R.array.monumentsRabatDescriptions);
        monumentsRabat=new ArrayList<Element>();
        index=0;
        for (String t:monumentsRabatNames){
            monumentsRabat.add(new Element(t,monumentsRabatDrawable.getResourceId(index,-1),monumentsRabatDescriptions[index]));
            index++;
        }
        nomVillesPopulaires=context.getResources().getStringArray(R.array.nomVillesPopulaires);
        drawableVillesPopulaires=context.getResources().obtainTypedArray(R.array.drawableVillesPopulaires);
        listeVillesPopulaires=new ArrayList<VillesPopulairesTendances>();
        listeVillesPatrimoineUnesco=new ArrayList<VillesPopulairesTendances>();
        index=0;
        for (String t:nomVillesPopulaires){
            listeVillesPopulaires.add(new VillesPopulairesTendances(drawableVillesPopulaires.getResourceId(index,-1),t));
            index++;
        }
        nomVillesPatrimoineUnesco=context.getResources().getStringArray(R.array.nomVillesPatrimoineUnesco);
        drawablePatrimoineUnesco=context.getResources().obtainTypedArray(R.array.drawablePatrimoineUnesco);
        index=0;
        for (String t:nomVillesPatrimoineUnesco){
            listeVillesPatrimoineUnesco.add(new VillesPopulairesTendances(drawablePatrimoineUnesco.getResourceId(index,-1),t));
            index++;
        }
    }

    public static AppUtility getAppUtility(Context context){
        if(appUtility==null){
            appUtility=new AppUtility(context);
        }
        return appUtility;
    }

    public String[] getMonumentsRabatNames() {
        return monumentsRabatNames;
    }

    public TypedArray getMonumentsRabatDrawable() {
        return monumentsRabatDrawable;
    }

    public String[] getMonumentsRabatDescriptions() {
        return monumentsRabatDescriptions;
    }

    public ArrayList<VillesPopulairesTendances> getListeVillesPopulaires() {
        return listeVillesPopulaires;
    }

    public ArrayList<VillesPopulairesTendances> getListeVillesPatrimoineUnesco() {
        return listeVillesPatrimoineUnesco;
    }

    public ArrayList<Element> getMonumentsRabat() {
        return monumentsRabat;
    }

    public String[] getNomVillesPopulaires() {
        return nomVillesPopulaires;
    }
}

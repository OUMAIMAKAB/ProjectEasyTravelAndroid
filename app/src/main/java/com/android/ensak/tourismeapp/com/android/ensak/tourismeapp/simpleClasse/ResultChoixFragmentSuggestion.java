package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Artisanat;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Gastronomie;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Hopital;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Logement;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Pharmacie;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Restaurant;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Transport;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.PageRechercheActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListArtisanatsAdapter;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListElementsAdapter;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListGastronomiesAdapter;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListHopitauxAdapter;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListLogementsAdapter;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListMonumentsAdapter;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListPharmaciesAdapter;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListRestaurantsAdapter;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListTransportsAdapter;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.ListeElmentsFragment;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.VillesPopulairesTendancesFragment;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.test.TestSuggestionActivity;
import com.nostra13.universalimageloader.utils.L;

import java.util.ArrayList;

public class ResultChoixFragmentSuggestion {

    private String nomVille;
    private Context context;
    private String choix;
    private static ResultChoixFragmentSuggestion resultChoixFragmentSuggestion;
    private FragmentManager fragmentManager;

    private ResultChoixFragmentSuggestion(Context context, String choix) {

        this.context = context;
        this.choix = choix;
    }

    private ResultChoixFragmentSuggestion(Context context) {
        this.context = context;
    }

    public static ResultChoixFragmentSuggestion getResultChoixFragmentSuggestion(Context context){
        if(resultChoixFragmentSuggestion==null){
            resultChoixFragmentSuggestion=new ResultChoixFragmentSuggestion(context);
        }
        return resultChoixFragmentSuggestion;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void getFragmentSuggestion(){

        switch(choix){
            case "villes_populaires" : case "tendances" :
                fragmentVillesPopulairesOuPatrimoineUnesco();
                break;
            case "Monuments":
              monumentVille();

                break;
            case "Artisanat" :
               artisanatVille();

                break;
            case "Banques":

                break;
            case "Centre de Changes":

                break;
            case "Gastronomies":
                gastronomieVille();
                break;
            case "Hopitaux":
                hopitalVille();
                break;
            case "Restaurants":
                  restaurantVille();
                break;
            case "Logements":
                  logementVille();
                break;
            case "Pharmacies":
                  pharmacieVille();
                break;
            case "Transports":
                  transportVille();
                break;


        }

    }

    private void transportVille() {
        ListTransportsAdapter listTransportsAdapter=new ListTransportsAdapter(context,R.layout.layout_list_transports_adapter, (ArrayList<Transport>) GlobalClass.listVilleTransports);
        ListeElmentsFragment listeElmentsFragment=new ListeElmentsFragment(listTransportsAdapter);
        fragmentManager.beginTransaction().add(R.id.layout_container,listeElmentsFragment).commit();
    }

    private void pharmacieVille() {
        ListPharmaciesAdapter listPharmacieAdapter=new ListPharmaciesAdapter(context,R.layout.layout_list_pharmacies_adapter, (ArrayList<Pharmacie>) GlobalClass.listVillePharmacies);
        ListeElmentsFragment listeElmentsFragment=new ListeElmentsFragment(listPharmacieAdapter);
        fragmentManager.beginTransaction().add(R.id.layout_container,listeElmentsFragment).commit();
    }

    private void logementVille() {
        ListLogementsAdapter listLogementAdapter=new ListLogementsAdapter(context,R.layout.layout_list_logements_adapter, (ArrayList<Logement>) GlobalClass.listVilleLogements);
        ListeElmentsFragment listeElmentsFragment=new ListeElmentsFragment(listLogementAdapter);
        fragmentManager.beginTransaction().add(R.id.layout_container,listeElmentsFragment).commit();
    }

    private void restaurantVille() {
        ListRestaurantsAdapter listRestaurantsAdapter=new ListRestaurantsAdapter(context,R.layout.layout_list_restaurants_adapter, (ArrayList<Restaurant>) GlobalClass.listVilleRestaurants);
        ListeElmentsFragment listeElmentsFragment=new ListeElmentsFragment(listRestaurantsAdapter);
        fragmentManager.beginTransaction().add(R.id.layout_container,listeElmentsFragment).commit();
    }

    private void hopitalVille() {
        ListHopitauxAdapter listHopitauxAdapter=new ListHopitauxAdapter(context,R.layout.layout_list_hopitaux_adapter, (ArrayList<Hopital>) GlobalClass.listVilleHopitals);
        ListeElmentsFragment listeElmentsFragment=new ListeElmentsFragment(listHopitauxAdapter);
        fragmentManager.beginTransaction().add(R.id.layout_container,listeElmentsFragment).commit();
    }

    private void gastronomieVille() {
        ListGastronomiesAdapter listGastronomiesAdapter=new ListGastronomiesAdapter(context,R.layout.layout_list_gastronomies_adapter, (ArrayList<Gastronomie>) GlobalClass.listVilleGastronomies);
        ListeElmentsFragment listeElmentsFragment=new ListeElmentsFragment(listGastronomiesAdapter);
        fragmentManager.beginTransaction().add(R.id.layout_container,listeElmentsFragment).commit();
    }


    private void artisanatVille() {

        ListArtisanatsAdapter listArtisanatsAdapter=new ListArtisanatsAdapter(context,R.layout.layout_list_artisanats_adapter, (ArrayList<Artisanat>) GlobalClass.listVilleArtisanats);
        ListeElmentsFragment listeElmentsFragment=new ListeElmentsFragment(listArtisanatsAdapter);
        fragmentManager.beginTransaction().add(R.id.layout_container,listeElmentsFragment).commit();

    }

    private void fragmentVillesPopulairesOuPatrimoineUnesco() {
        VillesPopulairesTendancesFragment villesPopulairesTendancesFragment = new VillesPopulairesTendancesFragment();
        villesPopulairesTendancesFragment.choixSuggestion(choix);
        villesPopulairesTendancesFragment.initContext(context);
        fragmentManager.beginTransaction().replace(R.id.layout_container, villesPopulairesTendancesFragment).commit();
    }

    private void monumentVille() {
               /*
                ListElementsAdapter listElementsAdapter=new ListElementsAdapter(context,R.layout.layout_list_elements_adapter,AppUtility.getAppUtility(context).getMonumentsRabat());
                ListeElmentsFragment listeElmentsFragment=new ListeElmentsFragment(listElementsAdapter);
                fragmentManager.beginTransaction().add(R.id.layout_container,listeElmentsFragment).commit();
                break;
                */
                ListMonumentsAdapter listMonumentsAdapter=new ListMonumentsAdapter(context,R.layout.layout_list_monuments_adapter,GlobalClass.listVilleMonuments);
                ListeElmentsFragment listeElmentsFragment=new ListeElmentsFragment(listMonumentsAdapter);
                fragmentManager.beginTransaction().add(R.id.layout_container,listeElmentsFragment).commit();
        }

    }



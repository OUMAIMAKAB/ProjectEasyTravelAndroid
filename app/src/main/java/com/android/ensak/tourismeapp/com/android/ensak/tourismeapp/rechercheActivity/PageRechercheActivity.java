package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Ville;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.VilleActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.ListeVillesFragment;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.listeSuggestionsFragment;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.AppUtility;

public class PageRechercheActivity extends AppCompatActivity implements ListeVillesFragment.OnFragmentInteractionListenerListeVilles{


    FragmentManager fragmentManager;
    ListeVillesFragment listeVillesFragment;
    com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.listeSuggestionsFragment listeSuggestionsFragment;
    Context context;
    FragmentActivity myContext;
    String[] tableNomVille ;
    String[] tableRechercheSurTourismeApp=new String[GlobalClass.listVilleMonuments.size()];;
    EditText editText;
    String [] table;
    String typePageRecherche;
    String nomVille;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_recherche);
        editText=findViewById(R.id.barreRecherchePageRecherche);
        Intent intent = getIntent();
        Bundle bundle =intent.getExtras();

        typePageRecherche=bundle.getString("typePageRecherche");
        //nomVille=bundle.getString("nomVille");
        myContext= this;
        context=this;
        listeVillesFragment =new ListeVillesFragment();
        listeSuggestionsFragment =new listeSuggestionsFragment();
        listeVillesFragment.initContext(context);
        fragmentManager=getSupportFragmentManager();
        tableNomVille = AppUtility.getAppUtility(context).getNomVillesPopulaires();
        //tableRechercheSurTourismeApp=getResources().getStringArray(R.array.recherche_sur_Tourisme_App);

        int indexListMonuments=0;
        for (Monument monument:GlobalClass.listVilleMonuments) {

            tableRechercheSurTourismeApp[indexListMonuments]=GlobalClass.listVilleMonuments.get(indexListMonuments).getName();
            Toast.makeText(this,"monument+nom"+tableRechercheSurTourismeApp[indexListMonuments],Toast.LENGTH_LONG).show();
            indexListMonuments++;
        }


        getSupportFragmentManager().beginTransaction().add(R.id.content_fragment_page_recherche,listeVillesFragment,"fragment2")
                .add(R.id.content_fragment_page_recherche, listeSuggestionsFragment,"fragment1")
                .show(listeSuggestionsFragment)
                .hide(listeVillesFragment).commit();

        switch (typePageRecherche){
            case "ville":
                editText.setHint("Recherchez sur Tourisme APP");
                listeSuggestionsFragment.typeSuggestion("ville");
                table=tableRechercheSurTourismeApp;
                break;
            case "Page Principale":
                listeSuggestionsFragment.typeSuggestion("Page Principale");
                table=tableNomVille;
                break;

        }
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setFocusable(true);
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.toString().equals("")){
                    getSupportFragmentManager().beginTransaction().show(listeSuggestionsFragment).hide(listeVillesFragment).commit();
                }else {
                    getSupportFragmentManager().beginTransaction().show(listeVillesFragment).hide(listeSuggestionsFragment).commit();
                    listeVillesFragment.remplirListe(s.toString(), table);

                }
                        /*
                     getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment_page_recherche,listeVillesFragment).commit();
                     getSupportFragmentManager().beginTransaction().show(listeVillesFragment).commit();
                     listeVillesFragment.remplirListe(s.toString(),tableNomVille);
                     */
            }
            @Override
            public void afterTextChanged(Editable s){}
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (typePageRecherche){
            case "ville":
                LinearLayout linearLayout=(LinearLayout) view;
                TextView textVie=(TextView) linearLayout.findViewById(R.id.barreRecherche2);
                //Toast.makeText(myContext, String.valueOf(position)+" "+textVie.getText()+" "+nomVille, Toast.LENGTH_LONG).show();
                Monument monument =getMonumentByName(textVie.getText().toString());
                Intent intent2 = new Intent(this,MonumentActivity.class);
                intent2.putExtra("monument", monument);
                startActivity(intent2);
                break;
            case "Page Principale":

                LinearLayout linearLayout2=(LinearLayout) view;
                TextView textVie2=(TextView) linearLayout2.findViewById(R.id.barreRecherche2);
                //////////////////
                // String nomVille=textVie2.getText().toString()
                int positionList=getIdVille(textVie2.getText().toString().toLowerCase());
                Intent intent = new Intent(this,VilleActivity.class);
                // intent.putExtra("nomVille",nameVille);
                intent.putExtra("positionList",positionList);
                startActivity(intent);
                /////////////////

                break;

        }

    }

    private Monument getMonumentByName(String s) {
        Monument monument=new Monument();
        for (Monument monument2:GlobalClass.listVilleMonuments
                ) {
            if(monument2.getName().equals(s)){
                monument=monument2;
            }
        }
        return monument;
    }

    private int getIdVille(String s) {
        int idVille = 0;
        for (Ville ville:GlobalClass.listVilles) {
            if(ville.getName().equals(s)){
                break;
            }
            idVille++;
        }
        return idVille;
    }
}

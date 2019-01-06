package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestVilleTransports;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.ContainerActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.MapActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.test.TestSuggestionActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class listeSuggestionsFragment extends Fragment {

    ListView listeView;
    ArrayList<String> nameSuggestions=new ArrayList<>() ;
    Context context;
    String typeSuggestion;
    TextView textView;
    String nomVille;

    FragmentManager fragmentManager;
    public listeSuggestionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_liste_suggestions,container,false);
    }


    public void typeSuggestion(String typeSuggestion) {
        this.typeSuggestion=typeSuggestion;
        if(typeSuggestion.equals("ville")){

            nameSuggestions.add("Carte");
            nameSuggestions.add("Transports");
            nameSuggestions.add("Hopitaux");
            nameSuggestions.add("Monuments");
            nameSuggestions.add("Gastronomies");
        }else if(typeSuggestion.equals("Page Principale")){
            nameSuggestions.add("Villes Populaires");
            nameSuggestions.add("Tendances");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getContext();
        listeView = (ListView) getView().findViewById(R.id.listSuggestionsVille);
        fragmentManager=  getFragmentManager();

        textView = (TextView) getView().findViewById(R.id.add_more_suggestions);
        if(typeSuggestion.equals("Page Principale")){
            textView.setVisibility(View.INVISIBLE);
        }
        final ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,nameSuggestions);
        listeView.setAdapter(arrayAdapter);
        textView.setText("add more Suggestions");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.INVISIBLE);
                if(typeSuggestion.equals("ville")) {
                    nameSuggestions.add("Artisanat");
                    nameSuggestions.add("Restaurants");
                    nameSuggestions.add("Logements");
                    nameSuggestions.add("Banques");
                    nameSuggestions.add("Centre de Changes");
                    nameSuggestions.add("Pharmacies");


                }
                arrayAdapter.notifyDataSetChanged();
            }
        });

        listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //   LinearLayout linearLayou=(LinearLayout) view;
                TextView textVi=(TextView) view;
                Toast.makeText(getContext(), String.valueOf(position)+""+textVi.getText()+" "+nomVille, Toast.LENGTH_LONG).show();

                    if(textVi.getText().equals("Villes Populaires")) {
                        Intent intent = new Intent(getContext(), ContainerActivity.class);
                        intent.putExtra("choix", "villes_populaires");
                        startActivity(intent);
                    }
                    if(textVi.getText().equals("Tendances")) {
                        Intent intent = new Intent(getContext(), ContainerActivity.class);
                        intent.putExtra("choix", "tendances");
                        startActivity(intent);
                    }
                    if(textVi.getText().equals("Monuments")){
                        Intent intent = new Intent(getContext(), ContainerActivity.class);
                        intent.putExtra("choix", "Monuments");
                        //intent.putExtra("nomVille",nomVille);
                        startActivity(intent);
                    }
                    if(textVi.getText().equals("Carte")){
                        Intent intent=new Intent(getContext(),MapActivity.class);
                        intent.putExtra("choix","Carte");
                        startActivity(intent);
                    }
                if(textVi.getText().equals("Artisanat")){
                    Intent intent = new Intent(getContext(), ContainerActivity.class);
                    intent.putExtra("choix", "Artisanat");
                    //intent.putExtra("nomVille",nomVille);
                    startActivity(intent);
                }
                if(textVi.getText().equals("Banques")){
                    Intent intent = new Intent(getContext(), MapActivity.class);
                    intent.putExtra("choix", "Banques");
                    //intent.putExtra("nomVille",nomVille);
                    startActivity(intent);
                }
                if(textVi.getText().equals("Centre de Changes")){
                    Intent intent = new Intent(getContext(), MapActivity.class);
                    intent.putExtra("choix", "Centre de Changes");
                    //intent.putExtra("nomVille",nomVille);
                    startActivity(intent);
                }
                if(textVi.getText().equals("Gastronomies")){
                    Intent intent = new Intent(getContext(), ContainerActivity.class);
                    intent.putExtra("choix", "Gastronomies");
                    //intent.putExtra("nomVille",nomVille);
                    startActivity(intent);
                }
                if(textVi.getText().equals("Hopitaux")){
                    Intent intent = new Intent(getContext(), MapActivity.class);
                    intent.putExtra("choix", "Hopitaux");
                    //intent.putExtra("nomVille",nomVille);
                    startActivity(intent);
                }

                if(textVi.getText().equals("Restaurants")){
                    Intent intent = new Intent(getContext(), MapActivity.class);
                    intent.putExtra("choix", "Restaurants");
                    //intent.putExtra("nomVille",nomVille);
                    startActivity(intent);
                }
                if(textVi.getText().equals("Transports")){
                    Intent intent = new Intent(getContext(), ContainerActivity.class);
                    intent.putExtra("choix", "Transports");

                    startActivity(intent);
                }
                if(textVi.getText().equals("Logements")){
                    Intent intent = new Intent(getContext(), ContainerActivity.class);
                    intent.putExtra("choix", "Logements");
                    //intent.putExtra("nomVille",nomVille);
                    startActivity(intent);
                }
                if(textVi.getText().equals("Pharmacies")){
                    Intent intent = new Intent(getContext(), MapActivity.class);
                    intent.putExtra("choix", "Pharmacies");
                    //intent.putExtra("nomVille",nomVille);
                    startActivity(intent);
                }



                }


        });
    }
}

package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.VilleAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListeVillesFragment extends Fragment {

     ListView listeViewRechercheVille;
     VilleAdapter adapter2;
     Context con;
     String[] tableNomVille ;
     String[] tabVille;
     View viewGlobal;
     ArrayAdapter<String> adapter;
     private OnFragmentInteractionListenerListeVilles mListener;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_liste_villes, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listeViewRechercheVille = (ListView) getView().findViewById(R.id.list_view_recherche_ville);
        listeViewRechercheVille.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onItemClick(parent,view,position,id);
            }
        });
    }





    public void remplirListe(String s,String [] tableNomVill){
        //  onActivityCreated(null);
        if(!s.equals("")) {
            tableNomVille = tableNomVill;
            ArrayList<String> affiche = chercherVille(s);
            tabVille = affiche.toArray(new String[affiche.size()]);
            adapter2 = new VilleAdapter(con,R.layout.layout_ville_adapter,tabVille);
            listeViewRechercheVille.setAdapter(adapter2);

        }else {
            listeViewRechercheVille.setAdapter(null);
        }
    }
    public ArrayList<String> chercherVille(String s){
        ArrayList<String> listVales=new ArrayList<String>();
        for (String v: tableNomVille
                ) {
            if( v.startsWith(s) ){
                listVales.add(v);
            }
        }
        return listVales;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListenerListeVilles) {
            mListener = (OnFragmentInteractionListenerListeVilles) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void initContext(Context context) {
        con = context;
    }



    public interface OnFragmentInteractionListenerListeVilles extends AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id);
    }




}

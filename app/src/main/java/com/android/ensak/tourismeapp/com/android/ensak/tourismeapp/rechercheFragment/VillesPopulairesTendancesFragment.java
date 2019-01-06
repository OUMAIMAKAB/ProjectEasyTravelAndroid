package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.AppUtility;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.VillesPopulairesTendances;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.villesPopulairesTendancesAdapter;

import java.util.ArrayList;

public class VillesPopulairesTendancesFragment extends Fragment {
    ListView listeView;
    ArrayList<VillesPopulairesTendances> villesPopulairesTendances;
    ArrayList<VillesPopulairesTendances> patrimoineUnesco;
    Context context;
    private FragmentVillesPopulairesTendancesInterface mListener;
    String choix;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_liste_villes_populaires_tendances,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listeView= (ListView) getView().findViewById(R.id.liste_view_villes_populaires_tendances);
        listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onItemClick(parent,view,position,id);
            }
        });
        villesPopulairesTendances=new ArrayList<VillesPopulairesTendances>();
        patrimoineUnesco=new ArrayList<VillesPopulairesTendances>();

        if(choix.equals("villes_populaires")){
            villesPopulairesTendancesAdapter adapter = new villesPopulairesTendancesAdapter(getContext(), R.layout.layout_villes_populaires_tendances_adapter, AppUtility.getAppUtility(context).getListeVillesPopulaires());
            listeView.setAdapter(adapter);
        }
        if(choix.equals("tendances")){
            villesPopulairesTendancesAdapter adapter = new villesPopulairesTendancesAdapter(getContext(), R.layout.layout_villes_populaires_tendances_adapter, AppUtility.getAppUtility(context).getListeVillesPatrimoineUnesco());
            listeView.setAdapter(adapter);
        }
    }

    public void changerAdapterList(villesPopulairesTendancesAdapter adapter){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentVillesPopulairesTendancesInterface) {
            mListener = (FragmentVillesPopulairesTendancesInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }


    public void initContext(Context context) {
        this.context=context;
    }

    public void choixSuggestion(String choix) {
        this.choix=choix;

    }

    public interface FragmentVillesPopulairesTendancesInterface extends  AdapterView.OnItemClickListener{

    }
}

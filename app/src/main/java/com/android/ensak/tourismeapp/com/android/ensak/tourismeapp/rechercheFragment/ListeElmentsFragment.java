package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListElementsAdapter;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListMonumentsAdapter;

public class ListeElmentsFragment extends Fragment {

    ListView elementsListView;
    ArrayAdapter listElementsAdapter;

    public ListeElmentsFragment() {
        super();
    }

    @SuppressLint("ValidFragment")
    public ListeElmentsFragment(ArrayAdapter listElementsAdapter) {
        this.listElementsAdapter=listElementsAdapter;
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(getResources().getLayout(R.layout.fragment_liste_elements),container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        elementsListView=(ListView) getView().findViewById(R.id.liste_view_elements);
        elementsListView.setAdapter(listElementsAdapter);

    }
/*
    public void changeContentListView(ListElementsAdapter listElementsAdapter){
        elementsListView.setAdapter(listElementsAdapter);
    }
*/

}

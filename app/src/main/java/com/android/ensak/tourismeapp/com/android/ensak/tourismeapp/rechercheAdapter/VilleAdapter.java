package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;

public class VilleAdapter extends ArrayAdapter<String> {

  String [] tabVille;

    public VilleAdapter( Context context, int resource,String[] tabVille) {
        super(context, resource,tabVille);
        this.tabVille = tabVille;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView =inflater.inflate(R.layout.layout_ville_adapter,parent,false);
        TextView editText = (TextView) convertView.findViewById(R.id.barreRecherche2);
        editText.setText(tabVille[position]);
        return convertView;
    }
}

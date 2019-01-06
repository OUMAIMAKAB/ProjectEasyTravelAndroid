package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.VillesPopulairesTendances;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.VilleActivity;

import java.util.ArrayList;



public class villesPopulairesTendancesAdapter extends ArrayAdapter<VillesPopulairesTendances> {
    ArrayList<VillesPopulairesTendances> listesVillesPopulairesTendances;
    Context context;
    public villesPopulairesTendancesAdapter(Context context, int resource,ArrayList<VillesPopulairesTendances> objects) {
        super(context, resource, objects);
        listesVillesPopulairesTendances = objects;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView =inflater.inflate(R.layout.layout_villes_populaires_tendances_adapter,parent,false);
        final TextView textViewVillesPopulairesTendances = (TextView) convertView.findViewById(R.id.textViewVillesPopulairesTendances);
        ImageView imageViewVillesPopulairesTendaces =(ImageView) convertView.findViewById(R.id.imageButtonGo);
        textViewVillesPopulairesTendances.setText(listesVillesPopulairesTendances.get(position).getNameVille());
        Drawable drawable = context.getResources().getDrawable(listesVillesPopulairesTendances.get(position).getImageVille());
        imageViewVillesPopulairesTendaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String chaineVille= (String) textViewVillesPopulairesTendances.getText();
                Intent intent = new Intent(context,VilleActivity.class);
                intent.putExtra("nomVille",chaineVille);
                context.startActivity(intent);

            }
        });
        convertView.setBackground(drawable);

        return convertView;
    }
}

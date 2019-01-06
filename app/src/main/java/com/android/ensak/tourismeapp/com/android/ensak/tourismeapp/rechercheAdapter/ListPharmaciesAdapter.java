package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Artisanat;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Pharmacie;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.ArtisanatActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.PharmacieActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class ListPharmaciesAdapter extends ArrayAdapter<Pharmacie> {
    ArrayList<Pharmacie> pharmacies;
    Context context;
    public ListPharmaciesAdapter( Context context, int resource, ArrayList<Pharmacie> pharmacies) {
        super(context, resource, pharmacies);
        this.pharmacies=pharmacies;
        this.context=context;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(getContext().getResources().getLayout(R.layout.layout_list_pharmacies_adapter),parent,false);

        TextView textView=(TextView) convertView.findViewById(R.id.name_pharmacie);

        textView.setText(pharmacies.get(position).getName());
        final View finalConvertView = convertView;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),PharmacieActivity.class);
                intent.putExtra("pharmacie", pharmacies.get(position));
                getContext().startActivity(intent);
            }
        });
        return convertView;
    }
}

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
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Logement;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.ArtisanatActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.LogementActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import android.content.Context;
import java.util.ArrayList;

public class ListLogementsAdapter extends ArrayAdapter<Logement> {
    ArrayList<Logement> logements;
    Context context;
    public ListLogementsAdapter( Context context, int resource, ArrayList<Logement> logements) {
        super(context, resource, logements);
        this.logements=logements;
        this.context=context;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(getContext().getResources().getLayout(R.layout.layout_list_logements_adapter),parent,false);

        TextView textView=(TextView) convertView.findViewById(R.id.name_logement);

        textView.setText(logements.get(position).getName());
        final View finalConvertView = convertView;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),LogementActivity.class);
                intent.putExtra("logement", logements.get(position));
                getContext().startActivity(intent);
            }
        });
        return convertView;
    }
}

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
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Gastronomie;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.ArtisanatActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.GastronomieActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class ListGastronomiesAdapter extends ArrayAdapter<Gastronomie> {
    ArrayList<Gastronomie> gastronomies;
    Context context;
    public ListGastronomiesAdapter( Context context, int resource, ArrayList<Gastronomie> gastronomies) {
        super(context, resource, gastronomies);
        this.gastronomies=gastronomies;
        this.context=context;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(getContext().getResources().getLayout(R.layout.layout_list_gastronomies_adapter),parent,false);
        ImageView imageView=(ImageView) convertView.findViewById(R.id.image_view_gastronomie);
        TextView textView=(TextView) convertView.findViewById(R.id.name_gastronomie);
        ImageLoader.getInstance().init(MainActivity.config); // Do it on Application start
        // Then later, when you want to display image
       ImageLoader.getInstance().displayImage(GlobalClass.urlServerImages+gastronomies.get(position).getImage(),  imageView);
        textView.setText(gastronomies.get(position).getNom());
        final View finalConvertView = convertView;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),GastronomieActivity.class);
                intent.putExtra("gastronomie", gastronomies.get(position));
                intent.putExtra("chaine","oumaima");
                getContext().startActivity(intent);
            }
        });
        return convertView;
    }
}

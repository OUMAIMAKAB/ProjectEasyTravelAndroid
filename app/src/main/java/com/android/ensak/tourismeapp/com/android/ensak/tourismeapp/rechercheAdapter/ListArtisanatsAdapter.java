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
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Artisanat;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.ArtisanatActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.ElementActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.Element;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class ListArtisanatsAdapter extends ArrayAdapter<Artisanat> {
    ArrayList<Artisanat> artisanats;
    Context context;
    public ListArtisanatsAdapter( Context context, int resource, ArrayList<Artisanat> artisanats) {
        super(context, resource, artisanats);
        this.artisanats=artisanats;
        this.context=context;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(getContext().getResources().getLayout(R.layout.layout_list_artisanats_adapter),parent,false);
        ImageView imageView=(ImageView) convertView.findViewById(R.id.image_view_artisanat);
        TextView textView=(TextView) convertView.findViewById(R.id.name_artisanat);
        ImageLoader.getInstance().init(MainActivity.config); // Do it on Application start
        // Then later, when you want to display image
        ImageLoader.getInstance().displayImage(GlobalClass.urlServerImages+artisanats.get(position).getImage(),imageView);
        textView.setText(artisanats.get(position).getNom());
        final View finalConvertView = convertView;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),ArtisanatActivity.class);
                intent.putExtra("artisanat", artisanats.get(position));
                getContext().startActivity(intent);
            }
        });
        return convertView;
    }
}

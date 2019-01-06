package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.ElementActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.MonumentActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.Element;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class ListMonumentsAdapter extends ArrayAdapter<Monument> {
    ArrayList<Monument> monuments;
    Context context;
    public ListMonumentsAdapter( Context context, int resource, ArrayList<Monument> monuments) {
        super(context, resource, monuments);
        this.monuments=monuments;
        this.context=context;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(getContext().getResources().getLayout(R.layout.layout_list_monuments_adapter),parent,false);
        ImageView imageView=(ImageView) convertView.findViewById(R.id.image_view_monument);
        TextView textView=(TextView) convertView.findViewById(R.id.name_monument);
        RatingBar ratingBar=(RatingBar) convertView.findViewById(R.id.ratingBarMonument);
        ratingBar.setRating((float) monuments.get(position).getRate());
        //Drawable drawable=context.getResources().getDrawable(elements.get(position).getImageElement());
        ImageLoader.getInstance().displayImage(GlobalClass.urlServerImages+monuments.get(position).getImage(),  imageView);
        //imageView.setImageDrawable(drawable);
        textView.setText(monuments.get(position).getName());


        final View finalConvertView = convertView;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MonumentActivity.class);
                intent.putExtra("monument", GlobalClass.listVilleMonuments.get(position));
                getContext().startActivity(intent);
            }
        });




        return convertView;
    }
}

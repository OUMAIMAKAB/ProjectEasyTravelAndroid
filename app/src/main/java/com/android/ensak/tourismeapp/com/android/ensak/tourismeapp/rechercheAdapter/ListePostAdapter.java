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
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Hopital;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Post;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.ElementActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.Element;

import java.util.ArrayList;
import java.util.List;

public class ListePostAdapter  extends ArrayAdapter<Post> {
    ArrayList<Post> elements=new ArrayList<Post>();
    Context context;

    public ListePostAdapter(Context context, int resource, ArrayList<Post> elements) {
        super(context, resource, elements);
        this.elements = elements;
        this.context = context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(getContext().getResources().getLayout(R.layout.layout_listpost_adapter),parent,false);

        TextView textView=(TextView) convertView.findViewById(R.id.textviewposter);

        textView.setText(elements.get(position).getTexte());


        return convertView;
    }
}
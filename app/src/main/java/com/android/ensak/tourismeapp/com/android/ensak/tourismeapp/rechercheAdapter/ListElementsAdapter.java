package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.ElementActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.Element;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class ListElementsAdapter extends ArrayAdapter<Element> {
    ArrayList<Element> elements;
    Context context;
    public ListElementsAdapter( Context context, int resource, ArrayList<Element> elements) {
        super(context, resource, elements);
        this.elements=elements;
        this.context=context;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       convertView=inflater.inflate(getContext().getResources().getLayout(R.layout.layout_list_elements_adapter),parent,false);
        ImageView imageView=(ImageView) convertView.findViewById(R.id.image_view_element);
        TextView textView=(TextView) convertView.findViewById(R.id.name_element);
        Drawable drawable=context.getResources().getDrawable(elements.get(position).getImageElement());
        imageView.setImageDrawable(drawable);
        textView.setText(elements.get(position).getNameElement());
        final View finalConvertView = convertView;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getContext(),ElementActivity.class);
               intent.putExtra("element", elements.get(position));
               getContext().startActivity(intent);
            }
        });
       return convertView;
    }
}

package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.Element;

public class ElementActivity extends AppCompatActivity {
ImageView imageView;
TextView titleElement;
TextView descriptionElement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
        Element element= (Element) bundle.getSerializable("monument");
        imageView=findViewById(R.id.activity_element_image_view);
        titleElement=findViewById(R.id.activity_element_name);
        descriptionElement=findViewById(R.id.activity_element_description);
        Drawable drawable=getResources().getDrawable(element.getImageElement());
        imageView.setImageDrawable(drawable);
        titleElement.setText(element.getNameElement());
        descriptionElement.setText(element.getDescriptionElement());

    }
}

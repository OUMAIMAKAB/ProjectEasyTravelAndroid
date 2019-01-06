package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MonumentActivity extends AppCompatActivity {
    ImageView imageView;
    TextView titleMonument;
    TextView descriptionMonument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monument);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
        Monument monument= (Monument) bundle.getSerializable("monument");

        titleMonument=findViewById(R.id.activity_monument_name);
        titleMonument.setText(monument.getName());

        imageView = findViewById(R.id.imageMonument);
        ImageLoader.getInstance().init(MainActivity.config); // Do it on Application start
        // Then later, when you want to display image
        ImageLoader.getInstance().displayImage(GlobalClass.urlServerImages+monument.getImage(), imageView);

        descriptionMonument = findViewById(R.id.DescriptionMonument);
        descriptionMonument.setText(monument.getDescription());

    }
}

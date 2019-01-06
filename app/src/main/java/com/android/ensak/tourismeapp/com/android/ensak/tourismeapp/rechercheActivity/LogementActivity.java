package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Logement;
import com.nostra13.universalimageloader.core.ImageLoader;

public class LogementActivity extends AppCompatActivity {
    TextView titleElement;
    TextView description;
    ImageView image;
    TextView tel;
    TextView type;
    Button appelerLogement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logement);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
        final Logement logement= (Logement) bundle.getSerializable("logement");

        image = findViewById(R.id.imageLogement);
        ImageLoader.getInstance().init(MainActivity.config); // Do it on Application start
        // Then later, when you want to display image
        ImageLoader.getInstance().displayImage(GlobalClass.urlServerImages+logement.getImage(), image);

        description = findViewById(R.id.DescriptionLogement);
        description.setText(logement.getDescription());

        titleElement=findViewById(R.id.activity_Logement_name);
        titleElement.setText(logement.getName());

        tel = findViewById(R.id.TelLogement);
        tel.setText(logement.getTel());

        type = findViewById(R.id.TypeLogement);
        type.setText(logement.getType());

        appelerLogement = findViewById(R.id.buttonAppelerLogement);
        appelerLogement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri telnumber = Uri.parse("tel:"+logement.getTel().toString());
                Intent call = new Intent(Intent.ACTION_DIAL, telnumber);
                startActivity(call);
            }
        });
    }

}

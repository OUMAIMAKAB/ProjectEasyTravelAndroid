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
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Logement;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Pharmacie;

public class PharmacieActivity extends AppCompatActivity {
    TextView titleElement;
    TextView tel;
    Button appelerPharmacie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacie);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
        //Pharmacie pharmacie= (Pharmacie) bundle.getSerializable("pharmacie");
        String nomPharmacie=bundle.getString("nomPharmacie");
        final Pharmacie pharmacie=getPharmacie(nomPharmacie);

        titleElement = findViewById(R.id.activity_pharmacie_name);
        titleElement.setText(pharmacie.getName());

        tel = findViewById(R.id.TelPharmacie);
        tel.setText(pharmacie.getTel());

        appelerPharmacie = findViewById(R.id.buttonAppelerPharmacie);
        appelerPharmacie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri telnumber = Uri.parse("tel:"+pharmacie.getTel().toString());
                Intent call = new Intent(Intent.ACTION_DIAL, telnumber);
                startActivity(call);
            }
        });
    }
    private Pharmacie getPharmacie(String nomPharmacie) {
        Pharmacie pharmacie=new Pharmacie();
        for (Pharmacie pharmacie2 : GlobalClass.listVillePharmacies
                ) {
            if(pharmacie2.getName().equals(nomPharmacie)){
                pharmacie=pharmacie2;
                break;
            }
        }
        return pharmacie;
    }


}


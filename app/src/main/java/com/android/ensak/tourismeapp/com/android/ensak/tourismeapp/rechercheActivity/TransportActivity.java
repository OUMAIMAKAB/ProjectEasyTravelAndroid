package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.ListStations;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Logement;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Station;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Transport;

import java.io.Serializable;
import java.util.List;

public class TransportActivity extends AppCompatActivity {
    TextView titleElement;
    Transport transport;
    TextView prix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
        transport= (Transport) bundle.getSerializable("transport");

        titleElement=findViewById(R.id.activity_transport_name);
        titleElement.setText(transport.getType());

        prix = findViewById(R.id.DescriptionPrix);
        prix.setText(transport.getPrix());


    }


    public void voirTrajet(View view){

        Intent intent=new Intent(this,MapActivity.class);
        intent.putExtra("choix","transport");
        ListStations listStations = new ListStations();
        listStations.setStations(transport.getStations());
        intent.putExtra("listeStations", listStations);
        startActivity(intent);
    }
}

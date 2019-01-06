package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Artisanat;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Hopital;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Restaurant;
import com.nostra13.universalimageloader.core.ImageLoader;

public class HopitalActivity extends AppCompatActivity {

    TextView titleElement;
    TextView tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hopital);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
       // Hopital hopital= (Hopital) bundle.getSerializable("hopital");
        String nomHopital=bundle.getString("nomHopital");
        Hopital hopital=getHopital(nomHopital);

        titleElement=findViewById(R.id.activity_hopital_name);
        titleElement.setText(hopital.getName());

        tel = findViewById(R.id.TelHopital);
        tel.setText(hopital.getTel());
    }

    public void appeler(View view){

        tel = findViewById(R.id.TelHopital);
        Uri telnumber = Uri.parse(tel.toString());
        Intent call = new Intent(Intent.ACTION_DIAL, telnumber);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        startActivity(call);
    }

    private Hopital getHopital(String nomHopital) {
        Hopital hopital=new Hopital();
        for (Hopital hopital2 : GlobalClass.listVilleHopitals
                ) {
            if(hopital2.getName().equals(nomHopital)){
                hopital=hopital2;
                break;
            }
        }
        return hopital;
    }
}

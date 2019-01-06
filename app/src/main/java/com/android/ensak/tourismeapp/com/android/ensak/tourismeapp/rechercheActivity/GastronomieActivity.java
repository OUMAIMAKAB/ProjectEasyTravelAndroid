package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Sessions.CodezSession;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Gastronomie;
import com.nostra13.universalimageloader.core.ImageLoader;

public class GastronomieActivity extends AppCompatActivity {
    Gastronomie gastronomie;
    ImageView imageView;
    TextView titleElement;
    TextView descriptionElement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomie);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
     //   String chaine=bundle.getString("chaine");
     //   Toast.makeText(this,"chaine"+chaine,Toast.LENGTH_LONG).show();

         gastronomie= (Gastronomie) bundle.getSerializable("gastronomie");

        titleElement = findViewById(R.id.activity_gastronomie_name);
        titleElement.setText(gastronomie.getNom());

        imageView = findViewById(R.id.imageGastronomie);
        ImageLoader.getInstance().init(MainActivity.config); // Do it on Application start
        // Then later, when you want to display image
        ImageLoader.getInstance().displayImage(GlobalClass.urlServerImages+gastronomie.getImage(),imageView);

        descriptionElement = findViewById(R.id.DescriptionGastronomie);
        descriptionElement.setText(gastronomie.getDescription());

    }

    public void popup(View view){
        CodezSession session;
        session = new CodezSession(getApplicationContext());
        if (session.isUserLogedIn()){
            Intent intent =new Intent(GastronomieActivity.this, pop.class);
            intent.putExtra("gastronomie",gastronomie);
            intent.putExtra("idGastronomie", gastronomie.getId());
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),"Veuillez se connecter !!",Toast.LENGTH_LONG).show();
        }


    }
}

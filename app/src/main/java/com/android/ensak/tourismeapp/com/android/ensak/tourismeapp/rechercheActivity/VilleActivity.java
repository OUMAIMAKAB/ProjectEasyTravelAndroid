package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestVilleArtisanats;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestVilleBanques;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestVilleCentreDeChanges;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestVilleGastronomies;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestVilleHopitaux;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestVilleLogements;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestVilleMonuments;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestVillePharmacies;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestVilleRestaurants;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestVilleTransports;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.BareRechercheFragment;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public class VilleActivity extends AppCompatActivity implements BareRechercheFragment.OnFragmentInteractionListener{

    BareRechercheFragment fragment;
    Drawable drawable;
    TextView textView;
    int positionList;
    String nomVille;
    int idVille;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ville);
        fragment= (BareRechercheFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);

        fragment.setMode("ville");

        textView = (TextView) findViewById(R.id.text_view_page_ville_images);
        Intent intent =getIntent();
        Bundle bundle;
        bundle = intent.getExtras();
        positionList= bundle.getInt("positionList");
        GlobalClass.idPositionVilleCourante=positionList;
        nomVille=GlobalClass.listVilles.get(positionList).getName();
        idVille=GlobalClass.listVilles.get(positionList).getId();
       textView.setText(nomVille);
        RelativeLayout relativeLayout=findViewById(R.id.container_image_view_ville);
        ImageView imageView=findViewById(R.id.imageViewVille);
        // Create default options which will be used for every
        //  displayImage(...) call if no options will be passed to this method

        ImageLoader.getInstance().init(MainActivity.config); // Do it on Application start
        // Then later, when you want to display image
       ImageLoader.getInstance().displayImage(GlobalClass.urlServerImages+GlobalClass.listVilles.get(positionList).getImage(),  imageView); // Default options will be used
       //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ControllerRestVilleArtisanats controllerRestVilleArtisanats=ControllerRestVilleArtisanats.getInstanceControllerRestClass();
        controllerRestVilleArtisanats.listVilleArtisanatsAsync(idVille);
        ControllerRestVilleBanques controllerRestVilleBanques=ControllerRestVilleBanques.getInstanceControllerRestClass();
        controllerRestVilleBanques.listVilleBanquesAsync(idVille);
        ControllerRestVilleCentreDeChanges controllerRestVilleCentreDeChanges=ControllerRestVilleCentreDeChanges.getInstanceControllerRestClass();
        controllerRestVilleCentreDeChanges.listVilleCentreDeChangesAsync(idVille);
        ControllerRestVilleGastronomies controllerRestVilleGastronomies=ControllerRestVilleGastronomies.getInstanceControllerRestClass();
        controllerRestVilleGastronomies.listVilleGastronomiesAsync(idVille);
        ControllerRestVilleHopitaux controllerRestVilleHopitaux=ControllerRestVilleHopitaux.getInstanceControllerRestClass();
        controllerRestVilleHopitaux.listVilleHopitauxAsync(idVille);
        ControllerRestVilleLogements controllerRestVilleLogements=ControllerRestVilleLogements.getInstanceControllerRestClass();
        controllerRestVilleLogements.listVilleLogementsAsync(idVille);
        ControllerRestVilleMonuments controllerRestVilleMonuments=ControllerRestVilleMonuments.getInstanceControllerRestClass();
        controllerRestVilleMonuments.listVilleMonumentsAsync(idVille);
        ControllerRestVillePharmacies controllerRestVillePharmacies=ControllerRestVillePharmacies.getInstanceControllerRestClass();
        controllerRestVillePharmacies.listVillePharmaciesAsync(idVille);
        ControllerRestVilleRestaurants controllerRestVilleRestaurants=ControllerRestVilleRestaurants.getInstanceControllerRestClass();
        controllerRestVilleRestaurants.listVilleRestaurantsAsync(idVille);
        ControllerRestVilleTransports controllerRestVilleTransports=ControllerRestVilleTransports.getInstanceControllerRestClass();
        controllerRestVilleTransports.listVilleTransportsAsync(idVille);


       //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    @Override
    public void onClick(String mode) {

        Toast.makeText(this,mode,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,PageRechercheActivity.class);
        intent.putExtra("typePageRecherche",mode);
        //intent.putExtra("nomVille",nomVille.toLowerCase());
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fragment.setTextBarreRecherche(" Que recherches-tu sur "+ nomVille+" ?");
    }
}

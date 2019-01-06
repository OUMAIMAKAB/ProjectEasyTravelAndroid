package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Ville;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.test.GithubService;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.test.MainTestActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


import java.util.List;

import retrofit.Callback;
import retrofit.ErrorHandler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class Main2TestActivity  extends AppCompatActivity {

    TextView testView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayout);
        testView=findViewById(R.id.testViewTest);
        imageView=findViewById(R.id.imageView);




    }


    public void go(View view) {
        //ControllerRestClass controllerRestClass=ControllerRestClass.getInstanceControllerRestClass();
     //   ControllerRestVillesClass controllerRestVillesClass=ControllerRestVillesClass.getInstanceControllerRestClass();
      //    ControllerRestVilleArtisanats controllerRestVilleArtisanats=ControllerRestVilleArtisanats.getInstanceControllerRestClass();
        //  controllerRestVilleArtisanats.listVilleArtisanatsAsync(1);
      //  ControllerRestVilleBanques controllerRestVilleBanques=ControllerRestVilleBanques.getInstanceControllerRestClass();
        //controllerRestVilleBanques.listVilleBanquesAsync(1);
     //   ControllerRestVilleCentreDeChanges controllerRestVilleCentreDeChanges=ControllerRestVilleCentreDeChanges.getInstanceControllerRestClass();
     //   controllerRestVilleCentreDeChanges.listVilleCentreDeChangesAsync(1);
       // ControllerRestVilleGastronomies controllerRestVilleGastronomies=ControllerRestVilleGastronomies.getInstanceControllerRestClass();
        //controllerRestVilleGastronomies.listVilleGastronomiesAsync(1);
     //   ControllerRestVilleHopitaux controllerRestVilleHopitaux=ControllerRestVilleHopitaux.getInstanceControllerRestClass();
       // controllerRestVilleHopitaux.listVilleHopitauxAsync(1);
        //ControllerRestVilleLogements controllerRestVilleLogements=ControllerRestVilleLogements.getInstanceControllerRestClass();
        //controllerRestVilleLogements.listVilleLogementsAsync(1);
       // ControllerRestVilleMonuments controllerRestVilleMonuments=ControllerRestVilleMonuments.getInstanceControllerRestClass();
        //controllerRestVilleMonuments.listVilleMonumentsAsync(1);
      //   ControllerRestVillePharmacies controllerRestVillePharmacies=ControllerRestVillePharmacies.getInstanceControllerRestClass();
        // controllerRestVillePharmacies.listVillePharmaciesAsync(1);
        //ControllerRestVilleRestaurants controllerRestVilleRestaurants=ControllerRestVilleRestaurants.getInstanceControllerRestClass();
        //controllerRestVilleRestaurants.listVilleRestaurantsAsync(1);
      //  ControllerRestVilleTransports controllerRestVilleTransports=ControllerRestVilleTransports.getInstanceControllerRestClass();
        //controllerRestVilleTransports.listVilleTransportsAsync(1);
        //controllerRestVillesClass.listVillesAsync();
    ControllerRestUtilisateurs controllerRestUtilisateurs=ControllerRestUtilisateurs.getInstanceControllerRestClass();
  //  controllerRestUtilisateurs.addUtilisateurAsync();
    // controllerRestUtilisateurs.updateUtilisateurAsync();
        controllerRestUtilisateurs.deleteUtilisateurAsync();




    }

    public void seach(View view){
       int taille=  GlobalClass.userUpdate.getId();
         testView.setText("taille: "+taille);
    }

}

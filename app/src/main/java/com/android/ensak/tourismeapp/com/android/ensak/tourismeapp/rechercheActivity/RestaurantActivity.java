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
import android.widget.Toast;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Restaurant;
import com.nostra13.universalimageloader.core.ImageLoader;

public class RestaurantActivity extends AppCompatActivity {
    TextView titleElement;
    TextView description;
    ImageView image;
    TextView tel;
    Button buttonAppeler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
       // Restaurant restaurant= (Restaurant) bundle.getSerializable("restaurant");
        String nomRestaurant=bundle.getString("nomRestaurant");
        final Restaurant restaurant=getRestaurant(nomRestaurant);

        image = findViewById(R.id.imageRestaurant);
        ImageLoader.getInstance().init(MainActivity.config); // Do it on Application start
        // Then later, when you want to display image
        ImageLoader.getInstance().displayImage(GlobalClass.urlServerImages+restaurant.getImage(),  image);

        description = findViewById(R.id.DescriptionRestaurant);
        description.setText(restaurant.getDescription());

        titleElement = findViewById(R.id.activity_restaurant_name);
        titleElement.setText(restaurant.getName());

        tel = findViewById(R.id.TelRestaurant);
        tel.setText(restaurant.getTel());

        buttonAppeler = findViewById(R.id.buttonAppelerRestaurant);
        buttonAppeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri telnumber = Uri.parse("tel:"+restaurant.getTel().toString());
                Intent call = new Intent(Intent.ACTION_DIAL, telnumber);
                startActivity(call);

            }

        });
    }

    public void appeler(View view){


        Uri telnumber = Uri.parse("tel:"+tel.toString());
        Intent call = new Intent(Intent.ACTION_DIAL, telnumber);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        startActivity(call);
    }

    private Restaurant getRestaurant(String nomRestaurant) {
        Restaurant restaurant=new Restaurant();
        for (Restaurant restaurant2 : GlobalClass.listVilleRestaurants
                ) {
            if(restaurant2.getName().equals(nomRestaurant)){
                restaurant=restaurant2;
                break;
            }
        }
        return restaurant;
    }
}

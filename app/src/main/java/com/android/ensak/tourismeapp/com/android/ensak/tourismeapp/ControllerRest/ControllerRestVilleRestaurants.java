package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Logement;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Restaurant;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestVilleRestaurants {
    TourismeAppService tourismeAppService;
    public static List<Restaurant> restaurants;
    private static ControllerRestVilleRestaurants controllerRestClass;
    private ControllerRestVilleRestaurants(){
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }
    public static ControllerRestVilleRestaurants getInstanceControllerRestClass(){
        if(controllerRestClass==null){
            controllerRestClass=new ControllerRestVilleRestaurants();
        }
        return controllerRestClass;
    }


    public void listVilleRestaurantsAsync(int idVille) {

        tourismeAppService.listVilleRestaurantsAsync(idVille,new Callback<List<Restaurant>>() {
            @Override
            public void success(List<Restaurant> restaurants, Response response) {
                listRestaurants(restaurants);

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void listRestaurants(List<Restaurant> restaurants) {
        GlobalClass.listVilleRestaurants=restaurants;
    }
}

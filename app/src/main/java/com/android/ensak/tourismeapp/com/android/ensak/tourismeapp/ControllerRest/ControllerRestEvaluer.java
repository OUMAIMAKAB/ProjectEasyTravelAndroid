package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import android.content.Context;
import android.widget.Toast;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Evaluer;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Utilisateur;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.pop;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestEvaluer {
    TourismeAppService tourismeAppService;
    public static List<Evaluer> evaluations;
    public Context context;
    private static ControllerRestEvaluer controllerRestClass;

    private ControllerRestEvaluer() {
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }

    public static ControllerRestEvaluer getInstanceControllerRestClass(){
        if(controllerRestClass==null){
            controllerRestClass=new ControllerRestEvaluer();
        }
        return controllerRestClass;
    }

    public void listEvaluerAsync(int idVille,int idRestaurant) {

        tourismeAppService.listEvaluerAsync(idVille,idRestaurant,new Callback<List<Evaluer>>() {
            @Override
            public void success(List<Evaluer> evaluers, Response response) {
                listEvaluers(evaluers);

            }
            @Override
            public void failure(RetrofitError error) {
            }
        });
    }

    public void addEvalluerAsync(int idVille,Evaluer evaluer){
        //Evaluer evaluer=new Evaluer();
        tourismeAppService.addEvaluerAsync(idVille,evaluer.getIdRestaurant(),evaluer,new Callback<Evaluer>() {
            @Override
            public void success(Evaluer evaluer, Response response) {
              afficherToast();
            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void afficherToast() {
        Toast.makeText(context,"OK",Toast.LENGTH_LONG).show();
    }


    void listEvaluers(List<Evaluer> evaluers){
        GlobalClass.listEvaluer=evaluers;
    }


    public void initContext(Context context) {
        this.context=context;
    }
}
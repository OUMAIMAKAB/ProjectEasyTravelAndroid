package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestEvaluer;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Sessions.CodezSession;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Evaluer;

public class pop extends GastronomieActivity {
    EditText editText;
    Button button;
    int idGastronomie;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        idGastronomie = bundle.getInt("idGastronomie");
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        editText=findViewById(R.id.editTextPopup);
        button=findViewById(R.id.buttonPopup);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));
    }

    public void popupButton(View view) {

        String commentaire= String.valueOf(editText.getText());
        Toast.makeText(this,"commentaire"+commentaire,Toast.LENGTH_LONG).show();
        ControllerRestEvaluer controllerRestEvaluer =ControllerRestEvaluer.getInstanceControllerRestClass();
        controllerRestEvaluer.initContext(this);
        Evaluer evaluer=new Evaluer(commentaire,idGastronomie,null, GlobalClass.idUtilisateurCourant);
        controllerRestEvaluer.addEvalluerAsync(GlobalClass.listVilles.get(GlobalClass.idPositionVilleCourante).getId(),evaluer);}

}

package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListElementsAdapter;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.ListeElmentsFragment;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.VillesPopulairesTendancesFragment;
import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.AppUtility;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.Element;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.ResultChoixFragmentSuggestion;

import java.util.ArrayList;
import java.util.List;

public class ContainerActivity extends AppCompatActivity implements VillesPopulairesTendancesFragment.FragmentVillesPopulairesTendancesInterface {
      Context context;
      String nomVille;
      String choix;
      ResultChoixFragmentSuggestion resultChoixFragmentSuggestion;
      AppUtility appUtility;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        Intent intent=getIntent();
        context=this;
        Bundle bundle =intent.getExtras();
        choix =bundle.getString("choix");
        //nomVille=bundle.getString("nomVille");
        appUtility=AppUtility.getAppUtility(context);
        resultChoixFragmentSuggestion=ResultChoixFragmentSuggestion.getResultChoixFragmentSuggestion(context);
        FragmentManager fragmentManager = getSupportFragmentManager();
        resultChoixFragmentSuggestion.setFragmentManager(fragmentManager);
        resultChoixFragmentSuggestion.setChoix(choix);
        //resultChoixFragmentSuggestion.setNomVille(nomVille);
        resultChoixFragmentSuggestion.getFragmentSuggestion();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }
}

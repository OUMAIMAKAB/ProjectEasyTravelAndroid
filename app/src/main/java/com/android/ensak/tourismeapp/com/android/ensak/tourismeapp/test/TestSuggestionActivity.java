package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;

public class TestSuggestionActivity extends AppCompatActivity {

     TextView textViewName;
     TextView textViewDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_suggestion);
        /*
        textViewName=findViewById(R.id.textViewActivityTestSuggestion);
        textViewDescription=findViewById(R.id.descriptionActivityTestSuggestion);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String chaine=bundle.getString("choix");

        textViewName.setText(chaine);
        String chaine2=bundle.getString("listeMonument");
        textViewDescription.setText(chaine2);
        */
    }
}

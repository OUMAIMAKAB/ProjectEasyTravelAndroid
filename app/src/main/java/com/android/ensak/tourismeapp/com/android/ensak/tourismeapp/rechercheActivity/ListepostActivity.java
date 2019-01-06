package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestPost;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Post;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListePostAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListepostActivity extends AppCompatActivity {
    ListView listeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listepost);
        listeView= (ListView) findViewById(R.id.listepost);
       // ControllerRestPost controllerRestPost = ControllerRestPost.getInstanceControllerRestClass();
        // controllerRestPost.listPostAsync(1);
       // ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,GlobalClass.listPost);
        //listeView.setAdapter(arrayAdapter);
        Toast.makeText(this,"number of object in tab poster"+((ArrayList<Post>) GlobalClass.listPost).size(),Toast.LENGTH_LONG).show();
        ArrayList<Post> listdd=new ArrayList<Post>();
      //  listdd.add(new Post("Hind"));
       ListePostAdapter listePostAdapter = new ListePostAdapter(this,R.layout.activity_liste_post_adapter, ((ArrayList<Post>) GlobalClass.listPost));
       listeView.setAdapter(listePostAdapter);
    }
}

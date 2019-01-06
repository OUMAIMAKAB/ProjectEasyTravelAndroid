package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestPost;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestVillesClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Sessions.CodezSession;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Artisanat;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Post;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Utilisateur;
import com.nostra13.universalimageloader.core.ImageLoader;

import static com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestPost.getInstanceControllerRestClass;
import static com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestPost.posts;

public class PostActivity extends AppCompatActivity {
    Button button3;
    EditText editText;
    ControllerRestPost controllerRestPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
       // int idUtilisateur = 1;
        //ControllerRestPost controllerRestPost = ControllerRestPost.getInstanceControllerRestClass();
        //controllerRestPost.listPostAsync(idUtilisateur);

        editText=findViewById(R.id.editText);
        button3=findViewById(R.id.button3);
        ImageLoader.getInstance().init(MainActivity.config); // Do it on Application start

         controllerRestPost = ControllerRestPost.getInstanceControllerRestClass();
        Post post = new Post("fhdjfhjd");
       // controllerRestPost.addPostAsync(post);
   //    controllerRestPost.deletePostAsync(1,7);
      //  controllerRestPost.listPostAsync(1);
      post.setTexte("hhhhhh");
        controllerRestPost.updatePostAsync(GlobalClass.idUtilisateurCourant,post);


    }

    public void poster(View view){
        ControllerRestPost controllerRestPost = ControllerRestPost.getInstanceControllerRestClass();
        controllerRestPost.setContext(this);
        //editText = findViewById(R.id.editText);
        String texte = editText.getText().toString();
       // int idUtilisateur = 1;
        Post post = new Post(texte);
        controllerRestPost.addPostAsync(post);
        controllerRestPost.listPostAsync(GlobalClass.idUtilisateurCourant);


        //constructeur ds la classe post
        //= post.getTexte();
       // Toast.makeText(this,"numbers"+GlobalClass.listPost.size(),Toast.LENGTH_LONG).show();

    }
    public void listerPoste(View view)
    {
        ControllerRestPost controllerRestPost = ControllerRestPost.getInstanceControllerRestClass();
        controllerRestPost.listPostAsync(GlobalClass.idUtilisateurCourant);
        Intent intent = new Intent(this,ListepostActivity.class);

        startActivity(intent);
    }



}

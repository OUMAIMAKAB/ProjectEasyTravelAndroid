package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import android.content.Context;
import android.widget.Toast;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Banque;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Post;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Utilisateur;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.PostActivity;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestPost {

    TourismeAppService tourismeAppService;
    public static List<Post> posts ;
    public Context context;
    private static ControllerRestPost controllerRestClass;
    private ControllerRestPost(){
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }

    public static ControllerRestPost getInstanceControllerRestClass(){
        if(controllerRestClass==null){
            controllerRestClass=new ControllerRestPost();
        }
        return controllerRestClass;
    }


    public void listPostAsync(int idUtilisateur) {

        tourismeAppService.listPostAsync(idUtilisateur,new Callback<List<Post>>() {
            @Override
            public void success(List<Post> posts, Response response) {
                listPosts(posts);
            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }




    public void addPostAsync(Post post){
       // Post post=new Post();
        int idUtilisateur = GlobalClass.idUtilisateurCourant;
        tourismeAppService.addPostAsync(idUtilisateur,post,new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {
                newPost();
            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void updatePostAsync(int utilisateur, Post post){
        //Post post=new Post();
        post.setTexte("dkdkjfkjsdkfjksdjfk");
        tourismeAppService.updatePostAsync(utilisateur,5,post,new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {
                updatePost(post);
            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void deletePostAsync(int utilisateur, int post ){


        tourismeAppService.deletePostAsync(utilisateur,post,new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


    private void listPosts(List<Post> posts) {
        GlobalClass.listPost=posts;
    }

    private void newPost() {
        Toast.makeText(context,"c'est posté!!",Toast.LENGTH_LONG).show();

    }
    public void setContext(Context context){
        this.context=context;
    }
    private void updatePost(Post post){
        GlobalClass.pstUpdate=post;
    }
}


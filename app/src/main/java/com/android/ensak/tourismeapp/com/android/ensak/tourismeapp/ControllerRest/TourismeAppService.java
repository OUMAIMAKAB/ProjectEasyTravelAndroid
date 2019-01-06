package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Artisanat;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Banque;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.CentreDeChange;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Evaluer;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Gastronomie;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Hopital;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Logement;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Pharmacie;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Post;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Restaurant;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Transport;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Utilisateur;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Ville;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

public interface TourismeAppService {

    public static final String ENDPOINT = "http://192.168.1.9:8085/tourismeApp";

    @GET("/villes/{idVille}/artisanats/")
    void listVilleArtisanatsAsync(@Path("idVille") int idVille,Callback<List<Artisanat>> callback);

    @GET("/villes/{idVille}/banques/")
    void listVilleBanquesAsync(@Path("idVille") int idVille,Callback<List<Banque>> callback);

    @GET("/villes/{idVille}/centreDeChanges/")
    void listVilleCentreDeChangesAsync(@Path("idVille") int idVille,Callback<List<CentreDeChange>> callback);

    @GET("/villes/{idVille}/gastronomies/")
    void listVilleGastronomiesAsync(@Path("idVille") int idVille,Callback<List<Gastronomie>> callback);

    @GET("/villes/{idVille}/hopitaux/")
    void listVilleHopitauxAsync(@Path("idVille") int idVille,Callback<List<Hopital>> callback);

    @GET("/villes/{idVille}/logements/")
    void listVilleLogementsAsync(@Path("idVille") int idVille,Callback<List<Logement>> callback);

    @GET("/villes/{idVille}/monuments/")
    void listVilleMonumentsAsync(@Path("idVille") int idVille,Callback<List<Monument>> callback);

    @GET("/villes/{idVille}/pharmacies/")
    void listVillePharmaciesAsync(@Path("idVille") int idVille,Callback<List<Pharmacie>> callback);

    @GET("/villes/{idVille}/restaurants/")
    void listVilleRestaurantsAsync(@Path("idVille") int idVille,Callback<List<Restaurant>> callback);

    @GET("/villes/{idVille}/transports/")
    void listVilleTransportsAsync(@Path("idVille") int idVille,Callback<List<Transport>> callback);

    @GET("/villes/")
    void listVilleAsync(Callback<List<Ville>> callback);

    @GET("/utilisateurs/")
    void listUtilisateursAsync(Callback<List<Utilisateur>> callback);

    @POST("/utilisateurs/")
    void addUtilisateurAsync(@Body Utilisateur utilisateur, Callback<Utilisateur> callback);

    @PUT("/utilisateurs/{idUser}")
    void updateUtilisateurAsync(@Path("idUser") int idUser,@Body Utilisateur utilisateur,Callback<Utilisateur> callback);

    @DELETE("/utilisateurs/{idUser}")
    void deleteUtilisateurAsync(@Path("idUser") int idUser,Callback<Utilisateur> callback);
	
	@GET("/utilisateurs/{idUtilisateur}/post/")
    void listPostAsync(@Path("idUtilisateur")int idUtilisateur, Callback<List<Post>> callback);

    @POST("/utilisateurs/{idUtilisateur}/post/")
    void addPostAsync(@Path("idUtilisateur") int idUtilisateur , @Body Post post, Callback<Post> callback);

    @POST("/utilisateurs/connection")
    void utilisateurConnectionAsync(@Body Utilisateur utilisateur, Callback<Utilisateur> callback);

    @PUT("/utilisateurs/{idUtilisateur}/post/{idPost}")
    void updatePostAsync(@Path("idUtilisateur") int idUtilisateur ,@Path("idPost") int idPost,@Body Post post,Callback<Post> callback);

    @DELETE("/utilisateurs/{idUtilisateur}/post/{idPost}")
    void deletePostAsync(@Path("idUtilisateur") int idUtilisateur ,@Path("idPost") int idPost,Callback<Post> callback);
	
	@GET("/villes/{idVille}/restaurants/{idRestaurant}/evaluer/")
    void listEvaluerAsync(@Path("idVille") int idVille, @Path("idRestaurant") int idRestaurant, Callback<List<Evaluer>> callback);

   @POST("/villes/{idVille}/restaurants/{idRestaurant}/evaluer/")
    void addEvaluerAsync(@Path("idVille") int idVille, @Path("idRestaurant") int idRestaurant,@Body Evaluer evaluer, Callback<Evaluer> callback);



    /*
    @GET("/users/{user}/repos/")
    void listReposAsync(@Path("user") String user, Callback<List<Repo>> callback);

    @GET("/search/repositories")
    List<Repo> searchRepos(@Query("q") String query);

 */
}

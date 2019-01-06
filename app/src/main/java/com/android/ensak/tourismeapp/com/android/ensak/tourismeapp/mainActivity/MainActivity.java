package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Activities.AideActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Activities.AproposActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Activities.ConditionUtilisationActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Activities.EndroitsActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Activities.LoginDrawerActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Activities.PostesActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Activities.ProfilActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Activities.RegisterDrawerActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Activities.SettingsActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestPost;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestVillesClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Sessions.CodezSession;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Ville;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.ListepostActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.MapActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.PageRechercheActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.PostActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.VilleActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.BareRechercheFragment;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BareRechercheFragment.OnFragmentInteractionListener {

    CodezSession session;
    BareRechercheFragment fragment;
    public static DisplayImageOptions defaultOptions;
    public static ImageLoaderConfiguration config;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragment = (BareRechercheFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        fragment.setMode("Page Principale");
        ControllerRestVillesClass controllerRestVillesClass=ControllerRestVillesClass.getInstanceControllerRestClass();
        controllerRestVillesClass.listVillesAsync();

        defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .build();

        session = new CodezSession(MainActivity.this);

        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.textViewUsername);
        TextView navMailUser = (TextView) headerView.findViewById(R.id.textViewUsermail);
        if (session.isUserLogedIn() == true) {
            navigationView.getMenu().findItem(R.id.nav_connecter).setTitle("Mon profil");
            navigationView.getMenu().findItem(R.id.nav_connecter).setIcon(R.drawable.ic_profile);

            navigationView.getMenu().findItem(R.id.nav_inscription).setTitle("Mes postes");
            navigationView.getMenu().findItem(R.id.nav_inscription).setIcon(R.drawable.ic_posts);

            navigationView.getMenu().findItem(R.id.nav_test).setTitle("Mes endroits visités");
            navigationView.getMenu().findItem(R.id.nav_test).setIcon(R.drawable.ic_endroits);

            navUsername.setText(session.getUserName());
            navMailUser.setText(session.getUserEmail());
        } else {
            navigationView.getMenu().removeItem(R.id.nav_test);
            navigationView.getMenu().removeItem(R.id.nav_logout);

            navUsername.setText("Bienvenue...");
            navMailUser.setText(" ");
        }



        ////////////////////////////
        BottomNavigationView bottomNav=findViewById(R.id.navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    session = new CodezSession(getApplicationContext());
                    switch (menuItem.getItemId()) {
                        case R.id.menu_search:
                            Intent intentMain = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intentMain);
                            Toast.makeText(getApplicationContext(), "click menu search", Toast.LENGTH_LONG).show();
                            break;
                        case R.id.menu_map:
                            Toast.makeText(getApplicationContext(), "click menu map", Toast.LENGTH_LONG).show();
                            Intent intentmap = new Intent(getApplicationContext(),MapActivity.class);
                            intentmap.putExtra("choix","mapMaroc");
                            startActivity(intentmap);
                            break;
                        case R.id.menu_post:
                            if (session.isUserLogedIn()){
                            Toast.makeText(getApplicationContext(), "click menu post", Toast.LENGTH_LONG).show();
                            Intent intent =new Intent(getApplicationContext(),PostActivity.class);
                            startActivity(intent);}
                            else{
                                Toast.makeText(getApplicationContext(), "Veuillez se connecter !!", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case R.id.menu_speak:
                            Toast.makeText(getApplicationContext(), "click menu speak", Toast.LENGTH_LONG).show();
                            break;

                    }
                    return true;
                }
            };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(String mode)
    {
        Intent intent = new Intent(this,PageRechercheActivity.class);
        intent.putExtra("typePageRecherche",mode);
        startActivity(intent);
    }

    public void button_ville_page_principal(View view) {
        String nameVille= (String) ((Button) view).getText();
        int positionList=getIdVille(nameVille.toLowerCase());
        Intent intent = new Intent(this,VilleActivity.class);
        // intent.putExtra("nomVille",nameVille);
        intent.putExtra("positionList",positionList);
        startActivity(intent);
    }

    private int getIdVille(String s) {
        int idVille = 0;
        for (Ville ville:GlobalClass.listVilles) {
            if(ville.getName().equals(s)){
                break;
            }
            idVille++;
        }
        return idVille;
    }

    public void page_poster(View view)
    {
        Intent intent = new Intent(this,PostActivity.class);
        startActivity(intent);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        session = new CodezSession(getApplicationContext());

        if (id == R.id.nav_connecter) {
            if (session.isUserLogedIn()) {
                Intent intent0 = new Intent(getApplicationContext(), ProfilActivity.class);
                startActivity(intent0);
            } else {
                Intent intent1 = new Intent(getApplicationContext(), LoginDrawerActivity.class);
                startActivity(intent1);
            }
        } else if (id == R.id.nav_inscription) {
            if (session.isUserLogedIn()) {


                Intent intent = new Intent(getApplicationContext(),ListepostActivity.class);
                startActivity(intent);
            } else {
                Intent intent3 = new Intent(getApplicationContext(), RegisterDrawerActivity.class);
                startActivity(intent3);
            }
        } else if (id == R.id.nav_test) {
            Intent intent4 = new Intent(getApplicationContext(), EndroitsActivity.class);
            startActivity(intent4);
        } else if (id == R.id.nav_settings) {
            Intent intent5 = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent5);
        } else if (id == R.id.nav_propos) {
            Intent intent6 = new Intent(getApplicationContext(), AproposActivity.class);
            startActivity(intent6);
        } else if (id == R.id.nav_aide) {
            Intent intent7 = new Intent(getApplicationContext(), AideActivity.class);
            startActivity(intent7);
        } else if (id == R.id.nav_utilisation) {
            Intent intent8 = new Intent(getApplicationContext(), ConditionUtilisationActivity.class);
            startActivity(intent8);
        } else if (id == R.id.nav_logout) {
            if (session.isUserLogedIn())
                session.logOutUser();
            Intent in = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(in);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }



}

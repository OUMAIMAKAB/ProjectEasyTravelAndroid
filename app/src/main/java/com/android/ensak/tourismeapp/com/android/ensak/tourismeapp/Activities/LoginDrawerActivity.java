package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestUtilisateurs;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Sessions.CodezSession;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Utilisateur;

public class LoginDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    EditText loginname, loginpassword;
    Button login;
    CodezSession session;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context=this;
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView textView = findViewById(R.id.creercompte);

        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.textViewUsername);
        navUsername.setText("Bienvenue...");
        TextView navMailUser = (TextView) headerView.findViewById(R.id.textViewUsermail);
        navMailUser.setText(" ");

        session = new CodezSession(LoginDrawerActivity.this);
        loginname = (EditText) findViewById(R.id.loginusername);
        loginpassword = (EditText) findViewById(R.id.loginpassword);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = loginname.getText().toString().trim();
                String pass = loginpassword.getText().toString().trim();
                if (name.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(LoginDrawerActivity.this, "Please Fill the details", Toast.LENGTH_SHORT).show();
                } else {


                    ControllerRestUtilisateurs controllerRestUtilisateurs=ControllerRestUtilisateurs.getInstanceControllerRestClass();
                    controllerRestUtilisateurs.setContext(context);
                    controllerRestUtilisateurs.getUtilisteurConnecte(new Utilisateur(name,pass));
                    //invalidateUser(name, pass);
                }
            }
        });

        setValuesFromSignUp();

        if (session.isUserLogedIn() == true) {

            navigationView.getMenu().findItem(R.id.nav_connecter).setTitle("Mon profil");
            navigationView.getMenu().findItem(R.id.nav_connecter).setIcon(R.drawable.ic_profile);

            navigationView.getMenu().findItem(R.id.nav_inscription).setTitle("Mes postes");
            navigationView.getMenu().findItem(R.id.nav_inscription).setIcon(R.drawable.ic_posts);

            navigationView.getMenu().findItem(R.id.nav_test).setTitle("Mes endroits visités");
            navigationView.getMenu().findItem(R.id.nav_test).setIcon(R.drawable.ic_endroits);

        } else {
            navigationView.getMenu().removeItem(R.id.nav_test);
            navigationView.getMenu().removeItem(R.id.nav_logout);
        }


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoginDrawerActivity.this, RegisterDrawerActivity.class);
                startActivity(in);
                finish();
            }
        });


    }

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



    public void setValuesFromSignUp() {
        loginname.setText(session.getUserName().equalsIgnoreCase("") ? "" : session.getUserName());
        loginpassword.setText(session.getUserPassword().equalsIgnoreCase("") ? "" : session.getUserPassword());
    }

    public void invalidateUser(String name, String pass) {
        if (name.equalsIgnoreCase(session.getUserName()) && pass.equalsIgnoreCase(session.getUserPassword())) {
            session.loginUser(name, pass, true);
            Intent in = new Intent(LoginDrawerActivity.this, MainActivity.class);
            startActivity(in);
            finish();
        } else {
            Toast.makeText(LoginDrawerActivity.this, "Wrong Username or Password! Try again", Toast.LENGTH_SHORT).show();
        }
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
                Intent intent2 = new Intent(getApplicationContext(), PostesActivity.class);
                startActivity(intent2);
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


    //Login code


}

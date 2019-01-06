package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.Sessions;


import android.content.Context;
import android.content.SharedPreferences;


public class CodezSession {
    //key for username
    private String USERNAME="username";
    //key for password
    private String PASSWORD="password";
    //key for email
    private String EMAIL="email";
    //key for preferences
    private String PREFERENCES="codezSession";
    //key for is user login
    private String ISLOGIN="login";
    // Shared Preferences variable
    SharedPreferences coderzpassionprefer;
    //editor for shared preference
    SharedPreferences.Editor editor;

    public CodezSession(Context context)
    {
        coderzpassionprefer=context.getSharedPreferences(PREFERENCES,Context.MODE_PRIVATE);
        editor=coderzpassionprefer.edit();

    }
    // function store user details
    public void storeUser(String name,String pass,String email)
    {
        editor.putString(USERNAME,name);
        editor.putString(PASSWORD,pass);
        editor.putString(EMAIL,email);
        editor.commit();
    }
    // to login user
    public void loginUser(String name,String password,boolean login)
    {
        editor.putString(USERNAME,name);
        editor.putString(PASSWORD,password);
        editor.putBoolean(ISLOGIN,login);
        editor.commit();
    }

    //to get username
    public String getUserName()
    {
        return coderzpassionprefer.getString(USERNAME,"");
    }
    //to get userpassword
    public String getUserPassword()
    {
        return coderzpassionprefer.getString(PASSWORD,"");
    }
    //to get useremail
    public String getUserEmail()
    {
        return coderzpassionprefer.getString(EMAIL,"");
    }
    //to check whether user is login or not
    public boolean isUserLogedIn()
    {
        return coderzpassionprefer.getBoolean(ISLOGIN,false);
    }
    // to delete the user and clear the preferences
    public void logOutUser()
    {
        editor.clear();
        editor.commit();
    }

}
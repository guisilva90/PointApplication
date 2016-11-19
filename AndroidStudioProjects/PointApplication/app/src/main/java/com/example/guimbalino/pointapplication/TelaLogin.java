package com.example.guimbalino.pointapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.CallbackManager;


import java.util.Arrays;


public class TelaLogin extends AppCompatActivity {

    LoginButton loginButton;
    CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        setContentView(R.layout.activity_tela_login);

        loginButton = (LoginButton) findViewById(R.id.btnFacebook);

        final LoginButton btnFacebook = (LoginButton) findViewById(R.id.btnFacebook);
        loginButton.setBackgroundResource(R.drawable.login);
        loginButton.setPadding(40, 40, 40, 40);
        loginButton.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

        loginButton.setReadPermissions(Arrays.asList("public_profile, email, user_friends"));
        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }



            @Override
            public void onCancel() {


            }

            @Override
            public void onError(FacebookException error) {

            }
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    protected void onStart(){
        super.onStart();

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if(accessToken != null){
            Intent intent = new Intent(TelaLogin.this, MainActivity.class);
            startActivity(intent);

        }
    }

}

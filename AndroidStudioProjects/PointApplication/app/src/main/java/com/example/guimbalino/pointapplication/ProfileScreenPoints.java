package com.example.guimbalino.pointapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileScreenPoints extends AppCompatActivity {

    String nome;
    String email;
    String id;
    String caminhoImagem;

    ImageView imagemusuario;
    ImageView imagemusuario2;
    TextView nomeusuario;
    RoundImage roundImage;


    AccessToken accessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_profile_screen_points);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        /*ImageView cimaperfil = (ImageView) findViewById(R.id.cimaperfil);
        cimaperfil.setAlpha(50);*/

        imagemusuario = (ImageView) findViewById(R.id.imagemusuario);
        imagemusuario2 = (ImageView) findViewById(R.id.imagemusuario2);
        nomeusuario = (TextView) findViewById(R.id.nomeusuario);

        /*Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.id.imagemusuario2);
        roundImage = new RoundImage(bitmap);
        imagemusuario2.setImageDrawable(roundImage);*/

    }

        @Override
        protected void onStart () {
            super.onStart();

            accessToken = AccessToken.getCurrentAccessToken();
            if(accessToken == null){
                finish();
            }
            GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject object, GraphResponse response) {
                    try {
                        nome = object.getString("name");
                        email = object.getString("email");
                        id = object.getString("id");

                        nomeusuario.setText(nome);

                        caminhoImagem = "https://graph.facebook.com/" + object.getString("id") + "/picture?type=large";
                        Picasso.with(ProfileScreenPoints.this).load(caminhoImagem).into(imagemusuario);
                        Picasso.with(ProfileScreenPoints.this).load(caminhoImagem).into(imagemusuario2);

                    } catch (JSONException e) {e.printStackTrace();}

                }

            });

            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email");
            request.setParameters(parameters);
            request.executeAsync();
        }
    }


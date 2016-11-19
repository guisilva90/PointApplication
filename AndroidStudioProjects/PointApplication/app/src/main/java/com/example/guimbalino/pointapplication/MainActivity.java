package com.example.guimbalino.pointapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.CoordinatorLayout;
import android.widget.ImageButton;
import android.view.*;
import android.content.*;
import android.widget.Toast;

import com.example.guimbalino.pointapplication.adapters.MyFragmentPagerAdapter;

import java.*;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar point_toolbar = (Toolbar) findViewById(R.id.point_toolbar);
        setSupportActionBar(point_toolbar);
        getSupportActionBar().setTitle(R.string.point_tb_title);

        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        //getSupportActionBar().setIcon(R.drawable.vector_smart_object);

        //Funções dos Botões


        ButtonBarLayout btnCal = (ButtonBarLayout) findViewById(R.id.btnCal);
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Calendário",
                        Toast.LENGTH_SHORT).show();
            }
        });


        ButtonBarLayout btnPoint = (ButtonBarLayout) findViewById(R.id.btnPoint);
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileScreenPoints.class);
                startActivity(intent);
            }
        });

        ButtonBarLayout btnTag = (ButtonBarLayout) findViewById(R.id.btnTag);
        btnTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Tags",
                        Toast.LENGTH_SHORT).show();
            }
        });


        ImageButton btnShed = (ImageButton) findViewById(R.id.btnShed);

        btnShed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}













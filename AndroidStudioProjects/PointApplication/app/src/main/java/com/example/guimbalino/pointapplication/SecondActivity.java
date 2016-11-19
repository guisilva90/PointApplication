package com.example.guimbalino.pointapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.guimbalino.pointapplication.adapters.MyFragmentPagerAdapter;
import com.example.guimbalino.pointapplication.fragments.FragmentA;
import com.example.guimbalino.pointapplication.fragments.FragmentB;
import com.example.guimbalino.pointapplication.fragments.FragmentC;

public class SecondActivity extends AppCompatActivity {

    public class TabsPagerAdapter extends FragmentPagerAdapter {
        private static final int NUM_TABS = 3;

        public TabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return FragmentA.newInstance();
                case 1:
                    return FragmentB.newInstance();
                default:
                    return FragmentC.newInstance();
            }
        }

        @Override
        public int getCount() {
            return NUM_TABS;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            if (position == 0){
                return "Descrição";
            }

            if (position == 1){
                return "Promos";
            }

            return "Trocas";
        }
    }



    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), getResources().getStringArray(R.array.titles_tab)));
        mTabLayout.setupWithViewPager(mViewPager);




        Button btnCheckin = (Button) findViewById(R.id.btnCheckin);

        btnCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, TelaConfirmacao.class);
                startActivity(intent);



            }
        });

    }
}


package com.example.guimbalino.pointapplication.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guimbalino.pointapplication.R;

/**
 * Created by guimbalino on 11/3/16.
 */

public class FragmentA extends android.support.v4.app.Fragment {
    public static FragmentA newInstance() {
            FragmentA fragment = new FragmentA();
            return fragment;
        }

        public FragmentA() {
            // Deve existir um construtor vazio
            // na classe que estende um Fragment
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
            }
        }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_a, container, false);
    }
}

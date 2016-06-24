package com.example.home.bngapp.fragments;

/**
 * Created by Home on 6/6/2016.
 */

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home.bngapp.R;
import com.example.home.bngapp.activities.MainActivity;
import com.example.home.bngapp.utilities.Util;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;


public class BngLoveFragment2 extends Fragment{
MainActivity mainActivity;


    public BngLoveFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View rootView = inflater.inflate(R.layout.fragment_bnglove2, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }



    @Override
    public void onResume() {
        super.onResume();

        // select libraries tab
        mainActivity.tabLayout.getTabAt(3).select();

    }




}
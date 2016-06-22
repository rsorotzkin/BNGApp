package com.example.home.bngapp.fragments;

/**
 * Created by Home on 6/6/2016.
 */
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.home.bngapp.R;
import com.example.home.bngapp.activities.MainActivity;


public class HomeFragment extends Fragment{
MainActivity mainActivity;
    Toolbar toolbar;

    public HomeFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
    initializeViews(rootView);
        return rootView;

    }


    public void initializeViews(View rootView){

        //((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        //((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        toolbar.setTitle("BNG");
        toolbar.setTitleTextColor(getResources().getColor(R.color.primary));
        //((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(0, 0, 0)));

    }

    @Override
    public void onResume() {
        super.onResume();

        // select libraries tab
        mainActivity.tabLayout.getTabAt(0).select();

    }

}
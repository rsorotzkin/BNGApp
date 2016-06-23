package com.example.home.bngapp.fragments;

/**
 * Created by Home on 6/6/2016.
 */
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.home.bngapp.R;
import com.example.home.bngapp.activities.MainActivity;
import com.example.home.bngapp.adapters.GiftsItemsAdapter;
import com.example.home.bngapp.classes.GiftItems;
import com.example.home.bngapp.utilities.Util;

import java.util.ArrayList;


public class GiftDetailsFragment extends Fragment{

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    // Declare activity
    MainActivity mainActivity;
    Toolbar toolbar;


    public GiftDetailsFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_gifts_detail, container, false);

        // Initialize views for this fragment
        initializeViews(rootView);

        // Set up recyclerView
        setUpRecyclerView();

        // Register all listeners for controls
        registerListeners();
        toolbar = (android.support.v7.widget.Toolbar) rootView.findViewById(R.id.toolbar);
        toolbar.setTitle("Sunshine Basket");
        toolbar.setBackgroundColor(getResources().getColor(R.color.icons));
        toolbar.setTitleTextColor(getResources().getColor(R.color.primary));
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.primary));
        ((AppCompatActivity) Util.getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)Util.getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Util.enableBackButton(toolbar);


        return rootView;
    }

    public void initializeViews(View rootView) {


    }

    public void setUpRecyclerView() {


    }

    public void registerListeners() {

    }


}
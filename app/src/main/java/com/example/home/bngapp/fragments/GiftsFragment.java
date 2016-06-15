package com.example.home.bngapp.fragments;

/**
 * Created by Home on 6/6/2016.
 */
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.home.bngapp.R;
import com.example.home.bngapp.activities.MainActivity;
import com.example.home.bngapp.adapters.GiftsItemsAdapter;
import com.example.home.bngapp.classes.GiftItems;
import com.example.home.bngapp.utilities.Util;

import java.util.ArrayList;


public class GiftsFragment extends Fragment{

    // Declare activity
    MainActivity mainActivity;

    // Declare controls
    RecyclerView recyclerView;
    LinearLayoutManager llm;

    // Declare variables
    ArrayList<GiftItems> giftItems;
    GiftItems items;
    GiftsItemsAdapter adapter;

    public GiftsFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_gifts, container, false);

        // Initialize views for this fragment
        initializeViews(rootView);

        // Set up recyclerView
        setUpRecyclerView();

        // Register all listeners for controls
        registerListeners();

        // Download data from url
        downloadData();

        // set toolbar title
        //Util.setToolbarTitle(R.string.fragment_team, mainActivity.toolbar);
        //((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getResources().getString(R.string.fragment_gifts));


        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        // select libraries tab
        mainActivity.tabLayout.getTabAt(2).select();

    }

    public void initializeViews(View rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        llm = new LinearLayoutManager(getActivity().getBaseContext());
        adapter = new GiftsItemsAdapter(getActivity());
        giftItems = new ArrayList<>();
        items = new GiftItems(1,"SUNSHINE BASKET", "$90.00", "An assortment of BNG delicacies, in an" +
                " exquisitely decorated basket");
        giftItems.add(items);
        items = new GiftItems(2,"SUNSHINE BASKET", "$90.00", "An assortment of BNG delicacies, in an" +
                " exquisitely decorated basket");
        giftItems.add(items);
        items = new GiftItems(3,"SUNSHINE BASKET", "$90.00", "An assortment of BNG delicacies, in an" +
                " exquisitely decorated basket");
        giftItems.add(items);
        items = new GiftItems(4,"SUNSHINE BASKET", "$90.00", "An assortment of BNG delicacies, in an" +
                " exquisitely decorated basket");
        giftItems.add(items);
        items = new GiftItems(5,"SUNSHINE BASKET", "$90.00", "An assortment of BNG delicacies, in an" +
                " exquisitely decorated basket");
        giftItems.add(items);
        adapter.setGiftItemsList(giftItems);


    }

    public void setUpRecyclerView() {
        // set layout manager to recycler view
        recyclerView.setLayoutManager(llm);
        // set orientation for linear layout manager
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        // set adapter for recycler view
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    public void registerListeners() {


    }

    public void downloadData() {

    }

}
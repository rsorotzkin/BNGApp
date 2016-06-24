package com.example.home.bngapp.fragments;

/**
 * Created by Home on 6/6/2016.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.bngapp.R;
import com.example.home.bngapp.activities.MainActivity;
import com.example.home.bngapp.adapters.GiftsItemsAdapter;
import com.example.home.bngapp.adapters.LocationItemsAdapter;
import com.example.home.bngapp.classes.GiftItems;
import com.example.home.bngapp.classes.LocationItems;
import com.example.home.bngapp.utilities.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class AboutFragment extends Fragment{

    public AboutFragment() {
        // Required empty public constructor
    }
    // Declare activity
    MainActivity mainActivity;

    // Declare controls
    RecyclerView recyclerView;
    LinearLayoutManager llm;

    @Nullable
    @BindView (R.id.contactFab)
    FloatingActionButton contactFab;

    @Nullable
    @BindView (R.id.toolbar)
    Toolbar toolbar;

    // Declare variables
    ArrayList<LocationItems> locationItemss;
    LocationItems items;
    LocationItemsAdapter adapter;
    //Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, rootView);
        ButterKnife.setDebug(true);

        toolbar.setTitle("About");
        toolbar.setBackgroundColor(getResources().getColor(R.color.icons));
        toolbar.setTitleTextColor(getResources().getColor(R.color.primary));

        contactFab.setBackgroundColor(getResources().getColor(R.color.primary));


        // Initialize views for this fragment
        initializeViews(rootView);

        // Set up recyclerView
        setUpRecyclerView();

        // Download data from url
        downloadData();



        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        // select libraries tab
        mainActivity.tabLayout.getTabAt(4).select();

    }

    public void initializeViews(View rootView) {

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        llm = new LinearLayoutManager(getActivity().getBaseContext());
        adapter = new LocationItemsAdapter(getActivity());
        locationItemss = new ArrayList<>();
        items = new LocationItems(1,"5702 18TH AVENUE", "BROOKLYN, NY 11204", "718.256.6656 ext 2");
        locationItemss.add(items);
        items = new LocationItems(1,"5702 18TH AVENUE", "BROOKLYN, NY 11204", "718.256.6656 ext 1");
        locationItemss.add(items);
        items = new LocationItems(1,"5702 18TH AVENUE", "BROOKLYN, NY 11204", "718.256.6656 ext 3");
        locationItemss.add(items);
        items = new LocationItems(1,"BAGELS N GREENS", "CALL CENTER", "718.256.6656 ext 0");
        locationItemss.add(items);

        adapter.setLocatinItemsList(locationItemss);


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


    @OnClick(R.id.contactFab)
    public void submit(FloatingActionButton contactFab) {
        Util.replaceFragment(new ContactFormFragment(), R.string.fragment_contact);
    }



    public void downloadData() {

    }


    @Override public void onDestroyView() {
        super.onDestroyView();
        //ButterKnife.unbind(this);

    }

}
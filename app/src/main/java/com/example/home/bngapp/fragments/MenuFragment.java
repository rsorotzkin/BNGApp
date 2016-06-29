package com.example.home.bngapp.fragments;

/**
 * Created by Home on 6/6/2016.
 */
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.bngapp.R;
import com.example.home.bngapp.activities.MainActivity;
import com.example.home.bngapp.utilities.Util;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MenuFragment extends Fragment{
    TextView clickTextView;

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    MainActivity mainActivity;

    public MenuFragment() {
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
        View rootView =  inflater.inflate(R.layout.fragment_menu, container, false);
        // set ButterKnife
        ButterKnife.bind(this, rootView);
        // set toolbar title
        toolbar.setTitle("Menu");

    return rootView;


    }
    @Override
    public void onResume() {
        super.onResume();

        // select libraries tab
        mainActivity.tabLayout.getTabAt(1).select();

    }



}
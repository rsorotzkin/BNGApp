package com.example.home.bngapp.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import com.example.home.bngapp.R;
import com.example.home.bngapp.activities.MainActivity;
import com.example.home.bngapp.utilities.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Home on 6/10/2016.
 */
public class ContactFormFragment extends Fragment {
    MainActivity mainActivity;
    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public ContactFormFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_contact_form, container, false);
        ButterKnife.bind(this, rootView);
        ButterKnife.setDebug(true);
        toolbar.setTitle("Contact");

        ((AppCompatActivity) Util.getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) Util.getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Util.enableBackButton(toolbar);
        return rootView;


    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

}

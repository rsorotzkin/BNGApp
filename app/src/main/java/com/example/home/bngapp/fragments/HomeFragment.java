package com.example.home.bngapp.fragments;

/**
 * Created by Home on 6/6/2016.
 */

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.home.bngapp.R;
import com.example.home.bngapp.activities.MainActivity;
import com.example.home.bngapp.utilities.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeFragment extends Fragment {
    MainActivity mainActivity;
    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Nullable
    @BindView(R.id.bngTodayCardView)
    CardView bngTodayCardView;
    @Nullable
    @BindView(R.id.springMenuCardView)
    CardView springMenuCardView;
    @Nullable
    @BindView(R.id.corporateCardView)
    CardView corporateCardView;
    @Nullable
    @BindView(R.id.giftCardView)
    CardView giftCardView;

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
        ButterKnife.bind(this, rootView);
        ButterKnife.setDebug(true);

        toolbar.setTitle("BNG");
        toolbar.setTitleTextColor(ContextCompat.getColor(Util.getContext(), R.color.primary));

        return rootView;

    }


    @OnClick(R.id.bngTodayCardView)
    void onSubmitTips() {
        Util.replaceFragment(new TipsFragment(), R.string.fragment_home);
    }
    @OnClick(R.id.springMenuCardView)
    void onSubmitMenu() {
        Util.replaceFragment(new MenuFragment(), R.string.fragment_home);
    }
    @OnClick(R.id.corporateCardView)
    void onSubmitCorporate() {
        Util.replaceFragment(new MenuFragment(), R.string.fragment_home);
    }
    @OnClick(R.id.giftCardView)
    void onSubmitGifts() {
        Util.replaceFragment(new GiftsFragment(), R.string.fragment_home);
    }


    @Override
    public void onResume() {
        super.onResume();

        // select libraries tab
        mainActivity.tabLayout.getTabAt(0).select();

    }

}
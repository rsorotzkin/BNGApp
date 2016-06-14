package com.example.home.bngapp.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.home.bngapp.R;
import com.example.home.bngapp.adapters.ViewPagerAdapter;
import com.example.home.bngapp.utilities.CustomViewPager;

/**
 * Created by faigy on 6/10/2016.
 */
public class TabLayoutFragment extends Fragment {

    public TabLayout tabLayout;
    private CustomViewPager viewPager;
    public ViewPagerAdapter adapter;

    public TabLayoutFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.tab_layout, container, false);
        initializeViews(rootView);

        setupTabIcons();
        return rootView;
    }

    public void initializeViews(View rootView) {
    viewPager = (CustomViewPager) rootView.findViewById(R.id.viewPagerContainer);
    setupViewPager(viewPager);

    // disable swiping in viewpager
    viewPager.setPagingEnabled(false);


    tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(viewPager);
    tabLayout.setSelectedTabIndicatorHeight(0);


}

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new MenuFragment(), "Menu");
        adapter.addFragment(new GiftsFragment(), "Gifts");
        adapter.addFragment(new BngLoveFragment(), "BngLove");
        adapter.addFragment(new AboutFragment(), "About");
        viewPager.setAdapter(adapter);


    }

    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabOne.setText("Home");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_one, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);
        if(!tabLayout.isSelected())
            tabOne.setSelected(true);

        TextView tabTwo = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Menu");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_two, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabThree.setText("Gifts");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_three, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabFour.setText("BngLove");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_four, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);

        TextView tabFive = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabFive.setText("About");
        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_five, 0, 0);
        tabLayout.getTabAt(4).setCustomView(tabFive);
    }


}

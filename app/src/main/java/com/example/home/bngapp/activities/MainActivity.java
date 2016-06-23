package com.example.home.bngapp.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.bngapp.fragments.AboutFragment;
import com.example.home.bngapp.fragments.BngLoveFragment;
import com.example.home.bngapp.fragments.GiftDetailsFragment;
import com.example.home.bngapp.fragments.GiftsFragment;
import com.example.home.bngapp.fragments.HomeFragment;
import com.example.home.bngapp.fragments.MenuFragment;
import com.example.home.bngapp.R;
import com.example.home.bngapp.utilities.CustomViewPager;
import com.example.home.bngapp.utilities.Util;
import com.example.home.bngapp.adapters.ViewPagerAdapter;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {

    // Declare controls
   //private Toolbar toolbar;
    public static TabLayout tabLayout;

    // Declare fragments
    public HomeFragment homeFragment;
    public BngLoveFragment bngLoveFragment;
    public AboutFragment aboutFragment;
    public GiftDetailsFragment giftDetailsFragment;
    public GiftsFragment giftsFragment;
    MenuFragment menuFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // send activity reference to Util class
        Util.setReference(this);

        initializeViews();
        initializeFragments();
        setupTablayout();

    }

    /**
     * Function to initialize controls
     */
    public void initializeViews() {

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        //getSupportActionBar().setTitle("BNG");
        tabLayout = (TabLayout) findViewById(R.id.tabs);
    }

    public void initializeFragments() {

        homeFragment = new HomeFragment();
        bngLoveFragment = new BngLoveFragment();
        aboutFragment = new AboutFragment();
        giftDetailsFragment = new GiftDetailsFragment();
        giftDetailsFragment.setMainActivity(this);
        giftsFragment = new GiftsFragment();
        menuFragment = new MenuFragment();
        menuFragment.setMainActivity(this);
    }

    /**
     * Function to set up tabLayout
     */
    private void setupTablayout() {
        // remove default tab indicator
        tabLayout.setSelectedTabIndicatorHeight(0);
        // createTab and send title, and drawable for each tab in the tabLayout
        createTab("Home", R.drawable.tab_one);
        createTab("Menu", R.drawable.tab_two);
        createTab("Gifts", R.drawable.tab_three);
        createTab("BngLove", R.drawable.tab_four);
        createTab("About", R.drawable.tab_five);
        tabLayout.setOnTabSelectedListener(tabListener);
    }

    /**
     * Function to set up each tab
     *
     * @param title - text
     * @param icon  - drawable
     */
    public void createTab(String title, int icon) {
        // initialize the tab
        TabLayout.Tab tab = tabLayout.newTab();
        // setting the custom view in the tab
        TextView view = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        // setting the text of the view
        view.setText(title);
        // setting the icon of the view
        view.setCompoundDrawablesWithIntrinsicBounds(0, icon, 0, 0);
        // adding the tab to the tabLayout
        tabLayout.addTab(tab);
        // adding the view to the tab
        tab.setCustomView(view);
        // if position of tab is 0
        if(tab.getPosition() == 0){
            // set tab to be selected
            view.setSelected(true);
            // inflate homeFragment
            Util.replaceFragment(homeFragment, R.string.fragment_home);
        }

    }

    /**
     * initializing a tabListener
     */
    TabLayout.OnTabSelectedListener tabListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            // check selected tab item position
            switch (tabLayout.getSelectedTabPosition()) {
                // first tab - Home
                case 0:
                    // check if homeFragment is visible or not
                    if (!homeFragment.isVisible()) {
                        // if its not visible call a method that will return this fragment
                        Util.replaceFragment(homeFragment,R.string.fragment_home);
                    }
                    // exit the switch statement
                    break;
                // second tab - Menu
                case 1:
                    // check if menuFragment is visible or not
                    if (!menuFragment.isVisible()) {
                        // if its not visible call a method that will return this fragment
                        Util.replaceFragment(menuFragment,R.string.fragment_menu);
                    }
                    // exit the switch statement
                    break;
                // third tab - Gifts
                case 2:
                    // check if giftsFragment is visible or not
                    if (!giftsFragment.isVisible()) {
                        // if its not visible call a method that will return this fragment
                        Util.replaceFragment(giftsFragment,R.string.fragment_gifts);
                    }
                    // exit the switch statement
                    break;
                // fourth tab - BngLove
                case 3:
                    // check if bngLoveFragment is visible or not
                    if (!bngLoveFragment.isVisible()) {
                        // if its not visible call a method that will return this fragment
                        Util.replaceFragment(bngLoveFragment,R.string.fragment_bnglove);
                    }
                    // exit the switch statement
                    break;
                // fifth tab - About
                case 4:
                    // check if aboutFragment is visible or not
                    if (!aboutFragment.isVisible()) {
                        // if its not visible call a method that will return this fragment
                        Util.replaceFragment(aboutFragment,R.string.fragment_about);
                    }
                    // exit the switch statement
                    break;
                // error handler - used if any of the other cases are not used.
                default:
                    // exit the switch statement
                    break;
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };




    @Override
    public void onBackPressed() {
        // if there are fragments in the back stack
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            // undo the last back stack transaction
            getFragmentManager().popBackStack();
        } else {
            // finish this activity
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }



}

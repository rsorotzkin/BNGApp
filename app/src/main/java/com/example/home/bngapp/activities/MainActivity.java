package com.example.home.bngapp.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity {

    // Declare controls
    private Toolbar toolbar;
    public TabLayout tabLayout;
    private CustomViewPager viewPager;
    public GiftDetailsFragment giftDetailsFragment;
    public GiftsFragment giftsFragment;
    public ViewPagerAdapter adapter;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // send activity reference to Util class
        Util.setReference(this);

        giftDetailsFragment = new GiftDetailsFragment();
        giftDetailsFragment.setMainActivity(this);
        giftsFragment = new GiftsFragment();
        menuFragment = new MenuFragment();
        menuFragment.setMainActivity(this);

        initializeViews();
        setupTabIcons();



    }

    /**
     * Function to initialize controls
     */
    public void initializeViews() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        viewPager = (CustomViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        // disable swiping in viewpager
        viewPager.setPagingEnabled(false);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorHeight(0);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new MenuFragment(), "Menu");
        adapter.addFragment(new GiftsFragment(), "Gifts");
        adapter.addFragment(new BngLoveFragment(), "BngLove");
        adapter.addFragment(new AboutFragment(), "About");
        viewPager.setAdapter(adapter);


    }



    public void replaceFragment(Fragment fragment) {

        //invalidateOptionsMenu();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();

    }




    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Home");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_one, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);
        if(!tabLayout.isSelected())
        tabOne.setSelected(true);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Menu");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_two, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Gifts");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_three, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFour.setText("BngLove");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_four, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);

        TextView tabFive = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFive.setText("About");
        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tab_five, 0, 0);
        tabLayout.getTabAt(4).setCustomView(tabFive);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

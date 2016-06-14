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
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.bngapp.fragments.AboutFragment;
import com.example.home.bngapp.fragments.BngLoveFragment;
import com.example.home.bngapp.fragments.GiftDetailsFragment;
import com.example.home.bngapp.fragments.GiftsFragment;
import com.example.home.bngapp.fragments.HomeFragment;
import com.example.home.bngapp.fragments.MenuFragment;
import com.example.home.bngapp.R;
import com.example.home.bngapp.fragments.TabLayoutFragment;
import com.example.home.bngapp.utilities.CustomViewPager;
import com.example.home.bngapp.utilities.Util;
import com.example.home.bngapp.adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    // Declare controls
    private Toolbar toolbar;

    public GiftDetailsFragment giftDetailsFragment;
    public GiftsFragment giftsFragment;

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

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TabLayoutFragment()).commit();

    }

    /**
     * Function to initialize controls
     */
    public void initializeViews() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("BNG");
    }


    public void showToast() {
        Toast.makeText(this, "hello", Toast.LENGTH_LONG).show();
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

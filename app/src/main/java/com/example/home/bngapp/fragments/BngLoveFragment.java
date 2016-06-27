package com.example.home.bngapp.fragments;

/**
 * Created by Home on 6/6/2016.
 */
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.bngapp.R;
import com.example.home.bngapp.activities.MainActivity;
import com.example.home.bngapp.utilities.Util;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;


public class BngLoveFragment extends Fragment{
MainActivity mainActivity;
    Toolbar toolbar;
    CardView uploadImageCardView;
    ImageView imageView;
    TextView uploadImageTextView;


    public BngLoveFragment() {
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
      View rootView = inflater.inflate(R.layout.fragment_bnglove, container, false);
        ButterKnife.bind(this, rootView);
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        toolbar.setTitle("Eat.Love.Share");
        uploadImageCardView = (CardView)rootView.findViewById(R.id.uploadImageCardView);
        uploadImageCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               takePhoto();
            }
        });
        imageView = (ImageView)rootView.findViewById(R.id.imageView);
        uploadImageTextView = (TextView)rootView.findViewById(R.id.uploadImageTextView);
       // toolbar.setBackgroundColor(getResources().getColor(R.color.icons));
        return rootView;
    }

    public void takePhoto(){
        Util.createDialog("Take Photo","Share your photo on BNG","take photo","choose photo",null,"photo","");
        //((MainActivity)getActivity()).takePhoto();
        //((MainActivity)getActivity()).pickPhoto();
    }

    @Override
    public void onResume() {
        super.onResume();

        // select libraries tab
        mainActivity.tabLayout.getTabAt(3).select();

    }

    /**
     * Function to set reference of MainActivity
     *
     * @param mainActivity - reference to MainActivity
     */
    public void setMainActivity(MainActivity mainActivity) {
        // set this mainActivity to mainActivity
        this.mainActivity = mainActivity;
    }

    public void setImage(Uri mMediaUri){
        uploadImageTextView.setText("");
        Picasso.with(Util.getContext()).load(mMediaUri).into(imageView);
    }

}
package com.example.home.bngapp.fragments;

/**
 * Created by Home on 6/6/2016.
 */

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.bngapp.R;
import com.example.home.bngapp.activities.MainActivity;
import com.example.home.bngapp.utilities.Util;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;


public class BngLoveFragment extends Fragment {

    // Declare activity
    MainActivity mainActivity;

    // Declare controls

    @Nullable @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Nullable @BindView(R.id.uploadImageView)
    ImageView imageView;

    @Nullable @BindView(R.id.uploadImageView2)
    ImageView imageView2;

    @Nullable @BindView(R.id.uploadImageTextView)
    TextView uploadImageTextView;

    @Nullable @BindView(R.id.shareLinearLayout)
    LinearLayout shareLinearLayout;

    @Nullable @BindView(R.id.uploadImageLinearLayout)
    LinearLayout uploadImageLinearLayout;

    @Nullable @BindView(R.id.facebookImageView)
    ImageView facebookImageView;

    @Nullable @BindView(R.id.twitterImageView)
    ImageView twitterImageView;

    @Nullable @BindView(R.id.instagramImageView)
    ImageView instagramImageView;

    @Nullable @BindView(R.id.googleplusImageView)
    ImageView googleplusImageView;

    @Nullable @BindView(R.id.youtubeImageView)
    ImageView youtubeImageView;

    // set variables
    Boolean isImageSet = false;

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
        // set ButterKnife
        ButterKnife.bind(this, rootView);

        toolbar.setTitle("Eat.Love.Share.");
        // set isImageSet to false
        isImageSet = false;

        return rootView;
    }


    @Optional @OnClick(R.id.uploadImageView)
    public void uploadImageView() {
        Util.createDialog("Take Photo", "Share your photo on BNG", "take photo", "choose photo", null, "photo", "");
    }

    @Optional @OnClick(R.id.uploadImageView2)
    public void resetImaegView() {
        Util.createDialog("Take Photo", "Share your photo on BNG", "take photo", "choose photo", null, "photo", "");
    }

    @Optional@OnClick(R.id.shareLinearLayout)
    public void shareImage() {
        if (isImageSet == true)
            ((MainActivity) getActivity()).shareIntent();
        else
            Toast.makeText(Util.getContext(), "Please upload an image first", Toast.LENGTH_LONG).show();
    }

    @Optional @OnClick(R.id.facebookImageView)
    public void openFacebook() {
        Util.openUrlInBrowser("https://www.facebook.com/BagelsNGreens/");
    }
    @Optional @OnClick(R.id.twitterImageView)
    public void openTwitter() {
        Util.openUrlInBrowser("https://twitter.com/bagelsngreens");
    }
    @Optional @OnClick(R.id.instagramImageView)
    public void openInstagram() {
        Util.openUrlInBrowser("https://www.instagram.com/bagelsngreens/?hl=en");
    }
    @Optional @OnClick(R.id.googleplusImageView)
    public void openGoogleplus() {
        Util.openUrlInBrowser("https://plus.google.com/+BagelsngreensConey/about");
    }
    @Optional @OnClick(R.id.youtubeImageView)
    public void openYoutube() {
        Util.openUrlInBrowser("https://www.youtube.com/watch?v=phHeG3jB-HY");
    }

    public void setImage(Uri mMediaUri) {
        setViewsVisibilty();
        // inflate imageView with mMediaUri
        Picasso.with(Util.getContext()).load(mMediaUri).into(imageView2);
        // set isImageSet to true
        isImageSet = true;
    }

    public void setViewsVisibilty(){
        uploadImageTextView.setVisibility(View.GONE);
        uploadImageLinearLayout.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);
        imageView2.setVisibility(View.VISIBLE);
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

}
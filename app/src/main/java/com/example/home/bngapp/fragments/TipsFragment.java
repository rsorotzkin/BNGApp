package com.example.home.bngapp.fragments;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.bngapp.R;
import com.example.home.bngapp.utilities.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFragment extends Fragment {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Nullable
    @BindView(R.id.tipCardView)
    CardView tipCardView;


    public TipsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tips, container, false);

        ButterKnife.bind(this, rootView);
        ButterKnife.setDebug(true);
        toolbar.setTitle("Tip of the Day");


        return rootView;
    }

    @OnClick(R.id.tipCardView)
    void onSubmit() {
        LayoutInflater inflater = (LayoutInflater) Util.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.tips_dialog, null);
        AlertDialog.Builder builder =
                new AlertDialog.Builder(Util.getActivity(), R.style.AppCompatAlertDialogStyle);
        builder.setView(view);
        ImageView shareButton = (ImageView) view.findViewById(R.id.shareButton);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Util.getContext(), "share intent", Toast.LENGTH_LONG).show();

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                //Uri screenshotUri = ;

                shareIntent.setType("image/png");
                //shareIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                shareIntent.putExtra(android.content.Intent.EXTRA_TITLE, "text goes here");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "text extra goes here");
                startActivity(Intent.createChooser(shareIntent, "Share image using"));
            }
        });
        builder.show();
    }


}

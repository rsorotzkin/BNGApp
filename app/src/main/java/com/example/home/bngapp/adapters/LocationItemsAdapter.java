package com.example.home.bngapp.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home.bngapp.R;
import com.example.home.bngapp.activities.MainActivity;
import com.example.home.bngapp.classes.GiftItems;
import com.example.home.bngapp.classes.LocationItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by faigy on 6/7/2016.
 */
public class LocationItemsAdapter extends RecyclerView.Adapter<LocationItemsAdapter.LocationItemsViewHolder> {
    // Declare ArrayList
    private List<LocationItems> locationItemsList;

    // Declare variables
    public int expandedPosition;;

    // Declare class
    public LocationItems items;
    MainActivity mainActivity;


    // Declare context
    Context context;

    // Constructor
    public LocationItemsAdapter(Context context) {
        this.context = context;

    }

    /**
     * Function sets the newsList
     */
    public void setLocatinItemsList(ArrayList<LocationItems> locationItemsList){
        this.locationItemsList = locationItemsList;
        // notify the adapter of item range changed
        notifyItemRangeChanged(0, locationItemsList.size());
    }

    /**
     * Function that create new views (invoked by the layout manager)
     *
     */
    @Override
    public LocationItemsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // initialize itemView
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.fragment_about_items, viewGroup, false);
        // return itemView
        return new LocationItemsViewHolder(itemView);
    }

    /**
     * Function that replace the contents of a view (invoked by the layout manager)
     * @param locationItemsViewHolder   - current viewHolder
     * @param position - current inflated position in viewHolder
     *
     */
    @Override
    public void onBindViewHolder(final LocationItemsViewHolder locationItemsViewHolder, final int position) {
        // get data from your newsList at this position
        // replace the contents of the view with that newsList data
        items = locationItemsList.get(position);
        locationItemsViewHolder.locationTitle.setText(items.getTitle());
        locationItemsViewHolder.locationZip.setText(items.getZip());
        locationItemsViewHolder.locationPhone.setText(items.getPhone());
        locationItemsViewHolder.basketImageView.setImageResource(R.drawable.boropark_location);

        locationItemsViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "hi", Toast.LENGTH_LONG).show();

            }
        });

    }

    /**
     * Function that returns the number of items in newsList
     * @return int
     */
    @Override
    public int getItemCount() {
        // if newsList is not null
        if (locationItemsList != null) {
            // return size of newsList
            return locationItemsList.size();
        }
        return 0;
    }

    // this will store the references to our view
    public class LocationItemsViewHolder extends RecyclerView.ViewHolder {
        protected TextView locationTitle,  locationPhone, locationZip;
        public ImageView basketImageView;
        public ProgressBar imageProgressBar;
        public CardView cardView;

        public LocationItemsViewHolder(View v) {
            super(v);
            // Initialize all views in viewHolder
            locationTitle = (TextView) v.findViewById(R.id.locationTitle);
            locationZip = (TextView) v.findViewById(R.id.locationZip);
            locationPhone = (TextView) v.findViewById(R.id.locationPhone);
            basketImageView = (ImageView) v.findViewById(R.id.basketImageView);
            imageProgressBar = (ProgressBar) v.findViewById(R.id.imageProgressBar);
            cardView = (CardView) v.findViewById(R.id.card_view);
        }
    }
}

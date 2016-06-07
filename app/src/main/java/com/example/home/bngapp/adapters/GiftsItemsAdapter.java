package com.example.home.bngapp.adapters;

import android.app.Fragment;
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
import com.example.home.bngapp.utilities.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by faigy on 6/7/2016.
 */
public class GiftsItemsAdapter extends RecyclerView.Adapter<GiftsItemsAdapter.GiftsItemsViewHolder> {
    // Declare ArrayList
    private List<GiftItems> giftItemsList;

    // Declare variables
    public int expandedPosition;;

    // Declare class
    public GiftItems items;


    // Declare context
    Context context;

    // Constructor
    public GiftsItemsAdapter(Context context) {
        this.context = context;

    }

    /**
     * Function sets the newsList
     */
    public void setGiftItemsList(ArrayList<GiftItems> giftItemsList){
        this.giftItemsList = giftItemsList;
        // notify the adapter of item range changed
        notifyItemRangeChanged(0, giftItemsList.size());
    }

    /**
     * Function that create new views (invoked by the layout manager)
     *
     */
    @Override
    public GiftsItemsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // initialize itemView
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.fragment_gifts_items, viewGroup, false);
        // return itemView
        return new GiftsItemsViewHolder(itemView);
    }

    /**
     * Function that replace the contents of a view (invoked by the layout manager)
     * @param giftsItemsViewHolder   - current viewHolder
     * @param position - current inflated position in viewHolder
     *
     */
    @Override
    public void onBindViewHolder(final GiftsItemsViewHolder giftsItemsViewHolder, final int position) {
        // get data from your newsList at this position
        // replace the contents of the view with that newsList data
        items = giftItemsList.get(position);
        giftsItemsViewHolder.basketTitle.setText(items.getTitle());
        giftsItemsViewHolder.basketPrice.setText(items.getPrice());
        giftsItemsViewHolder.basketDescription.setText(items.getDescription());
        giftsItemsViewHolder.basketImageView.setImageResource(R.drawable.gifts_item);

        giftsItemsViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "hi", Toast.LENGTH_LONG).show();
                // set and store the clicked position in the recycler view
                //MySingleton.getInstance().setPosition(position);
                // switch to service detail fragment
                if (context instanceof MainActivity) {
                    Fragment giftsDetailFragment = ((MainActivity)context).giftDetailsFragment;
                    Util.replaceFragment(giftsDetailFragment, R.id.basketTitle);
                }
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
        if (giftItemsList != null) {
            // return size of newsList
            return giftItemsList.size();
        }
        return 0;
    }

    // this will store the references to our view
    public class GiftsItemsViewHolder extends RecyclerView.ViewHolder {
        protected TextView basketTitle,  basketPrice, basketDescription;
        public ImageView basketImageView;
        public ProgressBar imageProgressBar;
        public CardView cardView;

        public GiftsItemsViewHolder(View v) {
            super(v);
            // Initialize all views in viewHolder
            basketTitle = (TextView) v.findViewById(R.id.basketTitle);
            basketDescription = (TextView) v.findViewById(R.id.basketDescription);
            basketPrice = (TextView) v.findViewById(R.id.basketPrice);
            basketImageView = (ImageView) v.findViewById(R.id.basketImageView);
            imageProgressBar = (ProgressBar) v.findViewById(R.id.imageProgressBar);
            cardView = (CardView) v.findViewById(R.id.card_view);
        }
    }
}

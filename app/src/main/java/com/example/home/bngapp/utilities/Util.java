package com.example.home.bngapp.utilities;

import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.home.bngapp.R;
import com.example.home.bngapp.activities.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Home on 6/7/2016.
 */
public class Util extends Activity{
    // initialize variables
    private static Context context = null;
    private static Activity activity = null;

    /**
     * Function to set reference of current activity
     *
     * @param activity - current activity
     */
    public static void setActivity(Activity activity) {
        // set this activity to current activity
        Util.activity = activity;
    }

    /**
     * Function to return reference of current activity
     *
     * @return activity
     */
    public static Activity getActivity() {
        return activity;
    }

    /**
     * Function to return reference of current context
     *
     * @return context
     */
    public static Context getContext() {
        return context;
    }

    /**
     * Function to set reference of current context
     *
     * @param context - current context
     */
    public static void setContext(Context context) {

        // set this context to current context
        Util.context = context;
    }

    /**
     * Function to call methods that set reference to current activity
     *
     * @param activity - current activity
     */
    public static void setReference(Activity activity) {
        // set context to activity
        setContext(activity);
        // set activity to activity
        setActivity(activity);
    }

    /**
     * Function to add / replace fragment
     *
     * @param fragment - new fragment
     * @param tag      - tag to add along with the fragment to the back stack
     */
    public static void replaceFragment(Fragment fragment, int tag) {
        // replace fragment in container
        getActivity().getFragmentManager().beginTransaction().replace(R.id.container,
                fragment, tag + "").addToBackStack(tag + "").commit();

    }
    /**
     * @param toolbar - set the icon to this toolbar
     */
    public static void enableBackButton(Toolbar toolbar) {

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pop the backStack
                activity.getFragmentManager().popBackStack();
            }
        });

    }

    /**
     * @param title              - set dialog title
     * @param message            - set dialog message
     * @param positiveButtonText - set text for positive button in dialog
     * @param negativeButtonText - set text for negative button in dialog
     * @param neutralButtonText - set text for neutral button in dialog
     * @param tag                - set tag for listener in dialog
     * @param param              - set param for listener in dialog
     */
    public static void createDialog(String title, String message, String positiveButtonText,
                                    String negativeButtonText, String neutralButtonText, final String tag, final String param) {
        // initialize builder and set it to AlertDialog.Builder of style AppCompatAlertDialogStyle
        AlertDialog.Builder builder =
                new AlertDialog.Builder(Util.getActivity(), R.style.AppCompatAlertDialogStyle);
        // set title of builder with title param
        builder.setTitle(title);
        // set message of builder message param
        builder.setMessage(message);
        // set positive button of builder
        builder.setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (tag) {
                    case "photo":
                        ((MainActivity)getActivity()).takePhoto();
                        break;
                    default:
                        break;
                }

            }
        });

        builder.setNegativeButton(negativeButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (tag.equals("photo")) {
                    ((MainActivity)getActivity()).pickPhoto();
                }
            }
        });
        // set negative button of builder with negativeButtonText param
        builder.setNeutralButton(neutralButtonText, null);
        // show builder
        builder.show();

    }

    /**
     * Function to open link of article in browser
     */
    public static void openUrlInBrowser(String url) {
        getActivity().startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse(url)));

    }


    /**
     * Function to open Google Maps with address populated
     *
     * @param address - address that is added to Uri for intent
     */
    public static void navigationIntent(String address) {


            // Create a Uri from an intent string. Use the result to create an Intent.
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + address);

            // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            // Make the Intent explicit by setting the Google Maps package
            mapIntent.setPackage("com.google.android.apps.maps");

            // Attempt to start an activity that can handle the Intent
            if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
                activity.startActivity(mapIntent);
            }
        }

    /**
     * Function to make a call with an intent
     *
     * @param number - number to call
     */
    public static void callIntent(String number) {
        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri call = Uri.parse("tel:" + number);
        // Create an Intent. Set the action to ACTION_CALL and send uri
        Intent intent = new Intent(Intent.ACTION_CALL, call);

        // Attempt to start an activity that can handle the Intent
        if (intent.resolveActivity(context.getPackageManager()) != null) {

                activity.startActivity(intent);

        } else {
            // Show message: "No phone clients installed."
            Toast.makeText(context, "No phone clients installed.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public static void share(String link) {
        // instanitiate targetedShareIntents
        List<Intent> targetedShareIntents = new ArrayList<>();
        // instanitiate shareIntent and set the action to ACTION_SEND
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        // set type of shareIntent to text/plain
        shareIntent.setType("text/plain");
        // instanitiate resInfo and set it to the phone's packages managers intent activities
        List<ResolveInfo> resInfo = activity.getPackageManager()
                .queryIntentActivities(shareIntent, 0);
        // if resInfo is not empty
        if (!resInfo.isEmpty()) {
            // loop through each item in resInfo
            for (ResolveInfo resolveInfo : resInfo) {
                // assign resolveInfo.activityInfo.packageName to packageName
                String packageName = resolveInfo.activityInfo.packageName;
                // instanitiate targetedShareIntent and set the action to ACTION_SEND
                Intent targetedShareIntent = new Intent(Intent.ACTION_SEND);
                // set type of targetedShareIntent to text/plain
                targetedShareIntent.setType("text/plain");
                // add subject line to intent
                targetedShareIntent.putExtra(Intent.EXTRA_SUBJECT, "Bagels N Greens");
                // if textUtils is equals to facebook
                if (TextUtils.equals(packageName, "com.facebook.katana")) {
                    // add to intent the link
                    targetedShareIntent.putExtra(Intent.EXTRA_TEXT, link);
                } else {
                    // add to intent the link
                    targetedShareIntent.putExtra(Intent.EXTRA_TEXT, link);
                }
                // set package of targetedShareIntent to packageName
                targetedShareIntent.setPackage(packageName);
                // add targetedShareIntent
                targetedShareIntents.add(targetedShareIntent);
            }
            // instanitiate chooserIntent and assign to it a list of app to choose from with
            // the title "Select app to share"
            Intent chooserIntent = Intent.createChooser(targetedShareIntents.remove(0),
                    "Select app to share");
            // add EXTRA_INITIAL_INTENTS tp chooserIntent and get item from array
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS,
                    targetedShareIntents.toArray(new Parcelable[]{}));
            // start chooserIntent
            activity.startActivity(chooserIntent);
        }
    }






}

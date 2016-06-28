package com.example.home.bngapp.utilities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.home.bngapp.R;
import com.example.home.bngapp.activities.MainActivity;

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


}

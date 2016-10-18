package com.jasonbutwell.cardlayoutdemo;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);

        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {

            @Override
            public void onLayoutInflated(WatchViewStub stub) {

                // For the card we need the fragment manager

                FragmentManager fragmentManager = getFragmentManager();

                // Set up the transaction

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Creation of the card fragment

                CardFragment cardFragment = CardFragment.create(
                        getString(R.string.cftitle),                        //  card title
                        getString(R.string.cfdesc),                         //  card description
                        android.R.drawable.ic_menu_add);                   //   card icon

                // Add the layout and commit to the fragment

                fragmentTransaction.add(R.id.frame_layout, cardFragment);
                fragmentTransaction.commit();
            }

        });
    }
}

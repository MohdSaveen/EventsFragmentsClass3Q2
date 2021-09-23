package com.example.eventsfragmentsclass3q2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.nfc.Tag;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicationListener {

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        AttachFragment();

    }

    private void AttachFragment() {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        EventDetailsFragments eventDetailsFragments=new EventDetailsFragments();
        transaction.add(R.id.container,eventDetailsFragments,"event").commit();
    }


    @Override
    public void launchFragments(Bundle bundle, String tag) {
        if(tag.equals("event")) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            TimeAndDateDetailsFragment timeAndDateDetailsFragment = new TimeAndDateDetailsFragment();
            timeAndDateDetailsFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.container, timeAndDateDetailsFragment, "time").commit();
        }
        else if(tag.equals("time")) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            PriceDetailsFragment priceDetailsFragment=new PriceDetailsFragment();
            priceDetailsFragment.setArguments(bundle);
            transaction.replace(R.id.container,priceDetailsFragment,"price").commit();
        }
    }
}
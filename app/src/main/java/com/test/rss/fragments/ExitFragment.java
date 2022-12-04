package com.test.rss.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.test.rss.R;

public class ExitFragment extends androidx.fragment.app.Fragment {


    public ExitFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        Snackbar.make(getLayoutInflater().inflate(R.layout.fragment_exit, container, false).findViewById(R.id.snackbar_ll), "App will exit after 3 Seconds", Snackbar.LENGTH_LONG).show();
//        Snackbar snackbar = Snackbar.make(getLayoutInflater().inflate(R.layout.fragment_exit, container, false).findViewById(R.id.snackbar_ll), "Snackbar test", Snackbar.LENGTH_SHORT);
//        View sbView = snackbar.getView();
//        TextView textView = (TextView) sbView.findViewById(R.id.snackbar_text);
//        textView.setTextColor(Color.YELLOW);
//        snackbar.show();


        Snackbar snackBar = Snackbar.make(getActivity().findViewById(android.R.id.content), "App will exit", Snackbar.LENGTH_LONG);
        View sbView = snackBar.getView();
        TextView textView = (TextView) sbView.findViewById(R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackBar.show();

        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                //do what you want
                getActivity().finish();


            }
        }, 3000);

        return inflater.inflate(R.layout.fragment_exit, container, false);
    }

}





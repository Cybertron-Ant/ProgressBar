package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// for progress bar
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar; //  instanciate 'ProgressBar' widget
    private int progressBarStatus = 0; // integer variable used to track the progress

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
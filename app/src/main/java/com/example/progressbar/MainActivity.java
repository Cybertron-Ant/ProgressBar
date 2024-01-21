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

        // find ProgressBar widget in layout by ID, assign to progressBar variable
        progressBar = findViewById(R.id.progressBar);

        // Handler is with the main (UI) thread, used to post actions back to the main thread
        final Handler handler = new Handler(Looper.getMainLooper());

    }// end method 'onCreate'
}// end class 'MainActivity'
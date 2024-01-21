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

        //
        new Thread(new Runnable() {
            // 'Runnable' interface should be implemented by any class whose instances are intended to be executed by a thread
            // The class must define a method of no arguments called 'run'.
            @Override
            public void run() {
                // 'run' method runs in a background thread

                while (progressBarStatus < 100) {
                    // increment 'progressBarStatus'
                    progressBarStatus += 1;

                    // update progress bar on the main (UI) thread using the handler
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressBarStatus);
                        }
                    });

                    try {
                        // delay to slow down progress increment
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start(); // end increment progress bar

    }// end method 'onCreate'
}// end class 'MainActivity'
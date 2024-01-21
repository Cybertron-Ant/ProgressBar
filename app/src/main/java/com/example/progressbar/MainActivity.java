package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// for progress bar
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar; //  instanciate 'ProgressBar' widget
    private TextView percentageTextView; // instanciate 'TextView' widget
    private int progressBarStatus = 0; // integer variable used to track the progress

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find ProgressBar widget in layout by ID, assign to progressBar variable
        progressBar = findViewById(R.id.progressBar);

        // assign TextView with ID to 'percentageTextView' variable
        percentageTextView = findViewById(R.id.percentagetv);

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

                            // update percentageTextView with 'progressBarStatus' percentage value
                            percentageTextView.setText(new StringBuilder().append(progressBarStatus).append("%").toString());
                        }// end nested method 'run'
                    });

                    try {
                        // delay to slow down progress increment
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }// end CATCH
                }// end WHILE
            }// end method 'run'
        }).start(); // end increment progress bar 'Thread'

    }// end method 'onCreate'
}// end class 'MainActivity'
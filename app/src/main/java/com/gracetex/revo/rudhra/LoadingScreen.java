package com.gracetex.revo.rudhra;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;


public class LoadingScreen extends AppCompatActivity {

    private final int WAIT_TIME = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Typeface custom_font2 = Typeface.createFromAsset(getAssets(),  "fonts/OdinBold.otf");
        Typeface custom_font7 = Typeface.createFromAsset(getAssets(),  "fonts/SR.otf");
        setContentView(R.layout.content_loading_screen);

        TextView tvLoad = (TextView) findViewById(R.id.tvLoad);
        tvLoad.setTypeface(custom_font7);
        final ProgressBar pgr = (ProgressBar) findViewById(R.id.progressBar);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    pgr.setProgress(100);
                    Thread.sleep(500);
                    pgr.setProgress(25);
                    Thread.sleep(500);
                    pgr.setProgress(25);
                    Thread.sleep(500);
                    pgr.setProgress(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent main = new Intent(LoadingScreen.this, GraphView.class);
                LoadingScreen.this.startActivity(main);
                LoadingScreen.this.finish();
            }
        }, WAIT_TIME);

    }

}

package com.augmentis.ayp.atm_model_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;

/**
 * Created by Theerawuth on 10/25/2016.
 */

public class Splash extends Activity {
    Handler handler;
    Runnable runnable;
    long delay_time;
    long time = 3000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splashscreen);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                Log.d("Splassh", "on splashscreen");
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        delay_time = time;
        handler.postDelayed(runnable, delay_time);
        time = System.currentTimeMillis();
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
        time = delay_time - (System.currentTimeMillis() - time);
    }
}

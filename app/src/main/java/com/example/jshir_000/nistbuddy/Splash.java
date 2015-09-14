package com.example.jshir_000.nistbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by jshir_000 on 9/5/2015.
 */
public class Splash extends Activity {
    /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
    private final int SPLASH_DISPLAY_LENGTH = 5000;

    private TextView textView1;
    private TextView textView2;
        /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splashscreen);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        //progressBar.getIndeterminateDrawable().setColorFilter(
        //        getResources().getColor(R.color.ColorPrimary),
        //        android.graphics.PorterDuff.Mode.SRC_IN);
        //progressBar.setProgress(50);


        textView1.startAnimation(AnimationUtils.loadAnimation(Splash.this,android.R.anim.slide_in_left ));
        textView2.startAnimation(AnimationUtils.loadAnimation(Splash.this, android.R.anim.slide_in_left));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(mainIntent);

                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

}

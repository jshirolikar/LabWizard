package com.example.jshir_000.nistbuddy;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;


/**
 * Created by jshir_000 on 9/11/2015.
 */
public class HelpActivity extends Activity {

    private TextView textView1;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        textView1 =  (TextView) findViewById(R.id.textView1);
        textView1.setMovementMethod(new ScrollingMovementMethod());

    }
}

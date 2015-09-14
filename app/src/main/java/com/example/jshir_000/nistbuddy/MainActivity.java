package com.example.jshir_000.nistbuddy;

import android.app.Activity;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.GridView;
import android.widget.Toast;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button thermocouple_coeffs_button = (Button) findViewById(R.id.thermocouple_coeffs_button);
        thermocouple_coeffs_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ThermocoupleCoeffsActivity.class);
                startActivity(i);
            }

        });

        Button atomic_weights_button = (Button) findViewById(R.id.atomic_weights_button);
        atomic_weights_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), AtomicWeightsActivity.class);
                startActivity(i);
            }

        });

        Button ionization_energies_button = (Button) findViewById(R.id.ionization_energies_button);
        ionization_energies_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), IonizationEnergiesActivity.class);
                startActivity(i);
            }

        });

        Button constants_button = (Button) findViewById(R.id.constants_button);
        constants_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), constantsButtonActivity.class);
                startActivity(i);
            }

        });

        Button cccbd_button = (Button) findViewById(R.id.CCCBD_button);
        cccbd_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), CCCBDActivity.class);
                startActivity(i);
            }

        });

        Button thermocouple_voltages_button = (Button) findViewById(R.id.thermocouple_voltages_button);
        thermocouple_voltages_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), ThermocoupleVoltagesActivity.class);
                startActivity(i);
            }

        });

        Button news_button = (Button) findViewById(R.id.help_button);
        news_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), HelpActivity.class);
                startActivity(i);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
        Handle action bar item clicks here. The action bar will
        automatically handle clicks on the Home/Up button, so long
        as you specify a parent activity in AndroidManifest.xml.
        */
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

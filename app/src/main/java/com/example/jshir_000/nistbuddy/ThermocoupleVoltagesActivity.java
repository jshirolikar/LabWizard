package com.example.jshir_000.nistbuddy;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ThermocoupleVoltagesActivity extends Activity {

    private Spinner spinner1;
    private RadioButton radioButton1;
    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;
    private NumberPicker numberPicker4;
    private NumberPicker numberPicker5;
    private String FirebasePath;
    private TextView textView2;
    private CheckBox checkbox1;
    private Integer temperatureInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_thermocouple_voltages);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        numberPicker1 = (NumberPicker) findViewById(R.id.numberPicker);
        numberPicker2 = (NumberPicker) findViewById(R.id.numberPicker2);
        numberPicker3 = (NumberPicker) findViewById(R.id.numberPicker3);
        numberPicker4 = (NumberPicker) findViewById(R.id.numberPicker4);
        checkbox1 = (CheckBox) findViewById(R.id.checkbox);

        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(1);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(9);
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(9);
        numberPicker4.setMinValue(0);
        numberPicker4.setMaxValue(9);


        FirebasePath = "https://nist-buddy3.firebaseio.com/voltages";


        textView2 = (TextView) findViewById(R.id.textView2);
        List list = new ArrayList();

        list.add("Type B");
        list.add("Type E");
        list.add("Type J");
        list.add("Type K");
        list.add("Type N");
        list.add("Type R");
        list.add("Type S");
        list.add("Type T");


        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
        spinner1.setOnItemSelectedListener(new onThermocoupleCoeffsItemSelectedListener() {

            public void onItemSelected(AdapterView parent, View view, int pos, long id) {

                textView2.setText("");


                switch (pos) {
                    case 0:

                        FirebasePath = "https://nist-buddy3.firebaseio.com/voltages/typeB";
                        break;

                    case 1:

                        FirebasePath = "https://nist-buddy3.firebaseio.com/voltages/typeE";
                        break;

                    case 2:

                        FirebasePath = "https://nist-buddy3.firebaseio.com/voltages/typeJ";
                        break;

                    case 3:

                        FirebasePath = "https://nist-buddy3.firebaseio.com/voltages/typeK";
                        break;

                    case 4:

                        FirebasePath = "https://nist-buddy3.firebaseio.com/voltages/typeN";
                        break;

                    case 5:

                        FirebasePath = "https://nist-buddy3.firebaseio.com/voltages/typeR";
                        break;

                    case 6:

                        FirebasePath = "https://nist-buddy3.firebaseio.com/voltages/typeS";
                        break;

                    case 7:

                        FirebasePath = "https://nist-buddy3.firebaseio.com/voltages/typeT";
                        break;

                }

                String prefix_temp;
                if (checkbox1.isChecked()) {
                    prefix_temp = "-";
                } else {
                    prefix_temp = "";
                }


                String temperature = prefix_temp + numberPicker1.getValue() + numberPicker2.getValue() + numberPicker3.getValue() + "0";

                temperatureInt = Integer.valueOf(temperature);

                Firebase ref = new Firebase(FirebasePath);


                Query queryRef = ref.orderByChild("FIELD1").equalTo((Integer.valueOf(temperatureInt)));
                Query queryRef2 = ref.orderByChild("FIELD1").equalTo((Integer.valueOf(temperatureInt)).toString());

                queryRef.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot snapshot, String previousChild) {


                        Map<String, Object> outputarray = (Map) snapshot.getValue();

                        textView2.setText("");
                        textView2.setMovementMethod(new ScrollingMovementMethod());

                        for (Map.Entry<String, Object> entry : outputarray.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();

                            System.out.println(key);
                            System.out.println(value);

                            System.out.println("XFIELD" + (numberPicker4.getValue() + 1));

                            if(key.equals("FIELD" + (numberPicker4.getValue() + 2))) {
                                textView2.append("Thermoelectric voltage=\n" + value.toString() + " mV");
                                textView2.append("\n");
                            }

                        }

                    }


                    public void onChildRemoved(DataSnapshot snapshot) {

                    }

                    public void onChildChanged(DataSnapshot snapshot, String s) {

                    }

                    public void onChildMoved(DataSnapshot snapshot, String s) {

                    }

                    public void onCancelled(FirebaseError error) {

                    }


                });

                queryRef2.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot snapshot, String previousChild) {


                        Map<String, Object> outputarray = (Map) snapshot.getValue();

                        textView2.setText("");
                        textView2.setMovementMethod(new ScrollingMovementMethod());

                        for (Map.Entry<String, Object> entry : outputarray.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();



                            if(key.equals("FIELD" + (numberPicker4.getValue() + 2))) {
                                textView2.append("Thermoelectric voltage=\n" + value.toString() + " mV");
                                textView2.append("\n");
                            }

                        }

                    }


                    public void onChildRemoved(DataSnapshot snapshot) {

                    }

                    public void onChildChanged(DataSnapshot snapshot, String s) {

                    }

                    public void onChildMoved(DataSnapshot snapshot, String s) {

                    }

                    public void onCancelled(FirebaseError error) {

                    }


                });

            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_thermocouple_voltages, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

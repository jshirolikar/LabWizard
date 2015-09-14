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
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import org.json.JSONStringer;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ThermocoupleCoeffsActivity extends Activity {

    private Spinner spinner1;
    private TextView textView2;
    private TextView textView3;
    private CheckBox checkBox1;
    private String FirebasePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_thermocouple_coeffs);

        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        checkBox1 = (CheckBox)findViewById(R.id.checkBoxInverse);
        FirebasePath = "https://nist-buddy3.firebaseio.com/";




        List list = new ArrayList();

        list.add("Type B");
        list.add("Type E");
        list.add("Type J");
        list.add("Type K");
        list.add("Type N");
        list.add("Type R");
        list.add("Type S");
        list.add("Type T");




        ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner1.setAdapter(dataAdapter);



            spinner1.setOnItemSelectedListener(new onThermocoupleCoeffsItemSelectedListener() {

        public void onItemSelected(AdapterView parent, View view, int pos, long id) {


            System.out.println(pos);

            String lookupstring = "none";


            switch (pos) {
                case 0:
                    lookupstring = "B";
                    break;

                case 1:
                    lookupstring = "E";
                    break;

                case 2:
                    lookupstring = "J";
                    break;

                case 3:
                    lookupstring = "K";
                    break;

                case 4:
                    lookupstring = "N";
                    break;

                case 5:
                    lookupstring = "R";
                    break;

                case 6:
                    lookupstring = "S";
                    break;

                case 7:
                    lookupstring = "T";
                    break;

            }



            if(checkBox1.isChecked()){
                FirebasePath = "https://nist-buddy3.firebaseio.com/inverse/";
            }else
            {
                FirebasePath = "https://nist-buddy3.firebaseio.com/";
            }


            Firebase ref = new Firebase(FirebasePath);


            Query queryRef = ref.orderByChild("thermocouple type").equalTo(lookupstring);

            queryRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot snapshot, String previousChild) {


                    Map<String, Object> outputarray = (Map) snapshot.getValue();

                    textView2.setText("");
                    textView2.setMovementMethod(new ScrollingMovementMethod());
                    textView3.setText("");
                    textView3.setMovementMethod(new ScrollingMovementMethod());


                    for (Map.Entry<String, Object> entry : outputarray.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();

                       if(key != "data") {

                            textView2.append(key + "=" + value.toString());
                            textView2.append("\n");
                       }
                       if(key == "data") {
                           ArrayList valuelist = (ArrayList) value;

                           for(int i = 0; i<valuelist.size(); i++){
                               Map<String, Object> valuearray = (Map) valuelist.get(i);

                               for(Map.Entry<String, Object> entry2 : valuearray.entrySet()){
                                   String key2 = entry2.getKey();
                                   Object value2 = entry2.getValue();
                                   textView3.append(key2 + "=" + value2.toString());
                                   textView3.append("\n");
                               }
                               textView3.append("\n");

                           }




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


    }


    );




}




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_thermocouple_coeffs, menu);
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

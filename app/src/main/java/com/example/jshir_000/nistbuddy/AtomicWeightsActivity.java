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

public class AtomicWeightsActivity extends Activity {

    private Spinner spinner1;
    private String FirebasePath;
    private TextView textView2;
    private TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_atomic_weights);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView4 = (TextView)findViewById(R.id.textView4);
        FirebasePath = "https://nist-buddy.firebaseio.com/atomic weights/data/";

        List list = new ArrayList();

        list.add("Ac - Actinium");
        list.add("Ag - Silver");
        list.add("Al - Aluminium");
        list.add("Am - Americium");
        list.add("Ar - Argon");
        list.add("As - Arsenic");
        list.add("At - Astatine");
        list.add("Au - Gold");
        list.add("B - Boron");
        list.add("Ba - Barium");
        list.add("Be - Beryllium");
        list.add("Bh - Bohrium");
        list.add("Bi - Bismuth");
        list.add("Bk - Berkelium");
        list.add("Br - Bromine");
        list.add("C	- Carbon");
        list.add("Ca - Calcium");
        list.add("Cd - Cadmium");
        list.add("Ce - Cerium");
        list.add("Cf - Californium");
        list.add("Cl - Chlorine");
        list.add("Cm - Curium");
        list.add("Cn - Copernicium");
        list.add("Co - Cobalt");
        list.add("Cr - Chromium");
        list.add("Cs - Caesium");
        list.add("Cu - Copper");
        list.add("Db - Dubnium");
        list.add("Ds - Darmstadtium");
        list.add("Dy - Dysprosium");
        list.add("Er - Erbium");
        list.add("Es - Einsteinium");
        list.add("Eu - Europium");
        list.add("F	- Fluorine");
        list.add("Fe - Iron");
        list.add("Fl - Flerovium");
        list.add("Fm - Fermium");
        list.add("Fr - Francium");
        list.add("Ga - Gallium");
        list.add("Gd - Gadolinium");
        list.add("Ge - Germanium");
        list.add("H	- Hydrogen");
        list.add("He - Helium");
        list.add("Hf - Hafnium");
        list.add("Hg - Mercury");
        list.add("Ho - Holmium");
        list.add("Hs - Hassium");
        list.add("I	- Iodine");
        list.add("In - Indium");
        list.add("Ir -Iridium");
        list.add("K	- Potassium");
        list.add("Kr - Krypton");
        list.add("La - Lanthanum");
        list.add("Li - Lithium");
        list.add("Lr - Lawrencium");
        list.add("Lu - Lutetium");
        list.add("Lv - Livermorium");
        list.add("Md - Mendelevium");
        list.add("Mg - Magnesium");
        list.add("Mn - Manganese");
        list.add("Mo - Molybdenum");
        list.add("Mt - Meitnerium");
        list.add("N	- Nitrogen");
        list.add("Na - Sodium");
        list.add("Nb - Niobium");
        list.add("Nd - Neodymium");
        list.add("Ne - Neon");
        list.add("Ni - Nickel");
        list.add("No - Nobelium");
        list.add("Np - Neptunium");
        list.add("O	- Oxygen");
        list.add("Os - Osmium");
        list.add("P - Phosphorus");
        list.add("Pa - Protactinium");
        list.add("Pb - Lead");
        list.add("Pd - Palladium");
        list.add("Pm - Promethium");
        list.add("Po - Polonium");
        list.add("Pr - Praseodymium");
        list.add("Pt - Platinum");
        list.add("Pu - Plutonium");
        list.add("Ra - Radium");
        list.add("Rb - Rubidium");
        list.add("Re - Rhenium");
        list.add("Rf - Rutherfordium");
        list.add("Rg - Roentgenium");
        list.add("Rh - Rhodium");
        list.add("Rn - Radon");
        list.add("Ru - Ruthenium");
        list.add("S	- Sulfur");
        list.add("Sb - Antimony");
        list.add("Sc - Scandium");
        list.add("Se - Selenium");
        list.add("Sg - Seaborgium");
        list.add("Si - Silicon");
        list.add("Sm - Samarium");
        list.add("Sr - Strontium");
        list.add("Ta - Tantalum");
        list.add("Tb - Terbium");
        list.add("Tc - Technetium");
        list.add("Te - Tellurium");
        list.add("Th - Thorium");
        list.add("Ti - Titanium");
        list.add("Tl - Thallium");
        list.add("Tm - Thulium");
        list.add("U	- Uranium");
        list.add("Uuo - Ununoctium");
        list.add("Uup -	Ununpentium");
        list.add("Uus - Ununseptium");
        list.add("Uut - Ununtrium");
        list.add("V	- Vanadium");
        list.add("W	- Tungsten");
        list.add("Xe - Xenon");
        list.add("Y - Yttrium");
        list.add("Yb - Ytterbium");
        list.add("Zn - Zinc");
        list.add("Zr - Zirconium");



        ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner1.setAdapter(dataAdapter);

        spinner1.setOnItemSelectedListener(new onThermocoupleCoeffsItemSelectedListener() {

                                               public void onItemSelected(AdapterView parent, View view, int pos, long id) {


                                                   System.out.println(pos);

                                                   String lookupstring = "none";


                                                   switch (pos) {
                                                       case 0:
                                                           lookupstring = "Ac";
                                                           break;

                                                       case 1:
                                                           lookupstring = "Ag";
                                                           break;

                                                       case 2:
                                                           lookupstring = "Al";
                                                           break;

                                                       case 3:
                                                           lookupstring = "Am";
                                                           break;
                                                       case 4:
                                                           lookupstring = "Ar";
                                                           break;

                                                       case 5:
                                                           lookupstring = "As";
                                                           break;
                                                       case 6:
                                                           lookupstring = "At";
                                                           break;

                                                       case 7:
                                                           lookupstring = "Au";
                                                           break;

                                                       case 8:
                                                           lookupstring = "B";
                                                           break;
                                                       case 9:
                                                           lookupstring = "Ba";
                                                           break;
                                                       case 10:
                                                           lookupstring = "Be";
                                                           break;
                                                       case 11:
                                                           lookupstring = "Bh";
                                                           break;
                                                       case 12:
                                                           lookupstring = "Bi";
                                                           break;
                                                       case 13:
                                                           lookupstring = "Bk";
                                                           break;
                                                       case 14:
                                                           lookupstring = "Br";
                                                           break;

                                                       case 15:
                                                           lookupstring = "C";
                                                           break;
                                                       case 16:
                                                           lookupstring = "Ca";
                                                           break;
                                                       case 17:
                                                           lookupstring = "Cd";
                                                           break;
                                                       case 18:
                                                           lookupstring = "Ce";
                                                           break;
                                                       case 19:
                                                           lookupstring = "Cf";
                                                           break;
                                                       case 20:
                                                           lookupstring = "Cl";
                                                           break;
                                                       case 21:
                                                           lookupstring = "Cm";
                                                           break;
                                                       case 22:
                                                           lookupstring = "Cn";
                                                           break;
                                                       case 23:
                                                           lookupstring = "Co";
                                                           break;
                                                       case 24:
                                                           lookupstring = "Cr";
                                                           break;
                                                       case 25:
                                                           lookupstring = "Cs";
                                                           break;
                                                       case 26:
                                                           lookupstring = "Cu";
                                                           break;
                                                       case 27:
                                                           lookupstring = "Db";
                                                           break;
                                                       case 28:
                                                           lookupstring = "Ds";
                                                           break;
                                                       case 29:
                                                           lookupstring = "Dy";
                                                           break;
                                                       case 30:
                                                           lookupstring = "Er";
                                                           break;
                                                       case 31:
                                                           lookupstring = "Es";
                                                           break;
                                                       case 32:
                                                           lookupstring = "Eu";
                                                           break;
                                                       case 33:
                                                           lookupstring = "F";
                                                           break;
                                                       case 34:
                                                           lookupstring = "Fe";
                                                           break;

                                                       case 35:
                                                           lookupstring = "Fl";
                                                           break;
                                                       case 36:
                                                           lookupstring = "Fm";
                                                           break;
                                                       case 37:
                                                           lookupstring = "Fr";
                                                           break;

                                                       case 38:
                                                           lookupstring = "Ga";
                                                           break;
                                                       case 39:
                                                           lookupstring = "Gd";
                                                           break;
                                                       case 40:
                                                           lookupstring = "Ge";
                                                           break;
                                                       case 41:
                                                           lookupstring = "H";
                                                           break;
                                                       case 42:
                                                           lookupstring = "He";
                                                           break;
                                                       case 43:
                                                           lookupstring = "Hf";
                                                           break;
                                                       case 44:
                                                           lookupstring = "Hg";
                                                           break;

                                                       case 45:
                                                           lookupstring = "Ho";
                                                           break;
                                                       case 46:
                                                           lookupstring = "Hs";
                                                           break;
                                                       case 47:
                                                           lookupstring = "I";
                                                           break;
                                                       case 48:
                                                           lookupstring = "In";
                                                           break;
                                                       case 49:
                                                           lookupstring = "Ir";
                                                           break;
                                                       case 50:
                                                           lookupstring = "K";
                                                           break;
                                                       case 51:
                                                           lookupstring = "Kr";
                                                           break;
                                                       case 52:
                                                           lookupstring = "La";
                                                           break;
                                                       case 53:
                                                           lookupstring = "Li";
                                                           break;
                                                       case 54:
                                                           lookupstring = "Lr";
                                                           break;

                                                       case 55:
                                                           lookupstring = "Lu";
                                                           break;
                                                       case 56:
                                                           lookupstring = "Lv";
                                                           break;
                                                       case 57:
                                                           lookupstring = "Md";
                                                           break;
                                                       case 58:
                                                           lookupstring = "Mg";
                                                           break;
                                                       case 59:
                                                           lookupstring = "Mn";
                                                           break;
                                                       case 60:
                                                           lookupstring = "Mo";
                                                           break;
                                                       case 61:
                                                           lookupstring = "Mt";
                                                           break;
                                                       case 62:
                                                           lookupstring = "N";
                                                           break;
                                                       case 63:
                                                           lookupstring = "Na";
                                                           break;
                                                       case 64:
                                                           lookupstring = "Nb";
                                                           break;

                                                       case 65:
                                                           lookupstring = "Nd";
                                                           break;
                                                       case 66:
                                                           lookupstring = "Ne";
                                                           break;
                                                       case 67:
                                                           lookupstring = "Ni";
                                                           break;
                                                       case 68:
                                                           lookupstring = "No";
                                                           break;
                                                       case 69:
                                                           lookupstring = "Np";
                                                           break;
                                                       case 70:
                                                           lookupstring = "O";
                                                           break;
                                                       case 71:
                                                           lookupstring = "Os";
                                                           break;
                                                       case 72:
                                                           lookupstring = "P";
                                                           break;
                                                       case 73:
                                                           lookupstring = "Pa";
                                                           break;
                                                       case 74:
                                                           lookupstring = "Pb";
                                                           break;

                                                       case 75:
                                                           lookupstring = "Pd";
                                                           break;
                                                       case 76:
                                                           lookupstring = "Pm";
                                                           break;
                                                       case 77:
                                                           lookupstring = "Po";
                                                           break;
                                                       case 78:
                                                           lookupstring = "Pr";
                                                           break;
                                                       case 79:
                                                           lookupstring = "Pt";
                                                           break;
                                                       case 80:
                                                           lookupstring = "Pu";
                                                           break;
                                                       case 81:
                                                           lookupstring = "Ra";
                                                           break;
                                                       case 82:
                                                           lookupstring = "Rb";
                                                           break;
                                                       case 83:
                                                           lookupstring = "Re";
                                                           break;
                                                       case 84:
                                                           lookupstring = "Rf";
                                                           break;

                                                       case 85:
                                                           lookupstring = "Rg";
                                                           break;
                                                       case 86:
                                                           lookupstring = "Rh";
                                                           break;
                                                       case 87:
                                                           lookupstring = "Rn";
                                                           break;
                                                       case 88:
                                                           lookupstring = "Ru";
                                                           break;
                                                       case 89:
                                                           lookupstring = "S";
                                                           break;
                                                       case 90:
                                                           lookupstring = "Sb";
                                                           break;
                                                       case 91:
                                                           lookupstring = "Sc";
                                                           break;

                                                       case 92:
                                                           lookupstring = "Se";
                                                           break;

                                                       case 93:
                                                           lookupstring = "Sg";
                                                           break;
                                                       case 94:
                                                           lookupstring = "Si";
                                                           break;
                                                       case 95:
                                                           lookupstring = "Sm";
                                                           break;


                                                       case 96:
                                                           lookupstring = "Sr";
                                                           break;
                                                       case 97:
                                                           lookupstring = "Ta";
                                                           break;

                                                       case 98:
                                                           lookupstring = "Tb";
                                                           break;
                                                       case 99:
                                                           lookupstring = "Tc";
                                                           break;
                                                       case 100:
                                                           lookupstring = "Te";
                                                           break;
                                                       case 101:
                                                           lookupstring = "Th";
                                                           break;
                                                       case 102:
                                                           lookupstring = "Ti";
                                                           break;
                                                       case 103:
                                                           lookupstring = "Tl";
                                                           break;
                                                       case 104:
                                                           lookupstring = "Tm";
                                                           break;
                                                       case 105:
                                                           lookupstring = "U";
                                                           break;
                                                       case 106:
                                                           lookupstring = "Uuo";
                                                           break;
                                                       case 107:
                                                           lookupstring = "Uup";
                                                           break;

                                                       case 108:
                                                           lookupstring = "Uus";
                                                           break;
                                                       case 109:
                                                           lookupstring = "Uut";
                                                           break;
                                                       case 110:
                                                           lookupstring = "V";
                                                           break;
                                                       case 111:
                                                           lookupstring = "W";
                                                           break;
                                                       case 112:
                                                           lookupstring = "Xe";
                                                           break;
                                                       case 113:
                                                           lookupstring = "Y";
                                                           break;
                                                       case 114:
                                                           lookupstring = "Yb";
                                                           break;
                                                       case 115:
                                                           lookupstring = "Zn";
                                                           break;
                                                       case 116:
                                                           lookupstring = "Zr";
                                                           break;

                                                   }




                                                   Firebase ref = new Firebase(FirebasePath);


                                                   Query queryRef = ref.orderByChild("Atomic Symbol").equalTo(lookupstring);

                                                   queryRef.addChildEventListener(new ChildEventListener() {
                                                       @Override
                                                       public void onChildAdded(DataSnapshot snapshot, String previousChild) {

                                                           Map<String, Object> outputarray = (Map) snapshot.getValue();

                                                           textView2.setText("");
                                                           textView2.setMovementMethod(new ScrollingMovementMethod());
                                                           textView4.setText("");
                                                           textView4.setMovementMethod(new ScrollingMovementMethod());


                                                           for (Map.Entry<String, Object> entry : outputarray.entrySet()) {
                                                               String key = entry.getKey();
                                                               Object value = entry.getValue();

                                                               if(key != "isotopes") {
                                                                   textView2.append(key + "=" + value.toString());
                                                                   textView2.append("\n");
                                                               }
                                                               if(key == "isotopes"){

                                                                   int i;
                                                                   ArrayList isotopelist = (ArrayList)value;

                                                                   textView4.append("Atomic Symbol, Relative Atomic Mass, Mass Number, Isotopic composition\n\n");


                                                                   for (i=0; i < isotopelist.size() ; i++){
                                                                       System.out.println(isotopelist.get(i));

                                                                       Map<String, String> atomicarray = (Map) isotopelist.get(i);
                                                                       String temp = "";
                                                                       for (Map.Entry<String, String> entry2 : atomicarray.entrySet()){
                                                                           String key2 = entry2.getKey();
                                                                           String value2 = entry2.getValue();

                                                                           if(key2 != "Isotopic Composition") {
                                                                               textView4.append(value2.toString() + ", ");
                                                                           }
                                                                           if (key2 == "Isotopic Composition") {

                                                                               temp = value2;
                                                                           }
                                                                       }
                                                                       textView4.append(temp + "\n");


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
        getMenuInflater().inflate(R.menu.menu_atomic_weights, menu);
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

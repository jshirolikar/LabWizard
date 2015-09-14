package com.example.jshir_000.nistbuddy;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IonizationEnergiesActivity extends Activity {

    private Spinner spinner1;
    private String FirebasePath;
    private TextView textView2;
    private TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_ionization_energies);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView4 = (TextView)findViewById(R.id.textView4);
        FirebasePath = "https://nist-buddy.firebaseio.com/ionization energies/ionization energies data/";

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
                                                           lookupstring = "Actinium";
                                                           break;

                                                       case 1:
                                                           lookupstring = "Silver";
                                                           break;

                                                       case 2:
                                                           lookupstring = "Alumimium";
                                                           break;

                                                       case 3:
                                                           lookupstring = "Americium";
                                                           break;
                                                       case 4:
                                                           lookupstring = "Argon";
                                                           break;

                                                       case 5:
                                                           lookupstring = "Arsenic";
                                                           break;
                                                       case 6:
                                                           lookupstring = "Astatine";
                                                           break;

                                                       case 7:
                                                           lookupstring = "Gold";
                                                           break;

                                                       case 8:
                                                           lookupstring = "Boron";
                                                           break;
                                                       case 9:
                                                           lookupstring = "Barium";
                                                           break;
                                                       case 10:
                                                           lookupstring = "Beryllium";
                                                           break;
                                                       case 11:
                                                           lookupstring = "Bohrium";
                                                           break;
                                                       case 12:
                                                           lookupstring = "Bismuth";
                                                           break;
                                                       case 13:
                                                           lookupstring = "Berkelium";
                                                           break;
                                                       case 14:
                                                           lookupstring = "Bromine";
                                                           break;

                                                       case 15:
                                                           lookupstring = "Carbon";
                                                           break;
                                                       case 16:
                                                           lookupstring = "Calcium";
                                                           break;
                                                       case 17:
                                                           lookupstring = "Cadmium";
                                                           break;
                                                       case 18:
                                                           lookupstring = "Cerium";
                                                           break;
                                                       case 19:
                                                           lookupstring = "Californium";
                                                           break;
                                                       case 20:
                                                           lookupstring = "Chlorine";
                                                           break;
                                                       case 21:
                                                           lookupstring = "Curium";
                                                           break;
                                                       case 22:
                                                           lookupstring = "Copernicium";
                                                           break;
                                                       case 23:
                                                           lookupstring = "Cobalt";
                                                           break;
                                                       case 24:
                                                           lookupstring = "Chromium";
                                                           break;
                                                       case 25:
                                                           lookupstring = "Caesium";
                                                           break;
                                                       case 26:
                                                           lookupstring = "Copper";
                                                           break;
                                                       case 27:
                                                           lookupstring = "Dubnium";
                                                           break;
                                                       case 28:
                                                           lookupstring = "Darmstadtium";
                                                           break;
                                                       case 29:
                                                           lookupstring = "Dysprosium";
                                                           break;
                                                       case 30:
                                                           lookupstring = "Erbium";
                                                           break;
                                                       case 31:
                                                           lookupstring = "Einsteinium";
                                                           break;
                                                       case 32:
                                                           lookupstring = "Europium";
                                                           break;
                                                       case 33:
                                                           lookupstring = "Fluorine";
                                                           break;
                                                       case 34:
                                                           lookupstring = "Iron";
                                                           break;

                                                       case 35:
                                                           lookupstring = "Flerovium";
                                                           break;
                                                       case 36:
                                                           lookupstring = "Fermium";
                                                           break;
                                                       case 37:
                                                           lookupstring = "Francium";
                                                           break;

                                                       case 38:
                                                           lookupstring = "Gallium";
                                                           break;
                                                       case 39:
                                                           lookupstring = "Gadolinium";
                                                           break;
                                                       case 40:
                                                           lookupstring = "Germanium";
                                                           break;
                                                       case 41:
                                                           lookupstring = "Hydrogen";
                                                           break;
                                                       case 42:
                                                           lookupstring = "Helium";
                                                           break;
                                                       case 43:
                                                           lookupstring = "Hafnium";
                                                           break;
                                                       case 44:
                                                           lookupstring = "Mercury";
                                                           break;

                                                       case 45:
                                                           lookupstring = "Holmium";
                                                           break;
                                                       case 46:
                                                           lookupstring = "Hassium";
                                                           break;
                                                       case 47:
                                                           lookupstring = "Iodine";
                                                           break;
                                                       case 48:
                                                           lookupstring = "Indium";
                                                           break;
                                                       case 49:
                                                           lookupstring = "Iridium";
                                                           break;
                                                       case 50:
                                                           lookupstring = "Potassium";
                                                           break;
                                                       case 51:
                                                           lookupstring = "Krypton";
                                                           break;
                                                       case 52:
                                                           lookupstring = "Lanthanum";
                                                           break;
                                                       case 53:
                                                           lookupstring = "Lithium";
                                                           break;
                                                       case 54:
                                                           lookupstring = "Lawrencium";
                                                           break;

                                                       case 55:
                                                           lookupstring = "Lutetium";
                                                           break;
                                                       case 56:
                                                           lookupstring = "Livermorium";
                                                           break;
                                                       case 57:
                                                           lookupstring = "Mendelevium";
                                                           break;
                                                       case 58:
                                                           lookupstring = "Magnesium";
                                                           break;
                                                       case 59:
                                                           lookupstring = "Manganese";
                                                           break;
                                                       case 60:
                                                           lookupstring = "Molybdenum";
                                                           break;
                                                       case 61:
                                                           lookupstring = "Meitnerium";
                                                           break;
                                                       case 62:
                                                           lookupstring = "Nitrogen";
                                                           break;
                                                       case 63:
                                                           lookupstring = "Sodium";
                                                           break;
                                                       case 64:
                                                           lookupstring = "Niobium";
                                                           break;

                                                       case 65:
                                                           lookupstring = "Neodymium";
                                                           break;
                                                       case 66:
                                                           lookupstring = "Neon";
                                                           break;
                                                       case 67:
                                                           lookupstring = "Nickel";
                                                           break;
                                                       case 68:
                                                           lookupstring = "Nobelium";
                                                           break;
                                                       case 69:
                                                           lookupstring = "Neptunium";
                                                           break;
                                                       case 70:
                                                           lookupstring = "Oxygen";
                                                           break;
                                                       case 71:
                                                           lookupstring = "Osmium";
                                                           break;
                                                       case 72:
                                                           lookupstring = "Phosphorus";
                                                           break;
                                                       case 73:
                                                           lookupstring = "Protactinium";
                                                           break;
                                                       case 74:
                                                           lookupstring = "Lead";
                                                           break;

                                                       case 75:
                                                           lookupstring = "Palladium";
                                                           break;
                                                       case 76:
                                                           lookupstring = "Promethium";
                                                           break;
                                                       case 77:
                                                           lookupstring = "Polonium";
                                                           break;
                                                       case 78:
                                                           lookupstring = "Praseodymium";
                                                           break;
                                                       case 79:
                                                           lookupstring = "Platinum";
                                                           break;
                                                       case 80:
                                                           lookupstring = "Plutonium";
                                                           break;
                                                       case 81:
                                                           lookupstring = "Radium";
                                                           break;
                                                       case 82:
                                                           lookupstring = "Rubidium";
                                                           break;
                                                       case 83:
                                                           lookupstring = "Rhenium";
                                                           break;
                                                       case 84:
                                                           lookupstring = "Rutherfordium";
                                                           break;

                                                       case 85:
                                                           lookupstring = "Roentgenium";
                                                           break;
                                                       case 86:
                                                           lookupstring = "Rhodium";
                                                           break;
                                                       case 87:
                                                           lookupstring = "Radon";
                                                           break;
                                                       case 88:
                                                           lookupstring = "Ruthenium";
                                                           break;
                                                       case 89:
                                                           lookupstring = "Sulfur";
                                                           break;
                                                       case 90:
                                                           lookupstring = "Antimony";
                                                           break;
                                                       case 91:
                                                           lookupstring = "Scandium";
                                                           break;

                                                       case 92:
                                                           lookupstring = "Selenium";
                                                           break;

                                                       case 93:
                                                           lookupstring = "Seaborgium";
                                                           break;
                                                       case 94:
                                                           lookupstring = "Silicon";
                                                           break;
                                                       case 95:
                                                           lookupstring = "Samarium";
                                                           break;


                                                       case 96:
                                                           lookupstring = "Strontium";
                                                           break;
                                                       case 97:
                                                           lookupstring = "Tantalum";
                                                           break;

                                                       case 98:
                                                           lookupstring = "Terbium";
                                                           break;
                                                       case 99:
                                                           lookupstring = "Technetium";
                                                           break;
                                                       case 100:
                                                           lookupstring = "Tellurium";
                                                           break;
                                                       case 101:
                                                           lookupstring = "Thorium";
                                                           break;
                                                       case 102:
                                                           lookupstring = "Titanium";
                                                           break;
                                                       case 103:
                                                           lookupstring = "Thallium";
                                                           break;
                                                       case 104:
                                                           lookupstring = "Thulium";
                                                           break;
                                                       case 105:
                                                           lookupstring = "Uranium";
                                                           break;
                                                       case 106:
                                                           lookupstring = "Ununoctium";
                                                           break;
                                                       case 107:
                                                           lookupstring = "Ununpentium";
                                                           break;

                                                       case 108:
                                                           lookupstring = "Ununseptium";
                                                           break;
                                                       case 109:
                                                           lookupstring = "Ununtrium";
                                                           break;
                                                       case 110:
                                                           lookupstring = "Vanadium";
                                                           break;
                                                       case 111:
                                                           lookupstring = "Tungsten";
                                                           break;
                                                       case 112:
                                                           lookupstring = "Xenon";
                                                           break;
                                                       case 113:
                                                           lookupstring = "Yttrium";
                                                           break;
                                                       case 114:
                                                           lookupstring = "Ytterbium";
                                                           break;
                                                       case 115:
                                                           lookupstring = "Zinc";
                                                           break;
                                                       case 116:
                                                           lookupstring = "Zirconium";
                                                           break;

                                                   }




                                                   Firebase ref = new Firebase(FirebasePath);


                                                   Query queryRef = ref.orderByChild("Element Name").equalTo(lookupstring);

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

                                                               if(key != "ReferencesURL") {
                                                                   textView2.append(key + "=" + value.toString());
                                                                   textView2.append("\n");
                                                               }
                                                               if (key == "ReferencesURL") {

                                                                   ArrayList urllist = (ArrayList)value;

                                                                   for (int i=0; i<urllist.size();i++){
                                                                       String urltxt = urllist.get(i).toString();

                                                                       textView4.append("\"" + urltxt + "\"" );
                                                                       textView4.setMovementMethod(LinkMovementMethod.getInstance());
                                                                       textView4.append("\n");

                                                                   }



                                                               }
                                                           }

                                                           System.out.println(outputarray);
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

package com.exemple.loginexemple;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.exemple.loginexemple.Model.Data;
import com.exemple.loginexemple.Model.JsonParser;
import com.rengwuxian.materialedittext.MaterialAutoCompleteTextView;

public class ActivityFormulaire extends AppCompatActivity {

    Context ctx;

    TextInputLayout age,info;
    AutoCompleteTextView nom,prenom;
    int idNom=-1,idPrenom=-2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_formulaire);

        ctx = getApplicationContext();

        nom = (AutoCompleteTextView)findViewById(R.id.nom);
        prenom = (AutoCompleteTextView)findViewById(R.id.prenom);
        age = (TextInputLayout)findViewById(R.id.age);
        info = (TextInputLayout)findViewById(R.id.info);


        ArrayAdapter<String> adapterNom = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,JsonParser.ListNom(ctx));

        nom.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                nom.showDropDown();
                return false;
            }


        });
        nom.setAdapter(adapterNom);
        nom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                idNom = arg2;
                Toast.makeText(getApplicationContext(), (CharSequence) arg0.getItemAtPosition(arg2) + "/" + idNom, Toast.LENGTH_LONG).show();
                if (idPrenom==idNom){
                    Data dataItem=JsonParser.dataItem(ctx, idNom);
                    age.getEditText().setText(dataItem.getAge());
                    info.getEditText().setText(dataItem.getInfo());
                }else{
                    age.getEditText().setText("");
                    info.getEditText().setText("");
                }
            }
        });




        ArrayAdapter<String> adapterPrenom = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, JsonParser.ListPrenom(ctx));
        prenom.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                prenom.showDropDown();
                return false;
            }


        });

        prenom.setAdapter(adapterPrenom);
        prenom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                idPrenom=arg2;
                Toast.makeText(getApplicationContext(), (CharSequence)arg0.getItemAtPosition(arg2)+"/"+idPrenom, Toast.LENGTH_LONG).show();
                if (idPrenom==idNom){
                    Data dataItem=JsonParser.dataItem(ctx, idNom);
                    age.getEditText().setText(dataItem.getAge());
                    info.getEditText().setText(dataItem.getInfo());
                }else{
                    age.getEditText().setText("");
                    info.getEditText().setText("");
                }
            }
        });


    }

}

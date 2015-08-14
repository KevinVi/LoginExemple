package com.exemple.loginexemple;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends Activity {

    private static String USERPSEUDO="key_for_userpseudo";
    private static String USERPASSWORD="key_for_password";

    Button login ;
    TextInputLayout pseudo,password;
    CheckBox check;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        login = (Button)findViewById(R.id.login);
        pseudo = (TextInputLayout)findViewById(R.id.pseudo);
        password = (TextInputLayout)findViewById(R.id.password);
        check = (CheckBox)findViewById(R.id.checkBox);

        prefs = getSharedPreferences("codelearn_twitter", MODE_PRIVATE);
        String userPseudo = prefs.getString(USERPSEUDO,null);
        String userPassword = prefs.getString(USERPASSWORD,null);

        if (userPassword != null && userPassword != null){
            pseudo.getEditText().setText(userPseudo);
            password.getEditText().setText(userPassword);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pseudo.getEditText().length()>1 && password.getEditText().length()>1){
                    if(check.isChecked()){
                        String userPseudo = pseudo.getEditText().getText().toString();
                        String userPassword = password.getEditText().getText().toString();

                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString(USERPSEUDO,userPseudo);
                        editor.putString(USERPASSWORD,userPassword);
                        editor.commit();
                    }
                    Intent i = new Intent(MainActivity.this,ActivityFormulaire.class);
                    startActivity(i);
                }
            }
        });
    }


}

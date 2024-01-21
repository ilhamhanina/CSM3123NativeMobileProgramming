package com.example.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3;

    Button clear, save, get;

    public static final String myPref= "myPref";

    public static final String nameKey= "nameKey";

    public static final String phoneKey= "phoneKey";

    public static final String emailKey= "emailKey";

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.edittext);
        ed2 = findViewById(R.id.edittext2);
        ed3 = findViewById(R.id.edittext3);

        clear = findViewById(R.id.button3);
        save = findViewById(R.id.button);
        get = findViewById(R.id.button2);

        sp = getSharedPreferences(myPref, Context.MODE_PRIVATE);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(MainActivity.this, "Share Preference is deleted", Toast.LENGTH_LONG).show();
            }
        });

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = ed1.getText().toString();
                String phone = ed2.getText().toString();
                String email = ed3.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString(nameKey, name);
                editor.putString(phoneKey, phone);
                editor.putString(emailKey, email);
                editor.commit();
                Toast.makeText(MainActivity.this, "Data saved into shared preference", Toast.LENGTH_LONG).show();
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sp.getAll().isEmpty()){
                    Toast.makeText(MainActivity.this, "Shared Preference is empty", Toast.LENGTH_LONG).show();
                }else{
                    String name = sp.getString(nameKey, "");
                    String phone = sp.getString(phoneKey, "");
                    String email = sp.getString(emailKey, "");

                    ed1.setText(name.toString());
                    ed2.setText(phone.toString());
                    ed3.setText(email.toString());
                }
            }
        });


    }
}
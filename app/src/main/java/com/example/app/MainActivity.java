package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button btnWelcomeLogin,btnWelcomeRegister;
    public void init(){

        btnWelcomeLogin=(Button) findViewById(R.id.buttonWelcomeLogin);
        btnWelcomeRegister= (Button) findViewById(R.id.buttonWelcomeRegister);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnWelcomeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentLogin = new Intent(MainActivity.this, loginActivity.class);
                startActivity(intentLogin);
                finish();
            }
        });

        btnWelcomeRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intentRegister);
                finish();
            }
        });




    }


}

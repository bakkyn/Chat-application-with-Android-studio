package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {

    private Toolbar actionbarlogin;
    private EditText txtEmail, txtPassword;
    private Button btnLogin, btnregisterlogin;
    private FirebaseAuth auth;
    private FirebaseUser currentUser;

    public void  init(){
        actionbarlogin= (Toolbar) findViewById(R.id.actionBarLogin);
        setSupportActionBar(actionbarlogin);
        getSupportActionBar().setTitle("Giriş yap");

        auth= FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();


        txtEmail = (EditText) findViewById(R.id.txtemaillogin);
        txtPassword = (EditText) findViewById(R.id.txtpasswordLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnregisterlogin= (Button) findViewById(R.id.btnRegisterLogin);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }


        });
        btnregisterlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegisterActivity();
            }
        });
    }

    private void goToRegisterActivity() {
        Intent registerIntent = new Intent(loginActivity.this, RegisterActivity.class );
        startActivity(registerIntent);
        finish();

    }


    private void loginUser() {

        String email= txtEmail.getText().toString();
        String password= txtPassword.getText().toString();

        if(TextUtils.isEmpty(email)){

            Toast.makeText(this, "Email alanı boş olamaz", Toast.LENGTH_SHORT).show();

        }

        else if(TextUtils.isEmpty(password)){

            Toast.makeText(this, "Şifre alanı boş olamaz", Toast.LENGTH_SHORT).show();
        }

        else {


            btnLogin.setEnabled(false);

            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){

                        Toast.makeText(loginActivity.this, "Giriş başarılı", Toast.LENGTH_SHORT).show();
                        Intent mainIntent = new Intent (loginActivity.this , Main2Activity.class);
                        startActivity(mainIntent);
                        finish();
                    }


                    else
                        Toast.makeText(loginActivity.this, "Giriş başarısız", Toast.LENGTH_SHORT).show();

                        btnLogin.setEnabled(true);
                }
            });


        }

    }
}

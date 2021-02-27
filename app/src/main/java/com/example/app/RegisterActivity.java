package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseUser;


public class RegisterActivity extends AppCompatActivity {

    private Toolbar actionbarRegister;
    private EditText txtUserName, txtEmail, txtPassword;
    private Button btnRegister, btnLoginRegister;

    private FirebaseAuth mAuth;





    public void  init() {

        actionbarRegister=(Toolbar) findViewById(R.id.action_barRegister);
        setSupportActionBar(actionbarRegister);
        getSupportActionBar().setTitle("Hesap oluştur");




        txtUserName=(EditText) findViewById(R.id.txtusername);
        txtEmail=(EditText) findViewById(R.id.txtemail);
        txtPassword=(EditText) findViewById(R.id.txtpassword);
        btnRegister= (Button)  findViewById(R.id.btnregister);

        btnLoginRegister= (Button)  findViewById(R.id.btnloginregister);




    }

    private void createNewAccount() {

        final String username = txtUserName.getText().toString();
        final String email= txtEmail.getText().toString();
        final String password= txtPassword.getText().toString();

        if(TextUtils.isEmpty(email)){

            Toast.makeText(this, "Email alanı boş olamaz", Toast.LENGTH_SHORT).show();

        }
        else if (TextUtils.isEmpty(password)){

            Toast.makeText(this, "Şifre alanı boş olamaz", Toast.LENGTH_SHORT).show();
        }

        else{

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(  @NonNull Task task) {

                            if (task.isSuccessful()){
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(getApplicationContext(),loginActivity.class);
                                intent.putExtra("name",username);
                                intent.putExtra("mail",email);
                                intent.putExtra("password",password);
                                startActivity(intent);
                                Toast.makeText(RegisterActivity.this, "HEsabınız oluştuurldu", Toast.LENGTH_SHORT).show();
                                finish();

                            }
                            else  {

                                    Toast.makeText(RegisterActivity.this, "HATA", Toast.LENGTH_SHORT).show();


                                }
                            }
                        }

            );






        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth= FirebaseAuth.getInstance();
        init();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewAccount();
            }
        });


        btnLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                goToLoginActivity();
            }


        });

    }

    private void goToLoginActivity() {

        Intent loginIntent = new Intent (RegisterActivity.this, loginActivity.class);
        startActivity(loginIntent);
        finish();

    }
}

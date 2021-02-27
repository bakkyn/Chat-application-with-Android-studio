package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {

    private Toolbar actionbar;
    private ViewPager vpMain;
    private TabLayout tabsMain;
    private TabsAdapter tabsAdapter;
         private    DatabaseReference reference;
    private FirebaseAuth auth;
    private FirebaseUser currentUser;



    public void init(){
        actionbar= (Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(actionbar);
        getSupportActionBar().setTitle(R.string.app_name);

        vpMain=(ViewPager) findViewById(R.id.vpmain);
        tabsAdapter = new TabsAdapter(getSupportFragmentManager());
        vpMain.setAdapter(tabsAdapter);
        auth = FirebaseAuth.getInstance();
        currentUser= auth.getCurrentUser();
        tabsMain= (TabLayout) findViewById(R.id.tabsMain);
        tabsMain.setupWithViewPager(vpMain);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        reference = FirebaseDatabase.getInstance().getReference("User").child(currentUser.getUid());


    }

    @Override
    protected void onStart() {

        if(currentUser == null){

            Intent welcomeIntent = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(welcomeIntent);
            finish();

        }

        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);

         getMenuInflater().inflate(R.menu.menu_main , menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.mainLogout ){

            auth.signOut();
            Intent loginIntent = new Intent( Main2Activity.this, loginActivity.class);
            startActivity(loginIntent);
            finish();



        }

         return true;

    }
}


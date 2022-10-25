package com.carlosketer.teafarmerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class DashboardActivity extends AppCompatActivity {
    private CardView loanCard ,toolCard;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        loanCard = findViewById(R.id.loanCard);
        toolCard = findViewById(R.id.toolsCard);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        Button logoutBtn = findViewById(R.id.logout);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                FirebaseUtil.attachListener();
                            }
                        });
                FirebaseUtil.detachListener();*/
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater  = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
//        MenuItem ocsMenu = menu.findItem(R.id.reported_cases);
//        MenuItem initives = menu.findItem(R.id.nav_initive);
//        if (FirebaseUtil.isAdmin){
//            ocsMenu.setVisible(true);
//            initives.setVisible(true);
//        }else {
//            ocsMenu.setVisible(false);
//            initives.setVisible(false);
//        }


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
//            case R.id.logout_menu:{
////                AuthUI.getInstance()
////                        .signOut(this)
////                        .addOnCompleteListener(new OnCompleteListener<Void>() {
////                            public void onComplete(@NonNull Task<Void> task) {
////                                FirebaseUtil.attachListener();
////                            }
////                        });
////                FirebaseUtil.detachListener();
//                return true;
//            }
            case R.id.settings:{
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            }

            case R.id.help: {
                Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.admin: {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
                return true;
            }

            case R.id.rate: {

            }
            case R.id.support: {
                startActivity(new Intent(this, SupportActivity.class));
                return true;
            }


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
     //   FirebaseUtil.detachListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
       // FirebaseUtil.attachListener();
    }
}
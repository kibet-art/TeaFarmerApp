package com.carlosketer.teafarmerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoanApplicationActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    EditText txtName,txtLocation,txtAmount,txtPhone,txtSacco;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_application);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("loandeals");
        txtName = findViewById(R.id.name);
        txtAmount = findViewById(R.id.amount);
        txtLocation = findViewById(R.id.location);
        txtPhone = findViewById(R.id.phone);
        txtSacco = findViewById(R.id.sacco);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitLoanApplication();

            }
        });

        Button saccoBtn = findViewById(R.id.saccoBtn);
        saccoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(LoanApplicationActivity.this,v);
                popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) LoanApplicationActivity.this);
                popupMenu.inflate(R.menu.sacco_menu);
                popupMenu.show();
            }
        });

    }

    private void submitLoanApplication() {
        String amount = txtAmount.getText().toString();
        String phone = txtPhone.getText().toString();
        String sacco = txtSacco.getText().toString();
        String name = txtName.getText().toString();
        String location = txtLocation.getText().toString();

        if (TextUtils.isEmpty(amount)){
            Toast.makeText(this, "Please enter the amount", Toast.LENGTH_SHORT).show();
        }else  if (TextUtils.isEmpty(phone)){
            Toast.makeText(this, "Please enter the phone no: for account", Toast.LENGTH_SHORT).show();
        }else  if (TextUtils.isEmpty(sacco)){
            Toast.makeText(this, "Please select your sacco", Toast.LENGTH_SHORT).show();
        }else  if (TextUtils.isEmpty(name)){
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
        }else  if (TextUtils.isEmpty(location)){
            Toast.makeText(this, "Please select your location of residence", Toast.LENGTH_SHORT).show();
        }else {
            LoanDeal deal = new LoanDeal(amount, phone, sacco, name, location);
            mDatabaseReference.push().setValue(deal);
            clean();
        }
    }
    private void clean() {
        txtAmount.setText("");
        txtPhone.setText("");
        txtSacco.setText("");
        txtName.setText("");
        txtLocation.setText("");
        txtSacco.requestFocus();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tawalla:
                txtSacco.setText("Tawala sacco");
                return true;
            case R.id.women:
                txtSacco.setText("Women sacco");
                return true;
            case R.id.majani:
                txtSacco.setText("Majani Bora");
                return true;
            case R.id.county:
                txtSacco.setText("County tea association");
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
package com.carlosketer.teafarmerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EquipmentAppActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    EditText txtquantity,txtbags,txtsize,txtquantityKg,txtpairs,txtcounty,txttown, txtsacco,txtphone,txtid,txtname;
    private Button countyBtn, quantityBtn,basketBtn,fertilizerquantityBtn,gumbootBtn,gumbootSizeBtn ;
    private FirebaseDatabase mFirebaseDatabase;
    private ImageView teabagsImg,fertilizersImg,gumbootImg;
    private DatabaseReference mDatabaseReference;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_app);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("tooldeals");
        txtquantityKg = findViewById(R.id.quantityKg);
        txtbags = findViewById(R.id.bags);
        txtpairs = findViewById(R.id.pairs);
        txtsize = findViewById(R.id.size);
        txttown = findViewById(R.id.location);
        txtsacco = findViewById(R.id.sacco);
        txtphone = findViewById(R.id.phone);
        txtid = findViewById(R.id.id);
        txtname = findViewById(R.id.name);
        txtcounty = findViewById(R.id.araea);
        submit = findViewById(R.id.submitNow);
        fertilizersImg = findViewById(R.id.teaToolImg);

        //btns
        quantityBtn = findViewById(R.id.quantityBtn);
        basketBtn =findViewById(R.id.basketsBtn);
        gumbootBtn = findViewById(R.id.gumbootPairBtn);
        gumbootSizeBtn = findViewById(R.id.GumbootSizeBtn);
        fertilizerquantityBtn = findViewById(R.id.fertilizerquantityBtn);



        txtquantityKg.setVisibility(View.GONE);
        txtbags.setVisibility(View.GONE);
        txtsize.setVisibility(View.GONE);
        txtpairs.setVisibility(View.GONE);
        txtsacco.setVisibility(View.GONE);
        txttown.setVisibility(View.GONE);
        txtphone.setVisibility(View.GONE);
        txtid.setVisibility(View.GONE);
        txtname.setVisibility(View.GONE);
        txtcounty.setVisibility(View.GONE);
        basketBtn.setVisibility(View.GONE);
        gumbootBtn.setVisibility(View.GONE);
        gumbootSizeBtn.setVisibility(View.GONE);
        quantityBtn.setVisibility(View.GONE);
        submit.setVisibility(View.GONE);
        fertilizerquantityBtn.setVisibility(View.GONE);




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitLoanApplication();
            }
        });

        quantityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(EquipmentAppActivity.this,v);
                popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) EquipmentAppActivity.this);
                popupMenu.inflate(R.menu.basket_quantity);
                popupMenu.show();
            }
        });

        ImageView teabag = findViewById(R.id.teabags);
        ImageView teatool = findViewById(R.id.teaToolImg);
        ImageView teaMachine = findViewById(R.id.teaMachine);
        countyBtn = findViewById(R.id.countyList);
        countyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(EquipmentAppActivity.this,v);
                    popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) EquipmentAppActivity.this);
                popupMenu.inflate(R.menu.county);
                popupMenu.show();
            }
        });

        fertilizersImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtquantityKg.setVisibility(View.VISIBLE);
                txtbags.setVisibility(View.GONE);
                txtsize.setVisibility(View.GONE);
                txtpairs.setVisibility(View.GONE);

                txtsacco.setVisibility(View.VISIBLE);
                txttown.setVisibility(View.VISIBLE);
                txtphone.setVisibility(View.VISIBLE);
                txtid.setVisibility(View.VISIBLE);
                submit.setVisibility(View.VISIBLE);
                txtname.setVisibility(View.VISIBLE);
                txtcounty.setVisibility(View.VISIBLE);
                fertilizerquantityBtn.setVisibility(View.VISIBLE);
            }
        });

        teabag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtsize.setVisibility(View.GONE);
                txtquantityKg.setVisibility(View.GONE);
                txtpairs.setVisibility(View.GONE);
                txtbags.setVisibility(View.VISIBLE);
                txtsacco.setVisibility(View.VISIBLE);
                txttown.setVisibility(View.VISIBLE);
                submit.setVisibility(View.VISIBLE);
                txtphone.setVisibility(View.VISIBLE);
                txtid.setVisibility(View.VISIBLE);
                txtname.setVisibility(View.VISIBLE);
                txtcounty.setVisibility(View.VISIBLE);
                basketBtn.setVisibility(View.VISIBLE);

            }
        });
        teaMachine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtquantityKg.setVisibility(View.GONE);
                txtbags.setVisibility(View.GONE);
                txtsize.setVisibility(View.VISIBLE);
                txtpairs.setVisibility(View.VISIBLE);
                txtsacco.setVisibility(View.VISIBLE);
                txttown.setVisibility(View.VISIBLE);
                txtphone.setVisibility(View.VISIBLE);
                txtid.setVisibility(View.VISIBLE);
                submit.setVisibility(View.VISIBLE);
                txtname.setVisibility(View.VISIBLE);
                txtcounty.setVisibility(View.VISIBLE);
                gumbootBtn.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tenkg:
                txtquantity.setText("10kg");
                return true;
            case R.id.twentykg:
                txtquantityKg.setText("20kg");
                return true;
            case R.id.thirtykg:
                txtquantityKg.setText("30kg");
                return true;
            case R.id.fourtykg:
                txtquantityKg.setText("40kg");
                return true;
            case R.id.fiftykg:
                txtquantityKg.setText("50kg");
            case R.id.sixtykg:
                txtquantityKg.setText("60kg");
                return true;
            case R.id.ainamoi:
                txtcounty.setText("Ainamoi");
                return true;
            case R.id.belgut:
                txtcounty.setText("Belgut");
                return true;
            case R.id.buret:
                txtcounty.setText("Buret");
                return true;
            case R.id.kipkelion:
                txtcounty.setText("Kipkelion East");
                return true;
            case R.id.sigowet:
                txtcounty.setText("Sigowet-sion");
                return true;
            case R.id.kipkelion_west:
                txtcounty.setText("Kipkelion West");
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void submitLoanApplication() {
        String bags = txtbags.getText().toString();
        String size = txtsize.getText().toString();
        String quantityKg = txtquantityKg.getText().toString();
        String pairs = txtpairs.getText().toString();
        String county = txtcounty.getText().toString();
        String town = txttown.getText().toString();
        String sacco = txtsacco.getText().toString();
        String phone = txtphone.getText().toString();
        String id = txtid.getText().toString();
        String name = txtname.getText().toString();

       if (TextUtils.isEmpty(bags)){
            Toast.makeText(this, "Please enter bags no", Toast.LENGTH_SHORT).show();
        }else  if (TextUtils.isEmpty(size)){
            Toast.makeText(this, "Please select enter bag size", Toast.LENGTH_SHORT).show();
        }else  if (TextUtils.isEmpty(quantityKg)){
            Toast.makeText(this, "Please enter the quantity", Toast.LENGTH_SHORT).show();
        }else  if (TextUtils.isEmpty(county)){
            Toast.makeText(this, "Please enter your county", Toast.LENGTH_SHORT).show();
        }
        else  if (TextUtils.isEmpty(pairs)){
            Toast.makeText(this, "Please enter gumboots pair", Toast.LENGTH_SHORT).show();
        }else  if (TextUtils.isEmpty(town)){
            Toast.makeText(this, "Please enter your town", Toast.LENGTH_SHORT).show();
        }else  if (TextUtils.isEmpty(sacco)){
            Toast.makeText(this, "Please enter your sacco", Toast.LENGTH_SHORT).show();
        }else  if (TextUtils.isEmpty(phone)){
            Toast.makeText(this, "Please select your phone", Toast.LENGTH_SHORT).show();
        }
        else  if (TextUtils.isEmpty(id)){
            Toast.makeText(this, "Please enter your id", Toast.LENGTH_SHORT).show();
        }else  if (TextUtils.isEmpty(name)){
            Toast.makeText(this, "Please select your name", Toast.LENGTH_SHORT).show();
        }else {
            ToolsDeal deal = new ToolsDeal
                    (bags, size,quantityKg,pairs,town,sacco,phone,id,name,county);
            mDatabaseReference.push().setValue(deal);
            clean();
        }
    }
    private void clean() {
        txtbags.setText("");
        txtsize.setText("");
        txtquantityKg.setText("");
        txtpairs.setText("");
        txtcounty.setText("");
        txttown.setText("");
        txtsacco.setText("");
        txtphone.setText("");
        txtname.setText("");
        txtid.setText("");
        txtid.requestFocus();
    }

}
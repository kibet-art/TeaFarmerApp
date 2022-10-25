package com.carlosketer.teafarmerapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.carlosketer.teafarmerapp.R;


public class SupportActivity extends AppCompatActivity {
    private EditText mEditextTo,getmEditextSubject,getmEditextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_support);
        mEditextTo = findViewById(R.id.editTextTo);
        getmEditextSubject = findViewById(R.id.editTextSubject);
        getmEditextMessage = findViewById(R.id.editTextMessage);


        mEditextTo.setText("carlosketer@gmail.com");

        final Button send = findViewById(R.id.buttonSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void sendMail() {
        String recipientList =  mEditextTo.getText().toString();
        String[] recipients  =  recipientList.split(",");
        String  subject= getmEditextSubject.getText().toString();
        String message = getmEditextMessage.getText().toString();


        if(TextUtils.isEmpty(subject))
        {
            Toast.makeText(this, "Enter your subject", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(message)){
            Toast.makeText(this, "Please enter your feedback", Toast.LENGTH_SHORT).show();

        }else {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, recipients);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, message);
            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent,"Choose an email client,"));
        }

    }
}
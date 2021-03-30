package com.example.sujitassignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sms_to_another extends AppCompatActivity {
    private Button send;
    private EditText txtphone,txtmessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_to_another);
        setTitle("SMS");
        txtphone=findViewById(R.id.phone);
        txtmessage=findViewById(R.id.txtmsg);
        send=findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SmsManager smg= SmsManager.getDefault();
                    smg.sendTextMessage(txtphone.getText().toString(),null,txtmessage.getText().toString(),null,null);
                    Toast.makeText(getApplicationContext(),"SMS Sent Succesfully",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"SMS Failed to Send" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
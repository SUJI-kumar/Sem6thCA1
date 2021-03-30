package com.example.sujitassignmentone;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class alarm_showing extends AppCompatActivity {
    Button b1;
    EditText e1;
    JobInfo ji, jobInfo;
    JobScheduler js;
    NotificationManager nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_showing);
        nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setAlarm(View view){
        e1 = findViewById(R.id.alarm_edit_text);
        int t = Integer.parseInt(e1.getText().toString());

        Intent intent = new Intent(getApplicationContext(),Broadcastalarmreceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(),1, intent,0);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+ (t * 1000), pi);

        Toast.makeText(getApplicationContext(),"alarm set for "+t+" seconds from now",Toast.LENGTH_LONG).show();
        notChannel();
        js=(JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
        ComponentName cm=new ComponentName(this,NotificationForJobScheduler.class);
        JobInfo.Builder b=new JobInfo.Builder(1,cm);
        b.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        jobInfo=b.build();
        js.schedule(jobInfo);
    }
    public void cancelAlarm(View view){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(getApplicationContext(),Broadcastalarmreceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(),1, intent,0);
        alarmManager.cancel(pi);
        Toast.makeText(getApplicationContext(),"alarm cancelled",Toast.LENGTH_LONG).show();
    }
    public void notChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            String name = "TEST CHANNEL";
            String desc = "text not";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel = new NotificationChannel("1", name, importance);
            channel.setDescription(desc);

            nm.createNotificationChannel(channel);
        }
    }

}
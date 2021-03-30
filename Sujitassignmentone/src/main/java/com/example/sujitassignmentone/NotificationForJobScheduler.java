package com.example.sujitassignmentone;

import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class NotificationForJobScheduler extends JobService {
    NotificationManager nm;
    @Override
    public boolean onStartJob(JobParameters params) {
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder b = new NotificationCompat.Builder(this,"1");
        b.setContentTitle("New Notification");
        b.setContentText("This is remainder, wake up");
        b.setSmallIcon(R.drawable.icon);
        nm.notify(1,b.build());

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}

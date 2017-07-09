package com.example.kpn.notify;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String contenttext = "Hey I am watching notificarion videos"+"It is amazing";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void normal(View view)
    {
        //Build the content of notification
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this);
        builder.setContentTitle("Normal regular notification");
        builder.setContentText(contenttext);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("This is ticker");
        builder.setAutoCancel(true);

        //Provide intent for notification
        Intent i = new Intent(this,result.class);

        //Add back stack using taskbuilder
        android.support.v4.app.TaskStackBuilder stackBuilder = android.support.v4.app.TaskStackBuilder.create(this);
        stackBuilder.addParentStack(result.class);
        stackBuilder.addNextIntent(i);
        PendingIntent pi=stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pi);


        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(123,builder.build());

    }
}

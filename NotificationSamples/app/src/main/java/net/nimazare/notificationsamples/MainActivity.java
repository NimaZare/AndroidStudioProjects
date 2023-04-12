package net.nimazare.notificationsamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationManager notifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Button btnNotify1 = findViewById(R.id.btn_main_notify1);
        Button btnNotify2 = findViewById(R.id.btn_main_notify2);
        Button btnNotify3 = findViewById(R.id.btn_main_notify3);
        Button btnNotify4 = findViewById(R.id.btn_main_notify4);
        btnNotify1.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
            Notification notification = new NotificationCompat.Builder(this, "mynotifyapp")
                    .setSmallIcon(android.R.drawable.stat_notify_chat)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("My New Notify")
                    .setContentText("This is my first notification.")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .build();
            notifyManager.notify(new Random().nextInt(), notification);
        });

        btnNotify2.setOnClickListener(view -> {
            Notification notification2 = new NotificationCompat.Builder(this, "mynotifyapp")
                    .setSmallIcon(android.R.drawable.stat_notify_chat)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("My New Notify")
                    .setContentText("This is my first notification.")
                    .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.banner))
                            .setBigContentTitle("Big Image Banner"))
                    .setAutoCancel(true)
                    .build();
            notifyManager.notify(new Random().nextInt(), notification2);
        });

        btnNotify3.setOnClickListener(view -> {
            Notification notification3 = new NotificationCompat.Builder(this, "mynotifyapp")
                    .setSmallIcon(android.R.drawable.stat_notify_chat)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("My New Notify")
                    .setContentText("This is my first notification.")
                    .setStyle(new NotificationCompat.BigTextStyle().bigText("This is my first notification.This is my first notification.This is my first notification.This is my first notification.This is my first notification.This is my first notification."))
                    .setAutoCancel(true)
                    .build();
            notifyManager.notify(new Random().nextInt(), notification3);
        });

        btnNotify4.setOnClickListener(view -> {
            Notification notification4 = new NotificationCompat.Builder(this, "mynotifyapp")
                    .setSmallIcon(android.R.drawable.stat_notify_chat)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("My New Notify")
                    .setContentText("This is my first notification.")
                    .setStyle(new NotificationCompat.InboxStyle().addLine("Line 1 Text")
                            .addLine("Line 2 Text").addLine("Line 3 Text")
                            .addLine("Line 3 Text").addLine("Line 4 Text"))
                    .setAutoCancel(true)
                    .build();
            notifyManager.notify(new Random().nextInt(), notification4);
        });
    }
}
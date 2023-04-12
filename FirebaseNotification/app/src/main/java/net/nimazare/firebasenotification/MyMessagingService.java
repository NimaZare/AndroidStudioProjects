package net.nimazare.firebasenotification;

import android.app.Notification;
import android.app.NotificationManager;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
        if (message.getNotification() == null)
            return;

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this, "mynotifyapp")
                .setContentTitle(message.getNotification().getTitle())
                .setContentText(message.getNotification().getBody())
                .setSmallIcon(android.R.drawable.stat_notify_chat)
                .build();
        notificationManager.notify(1001, notification);
    }
}

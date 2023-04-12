package net.nimazare.firebasenotification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel notificationChannel = new NotificationChannel("mynotifyapp", "Default Channel", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("this notification channel used for test");
            if (notificationManager != null)
                notificationManager.createNotificationChannel(notificationChannel);

        }
    }
}

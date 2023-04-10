package net.nimazare.multithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(SimpleThread.TAG, "Thread name (" + Thread.currentThread().getName() + ")");
        SimpleThread simpleThread = new SimpleThread();
        simpleThread.start();
        Thread thread2 = new Thread(new SimpleRunnable());
        thread2.start();
        Thread thread3 = new Thread(() -> Log.i(SimpleThread.TAG, "Thread name (" + Thread.currentThread().getName() + ")"));
        thread3.start();
    }
}
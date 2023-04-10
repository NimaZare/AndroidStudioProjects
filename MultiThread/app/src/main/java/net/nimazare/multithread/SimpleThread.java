package net.nimazare.multithread;

import android.util.Log;

public class SimpleThread extends Thread {
    public static final String TAG = "SimpleThread";

    @Override
    public void run() {
        Log.i(TAG, "Thread name (" + Thread.currentThread().getName() + ")");
    }
}

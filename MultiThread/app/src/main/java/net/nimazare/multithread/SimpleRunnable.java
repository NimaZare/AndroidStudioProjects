package net.nimazare.multithread;

import android.util.Log;

public class SimpleRunnable implements Runnable {
    @Override
    public void run() {
        Log.i(SimpleThread.TAG, "Thread name (" + Thread.currentThread().getName() + ")");
    }
}

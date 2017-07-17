package com.example.practiceservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public void onCreate() {
        Log.d("--myservice","onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("--myservice","onStartCommand");


        return super.onStartCommand(intent, flags, startId);
    }
}

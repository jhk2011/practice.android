package com.example.practiceservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //startService(new Intent(this, MyService.class));
        //startService(new Intent(this, MyService.class));

        bindService(new Intent(this, MyService2.class), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d("--**mainactivity","onServiceConnected");
                MyService2 service = ((MyService2.MyBinder) iBinder).getService();
                service.test("");
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.d("--**mainactivity","onServiceDisconnected");
            }
        }, Context.BIND_AUTO_CREATE);
    }
}

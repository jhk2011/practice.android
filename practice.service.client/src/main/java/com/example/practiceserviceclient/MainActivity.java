package com.example.practiceserviceclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.practiceservice.IMyAidlInterface;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent("com.example.practiceservice.MyService3");

        intent.setPackage("com.example.practiceservice");

        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                IMyAidlInterface service = IMyAidlInterface.Stub.asInterface(iBinder);

                try {

                    int value = service.test(100,"200");
                    Log.d("--**",value+"");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

                Log.d("--**","onServiceConnected");
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, Context.BIND_AUTO_CREATE);
    }
}

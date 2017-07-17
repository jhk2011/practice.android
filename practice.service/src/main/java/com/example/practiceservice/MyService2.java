package com.example.practiceservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService2 extends Service {

    public class MyBinder extends Binder{
        public MyService2 getService(){
            return MyService2.this;
        }
    }

    MyBinder binder = new MyBinder();

    public MyService2() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("--**service2","onBind");
        return binder;
    }

    public int test(String s){
        return 0;
    }
}

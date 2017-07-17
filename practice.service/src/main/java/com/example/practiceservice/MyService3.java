package com.example.practiceservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;

public class MyService3 extends Service {



    IMyAidlInterface.Stub binder2 = new IMyAidlInterface.Stub() {
        @Override
        public int test(int i, String s) throws RemoteException {
            return i;
        }
    };

    public MyService3() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder2;
    }
}

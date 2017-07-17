package com.example.administrator.practicememory;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {


    private ArrayList<byte[]> list = new ArrayList<byte[]>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Runtime r = Runtime.getRuntime();

        long memory= r.maxMemory();

        Log.d("my",memory+"");

       long m= memory/1024/1024;


        Toast.makeText(this,"最大内存"+m,Toast.LENGTH_SHORT).show();

        int n=0;

        while (true){
            try {
                byte[] bytes = new byte[1024 * 1024];
                list.add(bytes);
                n++;
            }catch (OutOfMemoryError e){
                Toast.makeText(this,"实际分配最大内存"+n,Toast.LENGTH_SHORT).show();
                list.clear();
                break;
            }
        }



    }
}

package com.mango.dimen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void main(String[] args){

        String path = "D:\\ASWorkSpace\\DimensMake\\app\\src\\main\\res\\";
        DimenThread thread = new DimenThread();
        thread.setPath(path);
        new Thread(thread).start();
    }
}

package com.mango.dimen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mango.dimen.dp.DimenDPThread;
import com.mango.dimen.px.DimenPXThread;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void main(String[] args){

        String pathPX = "E:\\values-px\\";
        DimenPXThread threadPX = new DimenPXThread();
        threadPX.setPath(pathPX);
        new Thread(threadPX).start();

        String pathDP = "E:\\values-dp\\";
        DimenDPThread threadDP = new DimenDPThread();
        threadDP.setPath(pathDP);
        new Thread(threadDP).start();

    }
}

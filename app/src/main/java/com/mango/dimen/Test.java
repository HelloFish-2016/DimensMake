package com.mango.dimen;

import com.mango.dimen.dp.DimenDPThread;
import com.mango.dimen.px.DimenPXThread;

/**
 * Author: Mangoer
 * Time: 2019/1/5 11:45
 * Version:
 * Desc: TODO()
 */
public class Test {

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

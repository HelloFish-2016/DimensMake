package com.mango.dimen;

import com.mango.dimen.dp.DimenDPThread;
import com.mango.dimen.px.DimenPXThread;

/**
 * Author: Mangoer
 * Time: 2019/1/5 11:45
 * Version:
 * Desc: TODO(屏幕适配方案)
 */
public class DimensBuild {

    /**
     * 生成分辨率限定符dimens文件
     * path          默认E:\values-px\
     * 宽度基准分辨率 默认 720
     * 高度基准分辨率 默认 1280
     */
    public static void buildPX(){
        buildPX("",720,1280);
    }

    /**
     * 生成分辨率限定符dimens文件
     * @param path 文件存放路径
     * @param baseWidth 宽度基准分辨率
     * @param baseHeight 高度基准分辨率
     */
    public static void buildPX(String path,int baseWidth,int baseHeight){

        String pathPX ;
        if (path == null || "".equals(path)) {
            pathPX = "E:\\values-px\\";
        } else {
            pathPX = path;
        }
        if (baseWidth <= 0 || baseHeight <= 0) {
            baseWidth = 720;
            baseHeight = 1280;
        }

        DimenPXThread threadPX = new DimenPXThread();
        threadPX.setPath(pathPX);
        threadPX.setBasePX(baseWidth,baseHeight);
        new Thread(threadPX).start();

    }

    /**
     * 生成最小宽度限定符dimens文件
     * path          默认E:\values-dp\
     * baseDp基准dp值 默认360dp
     */
    public static void buildDP(){
        buildDP("",360);
    }

    /**
     * 生成最小宽度限定符dimens文件
     * @param path 文件存放路径
     * @param baseDp 基准dp值
     */
    public static void buildDP(String path,int baseDp){

        String pathDP ;
        if (path == null || "".equals(path)) {
            pathDP = "E:\\values-dp\\";
        } else {
            pathDP = path;
        }

        if (baseDp <= 0) {
            baseDp = 360;
        }
        DimenDPThread threadDP = new DimenDPThread();
        threadDP.setPath(pathDP);
        threadDP.setwBaseDp(baseDp);
        new Thread(threadDP).start();

    }

    public static void main(String[] args){
        buildPX();
        buildDP();
    }
}

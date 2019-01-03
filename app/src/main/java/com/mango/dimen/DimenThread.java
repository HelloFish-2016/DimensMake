package com.mango.dimen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * Author:Mangoer
 * Time:2019/1/3 21:04
 * Version:
 * Desc:TODO()
 */
public class DimenThread implements Runnable{

    private String path = "";

    private static List<String> dimenFile = new ArrayList<>();

    private static List<Dimens> dimensData = new ArrayList<>();

    static{
        dimenFile.add("values-800x480");
        dimenFile.add("values-854x480");
        dimenFile.add("values-960x540");
        dimenFile.add("values-1024x600");
        dimenFile.add("values-1024x768");
        dimenFile.add("values-1184x720");
        dimenFile.add("values-1196x720");
        dimenFile.add("values-1280x720");
        dimenFile.add("values-1280x768");
        dimenFile.add("values-1280x800");
        dimenFile.add("values-1776x1080");
        dimenFile.add("values-1794x1080");
        dimenFile.add("values-1812x1080");
        dimenFile.add("values-1920x1080");
        dimenFile.add("values-1920x1200");
        dimenFile.add("values-2016x1080");
        dimenFile.add("values-2040x1080");
        dimenFile.add("values-2160x1080");
        dimenFile.add("values-2560x1440");

        dimensData.add(new Dimens(480,800,720,1280));
        dimensData.add(new Dimens(480,854,720,1280));
        dimensData.add(new Dimens(540,960,720,1280));
        dimensData.add(new Dimens(600,1024,720,1280));
        dimensData.add(new Dimens(768,1024,720,1280));
        dimensData.add(new Dimens(720,1184,720,1280));
        dimensData.add(new Dimens(720,1196,720,1280));
        dimensData.add(new Dimens(720,1280,720,1280));
        dimensData.add(new Dimens(768,1280,720,1280));
        dimensData.add(new Dimens(800,1280,720,1280));
        dimensData.add(new Dimens(1080,1776,720,1280));
        dimensData.add(new Dimens(1080,1794,720,1280));
        dimensData.add(new Dimens(1080,1812,720,1280));
        dimensData.add(new Dimens(1080,1920,720,1280));
        dimensData.add(new Dimens(1200,1920,720,1280));
        dimensData.add(new Dimens(1080,2016,720,1280));
        dimensData.add(new Dimens(1080,2040,720,1280));
        dimensData.add(new Dimens(1080,2160,720,1280));
        dimensData.add(new Dimens(1440,2560,720,1280));

    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void run() {

        if("".equals(path)) return;

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<dimenFile.size(); i++){

            String parentName = path + dimenFile.get(i);
            File file = new File(parentName);
            if(!file.exists()){
                file.mkdirs();
            }

            /************************编写lay_x.xml文件*******************************/

            File lay_x = new File(file, "lay_x.xml");
            lay_x.delete();
            writeFile(lay_x, sb, dimensData.get(i),"x");

            /**************************编写lay_y.xml文件********************************/

            File lay_y = new File(file, "lay_y.xml");
            lay_y.delete();
            writeFile(lay_y, sb, dimensData.get(i),"y");

        }

    }

    private void writeFile(File lay,StringBuffer sb,Dimens dimens,String type){

        //切勿使用FileWriter写数据，它是默认使用ISO-8859-1 or gb2312，不是utf-8,并且没有setEncoding方法
        BufferedWriter fw = null;
        try {
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream (lay,true),"UTF-8"));

            fw.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>" +"\n");
            fw.write("<resources>" + "\n");

            int bound;
            if("x".equals(type)){
                bound = dimens.getxBase();
            }else{
                bound = dimens.getyBase();
            }

            for(int k=1; k<bound+1; k++){

                sb.setLength(0);
                sb.append("    <dimen name=\""+type+k+"\">");

                float px = 0.0f;
                if("x".equals(type)){
                    px = ((float)dimens.getxPX()/dimens.getxBase()) * k;
                }else{
                    px = ((float)dimens.getyPX()/dimens.getyBase()) * k;
                }

                sb.append(px+"px</dimen>" + "\n");
                fw.write(sb.toString());
            }
            fw.write("</resources>");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

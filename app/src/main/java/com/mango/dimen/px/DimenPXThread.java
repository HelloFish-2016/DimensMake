package com.mango.dimen.px;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Mangoer
 * Time: 2019/1/4 19:48
 * Version:
 * Desc:TODO()
 */
public class DimenPXThread implements Runnable{

    private String path ;
    private int baseWidth;
    private int baseHeight ;
    private static List<DimensPX> dimensData = new ArrayList<>();

    static{
        dimensData.add(new DimensPX(480,800));
        dimensData.add(new DimensPX(480,854));
        dimensData.add(new DimensPX(540,960));
        dimensData.add(new DimensPX(600,1024));
        dimensData.add(new DimensPX(768,1024));
        dimensData.add(new DimensPX(720,1184));
        dimensData.add(new DimensPX(720,1196));
        dimensData.add(new DimensPX(720,1280));
        dimensData.add(new DimensPX(768,1280));
        dimensData.add(new DimensPX(800,1280));
        dimensData.add(new DimensPX(1080,1776));
        dimensData.add(new DimensPX(1080,1794));
        dimensData.add(new DimensPX(1080,1812));
        dimensData.add(new DimensPX(1080,1920));
        dimensData.add(new DimensPX(1200,1920));
        dimensData.add(new DimensPX(1080,2016));
        dimensData.add(new DimensPX(1080,2040));
        dimensData.add(new DimensPX(1080,2160));
        dimensData.add(new DimensPX(1440,2560));

    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setBasePX(int baseWidth,int baseHeight){
        this.baseWidth = baseWidth;
        this.baseHeight = baseHeight;
    }

    @Override
    public void run() {

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<dimensData.size(); i++){

            DimensPX dimensPX = dimensData.get(i);
            String parentName = path + "values-"+dimensPX.getyPX() + "x" + dimensPX.getxPX();
            File file = new File(parentName);
            if(!file.exists()){
                file.mkdirs();
            }

            /************************编写lay_x.xml文件*******************************/

            File lay_x = new File(file, "lay_x.xml");
            lay_x.delete();
            writeFile(lay_x, sb, dimensPX,"x");

            /**************************编写lay_y.xml文件********************************/

            File lay_y = new File(file, "lay_y.xml");
            lay_y.delete();
            writeFile(lay_y, sb, dimensPX,"y");

        }

    }

    private void writeFile(File lay, StringBuffer sb, DimensPX dimens, String type){

        //切勿使用FileWriter写数据，它是默认使用ISO-8859-1 or gb2312，不是utf-8,并且没有setEncoding方法
        BufferedWriter fw = null;
        try {
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(lay,true),"UTF-8"));

            fw.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>" +"\n");
            fw.write("<resources>" + "\n");

            int bound;
            if("x".equals(type)){
                bound = baseWidth;
            }else{
                bound = baseHeight;
            }

            for(int k=1; k<bound+1; k++){

                sb.setLength(0);
                sb.append("    <dimen name=\""+type+k+"\">");

                float px = 0.0f;
                if("x".equals(type)){
                    px = ((float)dimens.getxPX()/baseWidth) * k;
                }else{
                    px = ((float)dimens.getyPX()/baseHeight) * k;
                }

                sb.append(px+"px</dimen>" + "\n");
                fw.write(sb.toString());
            }
            fw.write("</resources>");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

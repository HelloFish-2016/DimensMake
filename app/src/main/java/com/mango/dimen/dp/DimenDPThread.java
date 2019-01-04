package com.mango.dimen.dp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Mangoer
 * Time: 2019/1/4 19:50
 * Version:
 * Desc: TODO()
 */
public class DimenDPThread implements Runnable{

    private String path = "";
    private static int wBaseDp = 360;
    private static List<DimensDP> dimensData = new ArrayList<>();

    static{
        dimensData.add(new DimensDP(240,wBaseDp));
        dimensData.add(new DimensDP(320,wBaseDp));
        dimensData.add(new DimensDP(360,wBaseDp));
        dimensData.add(new DimensDP(384,wBaseDp));
        dimensData.add(new DimensDP(392,wBaseDp));
        dimensData.add(new DimensDP(400,wBaseDp));
        dimensData.add(new DimensDP(410,wBaseDp));
        dimensData.add(new DimensDP(411,wBaseDp));
        dimensData.add(new DimensDP(420,wBaseDp));
        dimensData.add(new DimensDP(430,wBaseDp));
        dimensData.add(new DimensDP(432,wBaseDp));
        dimensData.add(new DimensDP(440,wBaseDp));
        dimensData.add(new DimensDP(480,wBaseDp));
        dimensData.add(new DimensDP(533,wBaseDp));
        dimensData.add(new DimensDP(592,wBaseDp));
        dimensData.add(new DimensDP(600,wBaseDp));
        dimensData.add(new DimensDP(640,wBaseDp));
        dimensData.add(new DimensDP(662,wBaseDp));
        dimensData.add(new DimensDP(720,wBaseDp));
        dimensData.add(new DimensDP(768,wBaseDp));
        dimensData.add(new DimensDP(800,wBaseDp));
        dimensData.add(new DimensDP(811,wBaseDp));

    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setwBaseDp(int wBaseDp) {
        this.wBaseDp = wBaseDp;
    }

    @Override
    public void run() {

        if("".equals(path)) return;

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<dimensData.size(); i++){

            DimensDP dimensDP = dimensData.get(i);
            String parentName = path + "values-sw" + dimensDP.getSwDp() + "dp";
            File file = new File(parentName);
            if(!file.exists()){
                file.mkdirs();
            }

            /************************编写dimens.xml文件*******************************/
            File dim = new File(file, "dimens.xml");
            dim.delete();
            writeFile(dim, sb, dimensDP);

        }

    }

    private void writeFile(File lay, StringBuffer sb, DimensDP dimens){

        //切勿使用FileWriter写数据，它是默认使用ISO-8859-1 or gb2312，不是utf-8,并且没有setEncoding方法
        BufferedWriter fw = null;
        try {
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(lay,true),"UTF-8"));

            fw.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>" +"\n");
            fw.write("<resources>" + "\n");

            StringBuffer sp = new StringBuffer();
            for(int k = 1; k<dimens.getwBaseDp()+1; k++){
                sb.setLength(0);
                sb.append("    <dimen name=\"dp_"+k+"\">");
                float dp = ((float)dimens.getSwDp()/dimens.getwBaseDp()) * k;
                sb.append(dp+"dp</dimen>" + "\n");
                fw.write(sb.toString());
                if (k >= 12 && k <=24 & k%2 == 0) {
                    sp.append("    <dimen name=\"sp_"+k+"\">");
                    float value = ((float)dimens.getSwDp()/dimens.getwBaseDp()) * k;
                    sp.append(value+"sp</dimen>" + "\n");
                }
            }
            fw.write("\n");
            fw.write("    /**********字体适配***************/" + "\n");
            fw.write("\n");
            fw.write(sp.toString());
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

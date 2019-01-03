package com.mango.dimen;

/**
 * Author:Mangoer
 * Time:2019/1/3 21:04
 * Version:
 * Desc:TODO()
 */
public class Dimens {

    private int xPX;
    private int yPX;

    private int xBase;
    private int yBase;

    public Dimens(int xPX, int yPX, int xBase, int yBase) {
        super();
        this.xPX = xPX;
        this.yPX = yPX;
        this.xBase = xBase;
        this.yBase = yBase;
    }

    public int getxPX() {
        return xPX;
    }
    public void setxPX(int xPX) {
        this.xPX = xPX;
    }
    public int getyPX() {
        return yPX;
    }
    public void setyPX(int yPX) {
        this.yPX = yPX;
    }
    public int getxBase() {
        return xBase;
    }
    public void setxBase(int xBase) {
        this.xBase = xBase;
    }
    public int getyBase() {
        return yBase;
    }
    public void setyBase(int yBase) {
        this.yBase = yBase;
    }

}

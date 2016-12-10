
package com.coloniergames.ld37.level;

/**
 *
 * @author Bözse
 */
public class Bnt {
    
    // valtoztattatm
    private Bnt leftchild;
    private Bnt rightchild;
    private int width;
    private int height;
    private int x;
    private int y;
    private int rectx;
    private int recty;
    private int rectwidth;
    private int rectheight;
    private boolean isleaf;

    public int getRectx() {
        return rectx;
    }

    public void setRectx(int rectx) {
        this.rectx = rectx;
    }

    public int getRecty() {
        return recty;
    }

    public void setRecty(int recty) {
        this.recty = recty;
    }

    public int getRectwidth() {
        return rectwidth;
    }

    public void setRectwidth(int rectwidth) {
        this.rectwidth = rectwidth;
    }

    public int getRectheight() {
        return rectheight;
    }

    public void setRectheight(int rectheight) {
        this.rectheight = rectheight;
    }

    public Bnt(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        isleaf = false;
    }

    public boolean isIsleaf() {
        return isleaf;
    }

    public void setIsleaf(boolean isleaf) {
        this.isleaf = isleaf;
    }

    public Bnt getLeftchild() {
        return leftchild;
    }

    public void setLeftchild(Bnt leftchild) {
        this.leftchild = leftchild;
    }

    public Bnt getRightchild() {
        return rightchild;
    }

    public void setRightchild(Bnt rightchild) {
        this.rightchild = rightchild;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    

}


package com.coloniergames.ld37.level;

/**
 *
 * @author Bözse
 */
public class Bnt {
    
    private Bnt leftchild;
    private Bnt rightchild;
    private int width;
    private int height;
    private int x;
    private int y;

    public Bnt(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
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

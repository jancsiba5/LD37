
package com.coloniergames.ld37.level;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bözse
 */
public class Bnt {
    
    // valtoztattatm
    private Bnt leftchild;
    private Bnt rightchild;
    private Bnt parent;
    private int width;
    private int height;
    private int x;
    private int y;
    private List<Room> roomlist;
    private boolean isleaf;

   

    public Bnt getParent() {
        return parent;
    }

    public void setParent(Bnt parent) {
        this.parent = parent;
    }

    public List<Room> getRoomlist() {
        return roomlist;
    }

    public void setRoomlist(List<Room> roomlist) {
        this.roomlist = roomlist;
    }

    public Bnt(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        isleaf = false;
        roomlist = new ArrayList();
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

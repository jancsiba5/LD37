
package com.coloniergames.ld37.level;

import java.util.Random;

/**
 *
 * @author Bözse
 */
public class Mapgen {

    private static Random rnd;
    public int[][] mapids;

    static {
        rnd = new Random();
    }

    public Mapgen(int minsize, Bnt root, int maxlevel) {
        mapids = new int[root.getHeight()][root.getWidth()];
        for (int i = 0; i < root.getHeight(); i++) {
            for (int j = 0; j < root.getWidth(); j++) {
                mapids[i][j] = 0;
            }
        }
        gen(root, minsize, 0, maxlevel);
        for (int i = 0; i < root.getHeight(); i++) {
            for (int j = 0; j < root.getWidth(); j++) {
                System.out.print(mapids[i][j]);
            }
            System.out.println("");
        }

    }
    
    private void genCorridors(Bnt node) {
        if (!(node.getRightchild() != null && node.getLeftchild() != null)) {
            return;
        }
        else {
            genCorridors(node.getLeftchild());
            genCorridors(node.getRightchild());
            if (node.getLeftchild().isIsleaf() && node.getRightchild().isIsleaf()) {
                if (node.getRightchild().getY() == node.getLeftchild().getY()) {
                    int from1 = node.getLeftchild().getY() + node.getLeftchild().getRecty();
                    int to1 = node.getLeftchild().getY() + node.getLeftchild().getRecty() + node.getLeftchild().getRectheight();
                    int from2 = node.getRightchild().getY () + node.getRightchild().getRecty();
                    int to2 = node.getRightchild().getY() + node.getRightchild().getRecty() + node.getRightchild().getRectheight();
                }
                else if (node.getRightchild().getY() == node.getLeftchild().getY()) {
                    
                }
            }
            
        }
    }
    

    private void gen(Bnt node, int minsize, int level, int maxlevel) {
        if (!cansplit(node, minsize) || level >= maxlevel) {

            int rectwidth = minsize;
            if (node.getWidth() - minsize > 0) {
                rectwidth += rnd.nextInt(node.getWidth() - minsize);
            }
            int rectheight =  minsize;
            if (node.getHeight() - minsize > 0) {
                rectheight += rnd.nextInt(node.getHeight() - minsize);
            }
            int rectx = 0;
            if (node.getWidth() - rectwidth > 0) {
                rectx += rnd.nextInt(node.getWidth() - rectwidth);
            }
            int recty = 0;
            if (node.getHeight() - rectheight > 0) {
                recty += rnd.nextInt(node.getHeight() - rectheight);
            }
            node.setRectx(rectx);
            node.setRecty(recty);
            node.setRectheight(rectheight);
            node.setRectwidth(rectwidth);
            node.setIsleaf(true);
            System.out.println(rectwidth + "  " + rectheight + " " + rectx + " " + recty);
            for (int i = rectx + node.getX(); i < node.getX() + rectx + rectwidth; i++) {
                for (int j = recty + node.getY() ; j < node.getY() + recty + rectheight; j++) {
                    System.out.println(i + "  " + j);
                    mapids[j][i] = 1;
                }
            }
            return;
        }
        boolean vertical = rnd.nextBoolean();

        if (vertical) {

            int splitx = rnd.nextInt(node.getWidth());
            while (splitx < minsize || node.getWidth()- splitx < minsize) {
                splitx = rnd.nextInt(node.getWidth());
            }
            System.out.println(splitx);
            node.setLeftchild(new Bnt(splitx, node.getHeight(), node.getX(), node.getY()));
            
            gen(node.getLeftchild(), minsize, level + 1, maxlevel);
            node.setRightchild(new Bnt(node.getWidth() - splitx, node.getHeight(), node.getX() + splitx, node.getY()));
            

            gen(node.getRightchild(), minsize, level + 1, maxlevel);

        } else {
            int splity = rnd.nextInt(node.getHeight());
            while (splity < minsize || node.getHeight() - splity < minsize) {
                splity = rnd.nextInt(node.getHeight());
            }
            System.out.println(splity);
            node.setLeftchild(new Bnt(node.getWidth(), splity, node.getX(), node.getY()));
            
            gen(node.getLeftchild(), minsize, level + 1, maxlevel);
            node.setRightchild(new Bnt(node.getWidth(), node.getHeight() - splity, node.getX(), node.getY() + splity));
            

            gen(node.getRightchild(), minsize, level + 1, maxlevel);

        }
    }

    private boolean cansplit(Bnt node, int minsize) {
        return !(node.getHeight() < (minsize + 1) * 2 || node.getWidth() < (minsize + 1) * 2);
    }

}

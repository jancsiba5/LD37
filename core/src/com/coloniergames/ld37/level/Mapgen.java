package com.coloniergames.ld37.level;

import java.util.Random;

/**
 *
 * @author Bözse
 */
public class Mapgen {

    //
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
        genCorridors(root);
    }

    boolean intervalIntersects (int int1From, int int1To, int int2From, int int2To) {
        return int1To > int2From && int1From < int2To;
    }
    
    
    
    private void buildCorr(Room r1, Room r2) {

        Room upperRoom = (r1.getY () < r2.getY () ? r1 : r2);
        Room bottomRoom = (r1.equals (upperRoom) ? r2 : r1);
        
        Room leftRoom = (r1.getX () < r2.getX () ? r1 : r2);
        Room rightRoom = (r1.equals (leftRoom) ? r2 : r1);
        
        Interval r1XInterval = new Interval (r1.getX(), r1.getX () + r1.getWidth ());
        Interval r2XInterval = new Interval (r2.getX (), r2.getX () + r2.getWidth ());
        Interval r1YInterval = new Interval (r1.getY (), r1.getY () + r1.getHeight ());
        Interval r2YInterval = new Interval (r2.getY (), r2.getY () + r2.getHeight ());
        
        Interval xIntersection = r1XInterval.intersect (r2XInterval);
        Interval yIntersection = r1YInterval.intersect (r2YInterval);
        
        // egymásban vannak
        if (xIntersection != null && yIntersection != null) return;
        
        if (xIntersection != null) {
            // egymás alatt, mehet egyenesen lefele
            int randX = xIntersection.from + rnd.nextInt (xIntersection.size ());
            int fromY = upperRoom.getY () + upperRoom.getHeight ();
            int toY = bottomRoom.getY ();
            
            for (int i = fromY; i < toY; i++) {
                mapids [i][randX] += 1;
            }
        } else if (yIntersection != null) {
            // egymás mellett, mehet egyenesen oldalra
            int randY = yIntersection.from + rnd.nextInt (yIntersection.size ());
            int fromX = leftRoom.getX () + leftRoom.getWidth ();
            int toX = rightRoom.getX ();
            
            for (int i = fromX; i < toX; i++) {
                mapids [randY][i] += 1;
            }
        } else {
            boolean fromSide = true;
            
            if (fromSide) {
                if (upperRoom.getX () > bottomRoom.getX ()) {
                    // balról
                    int fromY = upperRoom.getY () + rnd.nextInt (upperRoom.getHeight());
                    int toX = bottomRoom.getX () + rnd.nextInt (bottomRoom.getWidth ());
                    while (toX > upperRoom.getX ()) toX = bottomRoom.getX () + rnd.nextInt (bottomRoom.getWidth ());
                    
                    for (int i = upperRoom.getX (); i >= toX; i--) {
                        mapids [fromY][i] += 1;
                    }
                    for (int i = fromY; i < bottomRoom.getY (); i++) {
                        mapids [i][toX] += 1;
                    }
                } else {
                    // jobbról
                    int fromY = upperRoom.getY () + rnd.nextInt (upperRoom.getHeight());
                    int toX = bottomRoom.getX () + rnd.nextInt (bottomRoom.getWidth ());
                    
                    for (int i = upperRoom.getX () + upperRoom.getWidth (); i <= toX; i++) {
                        mapids [fromY][i] += 1;
                    }
                    for (int i = fromY; i < bottomRoom.getY (); i++) {
                        mapids [i][toX] += 1;
                    }
                }
            } else {
                
            }
        }
        
    }

    private void genCorridors(Bnt node) {
        if (!(node.getRightchild() != null && node.getLeftchild() != null)) {
            return;
        } else {
            genCorridors(node.getLeftchild());
            genCorridors(node.getRightchild());
            Room leftRoom = node.getLeftchild().getRoomlist().get(rnd.nextInt(node.getLeftchild().getRoomlist().size()));
            Room rightRoom = node.getRightchild().getRoomlist().get(rnd.nextInt(node.getRightchild().getRoomlist().size()));

            buildCorr(leftRoom, rightRoom);
            // fixed ;)
        }

    }

    private void gen(Bnt node, int minsize, int level, int maxlevel) {
        for (int i = 0; i < level; i++) System.out.print ("  ");
        System.out.println (level + " / " + maxlevel);
        if (!cansplit(node, minsize) || level >= maxlevel) {
            System.out.println ("start of if (!cansplit(node, minsize))");
            int rectwidth = minsize;
            if (node.getWidth() - minsize > 0) {
                rectwidth += rnd.nextInt((node.getWidth() - minsize > minsize * 2 ? minsize : node.getWidth() - minsize));
            }
            int rectheight = minsize;
            if (node.getHeight() - minsize > 0) {
                rectheight += rnd.nextInt((node.getHeight() - minsize > minsize * 2 ? minsize : node.getHeight() - minsize));
            }
            int rectx = 0;
            if (node.getWidth() - rectwidth > 0) {
                rectx += rnd.nextInt(node.getWidth() - rectwidth);
            }
            int recty = 0;
            if (node.getHeight() - rectheight > 0) {
                recty += rnd.nextInt(node.getHeight() - rectheight);
            }
            Room room = new Room(rectx + node.getX (), recty + node.getY (), rectwidth, rectheight);
            // node.getRoomlist().add(room);
            node.addRoom (room);
            node.setIsleaf(true);
            for (int i = rectx + node.getX(); i < node.getX() + rectx + rectwidth; i++) {
                for (int j = recty + node.getY(); j < node.getY() + recty + rectheight; j++) {
                    mapids[j][i] += 1;
                }
            }
            System.out.println ("end of if (!cansplit(node, minsize))");
            return;
        }
        boolean vertical = rnd.nextBoolean();
        if (vertical && node.getWidth() >= minsize * 2 + 1) {
            int splitx = rnd.nextInt(node.getWidth());
            while (splitx < minsize || node.getWidth() - splitx < minsize) {
                splitx = rnd.nextInt(node.getWidth());
            }
            node.setLeftchild(new Bnt(splitx, node.getHeight(), node.getX(), node.getY()));
            node.getLeftchild().setParent(node);
            gen(node.getLeftchild(), minsize, level + 1, maxlevel);
            node.setRightchild(new Bnt(node.getWidth() - splitx, node.getHeight(), node.getX() + splitx, node.getY()));
            node.getRightchild().setParent(node);
            gen(node.getRightchild(), minsize, level + 1, maxlevel);

        } else if (node.getHeight () >= minsize * 2 + 1) {
            int splity = rnd.nextInt(node.getHeight());
            while (splity < minsize || node.getHeight() - splity < minsize) {
                splity = rnd.nextInt(node.getHeight());
            }
            node.setLeftchild(new Bnt(node.getWidth(), splity, node.getX(), node.getY()));
            node.getLeftchild().setParent(node);
            gen(node.getLeftchild(), minsize, level + 1, maxlevel);
            node.setRightchild(new Bnt(node.getWidth(), node.getHeight() - splity, node.getX(), node.getY() + splity));
            node.getRightchild().setParent(node);
            gen(node.getRightchild(), minsize, level + 1, maxlevel);
        }
        
        for (int i = 0; i < level; i++) System.out.print ("  ");
        System.out.println ("/ " + level + " / " + maxlevel);
    }

    private boolean cansplit(Bnt node, int minsize) {
        return !(node.getHeight() < minsize * 2 + 1 || node.getWidth() < minsize * 2 + 1);
    }
    
    class Interval {
        public int from;
        public int to;
        
        public Interval (int f, int t) {
            this.from = f;
            this.to = t;
        }
        
        public boolean intersects (Interval other) {
            return to > other.from && from < other.to;
        }
        
        public Interval intersect (Interval other) {
            if (!intersects (other)) return null;
            return new Interval ((from > other.from ? from : other.from), (to < other.to ? to : other.to));
        }
        
        public int size () {
            return Math.abs (to - from);
        }
    }

}

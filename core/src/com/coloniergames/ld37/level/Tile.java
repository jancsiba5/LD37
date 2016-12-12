package com.coloniergames.ld37.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.coloniergames.ld37.coll.HitObject;

public class Tile {
    
    public static int WHITE_FLOOR = 0x01;
    
    
    public static int METAL_WALL_TOP_LEFT = 0x02;
    public static int METAL_WALL_TOP = 0x03;
    public static int METAL_WALL_TOP_RIGHT = 0x04;
    public static int METAL_WALL_LEFT = 0x05;
    public static int METAL_WALL_CENTER = 0x06;
    public static int METAL_WALL_RIGHT = 0x07;
    public static int METAL_WALL_BOTTOM_LEFT = 0x08;
    public static int METAL_WALL_BOTTOM = 0x09;
    public static int METAL_WALL_BOTTOM_RIGHT = 0x0A;
    
    public static int METAL_WALL_CORNER_SIMPLE_TOP_LEFT = 0x0B;
    public static int METAL_WALL_CORNER_SIMPLE_TOP_RIGHT = 0x0C;
    public static int METAL_WALL_CORNER_SIMPLE_BOTTOM_LEFT = 0x0D;
    public static int METAL_WALL_CORNER_SIMPLE_BOTTOM_RIGHT = 0x0E;
    
    public static int METAL_WALL_CORNER_DIAGONAL_OUTLINE_TOP_LEFT = 0x0F;
    public static int METAL_WALL_CORNER_DIAGONAL_OUTLINE_TOP_RIGHT = 0x10;
    public static int METAL_WALL_CORNER_DIAGONAL_OUTLINE_BOTTOM_LEFT = 0x11;
    public static int METAL_WALL_CORNER_DIAGONAL_OUTLINE_BOTTOM_RIGHT = 0x12;
    
    public static int METAL_WALL_CORNER_INNER_TOP_LEFT = 0x13;
    public static int METAL_WALL_CORNER_INNER_TOP_RIGHT = 0x14;
    public static int METAL_WALL_CORNER_INNER_BOTTOM_RIGHT = 0x15;
    public static int METAL_WALL_CORNER_INNER_BOTTOM_LEFT = 0x16;
    
    public static int METAL_WALL_CORNER_INNER_OUTLINE_TOP_LEFT = 0x17;
    public static int METAL_WALL_CORNER_INNER_OUTLINE_TOP_RIGHT = 0x18;
    public static int METAL_WALL_CORNER_INNER_OUTLINE_BOTTOM_LEFT = 0x19;
    public static int METAL_WALL_CORNER_INNER_OUTLINE_BOTTOM_RIGHT = 0x1A;
    
    public static int METAL_WALL_CORNER_BLOCK_TOP_LEFT = 0x1B;
    public static int METAL_WALL_CORNER_BLOCK_TOP_RIGHT = 0x1C;
    public static int METAL_WALL_CORNER_BLOCK_BOTTOM_LEFT = 0x1D;
    public static int METAL_WALL_CORNER_BLOCK_BOTTOM_RIGHT = 0x1E;
    
    public static int FLOOR_TILE = 0x1F;
    public static int FLOOR_TILE_2 = 0x20;
    public static int FLOOR_TILE_3 = 0x21;
    public static int FLOOR_TILE_4 = 0x22;
    
    public static TextureRegion METAL_WALL [][];
    public static TextureRegion FLOOR_TILES [][];
    
    public static void initTileRegions () {
        METAL_WALL = new TextureRegion (new Texture (Gdx.files.internal("textures/tiles/metal_wall.png"))).split(16, 16);
        FLOOR_TILES = new TextureRegion (new Texture (Gdx.files.internal ("textures/tiles/lab_floor.png"))).split (16, 16);
    }
    
    public static TextureRegion mapIDToRegion (int id) {
        if (id >= METAL_WALL_TOP_LEFT 
         && id <= METAL_WALL_BOTTOM_RIGHT) {
            
            return METAL_WALL   [(id - METAL_WALL_TOP_LEFT) / 3]
                                [(id - METAL_WALL_TOP_LEFT) % 3];
            
        } else if (id >= METAL_WALL_CORNER_SIMPLE_TOP_LEFT 
                && id <= METAL_WALL_CORNER_SIMPLE_BOTTOM_RIGHT) {
            
            return METAL_WALL   [(id - METAL_WALL_CORNER_SIMPLE_TOP_LEFT) / 2]
                                [(id - METAL_WALL_CORNER_SIMPLE_TOP_LEFT) % 2 + 3];
            
        } else if (id >= METAL_WALL_CORNER_DIAGONAL_OUTLINE_TOP_LEFT 
                && id <= METAL_WALL_CORNER_DIAGONAL_OUTLINE_BOTTOM_RIGHT) {
            
            return METAL_WALL   [(id - METAL_WALL_CORNER_DIAGONAL_OUTLINE_TOP_LEFT) / 2 + 2]
                                [(id - METAL_WALL_CORNER_DIAGONAL_OUTLINE_TOP_LEFT) % 2 + 3];
            
        } else if (id >= METAL_WALL_CORNER_INNER_TOP_LEFT 
                && id <= METAL_WALL_CORNER_INNER_BOTTOM_RIGHT) {
            
            return METAL_WALL   [(id - METAL_WALL_CORNER_INNER_TOP_LEFT) / 2 + 4]
                                [(id - METAL_WALL_CORNER_INNER_TOP_LEFT) % 2 + 4];
            
        } else if (id >= METAL_WALL_CORNER_INNER_OUTLINE_TOP_LEFT
                && id <= METAL_WALL_CORNER_INNER_OUTLINE_BOTTOM_RIGHT) {
            
            return METAL_WALL   [(id - METAL_WALL_CORNER_INNER_OUTLINE_TOP_LEFT) / 2 + 4]
                                [(id - METAL_WALL_CORNER_INNER_OUTLINE_TOP_LEFT) % 2 + 2];
            
        } else if (id >= METAL_WALL_CORNER_BLOCK_TOP_LEFT
                && id <= METAL_WALL_CORNER_BLOCK_BOTTOM_RIGHT) {
            
            return METAL_WALL   [(id - METAL_WALL_CORNER_BLOCK_TOP_LEFT) / 2 + 3]
                                [(id - METAL_WALL_CORNER_BLOCK_TOP_LEFT) % 2];
            
        } else if (id >= FLOOR_TILE
                && id <= FLOOR_TILE_4) {
            
            return FLOOR_TILES [(id - FLOOR_TILE) / 2] [(id - FLOOR_TILE) % 2];
            
        }
        
        return null;
    }
    
    public int tid;
    public int tx;
    public int ty;
    
    public Tile (int x, int y, int tid) {
        this.tx = x;
        this.ty = y;
        this.tid = tid;
    }
    
}

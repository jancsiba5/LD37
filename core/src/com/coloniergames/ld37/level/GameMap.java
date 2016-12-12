package com.coloniergames.ld37.level;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Arrays;
import java.util.Random;

public final class GameMap {
    
    private static final Random random = new Random ();
    
    public Mapgen gen;
    
    public Tile [][] tiles;
    
    public static final int TILE_SIZE = 16;
            
    public GameMap (Mapgen gen) {
        
        this.gen = gen;
        
        generate ();
        
    }
    
    public final void generate () {
        
        this.tiles = new Tile [gen.mapids.length * 2][gen.mapids [0].length * 2];
        
        for (int y = 0; y < gen.mapids.length; y++) {
            System.out.println (Arrays.toString(gen.mapids [y]));
            for (int x = 0; x < gen.mapids [0].length; x++) {
                
                if (gen.mapids [y] [x] > 0) {
                    this.tiles [y * 2] [x * 2] = new Tile (x * 2, y * 2, Tile.FLOOR_TILE + random.nextInt (3));
                    this.tiles [y * 2] [x * 2 + 1] = new Tile (x * 2 + 1, y * 2, Tile.FLOOR_TILE + random.nextInt (3));
                    this.tiles [y * 2 + 1] [x * 2 + 1] = new Tile (x * 2 + 1, y * 2 + 1, Tile.FLOOR_TILE + random.nextInt (3));
                    this.tiles [y * 2 + 1] [x * 2] = new Tile (x * 2, y * 2 + 1, Tile.FLOOR_TILE + random.nextInt (3));
                }
                
            }
        }
        
        int numnull = 0;
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles [0].length; x++) {
                if (tiles [y] [x] == null) numnull++;
            }
        }
        
        System.out.println ("NUM NULL: " + numnull);
        
    }
    
    public void draw (SpriteBatch spriteBatch, OrthographicCamera camera) {
        
        int fromX = (int) ((camera.position.x - camera.viewportWidth / 2.0f) / TILE_SIZE - 1);
        if (fromX < 0) fromX = 0;
        if (fromX >= tiles [0].length) fromX = tiles [0].length - 1;
        
        int fromY = (int) ((camera.position.y - camera.viewportHeight / 2.0f) / TILE_SIZE - 1);
        if (fromY < 0) fromY = 0;
        if (fromY >= tiles.length) fromY = tiles.length - 1;
        
        int toX = (int) ((camera.position.x + camera.viewportWidth / 2.0f) / TILE_SIZE + 1) ;
        if (toX < 0) toX = 0;
        if (toX >= tiles [0].length) toX = tiles [0].length - 1;
        
        int toY = (int) ((camera.position.y + camera.viewportHeight / 2.0f) / TILE_SIZE + 1);
        if (toY < 0) toY = 0;
        if (toY >= tiles.length) toY = tiles.length - 1;
        
        /*System.out.println (fromX + " --> " + toX + ", " + fromY + " --> " + toY);
        System.out.println (spriteBatch);
        System.out.println (tiles);*/
        
        spriteBatch.setProjectionMatrix (camera.combined);
        spriteBatch.begin ();
        
        for (int y = fromY; y < toY; y++) {
            for (int x = fromX; x < toX; x++) {
                if (tiles [y] [x] != null) {
                    spriteBatch.draw(Tile.mapIDToRegion(tiles [y] [x].tid), tiles [y] [x].tx * TILE_SIZE, tiles [y] [x].ty * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }
            }
        }
        
        spriteBatch.end ();
        
    }
    
}

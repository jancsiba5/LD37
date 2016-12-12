package com.coloniergames.ld37.game;

import com.badlogic.gdx.Gdx;
import com.coloniergames.ld37.entity.EntityManager;
import com.coloniergames.ld37.level.Bnt;
import com.coloniergames.ld37.level.GameMap;
import com.coloniergames.ld37.level.Mapgen;
import com.coloniergames.ld37.level.Tile;

public class PlayState extends GameState {

    private EntityManager entityManager;
    GameMap gameMap;
    
    public void init() {
        
        Tile.initTileRegions();
        
        Mapgen mg = new Mapgen (4, 5, new Bnt (32, 32, 0, 0), 16);
        
        gameMap = new GameMap (mg);
        
        System.out.println (spriteBatch);
        
    }

    public void tick(float delta) {
        
        gameCamera.position.x = (float) Math.cos (gameTimer * 0.1f) * 1000f;
        gameCamera.position.y = (float) Math.sin (gameTimer * 0.1f) * 1000f;
        gameCamera.update();
        
    }

    public void draw(float delta) {
        
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear (Gdx.gl.GL_COLOR_BUFFER_BIT);
        
        gameMap.draw(spriteBatch, gameCamera);
        
    }

    public void postProcess(float delta) {
        
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear (Gdx.gl.GL_COLOR_BUFFER_BIT);
        
        spriteBatch.setProjectionMatrix(guiCamera.combined);
        spriteBatch.begin ();
        spriteBatch.draw(screenBuffer.getColorBufferTexture(), -w, -h, dims.x, dims.y);
        spriteBatch.end();
        
    }

    public void uninit() {
    }

    public boolean keyDown(int keycode) {
        return false;
    }

    public boolean keyUp(int keycode) {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }

    public boolean evalShouldChange() {
        return false;
    }

    public void pause() {
    }

    public void resume() {
    }
    
}

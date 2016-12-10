package com.coloniergames.ld37.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public abstract class GameState implements Screen, InputProcessor {

    /** Main SpriteBatch for drawing */
    protected SpriteBatch spriteBatch;
    
    /** Main ShapeRenderer for drawing */
    protected ShapeRenderer shapeRenderer;
    
    /** FrameBuffer to draw to, used in post processing */
    protected FrameBuffer screenBuffer;
    
    protected int W;
    protected int H;
    protected float w;
    protected float h;
    protected Vector2 dims;
    
    /** Initialize common variables of the GameState (SpriteBatch, FrameBuffer, etc. */
    public void commonInit () {
        
    }
    
    /** Initialize GameState's variables */
    public abstract void init ();
    /** Advance Game Logic by 1 step */
    public abstract void tick (float delta);
    /** Draw a single frame */
    public abstract void draw (float delta);
    /** Post-process drawn frame */
    public abstract void postProcess (float delta);
    
    public abstract boolean keyDown(int keycode);
    public abstract boolean keyUp(int keycode);
    public abstract boolean touchDown(int screenX, int screenY, int pointer, int button);
    public abstract boolean touchUp(int screenX, int screenY, int pointer, int button);
    public abstract boolean touchDragged(int screenX, int screenY, int pointer);
    public abstract boolean mouseMoved(int screenX, int screenY);
    public abstract boolean scrolled(int amount);
    
    public void show() {
        commonInit ();
        
        init ();
    }

    public void render(float delta) {

        // TODO: Seperate thread
        tick (delta);
        
        screenBuffer.bind();
        draw (delta);
        screenBuffer.end();
        
        postProcess(delta);
        
    }

    public void resize(int width, int height) {
        this.W = width;
        this.H = height;
        this.w = (float) W;
        this.h = (float) H;
        this.dims.x = this.w;
        this.dims.y = this.h;
    }

    public void pause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void resume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void hide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    /**
     * Unused.
     * @param character
     * @return 
     */
    public boolean keyTyped(char character) {
        return false;
    }

    
}

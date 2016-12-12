package com.coloniergames.ld37.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public abstract class GameState implements Screen, InputProcessor {

    public GameState () {
        commonInit ();
        
        init ();
    }
    
    /** Main SpriteBatch for drawing */
    protected SpriteBatch spriteBatch;
    
    /** Main ShapeRenderer for drawing */
    protected ShapeRenderer shapeRenderer;
    
    /** FrameBuffer to draw to, used in post processing */
    protected FrameBuffer screenBuffer;
    
    /** FrameBuffer to draw GUI to */
    protected FrameBuffer guiBuffer;
    
    /** Camera for the transformation of in-game elements */
    protected OrthographicCamera gameCamera;
    
    /** Camera for the transformation of GUI elements (text, dialogs, etc.) */
    protected OrthographicCamera guiCamera;
    
    /** Screen dimensions represented in different forms */
    protected int W;
    protected int H;
    protected float w;
    protected float h;
    protected Vector2 dims;
    
    protected float gameTimer;
    
    /** The state the game changes into when evalShouldChange () returns true */
    public GameState nextState;
    
    /** Initialize common variables of the GameState (SpriteBatch, FrameBuffer, etc. */
    public final void commonInit () {
        
        this.gameTimer = 0.0f;
        
        this.dims = new Vector2 ();
        
        resize (Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        spriteBatch = new SpriteBatch ();
        shapeRenderer = new ShapeRenderer ();
        
    }
    
    /** Initialize GameState's variables */
    public abstract void init ();
    /** Advance Game Logic by 1 step */
    public abstract void tick (float delta);
    /** Draw a single frame */
    public abstract void draw (float delta);
    /** Post-process drawn frame */
    public abstract void postProcess (float delta);
    /** Called from dispose () */
    public abstract void uninit ();
    
    public abstract boolean keyDown(int keycode);
    public abstract boolean keyUp(int keycode);
    public abstract boolean touchDown(int screenX, int screenY, int pointer, int button);
    public abstract boolean touchUp(int screenX, int screenY, int pointer, int button);
    public abstract boolean touchDragged(int screenX, int screenY, int pointer);
    public abstract boolean mouseMoved(int screenX, int screenY);
    public abstract boolean scrolled(int amount);
    
    public abstract boolean evalShouldChange ();
    
    public abstract void pause();
    public abstract void resume();
    
    public void show() {
        resume ();
    }

    public void render(float delta) {

        gameTimer += delta;
        
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
        
        gameCamera = new OrthographicCamera (w, h);
        
        guiCamera = new OrthographicCamera (w, h);
        guiCamera.position.set(-w / 2.0f, -h / 2.0f, 0.0f);
        guiCamera.update();
        
        if (guiBuffer != null) {
            guiBuffer.dispose();
        }
        guiBuffer = new FrameBuffer (Format.RGB888, W, H, false);
        
        if (screenBuffer != null) {
            screenBuffer.dispose();
        }
        screenBuffer = new FrameBuffer (Format.RGB888, W, H, false);
        
    }

    public void hide() {
        pause ();
    }

    // never dispose
    public void dispose() {}



    /**
     * Unused.
     * @param character
     * @return 
     */
    public boolean keyTyped(char character) {
        return false;
    }

    
}

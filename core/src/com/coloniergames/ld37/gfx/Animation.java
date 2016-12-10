package com.coloniergames.ld37.gfx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animation {
    
    public TextureRegion [] frames;
    public int numFrames;
    public int currentFrame;
    public float frameTime;
    public float timer;
    
    public Animation (Texture t, int numFrames, int fps) {
        
        this.numFrames = numFrames;
        this.currentFrame = 0;
        this.frameTime = 1.0f / (float) fps;
        this.timer = 0.0f;
        this.frames = new TextureRegion (t).split(t.getWidth() / numFrames, t.getHeight()) [0];
        
    }
    
}

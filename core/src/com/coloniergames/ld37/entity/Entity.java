package com.coloniergames.ld37.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.coloniergames.ld37.coll.HitObject;

public abstract class Entity {
    
    public HitObject hitObject;
    public int id;
    public Sprite sprite;
    public float rotation;
    public Vector2 position;
    public Vector2 velocity;
    
    protected EntityManager manager;
    
    public Entity () {}
    
    /** TODO */
    public void updateHitObject () {
        
    }
    
    public abstract void tick (float delta);
    public abstract void draw (SpriteBatch sb, ShapeRenderer sr, float delta);
    
}

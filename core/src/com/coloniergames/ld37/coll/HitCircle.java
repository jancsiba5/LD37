package com.coloniergames.ld37.coll;

import com.badlogic.gdx.math.Vector2;

/** TODO */
public class HitCircle extends HitObject {

    public Vector2 center;
    public float radius;
    
    public boolean collides(HitObject other) {
        return false;
    }
    
}

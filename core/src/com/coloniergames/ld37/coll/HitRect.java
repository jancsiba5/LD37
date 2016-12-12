package com.coloniergames.ld37.coll;

import com.badlogic.gdx.math.Vector2;

public class HitRect extends HitObject {

    public Vector2 center, halfdims;
    
    public boolean collides(HitObject other) {
        
        if (other instanceof HitRect) {
            
        }
        
        return false;
    }
    
}

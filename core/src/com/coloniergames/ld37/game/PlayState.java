package com.coloniergames.ld37.game;

import com.coloniergames.ld37.entity.EntityManager;

public class PlayState extends GameState {

    private EntityManager entityManager;
    
    public void init() {
        
    }

    public void tick(float delta) {
    }

    public void draw(float delta) {
    }

    public void postProcess(float delta) {
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

package com.coloniergames.ld37.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TestState extends GameState {

    @Override
    public void init() {
        
    }

    @Override
    public void tick(float delta) {
    }

    @Override
    public void draw(float delta) {
        screenBuffer.bind();
        
        Gdx.gl.glClearColor(0.0f, 0.0f, 1.0f, 1.0f);
        Gdx.gl.glClear (Gdx.gl.GL_COLOR_BUFFER_BIT);
        
        shapeRenderer.setProjectionMatrix(guiCamera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(1.0f, 0.0f, 0.0f, 1.0f);
        shapeRenderer.rect(100.0f, 100.0f, 64.0f, 64.0f);
        shapeRenderer.end();
        
        screenBuffer.end();
    }

    @Override
    public void postProcess(float delta) {
        
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
        
        spriteBatch.setProjectionMatrix(guiCamera.combined);
        spriteBatch.begin();
        
        spriteBatch.draw(screenBuffer.getColorBufferTexture(), -w, -h, dims.x, dims.y);
        
        spriteBatch.end();
        
    }

    @Override
    public void uninit() {
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public boolean evalShouldChange() {
        return false;
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
    
}

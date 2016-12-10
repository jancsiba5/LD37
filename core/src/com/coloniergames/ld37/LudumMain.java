package com.coloniergames.ld37;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.coloniergames.ld37.game.GameState;
import com.coloniergames.ld37.game.GameStateStore;

public class LudumMain extends Game {

    GameState currentState;
    
    @Override
    public void create() {
        
        GameStateStore.initStates();
        
        currentState = GameStateStore.testState;
        setScreen (currentState);
        Gdx.input.setInputProcessor(currentState);
        
    }

}

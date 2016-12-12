package com.coloniergames.ld37;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.coloniergames.ld37.game.GameState;
import com.coloniergames.ld37.game.GameStateStore;
import com.coloniergames.ld37.level.Bnt;
import com.coloniergames.ld37.level.Mapgen;

public class LudumMain extends Game {

    GameState currentState;
    
    @Override
    public void create() {
        
        GameStateStore.initStates();
        
        currentState = GameStateStore.playState;
        setScreen (currentState);
        Gdx.input.setInputProcessor(currentState);
        
    }

}

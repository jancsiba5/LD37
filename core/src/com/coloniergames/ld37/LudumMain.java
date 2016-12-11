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
        
        Mapgen mg = new Mapgen (6, new Bnt (64, 64, 0, 0), 10);
        for (int y = 0; y < mg.mapids.length; y++) {
            for (int x = 0; x < mg.mapids [0].length; x++) {
                System.out.print (mg.mapids [y] [x]);
            }
            System.out.println ();
        }
        
        GameStateStore.initStates();
        
        currentState = GameStateStore.testState;
        setScreen (currentState);
        Gdx.input.setInputProcessor(currentState);
        
    }

}

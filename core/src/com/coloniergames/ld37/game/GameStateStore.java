package com.coloniergames.ld37.game;

public final class GameStateStore {
    
    public static TestState testState;
    
    /** Initialization of the states must happen after OpenGL context has been created */
    public static void initStates () {
        testState = new TestState ();
    }
    
}

package com.mygdx.game;

import States.StateManager;
import States.menuState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
//set game height and width
    public static final int WIDTH = 600;
    public static final int HEIGHT = 800;
   
    //create spritebatch and statemanager
    private SpriteBatch batch;
    private StateManager stateManager;

    /**
     * Create components for starting game
     */
    @Override
    public void create() {
        //make new spritebatch
        batch = new SpriteBatch();
        //clear the colour
        Gdx.gl.glClearColor(1, 0, 0, 1);
        //make new state manager
        stateManager = new StateManager();
        //menu state as the first screen
        menuState firstScreen = new menuState(stateManager);
        stateManager.push(firstScreen);  // load the first screen
    }
   
    /**
     * draw first screen
     */
    @Override
    public void render() {
        //clear screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateManager.handleInput();
        stateManager.update(Gdx.graphics.getDeltaTime());
        stateManager.render(batch);
    }

    /**
     * dispose batch
     */
    @Override
    public void dispose() {
    batch.dispose();
    }
}

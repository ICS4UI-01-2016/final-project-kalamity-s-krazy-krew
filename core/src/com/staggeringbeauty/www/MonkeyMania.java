package com.staggeringbeauty.www;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import states.stateManager;
import states.menuState;
import states.state;

public class MonkeyMania extends ApplicationAdapter {
    
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    
    private SpriteBatch batch;
    private stateManager stateManager;
    private Texture img;
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("Space.jpg");
        
        stateManager = new stateManager();
//        menuState firstScreen = new menuState(stateManager);
//        stateManager.push(firstScreen);  // load the first screen
    }
    
    // game loop
    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // handle input
        stateManager.handleInput();
        // update the game states
        stateManager.update(Gdx.graphics.getDeltaTime());
        // draw the screen 
        stateManager.render(batch);
    }

    // end section
    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
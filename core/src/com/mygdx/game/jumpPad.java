/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author preej0747
 */
public class jumpPad {

    //private floats
    private final float padPosX = (int) (0 + Math.random() * (480 - 0 + 1));
    private final float padPosY = (int) Math.random();
    private final float height = 25;
    public static final float WIDTH = 50;
    public boolean hasPassed;
    
    //import pad texture
    private Texture jumppad;
    
    //pad constructor
    public jumpPad(float x) {
        hasPassed = false;
    }
    
    //methods needed in order to run the jump pads
    public void render(SpriteBatch batch) {
        batch.draw(jumppad, padPosX, padPosY);
    }
    
    public float getX() {
        return padPosX;
    }
    
    public float getY() {
        return padPosY;
    }
    
    public boolean hasPassed() {
        return hasPassed;
    }
    
    public void pass() {
        hasPassed = true;
    }
}

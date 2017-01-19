/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

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
    private Vector2 position;
    private Rectangle bounds;
    
    //import pad texture
    private Texture jumppad;
    
    //pad constructor
    public jumpPad(float x) {
        float y = (int)(Math.random() * (325 - 75 + 1) + 75);
        position = new Vector2(x, y);
        //jumpPad = new Texture(); 
        bounds = new Rectangle(position.x, position.y, jumppad.getHeight(), jumppad.getWidth());
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
    



    public void setY(float y){
        hasPassed = false;
        position.y = y;
        float x = (int)(Math.random() * (325 - 75 + 1) + 75);
        position.x = x;
        bounds.setPosition(position.x, position.y);
    }
    
    public boolean collides(Monkey b){
        if(bounds.overlaps(b.getHitBox())){
            return true;
        }
        return false;
    }
    
    public void dispose(){
        jumppad.dispose();
    }


    public boolean hasPassed() {
        return hasPassed;
    }
    
    public void pass() {
        hasPassed = true;
    }
}

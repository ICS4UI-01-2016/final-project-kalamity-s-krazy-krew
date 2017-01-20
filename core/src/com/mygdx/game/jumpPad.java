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
    public boolean Jump;
    public static final float WIDTH = 50;
    
    private Vector2 position;
    private Rectangle bounds;
    private Texture jumppad;
    
    //pad constructor
    public jumpPad(float y) {
        float x = (int) (Math.random() * (481));
        position = new Vector2(x, y);
        jumppad = new Texture("JumpPad2.png"); 
        bounds = new Rectangle(position.x, position.y, jumppad.getHeight(), jumppad.getWidth());
 
       
    }
    
    //methods needed in order to run the jump pads
    public void render(SpriteBatch batch) {
        batch.draw(jumppad, position.x, position.y);
    }
    
    public float getY() {
        return position.y;
    }
    
    public void setY(float y){  
        position.y = y;    
        float x = (int)(Math.random() * (481));
        position.x = x;       
        bounds.setPosition(position.x, position.y);
    }
    
    public boolean collides(Monkey b){
        if(bounds.overlaps(b.getHitBox())){
            System.out.println("hitting");
            return true;
        } else{
            return false;
        }
    }
    
    public void dispose(){
        jumppad.dispose();
    }
}

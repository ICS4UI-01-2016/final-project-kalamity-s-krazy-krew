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
public class SuperJumpPad extends Pad{

    //create variables, vectors, Rectangles and Textures
    public boolean Jump;
    public static final float WIDTH = 50;
    private Vector2 position;
    private Rectangle bounds;
    private Texture jumppad;
  

    //pad constructor
    public SuperJumpPad(float y){
        super(y);
        position = new Vector2(super.getX(), y);
        jumppad = new Texture("SuperJumpPad.png"); 
        bounds = new Rectangle(position.x, position.y,  jumppad.getWidth(),jumppad.getHeight());       
    }

    //methods needed in order to run the jump pads
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(jumppad, bounds.x, bounds.y,  jumppad.getWidth(),jumppad.getHeight());
    }
//    
//    public Rectangle getBounds(){
//        return bounds;
//    }
//
//    public float getY() {
//        return position.y;
//    }
//      
//    public float getX() {
//        return position.x;
//    }
//
//    public float getHeight(){
//        return jumppad.getHeight();
//        
//    }
//    
//    public float throughJumpPad(){
//         return position.y + 3/4 * jumppad.getHeight();
//    }
//    
//    public void setY(float y) {
//        position.y = y;
//        float x = (int) (Math.random() * (481));
//        position.x = x;
//        bounds.setPosition(position.x, position.y);
//    }
/**
 * remove jumppads
 */
    @Override
    public void dispose() {
        jumppad.dispose();
    }
/**
 * update jumppad position
 */
    @Override
    public void update() {
        position.y = super.getY();
    }
}

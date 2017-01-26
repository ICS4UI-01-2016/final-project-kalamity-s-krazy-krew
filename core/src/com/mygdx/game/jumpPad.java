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
 * @author farrb0382
 */
public class jumpPad extends Pad {

    //create instance variables
    public boolean Jump;
    public static final float WIDTH = 50;
    private Vector2 position;
    private Rectangle bounds;
    private Texture pad;

    //pad constructor
    public jumpPad(float y) {
        //get y value from pad
        super(y);
        //set position
        position = new Vector2(super.getX(), y);
        //set texture
        pad = new Texture("JumpPad3.png");
        //set bounds
        bounds = new Rectangle(position.x, position.y, pad.getWidth(), pad.getHeight());
    }

//    //methods needed in order to run the jump pads
//    @Override
//    public void render(SpriteBatch batch) {
//        batch.draw(jumppad, position.x, position.y);
//    }
//    
//    @Override
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
//
//    public void dispose() {
//        jumppad.dispose();
//    }
    /**
     * draw
     * @param batch 
     */
    public void render(SpriteBatch batch) {
        batch.draw(pad, bounds.x, bounds.y, pad.getWidth(), pad.getHeight());
    }

    @Override
    public void dispose() {
    }
/**
 * update
 */
    @Override
    public void update() {
        position.y = super.getY();
    }
}

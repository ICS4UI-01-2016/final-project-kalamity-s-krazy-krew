/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author farrb0382
 */
public class Monster {
    //create instance variables
    public static final float WIDTH = 50;
    private float velocity;
    private Texture monster;
    private Rectangle bounds;
    private Vector3 position;
    private float movement;   
    
    public Monster(float y){
        //set x to very left side
        float x = 1 ;      
        //set position
        position = new Vector3(x, y, 0);
        //no velocity
        velocity = 0;
        //set texture
        monster = new Texture("monster.png"); 
        //set bounds
        bounds = new Rectangle(position.x, position.y,  monster.getWidth(),monster.getHeight());       
    }
    /**
     * makes monster move left
     */
        public void GoLeft(){
            velocity = -100;
            System.out.println("left");
        }
        /**
         * make monster move right
         */
        
        public void GoRight(){
            velocity = 100;
            System.out.println("right");
        }
        
        /**
         * updates monster
         * @param deltaTime 
         */
        public void update(float deltaTime) {
       position.x += velocity * deltaTime;
        //set hitbox
        bounds.setPosition(position.x, position.y);
    }
    
        /**
         * draw picture
         * @param batch 
         */
    public void render(SpriteBatch batch) {
        batch.draw(monster, position.x, position.y);
    }
    
    /**
     * gets bounds
     * @return bounds
     */
    public Rectangle getBounds(){
        return bounds;
    }

    /**
     * gets Position y value
     * @return 
     */
    public float getY() {
        return position.y;
    }
      
    /**
     * gets position x value
     * @return 
     */
    public float getX() {
        return position.x;
    }
    
    /**
     * gets picture height
     * @return 
     */
    public float getHeight(){
        return monster.getHeight();
        
    }
    
    /**
     * Set Y
     * @param y 
     */
    public void setY(float y) {
        position.y = y;
        position.x = 0;
        bounds.setPosition(position.x, position.y);
    }
    
    /**
     * dispose of game objects
     */
    public void dispose() {
        monster.dispose();
    }
}

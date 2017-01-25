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
    
    public static final float WIDTH = 50;
    private float velocity;
    private Texture monster;
    private Rectangle bounds;
    private Vector3 position;
    private float movement;   
    
    public Monster(float y){
        float x = 0;      
        position = new Vector3(x, y, 0);
        velocity = 0;
        monster = new Texture("monster.png"); 
        bounds = new Rectangle(position.x, position.y,  monster.getWidth(),monster.getHeight());       
    }
        public void GoLeft(){
            velocity = -100;
            System.out.println("left");
        }
        
        public void GoRight(){
            velocity = 100;
            System.out.println("right");
        }
        
        public void update(float deltaTime) {
       position.x += velocity * deltaTime;
        //set hitbox
        bounds.setPosition(position.x, position.y);
    }
    
    public void render(SpriteBatch batch) {
        batch.draw(monster, position.x, position.y);
    }
    
    public Rectangle getBounds(){
        return bounds;
    }

    public float getY() {
        return position.y;
    }
      
    public float getX() {
        return position.x;
    }
    
    public float getHeight(){
        return monster.getHeight();
        
    }
    
    public void setY(float y) {
        position.y = y;
        position.x = 0;
        bounds.setPosition(position.x, position.y);
    }
    
    public void dispose() {
        monster.dispose();
    }
}

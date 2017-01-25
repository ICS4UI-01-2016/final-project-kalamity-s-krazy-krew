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
public class Monster {
    
    public static final float WIDTH = 50;
    private Texture monster;
    private Rectangle bounds;
    private Vector2 position;
    
    public Monster(float y){
        float x = (int) (Math.random() * (481));
        position = new Vector2(x, y);
        monster = new Texture("monster.png"); 
        bounds = new Rectangle(position.x, position.y,  monster.getWidth(),monster.getHeight());       
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
        float x = (int) (Math.random() * (781));
        position.x = x;
        bounds.setPosition(position.x, position.y);
    }
    
    public void dispose() {
        monster.dispose();
    }
}

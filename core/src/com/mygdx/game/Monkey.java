
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author malcr1272
 */
public class Monkey {
    //create vectors, Rectangles, Textures, and variables
    private Vector3 position;
    private Vector3 velocity;
    private Texture monkeypic;
    private Rectangle hitbox;
    private float highestPoint;
    private final float gravity = -15;
    private final float movement = 100;

    public Monkey(float x, float y) {
        
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, movement, 0 - 100);
        monkeypic = new Texture("CharacterFinished2.png");
        hitbox = new Rectangle(position.x, position.y, monkeypic.getWidth(), monkeypic.getHeight());
        
    }

    /**
     * Changes Y velocity of monkey
     */
    public void bounce() {
        velocity.y = 750;
//        System.out.println("bounce");
    }

    public void superBounce(){
        velocity.y = 1500;
    }
    
    /**
     * decreases x velocity
     */
    public void moveLeft() {
        velocity.x -= 25;
    }
/**
 * Increases y velocity
 */
    public void moveRight() {
        velocity.x += 25;
    }
    
    /**
     *  is there a collision with jumppad
     * @param i
     * @return true/false
     */
    public boolean collides(jumpPad i) {
        if (hitbox.overlaps(i.getBounds())) {
//            System.out.println("hitting");
            return true;
        } else {
            return false;
        }
    }
    /**
     * is there a collision with monster
     * @param i
     * @return true/false
     */
        public boolean collidesMonster(Monster i) {
        if (hitbox.overlaps(i.getBounds())) {
//            System.out.println("hitting");
            return true;
        } else {
            return false;
        }
    }

        /**
         * is monkey above 3/4 through the jumppad
         * @param i
         * @return true/false
         */
    public boolean topOfJumpPad(jumpPad i) {
        if (position.y >= i.throughJumpPad()){
//            System.out.println("OnTop");
            return true;            
        }else{
          return false;  
        }       
    }

    /**
     * gets width
     * @return width
     */
    public float getWidth(){
        return monkeypic.getWidth();
    }
    /**
     * gets  picture height
     * @return height
     */
        public float getHeight(){
        return monkeypic.getHeight();
    }
    
    /**
     * 
     * @param x 
     */
    public void setX(float x){
        position.x = x;  
    }
   
    /**
     * is monkey falling
     * @return true/false
     */
    public boolean Falling() {
        if (velocity.y < 0) {
            
            return true;
        } else {
            return false;
        }
    }       

    /**
     * update monkeys position
     * @param deltaTime 
     */
    public void update(float deltaTime) {
        //add gravity
        velocity.y += gravity;
        //scale the velocity
        velocity.scl(deltaTime);
        //add velocity
        position.add(velocity);
        //unscale the velocity
        velocity.scl(1 / deltaTime);
        //set hitbox
        hitbox.setPosition(position.x, position.y);
    }

    /**
     * draw monkey
     * @param batch 
     */
    public void render(SpriteBatch batch) {
        batch.draw(monkeypic, position.x, position.y);
    }

    /**
     * get x position
     * @return position x
     */
    public float getX() {
        return position.x;
    }

    /**
     * get y position
     * @return position y
     */
    public float getY() {
        return position.y;
    }

    /**
     * get hitbox
     * @return hitbox
     */
    public Rectangle getHitBox() {
        return hitbox;
    }  
    
    /**
     * dispose of monkey picture
     */
    public void dispose() {
        monkeypic.dispose();
    }
}

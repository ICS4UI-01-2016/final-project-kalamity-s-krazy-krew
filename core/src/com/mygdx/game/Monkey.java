
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

    private Vector3 position;
    private Vector3 velocity;
    private Texture monkeypic;
    private Rectangle hitbox;
    private float highestPoint;
    private final float gravity = -15;
    private final float movement = 100;

    public Monkey(float x, float y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, movement, 0);
        monkeypic = new Texture("CharacterFinished2.png");
        hitbox = new Rectangle(position.x, position.y, monkeypic.getWidth(), monkeypic.getHeight());
        
    }

    public void bounce() {
        velocity.y = 750;
//        System.out.println("bounce");
    }

    public void moveLeft() {
        velocity.x -= 25;
    }

    public void moveRight() {
        velocity.x += 25;
    }

    public boolean collides(jumpPad i) {
        if (hitbox.overlaps(i.getBounds())) {
//            System.out.println("hitting");
            return true;
        } else {
            return false;
        }
    }
    
        public boolean collidesMonster(Monster i) {
        if (hitbox.overlaps(i.getBounds())) {
//            System.out.println("hitting");
            return true;
        } else {
            return false;
        }
    }


    public boolean topOfJumpad(jumpPad i) {
        if (position.y >= i.throughJumpPad()){
//            System.out.println("OnTop");
            return true;            
        }else{
          return false;  
        }       
    }

    public float getWidth(){
        return monkeypic.getWidth();
    }
        public float getHeight(){
        return monkeypic.getHeight();
    }
    
    public void setX(float x){
        position.x = x;  
    }
   
    public boolean Falling() {
        if (velocity.y < 0) {
            
            return true;
        } else {
            return false;
        }
    }       

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

    public void render(SpriteBatch batch) {
        batch.draw(monkeypic, position.x, position.y);
    }

    public void dispose() {
        monkeypic.dispose();
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public Rectangle getHitBox() {
        return hitbox;
    }
}

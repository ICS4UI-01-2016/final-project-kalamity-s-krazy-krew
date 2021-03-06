/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Monkey;
import com.mygdx.game.Monster;
import com.mygdx.game.MyGdxGame;

import com.mygdx.game.jumpPad;

/**
 *
 * @author farrb0382
 */
public class PlayState extends State {
    //instance variables

    private Monkey monkey;
    private jumpPad[] jumppad;
    private Monster[] monster;
    private Texture space;
    private Music music;
    private Sound bounce;
    private float time;
    private final float CAM_Y_OFFSET = 30;
    private float CamY;
    private final float JUMPPAD_DISTANCE = 0;
    private int highScore;
    private int score;
    private BitmapFont font;
    private boolean pause;

    public PlayState(StateManager sm) {
        //get statemanager from state
        super(sm);
        //set camera
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        //search for music file and play
        music = Gdx.audio.newMusic(Gdx.files.internal("Dk.mp3"));
        music.play();
        music.setVolume(0.1f);
        //search for bounce sound effect file
        bounce = Gdx.audio.newSound(Gdx.files.internal("Bounce.mp3"));
        monkey = new Monkey(0, 200);
        pause = true;
        space = new Texture("space.jpg");
        //set camY to middle of Screen
        CamY = (monkey.getY() + CAM_Y_OFFSET);
        //move the camera
        moveCameraY(CamY);

        Preferences pref = Gdx.app.getPreferences("highscore");
        highScore = pref.getInteger("highScore", 0);
        font = new BitmapFont();    // default 15pt Arial Font 

        //create jumppad array
        jumppad = new jumpPad[10];
        for (int i = 0; i < jumppad.length; i++) {
            //make first 9 regular jumpjumppads
           // if (i < 9) {
                jumppad[i] = new jumpPad(-100 + 250 * i);
            //} else {
                //make last one a superjumpjumppad
              //  jumppad[i] = new SuperJumpPad(-100 + 250 * i);
            }
        //}

        //create array of 2 monsters and set them 1000 pixels apart
        monster = new Monster[2];
        for (int i = 0; i < monster.length; i++) {
            monster[i] = new Monster(950 + 1000 * i);
        }

        //make monkey spawn on top of first jumpjumppad
        monkey.setX(jumppad[0].getX());

    }


    
    /**
     * draw all pictures
     *
     * @param batch
     */
    @Override
    public void render(SpriteBatch batch) {
        // draw the screen and link spritebatch to the camera
        batch.setProjectionMatrix(getCombinedCamera());
        // beginning drawing
        batch.begin();
        // draw the background
        batch.draw(space, getCameraX() - getViewWidth() / 2, getCameraY() - getViewHeight() / 2);
        font.draw(batch, "" + score, getViewWidth() / 2, getCameraY() + 350);
        // draw the monkey
        monkey.render(batch);

        for (int i = 0; i < jumppad.length; i++) {
            jumppad[i].render(batch);
        }

        for (int i = 0; i < monster.length; i++) {
            monster[i].render(batch);
        }

        // end the stuff to draw
        batch.end();
    }

    /**
     * update any game objects
     *
     * @param deltaTime
     */
    @Override
    public void update(float deltaTime) {
        if (pause != !pause) {
            //if monkey is off the left side of the screen, move to the right
            if (monkey.getX() - monkey.getWidth() > MyGdxGame.WIDTH) {
//            System.out.println("to left");
                monkey.setX(-128);
            }
            //if monkey is off right side of screen, move to the left
            if (monkey.getX() + monkey.getWidth() < 0) {
//            System.out.println("to right");
                monkey.setX(728);
            }

            //update the monkets position
            monkey.update(deltaTime);

            //update every jumppad
//        for(int i = 0; i < jumppad.length; i ++){
//            jumppad[i].update();
//        }

            //update both monsters
            for (int i = 0; i < monster.length; i++) {
                monster[i].update(deltaTime);
            }

            //if the monket is above the middle
            if (monkey.getY() > CamY) {
                //adjust the camera
                CamY = monkey.getY();
            }
            //move the camera
            moveCameraY(CamY);
            
            //make game conditions
            StateManager gsm = getStateManager();
            if (monkey.getY() + monkey.getHeight() <= getCameraY() - MyGdxGame.HEIGHT / 2) {
                // end the game        
                // pop off the game screen to go to menu
                gsm.push(new DeathState(gsm));
                //pause music
                music.pause();
            }

            //if monkey hits any of the monsters
            for (int i = 0; i < monster.length; i++) {
                if (monkey.collidesMonster(monster[i]) == true) {
                    //pause music
                    music.pause();
                    //load death screen
                    gsm.push(new DeathState(gsm));
                }
            }

            // time is equal to deltaTime
            time += deltaTime;
            //make time run from 0 - 10 seconds
            if (time > 10) {
                time = time - 10;
            }

            //the first 5 seconds make the monster go right
            if (time <= 5) {
                for (int i = 0; i < monster.length; i++) {
                    monster[i].GoRight();
                }
            }
            //the last 5 seconds make the monster go left
            if (time > 5) {
                for (int i = 0; i < monster.length; i++) {
                    monster[i].GoLeft();
                }
            }



            for (int i = 0; i < jumppad.length; i++) {
                //if monkey is falling and on top of jumpjumppad and touching the jumpjumppad
                if (monkey.Falling() == true && monkey.topOfJumpPad(jumppad[i]) == true && monkey.collides(jumppad[i]) == true) {
                    //bounce and play sound effect
                    monkey.bounce();
                    bounce.play(0.05f);
                    System.out.println("Bouncing");
                }
                if( i > 9){
                    monkey.superBounce();
                    bounce.play(0.05f);
                }
            }

            for (int i = 0; i < jumppad.length; i++) {
                //once a jumppad moves off the screen
                if (getCameraY() - MyGdxGame.HEIGHT / 2 > jumppad[i].getY() + jumppad[i].getHeight()) {
                    System.out.println("MOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOVING");
                    //set float x to 250 above the highestjumppad
                    float x = jumppad[i].getY() + 250 * jumppad.length;
                    //set the y value to the float x
                    jumppad[i].setY(x);
                    
                    //add to the score
                    score++;

                    System.out.println("NEW Y VALUE:                                                           " + jumppad[i].getY());
                }

            }



            for (int i = 0; i < monster.length; i++) {
                //if monster goes off screen
                if (getCameraY() - MyGdxGame.HEIGHT / 2 > monster[i].getY() + monster[i].getHeight()) {
                    //set float x to 1000 above the other monster
                    float x = monster[i].getY() + 1000 * monster.length;
                    monster[i].setY(x);
                    //set the y value to 
                    System.out.println("Monster Changed");
                }
            }
        }
    }

    @Override
    public void handleInput() {
        //if left key is pushed move left
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            monkey.moveLeft();
        }
        //if right key is pushed move right
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            monkey.moveRight();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)){
            pause = !pause;
        }
    }

    @Override
    public void dispose() {
    }
}
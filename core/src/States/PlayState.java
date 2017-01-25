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

    private Monkey monkey;
    private jumpPad[] jumppad;
    private Monster[] monster;
    private Texture space;
    private Music music;
    private Sound bounce;
    private final float CAM_Y_OFFSET = 30;
    private float CamY;
    private final float JUMPPAD_DISTANCE = 0;
    private int highScore;
    private int score;
    private BitmapFont font;

    public PlayState(StateManager sm) {
        super(sm);

        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        music = Gdx.audio.newMusic(Gdx.files.internal("Dk.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();
        bounce = Gdx.audio.newSound(Gdx.files.internal("Bounce.mp3"));
        monkey = new Monkey(0, 400);
        space = new Texture("space.jpg");
        CamY = (monkey.getY() + CAM_Y_OFFSET);
        moveCameraY(CamY);

        Preferences pref = Gdx.app.getPreferences("highscore");
        highScore = pref.getInteger("highScore", 0);
        font = new BitmapFont();    // default 15pt Arial Font 



        jumppad = new jumpPad[6];
        for (int i = 0; i < jumppad.length; i++) {
            jumppad[i] = new jumpPad(-100 + 250 * i);
        }

        monster = new Monster[2];
        for (int i = 0; i < monster.length; i++) {
            monster[i] = new Monster(1000 * i);
        }

        monkey.setX(jumppad[1].getX());

    }

    public void updateScore() {
        Preferences pref = Gdx.app.getPreferences("highscore");
        highScore = pref.getInteger("highScore", 0);
    }

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

    @Override
    public void update(float deltaTime) {

        
        
        
        if (monkey.getX() - monkey.getWidth() > MyGdxGame.WIDTH) {
//            System.out.println("to left");
            monkey.setX(-128);
        }

        if (monkey.getX() + monkey.getWidth() < 0) {
//            System.out.println("to right");
            monkey.setX(728);
        }

        monkey.update(deltaTime);

        for (int i = 0; i < monster.length; i++) {
            monster[i].update(deltaTime);
        }

        if (monkey.getY() > CamY) {
            CamY = monkey.getY();
        }
        moveCameraY(CamY);

        if (monkey.getY() <= 0 - CamY) {
//            System.out.println("gratatatatatatattatata");
            // end the game
            StateManager gsm = getStateManager();
            // pop off the game screen to go to menu
            gsm.push(new DeathState(gsm));
            System.out.println("poppin");
        }
        for (int i = 0; i < monster.length; i++) {
            if (monster[i].getX() < 0) {

                monster[i].GoRight();
            }

            if (monster[i].getX() > MyGdxGame.WIDTH) {
                monster[i].GoLeft();
            }
        }

        System.out.println(monkey.getX());
        for (int i = 0; i < jumppad.length; i++) {
            if (monkey.Falling() == true && monkey.topOfJumpad(jumppad[i]) == true && monkey.collides(jumppad[i]) == true) {
                monkey.bounce();
                bounce.play(0.05f);
                score ++;
                System.out.println("Bouncing");
            }
        }
        
        for (int i = 0; i < jumppad.length; i++) {
            if (getCameraY() - MyGdxGame.HEIGHT / 2 > jumppad[i].getY() + jumppad[i].getHeight()) {
                float x = jumppad[i].getY() + 250 * jumppad.length;
                jumppad[i].setY(x);
                System.out.println("Jumppad Changed");
            }
        }

        for (int i = 0; i < monster.length; i++) {
            if (getCameraY() - MyGdxGame.HEIGHT / 2 > monster[i].getY() + monster[i].getHeight()) {
                float x = monster[i].getY() + 1000 * monster.length;
                monster[i].setY(x);
                System.out.println("Monster Changed");
            }
        }
    }

    @Override
    public void handleInput() {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            monkey.moveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            monkey.moveRight();
        }
    }

    @Override
    public void dispose() {
    }
}

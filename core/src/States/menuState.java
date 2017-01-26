/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

/**
 *
 * @author preej0747
 */
public class menuState extends State {

    //create Textures, sounds and font
    private Texture background;
    private Texture button;
    private Music music;
    private Sound playGame;
    private BitmapFont font;
    private Texture creditbutton;

    
    public menuState(StateManager gsm) {
        //retrieve statemanager
        super(gsm);
        //create button textures
        background = new Texture("ms2.jpg");
        button = new Texture("playbtn.png");
        creditbutton = new Texture("credit.png");
        //get button sound and background music
        playGame = Gdx.audio.newSound(Gdx.files.internal("pg.mp3"));
        music = Gdx.audio.newMusic(Gdx.files.internal("Theme.mp3"));  
        //play music
        music.play();
        music.setVolume(0.1f);
       //set camera
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);


    }

    /**
     * Render pictures
     * @param batch 
     */
    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();
        batch.draw(background, 0, 0, getViewWidth(), getViewHeight());
        batch.draw(button, getViewWidth() / 2 - button.getWidth() / 2, getViewHeight() / 2);
        batch.draw(creditbutton, getViewWidth() / 2 - creditbutton.getWidth() / 2, getViewHeight() / 2 - 200);
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
    }
    
    /**
     * switch to playstate
     */
    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {

            // get the mouse click/touch position
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

            // convert that point to game coordinates 
            unproject(touch);
            
            // Set both buttons x and y positions
            float buttonX = getViewWidth() / 2 - button.getWidth() / 2;
            float buttonY = getViewHeight() / 2;
            float buttonX2 = getViewWidth() / 2 - creditbutton.getWidth() / 2;
            float buttonY2 = getViewHeight() / 2 - 200;
            
            //if button is touched
            if (touch.x > buttonX && touch.x < buttonX + button.getWidth()
                    && touch.y > buttonY && touch.y < buttonY + button.getHeight()) {
                StateManager gsm = getStateManager();
                //move to playstate
                gsm.push(new PlayState(gsm));
                //play sound and pause menu music
                playGame.play(0.1f);
                music.pause();
            }
            
            //if other button is touched
            if (touch.x > buttonX2 && touch.x < buttonX2 + creditbutton.getWidth()
                    && touch.y > buttonY2 && touch.y < buttonY2 + creditbutton.getHeight()) {
                StateManager gsm = getStateManager();
                //move to credit state
                gsm.push(new CreditState(gsm));
                
            }
        }
    }

    /**
     * dispose game components
     */
    @Override
    public void dispose() {
        background.dispose();
        button.dispose();
    }
}

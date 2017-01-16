/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.MyGdxGame;

/**
 *
 * @author preej0747
 */
public class menuState extends State{
    
    //private textures
    private Texture background;
    private Texture button;
    private int highScore;
    private BitmapFont font;
    
    //menu state constructor
    public menuState(StateManager gsm){
        super(gsm);
        background = new Texture("space.jpg");
        //button = new Texture();
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
        
        Preferences pref = Gdx.app.getPreferences("highscore");
        highScore = pref.getInteger("highscore", 0);
        
        //default font
        font = new BitmapFont();
    }
}

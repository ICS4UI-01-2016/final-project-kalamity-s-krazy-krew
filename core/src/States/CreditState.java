/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Monkey;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.jumpPad;

/**
 *
 * @author farrb0382
 */

public class CreditState extends State {
    
    private Texture credits;
    private float CamY;
    
    public CreditState(StateManager gsm) {
        super(gsm);
        
        credits = new Texture("guan.jpg");
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
    }
}

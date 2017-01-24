/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
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

    //private textures
    private Texture background;
    private Texture button;
    private BitmapFont font;
    private Texture creditbutton;

    //menu state constructor
    public menuState(StateManager gsm) {
        super(gsm);
        background = new Texture("ms2.jpg");
        button = new Texture("playbtn.png");
        creditbutton = new Texture("credit.png");
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);

//        default font
//        font = new BitmapFont();
    }

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

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {

            // get the mouse click/touch position
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

            // convert that point to game coordinates 
            unproject(touch);
            
            // check if the button is pressed
            float buttonX = getViewWidth() / 2 - button.getWidth() / 2;
            float buttonY = getViewHeight() / 2;
            float buttonX2 = getViewWidth() / 2 - creditbutton.getWidth() / 2;
            float buttonY2 = getViewHeight() / 2 - 200;

            if (touch.x > buttonX && touch.x < buttonX + button.getWidth()
                    && touch.y > buttonY && touch.y < buttonY + button.getHeight()) {
                StateManager gsm = getStateManager();
                gsm.push(new PlayState(gsm));
            }
            
            if (touch.x > buttonX2 && touch.x < buttonX2 + creditbutton.getWidth()
                    && touch.y > buttonY2 && touch.y < buttonY2 + creditbutton.getHeight()) {
                StateManager gsm = getStateManager();
                gsm.push(new CreditState(gsm));
            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        button.dispose();
    }
}

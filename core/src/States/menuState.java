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
    private int highScore;
    private BitmapFont font;

    //menu state constructor
    public menuState(StateManager gsm) {
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

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();
        font.draw(batch, "" + highScore, getViewWidth() / 2, getViewHeight() - 100);
        batch.draw(background, 0, 0, getViewWidth(), getViewHeight());
        batch.draw(button, getViewWidth() / 2 - button.getWidth() / 2, getViewHeight() / 2);
        batch.end();
    }

    public void updateScore() {
        Preferences pref = Gdx.app.getPreferences("highscore");
        highScore = pref.getInteger("highscore", 0);
    }

    @Override
    public void update(float deltaTime) {
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            unproject(touch);
            float buttonX = getViewWidth() / 2 - button.getWidth() / 2;
            float buttonY = getViewHeight() / 2;
            if (touch.x > buttonX && touch.x < button.getWidth()
                    && touch.y > buttonY && touch.y < buttonY + button.getHeight()) {
                StateManager gsm = getStateManager();
                gsm.push(new PlayState(gsm));
            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        button.dispose();
    }
}

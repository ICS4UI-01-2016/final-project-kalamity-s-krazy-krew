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
 * @author farrb0382
 */
public class CreditState extends State {

    private Texture credits;
    private float CamY;

    public CreditState(StateManager gsm) {

        super(gsm);

        credits = new Texture("credit2.png");
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();
        batch.setProjectionMatrix(getCombinedCamera());
        batch.draw(credits, 0, 0, getViewWidth(), getViewHeight());
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
    }

    @Override
    public void handleInput() {

        if (Gdx.input.justTouched()) {

            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

            unproject(touch);

            if (touch.x < MyGdxGame.WIDTH && touch.y < MyGdxGame.HEIGHT) {
                StateManager gsm = getStateManager();
                gsm.push(new menuState(gsm));
            }
        }
    }

    @Override
    public void dispose() {
        credits.dispose();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

/**
 *
 * @author farrb0382
 */
public class DeathState extends State {

    private Texture death;
    private Texture menu;
    private float CamY;

    public DeathState(StateManager gsm) {

        super(gsm);

        death = new Texture("death.png");
        menu = new Texture("menu.png");
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();
        batch.draw(death, 0, 0, getViewWidth(), getViewHeight());
        batch.draw(menu, getViewWidth() / 2 - menu.getWidth() / 2, getViewHeight() / 2 - 100);
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

            float buttonX = getViewWidth() / 2 - menu.getWidth() / 2;
            float buttonY = getViewHeight() / 2 - 100;

            if (touch.x > buttonX && touch.x < buttonX + menu.getWidth()
                    && touch.y > buttonY && touch.y < buttonY + menu.getHeight()) {

                StateManager gsm = getStateManager();
                gsm.push(new menuState(gsm));
            }
        }
    }

    @Override
    public void dispose() {
        death.dispose();
        menu.dispose();
    }
}

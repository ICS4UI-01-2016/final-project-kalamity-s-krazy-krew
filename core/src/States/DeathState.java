/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

/**
 *
 * @author farrb0382
 */
public class DeathState extends State {

    //create variables, textures, and sounds
    private Texture death;
    private Texture menu;
    private Sound oh;
    private float CamY;

    public DeathState(StateManager gsm) {
        //call statemanager
        super(gsm);
        //create and play soundclip
        oh = Gdx.audio.newSound(Gdx.files.internal("Supa.mp3"));
        oh.play();
        //retreive pictures
        death = new Texture("death.png");
        menu = new Texture("menu.png");
        //set camera view
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);

    }

    /**
     *draw pictures
     * @param batch
     */
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

    /**
     * send back to menu state
     */
    @Override
    public void handleInput() {

        if (Gdx.input.justTouched()) {

            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

            unproject(touch);

            //set x value of button
            float buttonX = getViewWidth() / 2 - menu.getWidth() / 2;
            //set y value of button
            float buttonY = getViewHeight() / 2 - 100;

            //if button is clicked
            if (touch.x > buttonX && touch.x < buttonX + menu.getWidth()
                    && touch.y > buttonY && touch.y < buttonY + menu.getHeight()) {

                StateManager gsm = getStateManager();
                gsm.push(new menuState(gsm));
            }
        }
    }
/**
 * remove pictures
 */
    @Override
    public void dispose() {
        death.dispose();
        menu.dispose();
    }
}

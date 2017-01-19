/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Monkey;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.jumpPad;

/**
 *
 * @author farrb0382
 */
public class PlayState extends State {

    private Monkey monkey;
    private jumpPad[] jumppad;
    private Texture space;
    
    private final float CAM_Y_OFFSET = 30;
    private final float JUMPPAD_GAP_AMOUNT = 0;

    public PlayState(StateManager sm){
        super(sm);
        setCameraView(MyGdxGame.WIDTH/2, MyGdxGame.HEIGHT/2);
        monkey = new Monkey(50,200);
        space = new Texture("space.jpg");
        
        moveCameraY(monkey.getY() + CAM_Y_OFFSET);      
        
    }
    @Override
    public void render(SpriteBatch batch) {
                // draw the screen
        // link spritebatch to the camera
        batch.setProjectionMatrix(getCombinedCamera());
        // beginning of stuff to draw
        batch.begin();
        // draw the background
        batch.draw(space, getCameraX() - getViewWidth()/2, getCameraY() - getViewHeight()/2);      
        // draw the bird
        monkey.render(batch);
        
        // end the stuff to draw
        batch.end();
    }
    

    @Override
    public void update(float deltaTime) {       
        monkey.update(deltaTime);
        moveCameraY(monkey.getY() + CAM_Y_OFFSET);
        
    }

    @Override
    public void handleInput() {
        
    }

    @Override
    public void dispose() {
        
    }
}

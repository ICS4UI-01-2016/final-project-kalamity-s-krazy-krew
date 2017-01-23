/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

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
public class PlayState extends State {

    private Monkey monkey;
    private jumpPad[] jumppad;
    private Texture space;
    private final float CAM_Y_OFFSET = 30;
    private final float JUMPPAD_DISTANCE = 0;

    public PlayState(StateManager sm) {
        super(sm);
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        monkey = new Monkey(280, 400);
        space = new Texture("space.jpg");
        moveCameraY(monkey.getY() + CAM_Y_OFFSET);      

         jumppad = new jumpPad[6];
        for(int i = 0; i < jumppad.length; i++){
            jumppad[i] = new jumpPad(0 + 200 * i);
        }



    }

    @Override
    public void render(SpriteBatch batch) {
        // draw the screen
        // link spritebatch to the camera
        batch.setProjectionMatrix(getCombinedCamera());
        // beginning of stuff to draw
        batch.begin();
        // draw the background
        batch.draw(space, getCameraX() - getViewWidth() / 2, getCameraY() - getViewHeight() / 2);
        // draw the bird
        monkey.render(batch);


        for(int i = 0; i < jumppad.length; i++){
            jumppad[i].render(batch);
        }      

        


        // end the stuff to draw
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        monkey.update(deltaTime);
        moveCameraY(monkey.getY() + CAM_Y_OFFSET);
        
        
       for(int i = 0; i < jumppad.length; i++){
           if(monkey.Falling() == true && monkey.collides(jumppad[i]) == true && monkey.aboveJumpad(jumppad[i] ) == true){
               monkey.bounce();
               System.out.println("Bouncing");
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

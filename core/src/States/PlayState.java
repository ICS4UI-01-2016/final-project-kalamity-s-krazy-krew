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
    private float CamY;
    private final float JUMPPAD_DISTANCE = 0;
    
    public PlayState(StateManager sm) {
        super(sm);
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        monkey = new Monkey(0, 400);
        space = new Texture("space.jpg");
        CamY = (monkey.getY() + CAM_Y_OFFSET);
        moveCameraY(CamY);       
       
         jumppad = new jumpPad[6];
        for(int i = 0; i < jumppad.length; i++){
            jumppad[i] = new jumpPad(-100 + 250 * i);
        }
        
        monkey.setX(jumppad[1].getX());


    }

    @Override
    public void render(SpriteBatch batch) {
        // draw the screen and link spritebatch to the camera
        batch.setProjectionMatrix(getCombinedCamera());
        // beginning drawing
        batch.begin();
        // draw the background
        batch.draw(space, getCameraX() - getViewWidth() / 2, getCameraY() - getViewHeight() / 2);
        // draw the monkey
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
       
        if(monkey.getY() > CamY){         
            CamY = monkey.getY();              
        }
        moveCameraY(CamY); 
        
         if (monkey.getY()<= 0 - CamY) {
             System.out.println("gratatatatatatattatata");
            // end the game
            StateManager gsm = getStateManager();
            // pop off the game screen to go to menu
            gsm.pop();
        }
        
        if(monkey.getX() - monkey.getWidth() > MyGdxGame.WIDTH){
            System.out.println("to left");
            monkey.setX(-128);
        }
        
        if(monkey.getX() + monkey.getWidth() < 0){
            System.out.println("to right");
            monkey.setX(728);
        }
       
        System.out.println(monkey.getX());
       for(int i = 0; i < jumppad.length; i++){
           if(monkey.Falling() == true  && monkey.topOfJumpad(jumppad[i] ) == true && monkey.collides(jumppad[i]) == true ){
               monkey.bounce();
               System.out.println("Bouncing");
           }
       }
       for(int i = 0; i < jumppad.length; i++){
       if(getCameraY() - MyGdxGame.HEIGHT/2 > jumppad[i].getY() + jumppad[i].getHeight()){
         float x = jumppad[i].getY() + 250 * jumppad.length;
         jumppad[i].setY(x);
           System.out.println("Jumppad Changed");
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

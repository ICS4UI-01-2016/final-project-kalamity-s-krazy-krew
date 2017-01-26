/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author farrb0382
 */

// the class in abstract in order to implement all the abstract methods
public abstract class State {
    // creating a camera and a statemanager
    private OrthographicCamera cam;
    private StateManager stateManager;

    // state is composed of the camera and the statemanager
    public State(StateManager sm) {
        stateManager = sm;
        cam = new OrthographicCamera();
    }
    
    // the abstract voids that had to be implemented in order for the state class to work
    public abstract void render(SpriteBatch batch);
    public abstract void update(float deltaTime);
    public abstract void handleInput();
    public abstract void dispose();
    
    // a method to return the state manager
    public StateManager getStateManager() {
        return stateManager;
    }

    // a method to return the camera 
    public OrthographicCamera getCamera() {
        return cam;
    }

    // a method for setting the cameras view to the width and height of the game
    // method is also for updating the cameras position
    public void setCameraView(float width, float height) {
        cam.setToOrtho(false, width, height);
        cam.update();
    }

    // setting the cameras position to a set of x and y coords then updating the position
    public void setCameraPosition(float x, float y) {
        cam.position.x = x;
        cam.position.y = y;
        cam.update();
    }

    // a method for returning the combined camera
    public Matrix4 getCombinedCamera() {
        return cam.combined;
    }

    // a method for moving the camera along the y axis then updating its position
    public void moveCameraY(float y) {
        cam.position.y = y;
        cam.update();
    }

    // a method for getting the cameras x position and returning it
    public float getCameraX() {
        return cam.position.x;
    }

    // a method for getting the cameras y position and returning it 
    public float getCameraY() {
        return cam.position.y;
    }

    // a method for getting the view width of the game
    public float getViewWidth() {
        return cam.viewportWidth;
    }

    // a method for getting the view height of the game
    public float getViewHeight() {
        return cam.viewportHeight;
    }

    // unprojecting the camera for when something is clicked
    public void unproject(Vector3 touch) {
        cam.unproject(touch);
    }
}

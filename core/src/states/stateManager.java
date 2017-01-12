

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.lang.Thread.State;
import java.util.Stack;

/**
 *
 * @author farrb0382
 */
public class stateManager {

    /**
     * @param args the command line arguments
     */
    
    private Stack<State> states;

    public stateManager() {
        states = new Stack<State>();
    }

    public void push(State s) {
        states.push(s);
    }

    public void pop() {
    state s = states.pop();
    s.dispose();
        
    }

    public void set(State s) {
        
    }

    public void update(float deltaTime) {
        
    }

    public void render(SpriteBatch batch) {
        
    }

    public void handleInput() {
       
    }
}






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
    
    private Stack<state> states;

    public stateManager() {
        states = new Stack<state>();
    }

    public void push(state s) {
        states.push(s);
    }

    public void pop() {
    state s = states.pop();
    s.dispose();
    }

    public void set(state s) {
    pop();
    push(s);
        
    }

    public void update(float deltaTime) {
    states.peek().update(deltaTime);
        
    }

    public void render(SpriteBatch batch) {
        states.peek().render(batch);        
    }

    public void handleInput() {
       
    }
}




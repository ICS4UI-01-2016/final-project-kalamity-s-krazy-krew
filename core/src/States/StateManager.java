/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Stack;

/**
 *
 * @author farrb0382
 */
public class StateManager {
    
    private Stack<State> states;
    
    public StateManager(){
        states = new Stack<State>();
    }
    
    public void push(State s){
        states.push(s);
    }
    
    public void pop(){
        State s = states.pop();
    }
    
    public void set(State s){
        pop();
        push(s);
    }
    
     public void update(float deltaTime){
        states.peek().update(deltaTime);
    }
    
    public void render(SpriteBatch batch){
        states.peek().render(batch);
    }

    public void handleInput() {
        states.peek().handleInput();
    }
}

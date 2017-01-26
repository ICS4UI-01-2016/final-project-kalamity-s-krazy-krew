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
    
    // creating the states variable 
    private Stack<State> states;
    
    // the state manager is equal to the variable states
    public StateManager(){
        states = new Stack<State>();
    }
    
    // a method that will push to a new state
    public void push(State s){
        states.push(s);
    }
    
    // a method that will pop the current state
    public void pop(){
        State s = states.pop();
        push(s);
    }
    
    // a method that will set a state
    public void set(State s){
        pop();
        push(s);
    }
    
    // a method that will update
     public void update(float deltaTime){
        states.peek().update(deltaTime);
    }
    
     // a method that will draw 
    public void render(SpriteBatch batch){
        states.peek().render(batch);
    }

    // a method that handles the users input
    public void handleInput() {
        states.peek().handleInput();
    }
}

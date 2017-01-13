/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.staggeringbeauty.www.JumpPad;
import com.staggeringbeauty.www.Monkey;
import com.staggeringbeauty.www.MonkeyMania;

/**
 *
 * @author farrb0382
 */
public class playState extends state {
    
    private Monkey monkey;
    private Texture background;
    private JumpPad[] pad;
    private boolean hasPassed;
    private final float CAM_Y_OFFSET = 30;
    private final float PAD_GAP_AMOUNT = 3;
    private int score;
    private BitmapFont font;
    
//    public playState(stateManager sm){
//        
//        super(sm);
////        setCameraView(MonkeyMania.WIDTH / 2, MonkeyMania.HEIGHT / 2);
////        monkey = new Monkey(100,400); 
////        background = new Texture("bg.png");
////        moveCameraY(monkey.getY() + CAM_Y_OFFSET);
        
    }
    


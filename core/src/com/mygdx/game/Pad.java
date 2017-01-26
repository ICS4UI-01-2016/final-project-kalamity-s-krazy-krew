//package com.mygdx.game;
//
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector2;
//
//public abstract class Pad {
//
//    //create variables, vectors, Rectangles, and textures
//    public boolean Jump;
//    public static final float WIDTH = 50;
//    private Vector2 position;
//    private Rectangle bounds;
//    private float height = 37;
//    private float width = 127;
//    private Texture pad;
//
//    public Pad(float y) {
//        //spawn pad at random x, and designated Y
//        position = new Vector2((int) (Math.random() * (481)), y);
//        //set bounds around pad
//        pad = new Texture("JumpPad3.png");
//        bounds = new Rectangle(position.x, position.y, 127, 37);
//        System.out.println(" pad x:                                    " + position.x);
//        System.out.println(" pad y:                                    " + position.y);
//    }
//
//    //abstract methods needed 
//   // public abstract void render(SpriteBatch batch);
//    public void render(SpriteBatch batch) {
//        batch.draw(pad, bounds.x, bounds.y, pad.getWidth(), pad.getHeight());
//    }
//    public abstract void update();
//
//    public abstract void dispose();
//
//    /**
//     * Accesses Pads bounds
//     *
//     * @return bounds
//     */
//    public Rectangle getBounds() {
//        return bounds;
//    }
//
//    /**
//     * Accesses Y Value
//     *
//     * @return Y
//     */
//    public float getY() {
//        return position.y;
//    }
//
//    /**
//     * Accesses X value
//     *
//     * @return x
//     */
//    public float getX() {
//        return position.x;
//    }
//
//    /**
//     * Accesses picture height
//     *
//     * @return height
//     */
//    public float getHeight() {
//        return height;
//
//    }
//
//    /**
//     * Checks 3/4 the way through the pad (Where the monkey bounces)
//     *
//     * @return position
//     */
//    public float throughJumpPad() {
//        return position.y + 3 / 4 * height;
//    }
//
//    /**
//     * Sets Y value
//     * @param y
//     */
//    public void setY(float y) {
//        System.out.println("Setting Y");
//        position.y = y;
//        float x = (int) (Math.random() * (481));
//        position.x = x;
//        bounds.setPosition(position.x, position.y);
//
//    }
//
//}

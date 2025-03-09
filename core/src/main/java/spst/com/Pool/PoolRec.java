package spst.com.Pool;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class PoolRec extends MyActor {
    public PoolRec(float x, float y, Stage s) {
        super(x, y, s);
    }
    public Rectangle getBound(){
        return new Rectangle(getX(), getY(), 32*9, 32*7);
    }
}

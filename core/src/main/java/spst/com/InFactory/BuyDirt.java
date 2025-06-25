package spst.com.InFactory;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class BuyDirt extends MyActor {
    public BuyDirt(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion2(16,16*2,16,16);
        setSize(32,32);
    }
}

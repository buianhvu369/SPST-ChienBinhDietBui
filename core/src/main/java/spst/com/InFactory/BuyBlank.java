package spst.com.InFactory;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class BuyBlank extends MyActor {
    public BuyBlank(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(16*9,16*17,16,16);
        setSize(32,32);
    }
}

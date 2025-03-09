package spst.com.Pool;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Water extends MyActor {
    public Water(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(9*16, 7*16, 16, 32);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }
}

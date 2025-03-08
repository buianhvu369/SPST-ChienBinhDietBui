package spst.com.Roads.CrossRoad;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class BlankRoad extends MyActor {
    public BlankRoad(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(9*16, 17*16, 16, 16);
        setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
    }
}

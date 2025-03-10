package spst.com.town;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Rice extends MyActor{
    public Rice(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion2(48, 0, 16, 32);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }
}

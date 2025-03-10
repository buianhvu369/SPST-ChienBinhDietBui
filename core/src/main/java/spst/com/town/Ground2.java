package spst.com.town;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Ground2 extends MyActor{
    public Ground2(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion2(0, 0, 48, 48+16);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }
}

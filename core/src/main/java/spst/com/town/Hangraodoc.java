package spst.com.town;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Hangraodoc extends MyActor {
    Hangraodoc(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion2(16*11, 16*3, 16, 48);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }
}

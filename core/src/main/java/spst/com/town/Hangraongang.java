package spst.com.town;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Hangraongang extends MyActor {
    public Hangraongang(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion2(16*8, 16*6, 48, 16);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }
}

package spst.com.town;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Hangraongang extends MyActor {
    public Hangraongang(float x, float y, Stage s,int la) {
        super(x, y, s);
        if (la == 1) {
            textureRegion = Utils.getRegion2(16 * 8, 16 * 6, 48, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
        if (la == 2) {
            textureRegion = Utils.getRegion2(16 * 8, 16 * 6, 48, 16);
            setSize(textureRegion.getRegionWidth() , textureRegion.getRegionHeight() );
        }
    }
}

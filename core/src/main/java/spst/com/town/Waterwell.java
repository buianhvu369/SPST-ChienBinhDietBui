package spst.com.town;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Waterwell extends MyActor{
    public Waterwell(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion2(16*8, 16*7, 16, 32);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }
}

package spst.com.Parking;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class LetterP extends MyActor {
    public LetterP(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(16*10,16*16,16,16);
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);
    }
}

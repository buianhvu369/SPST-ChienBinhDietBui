package spst.com.Button;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class CaiDat extends MyActor {
    public CaiDat(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegionButton(192*1,64*2,192,64);
        setSize(192,64);
    }
}

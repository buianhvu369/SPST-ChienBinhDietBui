package spst.com.Button;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Exit extends MyActor {
    public Exit(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegionButton(192*0,64*2,192,64);
        setSize(192,64);
    }
}

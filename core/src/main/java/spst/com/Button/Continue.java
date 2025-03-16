package spst.com.Button;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Continue extends MyActor {
    public Continue(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegionButton(192*0,64*0,192,64);
        setSize(192,64);
    }
}

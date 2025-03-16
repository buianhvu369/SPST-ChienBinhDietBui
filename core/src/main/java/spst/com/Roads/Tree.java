package spst.com.Roads;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Tree extends MyActor {
    public Tree(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(16*16, 8*16, 16, 32);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }
}

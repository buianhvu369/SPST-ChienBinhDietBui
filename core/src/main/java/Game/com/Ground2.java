package Game.com;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Ground2 extends MyActor{
    Ground2(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion2(0, 0, 48, 48+16);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }
}

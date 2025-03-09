package Game.com;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Roof extends MyActor{
    Roof(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion2(16*4, 16*4, 16*4, 16*3);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }
}

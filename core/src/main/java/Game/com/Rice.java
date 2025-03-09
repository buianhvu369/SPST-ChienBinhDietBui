package Game.com;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Rice extends MyActor{
    Rice(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion2(48, 0, 16, 32);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }
}

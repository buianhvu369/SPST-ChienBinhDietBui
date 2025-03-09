package Game.com;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Waterwell extends MyActor{
    Waterwell(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion2(16*8, 16*7, 16, 32);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }
}

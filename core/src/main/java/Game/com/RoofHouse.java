package Game.com;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class RoofHouse extends MyActor{
    RoofHouse(float x, float y, Stage s, boolean houseBlue) {
        super(x, y, s);
        if(houseBlue) {
            textureRegion = Utils.getRegion2(16, 16 *4, 16, 32);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }else {
            textureRegion = Utils.getRegion2(16*5, 16 *4, 16, 32);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
    }
}

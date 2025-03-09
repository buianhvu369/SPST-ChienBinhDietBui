package Game.com;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class DoorHouse extends MyActor{
    DoorHouse(float x, float y, Stage s, boolean houseBlue) {
        super(x, y, s);
        if(houseBlue) {
            textureRegion = Utils.getRegion2(16, 16 * 7, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }else {
            textureRegion = Utils.getRegion2(16 * 5, 16 * 7, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
    }
}

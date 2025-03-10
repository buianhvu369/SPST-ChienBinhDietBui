package spst.com.town;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Randomblock extends MyActor{
    public Randomblock(float x, float y, Stage s, int block) {
        super(x, y, s);

        if (block == 1) {
            textureRegion = Utils.getRegion2(0, 0, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
        if (block == 2) {
            textureRegion = Utils.getRegion2(16, 0, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
        if (block == 3) {
            textureRegion = Utils.getRegion2(32, 0, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
        if (block == 4) {
            textureRegion = Utils.getRegion2(16 * 5, 48, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
        if (block == 5) {
            textureRegion = Utils.getRegion2(16 * 7, 48, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
    }
}

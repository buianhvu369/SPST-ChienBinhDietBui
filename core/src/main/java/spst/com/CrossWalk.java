package spst.com;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class CrossWalk extends MyActor{
    CrossWalk(float x, float y, Stage s, boolean isHorizontal) {
        super(x, y, s);
        if(isHorizontal) {
            textureRegion = Utils.getRegion(0, 18 * 16 - 3 * 16, 16, 48);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        } else {
            textureRegion = Utils.getRegion(32, 18*16 - 2*16 , 48, 16);
            setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        }
    }
}

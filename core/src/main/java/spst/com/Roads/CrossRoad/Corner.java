package spst.com.Roads.CrossRoad;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Corner extends MyActor {
    public Corner(float x, float y, Stage s, String yx) {
        super(x, y, s);
        if(yx.equals("UL")) {
            textureRegion = Utils.getRegion(16*7, 16 * 16, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        } else if(yx.equals("UR")) {
            textureRegion = Utils.getRegion(16*8, 16 * 16, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }else if(yx.equals("DL")) {
            textureRegion = Utils.getRegion(16*7, 16 * 17, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }else if(yx.equals("DR")) {
            textureRegion = Utils.getRegion(16*8, 16 * 17, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
    }
}

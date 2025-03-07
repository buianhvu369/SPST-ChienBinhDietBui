package Game.com;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class RoadWay extends MyActor{
    RoadWay(float x, float y, Stage s, boolean isHorizontal) {
        super( x, y, s);
        if(isHorizontal){
            textureRegion = Utils.getRegion(16, 18*16 - 3*16, 16, 16*3);
            setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        } else {
            textureRegion = Utils.getRegion(32, 18*16 - 1*16, 16*3, 16);
            setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        }
    }
}

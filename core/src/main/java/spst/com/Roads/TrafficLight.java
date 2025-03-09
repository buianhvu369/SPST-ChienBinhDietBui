package spst.com.Roads;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class TrafficLight extends MyActor {

    public TrafficLight(float x, float y, Stage s,char huong) {
        super(x, y, s);
        if(huong == 'L') {
            textureRegion = Utils.getRegion(16*3, 16 * 15, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        } else if(huong == 'D') {
            textureRegion = Utils.getRegion(16*4, 16 * 15, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }else if(huong == 'U') {
            textureRegion = Utils.getRegion(16*5, 16 * 15, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }else if(huong == 'R') {
            textureRegion = Utils.getRegion(16*6, 16 * 15, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
    }
}

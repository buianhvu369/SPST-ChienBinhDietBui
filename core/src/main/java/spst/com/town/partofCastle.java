package spst.com.town;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;

public class partofCastle extends MyActor {
    public partofCastle(float x, float y, Stage s, int part) {
        super(x, y, s);
        if(part == 1) {
            textureRegion = Utils.getRegion2(0,16*8,16,16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        } if(part == 2) {
            textureRegion = Utils.getRegion2(0,16*10,16,16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        } if(part == 3) {
            textureRegion = Utils.getRegion2(16*2,16*8,16,16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }if(part == 4) {
            textureRegion = Utils.getRegion2(16*2,16*10,16,16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }if(part == 5) {
            textureRegion = Utils.getRegion2(16*6,16*10,16,16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
        if(part == 6) {
            textureRegion = Utils.getRegion2(16*3,16*9,32,32);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
        if(part == 7) {
            textureRegion = Utils.getRegion2(16*6,16*8,16,16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }if(part == 8) {
            textureRegion = Utils.getRegion2(16,16*8,16,16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
        if(part == 9) {
            textureRegion = Utils.getRegion2(16,16*10,16,16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
        Master.noPlaced.add(this.getBound());
    }
}

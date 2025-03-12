package spst.com.GroundOutRoads;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class GroundCorner extends MyActor {
    public GroundCorner(float x, float y, Stage s, String whichCorner) {
        super(x, y, s);
        switch (whichCorner){
            case "UL" -> textureRegion = Utils.getRegion(16*8,0,16,16);
            case "UR" -> textureRegion = Utils.getRegion(16*10,0,16,16);
            case "DL" -> textureRegion = Utils.getRegion(16*8,16*2,16,16);
            case "DR" -> textureRegion = Utils.getRegion(16*10,16*2,16,16);
        }
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);
    }
}

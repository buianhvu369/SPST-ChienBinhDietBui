package spst.com.Parking;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;

public class RoundCorner extends MyActor {
    public RoundCorner(float x, float y, Stage s, String whichCorner) {
        super(x, y, s);
        switch (whichCorner){
            case "UL" -> textureRegion = Utils.getRegion(16*5,16*16,16,16);
            case "UR" -> textureRegion = Utils.getRegion(16*6,16*16,16,16);
            case "DL" -> textureRegion = Utils.getRegion(16*5,16*17,16,16);
            case "DR" -> textureRegion = Utils.getRegion(16*6,16*17,16,16);
        }
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);
        Master.noPlaced.add(this.getBound());
        Master.roadArray.add(getBound());
        Master.roads.add(this);
    }
}

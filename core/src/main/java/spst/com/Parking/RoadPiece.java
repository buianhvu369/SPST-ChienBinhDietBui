package spst.com.Parking;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class RoadPiece extends MyActor {
    public RoadPiece(float x, float y, Stage s, char whichPiece) {
        super(x, y, s);
        switch (whichPiece){
            case '_' -> textureRegion = Utils.getRegion(16,16*17,16,16);
            case '-' -> textureRegion = Utils.getRegion(16,16*15,16,16);
            case '[' -> textureRegion = Utils.getRegion(16*2,16*17,16,16);
            case ']' -> textureRegion = Utils.getRegion(16*4,16*17,16,16);
        }
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);
    }
}

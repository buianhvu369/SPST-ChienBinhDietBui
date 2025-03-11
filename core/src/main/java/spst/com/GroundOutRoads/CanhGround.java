package spst.com.GroundOutRoads;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class CanhGround extends MyActor {
    public CanhGround(float x, float y, Stage s, char whichCanh) {
        super(x, y, s);
        switch (whichCanh){
            case 'L' -> textureRegion = Utils.getRegion(16*8,16,16,16);
            case 'R' -> textureRegion = Utils.getRegion(16*10,16,16,16);
            case 'U' -> textureRegion = Utils.getRegion(16*9,16*0,16,16);
            case 'D' -> textureRegion = Utils.getRegion(16*9,16*2,16,16);
        }
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);
    }
}

package spst.com.Pool;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class WallPool extends MyActor {
    public WallPool(float x, float y, Stage s, char huong) {
        super(x, y, s);
        if(huong == 'U'){
            textureRegion = Utils.getRegion(9*16, 6*16, 16, 16);
            setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        }else if(huong == 'D'){
            textureRegion = Utils.getRegion(9*16, 8*16, 16, 16);
            setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        }else if(huong == 'L'){
            textureRegion = Utils.getRegion(8*16, 7*16, 16, 16);
            setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        }else if(huong == 'R'){
            textureRegion = Utils.getRegion(10*16, 7*16, 16, 16);
            setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        }
    }
}

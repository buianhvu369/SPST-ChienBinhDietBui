package spst.com.Pool;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class CornerPool extends MyActor {
    public CornerPool(float x, float y, Stage s,String whatCorner) {
        super(x, y, s);
        if(whatCorner.equals("UL")){
            textureRegion = Utils.getRegion(8*16, 6*16, 16, 16);
            setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        }else if(whatCorner.equals("UR")){
            textureRegion = Utils.getRegion(10*16, 6*16, 16, 16);
            setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        }else if(whatCorner.equals("DR")){
            textureRegion = Utils.getRegion(10*16, 8*16, 16, 16);
            setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        }else if(whatCorner.equals("DL")){
            textureRegion = Utils.getRegion(8*16, 8*16, 16, 16);
            setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        }
    }
}

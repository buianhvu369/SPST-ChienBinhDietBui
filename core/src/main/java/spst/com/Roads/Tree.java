package spst.com.Roads;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Tree extends MyActor {
    int loadTree = 0;
    public Tree(float x, float y, Stage s) {
        super(x, y, s);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        loadTree++;
        if(loadTree < 120) {
            textureRegion = Utils.getRegion(0, 0, 0, 0);
            setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        }else  {
            textureRegion = Utils.getRegion(16*16, 8*16, 16, 32);
            setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        }
    }
}

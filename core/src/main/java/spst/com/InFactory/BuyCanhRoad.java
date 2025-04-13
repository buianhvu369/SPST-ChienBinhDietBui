package spst.com.InFactory;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;

public class BuyCanhRoad extends MyActor {
    public BuyCanhRoad(float x, float y, Stage s) {
        super(x, y, s);
        setPosition(x-16,y-16);
        textureRegion = Utils.getRegion(16*1,16*15,16,16);
        setSize(32,32);
        setOrigin(16,16);
        Master.roadArray.add(getBound());
    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

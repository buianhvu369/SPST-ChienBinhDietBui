package spst.com.InFactory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;

public class BuyRoadReNgoai extends MyActor {
    public BuyRoadReNgoai(float x, float y, Stage s) {
        super(x, y, s);
        setPosition(x-16,y-16);
        textureRegion = Utils.getRegion(16*7,16*16,16,16);
        setSize(32,32);
        setOrigin(16,16);
        Master.roadArray.add(getBound());
        Master.reArray.add(this);
        Master.roads.add(this);
    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

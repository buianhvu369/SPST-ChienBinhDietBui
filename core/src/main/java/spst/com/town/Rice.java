package spst.com.town;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Screen.Master;
import spst.com.MyActor;
import spst.com.Utils;

public class Rice extends MyActor {

    public Rice(float x, float y, Stage s) {
        super(x, y, s);
        Master.noPlaced.add(this.getBound());
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        //System.out.println(Master.growth);
        if (Master.growth == 120) {
            textureRegion = Utils.getRegion2(16 * 3, 16 * 2, 16, 16);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);

        }
        if(Master.growth == 180){
            textureRegion = Utils.getRegion2(16 * 3, 0, 16, 32);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
    }
    public void reset(){
        textureRegion = Utils.getRegion(0, 0, 1,1);

    }

}

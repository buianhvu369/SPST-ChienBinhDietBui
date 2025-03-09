package Game.com;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class WindowHouse1 extends MyActor{
    WindowHouse1(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion2(0, 16*7, 16, 16);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }
}

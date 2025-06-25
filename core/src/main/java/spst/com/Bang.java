package spst.com;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Bang extends MyActor{
    public Bang(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(16*9,16*1,16,16);
        setSize(896,476);
        setColor(0,0,0,0.6f);
    }
}

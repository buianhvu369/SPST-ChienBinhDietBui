package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Dark extends MyActor{
    public Dark(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(16*9,16*1,16,16);
        setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        setColor(0,0,0,0);
    }
}

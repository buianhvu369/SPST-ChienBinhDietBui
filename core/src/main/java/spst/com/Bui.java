package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class Bui extends MyActor{
    public Bui(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(16*9,16,16,16);
        setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        setColor(Color.GRAY);
        setColor(getColor().r,getColor().g,getColor().b,0);
        setTouchable(Touchable.disabled);
    }
}

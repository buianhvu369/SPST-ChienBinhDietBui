package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MayLoc extends MyActor{
    public MayLoc(float x, float y, Stage s,float width, float height) {
        super(x, y, s);
        Texture mayloc = new Texture("maylockhongkhi.png");
        setSize(width,height);
    }
}

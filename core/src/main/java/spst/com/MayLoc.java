package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MayLoc extends MyActor{
    Texture mayloc = new Texture("maylockhongkhi.png");
    public MayLoc(float x, float y, Stage s,float width, float height) {
        super(x, y, s);
        textureRegion = new TextureRegion(mayloc);
        setSize(width,height);
    }
}

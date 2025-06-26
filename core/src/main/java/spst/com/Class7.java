package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Class7 extends MyActor{
    public Class7(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("class7.png"));
        setSize(textureRegion.getRegionWidth() , textureRegion.getRegionHeight());
    }
}

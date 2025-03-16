package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ThapRua extends MyActor{
    public ThapRua(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("thaprua.png"));
        setSize(48,96);
    }
}

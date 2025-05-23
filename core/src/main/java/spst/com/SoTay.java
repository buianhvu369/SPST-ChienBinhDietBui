package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SoTay extends MyActor{
    public SoTay(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("sotay.png"));
        setSize(50, 50);
    }
}

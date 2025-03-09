package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Hotel extends MyActor {
    public Hotel(float x, float y, Stage s) {
        super(x, y, s);
        setSize(32*10,32*10);
        textureRegion = new TextureRegion(new Texture("bulding.png"));
    }
}

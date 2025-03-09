package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Waste extends MyActor {
    public Waste(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("waste.png"));
        setSize(32, 32);
    }
}

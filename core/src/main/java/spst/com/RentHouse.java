package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class RentHouse extends MyActor{
    public RentHouse(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("noithue.png"));
        setSize(150, 150);
    }
}

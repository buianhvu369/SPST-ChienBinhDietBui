package spst.com.InFactory.Items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Shovel extends MyActor {
    public Shovel(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("Shovel.png"));
        setSize(32,32*2);
    }
}

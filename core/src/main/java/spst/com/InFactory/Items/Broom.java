package spst.com.InFactory.Items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class Broom extends MyActor {
    public Broom(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("broom.png"));
        setSize(32,32*2);
    }
}

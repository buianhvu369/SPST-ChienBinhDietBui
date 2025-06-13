package spst.com.InFactory.Items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class Ax extends MyActor {
    public Ax(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("ax.png"));
        setSize(32,32*2);
    }
}

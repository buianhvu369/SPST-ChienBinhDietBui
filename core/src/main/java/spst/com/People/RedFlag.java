package spst.com.People;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class RedFlag extends MyActor {
    public RedFlag(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("redflag.png"));
        setSize(32*5,32*5);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }
}

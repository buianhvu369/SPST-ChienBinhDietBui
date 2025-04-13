package spst.com.Button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class PlayTurtleMap extends MyActor {
    Texture texture = new Texture("play.png");
    public PlayTurtleMap(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(texture);
        setSize(textureRegion.getRegionWidth()/1.5f, textureRegion.getRegionHeight()/1.5f);
    }
}

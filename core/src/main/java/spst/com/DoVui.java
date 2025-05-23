package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class DoVui extends MyActor{
    public DoVui(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("mini quiz.png"));
        setSize(textureRegion.getRegionWidth()/7, textureRegion.getRegionHeight()/7);
    }
}

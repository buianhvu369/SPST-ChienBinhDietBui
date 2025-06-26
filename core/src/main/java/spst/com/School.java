package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class School extends MyActor{
    public School(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("school.png"));
        setSize(textureRegion.getRegionWidth()/2.5f, textureRegion.getRegionHeight()/2.5f);
    }
}

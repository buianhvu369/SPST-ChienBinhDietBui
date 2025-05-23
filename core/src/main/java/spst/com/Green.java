package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Green extends MyActor{
    public Green(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("green.png")));
        setSize(textureRegion.getRegionWidth()/7, textureRegion.getRegionHeight()/7);
    }
}

package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Class6 extends MyActor{
    public Class6(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("class6.png"));
        setSize(textureRegion.getRegionWidth() , textureRegion.getRegionHeight());
    }
}

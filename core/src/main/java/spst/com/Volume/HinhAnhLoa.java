package spst.com.Volume;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class HinhAnhLoa extends MyActor {
    public HinhAnhLoa(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("hinhanhloa.png"));
        setSize(textureRegion.getRegionWidth()/15, textureRegion.getRegionHeight()/15);
        setColor(1,0.1f,0.5f,1);
    }
}

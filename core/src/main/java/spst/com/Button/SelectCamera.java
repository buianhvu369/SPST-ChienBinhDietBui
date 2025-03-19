package spst.com.Button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class SelectCamera extends MyActor {
    public SelectCamera(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("noCamera.png"));
        setSize(80,80);
    }
}

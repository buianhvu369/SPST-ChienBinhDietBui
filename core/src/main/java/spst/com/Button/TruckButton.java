package spst.com.Button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class TruckButton extends MyActor {
    public TruckButton(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("trashtruckright.png"));
        setSize(59,24);
    }
}

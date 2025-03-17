package spst.com.Button.ButtonTrongNghienCuuScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class ButtonRightMLKK extends MyActor {
    public ButtonRightMLKK(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("muitenphai.png"));
        setSize(textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
    }
}

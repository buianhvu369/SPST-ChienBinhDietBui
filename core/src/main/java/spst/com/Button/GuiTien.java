package spst.com.Button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class GuiTien extends MyActor {
    public GuiTien(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("deposit.png"));
        setSize(192,64);
    }
}

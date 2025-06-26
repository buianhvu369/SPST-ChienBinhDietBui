package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BangLop extends MyActor{
    public BangLop(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("banglop.png"));
        setSize(960 , 540);
    }
}

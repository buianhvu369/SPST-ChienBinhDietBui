package spst.com.Volume;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class ThanhControl extends MyActor {
    public ThanhControl(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("thanhvolume.png"));
        setSize(200+19.2f, textureRegion.getRegionHeight()/2.5f);
        setColor(Color.PINK);
    }
}

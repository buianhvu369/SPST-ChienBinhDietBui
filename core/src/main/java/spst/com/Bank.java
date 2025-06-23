package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Bank extends MyActor{
    public Bank(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("bank.png"));
        setSize((float)textureRegion.getRegionWidth()/2, (float)textureRegion.getRegionHeight()/2);
    }
}

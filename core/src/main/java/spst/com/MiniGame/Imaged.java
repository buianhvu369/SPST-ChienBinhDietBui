package spst.com.MiniGame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class Imaged extends MyActor {
    Texture texture = new Texture("camera1.png");
    Texture texture1 = new Texture("sign.png");
    Texture texture2 = new Texture("green.png");
    Texture texture3 = new Texture("energy.jpg");
    public Imaged(float x, float y, Stage s, int image) {
        super(x, y, s);
        if (image == 1) {
            textureRegion = Utils.getRegion(16 * 16, 8 * 16, 16, 32);
            setSize(textureRegion.getRegionWidth() , textureRegion.getRegionHeight());
        }if(image == 2) {
            textureRegion = new TextureRegion(texture);
            setSize(32 ,32);
        }if(image == 3) {
            textureRegion = new TextureRegion(texture1);
            setSize(textureRegion.getRegionWidth()/2, textureRegion.getRegionHeight()/2);
        }if(image == 4) {
            textureRegion = new TextureRegion(texture2);
            setSize(32, 32);
        }if(image == 5) {
            textureRegion = new TextureRegion(texture3);
            setSize(32, 32);
        }
    }
}

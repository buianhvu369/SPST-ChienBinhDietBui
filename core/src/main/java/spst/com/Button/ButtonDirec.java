package spst.com.Button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class ButtonDirec extends MyActor {
    public ButtonDirec(float x, float y,char direc, Stage s) {
        super(x, y, s);
        if(direc == 'U'){
            textureRegion = new TextureRegion(new Texture("muitenlen.png"));
        }if(direc == 'D'){
            textureRegion = new TextureRegion(new Texture("muitenduoi.png"));
        }
        setSize(textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
    }
}

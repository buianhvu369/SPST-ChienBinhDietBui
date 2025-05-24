package spst.com.Button.InItemsButton;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class CamVotRac extends MyActor {
    public boolean isSong = false;
    public Texture texture = new Texture("noChoi.png");
    public Texture texture1 = new Texture("yesChoi.png");
    public CamVotRac(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(texture);
        setSize(40,40);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isSong){
            isSong = false;
            textureRegion = new TextureRegion(texture);
        }
    }
}

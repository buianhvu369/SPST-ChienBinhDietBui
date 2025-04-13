package spst.com.Button.InItemsButton;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.MyActor;
import spst.com.Screen.Master;

public class CamXeng extends MyActor {
    public boolean isSong = false;
    public Texture texture = new Texture("noXeng.png");
    public Texture texture1 = new Texture("yesXeng.png");
    public CamXeng(float x, float y, Stage s) {
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

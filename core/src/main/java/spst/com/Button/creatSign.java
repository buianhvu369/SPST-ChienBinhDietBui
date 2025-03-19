package spst.com.Button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.MyActor;
import spst.com.Screen.Master;

public class creatSign extends MyActor {
    public boolean isSong = false;
    Texture texture = new Texture("noSign.png");
    Texture texture1 = new Texture("yesSign.png");
    public creatSign(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(texture);
        setSize(80,80);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(!Master.whatActionIfClickMouse.equals("createSign")) {
                    Master.whatActionIfClickMouse = "createSign";
                    textureRegion = new TextureRegion(texture1);
                }else{
                    Master.whatActionIfClickMouse = "move";
                    textureRegion = new TextureRegion(texture);
                }
            }
        });
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

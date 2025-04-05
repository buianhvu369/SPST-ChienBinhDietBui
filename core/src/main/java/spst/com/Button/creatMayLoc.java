package spst.com.Button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.MyActor;
import spst.com.Screen.Master;

public class creatMayLoc extends MyActor {
    public boolean isSong = false;
    Texture texture = new Texture("noMLKK.png");
    Texture texture1 = new Texture("yesMLKK.png");
    public creatMayLoc(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(texture);
        setSize(40,40);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(!Master.whatActionIfClickMouse.equals("createMayLoc")) {
                    Master.whatActionIfClickMouse = "createMayLoc";
                    textureRegion = new TextureRegion(texture1);
                }else{
                    Master.whatActionIfClickMouse = "move";
                    textureRegion = new TextureRegion(texture);
                }
                if(Master.soMayLoc < 1){
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

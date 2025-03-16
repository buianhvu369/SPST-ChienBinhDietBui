package spst.com.town;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import spst.com.MyActor;
import spst.com.Screen.Master;

public class TreeButon extends MyActor {
    public TreeButon(float x, float y, Stage s) {
        super(x, y, s);
        Texture texture = new Texture("no.png");
        Texture texture1 = new Texture("yes.png");
        textureRegion = new TextureRegion(texture);
        setSize(80,80);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(!Master.whatActionIfClickMouse.equals("planttree")){
                    Master.whatActionIfClickMouse = "planttree";
                    textureRegion = new TextureRegion(texture1);
                }else{
                    Master.whatActionIfClickMouse = "move";
                    textureRegion = new TextureRegion(texture);
                }
            }
        });
    }
}

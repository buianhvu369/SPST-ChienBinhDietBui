package spst.com.Button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.MyActor;
import spst.com.Screen.Master;

public class TreeButon extends MyActor {
    Texture texture = new Texture("no.png");
    Texture texture1 = new Texture("yes.png");
    public TreeButon(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(texture);
        setSize(40,40);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(!Master.whatActionIfClickMouse.equals("planttree")){
                    Master.whatActionIfClickMouse = "planttree";
                    textureRegion = new TextureRegion(texture1);
                    if(Master.thuTuNhiemVuTanBinh == 5){
                        Master.thuTuNhiemVuTanBinh ++;
                        Master.nhiemVuTanBinh = true;
                    }
                }else{
                    Master.whatActionIfClickMouse = "move";
                    textureRegion = new TextureRegion(texture);
                }
            }
        });

    }
}

package spst.com.town;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class Fire extends MyActor {
    Texture texture = new Texture("fire.png");
    int time = 60*5;
    public Fire(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(texture);
        setSize(26,39);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time--;
        if(time <= 0) {
            remove();
        }
    }
}

package spst.com.town;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class Truck extends MyActor {
    public Truck(float x, float y, Stage s) {
        super(x, y, s);
        this.textureRegion = new TextureRegion(new Texture("truck.png")) ;
        setSize(32*2.5f, 32*2.5f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }

}

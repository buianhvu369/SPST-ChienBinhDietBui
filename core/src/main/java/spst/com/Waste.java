package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Screen.Master;

public class Waste extends MyActor {
    boolean isFire;
    public Waste(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("waste.png"));
        setSize(32, 32);
        Master.noPlaced.add(this.getBound());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isFire){
            textureRegion = new TextureRegion(new Texture("wastefire.png"));
        }
    }
}

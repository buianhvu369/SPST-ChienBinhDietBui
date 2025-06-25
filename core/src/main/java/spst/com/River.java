package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import spst.com.Screen.Master;

public class River extends MyActor{


    public River(float x, float y, Stage s) {
        super(x, y, s);

        textureRegion = new TextureRegion(new Texture("river1.png"));

        setSize(4*32, 800);
        Master.noPlaced.add(this.getBound());
    }
}

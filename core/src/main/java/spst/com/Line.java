package spst.com;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Line extends MyActor{
    public Line(float x, float y, int width, int height, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(16*9,16,16,16);
        setColor(Color.BLACK);
        setSize(width,height);
    }
}

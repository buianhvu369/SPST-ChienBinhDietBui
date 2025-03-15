package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Boat extends MyActor{
    float speedY = MathUtils.random(-1f , -0.2f);
    public Boat(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("boat.png"));
        setSize(16, 16);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(getY() < -50){
            rotateBy(180);
            speedY = MathUtils.random(0.1f , 1f);
        }
        if(getY() > 800){
            rotateBy(180);
            speedY = MathUtils.random(-1f , -0.2f);
        }
        moveBy(0, speedY);
    }
}

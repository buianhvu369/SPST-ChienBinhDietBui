package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Car extends MyActor{
    int speedX = 1;
    Car(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(15*16, 16*16, 32, 32);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(getX() < -50){
            speedX = 1;
        } else if (getX() > Gdx.graphics.getWidth() + 50) {
            speedX = -1;
        }
        moveBy(speedX, 0);
    }
}

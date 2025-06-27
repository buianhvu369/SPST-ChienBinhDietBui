package spst.com.InFactory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;

public class BuyRoad extends MyActor {
    TextureRegion textureRegion2;
    TextureRegion textureRegion3;
    public char direction = 'N';
    public BuyRoad(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(16,16*17,16,16);
        textureRegion2 = Utils.getRegion(16,16*16,16,16);
        textureRegion3 = Utils.getRegion(16,16*15,16,16);
        Master.roadArray.add(getBound());
        Master.roads.add(this);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        switch (direction){
            case 'D' -> {
                setSize(32*3,32);
                batch.draw(textureRegion, getX(), getY()+32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation()-90);
                batch.draw(textureRegion2, getX()+32, getY()+32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation()-90);
                batch.draw(textureRegion3, getX() + 32 * 2, getY()+32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation()-90);
            }
            case 'N' -> {
                setSize(32,32*3);
                batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                batch.draw(textureRegion2, getX(), getY()+32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                batch.draw(textureRegion3, getX(), getY() + 32 * 2, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
            }
        }
    }
}

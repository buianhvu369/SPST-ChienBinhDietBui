package spst.com.ScienceHouse;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class ScienceCenter extends MyActor {
    TextureRegion textureRegionCol;
    TextureRegion textureRegionFront;
    TextureRegion textureRegion3;
    TextureRegion textureRegion4;
    TextureRegion textureRegion5;
    TextureRegion textureRegion6;
    TextureRegion textureRegion7;
    TextureRegion textureRegion8;
    TextureRegion textureRegionDoor;
    TextureRegion textureRegionWindow;
    TextureRegion textureRegionWindowBig;

    public ScienceCenter(float x, float y, Stage s) {
        super(x, y, s);
        textureRegionCol = Utils.getRegion(16*16, 4*16, 16, 4*16);
        textureRegionFront = Utils.getRegion(20*16, 4*16, 3*16, 4*16);
        textureRegion3 = Utils.getRegion(8*16, 3*16, 16, 16);
        textureRegion4 = Utils.getRegion(8*16, 5*16, 16, 16);

        textureRegion5 = Utils.getRegion(9*16, 3*16, 16, 16);
        textureRegion6 = Utils.getRegion(10*16, 3*16, 16, 16);

        textureRegion7 = Utils.getRegion(9*16, 5*16, 16, 16);
        textureRegion8 = Utils.getRegion(10*16, 5*16, 16, 16);

        textureRegionDoor = Utils.getRegion(7*16, 15*16, 2*16, 16);
        textureRegionWindow = Utils.getRegion(11*16, 15*16, 16, 16);
        textureRegionWindowBig = Utils.getRegion(11*16, 16*16, 16, 2*16);

        setSize(4*32, 6*32);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        float x = getX();
        float y = getY();
        batch.draw(textureRegionCol, getX(), getY(), getOriginX(), getOriginY(), 32, 96, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegionFront, getX() + 32, getY(), getOriginX(), getOriginY(), 64, 96, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegionCol, getX() + 96, getY(), getOriginX(), getOriginY(), 32, 96, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion3, x, y + 4 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion4, x, y + 3 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion5, x + 32, y + 4 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion5, x + 64, y + 4 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion6, x + 96, y + 4 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());

        batch.draw(textureRegion7, x + 32, y + 3 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion7, x + 64, y + 3 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion8, x + 96, y + 3 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegionDoor, x + 32, y, getOriginX(), getOriginY(), 64, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegionWindow, x , y + 40, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegionWindow, x , y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegionWindow, x + 96 , y + 40, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegionWindow, x + 96, y, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegionWindowBig, x + 32, y + 50, getOriginX(), getOriginY(), 32, 40, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegionWindowBig, x + 64, y + 50, getOriginX(), getOriginY(), 32, 40, getScaleX(), getScaleY(), getRotation());
    }
}

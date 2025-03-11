package spst.com.House;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class ScienceCenter extends MyActor {
    TextureRegion textureRegion1;
    TextureRegion textureRegion2;
    TextureRegion textureRegion3;
    TextureRegion textureRegion4;
    TextureRegion textureRegion5;
    TextureRegion textureRegion6;
    TextureRegion textureRegion7;
    TextureRegion textureRegion8;

    public ScienceCenter(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion1 = Utils.getRegion(16*16, 4*16, 16, 4*16);
        textureRegion2 = Utils.getRegion(20*16, 4*16, 3*16, 4*16);
        textureRegion3 = Utils.getRegion(8*16, 3*16, 16, 16);
        textureRegion4 = Utils.getRegion(8*16, 5*16, 16, 16);

        textureRegion5 = Utils.getRegion(9*16, 3*16, 16, 16);
        textureRegion6 = Utils.getRegion(10*16, 3*16, 16, 16);

        textureRegion7 = Utils.getRegion(9*16, 5*16, 16, 16);
        textureRegion8 = Utils.getRegion(10*16, 5*16, 16, 16);

        setSize(4*32, 6*32);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        float x = getX();
        float y = getY();
        batch.draw(textureRegion1, getX(), getY(), getOriginX(), getOriginY(), 32, 128, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion2, getX() + 32, getY(), getOriginX(), getOriginY(), 64, 128, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion1, getX() + 96, getY(), getOriginX(), getOriginY(), 32, 128, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion3, x, y + 5 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion4, x, y + 4 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion5, x + 32, y + 5 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion5, x + 64, y + 5 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion6, x + 96, y + 5 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());

        batch.draw(textureRegion7, x + 32, y + 4 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion7, x + 64, y + 4 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegion8, x + 96, y + 4 * 32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
    }
}

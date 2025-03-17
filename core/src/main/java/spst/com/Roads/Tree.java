package spst.com.Roads;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;

public class Tree extends MyActor {
    public boolean isCutDown = false;
    public Tree(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(16 * 16, 8 * 16, 16, 32);
        setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(isCutDown){
            TextureRegion root = Utils.getRegion(16 * 16, 9 * 16, 16, 16);
            batch.draw(root, getX(), getY(), getOriginX(), getOriginY(), getWidth(), 32, getScaleX(), getScaleY(), getRotation());
            TextureRegion branch = Utils.getRegion(16 * 16, 8 * 16, 16, 16);
            batch.draw(branch, getX() + 16, getY() + 32, getOriginX(), getOriginY(), getWidth(), 32, getScaleX(), getScaleY(), getRotation() - 135);
        } else {
            super.draw(batch, parentAlpha);
        }
    }
}

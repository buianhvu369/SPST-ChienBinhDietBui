package spst.com.Roads;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.GameState;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;

public class Tree extends MyActor {
    public boolean isCutDown = false;
    int time = 0;
    public Tree(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(16 * 16, 8 * 16, 16, 32);
        setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time ++;
        if(time == 30){
            GameState.money--;
        }
        if(GameState.money >= 1) {
            if (GameState.PM10 >= 0.0007f / 60f) {
                GameState.PM10 -= 0.0007f / 60f;
            }
            if (GameState.PM2_5 >= 0.0088f / 60f) {
                GameState.PM2_5 -= 0.0088f / 60f;
            }
            if (GameState.CO1 >= 0.009f / 60f) {
                GameState.CO1 -= 0.009f / 60f;
            }
            if (GameState.O3 >= 0.0098f / 60f) {
                GameState.O3 -= 0.0098f / 60f;
            }
        }
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

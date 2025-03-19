package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Screen.Master;

public class MayLoc extends MyActor{
    public String name;
    public int level = 1;
    Texture mayloc = new Texture("maylockhongkhi.png");
    public MayLoc(float x, float y, Stage s,float width, float height) {
        super(x, y, s);
        textureRegion = new TextureRegion(mayloc);
        setSize(width,height);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(Master.mLKKAction) {
            if (GameState.PM2_5 >= 6 + (level - 1) * 2 / 60f) {
                GameState.PM2_5 -= (6 + (level - 1) * 2) / 60f;
            } else {
                GameState.PM2_5 = 0;
            }
            if (GameState.NO2 >= 4 + (level - 1) * 1 / 60f) {
                GameState.NO2 -= (4 + (level - 1) * 1) / 60f;
            } else {
                GameState.NO2 = 0;
            }
        }
    }
}

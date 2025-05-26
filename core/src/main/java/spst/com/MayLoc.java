package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Screen.Master;

public class MayLoc extends MyActor{
    public String name;
    public int level = 1;
    public int time = 0;
    Texture mayloc = new Texture("maylockhongkhi.png");
    public MayLoc(float x, float y, Stage s,float width, float height) {
        super(x, y, s);
        textureRegion = new TextureRegion(mayloc);
        setSize(width,height);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time++;
        if(Master.mLKKAction && GameState.ernegy >= 5) {
            if (GameState.PM2_5 >= 0.5f + (level - 1) * 0.08f / 60f) {
                GameState.PM2_5 -= (0.5f + (level - 1) * 0.08f) / 60f;
            } else {
                GameState.PM2_5 = 0;
            }
            if (GameState.NO2 >= 0.07f + (level - 1) * 0.015f / 60f) {
                GameState.NO2 -= (0.07f + (level - 1) * 0.015f) / 60f;
            } else {
                GameState.NO2 = 0;
            }
        }
        if(time%60 == 0 && GameState.ernegy >= 5+(level-1) && Master.mLKKAction){
            GameState.ernegy -= 5+(level-1);
        }
    }
}

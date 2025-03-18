package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Screen.Master;

public class MayLoc extends MyActor{
    public String name;
    public int level;
    Texture mayloc = new Texture("maylockhongkhi.png");
    public MayLoc(float x, float y, Stage s,float width, float height) {
        super(x, y, s);
        textureRegion = new TextureRegion(mayloc);
        setSize(width,height);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(Master.timeOfDay%60==0){
            if(GameState.PM2_5>=6+(level-1)*2){
                GameState.PM2_5 -=6+(level-1)*2;
            }else{
                GameState.PM2_5 = 0;
            }
            if(GameState.NO2 >= 4+(level-1)*1){
                GameState.NO2 -= 4+(level-1)*1;
            }else{
                GameState.NO2 = 0;
            }
        }
    }
}

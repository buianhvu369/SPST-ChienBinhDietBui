package spst.com.Button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.GameState;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;

public class Sign extends MyActor {
    boolean isFire = false;
    boolean thisCamDotRac;
    public Sign(float x, float y,boolean isCamDotRac, Stage s) {
        super(x, y, s);
        if(isCamDotRac){
            textureRegion = new TextureRegion(new Texture("signCAMDOTRAC.png"));
        }else {
            textureRegion = new TextureRegion(new Texture("signCAMCHATCAY.png"));
        }
        thisCamDotRac = isCamDotRac;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(Master.timeOfDay%60==0){
            if(GameState.PM2_5>=6f){
                GameState.PM2_5 = 6f;
            }
            if(GameState.SO2 >= 5){
                GameState.SO2 -= 5;
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(isFire){
            textureRegion = new TextureRegion(new Texture("signfire.png"));
        }
        super.draw(batch, parentAlpha);
    }
}

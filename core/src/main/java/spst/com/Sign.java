package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.GameState;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;

public class Sign extends MyActor {
    public boolean isFire = false;
    int time = 0;
    public boolean myIsCamDotRac;
    public Sign(float x, float y,boolean isCamDotRac, Stage s) {
        super(x, y, s);
        if(isCamDotRac){
            textureRegion = new TextureRegion(new Texture("signCAMDOTRAC.png"));
        }else {
            textureRegion = new TextureRegion(new Texture("signCAMCHATCAY.png"));
        }
        myIsCamDotRac = isCamDotRac;
        setSize(45,45);
        Master.signs.add(this);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time++;
        if(time % 60 == 0 && GameState.money >= 1){
            GameState.money--;
        }
        if(GameState.money >= 1) {
            if (GameState.PM2_5 >= 6 / 60f) {
                GameState.PM2_5 -= 6 / 60f;
            } else {
                GameState.PM2_5 = 0;
            }
            if (GameState.SO2 >= 5 / 60f) {
                GameState.SO2 -= 5 / 60f;
            } else {
                GameState.SO2 = 0;
            }
        }
        if(isFire){
            textureRegion = new TextureRegion(new Texture("signfire.png"));
        }
    }
//
//    @Override
//    public void draw(Batch batch, float parentAlpha) {
//        if(isFire){
//            textureRegion = new TextureRegion(new Texture("signfire.png"));
//        }
//        super.draw(batch, parentAlpha);
//    }
}

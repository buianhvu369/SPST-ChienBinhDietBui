package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.Screen.Master;

public class Hieu extends MyActor{
    public Hieu(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("dahieu.png"));
        setSize(200,100);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(Master.inGreenCoBan){
                    GameState.greenscore += 2;
                }if(Master.inShock){
                    if(Master.trongHopShock == 1){
                        GameState.money += 500;
                    }if(Master.trongHopShock == 2){
                        GameState.greenscore += 20;
                    }if(Master.trongHopShock == 3){
                        Master.soMayLoc++;
                    }if(Master.trongHopShock == 4){
                        GameState.ernegy += 100;
                    }if(Master.trongHopShock == 5){
                        GameState.money += 400;
                    }if(Master.trongHopShock == 6){
                        GameState.greenscore += 30;
                    }if(Master.trongHopShock == 7){
                        GameState.ernegy += 120;
                    }if(Master.trongHopShock == 8){
                        GameState.greenscore += 25;
                    }if(Master.trongHopShock == 9){
                        Master.soMayLoc += 1;
                    }if(Master.trongHopShock == 10){
                        GameState.money += 600;
                    }
                }
                Master.inShock = false;
                Master.inGreenCoBan = false;
                Master.shock. setSize(Master.shock.textureRegion.getRegionWidth()/7, Master.shock.textureRegion.getRegionHeight()/7);
                Master.green. setSize(Master.green.textureRegion.getRegionWidth()/7, Master.green.textureRegion.getRegionHeight()/7);
                Master.doVui. setSize(Master.doVui.textureRegion.getRegionWidth()/7, Master.doVui.textureRegion.getRegionHeight()/7);

            }
        });
    }
}

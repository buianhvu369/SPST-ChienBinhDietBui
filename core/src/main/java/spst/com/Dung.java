package spst.com;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.Screen.Master;

public class Dung extends MyActor{
    public Dung(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("dung.png")));
        setSize(100,50);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Master.answered = true;
                if(Master.inDoVui){
                    if(Master.trongHopDoVui == 3
                    || Master.trongHopDoVui == 4
                    || Master.trongHopDoVui == 5
                    || Master.trongHopDoVui == 7
                    || Master.trongHopDoVui == 9){
                        GameState.greenscore+= 5;
                        Master.answerRight = true;
                    }else {
                        Master.answerRight = false;
                    }
                }
            }
        });

    }
    @Override
    public void act(float delta) {
        super.act(delta);
        if(Master.answered){
            if(Master.thoiGianHien == 120){
                Master.inDoVui = false;
                Master.shock. setSize(Master.shock.textureRegion.getRegionWidth()/7, Master.shock.textureRegion.getRegionHeight()/7);
                Master.green. setSize(Master.green.textureRegion.getRegionWidth()/7, Master.green.textureRegion.getRegionHeight()/7);
                Master.doVui. setSize(Master.doVui.textureRegion.getRegionWidth()/7, Master.doVui.textureRegion.getRegionHeight()/7);
                Master.thoiGianHien = 0;
                Master.answered = false;
            }
        }
    }
}

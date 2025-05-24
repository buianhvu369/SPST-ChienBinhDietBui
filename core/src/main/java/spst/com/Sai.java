package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.Screen.Master;

public class Sai extends MyActor{
    public Sai(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("sai.png")));
        setSize(100,50);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(Master.inDoVui){
                    if(Master.trongHopDoVui == 1
                            || Master.trongHopDoVui == 2
                            || Master.trongHopDoVui == 6
                            || Master.trongHopDoVui == 8
                            || Master.trongHopDoVui == 10){
                        GameState.greenscore+= 5;

                    }
                    Master.inDoVui = false;
                    Master.shock. setSize(Master.shock.textureRegion.getRegionWidth()/7, Master.shock.textureRegion.getRegionHeight()/7);
                    Master.green. setSize(Master.green.textureRegion.getRegionWidth()/7, Master.green.textureRegion.getRegionHeight()/7);
                    Master.doVui. setSize(Master.doVui.textureRegion.getRegionWidth()/7, Master.doVui.textureRegion.getRegionHeight()/7);

                }
            }
        });
    }
}

package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.Screen.Master;

public class Green extends MyActor{
    public Green(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal("green.png")));
        setSize(textureRegion.getRegionWidth()/7, textureRegion.getRegionHeight()/7);
        addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(!Master.inShock&&!Master.inGreenCoBan && !Master.inDoVui&& Master.soCauDoGreen >= 1){
                    Master.inGreenCoBan =  true;
                    setSize(textureRegion.getRegionWidth()/6.5f, textureRegion.getRegionHeight()/6.5f);
                    int ran = MathUtils.random(1,10);
                    switch (ran){
                        case 1 ->Master.trongHopGreen = 1;
                        case 2 ->Master.trongHopGreen = 2;
                        case 3 ->Master.trongHopGreen= 3;
                        case 4 ->Master.trongHopGreen = 4;
                        case 5 ->Master.trongHopGreen = 5;
                        case 6 ->Master.trongHopGreen = 6;
                        case 7 ->Master.trongHopGreen = 7;
                        case 8 ->Master.trongHopGreen = 9;
                        case 9 ->Master.trongHopGreen = 8;
                        case 10 ->Master.trongHopGreen = 10;
                    }
                    Master.soCauDoGreen--;
                }
            }
        });
    }
}

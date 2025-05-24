package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.Screen.Master;

public class DoVui extends MyActor{
    public DoVui(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("mini quiz.png"));
        setSize(textureRegion.getRegionWidth()/7, textureRegion.getRegionHeight()/7);
        addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(!Master.inShock&&!Master.inGreenCoBan && !Master.inDoVui&& Master.soCauDoVui >= 1){
                    Master.inDoVui =  true;
                    setSize(textureRegion.getRegionWidth()/6.5f, textureRegion.getRegionHeight()/6.5f);
                    int ran = MathUtils.random(1,10);
                    switch (ran){
                        case 1 ->Master.trongHopDoVui = 1;
                        case 2 ->Master.trongHopDoVui = 2;
                        case 3 ->Master.trongHopDoVui = 3;
                        case 4 ->Master.trongHopDoVui = 4;
                        case 5 ->Master.trongHopDoVui = 5;
                        case 6 ->Master.trongHopDoVui = 6;
                        case 7 ->Master.trongHopDoVui = 7;
                        case 8 ->Master.trongHopDoVui = 9;
                        case 9 ->Master.trongHopDoVui = 8;
                        case 10 ->Master.trongHopDoVui = 10;
                    }
                    Master.soCauDoVui--;

                   }
            }
        });
    }
}

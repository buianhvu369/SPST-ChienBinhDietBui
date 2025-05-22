package spst.com.town;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.GameState;
import spst.com.MyActor;
import spst.com.Roads.Restaurant;
import spst.com.Screen.Master;

public class Kem extends MyActor {
    public Kem(float x, float y, Stage s, Master m) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("kemtrangtien.png"));
        addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                    GameState.money -= 100;
                    GameState.PM10 += 10;
                    GameState.PM2_5 += 10;
                    GameState.SO2 += 10;
                    GameState.CO1 += 10;
                    GameState.O3 += 10;
                    GameState.NO2 += 10;
                    Restaurant.isCreateFood = true;
                    m.closeMenuFood();
                    if(Master.nhiemvu3 == 6){
                        Master.nhiemvu3 = 77;
                        GameState.money += 200;
                    }

            }
        });
        setSize(textureRegion.getRegionWidth()/3, textureRegion.getRegionHeight()/3);
    }
    @Override
    public void act(float delta) {
        super.act(delta);
        if(Master.isEating){
            float v = 30f/600 ;
            Master.amountOfFood += v;
        }
    }
}

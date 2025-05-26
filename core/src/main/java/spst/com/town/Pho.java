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

public class Pho extends MyActor {
    public Pho(float x, float y, Stage s, Master m) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("pho.png"));
        addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                    Master.amountOfFood += 70;
                    GameState.money -= 225;
                    GameState.PM10 += 20;
                    GameState.PM2_5 += 20;
                    GameState.SO2 += 20;
                    GameState.CO1 += 20;
                    GameState.O3 += 20;
                    GameState.NO2 += 20;
                    Restaurant.isCreateFood = true;
                    m.closeMenuFood();
                    if(Master.nhiemvu3== 5){
                        Master.nhiemvu3=77;
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
            float v = 70f/600;
            Master.amountOfFood += v;
        }
    }
}

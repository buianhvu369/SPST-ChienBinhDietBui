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

public class Com extends MyActor {
    public Com(float x, float y, Stage s, Master m) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("comlangvong.png"));
        addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                    Master.amountOfFood += 50;
                    GameState.money -= 275;
                    GameState.PM10 += 5;
                    GameState.PM2_5 += 5;
                    GameState.SO2 += 5;
                    GameState.CO1 += 5;
                    GameState.O3 += 5;
                    GameState.NO2 += 5;
                    Restaurant.isCreateFood = true;
                    m.closeMenuFood();
            }
        });
        setSize(textureRegion.getRegionWidth()/3, textureRegion.getRegionHeight()/3);
    }
}

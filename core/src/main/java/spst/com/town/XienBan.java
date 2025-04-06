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

public class XienBan extends MyActor {
    public XienBan(float x, float y, Stage s, Master m) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("xienban.png"));
        addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                    Master.amountOfFood += 60;
                    GameState.money -= 150;
                    GameState.PM10 += 25;
                    GameState.PM2_5 += 25;
                    GameState.SO2 += 25;
                    GameState.CO1 += 25;
                    GameState.O3 += 25;
                    GameState.NO2 += 25;
                    Restaurant.isCreateFood = true;
                    m.closeMenuFood();
            }
        });
        setSize(textureRegion.getRegionWidth()/3, textureRegion.getRegionHeight()/3);
    }
}

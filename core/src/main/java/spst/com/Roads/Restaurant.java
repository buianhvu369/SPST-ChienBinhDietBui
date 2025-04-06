package spst.com.Roads;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.FloatingNews;
import spst.com.GameState;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;

public class Restaurant extends MyActor {
    public static boolean  isCreateFood = false;
    int time = 0;
    public Restaurant(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("restaurant.png"));
        setSize(textureRegion.getRegionWidth()/2, textureRegion.getRegionHeight()/2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isCreateFood) {
            if(Master.amountOfFood > 100) {
                Master.amountOfFood = 100;
            }
            Master.isEating = true;
        }
        if(Master.isEating) {
            time++;
            if(time% 600 == 0){
                time = 0;
                isCreateFood = false;
                Master.isEating = false;
            }
        }
    }
}

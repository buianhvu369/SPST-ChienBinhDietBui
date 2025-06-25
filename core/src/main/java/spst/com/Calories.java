package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Screen.Master;

public class Calories extends MyActor{
    public Calories(float x, float y, Stage s) {
        super(x, y, s);
        setColor(Color.RED);
        textureRegion = Utils.getRegion(16*9,16,16,16);
        setSize(32, textureRegion.getRegionHeight());
        setScale(1f,0.3f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setScale(Master.amountOfFood/100f,0.3f);
        if(Master.amountOfFood <= 25){
            setColor(Color.RED);
        }else if(Master.amountOfFood <= 50){
            setColor(Color.ORANGE);
        }else if(Master.amountOfFood <= 75){
            setColor(Color.YELLOW);
        }else if(Master.amountOfFood <= 100){
            setColor(Color.GREEN);
        }
    }
}

package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Screen.Master;

public class ShowAQI extends MyActor {
    public ShowAQI(float x, float y, Stage s){
        super(x,y,s);
        setColor(Color.RED);
        textureRegion = Utils.getRegion(16*9,16,16,16);
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        setScale(100,0.5f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setScale(Master.AQI/10f,0.5f);
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            Master.AQI--;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.B)){
            Master.AQI++;
        }
        if(Master.AQI<=50){
            setColor(Color.GREEN);
        }else if(Master.AQI<=100){
            setColor(Color.YELLOW);
        }else if(Master.AQI<=150){
            setColor(Color.ORANGE);
        }else if(Master.AQI<=200){
            setColor(Color.RED);
        }else if(Master.AQI<=300){
                setColor(Color.PURPLE);
        }else if(Master.AQI<=500){
            setColor(Color.BROWN);
        }
    }
}

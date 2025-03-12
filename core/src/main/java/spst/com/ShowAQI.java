package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.security.Key;

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
        setScale(Master.AQI/2f,0.5f);
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            Master.AQI--;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.B)){
            Master.AQI++;
        }
        if(Master.AQI<30){
            setColor(Color.GREEN);
        }else if(30<=Master.AQI && Master.AQI<=60){
            setColor(Color.YELLOW);
        }else if(60<Master.AQI){
            setColor(Color.RED);
        }
    }
}

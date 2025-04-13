package spst.com.Button;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Screen.Master;

import java.awt.*;

public class Button7C extends ButtonActor{
    Texture texture = new Texture("9.png");
    public Button7C(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(texture);
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(Master.buyGTX){
            setColor(Color.GRAY);
        }
    }
}

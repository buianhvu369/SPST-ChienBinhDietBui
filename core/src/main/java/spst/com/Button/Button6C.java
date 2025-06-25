package spst.com.Button;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Screen.Master;

public class Button6C extends ButtonActor{
    Texture texture = new Texture("8.png");
    public Button6C(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(texture);
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }
    @Override
    public void act(float delta) {
        super.act(delta);
        if(Master.buyCNX){
            setColor(Color.GRAY);
        }
    }
}

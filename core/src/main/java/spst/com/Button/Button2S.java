package spst.com.Button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.Screen.Master;

public class Button2S extends ButtonActor{
    Texture texture = new Texture("11.png");
    Texture texture2 = new Texture("14.png");
    public Button2S(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(texture);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Master.factoryAction) {
                    textureRegion = new TextureRegion(texture2);
                    Master.factoryAction = false;
                } else {
                    textureRegion = new TextureRegion(texture);
                    Master.factoryAction = true;
                }
            }
        });

        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }
}

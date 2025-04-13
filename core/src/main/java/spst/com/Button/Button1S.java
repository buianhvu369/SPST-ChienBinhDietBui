package spst.com.Button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.Screen.Master;

public class Button1S extends ButtonActor{
    Texture texture = new Texture("10.png");
    Texture texture2 = new Texture("13.png");
    public Button1S(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(texture);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (Master.mLKKAction) {
                    textureRegion = new TextureRegion(texture2);
                    Master.mLKKAction = false;
                } else {
                    textureRegion = new TextureRegion(texture);
                    Master.mLKKAction = true;
                }
            }
        });
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }
}

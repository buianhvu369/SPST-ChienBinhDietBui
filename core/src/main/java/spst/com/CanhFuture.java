package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class CanhFuture extends MyActor{
    public TextureRegion AQI100 = new TextureRegion(new Texture("future100.png"));
    public TextureRegion AQI150 = new TextureRegion(new Texture("future150.png"));
    public TextureRegion AQI200 = new TextureRegion(new Texture("future200.png"));
    public TextureRegion AQI250 = new TextureRegion(new Texture("future250.png"));
    public TextureRegion AQI300 = new TextureRegion(new Texture("future300.png"));
    public CanhFuture(float x, float y, Stage s) {
        super(x, y, s);
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        textureRegion = new TextureRegion(AQI250);
    }
}

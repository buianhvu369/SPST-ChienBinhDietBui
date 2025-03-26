package spst.com.House;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Screen.Master;

public class TruSo extends MyActor {
    public TruSo(float x, float y, Stage s, int type) {
        super(x, y, s);
        if(type == 1) {
            textureRegion = new TextureRegion(new Texture(Gdx.files.internal("1.png")));
            setSize(textureRegion.getRegionWidth()*0.3f, textureRegion.getRegionHeight()*0.3f);
        }
        if(type == 2) {
            textureRegion = new TextureRegion(new Texture(Gdx.files.internal("2.png")));
            setSize(textureRegion.getRegionWidth()*0.8f, textureRegion.getRegionHeight()*0.8f);
        }
        if(type == 3) {
            textureRegion = new TextureRegion(new Texture(Gdx.files.internal("3.png")));
            setSize(textureRegion.getRegionWidth()*0.8f, textureRegion.getRegionHeight()*0.8f);
        }
        Master.truSos.add(this);
    }
}

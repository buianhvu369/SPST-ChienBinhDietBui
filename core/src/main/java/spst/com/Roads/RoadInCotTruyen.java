package spst.com.Roads;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class RoadInCotTruyen extends MyActor {
    public RoadInCotTruyen(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("road_in_cot_truyen.png"));
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        setPosition(x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        moveBy(-1, 0);
        if(getX() < -127){
            setX(Gdx.graphics.getWidth());
        }
    }
}

package spst.com.House;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

import java.awt.event.MouseEvent;

public class MordernDoor extends MyActor {
    boolean isOpen = false;
    public MordernDoor(float x, float y, Stage s) {
        super(x, y, s);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);
        Vector2 mouse = new Vector2();
        mouse.set(Gdx.input.getX(), Gdx.input.getY());
        getStage().getViewport().unproject(mouse);
        isOpen = (getX()< mouse.x
            && mouse.x < (getX() + 64))
            && (getY() < mouse.y
            && mouse.y < (getY() + 32));
        if(isOpen){
            textureRegion = Utils.getRegion(16*9,16*15,32,16);
        }else{
            textureRegion = Utils.getRegion(16*7,16*15,32,16);
        }
    }
}

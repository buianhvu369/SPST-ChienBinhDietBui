package spst.com.Speeds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Screen.TrashScreen;

public class ConTrolSpeed extends MyActor {

    public ConTrolSpeed(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("volume.png"));
        setSize(textureRegion.getRegionWidth()/2.5f, textureRegion.getRegionHeight()/2.5f);
        System.out.println(textureRegion.getRegionWidth()/2.5f);

        addListener(new ClickListener(){
            float offsetX;
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("");
            }
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                offsetX = x;
                return  true;
            }
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                if(TrashScreen.time%(20/TrashScreen.speed)==0){
                    float stageX = event.getStageX();
                    setPosition(stageX-offsetX, Gdx.graphics.getHeight()- 64);
                    if(getX() > 225){
                        setX(225);
                    }if(getX() < 25){
                        setX(25);
                    }
                    TrashScreen.speed = (char) (Math.round((getX() - 25)/200*20));
                    if(TrashScreen.speed<=0){
                        TrashScreen.speed++;
                    }
                }
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("X = " + getX() + " Y = " + getY());
            }
        });
    }
}

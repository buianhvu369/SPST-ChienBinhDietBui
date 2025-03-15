package spst.com.Cameras;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class NormalCamera extends MyActor {
    public String name;
    public NormalCamera(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(0,0,16,16);
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);
        setOrigin(getWidth()/2f,getHeight()/2f);
    }
    public void doiCamera(){
        OrthographicCamera camera = (OrthographicCamera) getStage().getViewport().getCamera();
        camera.zoom = 0.3f;
        if(getX() <= Gdx.graphics.getWidth()/2f){
            getStage().getCamera().position.x = Gdx.graphics.getWidth()/2f;
        }else {
            getStage().getCamera().position.x = getX()+getWidth()/2f;
        }
        if(getY() <= Gdx.graphics.getHeight()/2f){
            getStage().getCamera().position.y = Gdx.graphics.getHeight()/2f;
        }else{
            getStage().getCamera().position.y = getY()+getHeight()/2f;
        }
    }
}

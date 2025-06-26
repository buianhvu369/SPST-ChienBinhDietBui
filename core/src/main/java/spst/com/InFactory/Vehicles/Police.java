package spst.com.InFactory.Vehicles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.GameState;
import spst.com.MyActor;
import spst.com.Screen.Master;

public class Police extends MyActor {
    private boolean isUsing=false;
    private int soxang=0;
    public Police(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("policeright.png"));
        setSize(32*2,32);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isUsing){
            Master.player.setSize(0,0);
            if(Master.player.speedX==Master.player.speed){
                textureRegion = new TextureRegion(new Texture("policeright.png"));
                setSize(32*2,32);
            } else if(Master.player.speedX==-Master.player.speed){
                textureRegion = new TextureRegion(new Texture("policeleft.png"));
                setSize(32*2,32);
            }
            if(Master.player.speedY==Master.player.speed){
                textureRegion = new TextureRegion(new Texture("policeup.png"));
                setSize(32,32*2);
            }else if(Master.player.speedY==-Master.player.speed){
                textureRegion = new TextureRegion(new Texture("policedown.png"));
                setSize(32,32*2);
            }
            if(soxang==0){
                if(GameState.money>100){
                    GameState.money-=100;
                    soxang=60*24;
                }else{
                    isUsing=false;
                    Master.player.speed=2;
                }
            }
            soxang-=2;
            GameState.CO1+=0.6f/60f;
            GameState.PM2_5+=0.26f/60f;
            GameState.PM10+=0.06f/60f;
        }else {
            Master.player.setSize(32,32);
        }
    }

    public boolean getIsUsing(){return isUsing;}
    public void setIsUsing(boolean value){isUsing=value;}
}

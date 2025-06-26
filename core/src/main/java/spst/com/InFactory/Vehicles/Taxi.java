package spst.com.InFactory.Vehicles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.GameState;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Waste;

public class Taxi extends MyActor {
    private boolean isUsing=false;
    private int soxang=0;
    public Taxi(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("taxiright.png"));
        setSize(32*2,32);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isUsing){
            Master.player.setSize(0,0);
            if(Master.player.speedX==Master.player.speed){
                textureRegion = new TextureRegion(new Texture("taxiright.png"));
                setSize(32*2,32);
            } else if(Master.player.speedX==-Master.player.speed){
                textureRegion = new TextureRegion(new Texture("taxileft.png"));
                setSize(32*2,32);
            }
            if(Master.player.speedY==Master.player.speed){
                textureRegion = new TextureRegion(new Texture("taxiup.png"));
                setSize(32,32*2);
            }else if(Master.player.speedY==-Master.player.speed){
                textureRegion = new TextureRegion(new Texture("taxidown.png"));
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
            soxang--;
            GameState.CO1+=0.4f/60f;
            GameState.PM2_5+=0.16f/60f;
            GameState.PM10+=0.08f/60f;
        }else {
            Master.player.setSize(32,32);
        }
    }

    public boolean getIsUsing(){return isUsing;}
    public void setIsUsing(boolean value){isUsing=value;}
}

package spst.com.InFactory.Vehicles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.GameState;
import spst.com.MyActor;
import spst.com.Screen.Master;

public class ElectricCar extends MyActor {
    private boolean isUsing=false;
    private int sodien=0;
    public ElectricCar(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("teslaright.png"));
        setSize(32*2,32);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isUsing){
            Master.player.setSize(0,0);
            if(Master.player.speedX==Master.player.speed){
                textureRegion = new TextureRegion(new Texture("teslaright.png"));
                setSize(32*2,32);
            } else if(Master.player.speedX==-Master.player.speed){
                textureRegion = new TextureRegion(new Texture("teslaleft.png"));
                setSize(32*2,32);
            }
            if(Master.player.speedY==Master.player.speed){
                textureRegion = new TextureRegion(new Texture("teslaup.png"));
                setSize(32,32*2);
            }else if(Master.player.speedY==-Master.player.speed){
                textureRegion = new TextureRegion(new Texture("tesladown.png"));
                setSize(32,32*2);
            }
            if(sodien==0){
                if(GameState.ernegy>2){
                    GameState.ernegy-=2;
                    sodien=180;
                }else{
                    isUsing=false;
                    Master.player.speed=2;
                }
            }
            sodien--;
        }else {
            Master.player.setSize(32,32);
        }
    }

    public boolean getIsUsing(){return isUsing;}
    public void setIsUsing(boolean value){isUsing=value;}
}

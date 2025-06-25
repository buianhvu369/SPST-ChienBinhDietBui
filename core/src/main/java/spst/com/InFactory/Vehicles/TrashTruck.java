package spst.com.InFactory.Vehicles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.GameState;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Waste;

public class TrashTruck extends MyActor {
    private boolean isUsing=false;
    private int soxang=0;
    public TrashTruck(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("trashtruckright.png"));
        setSize(32*4,32*2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isUsing){
            Master.player.setSize(0,0);
            if(Master.player.speedX==Master.player.speed){
                textureRegion = new TextureRegion(new Texture("trashtruckright.png"));
                setSize(32*2,32);
            } else if(Master.player.speedX==-Master.player.speed){
                textureRegion = new TextureRegion(new Texture("trashtruckleft.png"));
                setSize(32*2,32);
            }
            if(Master.player.speedY==Master.player.speed){
                textureRegion = new TextureRegion(new Texture("trashtruckup.png"));
                setSize(32,32*2);
            }else if(Master.player.speedY==-Master.player.speed){
                textureRegion = new TextureRegion(new Texture("trashtruckdown.png"));
                setSize(32,32*2);
            }
        }else {
            Master.player.setSize(32,32);
        }
        if(soxang==0){
            if(GameState.money>100){
                GameState.money-=100;
                soxang=60*16;
            }else{
                isUsing=false;
                Master.player.speed=2;
            }
        }
        soxang--;
        GameState.CO1+=0.8/60f;
        GameState.PM2_5+=0.46/60f;
        GameState.PM10+=0.18/60f;
        for(Waste w : Master.wastes){
            if(getBound().overlaps(w.getBound())){
                switch (w.getCostume()){
                    case 'o' -> GameState.soRacHuuCo++;
                    case 'i' -> GameState.soRacVoCo++;
                    case 'r' -> GameState.soRacTaiChe++;
                    case 'h' -> GameState.soRacNguyHai++;
                }
                Master.wastes.removeValue(w,true);
                w.remove();
            }
        }
    }

    public boolean getIsUsing(){return isUsing;}
    public void setIsUsing(boolean value){isUsing=value;}
}

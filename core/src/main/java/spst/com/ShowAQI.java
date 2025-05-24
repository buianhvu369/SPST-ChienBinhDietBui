package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Screen.Master;

public class ShowAQI extends MyActor {
    public Sound canhbao = Gdx.audio.newSound(Gdx.files.internal("canhbao.mp3"));
    public Sound hetnangluong = Gdx.audio.newSound(Gdx.files.internal("hetnangluong.mp3"));
    boolean isCanhBao = false;
    boolean isHNL = false;
    Bui bui;
    public ShowAQI(float x, float y, Stage s){
        super(x,y,s);
        setColor(Color.RED);
        textureRegion = Utils.getRegion(16*9,16,16,16);
        setSize(textureRegion.getRegionWidth(), 10);

        bui = new Bui(0,0,Master.noMoveStage);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setSize(Master.AQI/300f*Gdx.graphics.getWidth(),10);
        if(Master.AQI<=50){
            setColor(Color.GREEN);
        }else if(Master.AQI<=100){
            setColor(Color.YELLOW);
        }else if(Master.AQI<=150){
            setColor(Color.ORANGE);
        }else if(Master.AQI<=200){
            setColor(Color.RED);
        }else if(Master.AQI<=300){
                setColor(Color.BROWN);
        }
        if(Master.AQI>=250&&!isCanhBao){
            canhbao.play(Master.amluong);
            new FloatingNews(0,0,Master.noMoveStage,"Sắp thua rồi",Color.RED);
            isCanhBao = true;
        }
        if(Master.AQI<250){
            isCanhBao = false;
        }
        bui.setColor(bui.getColor().r,bui.getColor().g,bui.getColor().b,1/300f*0.5f*Master.AQI);
        if(GameState.ernegy==0&&!isHNL){
            hetnangluong.play(Master.amluong);
            new FloatingNews(0,0,Master.noMoveStage,"Hết năng lượng",Color.RED);
            isHNL = true;
        }
        if(GameState.ernegy>0){
            isHNL = false;
        }
    }
}

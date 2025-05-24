package spst.com.People;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.FloatingNews;
import spst.com.GameState;
import spst.com.Screen.Master;
import spst.com.Utils;

public class AQXaRacIQ1000 extends People {
    public AQXaRacIQ1000(float x, float y, Stage s, boolean rightside) {
        super(x,y,s,rightside);
        setSize(32,32);
        TextureRegion[] textureRegionLeft = {Utils.getRegion(16*23,16*3,16,16),Utils.getRegion(16*23,16*4,16,16),Utils.getRegion(16*23,16*5,16,16)};
        TextureRegion[] textureRegionDown = {Utils.getRegion(16*24,16*3,16,16),Utils.getRegion(16*24,16*4,16,16),Utils.getRegion(16*24,16*5,16,16)};
        TextureRegion[] textureRegionUp = {Utils.getRegion(16*25,16*3,16,16),Utils.getRegion(16*25,16*4,16,16),Utils.getRegion(16*25,16*5,16,16)};
        TextureRegion[] textureRegionRight = {Utils.getRegion(16*26,16*3,16,16),Utils.getRegion(16*26,16*4,16,16),Utils.getRegion(16*26,16*5,16,16)};
        animationLeft = new Animation<TextureRegion>(0.1f, textureRegionLeft);
        animationRight = new Animation<TextureRegion>(0.1f, textureRegionRight);
        animationUp = new Animation<TextureRegion>(0.1f, textureRegionUp);
        animationDown = new Animation<TextureRegion>(0.1f, textureRegionDown);
        animationLeft.setPlayMode(Animation.PlayMode.LOOP);
        animationRight.setPlayMode(Animation.PlayMode.LOOP);
        animationUp.setPlayMode(Animation.PlayMode.LOOP);
        animationDown.setPlayMode(Animation.PlayMode.LOOP);
        time = 0;
        textureRegion = animationRight.getKeyFrame(time);

        addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                if(isCutting||isFiringWaste||isFiringSign){
                    GameState.money += 150 ;
                    new FloatingNews(Gdx.graphics.getWidth()/2f-10,Gdx.graphics.getHeight()/2f+100, Master.noMoveStage,"+150 $", Color.GREEN);
                    Master.collect.play(Master.amluong);
                }else {
                    GameState.money -= 50;
                    new FloatingNews(Gdx.graphics.getWidth()/2f-10,Gdx.graphics.getHeight()/2f+100,Master.noMoveStage,"-50 $",Color.GREEN);
                }
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}

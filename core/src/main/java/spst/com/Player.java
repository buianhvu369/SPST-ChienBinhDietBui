package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.math.Polygon;

import java.awt.*;

public class Player extends MyActor {
    Animation<TextureRegion> animationLeft;
    Animation<TextureRegion> animationRight;
    Animation<TextureRegion> animationUp;
    Animation<TextureRegion> animationDown;
    int speed = 2;
    float time;
    Player(float x, float y, Stage s) {
        super(x, y, s);
        setSize(32,32);
        TextureRegion[] textureRegionLeft = {Utils.getRegion(16*23,0,16,16),Utils.getRegion(16*23,32,16,16),Utils.getRegion(16*23,16*2,16,16)};
        TextureRegion[] textureRegionDown = {Utils.getRegion(16*24,0,16,16),Utils.getRegion(16*24,32,16,16),Utils.getRegion(16*24,16*2,16,16)};
        TextureRegion[] textureRegionUp = {Utils.getRegion(16*25,0,16,16),Utils.getRegion(16*25,32,16,16),Utils.getRegion(16*25,16*2,16,16)};
        TextureRegion[] textureRegionRight = {Utils.getRegion(16*26,0,16,16),Utils.getRegion(16*26,32,16,16),Utils.getRegion(16*26,16*2,16,16)};
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
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if((800/2f-48 <= getY() && getY() < 800/2f+48 && getX() > 0)
                || (800/2f-48 - 11*32 <= getY() && getY() < 800/2f-48 && getX() > 32*9 && !(getX() > 32*15))
                ||(800/2f+48 <= getY() && getY() < 800/2f+48+11*32 && getX() > 32*21)
                ||(800/2f-48 - 11*32 <= getY() && getY() < 800/2f-48 && getX() > 32*25)){
                moveBy(-speed, 0);
            }
            time += delta;
            textureRegion = animationLeft.getKeyFrame(time);
        }else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if((800/2f-48 <= getY() && getY() < 800/2f+48 && getX() < (1200 - getWidth()))
                || (800/2f-48 - 11*32 < getY() && getY() <= 800/2f-48 && getX() < 32*12-getWidth())
                ||(800/2f+48 <= getY() && getY() < 800/2f+48+11*32 && getX() < 32*24-getWidth())
                ||(800/2f-48 - 11*32 <= getY() && getY() < 800/2f-48 && getX() < 32*28-getWidth() && !(getX() < 32*15))){
                moveBy(speed, 0);
            }
            time += delta;
            textureRegion = animationRight.getKeyFrame(time);
        }else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if((0<=getX() && getX() < 32*21 && getY()<800/2f+48-getHeight())
            || (32*21<=getX() && getX() < 32*24 && getY()<800-getHeight())
            || (32*24<=getX() && getX() < 1200 && getY()<800/2f+48-getHeight())){
                moveBy(0, speed);
            }
            time += delta;
            textureRegion = animationUp.getKeyFrame(time);
        }else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if((0<=getX() && getX() < 32*9 && getY()>800/2f-48)
                || (32*9<=getX() && getX() < 32*12 && getY()>0)
                || (32*12<=getX() && getX() < 32*25 && getY()>800/2f-48)
                || (32*25<=getX() && getX() < 32*28 && getY()>0)
                || (32*28<=getX() && getX() < 1200 && getY()>800/2f-48)){
                moveBy(0, -speed);
            }
            time += delta;
            textureRegion = animationDown.getKeyFrame(time);
        }
    }
}

package spst.com.People;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.AnimationClickMouse;
import spst.com.Direction;
import spst.com.MyActor;
import spst.com.Roads.Tree;
import spst.com.Utils;

public class People1 extends MyActor {
    Animation<TextureRegion> animationLeft;
    Animation<TextureRegion> animationRight;
    Animation<TextureRegion> animationUp;
    Animation<TextureRegion> animationDown;
    float time;
    int timeDirection;

    Direction direction = Direction.LEFT;
    float speedX = 0;
    float speedY = 0;

    public People1(float x, float y, Stage s, boolean rightside) {
        super(x, y, s);
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
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time+= delta;
        switch (direction){
            case UP -> {
                speedX = 0;
                speedY = 1;
                textureRegion = animationUp.getKeyFrame(time);
            }
            case DOWN -> {
                speedX = 0;
                speedY = -1;
                textureRegion = animationDown.getKeyFrame(time);
            }
            case LEFT -> {
                speedX = -1;
                speedY = 0;
                textureRegion = animationLeft.getKeyFrame(time);
            }
            case RIGHT -> {
                speedX = 1;
                speedY = 0;
                textureRegion = animationRight.getKeyFrame(time);
            }
        }
        moveBy(speedX, speedY);
        if(getX()< 0){
            direction = Direction.RIGHT;
        } else if (getX()> 2400) {
            direction = Direction.LEFT;
        } else if (getY()> 800) {
            direction = Direction.DOWN;
        } else if (getY() < 0) {
            direction = Direction.UP;
        }
        timeDirection++;
        if(timeDirection % 300 == 0){
            timeDirection = 0;
            direction = Direction.values()[MathUtils.random(0, Direction.values().length -1)];
        }
    }
}

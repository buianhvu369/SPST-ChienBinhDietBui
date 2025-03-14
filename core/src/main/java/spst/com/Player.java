package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.math.Polygon;
import spst.com.Roads.Tree;

import java.awt.*;

public class Player extends MyActor {
    Animation<TextureRegion> animationLeft;
    Animation<TextureRegion> animationRight;
    Animation<TextureRegion> animationUp;
    Animation<TextureRegion> animationDown;
    int speed = 2;
    float time;
    float mouseX = -13314;
    float mouseY = -1321687;
    boolean isMove = true;
    private Sound clickSound = Gdx.audio.newSound(Gdx.files.internal("clicksound.ogg"));;
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
        Vector2 mouse = new Vector2();
        mouse.set(Gdx.input.getX(), Gdx.input.getY());
        getStage().getViewport().unproject(mouse);

        if (Gdx.input.justTouched()) {
            mouseX = mouse.x;
            mouseY = mouse.y;
            AnimationClickMouse animationClickMouse = new AnimationClickMouse(mouse.x-32,mouse.y-32,getStage());
            clickSound.play();
            if(Master.preparePlant){
                new Tree(mouseX,mouseY,getStage());
            }
        }
        if (mouseX != -13314 && mouseY != -1321687 && !Master.preparePlant){
            if (Math.abs(getX()-mouseX) < Math.abs(getY()-mouseY)) {
                if (!(getX() - 2 < mouseX && mouseX < getX() + 2)) {
                    if (mouseX < getX() + 2) {
                        if (!(32 * 16 <= getY() && getY() < 32 * 23 && getX() <= 32 * 9)) {
                            moveBy(-speed, 0);
                        }
                        time += delta;
                        textureRegion = animationLeft.getKeyFrame(time);
                    } else if (mouseX > getX() - 2) {
                        moveBy(speed, 0);
                        time += delta;
                        textureRegion = animationRight.getKeyFrame(time);
                    }
                } else if (!(getY() - 2 < mouseY && mouseY < getY() + 2)) {
                    if (getY() - 2 < mouseY) {
                        if (!(0 <= getX() && getX() < 32 * 9 && getY() > 32 * 16 - 8 && getY() <= 800 - 32 * 4)) {
                            moveBy(0, speed);
                        }
                        time += delta;
                        textureRegion = animationUp.getKeyFrame(time);
                    } else if (mouseY < getY() + 2) {
                        if (!(0 <= getX() && getX() < 32 * 9 && getY() <= 800 - 32 * 2 && getY() >= 32 * 18)) {
                            moveBy(0, -speed);
                        }
                        time += delta;
                        textureRegion = animationDown.getKeyFrame(time);
                    }
                }
            } else {
                if (!(getY() - 2 < mouseY && mouseY < getY() + 2)) {
                    if (getY() - 2 < mouseY) {
                        if (!(0 <= getX() && getX() < 32 * 9 && getY() > 32 * 16 - 8 && getY() <= 800 - 32 * 4)) {
                            moveBy(0, speed);
                        }
                        time += delta;
                        textureRegion = animationUp.getKeyFrame(time);
                    } else if (mouseY < getY() + 2) {
                        if (!(0 <= getX() && getX() < 32 * 9 && getY() <= 800 - 32 * 2 && getY() >= 32 * 18)) {
                            moveBy(0, -speed);
                        }
                        time += delta;
                        textureRegion = animationDown.getKeyFrame(time);
                    }
                } else if (!(getX() - 2 < mouseX && mouseX < getX() + 2)) {
                    if (mouseX < getX() + 2) {
                        if (!(32 * 16 <= getY() && getY() < 32 * 23 && getX() <= 32 * 9)) {
                            moveBy(-speed, 0);
                        }
                        time += delta;
                        textureRegion = animationLeft.getKeyFrame(time);
                    } else if (mouseX > getX() - 2) {
                        moveBy(speed, 0);
                        time += delta;
                        textureRegion = animationRight.getKeyFrame(time);
                    }
                }
            }
        }
    }
}

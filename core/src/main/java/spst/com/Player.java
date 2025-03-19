package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import spst.com.Roads.Car;
import spst.com.Screen.Master;

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
    boolean isAlive = true;
    boolean isBep = false;
    private Sound clickSound = Gdx.audio.newSound(Gdx.files.internal("clicksound.ogg"));;
    public Player(float x, float y, Stage s) {
        super(x, y, s);
        setSize(32, 32);
        TextureRegion[] textureRegionLeft = {Utils.getRegion(16 * 23, 0, 16, 16), Utils.getRegion(16 * 23, 32, 16, 16), Utils.getRegion(16 * 23, 16 * 2, 16, 16)};
        TextureRegion[] textureRegionDown = {Utils.getRegion(16 * 24, 0, 16, 16), Utils.getRegion(16 * 24, 32, 16, 16), Utils.getRegion(16 * 24, 16 * 2, 16, 16)};
        TextureRegion[] textureRegionUp = {Utils.getRegion(16 * 25, 0, 16, 16), Utils.getRegion(16 * 25, 32, 16, 16), Utils.getRegion(16 * 25, 16 * 2, 16, 16)};
        TextureRegion[] textureRegionRight = {Utils.getRegion(16 * 26, 0, 16, 16), Utils.getRegion(16 * 26, 32, 16, 16), Utils.getRegion(16 * 26, 16 * 2, 16, 16)};
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
        if(isAlive){
            mouseX = Master.cameraPosition.x;
            mouseY = Master.cameraPosition.y;

            if (Master.whatActionIfClickMouse.equals("move")&& !Master.hienChiSo){
                if (Math.abs(getX()-mouseX) < Math.abs(getY()-mouseY)) {
                    if (!(getX() - 2 < mouseX && mouseX < getX() + 2)) {
                        if (mouseX < getX() + 2) {
                            if (!(getX()>32*14 && 32 * 16 <= getY() && getY() < 32 * 27 && getX() <= 32 * 16)) {
                                moveBy(-speed, 0);
                            }
                            time += delta;
                            textureRegion = animationLeft.getKeyFrame(time);
                        } else if (mouseX > getX() - 2) {
                            if(!(getX()<32*8 && getY()>32*14 && 32 * 16 <= getY() && getY() < 32 * 27 && getX()>32*3)){
                                moveBy(speed, 0);
                            }
                            time += delta;
                            textureRegion = animationRight.getKeyFrame(time);
                        }
                    } else if (!(getY() - 2 < mouseY && mouseY < getY() + 2)) {
                        if (getY() - 2 < mouseY) {
                            if (!(32*3 <= getX() && getX() < 32 * 16 && getY() > 32 * 16 - 8 && getY() <= 800 - 32 * 4)) {
                                moveBy(0, speed);
                            }
                            time += delta;
                            textureRegion = animationUp.getKeyFrame(time);
                        } else if (mouseY < getY() + 2) {
                            if (!(32*3 <= getX() && getX() < 32 * 16 && getY() <= 800 - 32 * 2 && getY() >= 32 * 18)) {
                                moveBy(0, -speed);
                            }
                            time += delta;
                            textureRegion = animationDown.getKeyFrame(time);
                        }
                    }
                } else {
                    if (!(getY() - 2 < mouseY && mouseY < getY() + 2)) {
                        if (getY() - 2 < mouseY) {
                            if (!(32*3 <= getX() && getX() < 32 * 16 && getY() > 32 * 16 - 8 && getY() <= 800 - 32 * 4)) {
                                moveBy(0, speed);
                            }
                            time += delta;
                            textureRegion = animationUp.getKeyFrame(time);
                        } else if (mouseY < getY() + 2) {
                            if (!(32*3 <= getX() && getX() < 32 * 16 && getY() <= 800 - 32 * 2 && getY() >= 32 * 18)) {
                                moveBy(0, -speed);
                            }
                            time += delta;
                            textureRegion = animationDown.getKeyFrame(time);
                        }
                    } else if (!(getX() - 2 < mouseX && mouseX < getX() + 2)) {
                        if (mouseX < getX() + 2) {
                            if (!(getX()>32*14 && 32 * 16 <= getY() && getY() < 32 * 27 && getX() <= 32 * 16)) {
                                moveBy(-speed, 0);
                            }
                            time += delta;
                            textureRegion = animationLeft.getKeyFrame(time);
                        } else if (mouseX > getX() - 2) {
                            if(!(getX()<32*8 && getY()>32*14 && 32 * 16 <= getY() && getY() < 32 * 27 && getX()>32*3)){
                                moveBy(speed, 0);
                            }
                            time += delta;
                            textureRegion = animationRight.getKeyFrame(time);
                        }
                    }
                }
            }
        }
        if(1180<getX() && getX() < 1180 + 4*32 - 10 &&!(11*32<getY() && getY()<14*32)){
            textureRegion = Utils.getRegion(23*16, 0, 16, 6);
            setSize(32, 12);
            if(getX() > 1180+32 && getX() < 1180 + 4*32 - 10-32 && isAlive){
                isAlive = false;
                if(getY()<=32*11){
                    addAction(Actions.moveBy(0,-200,6));
                }else {
                    addAction(Actions.moveBy(0,-200,6));
                }
                addAction(Actions.sequence(
                    Actions.fadeOut(6),
                    Actions.run(()->{
                        Dark dark = new Dark(0,0,Master.noMoveStage);
                        dark.addAction(Actions.fadeIn(2));
                        new FloatingNews(Gdx.graphics.getWidth()/2f,Gdx.graphics.getHeight()/2f,Master.noMoveStage,"YOU LOSE", Color.RED);
                        Master.WLK = 'L';
                    })
                ));
            }
        } else {
            setSize(32,32);
        }

        for(Car c : Master.cars){
            if(getBound().overlaps(c.getBound())){
                isAlive = false;
                isBep = true;
                addAction(Actions.sequence(
                    Actions.fadeOut(6),
                    Actions.run(()->{
                        Dark dark = new Dark(0,0,Master.noMoveStage);
                        dark.addAction(Actions.fadeIn(2));
                        new FloatingNews(Gdx.graphics.getWidth()/2f,Gdx.graphics.getHeight()/2f,Master.noMoveStage,"YOU LOSE", Color.RED);
                        Master.WLK = 'L';
                    })
                ));
            }
        }
        if(isBep){
            setSize(32, 8);
        }
    }
}

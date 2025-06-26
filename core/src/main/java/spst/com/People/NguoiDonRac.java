package spst.com.People;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import spst.com.*;
import spst.com.Screen.Master;

public class NguoiDonRac extends MyActor {
    Animation<TextureRegion> animationLeft;
    Animation<TextureRegion> animationRight;
    Animation<TextureRegion> animationUp;
    Animation<TextureRegion> animationDown;
    float time;
    float speed = 1;
    float mouseX = 100000000;
    float mouseY = 100000000;
    float mouseXBridge = 100000;
    float mouseYBridge = 100000;
    static boolean isMoving = false;
    static boolean isCrossBridge = false;
    float timeDoRac = 0;
    boolean donXong = false;
    Rectangle rectangle3 = new Rectangle();
    Rectangle rectangle4 = new Rectangle();
    boolean firsttime = true;
    Waste wasteTarget;

    public NguoiDonRac(float x, float y, Stage s) {
        super(x, y, s);
        TextureRegion[] textureRegionLeft = {Utils.getRegionDonRac(0,0,32,32),Utils.getRegionDonRac(0,32,32,32),Utils.getRegionDonRac(0,32*2,32,32)};
        TextureRegion[] textureRegionDown = {Utils.getRegionDonRac(32,0,32,32),Utils.getRegionDonRac(32,32,32,32),Utils.getRegionDonRac(32,32*2,32,32)};
        TextureRegion[] textureRegionUp = {Utils.getRegionDonRac(32*2,0,32,32),Utils.getRegionDonRac(32*2,32,32,32),Utils.getRegionDonRac(32*2,32*2,32,32)};
        TextureRegion[] textureRegionRight = {Utils.getRegionDonRac(32*3,0,32,32),Utils.getRegionDonRac(32*3,32,32,32),Utils.getRegionDonRac(32*3,32*2,32,32)};
        animationLeft = new Animation<TextureRegion>(0.2f, textureRegionLeft);
        animationRight = new Animation<TextureRegion>(0.2f, textureRegionRight);
        animationUp = new Animation<TextureRegion>(0.2f, textureRegionUp);
        animationDown = new Animation<TextureRegion>(0.2f, textureRegionDown);
        animationLeft.setPlayMode(Animation.PlayMode.LOOP);
        animationRight.setPlayMode(Animation.PlayMode.LOOP);
        animationUp.setPlayMode(Animation.PlayMode.LOOP);
        animationDown.setPlayMode(Animation.PlayMode.LOOP);
        time = 0;
        textureRegion = animationRight.getKeyFrame(time);
        setSize(32,32);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        timeDoRac--;
        toFront();
        if(!donXong) {
            if (!Master.wastes.isEmpty()) {
                boolean findTarget = false;
                for (int i = 0; i < 100; i++) {
                    if (!findTarget) {
                        boolean canPut = true;
                        wasteTarget = Master.wastes.random();
                        if (wasteTarget.getX() <= 40 *32 && wasteTarget.getX() >= 36*32) {
                            canPut = false;
                        }

                        if (canPut) {
                            findTarget = true;
                            Master.wastes.removeValue(wasteTarget, true);
                            mouseX = wasteTarget.getX() - 16;
                            mouseY = wasteTarget.getY() -16;
                            rectangle4.setPosition(mouseX-1, mouseY-1);
                            rectangle4.setSize(3, 3);
                            isMoving = true;
                            isCrossBridge = false;
                            donXong = true;

                        }
                    }
                }
            }
        }else{

            if(rectangle4.contains(getX(),getY())){
                rectangle4.setPosition(100,10000000);
                addAction(Actions.sequence(
                    Actions.delay(3),
                    Actions.run(() -> {
                        donXong = false;
                        if(wasteTarget.costume == 'o'){
                            GameState.soRacHuuCo++;
                        }if(wasteTarget.costume == 'i'){
                            GameState.soRacVoCo++;
                        }if(wasteTarget.costume == 'r'){
                            GameState.soRacTaiChe++;
                        }if(wasteTarget.costume == 'h'){
                            GameState.soRacNguyHai++;
                        }
                        wasteTarget.remove();
                    })
                ));
            }
        }
        if (isMoving) {
            if(rectangle3.contains(getX(), getY())){
                isCrossBridge = false;
                rectangle3.setPosition(10000000,1000000000);
                firsttime = false;
            }
            if(!isCrossBridge) {
                if (Math.abs(getX() - mouseX) < Math.abs(getY() - mouseY)) {
                    if (!(getX() - 2 < mouseX && mouseX < getX() + 2)) {
                        if (mouseX < getX() + 2) {
                            if (!(getX() > 32 * 14 && 32 * 16 <= getY() && getY() < 32 * 27 && getX() <= 32 * 16)) {
                                moveBy(-speed, 0);
                            }
                            time += delta;
                            textureRegion = animationLeft.getKeyFrame(time);
                        } else if (mouseX > getX() - 2) {
                            if (!(getX() < 32 * 8 && getY() > 32 * 14 && 32 * 16 <= getY() && getY() < 32 * 27 && getX() > 32 * 3)) {
                                moveBy(speed, 0);
                            }
                            time += delta;
                            textureRegion = animationRight.getKeyFrame(time);
                        }
                    } else if (!(getY() - 2 < mouseY && mouseY < getY() + 2)) {
                        if (getY() - 2 < mouseY) {
                            if (!(32 * 3 <= getX() && getX() < 32 * 16 && getY() > 32 * 16 - 8 && getY() <= 800 - 32 * 4)) {
                                moveBy(0, speed);
                            }
                            time += delta;
                            textureRegion = animationUp.getKeyFrame(time);
                        } else if (mouseY < getY() + 2) {
                            if (!(32 * 3 <= getX() && getX() < 32 * 16 && getY() <= 800 - 32 * 2 && getY() >= 32 * 18)) {
                                moveBy(0, -speed);
                            }
                            time += delta;
                            textureRegion = animationDown.getKeyFrame(time);
                        }
                    }
                } else {
                    if (!(getY() - 2 < mouseY && mouseY < getY() + 2)) {
                        if (getY() - 2 < mouseY) {
                            if (!(32 * 3 <= getX() && getX() < 32 * 16 && getY() > 32 * 16 - 8 && getY() <= 800 - 32 * 4)) {
                                moveBy(0, speed);
                            }
                            time += delta;
                            textureRegion = animationUp.getKeyFrame(time);
                        } else if (mouseY < getY() + 2) {
                            if (!(32 * 3 <= getX() && getX() < 32 * 16 && getY() <= 800 - 32 * 2 && getY() >= 32 * 18)) {
                                moveBy(0, -speed);
                            }
                            time += delta;
                            textureRegion = animationDown.getKeyFrame(time);
                        }
                    } else if (!(getX() - 2 < mouseX && mouseX < getX() + 2)) {
                        if (mouseX < getX() + 2) {
                            if (!(getX() > 32 * 14 && 32 * 16 <= getY() && getY() < 32 * 27 && getX() <= 32 * 16)) {
                                moveBy(-speed, 0);
                            }
                            time += delta;
                            textureRegion = animationLeft.getKeyFrame(time);
                        } else if (mouseX > getX() - 2) {
                            if (!(getX() < 32 * 8 && getY() > 32 * 14 && 32 * 16 <= getY() && getY() < 32 * 27 && getX() > 32 * 3)) {
                                moveBy(speed, 0);
                            }
                            time += delta;
                            textureRegion = animationRight.getKeyFrame(time);
                        }
                    }
                }
            }else{

                if (Math.abs(getX() - mouseXBridge) < Math.abs(getY() - mouseYBridge)) {
                    if (!(getX() - 2 < mouseXBridge && mouseXBridge < getX() + 2)) {
                        if (mouseXBridge < getX() + 2) {
                            if (!(getX() > 32 * 14 && 32 * 16 <= getY() && getY() < 32 * 27 && getX() <= 32 * 16)) {
                                moveBy(-speed, 0);
                            }
                            time += delta;
                            textureRegion = animationLeft.getKeyFrame(time);
                        } else if (mouseXBridge > getX() - 2) {
                            if (!(getX() < 32 * 8 && getY() > 32 * 14 && 32 * 16 <= getY() && getY() < 32 * 27 && getX() > 32 * 3)) {
                                moveBy(speed, 0);
                            }
                            time += delta;
                            textureRegion = animationRight.getKeyFrame(time);
                        }
                    } else if (!(getY() - 2 < mouseYBridge && mouseYBridge < getY() + 2)) {
                        if (getY() - 2 < mouseYBridge) {
                            if (!(32 * 3 <= getX() && getX() < 32 * 16 && getY() > 32 * 16 - 8 && getY() <= 800 - 32 * 4)) {
                                moveBy(0, speed);
                            }
                            time += delta;
                            textureRegion = animationUp.getKeyFrame(time);
                        } else if (mouseYBridge < getY() + 2) {
                            if (!(32 * 3 <= getX() && getX() < 32 * 16 && getY() <= 800 - 32 * 2 && getY() >= 32 * 18)) {
                                moveBy(0, -speed);
                            }
                            time += delta;
                            textureRegion = animationDown.getKeyFrame(time);
                        }
                    }
                } else {
                    if (!(getY() - 2 < mouseYBridge && mouseYBridge < getY() + 2)) {
                        if (getY() - 2 < mouseYBridge) {
                            if (!(32 * 3 <= getX() && getX() < 32 * 16 && getY() > 32 * 16 - 8 && getY() <= 800 - 32 * 4)) {
                                moveBy(0, speed);
                            }
                            time += delta;
                            textureRegion = animationUp.getKeyFrame(time);
                        } else if (mouseYBridge < getY() + 2) {
                            if (!(32 * 3 <= getX() && getX() < 32 * 16 && getY() <= 800 - 32 * 2 && getY() >= 32 * 18)) {
                                moveBy(0, -speed);
                            }
                            time += delta;
                            textureRegion = animationDown.getKeyFrame(time);
                        }
                    } else if (!(getX() - 2 < mouseXBridge && mouseXBridge < getX() + 2)) {
                        if (mouseXBridge < getX() + 2) {
                            if (!(getX() > 32 * 14 && 32 * 16 <= getY() && getY() < 32 * 27 && getX() <= 32 * 16)) {
                                moveBy(-speed, 0);
                            }
                            time += delta;
                            textureRegion = animationLeft.getKeyFrame(time);
                        } else if (mouseXBridge > getX() - 2) {
                            if (!(getX() < 32 * 8 && getY() > 32 * 14 && 32 * 16 <= getY() && getY() < 32 * 27 && getX() > 32 * 3)) {
                                moveBy(speed, 0);
                            }
                            time += delta;
                            textureRegion = animationRight.getKeyFrame(time);
                        }
                    }
                }
            }
        }
    }
}

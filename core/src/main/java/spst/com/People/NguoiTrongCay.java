package spst.com.People;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import spst.com.LoadingPlant;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;

public class NguoiTrongCay extends MyActor {
    Animation<TextureRegion> animationLeft;
    Animation<TextureRegion> animationRight;
    Animation<TextureRegion> animationUp;
    Animation<TextureRegion> animationDown;
    float time;
    int speed = 2;
    float mouseX = 100000000;
    float mouseY = 100000000;
    float mouseXBridge = 100000;
    float mouseYBridge = 100000;
    static boolean isMoving = false;
    static boolean isCrossBridge = false;
    float timePlantTree = 0;
    boolean isFree = false;
    Rectangle rectangle3 = new Rectangle();
    Rectangle rectangle4 = new Rectangle();
    boolean firsttime = true;
    public NguoiTrongCay(float x, float y, Stage s) {
        super(x, y, s);
        TextureRegion[] textureRegionLeft = {Utils.getRegionLaoCong(0,0,16,16),Utils.getRegionLaoCong(0,16,16,16),Utils.getRegionLaoCong(0,16*2,16,16)};
        TextureRegion[] textureRegionDown = {Utils.getRegionLaoCong(16,0,16,16),Utils.getRegionLaoCong(16,16,16,16),Utils.getRegionLaoCong(16,16*2,16,16)};
        TextureRegion[] textureRegionUp = {Utils.getRegionLaoCong(16*2,0,16,16),Utils.getRegionLaoCong(16*2,16,16,16),Utils.getRegionLaoCong(16*2,16*2,16,16)};
        TextureRegion[] textureRegionRight = {Utils.getRegionLaoCong(16*3,0,16,16),Utils.getRegionLaoCong(16*3,16,16,16),Utils.getRegionLaoCong(16*3,16*2,16,16)};
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
        timePlantTree--;
        if(timePlantTree < 1) {
            while (!isFree) {
                mouseX = MathUtils.random(1200 + 32 * 4, 2400);
                mouseY = MathUtils.random(32, 800 - 32 * 3);
                isFree = true;
                for (Rectangle rec : Master.noPlaced) {
                    if (rec.contains(mouseX, mouseY)) {
                        isFree = false;
                        break;
                    }
                }
                if (isFree) {
                    rectangle4.setPosition(mouseX, mouseY);
                    rectangle4.setSize(20, 20);
                    isMoving = true;
                    isCrossBridge = false;
                }
            }
            if (rectangle4.contains(getX() + 10, getY() + 10)) {
                new LoadingPlant(getX() + 32, getY(), getStage());
                rectangle4.setPosition(100000000.9999999999999999999999999999999999999999999999999999f, 1000000000.9999999999999999999999999999999999999999999999999999999999f);
                addAction(Actions.sequence(
                    Actions.delay(2),
                    Actions.run(() -> {
                        isFree = false;
                        timePlantTree = 1800;
                        mouseX = 32*59;
                        mouseY = 32*7;
                    })
                ));
            }
        }else{

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

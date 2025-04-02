package spst.com.People;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import spst.com.*;
import spst.com.Roads.Car;
import spst.com.Roads.Tree;
import spst.com.Screen.Master;
import spst.com.town.Fire;

import static com.badlogic.gdx.math.MathUtils.random;
import static com.badlogic.gdx.math.MathUtils.randomBoolean;

public class People extends MyActor {
    TextureRegion[] textureRegionLeft;
    TextureRegion[] textureRegionDown;
    TextureRegion[] textureRegionUp;
    TextureRegion[] textureRegionRight;

    Animation<TextureRegion> animationLeft;
    Animation<TextureRegion> animationRight;
    Animation<TextureRegion> animationUp;
    Animation<TextureRegion> animationDown;
    float time;
    int timeFire;
    int timeDirection;
    int speed = 1;
    float mouseX = 100000000;
    float mouseY = 100000000;
    boolean isCutting = false;
    boolean isFiringWaste = false;
    boolean isFiringSign = false;
    boolean isFine = false;
    boolean isMoving = false;
    boolean isJogging = false;
    boolean isDangerous = false;
    int randomAction = 0;
    Rectangle rectangle = new Rectangle();


    boolean isAlive = true;
    boolean isBep = false;
    Direction direction = Direction.LEFT;
    float speedX = 0;
    float speedY = 0;

    Tree treeTarget;
    Sign signTarget;

    public People(float x, float y, Stage s, boolean rightside) {
        super(x, y, s);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isAlive) {
            time += delta;
            timeDirection++;
            if (timeDirection % 300 == 0 && !isCutting && !isFiringWaste && !isFiringSign && !isDangerous) {
                randomAction = MathUtils.random(0,20 );
                if (randomAction < 15) {
                    isJogging = true;
                    isCutting = false;
                    isFiringWaste = false;
                    isFiringSign = false;
                } else if (randomAction == 15 || randomAction == 16) {
                    isCutting = true;
                    isFiringWaste = false;
                    isJogging = false;
                    isFiringSign = false;
                } else if (randomAction == 17 || randomAction == 18) {
                    isFiringWaste = true;
                    isCutting = false;
                    isJogging = false;
                    isFiringSign = false;
                } else if (randomAction == 19 || randomAction == 20) {
                    isFiringSign = true;
                    isFiringWaste = false;
                    isCutting = false;
                    isJogging = false;
                }
                if (isCutting) {
                    if (!Master.trees.isEmpty()) {
                        boolean findTarget = false;
                        for(int i = 0; i <2; i++) {
                            if (!findTarget) {
                                boolean canPut = true;
                                treeTarget = Master.trees.random();
                                for (Rectangle rectangle1 : Master.noCutting) {
                                    if (rectangle1.contains(treeTarget.getX(), treeTarget.getY())) {
                                        canPut = false;
                                        break;
                                    }
                                }
                                if(canPut){
                                    findTarget = true;
                                    Master.trees.removeValue(treeTarget, true);
                                    System.out.println("Chat cay thoi anh em!" + Master.trees.size);
                                    mouseX = treeTarget.getX() + 32;
                                    mouseY = treeTarget.getY();
                                    isMoving = true;
                                }
                            }
                        }
                    }
                }
                if (isJogging) {
                    mouseX = MathUtils.random(100, 2200);
                    mouseY = MathUtils.random(20, 780);
                    isMoving = true;
                }
                if (isFiringWaste) {
                    boolean vitriDot = true;
                    boolean canFind = false;
                    for (int i = 0; i < 5; i++) {
                        mouseX = MathUtils.random(100, 2200);
                        mouseY = MathUtils.random(20, 780);
                        for (Rectangle rectangle1 : Master.noDotRac) {
                            if (rectangle1.contains(mouseX, mouseY)) {
                                vitriDot = false;
                                break;
                            }
                        }
                        if (vitriDot) {
                            rectangle.setSize(30, 26);
                            rectangle.setPosition(mouseX - 4, mouseY - 4);
                            isMoving = true;
                            canFind = true;
                            break;
                        }
                    }
                    if(!canFind){
                        isFiringWaste = false;
                        isJogging = true;
                        mouseX = MathUtils.random(100, 2200);
                        mouseY = MathUtils.random(20, 780);
                    }

                }
                if (isFiringSign) {
                    if (!Master.signs.isEmpty()) {
                        signTarget = Master.signs .removeIndex(random(0, Master.signs.size - 1));
                        System.out.println("Chong pha chinh quyen thoi anh em!" + Master.signs.size);
                        mouseX = signTarget.getX() + 32;
                        mouseY = signTarget.getY();
                        isMoving = true;
                    }
                }
            }
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    if(1180-6<getX() && getX() < 1180 + 4*32 - 10+6 &&!(11*32-6<getY() && getY()<14*32+6)){
                        isFiringWaste = false;
                        isCutting = false;
                        isJogging = true;
                        isDangerous = true;
                        isFiringSign = false;
                        mouseX = MathUtils.random(100, 2200);
                        mouseY = MathUtils.random(20, 780);
                    }else{
                        isDangerous = false;
                    }
                    if(getX()+getWidth()/2f-32*5<Master.player.getX()+Master.player.getWidth()/2f
                        &&Master.player.getX()+Master.player.getWidth()/2f<getX()+getWidth()/2f+32*5
                        &&getY()+getHeight()/2f-32*5<Master.player.getY()+Master.player.getHeight()/2f
                        &&Master.player.getY()+Master.player.getHeight()/2f<getY()+getHeight()/2f+32*5) {
                        isFiringWaste = false;
                        isCutting = false;
                        isJogging = true;
                        isDangerous = true;
                        isFiringSign = false;
                    }
                }
            },0);

            if (treeTarget != null) {
                Rectangle rec = new Rectangle(treeTarget.getX() + 32, treeTarget.getY(), 33, 64);
                if (rec.overlaps(getBound()) && !treeTarget.isCutDown) {
                    treeTarget.isCutDown = true;
                    treeTarget.addAction(Actions.sequence(
                        Actions.delay(5),
                        Actions.removeActor()
                    ));
                    addAction(Actions.sequence(
                        Actions.delay(5),
                        Actions.run(() -> {
                            isCutting = false;
                            treeTarget = null;
                        })
                    ));
                }
                rec = null;
            }

            if (signTarget != null) {
                Rectangle rec = new Rectangle(signTarget.getX() + 32, signTarget.getY(), 33, 64);
                if (rec.overlaps(getBound()) && !signTarget.isFire) {
                    signTarget.isFire = true;
                    signTarget.addAction(Actions.sequence(
                        Actions.delay(5),
                        Actions.removeActor()
                    ));
                    addAction(Actions.sequence(
                        Actions.delay(5),
                        Actions.run(() -> {
                            isFiringSign = false;
                            signTarget = null;
                        })
                    ));
                }
                rec = null;
            }

            if (rectangle.contains(getX(), getY())) {
                WasteFire wasteFire = new WasteFire(getX() + 32, getY(), getStage());
                addAction(Actions.sequence(
                    Actions.delay(5),
                    Actions.run(() -> {
                        isFiringWaste = false;
                        isFiringSign = false;
                        wasteFire.remove();
                    })
                ));
                rectangle.setPosition(100000000.9999999999999999999999999999999999999999999999999999f, 1000000000.9999999999999999999999999999999999999999999999999999999999f);

            }

            if (isMoving) {
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
                            GameState.danso--;
                            Master.blood.getColor().a+=Master.blood.numberBlood;
                            new FloatingNews(0,500,Master.noMoveStage,"1 người chết do bị rơi xuống sông",Color.RED).toFront();
                            remove();
                        })
                    )
                );
            }
        } else {
            setSize(32,32);
        }
        for(Car c : Master.cars){
            if(getBound().overlaps(c.getBoundCar())){
//                isAlive = false;
//                isBep = true;
//                c.toFront();
//                addAction(Actions.sequence(
//                    Actions.fadeOut(6),
//                    Actions.run(()->{
//                        GameState.danso--;
//                        new FloatingNews(0,500,Master.noMoveStage,"1 người chết do bị xe đâm",Color.RED).toFront();
//                        remove();
//                    })
//                ));
                isMoving = false;
            }
        }
        if(isBep){
            setSize(32, 8);
        }

    }
}

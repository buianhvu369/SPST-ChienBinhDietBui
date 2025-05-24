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
    float mouseXBridge = 100000;
    float mouseYBridge = 100000;
    boolean isCutting = false;
    boolean isFiringWaste = false;
    boolean isFiringSign = false;
    boolean isFine = false;
    boolean isMoving = false;
    boolean isJogging = false;
    boolean isDangerous = false;
    boolean isDoTrash = false;
    boolean isCrossBridge = false;
    int randomAction = 0;
    Rectangle rectangle = new Rectangle();
    Rectangle rectangle2 = new Rectangle();
    Rectangle rectangle3 = new Rectangle();
    Rectangle rectangle4 = new Rectangle();


    boolean isAlive = true;
    boolean isBep = false;
    Direction direction = Direction.LEFT;
    float speedX = 0;
    float speedY = 0;

    Tree treeTarget;
    Sign signTarget;

    boolean isFree = false;

    public People(float x, float y, Stage s, boolean rightside) {
        super(x, y, s);
        addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                if(isCutting){
                    GameState.money += 150 ;
                    if(Master.police.getIsUsing()){
                        GameState.money += 150 ;
                        new FloatingNews(Gdx.graphics.getWidth()/2f-10,Gdx.graphics.getHeight()/2f+100,Master.noMoveStage,"+300 $(x2)",Color.GREEN);
                    }else {
                        new FloatingNews(Gdx.graphics.getWidth()/2f-10,Gdx.graphics.getHeight()/2f+100,Master.noMoveStage,"+150 $",Color.GREEN);
                    }
                    Master.collect.play();
                    if(Master.soNguoiChatCay >0){
                        Master.soNguoiChatCay--;
                    }else{
                        if(Master.nhiemvu1 == 1 || Master.nhiemvu1 == 4){
                            Master.nhiemvu1 = 77;
                            GameState.money += 200;

                        }
                    }
                    if(Master.isSoiCam){
                        if(Master.nhiemvu2 == 6){
                            Master.nhiemvu2 = 77;
                            GameState.money += 200;
                        }
                    }
                }else if(isFiringWaste){
                    GameState.money += 150 ;
                    if(Master.police.getIsUsing()){
                        GameState.money += 150 ;
                        new FloatingNews(Gdx.graphics.getWidth()/2f-10,Gdx.graphics.getHeight()/2f+100,Master.noMoveStage,"+300 $(x2)",Color.GREEN);
                    }else {
                        new FloatingNews(Gdx.graphics.getWidth()/2f-10,Gdx.graphics.getHeight()/2f+100,Master.noMoveStage,"+150 $",Color.GREEN);
                    }
                    Master.collect.play();
                    if(Master.soNguoiDotRac >0){
                        Master.soNguoiChatCay--;
                    }else{
                        if(Master.nhiemvu1 == 2 || Master.nhiemvu1 == 5){
                            Master.nhiemvu1 = 77;
                            GameState.money += 200;
                        }
                    }
                    if(Master.isSoiCam){
                        if(Master.nhiemvu2 == 6){
                            Master.nhiemvu2 = 77;
                            GameState.money += 200;
                        }
                    }
                }else if(isFiringSign){
                    GameState.money += 150 ;
                    if(Master.police.getIsUsing()){
                        GameState.money += 150 ;
                        new FloatingNews(Gdx.graphics.getWidth()/2f-10,Gdx.graphics.getHeight()/2f+100,Master.noMoveStage,"+300 $(x2)",Color.GREEN);
                    }else {
                        new FloatingNews(Gdx.graphics.getWidth()/2f-10,Gdx.graphics.getHeight()/2f+100,Master.noMoveStage,"+150 $",Color.GREEN);
                    }
                    Master.collect.play();
                    if(Master.soNguoiDotBien >0){
                        Master.soNguoiDotBien--;
                    }else{
                        if(Master.nhiemvu1 == 3 || Master.nhiemvu1 == 6){
                            Master.nhiemvu1 = 77;
                            GameState.money += 200;
                        }
                    }
                    if(Master.isSoiCam){
                        if(Master.nhiemvu2 == 6){
                            Master.nhiemvu2 = 77;
                            GameState.money += 200;
                        }
                    }
                } else {
                    GameState.money -= 50;
                    new FloatingNews(Gdx.graphics.getWidth()/2f-10,Gdx.graphics.getHeight()/2f+100,Master.noMoveStage,"-50 $",Color.GREEN);
                }
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isAlive) {
            if(!Master.isNgayTrongCay) {
                time += delta;
                timeDirection++;
                if (timeDirection % 300 == 0 && !isCutting && !isFiringWaste && !isFiringSign && !isDangerous) {
                    randomAction = MathUtils.random(0, 101);
                    if (randomAction < 40) {
                        isJogging = true;
                        isDoTrash = false;
                        isCutting = false;
                        isFiringWaste = false;
                        isFiringSign = false;
                    }else if (randomAction < 70) {
                        isDoTrash = true;
                        isCutting = false;
                        isFiringWaste = false;
                        isFiringSign = false;
                        isJogging = false;
                    } else if (randomAction < 80) {
                        isCutting = true;
                        isFiringWaste = false;
                        isJogging = false;
                        isFiringSign = false;
                        isDoTrash = false;
                    } else if (randomAction < 95) {
                        isFiringWaste = true;
                        isCutting = false;
                        isJogging = false;
                        isFiringSign = false;
                        isDoTrash = false;
                    } else if (randomAction < 100) {
                        isFiringSign = true;
                        isFiringWaste = false;
                        isCutting = false;
                        isJogging = false;
                        isDoTrash = false;
                    }
                    if (isCutting) {
                        if (!Master.trees.isEmpty()) {
                            boolean findTarget = false;
                            for (int i = 0; i < 2; i++) {
                                if (!findTarget) {
                                    boolean canPut = true;
                                    treeTarget = Master.trees.random();
                                    for (Rectangle rectangle1 : Master.noCutting) {
                                        if (rectangle1.contains(treeTarget.getX(), treeTarget.getY())) {
                                            canPut = false;
                                            break;
                                        }
                                    }
                                    if (canPut) {
                                        findTarget = true;
                                        Master.trees.removeValue(treeTarget, true);
                                        System.out.println("Chat cay thoi anh em!" + Master.trees.size);
                                        mouseX = treeTarget.getX() + 32;
                                        mouseY = treeTarget.getY();
                                        isMoving = true;
                                        if (getX() >= 40 * 32 && getX() > mouseX) {
                                            isCrossBridge = true;
                                            mouseXBridge = 36 * 4 - 12;
                                            mouseYBridge = 11 * 32 + 3;
                                            rectangle3.setSize(20, 20);
                                            rectangle3.setPosition(mouseXBridge - 20, mouseYBridge - 20);
                                        } else if (getX() <= 36 * 4 && getX() < mouseX) {
                                            isCrossBridge = true;
                                            mouseXBridge = 40 * 4 + 12;
                                            mouseYBridge = 11 * 32 + 3;
                                            rectangle3.setSize(20, 20);
                                            rectangle3.setPosition(mouseXBridge + 20, mouseYBridge + 20);
                                        } else {
                                            isCrossBridge = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (isJogging) {
                        mouseX = MathUtils.random(100, 2200);
                        mouseY = MathUtils.random(20, 780);
                        isMoving = true;
                        if (getX() >= 40 * 32 && getX() > mouseX) {
                            isCrossBridge = true;
                            mouseXBridge = 36 * 4 - 12;
                            mouseYBridge = 11 * 32 + 3;
                            rectangle3.setSize(20, 20);
                            rectangle3.setPosition(mouseXBridge - 20, mouseYBridge - 20);
                        } else if (getX() <= 36 * 4 && getX() < mouseX) {
                            isCrossBridge = true;
                            mouseXBridge = 40 * 4 + 12;
                            mouseYBridge = 11 * 32 + 3;
                            rectangle3.setSize(20, 20);
                            rectangle3.setPosition(mouseXBridge + 20, mouseYBridge + 20);
                        } else {
                            isCrossBridge = false;
                        }
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
                                if (getX() >= 40 * 32 && getX() > mouseX) {
                                    isCrossBridge = true;
                                    mouseXBridge = 36 * 4 - 12;
                                    mouseYBridge = 11 * 32 + 3;
                                    rectangle3.setSize(20, 20);
                                    rectangle3.setPosition(mouseXBridge - 20, mouseYBridge - 20);
                                } else if (getX() <= 36 * 4 && getX() < mouseX) {
                                    isCrossBridge = true;
                                    mouseXBridge = 40 * 4 + 12;
                                    mouseYBridge = 11 * 32 + 3;
                                    rectangle3.setSize(20, 20);
                                    rectangle3.setPosition(mouseXBridge + 20, mouseYBridge + 20);
                                } else {
                                    isCrossBridge = false;
                                }
                                break;
                            }
                        }
                        if (!canFind) {
                            isFiringWaste = false;
                            isJogging = true;
                            mouseX = MathUtils.random(100, 2200);
                            mouseY = MathUtils.random(20, 780);
                        }

                    }
                    if (isFiringSign) {
                        if (!Master.signs.isEmpty()) {
                            signTarget = Master.signs.removeIndex(random(0, Master.signs.size - 1));
                            System.out.println("Chong pha chinh quyen thoi anh em!" + Master.signs.size);
                            mouseX = signTarget.getX() + 32;
                            mouseY = signTarget.getY();
                            isMoving = true;
                            if (getX() >= 40 * 32 && getX() > mouseX) {
                                isCrossBridge = true;
                                mouseXBridge = 36 * 4 - 12;
                                mouseYBridge = 11 * 32 + 3;
                                rectangle3.setSize(20, 20);
                                rectangle3.setPosition(mouseXBridge - 20, mouseYBridge - 20);
                            } else if (getX() <= 36 * 4 && getX() < mouseX) {
                                isCrossBridge = true;
                                mouseXBridge = 40 * 4 + 12;
                                mouseYBridge = 11 * 32 + 3;
                                rectangle3.setSize(20, 20);
                                rectangle3.setPosition(mouseXBridge + 20, mouseYBridge + 20);
                            } else {
                                isCrossBridge = false;
                            }
                        }
                    }
                    if (isDoTrash) {
                        mouseX = MathUtils.random(0, 8 * 32);
                        mouseY = MathUtils.random(0, 11 * 32);
                        rectangle2.setSize(30, 26);
                        rectangle2.setPosition(mouseX - 4, mouseY - 4);
                        isMoving = true;
                        if (getX() >= 40 * 32 && getX() > mouseX) {
                            isCrossBridge = true;
                            mouseXBridge = 36 * 4 - 12;
                            mouseYBridge = 11 * 32 + 3;
                            rectangle3.setSize(20, 20);
                            rectangle3.setPosition(mouseXBridge - 20, mouseYBridge - 20);
                        } else if (getX() <= 36 * 4 && getX() < mouseX) {
                            isCrossBridge = true;
                            mouseXBridge = 40 * 4 + 12;
                            mouseYBridge = 11 * 32 + 3;
                            rectangle3.setSize(20, 20);
                            rectangle3.setPosition(mouseXBridge + 20, mouseYBridge + 20);
                        } else {
                            isCrossBridge = false;
                        }

                    }
                }
//            Timer.schedule(new Timer.Task() {
//                @Override
//                public void run() {
//                    if(1180-6<getX() && getX() < 1180 + 4*32 - 10+6 &&!(11*32-6<getY() && getY()<14*32+6)){
//                        isFiringWaste = false;
//                        isCutting = false;
//                        isJogging = true;
//                        isDangerous = true;
//                        isFiringSign = false;
//                    }else{
//                        isDangerous = false;
//                    }
//                    if(getX()+getWidth()/2f-32*5<Master.player.getX()+Master.player.getWidth()/2f
//                        &&Master.player.getX()+Master.player.getWidth()/2f<getX()+getWidth()/2f+32*5
//                        &&getY()+getHeight()/2f-32*5<Master.player.getY()+Master.player.getHeight()/2f
//                        &&Master.player.getY()+Master.player.getHeight()/2f<getY()+getHeight()/2f+32*5) {
//                        isFiringWaste = false;
//                        isCutting = false;
//                        isJogging = true;
//                        isDangerous = true;
//                        isFiringSign = false;
//                    }
//                }
//            },0);

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

                if (rectangle2.contains(getX(), getY())) {
                    Waste waste = new Waste(getX() - 32, getY(), getStage(), '0');
                    rectangle2.setPosition(100000000.9999999999999999999999999999999999999999999999999999f, 1000000000.9999999999999999999999999999999999999999999999999999999999f);
                }
            }else {
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
                    if(isFree){
                        rectangle4.setPosition(mouseX, mouseY);
                        rectangle4.setSize(20,20);
                        isMoving = true;
                        isCrossBridge = false;
                    }
                }
                if (rectangle4.contains(getX()+10, getY()+10)) {
                    new LoadingPlant(getX() + 32, getY(), getStage());
                    rectangle4.setPosition(100000000.9999999999999999999999999999999999999999999999999999f, 1000000000.9999999999999999999999999999999999999999999999999999999999f);
                    Master.soCayTieuChuan--;
                    if(Master.soCayTieuChuan == 0){
                        Master.isNgayTrongCay = false;
                        Master.soCayTieuChuan = MathUtils.random(10, 25);
                        Master.soNgayDienRaLeHoi = MathUtils.random(5, 10);
                    }
                    addAction(Actions.sequence(
                        Actions.delay(2),
                        Actions.run(() -> {
                            isFree = false;
                        })
                    ));
                }
            }

            if (isMoving) {
                if(rectangle3.contains(getX(), getY())){
                    isCrossBridge = false;
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
        if(!isAlive&&getX() > 1180+32 && getX() < 1180 + 4*32 - 10-32){
            if(14*32>=getY()&&getY()>=11*32){
                toBack();
            }else {
                toFront();
            }
        }
        if(getBound().overlaps(Master.blood.getBound())&&(1180<getX() && getX() < 1180 + 4*32 - 10 &&!(11*32<getY() && getY()<14*32))){
            textureRegion = Utils.getRegion(23*16, 0, 16, 6);
            setSize(32, 12);
            if(getX() > 1180+32 && getX() < 1180 + 4*32 - 10-32 && isAlive){
                isAlive = false;
                addAction(Actions.moveBy(0,-200,6));
                addAction(Actions.sequence(
                    Actions.fadeOut(6),
                    Actions.run(()->{
                        GameState.danso--;
                        new FloatingNews(0,500,Master.noMoveStage,"1 người chết do bị trôi sông",Color.RED).toFront();
                        remove();
                    })
                ));
            }
        } else {
            setSize(32,32);
        }
        for(Car c : Master.cars){
            if(getBound().overlaps(c.getBoundCar())){
                isAlive = false;
                isBep = true;
                c.toFront();
                addAction(Actions.sequence(
                    Actions.fadeOut(6),
                    Actions.run(()->{
                        GameState.danso--;
                        new FloatingNews(0,500,Master.noMoveStage,"1 người chết do bị xe đâm",Color.RED).toFront();
                        remove();
                    })
                ));
            }
        }
        if(getBound().overlaps(Master.trashTruck.getBound())){
            isAlive = false;
            isBep = true;
            addAction(Actions.sequence(
                Actions.fadeOut(6),
                Actions.run(()->{
                    GameState.danso--;
                    new FloatingNews(0,500,Master.noMoveStage,"1 người chết do bị xe đâm",Color.RED).toFront();
                    remove();
                })
            ));
        }
        if(getBound().overlaps(Master.taxi.getBound())){
            isAlive = false;
            isBep = true;
            addAction(Actions.sequence(
                Actions.fadeOut(6),
                Actions.run(()->{
                    GameState.danso--;
                    new FloatingNews(0,500,Master.noMoveStage,"1 người chết do bị xe đâm",Color.RED).toFront();
                    remove();
                })
            ));
        }
        if(isBep){
            setSize(32, 8);
        }

    }
}

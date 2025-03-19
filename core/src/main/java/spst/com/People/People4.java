package spst.com.People;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.*;
import spst.com.Roads.Car;
import spst.com.Roads.Tree;
import spst.com.Screen.Master;

import static com.badlogic.gdx.math.MathUtils.random;

public class People4 extends MyActor {
    Animation<TextureRegion> animationLeft;
    Animation<TextureRegion> animationRight;
    Animation<TextureRegion> animationUp;
    Animation<TextureRegion> animationDown;
    int speed = 2;
    float time;
    float mouseX = -13314;
    float mouseY = -1321687;
    boolean takeWater = true;
    int timeDirection;

    Direction direction = Direction.LEFT;
    float speedX = 0;
    float speedY = 0;
    boolean isMoving = false;
    boolean isCutting = false;
    boolean isFiring = false;
    boolean isAlive = true;
    boolean isBep = false;
    Tree treeTarget;


    public People4(float x, float y, Stage s, boolean rightside) {
        super(x, y, s);
        setSize(32, 32);
        TextureRegion[] textureRegionLeft = {Utils.getRegion(16 * 23, 16 * 12, 16, 16), Utils.getRegion(16 * 23, 16 * 13, 16, 16), Utils.getRegion(16 * 23, 16 * 14, 16, 16)};
        TextureRegion[] textureRegionDown = {Utils.getRegion(16 * 24, 16 * 12, 16, 16), Utils.getRegion(16 * 24, 16 * 13, 16, 16), Utils.getRegion(16 * 24, 16 * 14, 16, 16)};
        TextureRegion[] textureRegionUp = {Utils.getRegion(16 * 25, 16 * 12, 16, 16), Utils.getRegion(16 * 25, 16 * 13, 16, 16), Utils.getRegion(16 * 25, 16 * 14, 16, 16)};
        TextureRegion[] textureRegionRight = {Utils.getRegion(16 * 26, 16 * 12, 16, 16), Utils.getRegion(16 * 26, 16 * 13, 16, 16), Utils.getRegion(16 * 26, 16 * 14, 16, 16)};
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

        this.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(isCutting){
                    GameState.money += 225;
                }
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isAlive){
            time+= delta;
            timeDirection++;
            if(timeDirection % 300 == 0 && !isCutting){
                isCutting = MathUtils.randomBoolean();
                if(isCutting){
                    if(!Master.trees.isEmpty()){
                        treeTarget = Master.trees.removeIndex(random(0, Master.trees.size - 1));
                        System.out.println("Chat cay thoi anh em!" + Master.trees.size);
                        mouseX = treeTarget.getX() + 32;
                        mouseY = treeTarget.getY();
                        isMoving = true;

                    }
                }
            }

            if(treeTarget != null){
                Rectangle rec = new Rectangle(treeTarget.getX()+32, treeTarget.getY(), 33, 64);
                if(rec.overlaps(getBound()) && !treeTarget.isCutDown) {
                    treeTarget.isCutDown = true;
                    treeTarget.addAction(Actions.sequence(
                        Actions.delay(5),
                        Actions.removeActor()
                    ));
                    addAction(Actions.sequence(
                        Actions.delay(5),
                        Actions.run(()->{
                            isCutting = false;
                            treeTarget = null;
                        })
                    ));
                }
                rec = null;
            }

            if(isMoving){
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
                            new FloatingNews(0,Gdx.graphics.getHeight()/2f,Master.noMoveStage,
                                "Có 1 người chết, cảnh sát phát hiện ra xác nạn nhân ở bờ sông Hồng, hiện các cơ " +
                                    "quan chức năng đang điều tra về vụ việc này", Color.RED);
                            remove();
                        }
                    )
                    )
                );
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
                        new FloatingNews(Gdx.graphics.getWidth()/2f,Gdx.graphics.getHeight()/2f,Master.noMoveStage,"Đã có 1 tài xế đâm người và bỏ chạy, hiện cơ quan chức năng đang điều tra thêm", Color.YELLOW);
                        remove();
                    })
                ));
            }
        }
        if(isBep){
            setSize(32, 8);
        }
    }
}


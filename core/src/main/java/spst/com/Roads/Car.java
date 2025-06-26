package spst.com.Roads;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import spst.com.*;
import spst.com.Enums.TypeRoadRe;
import spst.com.InFactory.BuyRoadRe;
import spst.com.InFactory.BuyRoadReNgoai;
import spst.com.Roads.CrossRoad.Corner;
import spst.com.Screen.Master;

import java.util.Random;
import static com.badlogic.gdx.math.MathUtils.random;

public class Car extends MyActor {
    int speedX;
    int speedY;
    char ran = (char) MathUtils.random.nextInt(1,3);;
    public boolean isRightthis;
    int ran2 = MathUtils.random.nextInt(1,3);
    int khaNangRe = -1;
    boolean isRe = false;
    boolean isAlive = true;
    boolean isBep = false;
    public Car(float x, float y, Stage s) {
        super(x, y, s);
        speedX = 2;
        speedY = 0;
        switch (ran) {
            case 0 -> textureRegion = Utils.getRegion(15*16, 16*16, 32, 32);
            case 1 -> textureRegion = Utils.getRegion(15*16, 16*14, 32, 32);
            case 2 -> textureRegion = Utils.getRegion(21*16, 17*16, 32, 16);
        }
        setPosition(0, 800/2f-48+8);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isAlive){
            if(!(Master.isDenDo&&getX()>24*32 && 26*32 > getX())){
                Move();
                setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
                moveBy(speedX, speedY);
            }
        }

        if(getBound().overlaps(Master.taxi.getBound())){
            isAlive = false;
            isBep = true;
            addAction(Actions.sequence(
                Actions.fadeOut(6),
                Actions.run(()->{
                    GameState.danso--;
                    new FloatingNews(0,500,Master.noMoveStage,"1 xe nát do bị xe đâm", Color.RED, TypeEffect.FLOATUP).toFront();
                    remove();
                })
            ));
        }
        if(isBep){
            setSize(32, 8);
        }
    }
    private void Move(){
        boolean isOnRoad = false;
        for(Rectangle rec : Master.roadArray){
            if(getBoundCar().overlaps(rec)){
                isOnRoad = true;
            }
        }
        if(!isOnRoad){
            remove();
        }
        boolean isChamNgaRe = false;
        for(MyActor actor : Master.reArray){
            if(getBoundCar().overlaps(actor.getBound())){
                isChamNgaRe = true;
            }
        }
        if(!isChamNgaRe){
            isRe = false;
        }
        khaNangRe = MathUtils.random.nextInt(0,4);
        if(!isRe){
            for(MyActor actor : Master.reArray){
                if(getBoundCar().overlaps(actor.getBound())){
                    if(actor instanceof Corner){
                        if(khaNangRe==0){
                            isRe = true;
                            if(((Corner) actor).myyx.equals("DL")){
                                if(speedX == -2 && speedY == 0){
                                    switch (ran) {
                                        case 0 -> textureRegion = Utils.getRegion(20 * 16, 16 * 16, 16, 32);
                                        case 1 -> textureRegion = Utils.getRegion(20 * 16, 14 * 16, 16, 32);
                                        case 2 -> textureRegion = Utils.getRegion(22 * 16, 14 * 16, 16, 32);
                                    }
                                    speedX = 0;
                                    speedY = 2;
                                    setPosition(actor.getX()-8-this.getWidth(),actor.getY());
                                }
                            }
                            if(((Corner) actor).myyx.equals("DR")){
                                if(speedX == 0 && speedY == -2){
                                    switch (ran) {
                                        case 0 -> textureRegion = Utils.getRegion(18*16, 16*16, 32, 32);
                                        case 1 -> textureRegion = Utils.getRegion(18*16, 16*14, 32, 32);
                                        case 2 -> textureRegion = Utils.getRegion(21*16, 16*16, 32, 16);
                                    }
                                    speedX = -2;
                                    speedY = 0;
                                    setPosition(actor.getX()-this.getWidth(),actor.getY()-8-this.getHeight());
                                }
                            }
                            if(((Corner) actor).myyx.equals("UL")){
                                if(speedX == 0 && speedY == 2){
                                    switch (ran) {
                                        case 0 -> textureRegion = Utils.getRegion(15*16, 16*16, 32, 32);
                                        case 1 -> textureRegion = Utils.getRegion(15*16, 16*14, 32, 32);
                                        case 2 -> textureRegion = Utils.getRegion(21*16, 17*16, 32, 16);
                                    }
                                    speedX = 2;
                                    speedY = 0;
                                    setPosition(actor.getX(),actor.getY()+8);
                                }
                            }
                            if(((Corner) actor).myyx.equals("UR")){
                                if(speedX == 2 && speedY == 0){
                                    switch (ran){
                                        case 0 -> textureRegion = Utils.getRegion(17*16,16*16,16,32);
                                        case 1 -> textureRegion = Utils.getRegion(17*16,14*16,16,32);
                                        case 2 -> textureRegion = Utils.getRegion(21*16,14*16,16,32);
                                    }
                                    speedX = 0;
                                    speedY = -2;
                                    setPosition(actor.getX()+8,actor.getY()-this.getHeight());
                                }
                            }
                        }
                    }
                    if(actor instanceof BuyRoadReNgoai){
                        if(khaNangRe==1){
                            isRe = true;
                            if(actor.getRotation()==90){
                                if(speedX == -2 && speedY == 0){
                                    switch (ran) {
                                        case 0 -> textureRegion = Utils.getRegion(20 * 16, 16 * 16, 16, 32);
                                        case 1 -> textureRegion = Utils.getRegion(20 * 16, 14 * 16, 16, 32);
                                        case 2 -> textureRegion = Utils.getRegion(22 * 16, 14 * 16, 16, 32);
                                    }
                                    speedX = 0;
                                    speedY = 2;
                                    setPosition(actor.getX()-8-this.getWidth(),actor.getY());
                                    isRe = false;
                                }
                            }
                            if(actor.getRotation()==180){
                                if(speedX == 0 && speedY == -2){
                                    switch (ran) {
                                        case 0 -> textureRegion = Utils.getRegion(18*16, 16*16, 32, 32);
                                        case 1 -> textureRegion = Utils.getRegion(18*16, 16*14, 32, 32);
                                        case 2 -> textureRegion = Utils.getRegion(21*16, 16*16, 32, 16);
                                    }
                                    speedX = -2;
                                    speedY = 0;
                                    setPosition(actor.getX()-this.getWidth(),actor.getY()+8);
                                    isRe = false;
                                }
                            }
                            if(actor.getRotation()==0){
                                if(speedX == 0 && speedY == 2){
                                    switch (ran) {
                                        case 0 -> textureRegion = Utils.getRegion(15*16, 16*16, 32, 32);
                                        case 1 -> textureRegion = Utils.getRegion(15*16, 16*14, 32, 32);
                                        case 2 -> textureRegion = Utils.getRegion(21*16, 17*16, 32, 16);
                                    }
                                    speedX = 2;
                                    speedY = 0;
                                    setPosition(actor.getX(),actor.getY()+8);
                                    isRe = false;
                                }
                            }
                            if(actor.getRotation()==270){
                                if(speedX == 2 && speedY == 0){
                                    switch (ran){
                                        case 0 -> textureRegion = Utils.getRegion(17*16,16*16,16,32);
                                        case 1 -> textureRegion = Utils.getRegion(17*16,14*16,16,32);
                                        case 2 -> textureRegion = Utils.getRegion(21*16,14*16,16,32);
                                    }
                                    speedX = 0;
                                    speedY = -2;
                                    setPosition(actor.getX()+8,actor.getY()-this.getHeight());
                                    isRe = false;
                                }
                            }
                        }
                    }
                    if(actor instanceof BuyRoadRe){
                        if (khaNangRe == 2){
                            switch (((BuyRoadRe) actor).type){
                                case Trai -> {
                                    switch (((BuyRoadRe) actor).direc){
                                        case 'u' -> {
                                            if(speedX == 2 && speedY == 0){
                                                switch (ran){
                                                    case 0 -> textureRegion = Utils.getRegion(17*16,16*16,16,32);
                                                    case 1 -> textureRegion = Utils.getRegion(17*16,14*16,16,32);
                                                    case 2 -> textureRegion = Utils.getRegion(21*16,14*16,16,32);
                                                }
                                                speedX = 0;
                                                speedY = -2;
                                                setPosition(actor.getX()+8,actor.getY()-this.getHeight());
                                            }
                                        }
                                        case 'r' -> {
                                            if(speedX == 0 && speedY == -2){
                                                switch (ran) {
                                                    case 0 -> textureRegion = Utils.getRegion(18*16, 16*16, 32, 32);
                                                    case 1 -> textureRegion = Utils.getRegion(18*16, 16*14, 32, 32);
                                                    case 2 -> textureRegion = Utils.getRegion(21*16, 16*16, 32, 16);
                                                }
                                                speedX = -2;
                                                speedY = 0;
                                                setPosition(actor.getX()-this.getWidth(),actor.getY()+32*2+8);
                                                isRe = false;
                                            }
                                        }
                                        case 'l' -> {
                                            if(speedX == 0 && speedY == 2){
                                                switch (ran) {
                                                    case 0 -> textureRegion = Utils.getRegion(15*16, 16*16, 32, 32);
                                                    case 1 -> textureRegion = Utils.getRegion(15*16, 16*14, 32, 32);
                                                    case 2 -> textureRegion = Utils.getRegion(21*16, 17*16, 32, 16);
                                                }
                                                speedX = 2;
                                                speedY = 0;
                                                setPosition(actor.getX(),actor.getY()+8);
                                                isRe = false;
                                            }
                                        }
                                        case 'd' -> {
                                            if(speedX == -2 && speedY == 0){
                                                switch (ran) {
                                                    case 0 -> textureRegion = Utils.getRegion(20 * 16, 16 * 16, 16, 32);
                                                    case 1 -> textureRegion = Utils.getRegion(20 * 16, 14 * 16, 16, 32);
                                                    case 2 -> textureRegion = Utils.getRegion(22 * 16, 14 * 16, 16, 32);
                                                }
                                                speedX = 0;
                                                speedY = 2;
                                                setPosition(actor.getX()-8-this.getWidth(),actor.getY());
                                                isRe = false;
                                            }
                                        }
                                    }
                                }
                                case Phai -> {
                                    switch (((BuyRoadRe) actor).direc){
                                        case 'u' -> {
                                            if(speedX == 0 && speedY == 2){
                                                switch (ran) {
                                                    case 0 -> textureRegion = Utils.getRegion(15*16, 16*16, 32, 32);
                                                    case 1 -> textureRegion = Utils.getRegion(15*16, 16*14, 32, 32);
                                                    case 2 -> textureRegion = Utils.getRegion(21*16, 17*16, 32, 16);
                                                }
                                                speedX = 2;
                                                speedY = 0;
                                                setPosition(actor.getX(),actor.getY()+8);
                                                isRe = false;
                                            }
                                        }
                                        case 'r' -> {
                                            if(speedX == 2 && speedY == 0){
                                                switch (ran){
                                                    case 0 -> textureRegion = Utils.getRegion(17*16,16*16,16,32);
                                                    case 1 -> textureRegion = Utils.getRegion(17*16,14*16,16,32);
                                                    case 2 -> textureRegion = Utils.getRegion(21*16,14*16,16,32);
                                                }
                                                speedX = 0;
                                                speedY = -2;
                                                setPosition(actor.getX()+8,actor.getY()-this.getHeight());
                                            }
                                        }
                                        case 'l' -> {
                                            if(speedX == -2 && speedY == 0){
                                                switch (ran) {
                                                    case 0 -> textureRegion = Utils.getRegion(20 * 16, 16 * 16, 16, 32);
                                                    case 1 -> textureRegion = Utils.getRegion(20 * 16, 14 * 16, 16, 32);
                                                    case 2 -> textureRegion = Utils.getRegion(22 * 16, 14 * 16, 16, 32);
                                                }
                                                speedX = 0;
                                                speedY = 2;
                                                setPosition(actor.getX()-8,actor.getY());
                                                isRe = false;
                                            }
                                        }
                                        case 'd' -> {
                                            if(speedX == 0 && speedY == -2){
                                                switch (ran) {
                                                    case 0 -> textureRegion = Utils.getRegion(18*16, 16*16, 32, 32);
                                                    case 1 -> textureRegion = Utils.getRegion(18*16, 16*14, 32, 32);
                                                    case 2 -> textureRegion = Utils.getRegion(21*16, 16*16, 32, 16);
                                                }
                                                speedX = -2;
                                                speedY = 0;
                                                setPosition(actor.getX()-this.getWidth(),actor.getY()+32*2+8);
                                                isRe = false;
                                            }
                                        }
                                    }
                                }
                                case CaHai -> {
                                    switch (((BuyRoadRe) actor).direc){
                                        case 'u' -> {
                                            if(MathUtils.randomBoolean()){
                                                if(speedX == 0 && speedY == 2){
                                                    switch (ran) {
                                                        case 0 -> textureRegion = Utils.getRegion(15*16, 16*16, 32, 32);
                                                        case 1 -> textureRegion = Utils.getRegion(15*16, 16*14, 32, 32);
                                                        case 2 -> textureRegion = Utils.getRegion(21*16, 17*16, 32, 16);
                                                    }
                                                    speedX = 2;
                                                    speedY = 0;
                                                    setPosition(actor.getX(),actor.getY()+8);
                                                    isRe = false;
                                                }
                                            }else {
                                                if(speedX == 2 && speedY == 0){
                                                    switch (ran){
                                                        case 0 -> textureRegion = Utils.getRegion(17*16,16*16,16,32);
                                                        case 1 -> textureRegion = Utils.getRegion(17*16,14*16,16,32);
                                                        case 2 -> textureRegion = Utils.getRegion(21*16,14*16,16,32);
                                                    }
                                                    speedX = 0;
                                                    speedY = -2;
                                                    setPosition(actor.getX()+8,actor.getY()-this.getHeight());
                                                }
                                            }
                                        }
                                        case 'r' -> {
                                            if(MathUtils.randomBoolean()){
                                                if(speedX == 2 && speedY == 0){
                                                    switch (ran){
                                                        case 0 -> textureRegion = Utils.getRegion(17*16,16*16,16,32);
                                                        case 1 -> textureRegion = Utils.getRegion(17*16,14*16,16,32);
                                                        case 2 -> textureRegion = Utils.getRegion(21*16,14*16,16,32);
                                                    }
                                                    speedX = 0;
                                                    speedY = -2;
                                                    setPosition(actor.getX()+8,actor.getY()-this.getHeight());
                                                }
                                            }else {
                                                if(speedX == 0 && speedY == -2){
                                                    switch (ran) {
                                                        case 0 -> textureRegion = Utils.getRegion(18*16, 16*16, 32, 32);
                                                        case 1 -> textureRegion = Utils.getRegion(18*16, 16*14, 32, 32);
                                                        case 2 -> textureRegion = Utils.getRegion(21*16, 16*16, 32, 16);
                                                    }
                                                    speedX = -2;
                                                    speedY = 0;
                                                    setPosition(actor.getX()-this.getWidth(),actor.getY()+32*2+8);
                                                    isRe = false;
                                                }
                                            }
                                        }
                                        case 'l' -> {
                                            if(MathUtils.randomBoolean()){
                                                if(speedX == -2 && speedY == 0){
                                                    switch (ran) {
                                                        case 0 -> textureRegion = Utils.getRegion(20 * 16, 16 * 16, 16, 32);
                                                        case 1 -> textureRegion = Utils.getRegion(20 * 16, 14 * 16, 16, 32);
                                                        case 2 -> textureRegion = Utils.getRegion(22 * 16, 14 * 16, 16, 32);
                                                    }
                                                    speedX = 0;
                                                    speedY = 2;
                                                    setPosition(actor.getX()-8,actor.getY());
                                                    isRe = false;
                                                }
                                            }else {
                                                if(speedX == 0 && speedY == 2){
                                                    switch (ran) {
                                                        case 0 -> textureRegion = Utils.getRegion(15*16, 16*16, 32, 32);
                                                        case 1 -> textureRegion = Utils.getRegion(15*16, 16*14, 32, 32);
                                                        case 2 -> textureRegion = Utils.getRegion(21*16, 17*16, 32, 16);
                                                    }
                                                    speedX = 2;
                                                    speedY = 0;
                                                    setPosition(actor.getX(),actor.getY()+8);
                                                    isRe = false;
                                                }
                                            }
                                        }
                                        case 'd' -> {
                                            if(MathUtils.randomBoolean()){
                                                if(speedX == -2 && speedY == 0){
                                                    switch (ran) {
                                                        case 0 -> textureRegion = Utils.getRegion(20 * 16, 16 * 16, 16, 32);
                                                        case 1 -> textureRegion = Utils.getRegion(20 * 16, 14 * 16, 16, 32);
                                                        case 2 -> textureRegion = Utils.getRegion(22 * 16, 14 * 16, 16, 32);
                                                    }
                                                    speedX = 0;
                                                    speedY = 2;
                                                    setPosition(actor.getX()-8,actor.getY());
                                                    isRe = false;
                                                }
                                            }else {
                                                if(speedX == 0 && speedY == -2){
                                                    switch (ran) {
                                                        case 0 -> textureRegion = Utils.getRegion(18*16, 16*16, 32, 32);
                                                        case 1 -> textureRegion = Utils.getRegion(18*16, 16*14, 32, 32);
                                                        case 2 -> textureRegion = Utils.getRegion(21*16, 16*16, 32, 16);
                                                    }
                                                    speedX = -2;
                                                    speedY = 0;
                                                    setPosition(actor.getX()-this.getWidth(),actor.getY()+32*2+8);
                                                    isRe = false;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public Rectangle getBoundCar(){
        return new Rectangle(getX(), getY()+getHeight()/3, getWidth(), getHeight()/4);
    }
}

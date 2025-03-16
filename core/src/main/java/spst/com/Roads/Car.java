package spst.com.Roads;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;

import java.util.Random;
import static com.badlogic.gdx.math.MathUtils.random;

public class Car extends MyActor {
    int speedX;
    int speedY;
    char ran;
    public boolean isRightthis;
    int ran2 = MathUtils.random.nextInt(1,3);
    Random random = new Random();
    public Car(float x, float y, Stage s) {
        super(x, y, s);
        int ran3 = random.nextInt(1,5);//random huong cua xe. 1:trai 2:phai 3:tren 4:duoi
        if(ran3 == 1){
            speedX = -2;
            speedY = 0;
            switch (ran) {
                case 0 -> textureRegion = Utils.getRegion(18*16, 16*16, 32, 32);
                case 1 -> textureRegion = Utils.getRegion(18*16, 16*14, 32, 32);
                case 2 -> textureRegion = Utils.getRegion(21*16, 16*16, 32, 16);
            }
            setPosition(32*75-32, 800/2f+48-32-8);
        }else if(ran3 == 2){
            speedX = 2;
            speedY = 0;
            switch (ran) {
                case 0 -> textureRegion = Utils.getRegion(15*16, 16*16, 32, 32);
                case 1 -> textureRegion = Utils.getRegion(15*16, 16*14, 32, 32);
                case 2 -> textureRegion = Utils.getRegion(21*16, 17*16, 32, 16);
            }
            setPosition(0, 800/2f-48+8);
        }else if(ran3 == 3){
            speedY = 2;
            speedX = 0;
            switch (ran) {
                case 0 -> textureRegion = Utils.getRegion(20 * 16, 16 * 16, 16, 32);
                case 1 -> textureRegion = Utils.getRegion(20 * 16, 14 * 16, 16, 32);
                case 2 -> textureRegion = Utils.getRegion(22 * 16, 14 * 16, 16, 32);
            }
            ran3 = random.nextInt(1,4);
            if(ran3 == 1){
                setPosition(32*9+8, 0);
            }else if(ran3 == 2){
                setPosition(32*25+8, 0);
            }else if(ran3 == 3){
                setPosition(32*52+8, 0);
            }
        }else if(ran3 == 4){
            speedY = -2;
            speedX = 0;
            switch (ran){
                case 0 -> textureRegion = Utils.getRegion(17*16,16*16,16,32);
                case 1 -> textureRegion = Utils.getRegion(17*16,14*16,16,32);
                case 2 -> textureRegion = Utils.getRegion(21*16,14*16,16,32);
            }
            setPosition(32*23-8,800);
        }
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        Master.noPlaced.add(this.getBound());

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        Turn();
        setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        moveBy(speedX, speedY);
    }
    private void Turn(){
        if (getX() > 75*32) {
            setX(0);
        }
        if (getX() < 0-getWidth()) {
            setX(75*32);
        }
        if(getX()==32*9+8 && random.nextInt(1,4) == 1){
            switch (ran){
                case 0 -> textureRegion = Utils.getRegion(17*16,16*16,16,32);
                case 1 -> textureRegion = Utils.getRegion(17*16,14*16,16,32);
                case 2 -> textureRegion = Utils.getRegion(21*16,14*16,16,32);
            }
            speedX = 0;
            speedY = -2;
        }else if(getX()==32*23-8 && random.nextInt(1,4) == 2) {
            switch (ran) {
                case 0 -> textureRegion = Utils.getRegion(20 * 16, 16 * 16, 16, 32);
                case 1 -> textureRegion = Utils.getRegion(20 * 16, 14 * 16, 16, 32);
                case 2 -> textureRegion = Utils.getRegion(22 * 16, 14 * 16, 16, 32);
            }
            speedX = 0;
            speedY = 2;
        }else if(getX()==32*25+8 && random.nextInt(1,4) == 3) {
            switch (ran) {
                case 0 -> textureRegion = Utils.getRegion(17 * 16, 16 * 16, 16, 32);
                case 1 -> textureRegion = Utils.getRegion(17 * 16, 14 * 16, 16, 32);
                case 2 -> textureRegion = Utils.getRegion(21 * 16, 14 * 16, 16, 32);
            }
            speedX = 0;
            speedY = -2;
        }else if(getX()==1184+32*15+8 && random.nextInt(1,4) == 3){
            switch (ran){
                case 0 -> textureRegion = Utils.getRegion(17*16,16*16,16,32);
                case 1 -> textureRegion = Utils.getRegion(17*16,14*16,16,32);
                case 2 -> textureRegion = Utils.getRegion(21*16,14*16,16,32);
            }
            speedX = 0;
            speedY = -2;
        }
        if(getY() == 0 && getX() == 32*9+8){
            remove();
        }
        if(getY() == 0 && getX() == 32*25+8){
            remove();
        }
        if(getY() == 0 && getX() == 1184+32*15+8){
            remove();
        }
        if(getY() == 800 && getX()==32*23-8){
            remove();
        }

        if(speedY == 2){
            if(getY() == 800/2f - 48 && ran2 == 1){
                setY(getY()+16-8);
                switch (ran) {
                    case 0 -> textureRegion = Utils.getRegion(15*16, 16*16, 32, 32);
                    case 1 -> textureRegion = Utils.getRegion(15*16, 16*14, 32, 32);
                    case 2 -> textureRegion = Utils.getRegion(21*16, 17*16, 32, 16);
                }
                speedX = 2;
                speedY = 0;
                ran2 = MathUtils.random.nextInt(1,3);
            } else if((getY() == 800/2f - 48 + 32) && ran2 != 1){
                setY(getY()+16+8);
                switch (ran) {
                    case 0 -> textureRegion = Utils.getRegion(18*16, 16*16, 32, 32);
                    case 1 -> textureRegion = Utils.getRegion(18*16, 16*14, 32, 32);
                    case 2 -> textureRegion = Utils.getRegion(21*16, 16*16, 32, 16);
                }
                speedX = -2;
                speedY = 0;
                ran2 = MathUtils.random.nextInt(1,3);
            }
        }else if (speedY == -2){
            if(getY() == 800/2f + 48 && ran2 == 1){
                setY(getY()-32-8);
                switch (ran) {
                    case 0 -> textureRegion = Utils.getRegion(18*16, 16*16, 32, 32);
                    case 1 -> textureRegion = Utils.getRegion(18*16, 16*14, 32, 32);
                    case 2 -> textureRegion = Utils.getRegion(21*16, 16*16, 32, 16);
                }
                speedX = -2;
                speedY = 0;
                ran2 = MathUtils.random.nextInt(1,3);
            } else if((getY() == 800/2f + 48 - 32) && ran2 != 1){
                setY(getY()-32*2+8);
                switch (ran) {
                    case 0 -> textureRegion = Utils.getRegion(15*16, 16*16, 32, 32);
                    case 1 -> textureRegion = Utils.getRegion(15*16, 16*14, 32, 32);
                    case 2 -> textureRegion = Utils.getRegion(21*16, 17*16, 32, 16);
                }
                speedX = 2;
                speedY = 0;
                ran2 = MathUtils.random.nextInt(1,3);
            }
        }
    }
}

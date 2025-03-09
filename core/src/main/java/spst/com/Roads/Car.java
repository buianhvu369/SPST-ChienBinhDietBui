package spst.com.Roads;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
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
    public Car(float x, float y, Stage s, boolean isRight) {
        super(x, y, s);
        isRightthis = isRight;
        ran = (char) random.nextInt(0,3);
        if(isRight){
            speedX = 2;
            switch (ran) {
                case 0 -> textureRegion = Utils.getRegion(15*16, 16*16, 32, 32);
                case 1 -> textureRegion = Utils.getRegion(15*16, 16*14, 32, 32);
                case 2 -> textureRegion = Utils.getRegion(21*16, 17*16, 32, 16);
            }
        }else {
            speedX = -2;
            switch (ran) {
                case 0 -> textureRegion = Utils.getRegion(18*16, 16*16, 32, 32);
                case 1 -> textureRegion = Utils.getRegion(18*16, 16*14, 32, 32);
                case 2 -> textureRegion = Utils.getRegion(21*16, 16*16, 32, 16);
            }
        }

        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        Turn();
        setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        moveBy(speedX, speedY);
    }
    private void Turn(){
        if (getX() > 1200) {
            setX(0);
        }
        if (getX() < 0-getWidth()) {
            setX(1200);
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
        }
        if(getY() == 0 && getX() == 32*9+8){
            setX(32*27-8);
            speedY = 2;
            switch (ran) {
                case 0 -> textureRegion = Utils.getRegion(20 * 16, 16 * 16, 16, 32);
                case 1 -> textureRegion = Utils.getRegion(20 * 16, 14 * 16, 16, 32);
                case 2 -> textureRegion = Utils.getRegion(22 * 16, 14 * 16, 16, 32);
            }
        }
        if(getY() == 0 && getX() == 32*25+8){
            setX(32*9+8);

            speedY = 2;
            switch (ran) {
                case 0 -> textureRegion = Utils.getRegion(20 * 16, 16 * 16, 16, 32);
                case 1 -> textureRegion = Utils.getRegion(20 * 16, 14 * 16, 16, 32);
                case 2 -> textureRegion = Utils.getRegion(22 * 16, 14 * 16, 16, 32);
            }
        }
        if(getY() == 800 && getX()==32*23-8){
                setX(32*21+8);
            speedY = -2;
            switch (ran) {
                case 0 -> textureRegion = Utils.getRegion(20 * 16, 16 * 16, 16, 32);
                case 1 -> textureRegion = Utils.getRegion(20 * 16, 14 * 16, 16, 32);
                case 2 -> textureRegion = Utils.getRegion(22 * 16, 14 * 16, 16, 32);
            }
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

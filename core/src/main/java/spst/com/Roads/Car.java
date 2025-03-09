package spst.com.Roads;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

import java.util.Random;

public class Car extends MyActor {
    int speedX;
    int speedY;
    char ran;
    public boolean isRightthis;
    TextureRegion[] textureRegions;
    Random random = new Random();
    public Car(float x, float y, Stage s, boolean isRight) {
        super(x, y, s);
        isRightthis = isRight;
        TextureRegion[] textureRegions = {Utils.getRegion(15*16, 16*16, 32, 32),Utils.getRegion(15*16, 16*14, 32, 32),Utils.getRegion(21*16, 17*16, 32, 16)};
        ran = (char) random.nextInt(0,3);
        textureRegion = textureRegions[ran];
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
        if(isRight){
            setScaleX(1);
        }else{
            setScaleX(-1);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isRightthis){
            speedX = 2;
            if (getX() > 1200) {
                setX(0);
            }
        }else{
            speedX = -2;
            if (getX() < 0-getWidth()) {
                setX(1200);
            }
        }
//        if(isRightthis){
//            if(getX()==32*8.5f){
//                switch (ran){
//                    case 0 -> textureRegion = Utils.getRegion(17*16,16*16,16,32);
//                    case 1 -> textureRegion = Utils.getRegion(17*16,14*16,16,32);
//                    case 2 -> textureRegion = Utils.getRegion(21*16,14*16,16,32);
//                }
//                setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);
//            }
//        }
        moveBy(speedX, 0);
    }
}

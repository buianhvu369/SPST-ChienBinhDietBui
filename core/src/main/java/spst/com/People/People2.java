package spst.com.People;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class People2 extends MyActor {
    Animation<TextureRegion> animationLeft;
    Animation<TextureRegion> animationRight;
    Animation<TextureRegion> animationUp;
    Animation<TextureRegion> animationDown;
    int speed = 2;
    float time;
    float mouseX = -13314;
    float mouseY = -1321687;
    boolean takeWater = true;

    public People2(float x, float y, Stage s, boolean rightside) {
        super(x, y, s);
        setSize(32, 32);
        TextureRegion[] textureRegionLeft = {Utils.getRegion(16 * 23, 16 * 6, 16, 16), Utils.getRegion(16 * 23, 16 * 7, 16, 16), Utils.getRegion(16 * 23, 16 * 8, 16, 16)};
        TextureRegion[] textureRegionDown = {Utils.getRegion(16 * 24, 16 * 6, 16, 16), Utils.getRegion(16 * 24, 16 * 7, 16, 16), Utils.getRegion(16 * 24, 16 * 8, 16, 16)};
        TextureRegion[] textureRegionUp = {Utils.getRegion(16 * 25, 16 * 6, 16, 16), Utils.getRegion(16 * 25, 16 * 7, 16, 16), Utils.getRegion(16 * 25, 16 * 8, 16, 16)};
        TextureRegion[] textureRegionRight = {Utils.getRegion(16 * 26, 16 * 6, 16, 16), Utils.getRegion(16 * 26, 16 * 7, 16, 16), Utils.getRegion(16 * 26, 16 * 8, 16, 16)};
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
}

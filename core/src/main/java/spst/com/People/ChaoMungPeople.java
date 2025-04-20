package spst.com.People;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class ChaoMungPeople extends MyActor {
    TextureRegion[] textureRegionLeft;
    TextureRegion[] textureRegionDown;
    TextureRegion[] textureRegionUp;
    TextureRegion[] textureRegionRight;
    Animation<TextureRegion> animationLeft;
    Animation<TextureRegion> animationRight;
    Animation<TextureRegion> animationUp;
    Animation<TextureRegion> animationDown;
    float time;
    public ChaoMungPeople(float x, float y, Stage s) {
        super(x, y, s);
        int i = MathUtils.random.nextInt(1,6);
        switch (i){
            case 1 ->{
                textureRegionLeft = new TextureRegion[]{Utils.getRegion(16 * 23, 16 * 3, 16, 16), Utils.getRegion(16 * 23, 16 * 4, 16, 16), Utils.getRegion(16 * 23, 16 * 5, 16, 16)};
                textureRegionDown = new TextureRegion[]{Utils.getRegion(16 * 24, 16 * 3, 16, 16), Utils.getRegion(16 * 24, 16 * 4, 16, 16), Utils.getRegion(16 * 24, 16 * 5, 16, 16)};
                textureRegionUp = new TextureRegion[]{Utils.getRegion(16*25,16*3,16,16),Utils.getRegion(16*25,16*4,16,16),Utils.getRegion(16*25,16*5,16,16)};
                textureRegionRight = new TextureRegion[]{Utils.getRegion(16*26,16*3,16,16),Utils.getRegion(16*26,16*4,16,16),Utils.getRegion(16*26,16*5,16,16)};
            }
            case 2 ->{
                textureRegionLeft = new TextureRegion[]{Utils.getRegion(16 * 23, 16 * 6, 16, 16), Utils.getRegion(16 * 23, 16 * 7, 16, 16), Utils.getRegion(16 * 23, 16 * 8, 16, 16)};
                textureRegionDown = new TextureRegion[]{Utils.getRegion(16 * 24, 16 * 6, 16, 16), Utils.getRegion(16 * 24, 16 * 7, 16, 16), Utils.getRegion(16 * 24, 16 * 8, 16, 16)};
                textureRegionUp = new TextureRegion[]{Utils.getRegion(16 * 25, 16 * 6, 16, 16), Utils.getRegion(16 * 25, 16 * 7, 16, 16), Utils.getRegion(16 * 25, 16 * 8, 16, 16)};
                textureRegionRight = new TextureRegion[]{Utils.getRegion(16 * 26, 16 * 6, 16, 16), Utils.getRegion(16 * 26, 16 * 7, 16, 16), Utils.getRegion(16 * 26, 16 * 8, 16, 16)};
            }
            case 3 ->{
                textureRegionLeft = new TextureRegion[]{Utils.getRegion(16 * 23, 16 * 9, 16, 16), Utils.getRegion(16 * 23, 16 * 10, 16, 16), Utils.getRegion(16 * 23, 16 * 11, 16, 16)};
                textureRegionDown = new TextureRegion[]{Utils.getRegion(16 * 24, 16 * 9, 16, 16), Utils.getRegion(16 * 24, 16 * 10, 16, 16), Utils.getRegion(16 * 24, 16 * 11, 16, 16)};
                textureRegionUp = new TextureRegion[]{Utils.getRegion(16 * 25, 16 * 9, 16, 16), Utils.getRegion(16 * 25, 16 * 10, 16, 16), Utils.getRegion(16 * 25, 16 * 11, 16, 16)};
                textureRegionRight = new TextureRegion[] {Utils.getRegion(16 * 26, 16 * 9, 16, 16), Utils.getRegion(16 * 26, 16 * 10, 16, 16), Utils.getRegion(16 * 26, 16 * 11, 16, 16)};
            }
            case 4 ->{
                textureRegionLeft = new TextureRegion[]{Utils.getRegion(16 * 23, 16 * 12, 16, 16), Utils.getRegion(16 * 23, 16 * 13, 16, 16), Utils.getRegion(16 * 23, 16 * 14, 16, 16)};
                textureRegionDown = new TextureRegion[]{Utils.getRegion(16 * 24, 16 * 12, 16, 16), Utils.getRegion(16 * 24, 16 * 13, 16, 16), Utils.getRegion(16 * 24, 16 * 14, 16, 16)};
                textureRegionUp = new TextureRegion[]{Utils.getRegion(16 * 25, 16 * 12, 16, 16), Utils.getRegion(16 * 25, 16 * 13, 16, 16), Utils.getRegion(16 * 25, 16 * 14, 16, 16)};
                textureRegionRight = new TextureRegion[]{Utils.getRegion(16 * 26, 16 * 12, 16, 16), Utils.getRegion(16 * 26, 16 * 13, 16, 16), Utils.getRegion(16 * 26, 16 * 14, 16, 16)};
            }
            case 5 ->{
                textureRegionLeft = new TextureRegion[]{Utils.getRegion(16 * 23, 16 * 15, 16, 16), Utils.getRegion(16 * 23, 16 * 16, 16, 16), Utils.getRegion(16 * 23, 16 * 17, 16, 16)};
                textureRegionDown = new TextureRegion[]{Utils.getRegion(16 * 24, 16 * 15, 16, 16), Utils.getRegion(16 * 24, 16 * 16, 16, 16), Utils.getRegion(16 * 24, 16 * 17, 16, 16)};
                textureRegionUp = new TextureRegion[]{Utils.getRegion(16 * 25, 16 * 15, 16, 16), Utils.getRegion(16 * 25, 16 * 16, 16, 16), Utils.getRegion(16 * 25, 16 * 17, 16, 16)};
                textureRegionRight = new TextureRegion[]{Utils.getRegion(16 * 26, 16 * 15, 16, 16), Utils.getRegion(16 * 26, 16 * 16, 16, 16), Utils.getRegion(16 * 26, 16 * 17, 16, 16)};
            }
        }
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
        setSize(32,32);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        moveBy(1,0);
        time+=delta;
        textureRegion = animationRight.getKeyFrame(time);
    }
}

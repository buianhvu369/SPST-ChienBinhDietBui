package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Player extends MyActor{
    Animation<TextureRegion> animationLeft;
    Animation<TextureRegion> animationRight;
    Animation<TextureRegion> animationUp;
    Animation<TextureRegion> animationDown;
    int speed = 2;
    float time;
    Player(float x, float y, Stage s) {
        super(x, y, s);
        setSize(32,32);
        TextureRegion[] textureRegionLeft = {Utils.getRegion(16*23,0,16,16),Utils.getRegion(16*23,32,16,16),Utils.getRegion(16*23,16*2,16,16)};
        TextureRegion[] textureRegionDown = {Utils.getRegion(16*24,0,16,16),Utils.getRegion(16*24,32,16,16),Utils.getRegion(16*24,16*2,16,16)};
        TextureRegion[] textureRegionUp = {Utils.getRegion(16*25,0,16,16),Utils.getRegion(16*25,32,16,16),Utils.getRegion(16*25,16*2,16,16)};
        TextureRegion[] textureRegionRight = {Utils.getRegion(16*26,0,16,16),Utils.getRegion(16*26,32,16,16),Utils.getRegion(16*26,16*2,16,16)};
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

    @Override
    public void act(float delta) {
        super.act(delta);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveBy(-speed, 0);
            time += delta;
            textureRegion = animationLeft.getKeyFrame(time);
        }else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveBy(speed, 0);
            time += delta;
            textureRegion = animationRight.getKeyFrame(time);
        }else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            moveBy(0, speed);
            time += delta;
            textureRegion = animationUp.getKeyFrame(time);
        }else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            moveBy(0, -speed);
            time += delta;
            textureRegion = animationDown.getKeyFrame(time);
        }
    }
}

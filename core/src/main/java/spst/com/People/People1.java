package spst.com.People;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.AnimationClickMouse;
import spst.com.Master;
import spst.com.MyActor;
import spst.com.Roads.Tree;
import spst.com.Utils;

public class People1 extends MyActor {
    Animation<TextureRegion> animationLeft;
    Animation<TextureRegion> animationRight;
    Animation<TextureRegion> animationUp;
    Animation<TextureRegion> animationDown;
    int speed = 2;
    float time;
    float mouseX = -13314;
    float mouseY = -1321687;
    boolean takeWater = true;

    public People1(float x, float y, Stage s, boolean rightside) {
        super(x, y, s);
        setSize(32,32);
        TextureRegion[] textureRegionLeft = {Utils.getRegion(16*23,16*3,16,16),Utils.getRegion(16*23,16*4,16,16),Utils.getRegion(16*23,16*5,16,16)};
        TextureRegion[] textureRegionDown = {Utils.getRegion(16*24,16*3,16,16),Utils.getRegion(16*24,16*4,16,16),Utils.getRegion(16*24,16*5,16,16)};
        TextureRegion[] textureRegionUp = {Utils.getRegion(16*25,16*3,16,16),Utils.getRegion(16*25,16*4,16,16),Utils.getRegion(16*25,16*5,16,16)};
        TextureRegion[] textureRegionRight = {Utils.getRegion(16*26,16*3,16,16),Utils.getRegion(16*26,16*4,16,16),Utils.getRegion(16*26,16*5,16,16)};
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

   // @Override
   // public void act(float delta) {
       // super.act(delta);

        //if (takeWater) {
           // mouseX =Master.giengleft.getX() ;
            //mouseY = Master.giengleft.getY() ;
       // }
       // if (mouseX != -13314 && mouseY != -1321687){
        ///    if (Math.abs(getX()-mouseX) < Math.abs(getY()-mouseY)) {
     ///           if (!(getX() - 2 < mouseX && mouseX < getX() + 2)) {
   //                 if (mouseX < getX() + 2) {
 //                       if (!(32 * 16 <= getY() && getY() < 32 * 23 && getX() <= 32 * 9)) {
                         ///   moveBy(-speed, 0);
                      ///  }
                   ///     time += delta;
                ///        textureRegion = animationLeft.getKeyFrame(time);
             ///       } else if (mouseX > getX() - 2) {
          ///              moveBy(speed, 0);
        //                time += delta;
     ///                   textureRegion = animationRight.getKeyFrame(time);
   //                 }
 //               } else if (!(getY() - 2 < mouseY && mouseY < getY() + 2)) {
                  //  if (getY() - 2 < mouseY) {
                     //   if (!(0 <= getX() && getX() < 32 * 9 && getY() > 32 * 16 - 8 && getY() <= 800 - 32 * 4)) {
                          //  moveBy(0, speed);
                       /// }
                        ///time += delta;
                       // textureRegion = animationUp.getKeyFrame(time);
                  //  } else if (mouseY < getY() + 2) {
                        //if (!(0 <= getX() && getX() < 32 * 9 && getY() <= 800 - 32 * 2 && getY() >= 32 * 18)) {
                         //   moveBy(0, -speed);
                       // }
                      //  time += delta;
                       // textureRegion = animationDown.getKeyFrame(time);
                  //  }
              //  }
           // } else {
               // if (!(getY() - 2 < mouseY && mouseY < getY() + 2)) {
                    //if (getY() - 2 < mouseY) {
                       //if (!(0 <= getX() && getX() < 32 * 9 && getY() > 32 * 16 - 8 && getY() <= 800 - 32 * 4)) {
                      //     moveBy(0, speed);
                      // }
                       // time += delta;
                        ///textureRegion = animationUp.getKeyFrame(time);
                    ///} else if (mouseY < getY() + 2) {
                       /// if (!(0 <= getX() && getX() < 32 * 9 && getY() <= 800 - 32 * 2 && getY() >= 32 * 18)) {
                        ///    moveBy(0, -speed);
                        ///}
                        //time += delta;
                        ///textureRegion = animationDown.getKeyFrame(time);
                   // }
                //} else if (!(getX() - 2 < mouseX && mouseX < getX() + 2)) {
                  ///  if (mouseX < getX() + 2) {
                       // if (!(32 * 16 <= getY() && getY() < 32 * 23 && getX() <= 32 * 9)) {
                        //    moveBy(-speed, 0);
                        //}
                        //time += delta;
                        //textureRegion = animationLeft.getKeyFrame(time);
                   // } else if (mouseX > getX() - 2) {
                        //moveBy(speed, 0);
                      ///  time += delta;
                      //  textureRegion = animationRight.getKeyFrame(time);
                    //}
                //}
            //}
        //}
   // }
}

package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Roads.Tree;
import spst.com.Screen.Master;

public class LoadingPlant extends MyActor{
    Animation<TextureRegion> animation;
    float time = 0;
    public LoadingPlant(float x, float y, Stage s) {
        super(x, y, s);
        Texture tex = new Texture("loading.png");
        float width = tex.getWidth()/8;
        setSize(32,32);

        TextureRegion[][] t = TextureRegion.split(tex, tex.getWidth()/8, tex.getHeight());

        TextureRegion[] frames = new TextureRegion[8];
        int index = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 8; j++) {
                frames[index++] = t[i][j];
            }
        }

        animation = new Animation<>(0.05f, frames);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        textureRegion = animation.getKeyFrame(time);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
        textureRegion = animation.getKeyFrame(time);
        toFront();
        if(time > 2){
            Tree a = new Tree(getX() , getY(), getStage());
            a.toFront();
            Master.trees.add(a);
            remove();
        }
    }
}

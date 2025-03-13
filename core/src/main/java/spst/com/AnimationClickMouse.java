package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class IsClickMouse extends MyActor{
    Animation<TextureRegion> animation;
    float time;
    public IsClickMouse(float x, float y, Stage s) {
        super(x, y, s);
        Texture texture = new Texture("cursor.png");
        int cot = 10;
        int hang = 6;
        setSize((float)texture.getWidth()/cot, (float)texture.getHeight()/hang);
        float speed = 0.02f;
        TextureRegion[][] tam = TextureRegion.split(texture, texture.getWidth()/cot, texture.getHeight()/hang);// đưa tất cả vào danh một danh sách ảnh, vì 6 cột 1 hàng nên sẽ có 6 phần tử: 6 x 1
        TextureRegion[] frames = new TextureRegion[cot*hang];
        int index = 0;
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                frames[index++] = tam[i][j];
            }
        }
        animation = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(speed, frames);
        animation.setPlayMode(Animation.PlayMode.NORMAL);
        time = 0;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
        if(animation.isAnimationFinished(time)){
            remove();
        }
    }
}

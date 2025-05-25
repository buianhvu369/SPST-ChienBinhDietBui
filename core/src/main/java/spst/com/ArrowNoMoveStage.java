package spst.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ArrowNoMoveStage extends MyActor{
    int i = -60;
    int bodem = 60;
    public ArrowNoMoveStage(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("arrow.png"));
        setSize(60,60);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(getRotation() != -90) {
            moveBy(0, (float) 20 / i);
            bodem--;
            if (bodem == 0) {
                i = -i;
                bodem = 60;
            }
        }else {
            moveBy((float)20/i, 0);
            bodem--;
            if (bodem == 0) {
                i = -i;
                bodem = 60;
            }
        }
    }
}

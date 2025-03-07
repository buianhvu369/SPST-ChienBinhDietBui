package Game.com;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Tree extends MyActor{
    Tree(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(16*16, 8*16, 16, 32);
        setSize(textureRegion.getRegionWidth()*2, textureRegion.getRegionHeight()*2);
    }
}

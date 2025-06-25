package spst.com.MiniGame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class Trash extends MyActor {
    Texture trash = new Texture("waste.png");
    public Trash(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(trash);
        setSize(64, 64);
    }
}

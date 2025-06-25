package spst.com.Button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.FloatingNews;
import spst.com.GameState;
import spst.com.MyActor;
import spst.com.Screen.Master;

public class SeeTheFuture extends MyActor {
    public SeeTheFuture(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("futurebutton.png"));
        setSize(40,40);
    }
}

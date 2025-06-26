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
import spst.com.TypeEffect;

public class SaveNut extends MyActor {
    public SaveNut(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("save.png"));
        setSize(48,48);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                GameState.saveGame();
                new FloatingNews(Gdx.graphics.getWidth()-120,500,Master.noMoveStage,"Save game", Color.BLACK, TypeEffect.FLOATUP).toFront();
            }
        });

    }
}

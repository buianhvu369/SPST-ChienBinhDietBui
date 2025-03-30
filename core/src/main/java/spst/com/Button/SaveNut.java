package spst.com.Button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import spst.com.*;
import spst.com.Screen.Master;

public class SaveNut extends MyActor {
    public SaveNut(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("save.png"));
        setSize(48,48);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
               // GameState.saveGame();
                Array<Integer> its = new Array<>();
                its.add(6);
                its.add(8);
                Utils.saveGameData(new GameStateTmp(1, 2, 3, its));
                new FloatingNews(Gdx.graphics.getWidth()-120,500,Master.noMoveStage,"Save game", Color.BLACK).toFront();
            }
        });

    }
}

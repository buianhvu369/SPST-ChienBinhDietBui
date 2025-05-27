package spst.com.Button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.MyActor;

public class DailyQuest extends MyActor {
    public DailyQuest(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(new Texture("dailyquest.png"));
        setSize(40, 40);

    }
}

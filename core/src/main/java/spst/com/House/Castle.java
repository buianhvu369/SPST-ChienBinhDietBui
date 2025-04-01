package spst.com.House;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;
import spst.com.town.partofCastle;

public class Castle extends MyActor {
    boolean isDraw = false;
    public Castle(float x, float y, Stage s) {
        super(x, y, s);
        setSize(32*5, 32*5);
        Master.noPlaced.add(this.getBound());
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        float x = getX();
        float y = getY();
        if(!isDraw) {
            isDraw = true;
            new partofCastle(x, y, getStage(), 5);
            x += 32;
            new partofCastle(x, y, getStage(), 5);
            x += 32;
            new partofCastle(x, y, getStage(), 6);
            x += 32 * 2;
            new partofCastle(x, y, getStage(), 5);
            x += 32;
            new partofCastle(x, y, getStage(), 5);
            x -= 32 * 5;
            y += 32;
            new partofCastle(x, y, getStage(), 5);
            x += 32;
            new partofCastle(x, y, getStage(), 5);
            x += 32 * 3;
            new partofCastle(x, y, getStage(), 5);
            x += 32;
            new partofCastle(x, y, getStage(), 5);
            x -= 32 * 5;
            y += 32;
            new partofCastle(x, y, getStage(), 2);
            x += 32;
            new partofCastle(x, y, getStage(), 5);
            x += 32;
            new partofCastle(x, y, getStage(), 5);
            x += 32;
            new partofCastle(x, y, getStage(), 5);
            x += 32;
            new partofCastle(x, y, getStage(), 5);
            x += 32;
            new partofCastle(x, y, getStage(), 4);
            x -= 32 * 5;
            y += 32;
            new partofCastle(x, y, getStage(), 1);
            x += 32;
            new partofCastle(x, y, getStage(), 5);
            x += 32;
            new partofCastle(x, y, getStage(), 9);
            x += 32;
            new partofCastle(x, y, getStage(), 9);
            x += 32;
            new partofCastle(x, y, getStage(), 5);
            x += 32;
            new partofCastle(x, y, getStage(), 3);
            x -= 32 * 4;
            y += 32;
            new partofCastle(x, y, getStage(), 5);
            x += 32;
            new partofCastle(x, y, getStage(), 8);
            x += 32;
            new partofCastle(x, y, getStage(), 8);
            x += 32;
            new partofCastle(x, y, getStage(), 5);
            y += 32;
            new partofCastle(x, y, getStage(), 5);
            x -= 32 * 3;
            new partofCastle(x, y, getStage(), 5);
            x += 32 * 3;
            y += 32;
            new partofCastle(x, y, getStage(), 7);
            x -= 32 * 3;
            new partofCastle(x, y, getStage(), 7);
        }
    }
}

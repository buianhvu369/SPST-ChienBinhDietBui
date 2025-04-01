package spst.com.House;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.town.*;

public class House1 extends MyActor {
    boolean isBlue;
    boolean isDraw = false;
    public House1(float x, float y, Stage s, boolean isBlue1) {
        super(x, y, s);
        isBlue = isBlue1;
        setSize(32*3, 32*3);
        Master.noPlaced.add(this.getBound());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        float x =getX();
        float y = getY();
        if(!isDraw) {
            isDraw = true;
            if (isBlue) {
                new Wall(x, y, getStage(), true);
                x += 32;
                new WindowHouse(x, y, getStage(), true);
                x += 32;
                new DoorHouse(x, y, getStage(), true);
                x += 32;
                ;
                new Wall(x, y, getStage(), true);
                x -= 32 * 3;
                y += 32;
                for (int i = 0; i < 4; i++) {
                    new RoofHouse(x, y, getStage(), true);
                    x += 32;
                }
                x -= 32 * 2;
                new SpecialRoof(x, y, getStage(), true);
                x -= 32;
                y += 32;
                new Chimney(x, y, getStage(), true);
            } else {
                new Wall(x, y, getStage(), false);
                x += 32;
                new WindowHouse(x, y, getStage(), false);
                x += 32;
                new DoorHouse(x, y, getStage(), false);
                x += 32;
                ;
                new Wall(x, y, getStage(), false);
                x -= 32 * 3;
                y += 32;
                for (int i = 0; i < 4; i++) {
                    new RoofHouse(x, y, getStage(), false);
                    x += 32;
                }
                x -= 32 * 2;
                new SpecialRoof(x, y, getStage(), false);
                x -= 32;
                y += 32;
                new Chimney(x, y, getStage(), false);
            }
        }
    }
}

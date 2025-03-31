package spst.com.House;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.town.DoorHouse;
import spst.com.town.RoofHouse;
import spst.com.town.Wall;
import spst.com.town.WindowHouse;

public class House3 extends MyActor {
    boolean isBlue;
    public House3(float x, float y, Stage s, boolean isBlue1) {
        super(x, y, s);
        isBlue = isBlue1;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        float x = getX();
        float y = getY();
        if(isBlue){
            new Wall(x, y, getStage(), true);
            x += 32;
            new DoorHouse(x, y,getStage(), true);
            x += 32;
            new Wall(x, y,getStage(), true);
            x -= 32 * 2;
            y += 32;
            new Wall(x, y,getStage(), true);
            x += 32;
            new WindowHouse(x, y,getStage(), true);
            x += 32;
            new Wall(x, y, getStage(), true);
            x -= 32 * 2;
            y += 32;
            for (int i = 0; i < 3; i++) {
                new RoofHouse(x, y,getStage(), true);
                x += 32;
            }
        }else {
            new Wall(x, y, getStage(), false);
            x += 32;
            new DoorHouse(x, y,getStage(), false);
            x += 32;
            new Wall(x, y,getStage(), false);
            x -= 32 * 2;
            y += 32;
            new Wall(x, y,getStage(), false);
            x += 32;
            new WindowHouse(x, y,getStage(), false);
            x += 32;
            new Wall(x, y, getStage(), false);
            x -= 32 * 2;
            y += 32;
            for (int i = 0; i < 3; i++) {
                new RoofHouse(x, y,getStage(), false);
                x += 32;
            }
        }
    }
}

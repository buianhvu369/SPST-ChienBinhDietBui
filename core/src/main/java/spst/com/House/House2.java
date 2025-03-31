package spst.com.House;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.town.DoorHouse;
import spst.com.town.RoofHouse;
import spst.com.town.SpecialRoof;
import spst.com.town.Wall;

public class House2 extends MyActor {
    boolean isBlue;
    public House2(float x, float y, Stage s, boolean isBlue1) {
        super(x, y, s);
        isBlue = isBlue1;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if(isBlue){
            float x = getX();
            float y = getY();
            new Wall(x, y, getStage(), true);
            x += 32;
            new DoorHouse(x, y, getStage(), true);
            x += 32;
            new Wall(x, y, getStage(), true);
            x -= 32 * 2;
            y += 32;
            for (int i = 0; i < 3; i++) {
                new RoofHouse(x, y,getStage(), true);
                x += 32;
            }
            x -= 32 * 2;
            new SpecialRoof(x, y,getStage(), true);
        }else{
            float x = getX();
            float y = getY();
            new Wall(x, y, getStage(), false);
            x += 32;
            new DoorHouse(x, y, getStage(), false);
            x += 32;
            new Wall(x, y, getStage(), false);
            x -= 32 * 2;
            y += 32;
            for (int i = 0; i < 3; i++) {
                new RoofHouse(x, y,getStage(), false);
                x += 32;
            }
            x -= 32 * 2;
            new SpecialRoof(x, y,getStage(), false);
        }
    }
}

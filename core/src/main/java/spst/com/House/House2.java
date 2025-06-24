package spst.com.House;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.town.DoorHouse;
import spst.com.town.RoofHouse;
import spst.com.town.SpecialRoof;
import spst.com.town.Wall;

public class House2 extends MyActor {
    boolean isBlue;
    boolean isDraw = false;
    public static Array<MyActor> pieces = new Array<>();
    public House2(float x, float y, Stage s, boolean isBlue1) {
        super(x, y, s);
        isBlue = isBlue1;
        setSize(32*4, 32*3);
        Master.noPlaced.add(this.getBound());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if(!isDraw) {
            isDraw = true;
            if (isBlue) {
                float x = getX();
                float y = getY();
                pieces.add(new Wall(x, y, getStage(), true));
                x += 32;
                pieces.add(new DoorHouse(x, y, getStage(), true));
                x += 32;
                pieces.add(new Wall(x, y, getStage(), true));
                x -= 32 * 2;
                y += 32;
                for (int i = 0; i < 3; i++) {
                    pieces.add(new RoofHouse(x, y, getStage(), true));
                    x += 32;
                }
                x -= 32 * 2;
                pieces.add(new SpecialRoof(x, y, getStage(), true));
            } else {
                float x = getX();
                float y = getY();
                pieces.add(new Wall(x, y, getStage(), false));
                x += 32;
                pieces.add(new DoorHouse(x, y, getStage(), false));
                x += 32;
                pieces.add(new Wall(x, y, getStage(), false));
                x -= 32 * 2;
                y += 32;
                for (int i = 0; i < 3; i++) {
                    pieces.add(new RoofHouse(x, y, getStage(), false));
                    x += 32;
                }
                x -= 32 * 2;
                pieces.add(new SpecialRoof(x, y, getStage(), false));
            }
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        for(MyActor p : pieces){
            p.setZIndex(getZIndex());
        }
    }
}

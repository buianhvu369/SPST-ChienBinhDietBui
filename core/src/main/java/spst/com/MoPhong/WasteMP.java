package spst.com.MoPhong;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class WasteMP extends MyActorMP {
    public char cos;
    public WasteMP(){}
    public WasteMP(float x, float y, char value) {
        super(x, y);
        cos = value;
    }
}

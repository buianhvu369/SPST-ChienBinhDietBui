package spst.com.MoPhong;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class NormalCameraMP extends MyActorMP {
    public String name;
    public NormalCameraMP(float x, float y,String name) {
        super(x, y);
        this.name = name;
    }
}

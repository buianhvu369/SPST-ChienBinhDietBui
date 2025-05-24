package spst.com.MoPhong;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class MLMP extends MyActorMP {
    public String name;
    public int level;

    public MLMP(){}
    public MLMP(float x, float y,String name) {
        super(x, y);
        this.name = name;
    }
}

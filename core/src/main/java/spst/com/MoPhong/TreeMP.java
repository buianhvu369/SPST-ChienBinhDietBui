package spst.com.MoPhong;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Roads.TypeTree;

public class TreeMP extends MyActorMP {
    public TypeTree type;
    public TreeMP(){}
    public TreeMP(float x, float y, TypeTree value) {
        super(x, y);
        type = value;
    }
}

package spst.com.MoPhong;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class SignMP extends MyActorMP {
    public boolean myIsCamDotRac;

    public SignMP(float x, float y,boolean isCamDotRac) {
        super(x, y);
        myIsCamDotRac = isCamDotRac;
    }
}

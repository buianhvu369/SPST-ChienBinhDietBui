package spst.com.InFactory;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Enums.TypeViaHe;
import spst.com.MyActor;
import spst.com.Utils;

public class BuyViaHe extends MyActor {
    TypeViaHe type = TypeViaHe.Tam;
    public BuyViaHe(float x, float y, Stage s) {
        super(x, y, s);
        setPosition(x-16,y-16);
        switch (type){
            case Canh -> textureRegion = Utils.getRegion(16*8,16,16,16);
            case Tam -> textureRegion = Utils.getRegion(16*9,16,16,16);
            case Goc -> textureRegion = Utils.getRegion(16*8,16*2,16,16);
        }
        setSize(32,32);
    }
}

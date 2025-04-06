package spst.com.MoPhong;

import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Enums.TypeRoadRe;
import spst.com.Enums.TypeVL;
import spst.com.MyActor;

public class TaiNguyenMP extends MyActorMP {
    public TypeVL typeVL;
    public char directionRoad;
    public TypeRoadRe typeRoadRe;
    public char directionRoadRe;
    public int rotationRoadReNgoai;
    public TaiNguyenMP(){}
    public TaiNguyenMP(float x, float y, TypeVL typeVL) {
        super(x, y);
        this.typeVL = typeVL;
    }
}

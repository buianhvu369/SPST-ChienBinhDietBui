package spst.com.Button;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import spst.com.Enums.TypeVL;
import spst.com.GameState;
import spst.com.MyActor;
import spst.com.Screen.Master;

public class creatVatLieuMoRongMap extends MyActor {
    public boolean isSong = false;
    public Texture texture = new Texture("noVLLD.png");
    public Texture texture1 = new Texture("yesVLLD.png");
    public int soVL;
    public TypeVL type = TypeVL.Dat;
    public creatVatLieuMoRongMap(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(texture);
        setSize(40,40);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(!Master.whatActionIfClickMouse.equals("DatSan")) {
                    Master.whatActionIfClickMouse = "DatSan";
                    textureRegion = new TextureRegion(texture1);
                }else{
                    Master.whatActionIfClickMouse = "move";
                    textureRegion = new TextureRegion(texture);
                }
                if(soVL < 1){
                    textureRegion = new TextureRegion(texture);
                    Master.whatActionIfClickMouse = "move";
                }
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isSong){
            isSong = false;
            textureRegion = new TextureRegion(texture);
        }
        switch (type){
            case Dat -> soVL = GameState.soDat;
            case NgaRe -> soVL = GameState.soReRoad;
            case ViaHe -> soVL = GameState.soViaHe;
            case VongCung -> soVL = GameState.soVongCungNgoai;
            case DuongThang -> soVL = GameState.soRoad;
            case DuongTrong -> soVL = GameState.soBlankRoad;
        }
    }
    public void thayVLL(){
        switch (type){
            case VongCung -> type = TypeVL.DuongTrong;
            case ViaHe -> type = TypeVL.VongCung;
            case NgaRe -> type = TypeVL.ViaHe;
            case Dat -> type = TypeVL.NgaRe;
            case DuongThang -> type = TypeVL.Dat;
            case DuongTrong -> type = TypeVL.DuongThang;
        }
    }
    public void thayVLR(){
        switch (type){
            case VongCung -> type = TypeVL.ViaHe;
            case ViaHe -> type = TypeVL.NgaRe;
            case NgaRe -> type = TypeVL.Dat;
            case Dat -> type = TypeVL.DuongThang;
            case DuongThang -> type = TypeVL.DuongTrong;
            case DuongTrong -> type = TypeVL.VongCung;
        }
    }
}

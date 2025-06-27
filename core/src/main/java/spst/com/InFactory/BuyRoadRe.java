package spst.com.InFactory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Enums.TypeRoadRe;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;

public class BuyRoadRe extends MyActor {
    TextureRegion textureRegionGocTraiLen;
    TextureRegion textureRegionGocPhaiLen;
    TextureRegion textureRegionGocTraiDuoi;
    TextureRegion textureRegionGocPhaiDuoi;
    TextureRegion textureRegionBlank;
    TextureRegion textureRegionGachTrai;
    TextureRegion textureRegionGachPhai;
    TextureRegion textureRegionGachLen;
    TextureRegion textureRegionGachDuoi;

    public TypeRoadRe type = TypeRoadRe.Trai;
    public char direc = 'd';
    public BuyRoadRe(float x, float y, Stage s) {
        super(x, y, s);
        textureRegionGocTraiLen = Utils.getRegion(16*8,16*16,16,16);
        textureRegionGocPhaiLen = Utils.getRegion(16*7,16*16,16,16);
        textureRegionGocTraiDuoi = Utils.getRegion(16*8,16*17,16,16);
        textureRegionGocPhaiDuoi = Utils.getRegion(16*7,16*17,16,16);
        textureRegionBlank = Utils.getRegion(16*9,16*16,16,16);
        textureRegionGachTrai = Utils.getRegion(16*2,16*17,16,16);
        textureRegionGachPhai = Utils.getRegion(16*4,16*17,16,16);
        textureRegionGachLen = Utils.getRegion(16*1,16*15,16,16);
        textureRegionGachDuoi = Utils.getRegion(16*1,16*17,16,16);
        Master.roadArray.add(getBound());
        Master.reArray.add(this);
        Master.roads.add(this);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        switch (direc){
            case 'u' -> setSize(32*3,32*1);
            case 'r' -> setSize(32,32*3);
            case 'l' -> setSize(32,32*3);
            case 'd' -> setSize(32*3,32*1);
        }
        switch (type){
            case Phai -> {
                switch (direc){
                    case 'u'->{
                        batch.draw(textureRegionGachTrai, getX(), getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionBlank, getX()+32, getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionGocPhaiLen, getX()+32*2, getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        setScaleX(1);
                        setScaleY(1);
                    }
                    case 'r'->{
                        batch.draw(textureRegionGachLen, getX(), getY()+32*2, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionBlank, getX(), getY()+32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionGocTraiLen, getX(), getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        setScaleX(1);
                        setScaleY(1);
                    }
                    case 'd'->{
                        batch.draw(textureRegionGocTraiLen, getX(), getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionBlank, getX()+32, getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionGachPhai, getX()+32*2, getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        setScaleX(1);
                        setScaleY(-1);
                    }
                    case 'l'->{
                        batch.draw(textureRegionGocPhaiDuoi, getX(), getY()+32*2, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionBlank, getX(), getY()+32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionGachDuoi, getX(), getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        setScaleX(1);
                        setScaleY(1);
                    }
                }
            }
            case Trai -> {
                switch (direc){
                    case 'u'->{
                        batch.draw(textureRegionGocTraiLen, getX(), getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionBlank, getX()+32, getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionGachPhai, getX()+32*2, getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        setScaleX(1);
                        setScaleY(1);
                    }
                    case 'd'->{
                        batch.draw(textureRegionGachTrai, getX(), getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionBlank, getX()+32, getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionGocPhaiLen, getX()+32*2, getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        setScaleX(1);
                        setScaleY(-1);
                    }
                    case 'l'->{
                        batch.draw(textureRegionGachLen, getX(), getY()+32*2, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionBlank, getX(), getY()+32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionGocTraiLen, getX(), getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        setScaleX(-1);
                        setScaleY(1);
                    }
                    case 'r'->{
                        batch.draw(textureRegionGocTraiDuoi, getX(), getY()+32*2, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionBlank, getX(), getY()+32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionGachDuoi, getX(), getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        setScaleX(1);
                        setScaleY(1);
                    }
                }
            }
            case CaHai -> {
                switch (direc){
                    case 'u'->{
                        batch.draw(textureRegionGocTraiLen, getX(), getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionBlank, getX()+32, getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionGocPhaiLen, getX()+32*2, getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        setScaleX(1);
                        setScaleY(1);
                    }
                    case 'd'->{
                        batch.draw(textureRegionGocTraiLen, getX(), getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionBlank, getX()+32, getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionGocPhaiLen, getX()+32*2, getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        setScaleX(1);
                        setScaleY(-1);
                    }
                    case 'l'->{
                        batch.draw(textureRegionGocTraiDuoi, getX(), getY()+32*2, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionBlank, getX(), getY()+32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionGocTraiLen, getX(), getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        setScaleX(-1);
                        setScaleY(1);
                    }
                    case 'r'->{
                        batch.draw(textureRegionGocTraiDuoi, getX(), getY()+32*2, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionBlank, getX(), getY()+32, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        batch.draw(textureRegionGocTraiLen, getX(), getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
                        setScaleX(1);
                        setScaleY(1);
                    }
                }
            }
        }
    }
}

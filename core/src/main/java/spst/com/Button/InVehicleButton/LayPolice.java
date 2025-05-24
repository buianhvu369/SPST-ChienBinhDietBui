package spst.com.Button.InVehicleButton;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;

public class LayPolice extends MyActor {
    public boolean isSong = false;
    private boolean isSelect=false;
    public Texture texture = new Texture("noPolice.png");
    public Texture texture1 = new Texture("yesPolice.png");
    public LayPolice(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(texture);
        setSize(40,40);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isSong){
            isSong = false;
            textureRegion = new TextureRegion(texture);
        }
    }
    public boolean getIsSelect(){return isSelect;}
    public void setIsSelect(boolean value){isSelect = value;}
}

package spst.com.House;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.MyActor;
import spst.com.Utils;

public class TrashCenter extends MyActor {
    TextureRegion traimai = new TextureRegion(Utils.getRegion(16*0,16*3,16,16*3));
    TextureRegion giuamai = new TextureRegion(Utils.getRegion(16*1,16*3,16,16*3));
    TextureRegion phaimai = new TextureRegion(Utils.getRegion(16*2,16*3,16,16*3));
    TextureRegion traimaibe = new TextureRegion(Utils.getRegion(16*4,16*12,16,16));
    TextureRegion giuamaibe = new TextureRegion(Utils.getRegion(16*5,16*12,16,16));
    TextureRegion phaimaibe = new TextureRegion(Utils.getRegion(16*6,16*12,16,16));
    TextureRegion cotdo = new TextureRegion(Utils.getRegion(16*16,16*0,16,16*4));
    TextureRegion trainha = new TextureRegion(Utils.getRegion(16*17,16*0,16*1,16*4));
    TextureRegion giuanha = new TextureRegion(Utils.getRegion(16*18,16*0,16*1,16*4));
    TextureRegion phainha = new TextureRegion(Utils.getRegion(16*19,16*0,16*1,16*4));
    TextureRegion thungrac = new TextureRegion(Utils.getRegion(16*10,16*9,16*1,16*1));
    TextureRegion textureRegionWindow = Utils.getRegion(11*16, 15*16, 16, 16);
    TextureRegion textureRegionWindowBig = Utils.getRegion(11*16, 16*16, 16, 2*16);
    public TrashCenter(float x, float y, Stage s) {
        super(x, y, s);
        setSize(32*6,32*7);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(cotdo, getX(), getY(), 32, 32*4);
        batch.draw(trainha, getX()+32, getY(), 32, 32*4);
        batch.draw(giuanha, getX()+32*2, getY(), 32, 32*4);
        batch.draw(giuanha, getX()+32*3, getY(), 32, 32*4);
        batch.draw(phainha, getX()+32*4, getY(), 32, 32*4);
        batch.draw(traimai, getX(), getY()+32*4, 32, 32*3);
        batch.draw(giuamai, getX()+32*1, getY()+32*4, 32, 32*3);
        batch.draw(giuamai, getX()+32*2, getY()+32*4, 32, 32*3);
        batch.draw(giuamai, getX()+32*3, getY()+32*4, 32, 32*3);
        batch.draw(giuamai, getX()+32*4, getY()+32*4, 32, 32*3);
        batch.draw(phaimai, getX()+32*5, getY()+32*4, 32, 32*3);
        batch.draw(cotdo, getX()+32*5, getY(), 32, 32*4);
        batch.draw(traimaibe, getX(), getY()+32*1.75f, 32, 32);
        batch.draw(giuamaibe, getX()+32*1, getY()+32*1.75f, 32, 32);
        batch.draw(giuamaibe, getX()+32*2, getY()+32*1.75f, 32, 32);
        batch.draw(giuamaibe, getX()+32*3, getY()+32*1.75f, 32, 32);
        batch.draw(giuamaibe, getX()+32*4, getY()+32*1.75f, 32, 32);
        batch.draw(phaimaibe, getX()+32*5, getY()+32*1.75f, 32, 32);
        batch.draw(thungrac, getX()+32*0.5f, getY()+32*6, 32, 32);
        batch.draw(thungrac, getX()+32*2.5f, getY()+32*6, 32, 32);
        batch.draw(thungrac, getX()+32*4.5f, getY()+32*6, 32, 32);
        batch.draw(thungrac, getX()+32*0.5f, getY()+32*4.5f, 32, 32);
        batch.draw(thungrac, getX()+32*2.5f, getY()+32*4.5f, 32, 32);
        batch.draw(thungrac, getX()+32*4.5f, getY()+32*4.5f, 32, 32);
        batch.draw(textureRegionWindow, getX() , getY() + 30, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegionWindow, getX() , getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegionWindow, getX() + 32*5 , getY() + 30, getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegionWindow, getX() + 32*5, getY(), getOriginX(), getOriginY(), 32, 32, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegionWindowBig, getX() + 32*1.5f, getY() + 50+32, getOriginX(), getOriginY(), 32, 40, getScaleX(), getScaleY(), getRotation());
        batch.draw(textureRegionWindowBig, getX() + 32*3.5f, getY() + 50+32, getOriginX(), getOriginY(), 32, 40, getScaleX(), getScaleY(), getRotation());
    }
}

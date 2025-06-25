package spst.com.MiniGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BackGround extends Actor {
    TextureRegion textureRegion;
    float scaleX = 1f;
    float scaleY = 1f;
    Polygon polygon;
    BackGround(float x, float y , Stage s){
        this.textureRegion = new TextureRegion(new Texture("water-border.jpg")) ;
       setPosition(x,y);
        setSize(Gdx.graphics.getWidth()*1.5f, Gdx.graphics.getHeight()*1.5f);
        s.addActor(this);
        setOrigin(getHeight()/2,getWidth()/2);


    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureRegion, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), scaleX, scaleY, getRotation());
    }
    @Override
    public void act(float delta) {

    }
}

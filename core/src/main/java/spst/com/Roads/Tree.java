package spst.com.Roads;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.GameState;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Utils;

public class Tree extends MyActor {
    public boolean isCutDown = false;
    int time = 0;
    public TypeTree type = TypeTree.Classic;
    public Tree(float x, float y, Stage s) {
        super(x, y, s);
        if(1180 < getX() && getX() < 1180 + 4*32-32){
            type=TypeTree.Water;
        }else if(MathUtils.random.nextInt(1,26)==10){
            type=TypeTree.Super;
        }else {
            type = TypeTree.Classic;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Q)){
            type = TypeTree.Super;
        }
        if(type == TypeTree.Super){
            textureRegion = new TextureRegion(new Texture("supertree.png"));
            setSize(64, 64);
        }else if(type == TypeTree.Water){
            textureRegion = new TextureRegion(new Texture("watertree.png"));
            setSize(32, 32);
        }else {
            textureRegion = Utils.getRegion(16 * 16, 8 * 16, 16, 32);
            setSize(textureRegion.getRegionWidth() * 2, textureRegion.getRegionHeight() * 2);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time ++;
        if(time ==30){
            GameState.money--;
        }
        if(type == TypeTree.Super){
            if (GameState.PM10 >= 0.009f*15 / 60f) {
                GameState.PM10 -= 0.009f*15 / 60f;
            }
            if (GameState.PM2_5 >= 0.02f*15 / 60f) {
                GameState.PM2_5 -= 0.02f*15 / 60f;
            }
            if (GameState.CO1 >= 0.09f*15 / 60f) {
                GameState.CO1 -= 0.09f*15 / 60f;
            }
            if (GameState.O3 >= 0.098f*15 / 60f) {
                GameState.O3 -= 0.098f*15 / 60f;
            }
        }else if(type == TypeTree.Water){
            if (GameState.PM10 >= 0.009f/2f / 60f) {
                GameState.PM10 -= 0.009f/2f / 60f;
            }
            if (GameState.PM2_5 >= 0.02f/2f / 60f) {
                GameState.PM2_5 -= 0.02f/2f / 60f;
            }
            if (GameState.CO1 >= 0.09f/2f / 60f) {
                GameState.CO1 -= 0.09f/2f / 60f;
            }
            if (GameState.O3 >= 0.098f/2f / 60f) {
                GameState.O3 -= 0.098f/2f / 60f;
            }
        }else{
            if(GameState.money >= 1) {
                if (GameState.PM10 >= 0.009f / 60f) {
                    GameState.PM10 -= 0.009f / 60f;
                }
                if (GameState.PM2_5 >= 0.02f / 60f) {
                    GameState.PM2_5 -= 0.02f / 60f;
                }
                if (GameState.CO1 >= 0.09f / 60f) {
                    GameState.CO1 -= 0.09f / 60f;
                }
                if (GameState.O3 >= 0.098f / 60f) {
                    GameState.O3 -= 0.098f / 60f;
                }
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(isCutDown){
            if(type == TypeTree.Super){
                TextureRegion root = new TextureRegion(new Texture("supertree.png"), 0, 32, 64, 32);
                batch.draw(root, getX(), getY(), getOriginX(), getOriginY(), getWidth(), 32, getScaleX(), getScaleY(), getRotation());
                TextureRegion branch = new TextureRegion(new Texture("supertree.png"), 0, 0, 64, 32);
                batch.draw(branch, getX() + 32, getY() + 32, getOriginX(), getOriginY(), getWidth(), 32, getScaleX(), getScaleY(), getRotation() - 135);
            }else if(type == TypeTree.Water){
                //nguoi dan ko chat cay duoi nuoc
            }else {
                TextureRegion root = Utils.getRegion(16 * 16, 9 * 16, 16, 16);
                batch.draw(root, getX(), getY(), getOriginX(), getOriginY(), getWidth(), 32, getScaleX(), getScaleY(), getRotation());
                TextureRegion branch = Utils.getRegion(16 * 16, 8 * 16, 16, 16);
                batch.draw(branch, getX() + 16, getY() + 32, getOriginX(), getOriginY(), getWidth(), 32, getScaleX(), getScaleY(), getRotation() - 135);
            }
        } else {
            super.draw(batch, parentAlpha);
        }
    }
}

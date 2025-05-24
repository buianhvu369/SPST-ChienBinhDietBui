package spst.com;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import spst.com.Screen.Master;

public class Waste extends MyActor {
    private boolean isFire;
    private char costume;
    private char sophan;
    private boolean isTrongDS=false;
    public Waste(float x, float y, Stage s, char cos) {
        super(x, y, s);
        int random = MathUtils.random.nextInt(1,101);
        if(random<=40){
            textureRegion = new TextureRegion(new Texture("organic waste.png"));
            costume = 'o';
        } else if (random<=70) {
            textureRegion = new TextureRegion(new Texture("inorganic waste.png"));
            costume = 'i';
        } else if (random<=97) {
            textureRegion = new TextureRegion(new Texture("recycled trash.png"));
            costume = 'r';
        } else if (random<=100) {
            textureRegion = new TextureRegion(new Texture("hazardous waste.png"));
            costume = 'h';
        }
        switch (cos){
            case 'o' -> {
                textureRegion = new TextureRegion(new Texture("organic waste.png"));
                costume = 'o';
            }
            case 'i' -> {
                textureRegion = new TextureRegion(new Texture("inorganic waste.png"));
                costume = 'i';
            }
            case 'r' -> {
                textureRegion = new TextureRegion(new Texture("recycled trash.png"));
                costume = 'r';
            }
            case 'h' -> {
                textureRegion = new TextureRegion(new Texture("hazardous waste.png"));
                costume = 'h';
            }
        }
        sophan=cos;
        Master.wastes.add(this);
        setSize(32, 32);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isFire){
            textureRegion = new TextureRegion(new Texture("wastefire.png"));
        }

        if(sophan=='1'){
            moveBy(0,-1);
            if(14*32>=getY()&&getY()>=11*32){
                if(isTrongDS){
                    Master.wastes.removeValue(this,true);
                    isTrongDS=false;
                }
                toBack();
            }else {
                if(!isTrongDS){
                    Master.wastes.add(this);
                    isTrongDS=true;
                }
                toFront();
            }
            if(getY()<-32){
                Master.wastes.removeValue(this,true);
                remove();
            }
        }
    }

    public char getCostume() {
        return costume;
    }
}

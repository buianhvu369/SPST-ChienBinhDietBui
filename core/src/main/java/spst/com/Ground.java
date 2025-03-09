package spst.com;

import com.badlogic.gdx.scenes.scene2d.Stage;

import static com.badlogic.gdx.math.MathUtils.random;

public class Ground extends MyActor{
    public Ground(float x, float y, Stage s, boolean isRandom) {
        super(x, y, s);
        if(isRandom){
            int ran = random.nextInt(1,6);
            switch (ran){
                case 1 -> textureRegion = Utils.getRegionGround(0,0,16,16);
                case 2 -> textureRegion = Utils.getRegionGround(1*16,0,16,16);
                case 3 -> textureRegion = Utils.getRegionGround(2*16,0,16,16);
                case 4 -> textureRegion = Utils.getRegionGround(1*16,2*16,16,16);
                case 5 -> textureRegion = Utils.getRegionGround(7*16,3*16,16,16);
            }
        }else{
            textureRegion = Utils.getRegionGround(16,2*16,16,16);
        }
        setSize(textureRegion.getRegionWidth()*2,textureRegion.getRegionHeight()*2);
    }
}

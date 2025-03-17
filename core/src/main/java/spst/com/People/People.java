package spst.com.People;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import spst.com.MyActor;
import spst.com.Roads.Tree;
import spst.com.Screen.Master;
import spst.com.Utils;

public class People extends MyActor {
    boolean isCutting = false;
    boolean isFiring = false;
    int time = 0;
    public People(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion( 23*16 + 16* MathUtils.random(0, 3),MathUtils.random(0, 17)*16,16,16);
        setSize(32, 32);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time ++;

        if(time % 300 == 0){
            time = 0;
            isCutting = MathUtils.randomBoolean();
            if(isCutting){
                if(!Master.trees.isEmpty()){
                    System.out.println("Chat cay thoi anh em!");
                    Tree tree = Master.trees.get(MathUtils.random(0, Master.trees.size - 1));
                    tree.isCutDown = true;
                    setPosition(tree.getX() + 32, tree.getY());
                }
            } else {
                setPosition(MathUtils.random(0, 2000), MathUtils.random(0, 700));
            }
        }
    }
}

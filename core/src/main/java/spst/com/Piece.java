package spst.com;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import spst.com.MyActor;
import spst.com.Roads.Tree;
import spst.com.Screen.Master;
import spst.com.Utils;

public class Piece extends MyActor {
    public Piece(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = Utils.getRegion(16 * MathUtils.random(0, 26), MathUtils.random(0, 17) * 16, 16, 16);
        setSize(32, 32);
        setPosition(MathUtils.random(0, Gdx.graphics.getWidth()), MathUtils.random(0, Gdx.graphics.getHeight()));
        addAction(Actions.sequence(
            Actions.moveBy(MathUtils.random(-400, 400), MathUtils.random(-250, 250), 2),
            Actions.removeActor()
        ));
        addAction(Actions.fadeOut(2));
    }
}

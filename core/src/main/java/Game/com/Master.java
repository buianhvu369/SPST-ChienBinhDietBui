package Game.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Master extends ApplicationAdapter {
    private SpriteBatch batch;

    Stage stage;

    @Override
    public void create() {
        batch = new SpriteBatch();
        stage = new Stage();
        generateMap();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        stage.act();
        stage.draw();
    }

    private void generateMap(){
        float x = 0;
        float y = Gdx.graphics.getHeight()/2;
        for (int i = 0; i < 4; i++) {
            new CrossWalk(x, y, stage, true);
            x += 32;
            for (int j = 0; j < 10; j++) {
                new RoadWay(x,y, stage, true);
                x += 32;
            }
        }
        new Car(MathUtils.random(0, Gdx.graphics.getWidth()), y + 10, stage);
        x = Gdx.graphics.getWidth()/2;
        y += (96 - 6);
        for (int i = 0; i < 2; i++) {
            new CrossWalk(x, y, stage, false);
            y += 32;
            for (int j = 0; j < 10; j++) {
                new RoadWay(x,y, stage, false);
                y += 32;
            }
        }
        y -= (2*11*32 + 114);
        for (int i = 0; i < 4; i++) {
            new CrossWalk(x, y, stage, false);
            y -= 32;
            for (int j = 0; j < 10; j++) {
                new RoadWay(x,y, stage, false);
                y -= 32;
            }
        }
        new Tree(MathUtils.random(0, Gdx.graphics.getWidth()), Gdx.graphics.getHeight()/2, stage);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}

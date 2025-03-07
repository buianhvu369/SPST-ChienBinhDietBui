package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Master implements Screen {
    private SpriteBatch batch;
    OrthographicCamera camera;
    Stage stage;
    Player player;
    public Master(){
        batch = new SpriteBatch();
        stage = new Stage();
        camera = new OrthographicCamera();
        generateMap();

        player = new Player(100,100,stage);
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLACK);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                if((float) Gdx.graphics.getWidth() / 2 - player.getWidth() /2 <= player.getX() && player.getX()  <= (float) (1000 - Gdx.graphics.getWidth()/2) - player.getWidth()/2) {
                    stage.getCamera().position.x = player.getX() + player.getWidth() / 2;
                    camera.position.x = player.getX() + player.getWidth() / 2;
                }
                if((float) Gdx.graphics.getHeight()/2 - player.getHeight()/2 <= player.getY() &&  player.getY() <=  (1000 - (float) Gdx.graphics.getHeight()/2) - player.getHeight()/2){
                    stage.getCamera().position.y = player.getY() + player.getHeight() /2;
                    camera.position.y = player.getY() + player.getHeight() /2;
                }
            }
        },0);

        stage.act();
        stage.draw();
    }
    private void generateMap(){
        for(int i = 0;i < 32;i++){
            RoadWay roadWay = new RoadWay(i*32,1000/2f-48,stage,true);
        }
        Car car = new Car(0,1000/2f-48,stage);
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}

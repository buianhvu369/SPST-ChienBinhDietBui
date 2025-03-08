package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import spst.com.Roads.RoadWay;
import spst.com.Roads.CrossRoad.BlankRoad;
import spst.com.Roads.CrossRoad.Corner;
import spst.com.Roads.Car;
import spst.com.Roads.CrossWalk;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Master implements Screen {
    private SpriteBatch batch;
    OrthographicCamera camera;
    Stage stage;
    Player player;
    ShapeRenderer shapeRenderer = new ShapeRenderer();

    Array<Car> cars = new Array<>();
    Array<MyActor> roads = new Array<>();
    public Master(){
        batch = new SpriteBatch();
        stage = new Stage();
        camera = new OrthographicCamera();

        generateMap();
        player = new Player(1200/2,800/2,stage);
        createCar();
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
                if((float) Gdx.graphics.getWidth() / 2 - player.getWidth() /2 <= player.getX() && player.getX()  <= (float) (1200 - Gdx.graphics.getWidth()/2) - player.getWidth()/2) {
                    stage.getCamera().position.x = player.getX() + player.getWidth() / 2;
                    camera.position.x = player.getX() + player.getWidth() / 2;
                }
                if((float) Gdx.graphics.getHeight()/2 - player.getHeight()/2 <= player.getY() &&  player.getY() <=  (800 - (float) Gdx.graphics.getHeight()/2) - player.getHeight()/2){
                    stage.getCamera().position.y = player.getY() + player.getHeight() /2;
                    camera.position.y = player.getY() + player.getHeight() /2;
                }
            }
        },0);
        stage.act();
        stage.draw();
    }
    private void generateMap(){
        for(int i = -1;i < 38;i++){
            RoadWay roadWayV = new RoadWay(i*32,800/2f-48,stage,true);
            roads.add(roadWayV);
            createCrossWalk(i,i*32,800/2f-48,true);
            if(i == 9 || i == 25){
                for(int  j = -1;j < 31;j++){
                    RoadWay roadWay = new RoadWay(i*32,800/2f-48-(j+2)*32,stage,false);
                    roads.add(roadWay);
                    createCrossWalk(j,i*32,800/2f-48-(j+2)*32,false);
                }
            }else if(i == 21){
                for(int  j = -1;j < 31;j++){
                    RoadWay roadWay = new RoadWay(i*32,800/2f+48+(j+1)*32,stage,false);
                    roads.add(roadWay);
                    createCrossWalk(j,i*32,800/2f+48+(j+1)*32,false);
                }
            }
        }
        Corner corner = new Corner(21*32,800/2f+48 - 32,stage,"DR");
        BlankRoad blankRoad = new BlankRoad(21*32+32,800/2f+48 - 32,stage);
        Corner corner12 = new Corner(21*32+32*2,800/2f+48 - 32,stage,"DL");
        roads.add(corner);
        roads.add(blankRoad);
        roads.add(corner12);

        Corner corner2 = new Corner(9*32,800/2f-48-0,stage,"UR");
        BlankRoad blankRoad2 = new BlankRoad(9*32+32,800/2f-48-0,stage);
        Corner corner22 = new Corner(9*32+32*2,800/2f-48-0,stage,"UL");
        roads.add(corner2);
        roads.add(blankRoad2);
        roads.add(corner22);

        Corner corner3 = new Corner(25*32,800/2f-48-0,stage,"UR");
        BlankRoad blankRoad3 = new BlankRoad(25*32+32,800/2f-48-0,stage);
        Corner corner32 = new Corner(25*32+32*2,800/2f-48-0,stage,"UL");
        roads.add(corner3);
        roads.add(blankRoad3);
        roads.add(corner32);
    }
    private void createCar(){
        for (int y = 0;y<3;y++){
            Car car = new Car(-1200/3*y,800/2f-48+8,stage,true);
            cars.add(car);
            Car car2 = new Car(1200+1200/3*y,800/2f-48+32*2-8,stage,false);
            cars.add(car2);
        }
    }
    private void createCrossWalk(int e, float x, float y, boolean isHorizontal){
        if(e%6 == 0){
            CrossWalk crossWalk = new CrossWalk(x,y,stage,isHorizontal);
            roads.add(crossWalk);
        }
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

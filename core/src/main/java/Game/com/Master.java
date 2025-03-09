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
        //generateMap();
        generateMap2();
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
    }public void generateMap2(){
        createGround();
        float xR = 0;
        float yR = Gdx.graphics.getHeight()-32*2;
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 21; i++) {
                new Rice(xR, yR, stage);
                xR += 32 ;
            }
            xR = 0;
            yR -= 32;
        }
        xR = 0;
        yR = Gdx.graphics.getHeight() - 32*4;
        for(int j = 0; j < 13; j++){
            new Hangraongang(xR, yR, stage);
            xR += 32*3-16;
        }

        float x = 0;
        float y = Gdx.graphics.getHeight()-32*7;
        for (int i = 0; i < 3; i++) {
            new CrossWalk(x, y, stage, true);
            x += 32;
            for (int j = 0; j < 12; j++) {
                new RoadWay(x,y, stage, true);
                x += 32;
            }
        }
        x = 32*15;
        y = Gdx.graphics.getHeight()-32*8+8;
        for (int i = 0; i < 4; i++) {
            new CrossWalk(x, y, stage, false);
            y -= 32;
            for (int j = 0; j < 6; j++) {
                new RoadWay(x,y, stage, false);
                y -= 32;
            }
        }
        createHouseBlue1(32*2,32*12);
        createHouseRed3(32*8,32*12);
        createHouseBlue2(32*4,32*6);
        createHouseBlue3(32*9,32*2);
        createHouseRed2(32*11, 32*8);
        new Waterwell(32*8,32*9,stage);
        createHouseBlue2(32*34,32*13);
        createHouseRed1(32*20,32*12);
        createHouseBlue1(32*28, 32*11);
        createHouseBlue2(32*25,32*2);
        createHouseRed1(32*33,32*2);
    }
    public void createGround(){
        float x = 0;
        float y = Gdx.graphics.getHeight();
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 7; i++) {
                new Ground2(x, y, stage);
                x += 32*3;
            }
            x = 0;
            y -= 32*4;
        }
        x = 32*21;
        y = Gdx.graphics.getHeight();
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 19; j++){
                int rand = MathUtils.random(1,5);
                new Randomblock(x,y, stage,rand);
                x+= 32;
            }
            x = 32*21;
            y -= 32;
        }
        x = 0;
        y = Gdx.graphics.getHeight()-32*8;
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 15; j++) {
                int rand = MathUtils.random(1,5);
                new Randomblock(x,y, stage,rand);
                x += 32;
            }
            x = 0;
            y -= 32;
        }
        x = 32*18;
        y = Gdx.graphics.getHeight()-32*8;
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 20; j++) {
                int rand = MathUtils.random(1,5);
                new Randomblock(x,y, stage,rand);
                x += 32;
            }
            x = 32*18;
            y -= 32;
        }
    } public void createHouseBlue1(float x , float y ){
        new Wall(x,y,stage,true);x+= 32;
        new WindowHouse(x,y,stage,true);x += 32;
        new DoorHouse(x,y,stage,true);x += 32;;
        new Wall(x,y,stage,true);x -= 32*3;y += 32;
        for(int i = 0; i<4; i++){
            new RoofHouse(x,y,stage,true);
            x += 32;
        }x -= 32*2;
        new SpecialRoof(x,y,stage,true);
        x -= 32;y += 32;new Chimney(x,y,stage,true);
    }
    public void createHouseBlue2(float x , float y ){
        new Wall(x,y,stage,true);x+= 32;
        new DoorHouse(x,y,stage,true);x += 32;
        new Wall(x,y,stage,true);x -= 32*2;y += 32;
        for(int i = 0; i<3; i++){
            new RoofHouse(x,y,stage,true);
            x += 32;
        }x -= 32*2;new SpecialRoof(x,y,stage,true);
    }
    public void createHouseBlue3(float x , float y ){
        new Wall(x,y,stage,true);x+= 32;
        new DoorHouse(x,y,stage,true);x += 32;
        new Wall(x,y,stage,true);x -= 32*2;y += 32;
        new Wall(x,y,stage,true);x += 32;
        new WindowHouse(x,y,stage,true);x += 32;
        new Wall(x,y,stage,true);
        x -= 32*2;y += 32;
        for(int i = 0; i<3; i++){
            new RoofHouse(x,y,stage,true);
            x += 32;
        }
    }
    public void createHouseRed1(float x , float y){
        new Wall(x,y,stage,false);x+= 32;
        new WindowHouse(x,y,stage,false);x += 32;
        new DoorHouse(x,y,stage,false);x += 32;;
        new Wall(x,y,stage,false);x -= 32*3;y += 32;
        for(int i = 0; i<4; i++){
            new RoofHouse(x,y,stage,false);
            x += 32;
        }x -= 32*2;
        new SpecialRoof(x,y,stage,false);x -= 32;y += 32;
        new Chimney(x,y,stage,false);
    }
    public void createHouseRed2(float x , float y ){
        new Wall(x,y,stage,false);x+= 32;
        new DoorHouse(x,y,stage,false);x += 32;
        new Wall(x,y,stage,false);
        x -= 32*2;y += 32;
        for(int i = 0; i<3; i++){
            new RoofHouse(x,y,stage,false);
            x += 32;
        }
        x -= 32*2;
        new SpecialRoof(x,y,stage,false);
    }
    public void createHouseRed3(float x , float y ){
        new Wall(x,y,stage,false);x+= 32;
        new DoorHouse(x,y,stage,false);x += 32;
        new Wall(x,y,stage,false);x -= 32*2;y += 32;
        new Wall(x,y,stage,false);x += 32;
        new WindowHouse(x,y,stage,false);x += 32;
        new Wall(x,y,stage,false);
        x -= 32*2;y += 32;
        for(int i = 0; i<3; i++){
            new RoofHouse(x,y,stage,false);
            x += 32;
        }

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}

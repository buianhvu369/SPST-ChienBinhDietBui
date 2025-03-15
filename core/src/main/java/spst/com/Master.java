package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import spst.com.Cameras.NormalCamera;
import spst.com.GroundOutRoads.CanhGround;
import spst.com.GroundOutRoads.GroundCenter;
import spst.com.GroundOutRoads.GroundCorner;
import spst.com.House.FactoryCenter;
import spst.com.House.HotelCenter;
import spst.com.Parking.LetterP;
import spst.com.Parking.RoadPiece;
import spst.com.Parking.RoundCorner;
import spst.com.Pool.CornerPool;
import spst.com.Pool.PoolRec;
import spst.com.Pool.WallPool;
import spst.com.Pool.Water;
import spst.com.Roads.RoadWay;
import spst.com.Roads.CrossRoad.BlankRoad;
import spst.com.Roads.CrossRoad.Corner;
import spst.com.Roads.Car;
import spst.com.Roads.CrossWalk;
import spst.com.Roads.Tree;
import spst.com.House.MordernDoor;
import spst.com.House.ScienceCenter;
import spst.com.town.*;

import static com.badlogic.gdx.math.MathUtils.random;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Master implements Screen {
    private SpriteBatch batch;
    OrthographicCamera camera;
    InputMultiplexer multiplexer;
    Stage stage;
    Stage noMoveStage;
    BitmapFont font;
    public static Player player;
    PoolRec poolRec;
    BangScience bangScience;
    MordernDoor scienceDoor;
    MordernDoor hotelDoor;
    public static ShowAQI showAQI;
    Dark dark;
    ShapeRenderer shapeRenderer = new ShapeRenderer();

    Array<Car> cars = new Array<>();
    Array<MyActor> roads = new Array<>();
    Array<Waste> wastes = new Array<>();
    Array<Tree> trees = new Array<>();
    public static float AQI = 500;
    public static String whatActionIfClickMouse = "move";

    final float WINDOW_WIDTH = 2400;
    final float WINDOW_HEIGHT = 800;

    public static int growth = 0;
    public Array<Rice>rices ;
    Array<NormalCamera> normalCameras = new Array<>();
    Truck truck;
    public static boolean cutting = false;
    int speedX = -2 ;
    int  luotcat = 1;
    static Vector2 cameraPosition = new Vector2();
    public static int day = 0;
    int gio1phan60 = 0;
    float[]toadox = new float[]{
        4,4,5,6,7,9,9,9,12,11,10,9,8,8,5,6,7,8,8,10,9,8,8,8,8,22,22,22,22,23,24,25,26,30,30,30,29,28,35,35,35,35,34,33,31,32,31,30,29,28,27,27,27,27,27,27,27,32
    };
    float[]toadoy = new float[]{
        11,10,10,10,10,11,10,9,7,7,7,7,7,8,5,5,5,5,6,1,1,1,2,3,4,12,11,10,9,9,9,9,9,11,10,9,9,9,13,12,11,10,10,10,10,2,2,2,2,2,2,3,4,5,6,7,8,10
    };
    public static TextField textField;

    public Master() {
        batch = new SpriteBatch();
        multiplexer = new InputMultiplexer();
        stage = new Stage();
        noMoveStage = new Stage();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(noMoveStage);
        camera = new OrthographicCamera();

        poolRec = new PoolRec(0, 32 * 17, stage);
        rices = new Array();
        generateMap();
        generateMap2();
        truck = new Truck(32*33+1184,800 - 32*3, stage);

        createCar();
        createTree();
        createWaste();

        createHouses();

        player = new Player(1200 / 2, 800 / 2, stage);

        bangScience = new BangScience(-10000,-100,noMoveStage);
        dark = new Dark(0,0,noMoveStage);
        showAQI = new ShowAQI(0,0,noMoveStage);
        showAQI.setPosition(0,Gdx.graphics.getHeight()-showAQI.getHeight());

        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Lonely Cake.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 25;
        fontParameter.color = Color.BLUE;
        font = fontGenerator.generateFont(fontParameter);
        fontGenerator.dispose();

    }

    @Override
    public void show() {
        scienceDoor.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                showBangScience(32,32);
            }
        });

        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = font;
        textFieldStyle.fontColor = Color.RED;

        textFieldStyle.background = new TextureRegionDrawable(Utils.getRegion(0,0,16,16));

        // Tạo TextField
        textField = new TextField("", textFieldStyle);
        textField.setSize(220, 50);
        textField.setPosition(220, 6); // Vị trí giữa màn hình
        textField.setVisible(false);

        noMoveStage.addActor(textField);

        Gdx.input.setInputProcessor(multiplexer);

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.GRAY);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        xulyngaydem();
        if ((float) Gdx.graphics.getWidth() / 2 - player.getWidth() / 2 <= player.getX() && player.getX() <= (float) (WINDOW_WIDTH - Gdx.graphics.getWidth() / 2) - player.getWidth() / 2) {
            stage.getCamera().position.x = player.getX() + player.getWidth() / 2;
            camera.position.x = player.getX() + player.getWidth() / 2;
        }else if((float) Gdx.graphics.getWidth() / 2 - player.getWidth() / 2 > player.getX()){
            stage.getCamera().position.x = Gdx.graphics.getWidth() / 2f;
            camera.position.x = Gdx.graphics.getWidth() / 2f;
        }else if(player.getX() > (float) (WINDOW_WIDTH - Gdx.graphics.getWidth() / 2) - player.getWidth() / 2){
            stage.getCamera().position.x = WINDOW_WIDTH - Gdx.graphics.getWidth() / 2f;
            camera.position.x = WINDOW_WIDTH - Gdx.graphics.getWidth() / 2f;
        }
        if ((float) Gdx.graphics.getHeight() / 2 - player.getHeight() / 2 <= player.getY() && player.getY() <= (800 - (float) Gdx.graphics.getHeight() / 2) - player.getHeight() / 2) {
            stage.getCamera().position.y = player.getY() + player.getHeight() / 2;
            camera.position.y = player.getY() + player.getHeight() / 2;
        }else if((float) Gdx.graphics.getHeight() / 2 - player.getHeight() / 2 > player.getY()){
            stage.getCamera().position.y = Gdx.graphics.getHeight() / 2f;
            camera.position.y = Gdx.graphics.getHeight() / 2f;
        }else if(player.getY() > (800 - (float) Gdx.graphics.getHeight() / 2) - player.getHeight() / 2){
            stage.getCamera().position.y = (800 - (float) Gdx.graphics.getHeight() / 2);
            camera.position.y = (800 - (float) Gdx.graphics.getHeight() / 2);
        }

        growth++;
        for(Rice rice : rices){
            if(rice.getBound().overlaps(truck.getBound())){
                rice.remove();
            }
        }
        if(growth >= 180){
            cutting = true;
        }
        if(cutting) {
            truck.moveBy(speedX, 0);
            if (luotcat == 1) {
                truck.setScaleX(-1);
            }
            if (luotcat == 2) {
                truck.setScaleX(1);
            }
            if (truck.getX() < 1184) {
                truck.setScaleX(1);
                speedX = 2;
                luotcat = 2;
            }
            if (truck.getX() > 32 * 33+1184) {
                cutting = false;
                truck.setX(32 * 33+1184);
                luotcat = 1;
                float xR = 1184;
                speedX = -2;
                float yR =  WINDOW_HEIGHT - 32 * 2;
                rices.clear();
                growth = 0;
                for (int j = 0; j < 2; j++) {
                    for (int i = 0; i < 30; i++) {
                        Rice lua = new Rice(xR, yR, stage);
                        rices.add(lua);
                        xR += 32;
                    }
                    xR = 1184;
                    yR -= 32;
                }

            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            if(whatActionIfClickMouse.equals("move")){
                whatActionIfClickMouse = "planttree";
            }else {
                whatActionIfClickMouse = "move";
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.C)){
            whatActionIfClickMouse = "camera";
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Q)){
            for(NormalCamera n : normalCameras){
                if(n.name.equals("camera")){
                    n.doiCamera();
                }
            }
        }else {
            OrthographicCamera camera = (OrthographicCamera) stage.getViewport().getCamera();
            camera.zoom = 1f;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            bangScience.setPosition(-1002343,-1101);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            String inputText = textField.getText();
            textField.setVisible(false);
            noMoveStage.unfocusAll();
            NormalCamera normalCamera = new NormalCamera(cameraPosition.x,cameraPosition.y,stage);
            normalCameras.add(normalCamera);
            normalCamera.name = inputText;
        }

        stage.act();
        truck.toFront();
        stage.draw();
        noMoveStage.act();
        noMoveStage.draw();
    }

    public static void nhapTenNormalCamera(float x, float y){
        textField.setVisible(true);
        textField.setText(""); // Xóa nội dung cũ
        showAQI.getStage().setKeyboardFocus(textField);
        cameraPosition.set(x,y);
        System.out.println(765);
    }
    private void xulyngaydem(){
        gio1phan60++;
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                if(gio1phan60 == 60*22){
                    dark.addAction(Actions.fadeIn(2));
                }
            }
        },0);
        if(gio1phan60 == 60*24){
            day++;
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    dark.addAction(Actions.fadeOut(2));
                }
            },0);
        }
        if(gio1phan60 == 60*24*2){
            gio1phan60 = 0;
            day++;
            new Tree(player.getX(),player.getY(),stage );
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    dark.addAction(Actions.fadeOut(2));
                }
            },0);
        }
    }
    private void showBangScience(float x, float y){
        if(Math.abs(player.getX()-scienceDoor.getX())<32*6 && Math.abs(player.getY()-scienceDoor.getY()) < 32*6){
            bangScience.setPosition(x,y);
            bangScience.toFront();
        }
    }
    private void createViaHe(float x, float y, float width,float height){
        new GroundCorner(x,y,stage,"DL");
        new GroundCorner(x,y+32*(height-1),stage,"UL");
        new GroundCorner(x+(width-1)*32 ,y,stage,"DR");
        new GroundCorner(x+(width-1)*32,y+32*(height-1),stage,"UR");
        for(int i = 1;i<width-2+1;i++){
            new CanhGround(x+i*32,y,stage,'D');
        }
        for(int i = 1;i<width-2+1;i++){
            new CanhGround(x+i*32,y+(height-1)*32,stage,'U');
        }
        for(int i = 1;i<height-2+1;i++){
            new CanhGround(x,y+i*32,stage,'L');
        }
        for(int i = 1;i<height-2+1;i++){
            new CanhGround(x+(width-1)*32,y+i*32,stage,'R');
        }
        for(int i = 1;i<height-2+1;i++){
            for(int j = 1;j<width-2+1;j++){
                new GroundCenter(x+j*32,y+i*32,stage);
            }
        }

    }
    private void generateMap() {
        createViaHe(0,0,9,11);
        createViaHe(32*12,0,13,11);
        createViaHe(32*28,0,9,11);
        new GroundCorner(32*28,32*5,stage,"DL");
        new CanhGround(32*29,32*5,stage,'D');
        for(int i = 0;i<4;i++){
            new CanhGround(32*30,32*i+32,stage,'L');
        }
        new GroundCorner(32*28+32*2,0,stage,"DL");
        createViaHe(32*24,800/2+48,13,11);
        createViaHe(0,800/2+48,21,11);

        for (int i = -1; i < 38; i++) {
            RoadWay roadWayV = new RoadWay(i * 32, 800 / 2f - 48, stage, true);
            roads.add(roadWayV);
            createCrossWalk(i, i * 32, 800 / 2f - 48, true);
            if (i == 9) {
                for (int j = -1; j < 31; j++) {
                    RoadWay roadWay = new RoadWay(i * 32, 800 / 2f - 48 - (j + 2) * 32, stage, false);
                    roads.add(roadWay);
                    createCrossWalk(j, i * 32, 800 / 2f - 48 - (j + 2) * 32, false);
                }
            } else if (i == 21) {
                for (int j = -1; j < 31; j++) {
                    RoadWay roadWay = new RoadWay(i * 32, 800 / 2f + 48 + (j + 1) * 32, stage, false);
                    roads.add(roadWay);
                    createCrossWalk(j, i * 32, 800 / 2f + 48 + (j + 1) * 32, false);
                }
            }
        }

        new RoundCorner(32*25,0,stage,"DL");
        new RoundCorner(32*27,0,stage,"DR");
        new RoundCorner(32*25,800/2f-48-32,stage,"UL");
        new RoundCorner(32*27,800/2f-48-32,stage,"UR");
        new RoadPiece(32*26,800/2f-48-32,stage,'-');
        new RoadPiece(32*26,0,stage,'_');
        for(int i = 0;i<9;i++){
            new RoadPiece(32*25,32+i*32,stage,'[');
            new BlankRoad(32*26,32+i*32,stage);
            new RoadPiece(32*27,32+i*32,stage,']');
        }
        for(int i = 0;i<5;i++){
            createParking(32*28,i*32);
        }

        Corner corner = new Corner(21 * 32, 800 / 2f + 48 - 32, stage, "DR");
        BlankRoad blankRoad = new BlankRoad(21 * 32 + 32, 800 / 2f + 48 - 32, stage);
        Corner corner12 = new Corner(21 * 32 + 32 * 2, 800 / 2f + 48 - 32, stage, "DL");
        roads.add(corner);
        roads.add(blankRoad);
        roads.add(corner12);

        Corner corner2 = new Corner(9 * 32, 800 / 2f - 48 - 0, stage, "UR");
        BlankRoad blankRoad2 = new BlankRoad(9 * 32 + 32, 800 / 2f - 48 - 0, stage);
        Corner corner22 = new Corner(9 * 32 + 32 * 2, 800 / 2f - 48 - 0, stage, "UL");
        roads.add(corner2);
        roads.add(blankRoad2);
        roads.add(corner22);

        Corner corner3 = new Corner(25 * 32, 800 / 2f - 48 - 0, stage, "UR");
        BlankRoad blankRoad3 = new BlankRoad(25 * 32 + 32, 800 / 2f - 48 - 0, stage);
        Corner corner32 = new Corner(25 * 32 + 32 * 2, 800 / 2f - 48 - 0, stage, "UL");
        roads.add(corner3);
        roads.add(blankRoad3);
        roads.add(corner32);

        CornerPool cornerPool = new CornerPool(0, 800 - 32 * 3, stage, "UL");
        CornerPool cornerPool2 = new CornerPool(32 * 19, 800 - 32 * 3, stage, "UR");
        CornerPool cornerPool3 = new CornerPool(0, 800 - 32 * 9, stage, "DL");
        CornerPool cornerPool4 = new CornerPool(32 * 19, 800 - 32 * 9, stage, "DR");
        for (int i = 0; i < 18; i++) {
            WallPool wallPool = new WallPool(32 + 32 * i, 800 - 32 * 3, stage, 'U');
        }
        for (int i = 0; i < 18; i++) {
            WallPool wallPool = new WallPool(32 + 32 * i, 800 - 32 * 8, stage, 'D');
        }
        for (int i = 0; i < 5; i++) {
            WallPool wallPool = new WallPool(0, 800 - 32 * 4 - 32 * i, stage, 'L');
        }
        for (int i = 0; i < 5; i++) {
            WallPool wallPool = new WallPool(32 * 19, 800 - 32 * 4 - 32 * i, stage, 'R');
        }
        for (int y = 0; y < 5; y++) {
            for (int i = 0; i < 18; i++) {
                Water water = new Water(32 + 32 * i, 800 - 32 * 5 - 32 * y, stage);
            }
        }
        ////ScienceHouse scienceHouse = new ScienceHouse(32 * 13, 0, stage);
    }

    private void createCar() {
        for (int y = 0; y < 3; y++) {
            Car car = new Car(1184 / 3 * y, 800 / 2f - 48 + 8, stage, true);
            cars.add(car);
            Car car2 = new Car(1184 / 3 * y, 800 / 2f - 48 + 32 * 2 - 8, stage, false);
            cars.add(car2);
        }
    }
    private void createParking(float x, float y){
        new RoadPiece(x,y,stage,'_');
        new LetterP(x+32,y,stage);
    }
    private void createHouses(){
        new ScienceCenter(28*32,32*16,stage);
        scienceDoor = new MordernDoor(32*29,32*16,stage);
        new FactoryCenter(13 * 32, 0, stage);
        new MordernDoor(32*14,0,stage);
        new HotelCenter(32*32,32*5,stage) ;
        hotelDoor = new MordernDoor(32*33,32*5,stage);
    }

    private void createTree() {
        for (int i = 0; i < 37; i += 12) {
            Tree tree2 = new Tree((i + 6) * 32, 800 / 2f - 48, stage);
            trees.add(tree2);
        }
        int i = 0;
        while (i < 21) {
            Tree tree2 = new Tree(i * 32, 800 / 2f + 48, stage);
            i += random.nextInt(2, 21);
            trees.add(tree2);
        }
        i = 0;
        while (i < 21) {
            Tree tree2 = new Tree(i * 32, 800 - 32 * 2, stage);
            i += random.nextInt(2, 21);
            trees.add(tree2);
        }
    }

    private void createCrossWalk(int e, float x, float y, boolean isHorizontal) {
        if (e % 6 == 0) {
            CrossWalk crossWalk = new CrossWalk(x, y, stage, isHorizontal);
            roads.add(crossWalk);
        }
    }

    private void createWaste() {
        for (int i = 0; i < 6; i++) {
            Waste waste = new Waste(random.nextInt(1, 9) * 32, random.nextInt(1, 11) * 32, stage);
            wastes.add(waste);
        }
    }

    public void generateMap2() {
        createGroundTown();
        float xR = 1184;
        float yR = WINDOW_HEIGHT - 32 * 2;
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 21; i++) {
                Rice lua = new Rice(xR, yR, stage);
                rices.add(lua);
                xR += 32;
            }
            xR = 1184;
            yR -= 32;
        }
        xR = 1184;
        yR = WINDOW_HEIGHT - 32 * 4;
        for (int j = 0; j < 13; j++) {
            new Hangraongang(xR, yR, stage);
            xR += 32 * 3 - 16;
        }

        float x = 1184;
        float y = WINDOW_HEIGHT - 32 * 7;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 12; j++) {
                new RoadWay(x, y, stage, true);
                x += 32;
            }
            new CrossWalk(x, y, stage, true);
            x += 32;
        }
        x = 1184 + 32 * 15;
        y = WINDOW_HEIGHT - 32 * 8 + 8;
        for(int i = 0;i<4;i++){
            for (int j = -1; j < 5; j++) {
                new RoadWay(x, y, stage, false);
                createCrossWalk(j, x,y,false);
                y -= 32;
            }
        }
        for (int i = 0; i < 58; i++) {
            x = toadox[i];
            y =  toadoy[i] ;
            new Randomblock(x*32 + 1184,y*32,stage,5);
        }

        createHouseBlue1(1184+32*2,32*12);
        createHouseRed3(1184+32*8,32*12);
        createHouseBlue2(1184+32*4,32*6);
        createHouseBlue3(1184+32*9,32*2);
        createHouseRed2(1184+32*11, 32*8);
        new Waterwell(1184+32*8,32*9,stage);
        createHouseBlue2(1184+32*34,32*13);
        createHouseRed1(1184+32*20,32*12);
        createHouseBlue1(1184+32*28, 32*11);
        creatCastle(1184+32*30,32*2);
        new Waterwell(1184+32*27,32*8,stage);

        new RoadWay(32*37,800/2f-48,stage,true);
        new RoadWay(32*38,800/2f-48,stage,true);
        new RoadWay(32*39,800/2f-48,stage,true);
        for (int i = 0;i<4;i++){
            new RoadWay(37f*32,800/2f+48+3*32-32*i,stage,false);
        }

        BlankRoad blankRoad = new BlankRoad(1184 + 32, 800 / 2f + 48 + 4*32, stage);
        Corner corner1 = new Corner(1184 + 2 * 32, 800 / 2f + 48 + 4*32, stage, "UL");

        Corner corner2 = new Corner(1184 + 15 * 32, 800 / 2f + 48 + 4*32, stage, "UR");
        BlankRoad blankRoad2 = new BlankRoad(1184 + 16 * 32, 800 / 2f + 48 + 4*32, stage);
        Corner corner12 = new Corner(1184 + 17 * 32, 800 / 2f + 48 + 4*32, stage, "UL");
    }

    public void createGroundTown() {
        float x = 1184;
        float y = WINDOW_HEIGHT - 32*4;
            for (int i = 0; i < 10; i++) {
                new Ground2(x, y, stage);
                x += 32 * 3;
            }
        x = 1184 + 32 * 30;
        y = WINDOW_HEIGHT;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 19; j++) {
                int rand = MathUtils.random(1, 2);
                new Randomblock(x, y, stage, rand);
                x += 32;
            }
            x = 1184 + 32 * 30;
            y -= 32;
        }
        x = 1184 + 0;
        y = WINDOW_HEIGHT - 32 * 8;
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 15; j++) {
                int rand = MathUtils.random(1, 2);
                new Randomblock(x, y, stage, rand);
                x += 32;
            }
            x = 1184 + 0;
            y -= 32;
        }
        x = 1184 + 32 * 18;
        y = WINDOW_HEIGHT - 32 * 8;
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 20; j++) {
                int rand = MathUtils.random(1, 2);
                new Randomblock(x, y, stage, rand);
                x += 32;
            }
            x = 1184 + 32 * 18;
            y -= 32;
        }
    }

    public void createHouseBlue1(float x, float y) {
        new Wall(x, y, stage, true);
        x += 32;
        new WindowHouse(x, y, stage, true);
        x += 32;
        new DoorHouse(x, y, stage, true);
        x += 32;
        ;
        new Wall(x, y, stage, true);
        x -= 32 * 3;
        y += 32;
        for (int i = 0; i < 4; i++) {
            new RoofHouse(x, y, stage, true);
            x += 32;
        }
        x -= 32 * 2;
        new SpecialRoof(x, y, stage, true);
        x -= 32;
        y += 32;
        new Chimney(x, y, stage, true);
    }

    public void createHouseBlue2(float x, float y) {
        new Wall(x, y, stage, true);
        x += 32;
        new DoorHouse(x, y, stage, true);
        x += 32;
        new Wall(x, y, stage, true);
        x -= 32 * 2;
        y += 32;
        for (int i = 0; i < 3; i++) {
            new RoofHouse(x, y, stage, true);
            x += 32;
        }
        x -= 32 * 2;
        new SpecialRoof(x, y, stage, true);
    }

    public void createHouseBlue3(float x, float y) {
        new Wall(x, y, stage, true);
        x += 32;
        new DoorHouse(x, y, stage, true);
        x += 32;
        new Wall(x, y, stage, true);
        x -= 32 * 2;
        y += 32;
        new Wall(x, y, stage, true);
        x += 32;
        new WindowHouse(x, y, stage, true);
        x += 32;
        new Wall(x, y, stage, true);
        x -= 32 * 2;
        y += 32;
        for (int i = 0; i < 3; i++) {
            new RoofHouse(x, y, stage, true);
            x += 32;
        }
    }

    public void createHouseRed1(float x, float y) {
        new Wall(x, y, stage, false);
        x += 32;
        new WindowHouse(x, y, stage, false);
        x += 32;
        new DoorHouse(x, y, stage, false);
        x += 32;
        ;
        new Wall(x, y, stage, false);
        x -= 32 * 3;
        y += 32;
        for (int i = 0; i < 4; i++) {
            new RoofHouse(x, y, stage, false);
            x += 32;
        }
        x -= 32 * 2;
        new SpecialRoof(x, y, stage, false);
        x -= 32;
        y += 32;
        new Chimney(x, y, stage, false);
    }

    public void createHouseRed2(float x, float y) {
        new Wall(x, y, stage, false);
        x += 32;
        new DoorHouse(x, y, stage, false);
        x += 32;
        new Wall(x, y, stage, false);
        x -= 32 * 2;
        y += 32;
        for (int i = 0; i < 3; i++) {
            new RoofHouse(x, y, stage, false);
            x += 32;
        }
        x -= 32 * 2;
        new SpecialRoof(x, y, stage, false);
    }

    public void createHouseRed3(float x, float y) {
        new Wall(x, y, stage, false);
        x += 32;
        new DoorHouse(x, y, stage, false);
        x += 32;
        new Wall(x, y, stage, false);
        x -= 32 * 2;
        y += 32;
        new Wall(x, y, stage, false);
        x += 32;
        new WindowHouse(x, y, stage, false);
        x += 32;
        new Wall(x, y, stage, false);
        x -= 32 * 2;
        y += 32;
        for (int i = 0; i < 3; i++) {
            new RoofHouse(x, y, stage, false);
            x += 32;
        }

    }
    public void creatCastle(float x , float y ){
        new partofCastle(x,y,stage,5);x+= 32;
        new partofCastle(x,y,stage,5);x += 32;
        new partofCastle(x,y,stage,6);x += 32*2;
        new partofCastle(x,y,stage,5);x += 32;
        new partofCastle(x,y,stage,5);x -= 32*5;y += 32;
        new partofCastle(x,y,stage,5);x+= 32;
        new partofCastle(x,y,stage,5);x += 32*3;
        new partofCastle(x,y,stage,5);x += 32;
        new partofCastle(x,y,stage,5);x -= 32*5;y += 32;
        new partofCastle(x,y,stage,2);x += 32;
        new partofCastle(x,y,stage,5);x+=32;
        new partofCastle(x,y,stage,5);x+=32;
        new partofCastle(x,y,stage,5);x+= 32;
        new partofCastle(x,y,stage,5);x+= 32;
        new partofCastle(x,y,stage,4);x -= 32*5;y += 32;
        new partofCastle(x,y,stage,1);x += 32;
        new partofCastle(x,y,stage,5);x += 32;
        new partofCastle(x,y,stage,9);x += 32;
        new partofCastle(x,y,stage,9);x += 32;
        new partofCastle(x,y,stage,5);x += 32;
        new partofCastle(x,y,stage,3);x -= 32*4;y += 32;
        new partofCastle(x,y,stage,5);x += 32;
        new partofCastle(x,y,stage,8);x += 32;
        new partofCastle(x,y,stage,8);x += 32;
        new partofCastle(x,y,stage,5);y+= 32;
        new partofCastle(x,y,stage,5);x -= 32*3;
        new partofCastle(x,y,stage,5);x += 32*3;y +=32;
        new partofCastle(x, y, stage, 7);x -= 32 * 3;new partofCastle(x, y, stage, 7);


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
        GameState.saveGame();
        batch.dispose();
    }
}

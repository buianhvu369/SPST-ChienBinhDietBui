package spst.com.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import spst.com.*;
import spst.com.Button.*;
import spst.com.Cameras.NormalCamera;
import spst.com.GroundOutRoads.CanhGround;
import spst.com.GroundOutRoads.GroundCenter;
import spst.com.GroundOutRoads.GroundCorner;
import spst.com.House.FactoryCenter;
import spst.com.House.HotelCenter;
import spst.com.Parking.LetterP;
import spst.com.Parking.RoadPiece;
import spst.com.Parking.RoundCorner;
import spst.com.People.People1;
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
    public static SpriteBatch batch;
    OrthographicCamera camera;
    InputMultiplexer multiplexer;
    Stage stage;
    public static Stage noMoveStage;
    ThongTin thongTinButton;
    NghienCuu nghienCuuButton;
    WhiteButton nangCapMLKK;
    CheTao cheTaoButton;
    CaiDat caiDatButton;
    public static Player player;
    PoolRec poolRec;
    BangScience bangScience;
    Cross bangScienceCross;
    MordernDoor scienceDoor;
    MordernDoor hotelDoor;
    public static ShowAQI showAQI;
    Dark dark;
    Line line;
    Line line2;
    Line lineThongTin;
    ShapeRenderer shapeRenderer = new ShapeRenderer();

    Array<Car> cars = new Array<>();
    Array<MyActor> roads = new Array<>();
    Array<Waste> wastes = new Array<>();
    Array<Tree> trees = new Array<>();
    public static  Array<Rectangle> noPlaced = new Array<>();
    public static float AQI = 500;
    public static String whatActionIfClickMouse = "move";
    public  static int amountSeed = 10;

    final float WINDOW_WIDTH = 2400;
    final float WINDOW_HEIGHT = 800;

    public static int growth = 0;
    public Array<Rice>rices ;
    Array<NormalCamera> normalCameras = new Array<>();
    Truck truck;
    TreeButon treeButon;

    public static Waterwell gieng;
    public static boolean cutting = false;
    int speedX = -2 ;
    int  luotcat = 1;
    boolean hienChiSo = false;
    boolean hienThongTin = false;
    boolean hienNghienCuu = false;
    public static Vector2 cameraPosition = new Vector2(1200 / 2, 800 / 2);
    public static int day = 0;
    int gio1phan60 = 0;
    float[]toadox = new float[]{
        4,4,5,6,7,9,9,9,12,11,10,9,8,8,5,6,7,8,8,10,9,8,8,8,8,22,22,22,22,23,24,25,26,30,30,30,29,28,35,35,35,35,34,33,31,32,31,30,29,28,27,27,27,27,27,27,27,32
    };
    float[]toadoy = new float[]{
        11,10,10,10,10,11,10,9,7,7,7,7,7,8,5,5,5,5,6,1,1,1,2,3,4,12,11,10,9,9,9,9,9,11,10,9,9,9,13,12,11,10,10,10,10,2,2,2,2,2,2,3,4,5,6,7,8,10
    };
    public static TextField textField;
    private Sound clickSound = Gdx.audio.newSound(Gdx.files.internal("clicksound.ogg"));;
    StartGame game;

    public Master(StartGame game) {
        this.game = game;

        batch = new SpriteBatch();
        multiplexer = new InputMultiplexer();
        stage = new Stage();
        noMoveStage = new Stage();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(noMoveStage);
        camera = new OrthographicCamera();
        camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        thongTinButton = new ThongTin(-1000,-1000,noMoveStage);
        nghienCuuButton = new NghienCuu(-1000,-1000,noMoveStage);
        nangCapMLKK = new WhiteButton(-1000,-1000,noMoveStage);
        cheTaoButton = new CheTao(-1000,-1000,noMoveStage);
        caiDatButton = new CaiDat(-1000,-1000,noMoveStage);

        poolRec = new PoolRec(0, 32 * 17, stage);
        rices = new Array();
        Array noPlaces = new Array();
        generateMap();
        generateMap2();
        truck = new Truck(32*33+1184,800 - 32*3, stage);
        gieng = new Waterwell(1184+32*27,32*6,stage);
        treeButon = new TreeButon(Gdx.graphics.getWidth()-100,Gdx.graphics.getHeight()-100,noMoveStage);

        createTree();
        createWaste();
        createHouses();

        new ThapRua(32*9+8,800/2+48+32*6+8,stage);
        player = new Player(1200 / 2, 800 / 2, stage);

        bangScience = new BangScience(-10000,-100,noMoveStage);
        bangScienceCross = new Cross(-10000,-100,noMoveStage);
        dark = new Dark(0,0,noMoveStage);
        // thằng này đang chắn ỏ lớp trên, nên các actor cùng stage ko nhận được click
        // nên cần disabled nó
        dark.setTouchable(Touchable.disabled);
        line = new Line(32,Gdx.graphics.getHeight()-32*5-4,896,0,noMoveStage);
        line2 = new Line(32,32*2+8,896,0,noMoveStage);
        lineThongTin = new Line(32,Gdx.graphics.getHeight()-32*6-4,896,0,noMoveStage);
        showAQI = new ShowAQI(0,0,noMoveStage);
        showAQI.setPosition(0,Gdx.graphics.getHeight()-showAQI.getHeight());

    }

    @Override
    public void show() {
        scienceDoor.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                showBangScience(32,32);
            }
        });
        bangScienceCross.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                bangScience.setPosition(-1002343,-1101);
                bangScienceCross.setPosition(-1002343,-1101);
                thongTinButton.setPosition(-1002343,-1101);
                nghienCuuButton.setPosition(-1002343,-1101);
                nangCapMLKK.setPosition(-1002343,-1101);
                cheTaoButton.setPosition(-1002343,-1101);
                caiDatButton.setPosition(-1002343,-1101);
                line.setHeight(0);
                line2.setHeight(0);
                dongThongtin();
                dongNghienCuu();
                hienChiSo = false;
                hienNghienCuu = false;
            }
        });

        thongTinButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                moThongTin();
            }
        });

        nghienCuuButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                moNghienCuu();
            }
        });

        nangCapMLKK.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                GameState.levelmaylockhongkhi++;
            }
        });

        cheTaoButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                moCheTao();
            }
        });

        caiDatButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                moCaiDat();
            }
        });

        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = StartGame.font;
        textFieldStyle.fontColor = Color.BLACK;

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

        createCar();
        xulyngaydem();
        if ((float) Gdx.graphics.getWidth() / 2 - player.getWidth() / 2 <= player.getX() && player.getX() <= (float) (WINDOW_WIDTH - Gdx.graphics.getWidth() / 2) - player.getWidth() / 2) {
            stage.getCamera().position.x = player.getX() + player.getWidth() / 2;
        }else if((float) Gdx.graphics.getWidth() / 2 - player.getWidth() / 2 > player.getX()){
            stage.getCamera().position.x = Gdx.graphics.getWidth() / 2f;
        }else if(player.getX() > (float) (WINDOW_WIDTH - Gdx.graphics.getWidth() / 2) - player.getWidth() / 2){
            stage.getCamera().position.x = WINDOW_WIDTH - Gdx.graphics.getWidth() / 2f;
        }
        if ((float) Gdx.graphics.getHeight() / 2 - player.getHeight() / 2 <= player.getY() && player.getY() <= (800 - (float) Gdx.graphics.getHeight() / 2) - player.getHeight() / 2) {
            stage.getCamera().position.y = player.getY() + player.getHeight() / 2;
        }else if((float) Gdx.graphics.getHeight() / 2 - player.getHeight() / 2 > player.getY()){
            stage.getCamera().position.y = Gdx.graphics.getHeight() / 2f;
        }else if(player.getY() > (800 - (float) Gdx.graphics.getHeight() / 2) - player.getHeight() / 2){
            stage.getCamera().position.y = (800 - (float) Gdx.graphics.getHeight() / 2);
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

        if (Gdx.input.justTouched()) {
            Vector2 mouse = new Vector2();
            mouse.set(Gdx.input.getX(), Gdx.input.getY());
            stage.getViewport().unproject(mouse);

            cameraPosition.x = mouse.x;
            cameraPosition.y = mouse.y;

            if(Master.whatActionIfClickMouse.equals("planttree")){
                if(Master.amountSeed > 0 ) {
                   boolean isFree = true;
                   for(Rectangle rec : noPlaced){
                       if(rec.contains(mouse.x,mouse.y)){
                           isFree = false;
                           break;
                       }
                   }
                   if(isFree){
                       Master.amountSeed--;
                       new LoadingPlant(mouse.x-16,mouse.y,stage);
                   }
                }
            } else if(Master.whatActionIfClickMouse.equals("camera")){
                Master.nhapTenNormalCamera();
            } else {
                AnimationClickMouse animationClickMouse = new AnimationClickMouse(mouse.x-32,mouse.y-32, stage);
                clickSound.play();
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            String inputText = textField.getText();
            textField.setVisible(false);
            noMoveStage.unfocusAll();
            NormalCamera normalCamera = new NormalCamera(cameraPosition.x,cameraPosition.y,stage);
            normalCameras.add(normalCamera);
            normalCamera.name = inputText;
            whatActionIfClickMouse = "move";
        }

        stage.act();
        truck.toFront();
        stage.draw();
        noMoveStage.act();
        noMoveStage.draw();
        batch.begin();
        game.font.draw(batch, ""+amountSeed,Gdx.graphics.getWidth() - 50, Gdx.graphics.getHeight()-50);
        if(hienChiSo){
            game.font3.draw(batch, "Tiền: " + GameState.money,32*2, Gdx.graphics.getHeight()-32*3-(25+8));
            game.font3.draw(batch, "Năng lượng: " + GameState.ernegy,32*13, Gdx.graphics.getHeight()-32*3-(25+8));
            game.font3.draw(batch, "AQI: " + AQI,32*24, Gdx.graphics.getHeight()-32*3-(25+8));
            game.font3.draw(batch, "Hạt giống cây: " + amountSeed,32*2, 32*2);
            game.font3.draw(batch, "Gỗ: " + GameState.woods,32*23, 32*2);
        }
        if(hienThongTin){
            game.font3.draw(batch, "Sự kiện: " + GameState.event,32*2, Gdx.graphics.getHeight()-32*4-(25+8*2));
            game.font3.draw(batch, "Cảm xúc của người dân: " + GameState.camxucnguoidan,32*2, Gdx.graphics.getHeight()-32*5-(25+8*2));
            game.font3.draw(batch, "Lý do: " + GameState.lydocamxucnguoidan,32*2, Gdx.graphics.getHeight()-32*6-(25+8*2));
        }
        if(hienNghienCuu){
            game.font3.draw(batch, "Cấp độ máy lọc không khí: " + GameState.levelmaylockhongkhi,32*2, Gdx.graphics.getHeight()-32*4-(25+8*2));
            game.font4.draw(batch, "Nâng cấp máy lọc không khí",32*2, Gdx.graphics.getHeight()-32*5-(25+8*2)-16);
        }
        batch.end();
    }

    public static void nhapTenNormalCamera(){
        textField.setVisible(true);
        textField.setText(""); // Xóa nội dung cũ
        showAQI.getStage().setKeyboardFocus(textField);
    }
    private void xulyngaydem(){
        gio1phan60++;
        if(gio1phan60 == 60*22 || gio1phan60 == 60*22*2){
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    dark.toFront();
                    dark.addAction(Actions.fadeIn(2));
                }
            },0);
        }
        if(gio1phan60 == 60*24){
            day++;
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    dark.addAction(Actions.fadeOut(2));
                    dark.toBack();
                }
            },0);
        }
        if(gio1phan60 == 60*24*2){
            gio1phan60 = 0;
            day++;
            sukiensau2ngay();
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    dark.addAction(Actions.fadeOut(2));
                    dark.toBack();
                }
            },0);
        }
    }
    private void sukiensau2ngay(){
        new Tree(player.getX(),player.getY(),stage);
    }
    private void showBangScience(float x, float y){
        if(Math.abs(player.getX()-scienceDoor.getX())<32*6 && Math.abs(player.getY()-scienceDoor.getY()) < 32*6){
            bangScience.setPosition(x,y);
            bangScienceCross.setPosition(Gdx.graphics.getWidth()-32*2,Gdx.graphics.getHeight()-32*2);
            thongTinButton.setPosition(32*2+192*0-16,Gdx.graphics.getHeight()-32*2-64);
            nghienCuuButton.setPosition(32*3+192*1-16,Gdx.graphics.getHeight()-32*2-64);
            cheTaoButton.setPosition(32*4+192*2-16,Gdx.graphics.getHeight()-32*2-64);
            caiDatButton.setPosition(32*5+192*3-16,Gdx.graphics.getHeight()-32*2-64);
            line.setHeight(4);
            line2.setHeight(4);
            hienChiSo = true;

            bangScience.toFront();
            thongTinButton.toFront();
            nghienCuuButton.toFront();
            cheTaoButton.toFront();
            caiDatButton.toFront();
            bangScienceCross.toFront();
            line.toFront();
        }
    }
    private void dongThongtin(){
        lineThongTin.setHeight(0);
        hienThongTin = false;
    }
    private void dongNghienCuu(){
        hienNghienCuu = false;
        nangCapMLKK.setPosition(-1398,-10092);
    }
    private void moThongTin(){
        hienThongTin = true;
        dongNghienCuu();

        lineThongTin.setHeight(4);
    }
    private void moNghienCuu(){
        hienNghienCuu = true;
        nangCapMLKK.setPosition(32*2-21,Gdx.graphics.getHeight()-32*5-(25+8*2)-25-19-16);
        nangCapMLKK.toFront();
        dongThongtin();
    }
    private void moCheTao(){
        new Car(200,200,noMoveStage);
        dongThongtin();
        dongNghienCuu();
    }
    private void moCaiDat(){
        dongThongtin();
        dongNghienCuu();
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

//        CornerPool cornerPool = new CornerPool(32*5, 800 - 32 * 3, stage, "UL");
//        CornerPool cornerPool2 = new CornerPool(32 * 15, 800 - 32 * 3, stage, "UR");
        CornerPool cornerPool3 = new CornerPool(32*4, 800 - 32 * 9, stage, "DL");
        CornerPool cornerPool4 = new CornerPool(32 * 15, 800 - 32 * 9, stage, "DR");
//        for (int i = 0; i < 18; i++) {
//            WallPool wallPool = new WallPool(32 + 32 * i, 800 - 32 * 8, stage, 'U');
//        }
//        for (int i = 0; i < 15; i++) {
//            WallPool wallPool = new WallPool(32*5 + 32 * i, 800 - 32 * 8, stage, 'D');
//        }
        for (int i = 0; i < 10; i++) {
            WallPool wallPool = new WallPool(32*4, 800+32 - 32 * i, stage, 'L');
        }
        for (int i = 0; i < 10; i++) {
            WallPool wallPool = new WallPool(32 * 15, 800+32 - 32 * i, stage, 'R');
        }
        for (int y = 0; y < 10; y++) {
            for (int i = 0; i < 10; i++) {
                Water water = new Water(32*5 + 32 * i, 800 - 32 * y, stage);
            }
        }
        ////ScienceHouse scienceHouse = new ScienceHouse(32 * 13, 0, stage);
    }

    private void createCar() {
        if(gio1phan60%180 == 0){
            new Car(0,0,stage);//dat x,y cho hop ly vi Car extends MyActor chu vao trong car no dat lai
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
//        i = 0;
//        while (i < 21) {
//            Tree tree2 = new Tree(i * 32, 800 - 32 * 2, stage);
//            i += random.nextInt(2, 21);
//            trees.add(tree2);
//        }
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
        createRiver();
        new Boat(MathUtils.random(1190, 1230), MathUtils.random(0, 800), stage);
        new Boat(MathUtils.random(1190, 1230), MathUtils.random(0, 800), stage);
        new Boat(MathUtils.random(1190, 1230), MathUtils.random(0, 800), stage);
        new Boat(MathUtils.random(1190, 1230), MathUtils.random(0, 800), stage);
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
            new Hangraongang(xR, yR, stage,1);
            xR += 32 * 2;
        }

        float x = 1184 - 32;
        float y = WINDOW_HEIGHT - 32 * 7-32*7;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 12; j++) {
                new RoadWay(x, y, stage, true);
                x += 32;
            }
            new CrossWalk(x, y, stage, true);
            x += 32;
        }
        x = 1184 + 32 * 15;
        y = WINDOW_HEIGHT - 32 * 8 +8-32*7;
        for(int i = 0;i<4;i++){
            for (int j = -1; j < 5; j++) {
                new RoadWay(x, y, stage, false);
                createCrossWalk(j, x,y,false);
                y -= 32;
            }
        }

        x = 1184 ;
        y = WINDOW_HEIGHT - 32*11;
        for(int i = 0;i<3;i++){
            new Hangraongang(x,y,stage,2);
            x += 16*3-10;
        }
        x = 1184 ;
        y = WINDOW_HEIGHT - 32*14;
        for(int i = 0;i<3;i++){
            new Hangraongang(x,y,stage,2);
            x += 16*3-10;
        }
        createHouseRed3(1184+32*8,32*16);
        createHouseBlue3(1184+32*9,32*2);
        createHouseRed2(1184+32*11, 32*8);

        createHouseBlue2(1184+32*25,32*17);
        createHouseRed1(1184+32*20,32*7);
        createHouseBlue1(1184+32*16, 32*16);
        createHouseBlue1(1184+32*22, 32);
        creatCastle(1184+32*30,32*2);

        new People1(32*5+1184,32,stage,true);
        new People1(32*30+ 1184,48,stage,true );



        Corner corner2 = new Corner(1184 + 15 * 32, 800 / 2f + 48 + 4*32-7*32, stage, "UR");
        BlankRoad blankRoad2 = new BlankRoad(1184 + 16 * 32, 800 / 2f + 48 + 4*32-7*32, stage);
        Corner corner12 = new Corner(1184 + 17 * 32, 800 / 2f + 48 + 4*32-7*32, stage, "UL");
    }

    public void createGroundTown() {
        float x = 1184;
        float y = WINDOW_HEIGHT - 32*4;
            for (int i = 0; i < 10; i++) {
                new Ground2(x, y, stage);
                x += 32 * 3;
            }

        x = 1184;
        y = WINDOW_HEIGHT - 32 * 5;
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 40; j++) {
                int rand = MathUtils.random(1, 2);
                new Randomblock(x, y, stage, rand);
                x += 32;
            }
            x = 1184;
            y -= 32;
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

    public void createRiver(){
        new River(1178, 0, stage);
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

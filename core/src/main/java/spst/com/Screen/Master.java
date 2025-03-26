package spst.com.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import spst.com.*;
import spst.com.Button.*;
import spst.com.Button.ButtonLeft;
import spst.com.Button.ButtonRight;
import spst.com.Cameras.NormalCamera;
import spst.com.GroundOutRoads.CanhGround;
import spst.com.GroundOutRoads.GroundCenter;
import spst.com.GroundOutRoads.GroundCorner;
import spst.com.House.*;
import spst.com.Parking.LetterP;
import spst.com.Parking.RoadPiece;
import spst.com.Parking.RoundCorner;
//import spst.com.People.People;
import spst.com.People.*;
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
import spst.com.town.*;

import static com.badlogic.gdx.math.MathUtils.random;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Master implements Screen {
    public static SpriteBatch batch;
    OrthographicCamera camera;
    InputMultiplexer multiplexer;
    public static Stage stage;
    public static Stage noMoveStage;
    private Music nen = Gdx.audio.newMusic(Gdx.files.internal("nhacnen.mp3"));
    GlyphLayout layout = new GlyphLayout();


    public static River river;
    public static Blood blood;
    Replay replay;
    ThongTin thongTinButton;
    NghienCuu nghienCuuButton;
    WhiteButton nangCapMLKK;
    ButtonLeft buttonLeftMLKK;
    ButtonRight buttonRightMLKK;
    ButtonLeft cameraLookingLeft;
    ButtonRight cameraLookingRight;
    SelectCamera cameraLooking;
    WhiteButton nangCapCNX;
    WhiteButton nangCapGTX;
    CheTao cheTaoButton;
    CaiDat caiDatButton;
    public static Player player;
    PoolRec poolRec;
    BangScience bangScience;
    Cross bangScienceCross;
    MordernDoor scienceDoor;
    MordernDoor hotelDoor;

    FactoryCenter factoryCenter;
    HotelCenter hotelCenter;
    ScienceCenter scienceCenter;
    public static ShowAQI showAQI;
    public static boolean hienCheTao = false;

    Dark dark;
    Rain rain;
    Line line;
    Line line2;
    Line lineThongTin;
    ShapeRenderer shapeRenderer = new ShapeRenderer();
    Texture button = new Texture("buttonblank.png");
    TextButton bienButton ;
    TextButton plantButton;
    TextButton MLKKButton;
    TextButton factoryButton;
    TextButton energyButton;
    TextButton trafficButton;
    TextButton cameraButton;
    TextButton  turnOffMLKK;
    TextButton  turnOnMLKK;
    TextButton  turnOffFactory;
    TextButton  turnOnFactory;
    TextButton  turnOffTraffic;
    TextButton  turnOnTraffic;


    public static Array<Car> cars = new Array<>();
    public static Array<MyActor> roads = new Array<>();
    public static Array<Waste> wastes = new Array<>();
    public static Array<Tree> trees = new Array<>();
    public static Array<MayLoc> MLKKs = new Array<>();
    public static Array<Sign> signs = new Array<>();
    public static  Array<TruSo> truSos = new Array<>();
    public static  Array<Rectangle> noPlaced = new Array<>();
    public static float AQI = 180;
    public static char WLK = 'K';
    public static String whatActionIfClickMouse = "move";
    public  static int amountSeed = 0;
    public static int soBienCam = 0;
    public static int soMayLoc = 0;
    public static boolean isCNX = false;
    public static boolean isGTX = false;
    public static int soCamera = 0;
    public static int sohieucuaMLKKdangchondenangcap = 0;
    public static boolean isOpenSetting = false;
    final float WINDOW_WIDTH = 2400;
    final float WINDOW_HEIGHT = 800;

    public static int growth = 0;
    public static Array<Rice>rices ;
    public static Array<NormalCamera> normalCameras = new Array<>();
    public static int soCuaCameraDangLooking = 0;
    Truck truck;
    TreeButon treeButon;
    creatMayLoc taoMayLockk;
    creatCamera taoCamera;
    creatSign taoSign;
    SaveNut saveNut;
    float ktHetEvent = 2;
    boolean ktDangChayEvent = false;
    public static Waterwell gieng;
    public static boolean cutting = false;
    public static boolean mLKKAction = true;
    public static boolean factoryAction = true;
    public  static boolean trafficAction = true;
    int speedX = -2 ;
    int  luotcat = 1;
    public static boolean hienChiSo = false;
    public static boolean hienThongTin = false;
    public static boolean hienNghienCuu = false;
    public static Vector2 cameraPosition = new Vector2(1200 / 2, 800 / 2);
    public static int day = 0;
    public static int gio1phan60 = 0;
    public static TextField textField;
    private Sound clickSound = Gdx.audio.newSound(Gdx.files.internal("clicksound.ogg"));
    public static Sound collect = Gdx.audio.newSound(Gdx.files.internal("collect.mp3"));
    StartGame game;
    public static int timeOfDay = 0;

    public Master(StartGame game) {
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = StartGame.font3;
        style.fontColor = Color.RED;
        style.up = new TextureRegionDrawable(button);

        layout.width = 300;
        layout.height = 40;
        MLKKButton = new TextButton(" Mua một cái máy lọc không khí ", style);
        MLKKButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>=500&&GameState.ernegy>=20) {
                    Master.soMayLoc++;
                    GameState.money-=500;
                    GameState.ernegy-=20;
                }

            }
        });
        bienButton = new TextButton("Mua một biển cấm  ", style);
        bienButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>=300&&GameState.ernegy >=10&&GameState.greenscore >=5) {
                    GameState.greenscore  -= 5;
                    GameState.ernegy  -= 10;
                    GameState.money-=300;
                    Master.soBienCam++;
                }
            }
        });
        factoryButton = new TextButton("Tạo công nghệ xanh ", style);
        factoryButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money >= 1500 && GameState.ernegy >= 30 && GameState.greenscore >= 30){
                    isCNX = true;
                    factoryButton.setColor(Color.GRAY);
                    GameState.money -=1500;
                    GameState.ernegy -=30;
                    GameState.greenscore -=30;
                }
            }
        });
        trafficButton = new TextButton(" Tạo công trình giao thông xanh ", style);
        trafficButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money >= 1000 && GameState.ernegy >= 50 && GameState.greenscore >= 20){
                    isGTX = true;
                    trafficButton.setColor(Color.GRAY);
                    GameState.money -=1000;
                    GameState.ernegy -=50;
                    GameState.greenscore -=20;
                }
            }
        });
        plantButton = new TextButton("Mua một cây xanh", style);
        plantButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>=100&&GameState.greenscore  >=5) {
                    Master.amountSeed++;
                    GameState.greenscore -= 5;
                    GameState.money-=100;
                }
            }
        });

        cameraButton = new TextButton("Mua một cái camera ", style);
        cameraButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money >=300&&GameState.ernegy >=5){
                    soCamera++;
                    GameState.money-=300;
                    GameState.ernegy-=5;
                }
            }
        });

        energyButton = new TextButton("Mua 100 năng  lượng ", style);
        energyButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>=75) {
                    GameState.ernegy+= 100;
                    GameState.money-=75;
                }
            }
        });

        turnOffMLKK = new TextButton(" Tắt máy lọc không khí  ", style);
        turnOffMLKK.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                mLKKAction = true;
            }
        });

        turnOnMLKK = new TextButton(" Bật máy lọc không khí  ", style);
        turnOnMLKK.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                mLKKAction = false;
            }
        });

        turnOffFactory = new TextButton(" Tắt công nghệ sản xuất xanh  ", style);
        turnOffFactory.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                factoryAction = true;
            }
        });

        turnOnFactory = new TextButton(" Bật công nghệ sản xuất xanh ", style);
        turnOnFactory.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                factoryAction = false;
            }
        });

        turnOffTraffic = new TextButton(" Tắt hệ thống giao thông xanh", style);
        turnOffTraffic.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                trafficAction = true;
            }
        });

        turnOnTraffic = new TextButton(" Bật hệ thống giao thông xanh ", style);
        turnOnTraffic.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                trafficAction = false;
            }
        });


        this.game = game;

        batch = new SpriteBatch();
        multiplexer = new InputMultiplexer();
        stage = new Stage();
        noMoveStage = new Stage();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(noMoveStage);
        camera = new OrthographicCamera();
        camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        replay = new Replay(-10080,-32760,noMoveStage);
        thongTinButton = new ThongTin(-1000,-1000,noMoveStage);
        nghienCuuButton = new NghienCuu(-1000,-1000,noMoveStage);
        nangCapMLKK = new WhiteButton(-1000,-1000,noMoveStage);
        nangCapMLKK.setHeight(nangCapMLKK.getHeight()*2);
        buttonLeftMLKK = new ButtonLeft(-1000,-1000,noMoveStage);
        buttonRightMLKK = new ButtonRight(-1000,-1000,noMoveStage);
        nangCapCNX = new WhiteButton(-1000,-1000,noMoveStage);
        nangCapGTX = new WhiteButton(-1000,-1000,noMoveStage);
        cheTaoButton = new CheTao(-1000,-1000,noMoveStage);
        caiDatButton = new CaiDat(-1000,-1000,noMoveStage);
       // nutMayLoc = new creatMayLoc(-1000,-1000,noMoveStage);

        cameraLookingLeft = new ButtonLeft(400,Gdx.graphics.getHeight()-100,noMoveStage);
        cameraLooking = new SelectCamera(400+26,Gdx.graphics.getHeight()-100,noMoveStage);
        cameraLookingRight = new ButtonRight(400+26+80,Gdx.graphics.getHeight()-100,noMoveStage);

        poolRec = new PoolRec(0, 32 * 17, stage);
        rices = new Array();
        generateMap();
        generateMap2();
        truck = new Truck(32*33+1184,800 - 32*3, stage);
        gieng = new Waterwell(1184+32*27,32*6,stage);
        treeButon = new TreeButon(Gdx.graphics.getWidth()-100-32,Gdx.graphics.getHeight()-100,noMoveStage);
        taoMayLockk = new creatMayLoc(Gdx.graphics.getWidth()-200-32,Gdx.graphics.getHeight()-100,noMoveStage);
        taoCamera = new creatCamera(Gdx.graphics.getWidth()-300-32,Gdx.graphics.getHeight()-100,noMoveStage);
        taoSign = new creatSign(Gdx.graphics.getWidth()-400-32,Gdx.graphics.getHeight()-100,noMoveStage);
        saveNut = new SaveNut(Gdx.graphics.getWidth()-32,Gdx.graphics.getHeight()-32,noMoveStage);

        createTree();
        createWaste();
        createHouses();

        new ThapRua(32*9+8,800/2+48+32*6+8,stage);
        player = new Player(1200 / 2, 800 / 2, stage);

        bangScience = new BangScience(-10000,-100,noMoveStage);
        bangScienceCross = new Cross(-10000,-100,noMoveStage);
        dark = new Dark(0,0,noMoveStage);
        dark.setTouchable(Touchable.disabled);
        line = new Line(32,Gdx.graphics.getHeight()-32*5-4,896,0,noMoveStage);
        line2 = new Line(32,32*2+8,896,0,noMoveStage);
        lineThongTin = new Line(32,Gdx.graphics.getHeight()-32*7-4,896,0,noMoveStage);
        showAQI = new ShowAQI(0,0,noMoveStage);
        showAQI.setPosition(0,Gdx.graphics.getHeight()-showAQI.getHeight());
        Rectangle rectangle = new Rectangle(21*32,15*32,32*3,32*10);
        noPlaced.add(rectangle);
        Rectangle rectangle1 = new Rectangle(0, 11*32,80*32,32*3);
        noPlaced.add(rectangle1);
        Rectangle rectangle2 = new Rectangle(9*32,0,3*32,32*10);
        noPlaced.add(rectangle2);
        Rectangle rectangle3 = new Rectangle(25*32,0,3*32,32*10);
        noPlaced.add(rectangle3);
        Rectangle rectangle4 = new Rectangle(37*32,0,3*32,32*10);
        noPlaced.add(rectangle4);
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
                closeScienceBoard();
            }
        });

        replay.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                WLK = 'K';
                GameState.reset();
                game.setScreen(game.menuScreen);
            }
        });

        thongTinButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                dongCheTao();
                isOpenSetting = false;
                dongCaiDat();
                moThongTin();
            }
        });

        nghienCuuButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {

                dongCheTao();
                isOpenSetting = false;
                dongCaiDat();
                moNghienCuu();

            }
        });

        nangCapMLKK.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money >= 1000 && GameState.ernegy >= 5){
                    try{
                        MLKKs.get(sohieucuaMLKKdangchondenangcap).level++;
                        GameState.money -= 1000;
                        GameState.ernegy -= 5;
                    }catch (Exception ignored){}
                }
            }
        });
        buttonLeftMLKK.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(sohieucuaMLKKdangchondenangcap>0){
                    sohieucuaMLKKdangchondenangcap--;
                }
            }
        });
        buttonRightMLKK.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(MLKKs.size >= sohieucuaMLKKdangchondenangcap+1){
                    sohieucuaMLKKdangchondenangcap++;
                }
            }
        });

        nangCapCNX.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(isCNX && GameState.money >= 1500 && GameState.ernegy >= 30 && GameState.greenscore >= 30){
                    GameState.levelcongnghexanh++;
                    GameState.money -= 1500;
                    GameState.ernegy -= 30;
                    GameState.greenscore -= 30;
                }
            }
        });

        cameraLookingLeft.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(soCuaCameraDangLooking>0){
                    soCuaCameraDangLooking--;
                }
            }
        });

        cameraLookingRight.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(soCuaCameraDangLooking+1<normalCameras.size){
                    soCuaCameraDangLooking++;
                }
            }
        });

        cheTaoButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                isOpenSetting = false;
                dongCaiDat();
                moCheTao();
            }
        });
        try {
            cameraLooking.addListener(new ClickListener() {
                public void clicked(InputEvent event, float x, float y) {
                    try{
                        NormalCamera currentCamera = normalCameras.get(soCuaCameraDangLooking);
                        OrthographicCamera camera = (OrthographicCamera) stage.getViewport().getCamera();
                        if(camera.zoom == 1f) {
                            camera.zoom = 0.3f;
                            if (currentCamera.getX() <= Gdx.graphics.getWidth() / 2f) {
                                stage.getCamera().position.x = Gdx.graphics.getWidth() / 2f;
                            } else {
                                stage.getCamera().position.x = currentCamera.getX() + currentCamera.getWidth() / 2f;
                            }
                            if (currentCamera.getY() <= Gdx.graphics.getHeight() / 2f) {
                                stage.getCamera().position.y = Gdx.graphics.getHeight() / 2f;
                            } else {
                                stage.getCamera().position.y = currentCamera.getY() + currentCamera.getHeight() / 2f;
                            }
                        } else {
                            camera.zoom = 1f;
                        }

                    }catch (Exception ignored){}
                    System.out.println("654321");

                }
            });
        }catch (Exception ignored) {
            System.out.println(soCuaCameraDangLooking);
            System.out.println("123456");
        }

        caiDatButton.addListener(new ClickListener() {

            public void clicked(InputEvent event, float x, float y) {

                dongCheTao();
                moCaiDat();
            }
        });



        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = StartGame.font;
        textFieldStyle.fontColor = Color.BLACK;

        textFieldStyle.background = new TextureRegionDrawable(new Texture("input.png"));

        // Tạo TextField
        textField = new TextField("", textFieldStyle);
        textField.setSize(220, 50);
        textField.setPosition(220, 6); // Vị trí giữa màn hình
        textField.setVisible(false);

        noMoveStage.addActor(textField);

        Gdx.input.setInputProcessor(multiplexer);

        MenuScreen.nen.stop();
        nen.isLooping();
        nen.play();
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.GRAY);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        if(Gdx.input.isTouched()){
            System.out.println("x = " + Gdx.input.getX()/32 + " y = " + (Gdx.graphics.getHeight()/32 - Gdx.input.getY()/32));
        }

        tinhThangThua();
        tanggiamdanso();
        taoChatCay();
        xuLyCNXVaGTX();
        ktHetEven();
        calculAQI();
        createCar();
        xulyngaydem();
        OrthographicCamera c = (OrthographicCamera) stage.getViewport().getCamera();
        if(c.zoom == 1f) {
            if ((float) Gdx.graphics.getWidth() / 2 - player.getWidth() / 2 <= player.getX() && player.getX() <= (float) (WINDOW_WIDTH - Gdx.graphics.getWidth() / 2) - player.getWidth() / 2) {
                stage.getCamera().position.x = player.getX() + player.getWidth() / 2;
            } else if ((float) Gdx.graphics.getWidth() / 2 - player.getWidth() / 2 > player.getX()) {
                stage.getCamera().position.x = Gdx.graphics.getWidth() / 2f;
            } else if (player.getX() > (float) (WINDOW_WIDTH - Gdx.graphics.getWidth() / 2) - player.getWidth() / 2) {
                stage.getCamera().position.x = WINDOW_WIDTH - Gdx.graphics.getWidth() / 2f;
            }
            if ((float) Gdx.graphics.getHeight() / 2 - player.getHeight() / 2 <= player.getY() && player.getY() <= (800 - (float) Gdx.graphics.getHeight() / 2) - player.getHeight() / 2) {
                stage.getCamera().position.y = player.getY() + player.getHeight() / 2;
            } else if ((float) Gdx.graphics.getHeight() / 2 - player.getHeight() / 2 > player.getY()) {
                stage.getCamera().position.y = Gdx.graphics.getHeight() / 2f;
            } else if (player.getY() > (800 - (float) Gdx.graphics.getHeight() / 2) - player.getHeight() / 2) {
                stage.getCamera().position.y = (800 - (float) Gdx.graphics.getHeight() / 2);
            }
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
            if (truck.getX() < 1184+32*4) {
                truck.setScaleX(1);
                speedX = 2;
                luotcat = 2;
            }
            if (truck.getX() > 32 * 33+1184) {
                cutting = false;
                truck.setX(32 * 33+1184);
                luotcat = 1;
                float xR = 1184+32*4;
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
                    xR = 1184+32*4;
                    yR -= 32;
                }

            }
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
                       GameState.greenscore += 10;
                       new LoadingPlant(mouse.x-16,mouse.y,stage);
                   }
                }
            } else if (Master.whatActionIfClickMouse.equals("createMayLoc")) {
                if(Master.soMayLoc > 0 ) {
                    boolean isFree = true;
                    for(Rectangle rec : noPlaced){
                        if(rec.contains(mouse.x,mouse.y)){
                            isFree = false;
                            break;
                        }
                    }
                    if(isFree){
                        Master.nhapTenMLKK();
                    }
                }else{
                    Master.whatActionIfClickMouse = "move";
                }
            } else if(Master.whatActionIfClickMouse.equals("camera")){
                if(soCamera >0 ){
                    Master.nhapTenNormalCamera();
                }else{
                    Master.whatActionIfClickMouse = "move";
                }
            } else if(Master.whatActionIfClickMouse.equals("createSign")){
                if(Master.soBienCam > 0 ) {
                    boolean isFree = true;
                    for(Rectangle rec : noPlaced){
                        if(rec.contains(mouse.x,mouse.y)){
                            isFree = false;
                            break;
                        }
                    }
                    if(isFree){
                        Master.soBienCam--;
                        new Sign(mouse.x-16,mouse.y,random.nextBoolean(),stage);
                    }
                }
            }else {
                new AnimationClickMouse(cameraPosition.x - 32, cameraPosition.y - 32, stage);
                clickSound.play();
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            if(Master.whatActionIfClickMouse.equals("createMayLoc") && soMayLoc >0){
                String inputText = textField.getText();
                textField.setVisible(false);
                noMoveStage.unfocusAll();
                Master.soMayLoc--;
                MayLoc mayLoc = new MayLoc(cameraPosition.x,cameraPosition.y,stage,27*2,47*2);
                MLKKs.add(mayLoc);
                mayLoc.name = inputText;
                whatActionIfClickMouse = "move";
                System.out.println("243287");
                taoMayLockk.isSong = true;
            }else if(Master.whatActionIfClickMouse.equals("camera") && soCamera >0){
                String inputText = textField.getText();
                textField.setVisible(false);
                noMoveStage.unfocusAll();
                Master.soCamera--;
                NormalCamera normalCamera = new NormalCamera(cameraPosition.x,cameraPosition.y,stage);
                normalCameras.add(normalCamera);
                normalCamera.name = inputText;
                whatActionIfClickMouse = "move";
                taoCamera.isSong = true;
            }
        }

        if(isOpenSetting){
            if(mLKKAction){
                turnOffMLKK.remove();
                turnOnMLKK.setPosition(Gdx.graphics.getWidth() * 0.07f, Gdx.graphics.getHeight() * 0.6f-40);
                turnOnMLKK.setSize(600, 80);
                noMoveStage.addActor(turnOnMLKK);
                turnOnMLKK.toFront();
            }else if (!mLKKAction){
                turnOnMLKK.remove();
                turnOffMLKK.setPosition(Gdx.graphics.getWidth() * 0.07f, Gdx.graphics.getHeight() * 0.6f-40);
                turnOffMLKK.setSize(600, 80);
                noMoveStage.addActor(turnOffMLKK);
                turnOffMLKK.toFront();
            }
            if(factoryAction){
                turnOffFactory.remove();
                turnOnFactory.setPosition(Gdx.graphics.getWidth() * 0.07f, Gdx.graphics.getHeight() * 0.6f-40-80);
                turnOnFactory.setSize(600, 80);
                noMoveStage.addActor(turnOnFactory);
                turnOnFactory.toFront();
            }else if (!factoryAction){
                turnOnFactory.remove();
                turnOffFactory.setPosition(Gdx.graphics.getWidth() * 0.07f, Gdx.graphics.getHeight() * 0.6f-40-80);
                turnOffFactory.setSize(600, 80);
                noMoveStage.addActor(turnOffFactory);
                turnOffFactory.toFront();
            }
            if(trafficAction){
                turnOffTraffic.remove();
                turnOnTraffic.setPosition(Gdx.graphics.getWidth() * 0.07f, Gdx.graphics.getHeight() * 0.6f-40-80*2);
                turnOnTraffic.setSize(600, 80);
                noMoveStage.addActor(turnOnTraffic);
                turnOnTraffic.toFront();
            }else if (!trafficAction){
                turnOnTraffic.remove();
                turnOffTraffic.setPosition(Gdx.graphics.getWidth() * 0.07f, Gdx.graphics.getHeight() * 0.6f-40-80*2);
                turnOffTraffic.setSize(600, 80);
                noMoveStage.addActor(turnOffTraffic);
                turnOffTraffic.toFront();
            }
        }
        if(player.getBound().overlaps(scienceCenter.getBound())){
            if(player.getY()<scienceCenter.getY()){
                player.toFront();
                if(player.getY() > scienceCenter.getY()-5){
                    player.setY(scienceCenter.getY()-5);
                }
            }else {
                scienceCenter.toFront();
                scienceDoor.toFront();
                if(player.getY() < scienceCenter.getY()+10){
                    player.setY(scienceCenter.getY()+10);
                }
            }
        }
        if(player.getBound().overlaps(hotelCenter.getBound())){
            if(player.getY()<hotelCenter.getY()){
                player.toFront();
                if(player.getY() > hotelCenter.getY()-5){
                    player.setY(hotelCenter.getY()-5);
                }
            }else {
                hotelCenter.toFront();
                hotelDoor.toFront();
                if(player.getY() < hotelCenter.getY()+10){
                    player.setY(hotelCenter.getY()+10);
                }
            }
        }
        if(player.getBound().overlaps(factoryCenter.getBound())){
            if(player.getY()<factoryCenter.getY()){
                player.toFront();
                if(player.getY() > factoryCenter.getY()-5){
                    player.setY(factoryCenter.getY()-5);
                }
            }else {
                factoryCenter.toFront();
                if(player.getY() < factoryCenter.getY()+10){
                    player.setY(factoryCenter.getY()+10);
                }
            }
        }
        for(Car car : cars) {
            if(player.getBound().overlaps(car.getBound())){
                if(player.getY()<car.getY()){
                    player.toFront();
                    if(player.getY() > car.getY()-5){
                        player.setY(car.getY()-5);
                    }
                }else {
                    car.toFront();
                    if(player.getY() < car.getY()+10){
                        player.setY(car.getY()+10);
                    }
                }
            }
        }
        for(TruSo x : truSos){
            if(player.getBound().overlaps(x.getBound())){
                if(player.getY()<x.getY()){
                    player.toFront();
                    if(player.getY() > x.getY()-5){
                        player.setY(x.getY()-5);
                    }
                }else {
                    x.toFront();
                    if(player.getY() < x.getY()+10){
                        player.setY(x.getY()+10);
                    }
                }
            }
        }
        stage.act();
        truck.toFront();
        stage.draw();
        vietChuNen();
        noMoveStage.draw();
        noMoveStage.act();
        vietChuBangScience();
    }

    private void vietChuNen(){
        if(this.dark.getColor().a == 0) {
            batch.begin();
            try {
                layout.setText(game.font3, "Camera: " + normalCameras.get(soCuaCameraDangLooking).name);
            } catch (Exception e) {
                layout.setText(game.font3, "Chưa có camera");
            }
            game.font.draw(batch, "" + amountSeed, Gdx.graphics.getWidth() - 50, Gdx.graphics.getHeight() - 50);
            game.font.draw(batch, "" + soMayLoc, Gdx.graphics.getWidth() - 50 - 100, Gdx.graphics.getHeight() - 50);
            game.font.draw(batch, "" + soCamera, Gdx.graphics.getWidth() - 50 - 200, Gdx.graphics.getHeight() - 50);
            game.font.draw(batch, "" + soBienCam, Gdx.graphics.getWidth() - 50 - 300, Gdx.graphics.getHeight() - 50);
            game.font.draw(batch, String.valueOf(Math.round(AQI)), 0, Gdx.graphics.getHeight() - 20);
            game.font3.draw(batch, layout, 466 - layout.width / 2f, Gdx.graphics.getHeight() - 100);
            batch.end();
        }
    }
    private void vietChuBangScience(){
        batch.begin();
        if(hienChiSo){
            game.font3.draw(batch, "Tiền: " + GameState.money,32*2, Gdx.graphics.getHeight()-32*3-(25+8));
            game.font3.draw(batch, "Năng lượng: " + GameState.ernegy,32*12, Gdx.graphics.getHeight()-32*3-(25+8));
            game.font3.draw(batch, "Điểm xanh: " + GameState.greenscore,32*22, Gdx.graphics.getHeight()-32*3-(25+8));
            game.font3.draw(batch, "Dân số: " + GameState.danso,32*2, 32*2);
            game.font3.draw(batch, "Xu hướng người dân: " + GameState.xuhuongdantangorgiam,32*16, 32*2);
        }
        if(hienThongTin){
            game.font3.draw(batch, "AQI của SO2: " + Math.round(GameState.AQISO2),32*2, Gdx.graphics.getHeight()-32*4-(25+8*2));
            game.font3.draw(batch, "AQI của CO1: " + Math.round(GameState.AQICO1),32*2, Gdx.graphics.getHeight()-32*5-(25+8*2));
            game.font3.draw(batch, "AQI của NO2: " + Math.round(GameState.AQINO2),32*11, Gdx.graphics.getHeight()-32*4-(25+8*2));
            game.font3.draw(batch, "AQI của O3: " + Math.round(GameState.AQIO3),32*11, Gdx.graphics.getHeight()-32*5-(25+8*2));
            game.font3.draw(batch, "AQI của PM2.5: " + Math.round(GameState.AQIPM2_5),32*20, Gdx.graphics.getHeight()-32*4-(25+8*2));
            game.font3.draw(batch, "AQI của PM10: " + Math.round(GameState.AQIPM10),32*20, Gdx.graphics.getHeight()-32*5-(25+8*2));
            game.font3.draw(batch, "Sự kiện: " + GameState.event,32*2, Gdx.graphics.getHeight()-32*6-(25+8*2));
            game.font3.draw(batch, "Cảm xúc của người dân: " + GameState.camxucnguoidan,32*2, Gdx.graphics.getHeight()-32*7-(25+8*2));
            game.font3.draw(batch, "Lý do: " + GameState.lydocamxucnguoidan,32*2, Gdx.graphics.getHeight()-32*8-(25+8*2));
        }
        if(hienNghienCuu){
            try {
                game.font3.draw(batch, "Cấp độ máy lọc không khí: " + MLKKs.get(sohieucuaMLKKdangchondenangcap).level,32*9, Gdx.graphics.getHeight()-32*4-(25+8*2));
                game.font4.draw(batch, "Nâng cấp máy lọc không khí",32*9, Gdx.graphics.getHeight()-32*5-(25+8*2)-16);
                game.font4.draw(batch, "Tên máy lọc không khí:", 32 * 9, Gdx.graphics.getHeight() - 32 * 6 - (25 + 8 * 2) - 16);
                game.font4.draw(batch, MLKKs.get(sohieucuaMLKKdangchondenangcap).name, 32 * 9, Gdx.graphics.getHeight() - 32 * 7 - (25 + 8 * 2) - 16);
                game.font5.draw(batch, "1000 money, 5 energy", 32 * 20, Gdx.graphics.getHeight() - 32 * 5.5f - (25 + 8 * 2) - 16 - 32);
            }catch(Exception e) {
                game.font4.draw(batch, "Chưa có máy lọc không khí", 32 * 9, Gdx.graphics.getHeight() - 32 * 5.5f - (25 + 8 * 2) - 16);
            }
            game.font3.draw(batch, "Cấp độ công nghệ xanh: " + GameState.levelcongnghexanh,32*17, Gdx.graphics.getHeight()-32*8-(25+8*2)-16*2);
            game.font4.draw(batch, "Nâng cấp công nghệ xanh",32*17, Gdx.graphics.getHeight()-32*9-(25+8*2)-16*3);
            if(isCNX) {
                game.font5.draw(batch, "1500 money, 30 ernegy",32*16, Gdx.graphics.getHeight()-32*9-(25+8*2)-16*5-10);
                game.font5.draw(batch, "30 greenscore",32*16, Gdx.graphics.getHeight()-32*9-(25+8*2)-16*5-25-10);
            }
            game.font3.draw(batch, "Cấp độ giao thông xanh: " + GameState.levelgiaothongxanh,32*2, Gdx.graphics.getHeight()-32*8-(25+8*2)-16*2);
            game.font4.draw(batch, "Nâng cấp giao thông xanh",32*2, Gdx.graphics.getHeight()-32*9-(25+8*2)-16*3);
            if(isGTX) {
                game.font5.draw(batch, "1000 money, 50 ernegy",32*2, Gdx.graphics.getHeight()-32*9-(25+8*2)-16*5-10);
                game.font5.draw(batch, "20 greenscore",32*2, Gdx.graphics.getHeight()-32*9-(25+8*2)-16*5-25-10);
            }
        }
        if(hienCheTao){
            game.font5.draw(batch, "500 money, 5 energy",32*20+10,Gdx.graphics.getHeight() * 0.6f+50-12.5f-10);
            game.font5.draw(batch, "300 money,10 energy",32*20+10, Gdx.graphics.getHeight() * 0.6f+0);
            game.font5.draw(batch, "5 green score",32*20+10, Gdx.graphics.getHeight() * 0.6f+0-20);
            game.font5.draw(batch, "300 money, 5 energy",32*20+10, Gdx.graphics.getHeight() * 0.6f-50-12.5f+10);
            game.font5.draw(batch, "100 money, 5 green score",32*20+10, Gdx.graphics.getHeight() * 0.6f-50*2+5);
            game.font5.draw(batch, "75 money",32*20+10, Gdx.graphics.getHeight() * 0.6f-50*2-30);
            game.font5.draw(batch, "1500 money, 30 energy",32*20+10, Gdx.graphics.getHeight() * 0.6f-50*3-10);
            game.font5.draw(batch, "30 green score",32*20+10, Gdx.graphics.getHeight() * 0.6f-50*3-20-10);
            game.font5.draw(batch, "1000 money, 50 energy",32*20+10, Gdx.graphics.getHeight() * 0.6f-50*4);
            game.font5.draw(batch, "20 green score",32*20+10, Gdx.graphics.getHeight() * 0.6f-50*4-20);
        }
        batch.end();
    }
    private void xuLyCNXVaGTX(){
        //xu ly CNX
        if(GameState.ernegy >= 10 && factoryAction) {
            if (GameState.SO2 >= 10 * GameState.levelcongnghexanh / 60f) {
                GameState.SO2 -= 10 * GameState.levelcongnghexanh / 60f;
            } else {
                GameState.SO2 = 0;
            }
            if (GameState.CO1 >= 8 * GameState.levelcongnghexanh / 60f) {
                GameState.CO1 -= 8 * GameState.levelcongnghexanh / 60f;
            } else {
                GameState.CO1 = 0;
            }
        }
        if (timeOfDay %120 == 0 && GameState.ernegy >= 10 && factoryAction && isCNX){
            GameState.ernegy -= 10;
        }
        if(!isCNX){
            nangCapCNX.setColor(Color.GRAY);
        }else {
            nangCapCNX.setColor(1,1,1,1);
        }
        //xu ly GTX
        if(GameState.ernegy >= 15 && trafficAction) {
            if (GameState.SO2 >= 8 * GameState.levelgiaothongxanh / 60f) {
                GameState.SO2 -= 8 * GameState.levelgiaothongxanh / 60f;
            } else {
                GameState.SO2 = 0;
            }
            if (GameState.CO1 >= 6 * GameState.levelgiaothongxanh / 60f) {
                GameState.CO1 -= 6 * GameState.levelgiaothongxanh / 60f;
            } else {
                GameState.CO1 = 0;
            }
        }
        if(GameState.ernegy >= 15 && trafficAction&& timeOfDay%120 == 0 && isGTX){
            GameState.ernegy -= 15;
        }
        if(!isGTX){
            nangCapGTX.setColor(Color.GRAY);
        }else {
            nangCapGTX.setColor(1,1,1,1);
        }
    }
    private void ktHetEven(){
        if(!GameState.event.isEmpty() && !ktDangChayEvent){
            ktHetEvent = 0;
            ktDangChayEvent = true;
        }
        if(ktDangChayEvent){
            ktHetEvent++;
        }
        if(!GameState.event.isEmpty() && ktHetEvent==60 && ktDangChayEvent){
            ktDangChayEvent = false;
            GameState.event = "";
        }
    }
    public static void nhapTenNormalCamera(){
        textField.setVisible(true);
        textField.setText(""); // Xóa nội dung cũ
        showAQI.getStage().setKeyboardFocus(textField);
    }
    public static void nhapTenMLKK(){
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
            GameState.money += GameState.danso/20/30;
            GameState.ernegy += 80;

            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    closeScienceBoard();
                    dark.addAction(Actions.fadeOut(2));
                   dark.toBack();
                }
            },0);
        }
        if(gio1phan60 == 60*24*2){
            gio1phan60 = 0;
            day++;
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    dark.addAction(Actions.fadeOut(2));
                    dark.toBack();
                }
            },0);
        }
    }
    private void showBangScience(float x, float y){
        if(!hienChiSo&&Math.abs(player.getX()-scienceDoor.getX())<32*6 && Math.abs(player.getY()-scienceDoor.getY()) < 32*6){
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

        dongCheTao();
        isOpenSetting = false;
        dongCaiDat();
        lineThongTin.setHeight(0);
        hienThongTin = false;
    }
    private void dongNghienCuu(){
        hienNghienCuu = false;
        nangCapMLKK.setPosition(-1398,-10092);
        buttonLeftMLKK.setPosition(-1398,-10092);
        buttonRightMLKK.setPosition(-1398,-10092);
        nangCapCNX.setPosition(-1398,-10092);
        nangCapGTX.setPosition(-1398,-10092);
    }
    private void moThongTin(){
        hienThongTin = true;
        dongNghienCuu();

        lineThongTin.setHeight(4);
    }

    private void moNghienCuu(){
        hienNghienCuu = true;
        nangCapMLKK.setPosition(32*9-21,Gdx.graphics.getHeight()-32*7-(25+8*2)-25-19-16);
        buttonLeftMLKK.setPosition(32*9-21-26-10,Gdx.graphics.getHeight()-32*5-(25+8*2)-25-19-16+10);
        buttonRightMLKK.setPosition(32*9-21+370+10,Gdx.graphics.getHeight()-32*5-(25+8*2)-25-19-16+10);
        nangCapCNX.setPosition(32*17-30,Gdx.graphics.getHeight()-32*9-(25+8*2)-25-19-16*3);
        nangCapGTX.setPosition(32*2-30,Gdx.graphics.getHeight()-32*9-(25+8*2)-25-19-16*3);
        nangCapMLKK.toFront();
        buttonLeftMLKK.toFront();
        buttonRightMLKK.toFront();
        nangCapCNX.toFront();
        nangCapGTX.toFront();
        dongThongtin();
    }

    private void muaPhuBay(){
        rain.toFront();
        rain.addAction(Actions.fadeIn(10));
    }
    private void moCheTao(){
//        nutMayLoc.setPosition(Gdx.graphics.getWidth()*0.2f, Gdx.graphics.getHeight()*0.8f);
//        nutMayLoc.toFront();
        dongThongtin();
        dongNghienCuu();
        hienCheTao = true;

        MLKKButton.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.6f);
        MLKKButton.setSize(600, 40);
        noMoveStage.addActor(MLKKButton);
        MLKKButton.toFront();



        bienButton.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.6f-40);
        bienButton.setSize(600, 40);
        noMoveStage.addActor(bienButton);
        bienButton.toFront();



        cameraButton.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.6f - 40*2);
        cameraButton.setSize(600, 40);
        noMoveStage.addActor(cameraButton);
        cameraButton.toFront();

        plantButton.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.6f - 40*3);
        plantButton.setSize(600, 40);
        noMoveStage.addActor(plantButton);
        plantButton.toFront();

        energyButton.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.6f - 40*4);
        energyButton.setSize(600, 40);
        noMoveStage.addActor(energyButton);
        energyButton.toFront();


        factoryButton.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.6f - 40*5);
        factoryButton.setSize(600, 40);
        noMoveStage.addActor(factoryButton);
        factoryButton.toFront();

        trafficButton.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.6f - 40*6);
        trafficButton.setSize(600, 40);
        noMoveStage.addActor(trafficButton);
        trafficButton.toFront();
    }

    public void dongCheTao(){
        MLKKButton.remove();
        cameraButton.remove();
        factoryButton.remove();
        plantButton.remove();
        trafficButton.remove();
        bienButton.remove();
        energyButton.remove();
        hienCheTao = false;
    }
    public void dongCaiDat(){
       turnOffMLKK.remove();
       turnOffFactory.remove();
       turnOffTraffic.remove();
       turnOnFactory.remove();
       turnOnMLKK.remove();
       turnOnTraffic.remove();
    }
    private void moCaiDat(){
        dongThongtin();
        dongNghienCuu();
        isOpenSetting = true;


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
    }

    private void tinhThangThua(){
        if(AQI>300 && WLK == 'K'){
            GameState.event = "YOU LOSE";
            new FloatingNews(random.nextInt(0,32*75)
                ,random.nextInt(0,800)
                , stage,"YOU LOSE"
                ,new Color(random.nextFloat(0,1),random.nextFloat(0,1)
                ,random.nextFloat(0,1),random.nextFloat(0,1)));
            WLK = 'L';
        }
        if(WLK == 'L'){
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    dark.toFront();
                    dark.setColor(0,0,0,0f);
                    if(WLK == 'L'){
                        Timer.schedule(new Timer.Task() {
                            @Override
                            public void run() {
                                dark.toFront();
                                dark.setColor(0,0,0,0f);
                                new Piece(0,0,noMoveStage).toFront();
                                new FloatingNews(random.nextInt(0,Gdx.graphics.getWidth()),random.nextInt(0,Gdx.graphics.getHeight()),noMoveStage ,"LOSE",Color.RED).toFront();
                                replay.setPosition(Gdx.graphics.getWidth()/2f-replay.getWidth()/2f,Gdx.graphics.getHeight()/2f-replay.getHeight()/2f);
                                replay.toFront();
                            }
                        },2);
                    }
                }
            },2);
        }
        if(AQI<100 && GameState.danso<=100000 && WLK == 'K'){
            dark.toFront();
            dark.setColor(0,0,0,1);
            WLK = 'W';
        }
        if(WLK == 'W'){
            dark = new Dark(0,0,noMoveStage);
            new FloatingNews(random.nextInt(0,Gdx.graphics.getWidth()),random.nextInt(0,Gdx.graphics.getHeight()),noMoveStage ,"WIN",Color.GREEN).toFront();
            player.toFront();
            camera.position.x = 480;
            camera.position.y = 270;
            player.setX(480);
            player.setY(270);
        }
    }
    private void calculAQI(){
        timeOfDay++;
        int hour = 0;
        if(timeOfDay%60 == 0){
            hour = timeOfDay / 60;
            hour = hour%24;
            if(hour == 6) {
                GameState.CO1 += 15;
                GameState.NO2 += 20;
            } else if(hour == 7) {
                GameState.CO1 += 15;
                GameState.NO2 += 20;
            } else if(hour == 8) {
                GameState.CO1 += 35;
                GameState.NO2 += 25;
            } else if(hour == 9) {
                int ran = random.nextInt(1,100);
                switch (ran){
                    case 1, 3,5,7,10,11,23,99,45 -> {
                        System.out.println("tai nan giao thong !!!");
                        GameState.event = "Tai nạn giao thông";
                        GameState.NO2 += 30;
                        GameState.CO1 += 20;
                        GameState.danso--;
                        new FloatingNews(0,500,noMoveStage,"Tai nạn giao thông chết 1 người",Color.RED).toFront();
                    }
                    case 2,24,26 -> {
                        System.out.println("co 1 con mua rua sach khong khi");
                        GameState.event = "Có 1 cơn mưa nhỏ";
                        if(GameState.PM2_5 >= 20){
                            GameState.PM2_5 -= 20;
                        }else {
                            GameState.PM2_5 = 0;
                        }
                        if(GameState.PM10 >= 15 ){
                            GameState.PM10 -= 15 ;
                        }else {
                            GameState.PM10 = 0;
                        }
                    }
                    case 8,25 -> {
                        System.out.println("co 1 con mua bao co sam set sam danh chat rac va chay bien bao va chay cay");
                        GameState.event = "Có 1 cơn mưa bão, vài tia sét đã đánh trúng đường phố gây ra vài vụ cháy nhỏ";
                        GameState.SO2 += 25;
                        GameState.NO2 += 20;
                        GameState.PM2_5 += 15;
                    }
                    case 9,52,56,78,93 -> {
                        System.out.println("co 1 con gio mua mang theo bui");
                        GameState.event = "Có 1 cơn gió mang bụi làm ô nhiễm thành phố nghiêm trọng";
                        GameState.PM2_5 += 30;
                        GameState.PM10 += 20;
                    }
                }
            } else if(hour == 10) {
                GameState.SO2 += 30;
                GameState.PM2_5 += 20;
            } else if(hour == 11) {
                int ran = random.nextInt(1,100);
                switch (ran){
                    case 1, 3,5,7,10 -> {
                        System.out.println("tai nan giao thong !!!");
                        GameState.event = "Tai nạn giao thông";
                        GameState.NO2 += 30;
                        GameState.CO1 += 20;
                        GameState.danso--;
                        new FloatingNews(0,500,noMoveStage,"Tai nạn giao thông chết 1 người",Color.RED).toFront();
                    }
                    case 2,24,26,67,68,69,79,89 -> {
                        System.out.println("co 1 con mua rua sach khong khi");
                        GameState.event = "Có 1 cơn mưa nhỏ";
                        if(GameState.PM2_5 >= 20){
                            GameState.PM2_5 -= 20;
                        }else {
                            GameState.PM2_5 = 0;
                        }
                        if(GameState.PM10 >= 15){
                            GameState.PM10 -= 15;
                        }else {
                            GameState.PM10 = 0;
                        }
                    }
                    case 8,25,54,33 -> {
                        System.out.println("co 1 con mua bao co sam set sam danh chat rac va chay bien bao va chay cay");
                        GameState.event = "Có 1 cơn mưa bão, vài tia sét đã đánh trúng đường phố gây ra vài vụ cháy nhỏ";
                        GameState.SO2 += 25;
                        GameState.NO2 += 20;
                        GameState.PM2_5 += 15;
                    }
                    case 9,52,56,78,93,58,57,35 -> {
                        System.out.println("co 1 con gio mua mang theo bui");
                        GameState.event = "Có 1 cơn gió mang bụi làm ô nhiễm thành phố nghiêm trọng";
                        GameState.PM2_5 += 30;
                        GameState.PM10 += 20;
                    }
                }
            } else if(hour == 12) {
                GameState.O3 += 35;
            } else if(hour == 13) {
                GameState.O3 += 20;
            } else if(hour == 14) {
                int ran = random.nextInt(1,100);
                switch (ran){
                    case 1, 3,5 -> {
                        System.out.println("tai nan giao thong !!!");
                        GameState.event = "Tai nạn giao thông";
                        GameState.NO2 += 30;
                        GameState.CO1 += 20;
                        GameState.danso--;
                        new FloatingNews(0,500,noMoveStage,"Tai nạn giao thông chết 1 người",Color.RED).toFront();
                    }
                    case 2,24,26,67,68,69,79,89 -> {
                        System.out.println("co 1 con mua rua sach khong khi");
                        GameState.event = "Có 1 cơn mưa nhỏ";
                        if(GameState.PM2_5 >= 20){
                            GameState.PM2_5 -= 20;
                        }else {
                            GameState.PM2_5 = 0;
                        }
                        if(GameState.PM10 >= 15){
                            GameState.PM10 -= 15;
                        }else {
                            GameState.PM10 = 0;
                        }
                    }
                    case 8,25,54,33 -> {
                        System.out.println("co 1 con mua bao co sam set sam danh chat rac va chay bien bao va chay cay");
                        GameState.event = "Có 1 cơn mưa bão, vài tia sét đã đánh trúng đường phố gây ra vài vụ cháy nhỏ";
                        GameState.SO2 += 25;
                        GameState.NO2 += 20;
                        GameState.PM2_5 += 15;
                    }
                    case 9,52,56,78,93,58,57 -> {
                        System.out.println("co 1 con gio mua mang theo bui");
                        GameState.event = "Có 1 cơn gió mang bụi làm ô nhiễm thành phố nghiêm trọng";
                        GameState.PM2_5 += 30;
                        GameState.PM10 += 20;
                    }
                }
            } else if(hour == 15) {
                GameState.NO2 += 20;
                GameState.CO1 += 15;
                int ran = random.nextInt(1,21);
                switch (ran){
                    case 1, 20 -> {
                        System.out.println("tai nan giao thong !!!");
                        GameState.event = "Tai nạn giao thông";
                        GameState.NO2 += 30;
                        GameState.CO1 += 20;
                        GameState.danso--;
                        new FloatingNews(0,500,noMoveStage,"Tai nạn giao thông chết 1 người",Color.RED).toFront();

                    }
                }
            } else if(hour == 16) {
                GameState.NO2 += 20;
                GameState.CO1 += 15;
                int ran = random.nextInt(1,21);
                switch (ran){
                    case 1, 20,19 -> {
                        System.out.println("tai nan giao thong !!!");
                        GameState.event = "Tai nạn giao thông";
                        GameState.NO2 += 30;
                        GameState.CO1 += 20;
                        GameState.danso--;
                        new FloatingNews(0,500,noMoveStage,"Tai nạn giao thông chết 1 người",Color.RED).toFront();

                    }
                }
            } else if(hour == 17) {
                GameState.NO2 += 20;
                GameState.CO1 += 15;
            } else if(hour == 18) {
                int ran = random.nextInt(1,101);
                switch (ran){
                    case 1, 20,19,45,67,23,55 -> {
                        System.out.println("su kien the thao lon");
                        GameState.event = "Sự kiện thể thao lớn";
                        GameState.NO2 += 30;
                        GameState.CO1 += 20;
                        int ran2 = random.nextInt(1,101);
                        if(25<ran2 && ran2<=50 ){
                            System.out.println("tai nan giao thong !!!");
                            GameState.event = "Tai nạn giao thông";
                            GameState.NO2 += 30;
                            GameState.CO1 += 20;
                            GameState.danso-= 5;
                            new FloatingNews(0,500,noMoveStage,"Tai nạn giao thông chết 1 người",Color.RED).toFront();

                        }
                    }
                    case 49,11,68,56,87 -> {
                        System.out.println("co 1 con mua bao co sam set sam danh chat rac va chay bien bao va chay cay");
                        GameState.event = "Có 1 cơn mưa bão, vài tia sét đã đánh trúng đường phố gây ra vài vụ cháy nhỏ";
                        GameState.SO2 += 25;
                        GameState.NO2 += 20;
                        GameState.PM2_5 += 15;
                    }
                }
            } else if(hour == 19) {
                GameState.PM2_5 += 25;
                GameState.SO2 += 20;
                int ran = random.nextInt(1,101);
                switch (ran) {
                    case 1, 20, 19, 45, 67, 23, 55,5,3 -> {
                        System.out.println("Chay nha chay nha");
                        GameState.event = "Cháy 1 ngôi nhà";
                        GameState.SO2 += 15;
                        GameState.NO2 += 20;
                        GameState.PM2_5 += 25;
                        switch (ran){
                            case 1 -> {
                                GameState.danso-=1;
                                new FloatingNews(0,500,noMoveStage,"Cháy 1 ngôi nhà chết 1 người",Color.RED).toFront();
                            }
                            case 20 -> {
                                GameState.danso-=2;
                                new FloatingNews(0,500,noMoveStage,"Cháy 1 ngôi nhà chết 2 người",Color.RED).toFront();
                            }
                            case 45 -> {
                                GameState.danso-=3;
                                new FloatingNews(0,500,noMoveStage,"Cháy 1 ngôi nhà chết 3 người",Color.RED).toFront();
                            }
                            case 55 -> {
                                GameState.danso-=4;
                                new FloatingNews(0,500,noMoveStage,"Cháy 1 ngôi nhà chết 4 người",Color.RED).toFront();
                            }
                        }
                        if (ran == 20) {
                            System.out.println("Chay 2 ngoi nha");
                            GameState.event = "Cháy 2 ngôi nhà";
                            GameState.SO2 += 30;
                            GameState.NO2 += 40;
                            GameState.PM2_5 += 50;
                            int ran100 = random.nextInt(1,10);
                            switch (ran){
                                case 1 -> {
                                    GameState.danso-=2;
                                    new FloatingNews(0,500,noMoveStage,"Cháy 2 ngôi nhà chết 2 người",Color.RED).toFront();
                                }
                                case 2 -> {
                                    GameState.danso-=3;
                                    new FloatingNews(0,500,noMoveStage,"Cháy 2 ngôi nhà chết 3 người",Color.RED).toFront();
                                }
                                case 3 -> {
                                    GameState.danso-=4;
                                    new FloatingNews(0,500,noMoveStage,"Cháy 2 ngôi nhà chết 4 người",Color.RED).toFront();
                                }
                                case 4 -> {
                                    GameState.danso-=5;
                                    new FloatingNews(0,500,noMoveStage,"Cháy 2 ngôi nhà chết 5 người",Color.RED).toFront();
                                }
                            }
                        }
                    }
                }
            } else if(hour == 20) {
                GameState.PM2_5 += 25;
                GameState.NO2 += 20;
                GameState.SO2 += 15;
            } else if(hour == 21) {
                int ran = random.nextInt(1,101);
                switch (ran){
                    case 34,43,56,65,78,87,12,21,10,91 -> {
                        System.out.println("Mưa lon");
                        GameState.event = "Có 1 cơn mưa lớn";
                        if(GameState.PM2_5 >= 30){
                            GameState.PM2_5 -= 30;
                        }else {
                            GameState.PM2_5 = 0;
                        }
                        if(GameState.PM10 >= 20){
                            GameState.PM10 -= 20;
                        }else {
                            GameState.PM10 = 0;
                        }
                    }
                }
            } else if(hour == 22) {
                GameState.PM10 += 20;
                GameState.CO1 += 15;
            } else if(hour == 23) {
                GameState.PM10 += 20;
                GameState.CO1 += 15;
            }
            else if(hour == 0) {
                GameState.PM10 += 20;
                GameState.CO1 += 15;
            }
            else if(hour == 5) {
                GameState.NO2 += 10;
                GameState.CO1 += 8;
            }
            Utils.updateAQI(GameState.CO1, GameState.NO2, GameState.O3, GameState.PM2_5, GameState.PM10, GameState.SO2);
            new FloatingNews(0,500,noMoveStage, GameState.event,Color.YELLOW);
        }

    }

    private void tanggiamdanso(){
        if(AQI<100){
            GameState.xuhuongdantangorgiam = "tăng dân số";
            if(timeOfDay%(24*60)==0){
                createRandomPeople();
                GameState.danso += Math.round(GameState.danso*2/100/30);
                int ran = random.nextInt(1,15);
                switch (ran){
                    case 1 ->new FloatingNews(0,500,noMoveStage,"Thành phố quá xinh đẹp nên " + Math.round(GameState.danso*2/100/30) + " người đến",Color.GREEN);
                    case 2 -> new FloatingNews(0,500,noMoveStage,"Thành phố xinh đẹp nên " + Math.round(GameState.danso*2/100/30) + " người đến",Color.GREEN);
                    case 3 -> new FloatingNews(0,500,noMoveStage,"Thành phố hiện đái nên " + Math.round(GameState.danso*2/100/30) + " người đến",Color.GREEN);
                    case 4 -> new FloatingNews(0,500,noMoveStage," Thành phố tiến tiến nên " + Math.round(GameState.danso*2/100/30) + " người đến",Color.GREEN);
                    case 5 -> new FloatingNews(0,500,noMoveStage,"Thành phố sạch sẽ nên " + Math.round(GameState.danso*2/100/30) + " người đến",Color.GREEN);
                    case 6 -> new FloatingNews(0,500,noMoveStage,"Ronando chuyển đến nên " + Math.round(GameState.danso*2/100/30) + " người đi theo",Color.GREEN);
                    case 7 -> new FloatingNews(0,500,noMoveStage,"Messi chuyển đến nên  " + Math.round(GameState.danso*2/100/30) + " người  đi theo",Color.GREEN);
                    case 8 -> new FloatingNews(0,500,noMoveStage,"M pa pê chuyển đến nên  " + Math.round(GameState.danso*2/100/30) + " người  đi theo",Color.GREEN);
                    case 9 -> new FloatingNews(0,500,noMoveStage,"Haland chuyển đến nên  " + Math.round(GameState.danso*2/100/30) + " người  đi theo",Color.GREEN);
                    case 10 -> new FloatingNews(0,500,noMoveStage,"Thích Minh Toại chuyển đến nên  " + Math.round(GameState.danso*2/100/30) + " người  đi theo",Color.GREEN);
                    case 11 -> new FloatingNews(0,500,noMoveStage,"Có bãi biển đẹp nên  " + Math.round(GameState.danso*2/100/30) + " người  tham quan",Color.GREEN);
                    case 12 -> new FloatingNews(0,500,noMoveStage," Giá đất rẻ nên " + Math.round(GameState.danso*2/100/30) + " người đến ở",Color.GREEN);
                    case 13 -> new FloatingNews(0,500,noMoveStage,"Nền kinh tế phát triển nên " + Math.round(GameState.danso*2/100/30) + " người đến ",Color.GREEN);
                    case 14 -> new FloatingNews(0,500,noMoveStage," Con Sông Hồng tuyệt sắc  " + Math.round(GameState.danso*2/100/30) + " người  đến",Color.GREEN);
                    case 15 -> new FloatingNews(0,500,noMoveStage," Công nghệ phát triển  nên " + Math.round(GameState.danso*2/100/30) + " người  đến",Color.GREEN);

                }
            }
        }else if(AQI<=200){
            GameState.xuhuongdantangorgiam = "giảm dân số";
        }else if(AQI>200){
            GameState.xuhuongdantangorgiam = "giảm dân số";
            if(timeOfDay%(24*60)==0){
                createRandomPeople();
                GameState.danso -= Math.round(GameState.danso*5/100/30);
                int ran = random.nextInt(1,10);
                switch (ran) {
                    case 1 ->new FloatingNews(0, 500, noMoveStage, "Thành phố quá bẩn nên " + Math.round(GameState.danso * 2 / 100 / 30) + " người rời đi", Color.RED);
                    case 2 ->new FloatingNews(0, 500, noMoveStage, "Messi rời đi nên " + Math.round(GameState.danso * 2 / 100 / 30) + " người rời đi", Color.RED);
                    case 3 ->new FloatingNews(0, 500, noMoveStage, "Ronando rời đi nên " + Math.round(GameState.danso * 2 / 100 / 30) + "người rời đi", Color.RED);
                    case 4 ->new FloatingNews(0, 500, noMoveStage, " Không khí ô nhiễm nặng " + Math.round(GameState.danso * 2 / 100 / 30) + " người rời đi", Color.RED);
                    case 5->new FloatingNews(0, 500, noMoveStage, " Nội thất giảm sút " + Math.round(GameState.danso * 2 / 100 / 30) + " người rời đi", Color.RED);
                    case 6 ->new FloatingNews(0, 500, noMoveStage, " Tiền thuê nhà tăng lên  " + Math.round(GameState.danso * 2 / 100 / 30) + " người rời đi", Color.RED);
                    case 7 ->new FloatingNews(0, 500, noMoveStage, " Có  " + Math.round(GameState.danso * 2 / 100 / 30) + " người chuyển nhà", Color.RED);
                    case 8 ->new FloatingNews(0, 500, noMoveStage, " Dịch bệnh nên " + Math.round(GameState.danso * 2 / 100 / 30) + " người chết", Color.RED);
                    case 9 ->new FloatingNews(0, 500, noMoveStage, " Thành phần người dân hổ báo nên " + Math.round(GameState.danso * 2 / 100 / 30) + " người rời đi", Color.RED);
                    case 10 ->new FloatingNews(0, 500, noMoveStage, "Biến đổi khí hậu nên " + Math.round(GameState.danso * 2 / 100 / 30) + " người rời đi", Color.RED);


                }
            }
        }
    }
    private void taoChatCay(){
        if(timeOfDay%180==0){
            if(random.nextBoolean()){
                createRandomPeople();
            }
        }
    }
    private void createRandomPeople(){
        switch (random.nextInt(1,6)){
            case 1 -> new People1(32*5+1184,32,stage,true);
            case 2 -> new People2(32*5+1184,32,stage,true);
            case 3 -> new People3(32*5+1184,32,stage,true);
            case 4 -> new People4(32*5+1184,32,stage,true);
            case 5 -> new People5(32*5+1184,32,stage,true);
        }
    }
    private void createCar() {
        if(gio1phan60%180 == 0){
            Car car = new Car(0,0,stage);//dat x,y cho hop ly vi Car extends MyActor chu vao trong car no dat lai
            cars.add(car);
        }
    }
    private void createParking(float x, float y){
        new RoadPiece(x,y,stage,'_');
        new LetterP(x+32,y,stage);
    }
    private void createHouses(){
        scienceCenter = new ScienceCenter(28*32,32*16,stage);
        scienceDoor = new MordernDoor(32*29,32*16,stage);
        factoryCenter = new FactoryCenter(13 * 32, 32, stage);
        hotelCenter = new HotelCenter(32*32,32*5,stage) ;
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
        createRiverAndBoats();
        float xR = 1184+32*4;
        float yR = WINDOW_HEIGHT - 32 * 2;
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 21; i++) {
                Rice lua = new Rice(xR, yR, stage);
                rices.add(lua);
                xR += 32;
            }
            xR = 1184+32*4;
            yR -= 32;
        }
        xR = 1184+32*4;
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

        for (int i = 0; i < 10; i++) {
           // new People(MathUtils.random(0, 2000), MathUtils.random(0, 700), stage);
        }

        Corner corner2 = new Corner(1184 + 15 * 32, 800 / 2f + 48 + 4*32-7*32, stage, "UR");
        BlankRoad blankRoad2 = new BlankRoad(1184 + 16 * 32, 800 / 2f + 48 + 4*32-7*32, stage);
        Corner corner12 = new Corner(1184 + 17 * 32, 800 / 2f + 48 + 4*32-7*32, stage, "UL");

        TruSo truSo1 = new TruSo(18*32,6*32,stage,2);
        TruSo truSo2 = new TruSo(20*32,0,stage,3);
        TruSo truSo3 = new TruSo(33*32,32*22,stage,1);
        TruSo truSo4 = new TruSo(17*32,32*19,stage,1);
        TruSo truSo5 = new TruSo(29*32,32*8,stage,1);
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

    public void createRiverAndBoats(){
        river = new River(1178, 0, stage);
        blood = new Blood(1178+15, 0, stage);
        new Boat(MathUtils.random(1190, 1230), MathUtils.random(0, 800), stage);
        new Boat(MathUtils.random(1190, 1230), MathUtils.random(0, 800), stage);
        new Boat(MathUtils.random(1190, 1230), MathUtils.random(0, 800), stage);
        new Boat(MathUtils.random(1190, 1230), MathUtils.random(0, 800), stage);
    }

    private void closeScienceBoard(){
        bangScience.setPosition(-1002343,-1101);
        bangScienceCross.setPosition(-1002343,-1101);
        thongTinButton.setPosition(-1002343,-1101);
        nghienCuuButton.setPosition(-1002343,-1101);
        cheTaoButton.setPosition(-1002343,-1101);
        caiDatButton.setPosition(-1002343,-1101);
        line.setHeight(0);
        line2.setHeight(0);
        dongThongtin();
        dongNghienCuu();
        hienChiSo = false;
        hienNghienCuu = false;
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
        nen.stop();
        batch.dispose();
    }
}

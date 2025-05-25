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
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.*;
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
import spst.com.Button.InItemsButton.CamChoi;
import spst.com.Button.InItemsButton.CamXeng;
import spst.com.Button.InItemsButton.OpenItems;
import spst.com.Button.InVehicleButton.LayPolice;
import spst.com.Button.InVehicleButton.LayTaxi;
import spst.com.Button.InVehicleButton.LayTrashTruck;
import spst.com.Button.InVehicleButton.OpenVehicles;
import spst.com.Enums.TypeViaHe;
import spst.com.InFactory.*;
import spst.com.Cameras.NormalCamera;
import spst.com.Enums.TypeRoadRe;
import spst.com.GroundOutRoads.CanhGround;
import spst.com.GroundOutRoads.GroundCenter;
import spst.com.GroundOutRoads.GroundCorner;
import spst.com.House.*;
import spst.com.InFactory.Items.Broom;
import spst.com.InFactory.Items.Shovel;
import spst.com.InFactory.Vehicles.Police;
import spst.com.InFactory.Vehicles.Taxi;
import spst.com.InFactory.Vehicles.TrashTruck;
import spst.com.MiniGame.Imaged;
import spst.com.MiniGame.MiniGame;
import spst.com.Parking.LetterP;
import spst.com.Parking.RoadPiece;
import spst.com.Parking.RoundCorner;
//import spst.com.People.People;
import spst.com.People.*;
import spst.com.Pool.CornerPool;
import spst.com.Pool.PoolRec;
import spst.com.Pool.WallPool;
import spst.com.Pool.Water;
import spst.com.Roads.*;
import spst.com.Roads.CrossRoad.BlankRoad;
import spst.com.Roads.CrossRoad.Corner;
import spst.com.Roads.CrossWalk;
import spst.com.Volume.ConTrol;
import spst.com.Volume.HinhAnhLoa;
import spst.com.Volume.ThanhControl;
import spst.com.town.*;

import static com.badlogic.gdx.math.MathUtils.random;

/**
 */
public class Master implements Screen {
    public static SpriteBatch batch;
    OrthographicCamera camera;
    InputMultiplexer multiplexer;
    public static Stage stage;
    public static Stage noMoveStage;
    public static Music nen = Gdx.audio.newMusic(Gdx.files.internal("nhacnen.mp3"));
    GlyphLayout layout = new GlyphLayout();
    boolean thongTinMode = false;

    RedFlag redFlag;
    ChaoMungPeople one;
    Vector2 mouseNoMoveStage = new Vector2();
    public static Vector2 mouseStage = new Vector2();
    Vector2 deltaXYVector = new Vector2();
    public static River river;
    public static Blood blood;
    public static Replay replay;
    Chu chu1;
    Chu chu2;
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
    XayDung xayDungButton;
    CongCu congCuButton;
    XeCo xeCoButton;
    public static Player player;
    PoolRec poolRec;
    BuyDirt buyDirt;
    Arrow arrow;
    BuyBlank buyBlank;
    BuyRoad buyRoad;
    BuyRoadRe buyRoadRe;
    BuyRoadReNgoai buyRoadReNgoai;
    BuyCanhRoad buyCanhRoad;
    BuyViaHe buyViaHe;
    BuyDirt MDirt;
    BuyBlank MBlank;
    BuyRoad MRoad;
    BuyRoadRe MRoadRe;
    BuyRoadReNgoai MRoadReNgoai;
    BuyCanhRoad MCanhRoad;
    BuyViaHe MViaHe;
    Shovel buyShovel;
    Shovel shovel;
    Broom buyBroom;
    Broom broom;
    TruckButton buyTrashTruck;
    public static TrashTruck trashTruck;
    TaxiButton buyTaxi;
    public static Taxi taxi;
    PoliceButton buyPolice;
    public static Police police;
    Bang bangFactory;
    Bang bangScience;
    Bang bangTrash;
    Waste giaiThichHuuCo;
    Waste giaiThichVoCo;
    Waste giaiThichTaiChe;
    Waste giaiThichNguyHai;
    WhiteButton luaChon1NhaRac;
    WhiteButton luaChon2NhaRac;
    WhiteButton luaChon3NhaRac;
    WhiteButton luaChon4NhaRac;
    WhiteButton luaChon5NhaRac;
    Bang turtleBang;
    Bang bangDaily;
    Bang bangSoTay;
    Cross turtleCross;
    Cross bangFactoryCross;
    public static Bang menuFood;
    Cross bangScienceCross;
    Cross bangTrashCross;
    Cross menuFoodCross;
    Cross dailyCross;
    Cross soTayCross;
    MordernDoor scienceDoor;
    MordernDoor hotelDoor;
    MordernDoor factoryDoor;
    boolean isCanDao = false;
    int isQuet = 0;
    boolean isCanDatDirt = false;
    boolean isCanDatThingsOnDirt = false;
    PlayTurtleMap playTurtleMap;
    ArrowNoMoveStage arrowNoMove;
    DailyQuest dailyQuest;
    public static boolean isSoiCam ;
    boolean openSoTay = false;
    public static boolean inDoVui = false;
    public static boolean inGreenCoBan = false;
    public static boolean inShock = false;
    public static char trongHopDoVui = 1;
    public static char trongHopShock = 1;
    public static char trongHopGreen = 1;
    public  static boolean answerRight = false;
    public static boolean answered = false;

    boolean inCreate = false;
    SoTay soTay;

    Bia bia;
    Pho pho;
    FactoryCenter factoryCenter;
    TrashCenter trashCenter;
    MordernDoor trashDoor;
    HotelCenter hotelCenter;
    ScienceCenter scienceCenter;
    public static ShowAQI showAQI;
    Calories calories;
    public static boolean hienCheTao = false;
    public static float amluong;
    public static int soNgayDienRaLeHoi ;
    public static int soCayTieuChuan ;
    public static boolean isNgayTrongCay = false;

    Dark dark;
    Rain rain;
    Line line;
    Line line2;
    Line lineThongTin2;
    Line lineThongTin;
    ShapeRenderer shapeRenderer = new ShapeRenderer();
    Texture button = new Texture("buttonblank.png");
    Texture sadIcon = new Texture("sadIcon.png");
    TextButton bienButton ;
    TextButton plantButton;
    Button1C button1C;
    Button2C button2C;
    Button3C button3C;
    Button4C button4C;
    Button5C button5C;
    Button6C button6C;
    Button7C button7C;
    Button1S button1S;
    Button2S button2S;
    Button3S button3S;
    Rectangle rectangleRestaurant;
    ConTrol conTrol;
    ThanhControl thanhControl;
    HinhAnhLoa hinhAnhLoa;

    public static Array<Rectangle> roadArray = new Array<>();
    public static Array<MyActor> reArray = new Array<>();
    public static Array<Actor> winsorloses = new Array<>();
    public static Array<Car> cars = new Array<>();
    public static Array<MyActor> roads = new Array<>();
    public static Array<Waste> wastes = new Array<>();
    public static Array<Tree> trees = new Array<>();
    public static Array<MayLoc> MLKKs = new Array<>();
    public static Array<Sign> signs = new Array<>();
    public static  Array<TruSo> truSos = new Array<>();
    public static Array<MyActor> VLLDs = new Array<>();
    public static Array<NormalCamera> normalCameras = new Array<>();
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
    public static boolean isEating = false;
    public static int nhiemvu1 = 0;
    public static int nhiemvu2 = 0;
    public static int nhiemvu3 = 0;
    public  static int soNguoiChatCay = 0;
    public static  int soNguoiDotBien = 0;
    public static int soNguoiDotRac = 0;
    public static int soCayConLai = 0;
    int soMayLocBought = 0;
    Imaged image;
    Imaged image2;
    Imaged image3;
    Imaged image4;
    Imaged image5;
    public static int sohieucuaMLKKdangchondenangcap = 0;
    public static boolean isOpenSetting = false;
    final float WINDOW_WIDTH = 2400;
    final float WINDOW_HEIGHT = 800;
    public static float amountOfFood = 100;
    public static Array<Rectangle> noCutting = new Array<>();
    public static Array<Rectangle> noDotRac = new Array<>();
    boolean isInTurtleMap = false;
    public static boolean nhiemVuTanBinh = true;
    public static int thuTuNhiemVuTanBinh = 1;

    public static int growth = 0;
    public static Array<Rice>rices ;
    public static int soCuaCameraDangLooking = 0;
    Truck truck;
    TreeButon treeButon;
    creatMayLoc taoMayLockk;
    public static DoVui doVui;
    public  static Green green;
    public static Shock shock;
    Sai sai;
    Dung dung;
    Hieu hieu;
    public static int soCauDoVui = 10;
    public static int soCauDoGreen = 5;
    public static int soCauDoShock = 8;
    public static int thoiGianHien = 0;

    creatCamera taoCamera;
    creatSign taoSign;
    creatVatLieuMoRongMap creatVLLD;
    OpenItems openItems;
    CamXeng xengButton;
    CamChoi choiButton;
    OpenVehicles openVehicles;
    LayTrashTruck trashTruckButton;
    LayTaxi taxiButton;
    LayPolice policeButton;
    ButtonLeft buttonLeftVLLD;
    ButtonRight buttonRightVLLD;
    SaveNut saveNut;
    Restaurant restaurant;
    Kem iceCream;
    Com com;
    XienBan xienBan;
    ThapRua thapRua;
    float ktHetEvent = 2;
    public  static boolean buyCNX = false;
    public static boolean buyGTX = false;
    boolean ktDangChayEvent = false;
    public static Waterwell gieng;
    public static boolean cutting = false;
    public static boolean mLKKAction = true;
    public static boolean factoryAction = true;
    public  static boolean trafficAction = true;

    int speedX = -2 ;
    int  luotcat = 1;
    public static boolean hienBangFactory = false;
    public static boolean hienXayDung = false;
    public static boolean hienCongCu = false;
    public static boolean hienXeCo = false;
    public static boolean hienBangTrash = false;
    public static boolean hienChiSo = false;
    public static boolean hienThongTin = false;
    public static boolean hienNghienCuu = false;
    public static boolean thongTinNutCay = false;
    public static boolean thongTinNutML = false;
    public static boolean thongTinNutCam = false;
    public static boolean thongTinNutSign = false;
    public static boolean thongTinNutSoiCam = false;
    public static boolean thongTinNgaRe = false;
    public static boolean thongTinCanhRoad = false;
    public static boolean thongTinDat = false;
    public static boolean thongTinVongCung = false;
    public static boolean thongTinViaHe = false;
    public static boolean thongTinDuongThang = false;
    public static boolean thongTinDuongTrong = false;
    public static boolean thongTinDatNgaRe = false;
    public static boolean thongTinDatCanhRoad = false;
    public static boolean thongTinDatVongCung = false;
    public static boolean thongTinDatViaHe = false;
    public static boolean thongTinDatDuongThang = false;
    public static boolean thongTinSaiUn = false;
    public static boolean thongTinFac = false;
    public static boolean thongTinHotel = false;
    public static boolean thongTinRestaurant = false;
    public static boolean thongTinTrashCenter = false;
    public static boolean thongTinThapRua = false;
    public static boolean thongTinThanhDoi = false;
    public static Vector2 cameraPosition = new Vector2(1200 / 2, 800 / 2);
    public static boolean isDenDo = false;
    public static int day = 0;
    public static int gio1phan60 = 0;
    public static TextField textField;
    private Sound clickSound = Gdx.audio.newSound(Gdx.files.internal("clicksound.ogg"));
    public static Sound collect = Gdx.audio.newSound(Gdx.files.internal("collect.mp3"));
    StartGame game;
    public static int timeOfDay = 0;
    public static boolean isCoXeng = false;
    public static boolean isCoChoi = false;
    public static boolean isMoItems = false;
    public boolean openDailyQuest = false;
    public static boolean isMoVehicles = false;
    public static boolean isCoXeRac = false;
    public static boolean isCoTaxi = false;
    public static boolean isCoPolice = false;

    public Master(StartGame game) {
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = StartGame.font3;
        style.fontColor = Color.RED;
        style.up = new TextureRegionDrawable(button);

        layout.width = 300;
        layout.height = 40;
        noMoveStage = new Stage();
        soNgayDienRaLeHoi = MathUtils.random(1,1);
        soCayTieuChuan = MathUtils.random(10,25);
        resetDailyQuest();

        button1C = new Button1C(100000,100000,noMoveStage);
        button1C.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>= 2000&&GameState.ernegy>=20&& GameState.soMayLocBought <= (GameState.soMLtoidacothemua-1)) {
                    Master.soMayLoc++;
                    GameState.money-=500;
                    GameState.ernegy-=20;
                    GameState.soMayLocBought++;
                    if(thuTuNhiemVuTanBinh==3){
                        nhiemVuTanBinh= true;
                        thuTuNhiemVuTanBinh++;
                    }
                }

            }
        });
        button2C = new Button2C(100000 , 100000, noMoveStage);
        button2C.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>=300&&GameState.ernegy >=10&&GameState.greenscore >=5) {
                    GameState.greenscore  -= 5;
                    GameState.ernegy  -= 10;
                    GameState.money-=300;
                    Master.soBienCam++;
                }
            }
        });
        button6C = new Button6C(100000 , 100000, noMoveStage);
        button6C.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money >= 1500 && GameState.ernegy >= 30 && GameState.greenscore >= 30){
                    isCNX = true;
                    button6C.setColor(Color.GRAY);
                    GameState.money -=1500;
                    GameState.ernegy -=30;
                    GameState.greenscore -=30;
                }
            }
        });
        button7C = new Button7C(100000 , 100000, noMoveStage);
        button7C.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money >= 1000 && GameState.ernegy >= 50 && GameState.greenscore >= 20){
                    isGTX = true;
                    button7C.setColor(Color.GRAY);
                    GameState.money -=1000;
                    GameState.ernegy -=50;
                    GameState.greenscore -=20;
                }
            }
        });
        button4C = new Button4C(100000 , 100000, noMoveStage);
        button4C.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>=100&&GameState.greenscore  >=5) {
                    Master.amountSeed++;
                    GameState.greenscore -= 5;
                    GameState.money-=100;
                }
            }
        });

        button3C = new Button3C(100000 , 100000, noMoveStage);
        button3C.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money >=300&&GameState.ernegy >=5){
                    soCamera++;
                    GameState.money-=300;
                    GameState.ernegy-=5;
                }
            }
        });

        button5C = new Button5C(100000 , 100000, noMoveStage);
        button5C.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>=75) {
                    GameState.ernegy+= 100;
                    GameState.money-=75;
                }
            }
        });

        button1S = new Button1S(10000,10000,noMoveStage);
        button2S = new Button2S(10000,10000,noMoveStage);
        button3S = new Button3S(10000,10000,noMoveStage);
        this.game = game;

        batch = new SpriteBatch();
        multiplexer = new InputMultiplexer();
        stage = new Stage();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(noMoveStage);
        camera = new OrthographicCamera();
        camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        replay = new Replay(-10080,-32760,noMoveStage);
        arrowNoMove = new ArrowNoMoveStage(-10000,-10000,noMoveStage);
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
        xayDungButton = new XayDung(-1000,-1000,noMoveStage);
        congCuButton = new CongCu(-1000,-1000,noMoveStage);
        xeCoButton = new XeCo(-1000,-1000,noMoveStage);
        image = new Imaged(32*20,Gdx.graphics.getHeight()-32*3-25,noMoveStage,2);
        image2 = new Imaged(32*20,Gdx.graphics.getHeight()-32*6-100,noMoveStage,3);
        image3 = new Imaged(32*20, Gdx.graphics.getHeight() - 32*7-125,noMoveStage,1);
        image4 = new Imaged(32*22, Gdx.graphics.getHeight() - 32*4-50,noMoveStage,4);
        image5 = new Imaged(32*22, Gdx.graphics.getHeight() - 32*5-75,noMoveStage,5);
        soTay = new SoTay( 300,Gdx.graphics.getHeight()-70,noMoveStage );

       // nutMayLoc = new creatMayLoc(-1000,-1000,noMoveStage);

        cameraLookingLeft = new ButtonLeft(Gdx.graphics.getWidth() - 500-100+10,Gdx.graphics.getHeight()-70,noMoveStage);
        cameraLooking = new SelectCamera(Gdx.graphics.getWidth() - 500+26-100,Gdx.graphics.getHeight()-70,noMoveStage);
        cameraLookingRight = new ButtonRight(Gdx.graphics.getWidth() - 500+26+42-100,Gdx.graphics.getHeight()-70,noMoveStage);

        poolRec = new PoolRec(0, 32 * 17, stage);
        rices = new Array();

        chu1 = new Chu(0, 0,stage,Color.BLACK);
        chu2 = new Chu(0, 0,stage,Color.BLACK);

        for(int i = 0;i<25;i++){
            for(int j = 0;j<75;j++){
                new BuyDirt(j*32,i*32,stage).toBack();
            }
        }
        openVehicles = new OpenVehicles(Gdx.graphics.getWidth()-350,Gdx.graphics.getHeight()-70,noMoveStage);
        trashTruckButton = new LayTrashTruck(Gdx.graphics.getWidth()-350,Gdx.graphics.getHeight()-70-45,noMoveStage);
        taxiButton = new LayTaxi(Gdx.graphics.getWidth()-350,Gdx.graphics.getHeight()-70-45*2,noMoveStage);
        policeButton = new LayPolice(Gdx.graphics.getWidth()-350,Gdx.graphics.getHeight()-70-45*3,noMoveStage);
        {// TỪ DẤU MỞ NGOẶC NHỌN ĐẾN HẾT CHỈ XỬ LÝ ẤN VÀO NÚT VEHICLE VÀ CÁC NÚT BÊN TRONG VEHICLE
            openVehicles.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if(!Master.isMoVehicles) {
                        Master.isMoVehicles = true;
                        openVehicles.textureRegion = new TextureRegion(openVehicles.texture1);
                    }else{
                        Master.isMoVehicles = false;
                        openVehicles.textureRegion = new TextureRegion(openVehicles.texture);
                    }
                }
            });
            trashTruckButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if(Master.isCoXeRac){
                        if(!trashTruckButton.getIsSelect()) {
                            if(!taxiButton.getIsSelect()&&!policeButton.getIsSelect()){
                                trashTruckButton.setIsSelect(true);
                                trashTruck.setIsUsing(true);
                                trashTruckButton.textureRegion = new TextureRegion(trashTruckButton.texture1);
                                trashTruck.toFront();
                                trashTruck.setPosition(player.getX()-32, player.getY());
                                player.speed=5;
                            }
                        }else{
                            trashTruckButton.setIsSelect(false);
                            trashTruck.setIsUsing(false);
                            trashTruckButton.textureRegion = new TextureRegion(trashTruckButton.texture);
                            player.speed=2;
                        }
                    }
                }
            });
            taxiButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if(Master.isCoTaxi){
                        if(!taxiButton.getIsSelect()) {
                            if(!trashTruckButton.getIsSelect()&&!policeButton.getIsSelect()){
                                taxiButton.setIsSelect(true);
                                taxi.setIsUsing(true);
                                taxiButton.textureRegion = new TextureRegion(taxiButton.texture1);
                                taxi.toFront();
                                taxi.setPosition(player.getX()-32, player.getY());
                                player.speed=8;
                            }
                        }else{
                            taxiButton.setIsSelect(false);
                            taxi.setIsUsing(false);
                            taxiButton.textureRegion = new TextureRegion(taxiButton.texture);
                            player.speed=2;
                        }
                    }
                }
            });
            policeButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if(Master.isCoPolice){
                        if(!policeButton.getIsSelect()) {
                            if(!trashTruckButton.getIsSelect()&& !taxiButton.getIsSelect()){
                                policeButton.setIsSelect(true);
                                police.setIsUsing(true);
                                policeButton.textureRegion = new TextureRegion(policeButton.texture1);
                                police.toFront();
                                police.setPosition(player.getX()-32, player.getY());
                                player.speed=10;
                            }
                        }else{
                            policeButton.setIsSelect(false);
                            police.setIsUsing(false);
                            policeButton.textureRegion = new TextureRegion(policeButton.texture);
                            player.speed=2;
                        }
                    }
                }
            });
        }
        openItems = new OpenItems(Gdx.graphics.getWidth()-300,Gdx.graphics.getHeight()-70,noMoveStage);
        xengButton = new CamXeng(Gdx.graphics.getWidth()-300,Gdx.graphics.getHeight()-70-45,noMoveStage);
        choiButton = new CamChoi(Gdx.graphics.getWidth()-300,Gdx.graphics.getHeight()-70-45*2,noMoveStage);
        xengButton.remove();
        choiButton.remove();
        {// TỪ DẤU MỞ NGOẶC NHỌN ĐẾN HẾT CHỈ XỬ LÝ ẤN VÀO NÚT ITEM VÀ CÁC NÚT BÊN TRONG ITEM
            openItems.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if(!Master.isMoItems) {
                        Master.isMoItems = true;
                        openItems.textureRegion = new TextureRegion(openItems.texture1);
                    }else{
                        Master.isMoItems = false;
                        openItems.textureRegion = new TextureRegion(openItems.texture);
                    }
                }
            });
            xengButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if(Master.isCoXeng){
                        if(!Master.whatActionIfClickMouse.equals("CamXeng")) {
                            Master.whatActionIfClickMouse = "CamXeng";
                            xengButton.textureRegion = new TextureRegion(xengButton.texture1);
                        }else{
                            Master.whatActionIfClickMouse = "move";
                            xengButton.textureRegion = new TextureRegion(xengButton.texture);
                            MDirt.setPosition(-32456,-34565);
                        }
                    }
                }
            });
            choiButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if(Master.isCoChoi){
                        if(!Master.whatActionIfClickMouse.equals("CamChoi")) {
                            Master.whatActionIfClickMouse = "CamChoi";
                            choiButton.textureRegion = new TextureRegion(choiButton.texture1);
                        }else{
                            Master.whatActionIfClickMouse = "move";
                            choiButton.textureRegion = new TextureRegion(choiButton.texture);
                            MDirt.setPosition(-32456,-34565);
                        }
                    }
                }
            });
        }
        generateMap();
        generateMap2();
        arrow = new Arrow(400,200,stage);
        truck = new Truck(32*33+1184,800 - 32*3, stage);
        gieng = new Waterwell(1184+32*27,32*6,stage);
        treeButon = new TreeButon(Gdx.graphics.getWidth()-100,Gdx.graphics.getHeight()-70,noMoveStage);
        taoMayLockk = new creatMayLoc(Gdx.graphics.getWidth()-150,Gdx.graphics.getHeight()-70,noMoveStage);
        taoCamera = new creatCamera(Gdx.graphics.getWidth()-200,Gdx.graphics.getHeight()-70,noMoveStage);
        taoSign = new creatSign(Gdx.graphics.getWidth()-250,Gdx.graphics.getHeight()-70,noMoveStage);
        creatVLLD = new creatVatLieuMoRongMap(Gdx.graphics.getWidth()-400-32,Gdx.graphics.getHeight()-70,noMoveStage);
        buttonLeftVLLD = new ButtonLeft(Gdx.graphics.getWidth()-400-32-13-5,Gdx.graphics.getHeight()-70,noMoveStage);
        buttonRightVLLD = new ButtonRight(Gdx.graphics.getWidth()-400+40-32+5,Gdx.graphics.getHeight()-70,noMoveStage);
        buyShovel = new Shovel(32*5,Gdx.graphics.getHeight()-32*8,noMoveStage);
        doVui = new DoVui(32*12,32*2,noMoveStage);
        green = new Green(32*5, 32*2, noMoveStage);
        shock = new Shock(32*19 , 32*2,noMoveStage);
        thanhControl = new ThanhControl(50,Gdx.graphics.getHeight() - 100 , noMoveStage);
        conTrol = new ConTrol(75,Gdx.graphics.getHeight() - 110 , noMoveStage);
        hinhAnhLoa = new HinhAnhLoa(0, Gdx.graphics.getHeight() - 120 , noMoveStage);

        sai = new Sai(32*18 , Gdx.graphics.getHeight() - 32*8,noMoveStage);
        dung = new Dung(32 *9 ,Gdx.graphics.getHeight() - 32*8,noMoveStage);
        hieu = new Hieu(32* 13 ,Gdx.graphics.getHeight() - 32*6,noMoveStage);
        buyShovel.remove();
        shovel = new Shovel(0,0,noMoveStage);
        shovel.setTouchable(Touchable.disabled);
        shovel.remove();
        buyBroom = new Broom(32*17,Gdx.graphics.getHeight()-32*8,noMoveStage);
        buyBroom.remove();
        broom = new Broom(0,0,noMoveStage);
        broom.setTouchable(Touchable.disabled);
        broom.remove();
        buyTrashTruck = new TruckButton(-345436,-24234,noMoveStage);
        trashTruck = new TrashTruck(-254242, -56732, stage);
        buyTaxi = new TaxiButton(-345436,-24234,noMoveStage);
        taxi = new Taxi(-254242, -56732, stage);
        buyPolice = new PoliceButton(-345436,-24234,noMoveStage);
        police = new Police(-254242, -56732, stage);

        saveNut = new SaveNut(Gdx.graphics.getWidth()-48,Gdx.graphics.getHeight()-48,noMoveStage);
        redFlag = new RedFlag(0,0,stage);
        redFlag.remove();
        one = new ChaoMungPeople(0,800/2f-48,stage);
        one.remove();

        createTree();
        createWaste();
        createHouses();
        playTurtleMap = new PlayTurtleMap(350,32,noMoveStage);
        playTurtleMap.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(nhiemvu2 == 2){
                    nhiemvu2 = 77;
                    GameState.money += 200;
                }
                isInTurtleMap = false;
                int random = MathUtils.random(1,5);
                switch (random) {
                    case 1 -> {
                        soBienCam+=2;
                        new FloatingNews(0, Gdx.graphics.getHeight()-40,noMoveStage, "Được 2 biển cấm từ việc chiến thắng game dưới lòng hồ", Color.GREEN);
                    }
                    case 2 -> {
                        amountSeed+=3;
                        new FloatingNews(0, Gdx.graphics.getHeight()-40,noMoveStage, "Được 3 cây xanh từ việc chiến thắng game dưới lòng hồ", Color.GREEN);
                    }
                    case 3 -> {
                        GameState.ernegy+= 50;
                        new FloatingNews(0, Gdx.graphics.getHeight()-40,noMoveStage, "Được 50 năng lượng từ việc chiến thắng game dưới lòng hồ", Color.GREEN);
                    }
                    case 4 -> {
                        GameState.greenscore += 20;
                        new FloatingNews(0, Gdx.graphics.getHeight()-40,noMoveStage, "Được 20 điểm xanh từ việc chiến thắng game dưới lòng hồ", Color.GREEN);
                    }
                    case 5 -> {
                        soCamera++;
                        new FloatingNews(0, Gdx.graphics.getHeight()-40,noMoveStage, "Được 1 cái camera từ việc chiến thắng game dưới lòng hồ", Color.GREEN);
                    }
                }
                playTurtleMap.setPosition(10000,100000);
                game.setScreen(new MiniGame(game));
            }
        });


        thapRua = new ThapRua(32*9+8,800/2+48+32*6+8,stage);
        thapRua.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                isInTurtleMap = true;
            }
        });

        player = new Player(1200 / 2, 800 / 2, stage);
        buyDirt = new BuyDirt(-132456,-65432,noMoveStage);
        buyBlank = new BuyBlank(-132456,-65432,noMoveStage);
        buyRoad = new BuyRoad(-132456,-65432,noMoveStage);
        buyRoadRe = new BuyRoadRe(-132456,-65432,noMoveStage);
        buyRoadReNgoai = new BuyRoadReNgoai(-132456,-65432,noMoveStage);
        buyRoadRe = new BuyRoadRe(-132456,-65432,noMoveStage);
        buyCanhRoad = new BuyCanhRoad(-132456,-65432,noMoveStage);
        buyViaHe = new BuyViaHe(-132456,-65432,noMoveStage);
        MViaHe = new BuyViaHe(-132456,-65432,noMoveStage);
        MDirt = new BuyDirt(-132456,-65432,noMoveStage);
        MBlank = new BuyBlank(-132456,-65432,noMoveStage);
        MRoad = new BuyRoad(-132456,-65432,noMoveStage);
        MRoadRe = new BuyRoadRe(-132456,-65432,noMoveStage);
        MRoadReNgoai = new BuyRoadReNgoai(-132456,-65432,noMoveStage);
        MCanhRoad = new BuyCanhRoad(-132456,-65432,noMoveStage);
        MDirt.setTouchable(Touchable.disabled);
        MBlank.setTouchable(Touchable.disabled);
        MRoad.setTouchable(Touchable.disabled);
        MRoadRe.setTouchable(Touchable.disabled);
        MRoadReNgoai.setTouchable(Touchable.disabled);
        MCanhRoad.setTouchable(Touchable.disabled);
        MViaHe.setTouchable(Touchable.disabled);
        MViaHe.setColor(MViaHe.getColor().r,MViaHe.getColor().g,MViaHe.getColor().b,0.6f);
        MDirt.setColor(MDirt.getColor().r,MDirt.getColor().g,MDirt.getColor().b,0.6f);
        MBlank.setColor(MBlank.getColor().r,MBlank.getColor().g,MBlank.getColor().b,0.6f);
        MRoad.setColor(MRoad.getColor().r,MRoad.getColor().g,MRoad.getColor().b,0.6f);
        MCanhRoad.setColor(MCanhRoad.getColor().r,MCanhRoad.getColor().g,MCanhRoad.getColor().b,0.6f);
        MRoadRe.setColor(MRoadRe.getColor().r,MRoadRe.getColor().g,MRoadRe.getColor().b,0.6f);
        MRoadReNgoai.setColor(MRoadReNgoai.getColor().r,MRoadReNgoai.getColor().g,MRoadReNgoai.getColor().b,0.6f);
        bangScience = new Bang(-10000,-100,noMoveStage);
        bangTrash = new Bang(-10000,-100,noMoveStage);

        giaiThichHuuCo = new Waste(-10000,-100,noMoveStage,'o');
        giaiThichHuuCo.setSize(64,64);
        wastes.removeValue(giaiThichHuuCo,true);
        giaiThichVoCo = new Waste(-10000,-100,noMoveStage,'i');
        giaiThichVoCo.setSize(64,64);
        wastes.removeValue(giaiThichVoCo,true);
        giaiThichTaiChe = new Waste(-10000,-100,noMoveStage,'r');
        giaiThichTaiChe.setSize(64,64);
        wastes.removeValue(giaiThichTaiChe,true);
        giaiThichNguyHai = new Waste(-10000,-100,noMoveStage,'h');
        giaiThichNguyHai.setSize(64,64);
        wastes.removeValue(giaiThichNguyHai,true);
        luaChon1NhaRac = new WhiteButton(-345634,-66652,noMoveStage);
        luaChon1NhaRac.setWidth(32*15);
        luaChon2NhaRac = new WhiteButton(-345634,-66652,noMoveStage);
        luaChon2NhaRac.setWidth(32*16);
        luaChon3NhaRac = new WhiteButton(-345634,-66652,noMoveStage);
        luaChon3NhaRac.setWidth(32*22);
        luaChon4NhaRac = new WhiteButton(-345634,-66652,noMoveStage);
        luaChon4NhaRac.setWidth(32*12);
        luaChon5NhaRac = new WhiteButton(-345634,-66652,noMoveStage);
        luaChon5NhaRac.setWidth(32*28);
        bangFactory = new Bang(-10000,-100,noMoveStage);
        turtleBang = new Bang(-10000,100,noMoveStage);
        bangDaily = new Bang(10000,10000, noMoveStage);
        bangSoTay = new Bang(10000,10000,noMoveStage);
        bangFactory = new Bang(-10000,-10000,noMoveStage);
        turtleBang = new Bang(-10000,10000,noMoveStage);
        turtleBang.setColor(0,0,0,0.8f);
        turtleCross = new Cross(-10000,1000,noMoveStage);
        bangScienceCross = new Cross(-10000,-100,noMoveStage);
        bangTrashCross = new Cross(-10000,-100,noMoveStage);
        bangFactoryCross = new Cross(-10000,-100,noMoveStage);
        menuFoodCross = new Cross(-10000,-100,noMoveStage);
        dailyCross = new Cross(-10000,-100,noMoveStage);
        soTayCross = new Cross(-100000,100,noMoveStage);
        dailyQuest = new DailyQuest(475,Gdx.graphics.getHeight()-70,noMoveStage);
        bia = new Bia(10000,10000,noMoveStage,this);
        iceCream = new Kem(10000,10000,noMoveStage,this);
        pho = new Pho(10000,10000,noMoveStage,this);
        com = new Com(10000,10000,noMoveStage,this);
        xienBan = new XienBan(10000,10000,noMoveStage,this);
        menuFood = new Bang(-10000,1000, noMoveStage);
        pho = new Pho(10000,10000,noMoveStage,this);
        dark = new Dark(0,0,noMoveStage);
        dark.setTouchable(Touchable.disabled);
        line = new Line(32,Gdx.graphics.getHeight()-32*5-4,896,0,noMoveStage);
        line2 = new Line(32,32*2+8,896,0,noMoveStage);
        lineThongTin2 = new Line(32,Gdx.graphics.getHeight()-32*10-4,896,0,noMoveStage);
        lineThongTin = new Line(32,Gdx.graphics.getHeight()-32*7-4,896,0,noMoveStage);
        showAQI = new ShowAQI(0,0,noMoveStage);
        showAQI.setPosition(0,Gdx.graphics.getHeight()-showAQI.getHeight());
        calories = new Calories(0,0,stage);
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

            noMoveStage.addListener(new InputListener(){
                private Actor lastActor = null;
                @Override
                public boolean mouseMoved(InputEvent event, float x, float y) {
                    try{
                        MyActor actor = (MyActor) noMoveStage.hit(x,y,true);
                        if(thongTinMode) {
                            if(actor instanceof TreeButon){
                                thongTinNutCay = true;
                            }else {
                                thongTinNutCay = false;
                            }
                            if(actor instanceof creatMayLoc){
                                thongTinNutML = true;
                            }else {
                                thongTinNutML = false;
                            }
                            if(actor instanceof creatSign){
                                thongTinNutSign = true;
                            }else {
                                thongTinNutSign = false;
                            }
                            if(actor instanceof creatCamera){
                                thongTinNutCam = true;
                            }else {
                                thongTinNutCam = false;
                            }
                            if(actor instanceof SelectCamera){
                                thongTinNutSoiCam = true;
                            }else {
                                thongTinNutSoiCam = false;
                            }
                            if(actor instanceof BuyDirt){
                                thongTinDat = true;
                            }else {
                                thongTinDat = false;
                            }
                            if(actor instanceof BuyRoadRe){
                                thongTinNgaRe = true;
                            }else {
                                thongTinNgaRe = false;
                            }
                            if(actor instanceof BuyCanhRoad){
                                thongTinCanhRoad = true;
                            }else {
                                thongTinCanhRoad = false;
                            }
                            if(actor instanceof BuyRoad){
                                thongTinDuongThang = true;
                            }else {
                                thongTinDuongThang = false;
                            }
                            if(actor instanceof BuyBlank){
                                thongTinDuongTrong = true;
                            }else {
                                thongTinDuongTrong = false;
                            }
                            if(actor instanceof BuyRoadReNgoai){
                                thongTinVongCung = true;
                            }else {
                                thongTinVongCung = false;
                            }
                            if(actor instanceof BuyViaHe){
                                thongTinViaHe = true;
                            }else {
                                thongTinViaHe = false;
                            }
                        }

                    }catch (Exception ignored){}
                    Actor actor = noMoveStage.hit(x, y, true);

                    if (lastActor != null && lastActor instanceof  ButtonActor && lastActor != actor) {
                        lastActor.setColor(1, 1, 1, 1);
                    }

                    if (actor instanceof ButtonActor) {
                        actor.setColor(0, 1, 1, 1);
                    }

                    lastActor = actor;

                    return super.mouseMoved(event, x, y);
                }
            });
        stage.addListener(new InputListener(){
            @Override
            public boolean mouseMoved(InputEvent event, float x, float y) {
                try{
                    MyActor actor = (MyActor) stage.hit(x, y, true);
                    if (thongTinMode) {
                        if (actor instanceof FactoryCenter) {
                            thongTinFac = true;
                        } else {
                            thongTinFac = false;
                        }
                        if (actor instanceof HotelCenter) {
                            thongTinHotel = true;
                        } else {
                            thongTinHotel = false;
                        }
                        if (actor instanceof ScienceCenter) {
                            thongTinSaiUn = true;
                        } else {
                            thongTinSaiUn = false;
                        }
                        if (actor instanceof TrashCenter) {
                            thongTinTrashCenter = true;
                        } else {
                            thongTinTrashCenter = false;
                        }
                        if (actor instanceof Restaurant) {
                            thongTinRestaurant = true;
                        } else {
                            thongTinRestaurant = false;
                        }
                        if (actor instanceof Calories) {
                            thongTinThanhDoi = true;
                        } else {
                            thongTinThanhDoi = false;
                        }
                        if (actor instanceof ThapRua) {
                            thongTinThapRua = true;
                        } else {
                            thongTinThapRua = false;
                        }
                    }
                    float x1 = Math.round(mouseNoMoveStage.x/32f)*32+(32-stage.getCamera().position.x%32) - 32;
                    float y1 = Math.round(mouseNoMoveStage.y/32f)*32+(32-stage.getCamera().position.y%32) - 48;
                    deltaXYVector.set((float) Gdx.graphics.getWidth() /2 - x1, (float) Gdx.graphics.getHeight() /2 - y1+2);
                    float x2 = stage.getViewport().getCamera().position.x - deltaXYVector.x;
                    float y2 = stage.getViewport().getCamera().position.y - deltaXYVector.y;
                    MyActor actorBlock = (MyActor) stage.hit(x2, y2, true);
                    if(actorBlock == null) {
                        isCanDatDirt=true;
                    }else {
                        isCanDatDirt=false;
                    }
                    if(actorBlock instanceof BuyDirt) {
                        isCanDatThingsOnDirt=true;
                    }else {
                        isCanDatThingsOnDirt=false;
                    }
                    if(actorBlock instanceof Waste){
                        isQuet=1;
                    }else if(actorBlock instanceof WasteFire){
                        isQuet=2;
                    }else {
                        isQuet=0;
                    }
                    if(actorBlock instanceof MordernDoor
                        || actorBlock instanceof Restaurant
                        || actorBlock instanceof ScienceCenter
                        || actorBlock instanceof FactoryCenter
                        || actorBlock instanceof HotelCenter
                        || actorBlock instanceof Water
                        || actorBlock instanceof CornerPool
                        || actorBlock instanceof WallPool
                        //|| actorBlock instanceof Tree
                        || actorBlock instanceof TrafficLight
                        || actorBlock instanceof Player
                        || actorBlock instanceof People
                        || actorBlock instanceof Car
                        || actorBlock instanceof NormalCamera
                        || actorBlock instanceof MayLoc
                        || actorBlock instanceof Sign
                        || actorBlock instanceof Castle
                        || actorBlock instanceof House1
                        || actorBlock instanceof House2
                        || actorBlock instanceof House3
                        || actorBlock instanceof TruSo
                        || actorBlock instanceof Rice
                        || actorBlock instanceof Truck
                        || actorBlock instanceof ThapRua
                        //|| actorBlock instanceof Waste
                        //|| actorBlock instanceof WasteFire
                        || actorBlock instanceof Blood
                        || actorBlock instanceof Boat
                        || actorBlock instanceof River
                        || actorBlock instanceof LoadingPlant
                        || actorBlock instanceof Chimney
                        || actorBlock instanceof DoorHouse
                        || actorBlock instanceof partofCastle
                        || actorBlock instanceof RoofHouse
                        || actorBlock instanceof SpecialRoof
                        || actorBlock instanceof Wall
                        || actorBlock instanceof Waterwell
                        || actorBlock instanceof WindowHouse
                    ) {
                        isCanDao=false;
                    }else {
                        isCanDao=true;
                    }
                }catch (Exception e){}
                return super.mouseMoved(event, x, y);
            }
        });
    }

    @Override
    public void show() {
        dailyQuest. addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                openDailyQuest = true;
            }
        });
        scienceDoor.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                showBangScience(32,32);
            }
        });
        trashDoor.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(game.trashScreen);
            }
        });
        factoryDoor.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                showBangFactory(32,32);
            }
        });
        dailyCross.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                openDailyQuest = false;
            }
        });
        soTayCross.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                openSoTay = false;
                bangSoTay.setPosition(32000,32000);
                soTayCross.setPosition(20000, 10000);
            }
        });

        xayDungButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                moXayDung();
            }
        });
        congCuButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                moCongCu();
            }
        });
        xeCoButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                moXeCo();
            }
        });
        xeCoButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                moXeCo();
            }
        });
        bangScienceCross.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                closeScienceBoard();
            }
        });
        bangTrashCross.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                closeTrashBoard();
            }
        });
        bangFactoryCross.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                closeFactoryBoard();
            }
        });
        turtleCross.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                isInTurtleMap = false;
            }
        });

        buttonLeftVLLD.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                creatVLLD.thayVLL();
            }
        });
        buttonRightVLLD.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                creatVLLD.thayVLR();
            }
        });
        buyRoad.direction = 'D';
        buyRoadRe.type = TypeRoadRe.CaHai;
        buyRoadRe.direc = 'u';
        buyRoadReNgoai.setRotation(90);
        buyCanhRoad.setRotation(90);
        soTay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                openSoTay = true;
                bangSoTay.setPosition(32,32);
                soTayCross.setPosition(Gdx.graphics.getWidth()-32*2, Gdx.graphics.getHeight()-32*2);
                soTayCross.toFront();
            }
        });
        luaChon1NhaRac.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.soRacHuuCo>=10){
                    GameState.greenscore+=10;
                    GameState.soRacHuuCo-=10;
                }else {
                    new FloatingNews(luaChon1NhaRac.getX(),luaChon1NhaRac.getY(),noMoveStage,"Bạn không đủ đồ",Color.YELLOW);
                }
            }
        });
        luaChon2NhaRac.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.soRacNguyHai>=2){
                    GameState.ernegy+=5000;
                    GameState.soRacNguyHai-=2;

                }else {
                    new FloatingNews(luaChon2NhaRac.getX(),luaChon2NhaRac.getY(),noMoveStage,"Bạn không đủ đồ",Color.YELLOW);
                }
            }
        });
        luaChon3NhaRac.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.soRacNguyHai>=2 && GameState.soRacTaiChe>=1){
                    GameState.soRacNguyHai-=2;
                    GameState.soRacTaiChe-=1;
                    GameState.levelcongnghexanh+=3;
                }else {
                    new FloatingNews(luaChon3NhaRac.getX(),luaChon3NhaRac.getY(),noMoveStage,"Bạn không đủ đồ",Color.YELLOW);
                }
            }
        });
        luaChon4NhaRac.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.soRacTaiChe>=10){
                    GameState.soRacTaiChe-=10;
                    GameState.money+=2500;
                }else {
                    new FloatingNews(luaChon4NhaRac.getX(),luaChon4NhaRac.getY(),noMoveStage,"Bạn không đủ đồ",Color.YELLOW);
                }
            }
        });
        luaChon5NhaRac.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.soRacTaiChe>=12 && GameState.soRacVoCo>=20){
                    GameState.soRacTaiChe-=12;
                    GameState.soRacVoCo-=20;
                    GameState.soMLtoidacothemua++;
                }else {
                    new FloatingNews(luaChon5NhaRac.getX(),luaChon5NhaRac.getY(),noMoveStage,"Bạn không đủ đồ",Color.YELLOW);
                }
            }
        });
        buyBroom.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(!isCoChoi){
                    if(GameState.money>=300) {
                        isCoChoi = true;
                        noMoveStage.addActor(broom);
                        broom.toFront();
                        GameState.money-=300;
                        buyBroom.setColor(Color.GRAY);
                    }
                }else {
                    new FloatingNews(buyBroom.getX(), buyBroom.getY(), noMoveStage,"ĐÃ MUA",Color.GREEN);
                }
            }
        });
        buyShovel.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(!isCoXeng){
                    if(GameState.money>=300) {
                        isCoXeng = true;
                        noMoveStage.addActor(shovel);
                        shovel.toFront();
                        GameState.money-=300;
                        buyShovel.setColor(Color.GRAY);
                    }
                }else {
                    new FloatingNews(buyShovel.getX(), buyShovel.getY(), noMoveStage,"ĐÃ MUA",Color.GREEN);
                }
            }
        });
        buyTrashTruck.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(!isCoXeRac){
                    if(GameState.money>=800) {
                        isCoXeRac = true;
                        GameState.money-=800;
                        buyTrashTruck.setColor(Color.GRAY);
                    }
                }
            }
        });
        buyTaxi.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(!isCoTaxi){
                    if(GameState.money>=400) {
                        isCoTaxi = true;
                        GameState.money-=400;
                        buyTaxi.setColor(Color.GRAY);
                    }
                }
            }
        });
        buyPolice.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(!isCoPolice){
                    if(GameState.money>=700) {
                        isCoPolice = true;
                        GameState.money-=700;
                        buyPolice.setColor(Color.GRAY);
                    }
                }
            }
        });
        buyViaHe.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>=10) {
                    GameState.soViaHe++;
                    GameState.money-=10;
                    new FloatingNews(0,0,noMoveStage,"2457i8756nrhybfcatvhgcdtsctgn",Color.RED);
                    //them o nhiem vao day
                }

            }
        });
        buyRoad.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>=12) {
                    GameState.soRoad++;
                    GameState.money-=12;
                    //them o nhiem vao day
                }

            }
        });
        buyRoadRe.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>=12) {
                    GameState.soReRoad++;
                    GameState.money-=12;
                    //them o nhiem vao day
                }

            }
        });
        buyCanhRoad.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>=4) {
                    GameState.soCanhRoad++;
                    GameState.money-=4;
                    //them o nhiem vao day
                }
            }
        });
        buyBlank.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>=3) {
                    GameState.soBlankRoad++;
                    GameState.money-=3;
                    //them o nhiem vao day
                }

            }
        });
        buyDirt.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>=3) {
                    GameState.soDat++;
                    GameState.money-=3;
                    //them o nhiem vao day
                }
            }
        });
        buyRoadReNgoai.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money>=3) {
                    GameState.soVongCungNgoai++;
                    GameState.money-=3;
                    //them o nhiem vao day
                }

            }
        });



        menuFoodCross.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                closeMenuFood();
            }
        });

        replay.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                replay.setPosition(-435642,-6434256);
                dark.setColor(dark.getColor().r,dark.getColor().g,dark.getColor().b,0);
                GameState.reset();
                game.setScreen(game.menuScreen);
            }
        });

        thongTinButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                dongCheTao();
                isOpenSetting = false;
                inCreate = false;
                dongCaiDat();
                moThongTin();
            }
        });

        nghienCuuButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {

                dongCheTao();
                isOpenSetting = false;
                inCreate = false;
                dongCaiDat();
                moNghienCuu();

            }
        });

        nangCapMLKK.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(GameState.money >= 1000 && GameState.ernegy >= 5){
                    try{
                        MLKKs.get(sohieucuaMLKKdangchondenangcap).level++;
                        if(nhiemvu2 == 3){
                            nhiemvu2 = 77;
                            GameState.money += 200;
                        }
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

        nangCapGTX.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(isGTX && GameState.money >= 1000 && GameState.ernegy >= 50 && GameState.greenscore >= 20){
                    GameState.levelgiaothongxanh++;
                    GameState.money -= 1000;
                    GameState.ernegy -= 50;
                    GameState.greenscore -= 20;
                    if(nhiemvu2 == 4){
                        nhiemvu2 = 77;
                        GameState.money += 200;
                    }
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
                inCreate = true;
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
                            isSoiCam = true;
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
                            isSoiCam = false;
                        }

                    }catch (Exception ignored){}

                }
            });
        }catch (Exception ignored) {
        }

        caiDatButton.addListener(new ClickListener() {

            public void clicked(InputEvent event, float x, float y) {
                dongCheTao();
                moCaiDat();
                inCreate = false;
            }
        });



        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = StartGame.fontTextField;
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
        nen.setVolume(0.1f);
        nen.play();
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLACK);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        mouseNoMoveStage.set(Gdx.input.getX(), Gdx.input.getY());
        mouseStage.set(Gdx.input.getX(),Gdx.input.getY());
        noMoveStage.getViewport().unproject(mouseNoMoveStage);
        stage.getViewport().unproject(mouseStage);
        if (Gdx.input.isKeyJustPressed(Input.Keys.H)){
            if(thongTinMode){
                thongTinMode = false;
                new FloatingNews(200,200,noMoveStage,"Tắt chế độ gợi ý",Color.BLACK);
            }else {
                thongTinMode = true;
                new FloatingNews(200,200,noMoveStage,"Bật chế độ gợi ý",Color.BLACK);
            }
        }
        if(isInTurtleMap){
            image.setPosition(32*20,Gdx.graphics.getHeight()-32*3-25-20);
            image2.setPosition(32*20,Gdx.graphics.getHeight()-32*6-100-20);
            image3 .setPosition(32*20, Gdx.graphics.getHeight() - 32*7-125-20);
            playTurtleMap.setPosition(350,32);
            turtleBang.setPosition(32,32);
            turtleCross.setPosition(Gdx.graphics.getWidth()-32*2,Gdx.graphics.getHeight()-32*2);
            playTurtleMap.toFront();
            image3.toFront();
            image.toFront();
            image2.toFront();
            image4.setPosition(32*22 , Gdx.graphics.getHeight()-32*4-50-20);
            image5.setPosition(32*22 , Gdx.graphics.getHeight()-32*5-75-20);
            image4.toFront();
            image5 .toFront();
        }else {
            turtleBang.setPosition(10000,10000);
            playTurtleMap.setPosition(400000,320000);
            turtleCross.setPosition(400000,320000);
            image.setPosition(32*2000,Gdx.graphics.getHeight()-32*3-25);
            image2.setPosition(32*2000,Gdx.graphics.getHeight()-32*6-100);
            image3 .setPosition(32*2000, Gdx.graphics.getHeight() - 32*7-125);
            image4.setPosition(32*2200 , Gdx.graphics.getHeight()-32*4-50-20);
            image5.setPosition(32*2200 , Gdx.graphics.getHeight()-32*5-75-20);

        }
        if(openSoTay){
            doVui .setPosition(32*12,32*2);
            green.setPosition(32*5, 32*2);
            shock.setPosition(32*19 , 32*2);
            doVui.toFront();
            green.toFront();
            shock.toFront();
        }else{
            doVui.setPosition(10000,10000);
            green.setPosition(10000,10000);
            shock.setPosition(10000,10000);
        }
        if(inDoVui){
            sai.setPosition(32*17 , Gdx.graphics.getHeight() - 32*8+16);
            dung.setPosition(32 *10 ,Gdx.graphics.getHeight() - 32*8+16);
            sai.toFront();
            dung.toFront();
        }else{
            dung.setPosition(10000,10000);
            sai.setPosition(10000,10000);
        }if(inGreenCoBan || inShock){
            hieu.setPosition(32*12 , Gdx.graphics.getHeight() - 32*8);
            hieu.toFront();
        }else{
            hieu.setPosition(10000,10000);
        }

        tanggiamdanso();
        xuLyCNXVaGTX();
        ktHetEven();
        calculAQI();
        createCar();
        luongThucAn();
        xulyngaydem();
        denXanhDenDo();
        racTroiSong();
        tinhThangThua();
        batTatNutMoVaXuLyTrongNutMo();
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                if(whatActionIfClickMouse.equals("DatSan")){
                    taoMoDatKhoi();
                }
            }
        },0);
        OrthographicCamera c = (OrthographicCamera) stage.getViewport().getCamera();
        if(c.zoom == 1f) {
            if ((float) Gdx.graphics.getWidth() / 2 - player.getWidth() / 2 <= player.getX() && player.getX() <= (float) (WINDOW_WIDTH - Gdx.graphics.getWidth() / 2) - player.getWidth() / 2) {
                stage.getCamera().position.x = player.getX() + player.getWidth() / 2;
            } else if ((float) Gdx.graphics.getWidth() / 2 - player.getWidth() / 2 > player.getX()) {
                stage.getCamera().position.x = Gdx.graphics.getWidth() / 2f;//day la tinh binh thuong
                //stage.getCamera().position.x = player.getX() + player.getWidth() / 2;//day la tinh cho player co the di vuot map
            } else if (player.getX() > (float) (WINDOW_WIDTH - Gdx.graphics.getWidth() / 2) - player.getWidth() / 2) {
                stage.getCamera().position.x = WINDOW_WIDTH - Gdx.graphics.getWidth() / 2f;
                //stage.getCamera().position.x = player.getX() + player.getWidth() / 2;//day la tinh cho player co the di vuot map
            }
            if ((float) Gdx.graphics.getHeight() / 2 - player.getHeight() / 2 <= player.getY() && player.getY() <= (800 - (float) Gdx.graphics.getHeight() / 2) - player.getHeight() / 2) {
                stage.getCamera().position.y = player.getY() + player.getHeight() / 2;
            } else if ((float) Gdx.graphics.getHeight() / 2 - player.getHeight() / 2 > player.getY()) {
                stage.getCamera().position.y = Gdx.graphics.getHeight() / 2f;
                //stage.getCamera().position.y = player.getY() + player.getHeight() / 2;
            } else if (player.getY() > (800 - (float) Gdx.graphics.getHeight() / 2) - player.getHeight() / 2) {
                stage.getCamera().position.y = (800 - (float) Gdx.graphics.getHeight() / 2);
                //stage.getCamera().position.y = player.getY() + player.getHeight() / 2;
            }
        }

        calories.setPosition(player.getX() , player.getY()+35);

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
        if(nhiemVuTanBinh && thuTuNhiemVuTanBinh == 1){
            arrowNoMove.setRotation(0);
            arrowNoMove.setPosition( 100000,1000000);
            arrow.setPosition(32*27-16, 19*32-16);
            arrow.toFront();
            nhiemVuTanBinh = false;
        }if(nhiemVuTanBinh && thuTuNhiemVuTanBinh == 2){
            arrow.setPosition(1000034,199999);
            arrowNoMove.setPosition(32*18, Gdx.graphics.getHeight()-50);
            arrowNoMove.toFront();
            nhiemVuTanBinh = false;
        }if(nhiemVuTanBinh&& thuTuNhiemVuTanBinh ==3){
            arrowNoMove.setRotation(-90);
            arrowNoMove.toFront();
            arrowNoMove.setPosition(32*22, 32*12);
            nhiemVuTanBinh = false;
        }if(nhiemVuTanBinh && thuTuNhiemVuTanBinh == 4){
            arrowNoMove.setRotation(180);
            arrowNoMove.setPosition(Gdx.graphics.getWidth()-10,Gdx.graphics.getHeight()-80);
            arrowNoMove.toFront();
            nhiemVuTanBinh = false;
        }if(nhiemVuTanBinh&& thuTuNhiemVuTanBinh == 5){
            arrowNoMove.setRotation(180);
            arrowNoMove.setPosition(Gdx.graphics.getWidth()-95,Gdx.graphics.getHeight()-85);
            nhiemVuTanBinh = false;
        }if(nhiemVuTanBinh&& thuTuNhiemVuTanBinh == 6){
            arrow.setRotation(0);
            arrow.setPosition(1080,32*20);
            arrow.toFront();
            arrowNoMove.setPosition(100000,100000);
            nhiemVuTanBinh = false;
        }

        if(isEating){
            player.setPosition(restaurant.getX()+restaurant.getWidth()/2, restaurant.getY() + restaurant.getHeight()/2);
            player.remove();
        }else {
            stage.addActor(player);

        }
        if(openDailyQuest){
            bangDaily.setPosition(32,32);
            dailyCross.setPosition(Gdx.graphics.getWidth()-32*2,Gdx.graphics.getHeight()-32*2);
        }else{
            bangDaily.setPosition(10000,10000);
            dailyCross.setPosition(10000,10000);
        }

        if (Gdx.input.justTouched()) {

            cameraPosition.x = mouseStage.x;
            cameraPosition.y = mouseStage.y;

            if(Master.whatActionIfClickMouse.equals("planttree")){
                if(Master.amountSeed > 0 ) {
                   boolean isFree = false;
                   if(stage.hit(mouseStage.x,mouseStage.y,true) instanceof Ground2
                       ||stage.hit(mouseStage.x,mouseStage.y,true) instanceof BuyDirt
                       ||stage.hit(mouseStage.x,mouseStage.y,true) instanceof Randomblock){
                       isFree = true;
                   }
                   if(isFree){
                       Master.amountSeed--;
                       GameState.greenscore += 10;
                       new LoadingPlant(mouseStage.x-16,mouseStage.y-16,stage);
                       arrow.setPosition(10000,100000);
                       soCayConLai--;
                       if(soCayConLai ==0){
                           if(nhiemvu2 == 1){
                               nhiemvu2 = 77;
                               GameState.money += 200;
                           }
                       }
                   }
                }
            } else if (Master.whatActionIfClickMouse.equals("createMayLoc")) {
                if(Master.soMayLoc > 0 ) {
                    boolean isFree = false;
                    if(stage.hit(mouseStage.x-16,mouseStage.y-16,true) instanceof ScienceCenter
                        ||stage.hit(mouseStage.x-16,mouseStage.y-16,true) instanceof FactoryCenter
                        ||stage.hit(mouseStage.x-16,mouseStage.y-16,true) instanceof HotelCenter){
                        thuTuNhiemVuTanBinh =1000;
                        arrow.setPosition(10000,10000);
                        arrowNoMove.setPosition(10000,10000);
                        isFree = true;
                    }
                    if(isFree){
                        Master.nhapTenMLKK();
                    }else{
                        whatActionIfClickMouse = "move";
                        taoMayLockk.textureRegion = new TextureRegion(taoMayLockk.texture);
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
                        if(rec.contains(mouseStage.x,mouseStage.y)){
                            isFree = false;
                            break;
                        }
                    }
                    if(isFree){
                        Master.soBienCam--;
                        new Sign(mouseStage.x-16,mouseStage.y,random.nextBoolean(),stage);
                        if(nhiemvu2 == 5){
                            nhiemvu2 = 77;
                            GameState.money += 200;
                        }
                    }
                }
            }else if(Master.whatActionIfClickMouse.equals("DatSan") && creatVLLD.soVL >0){
                float x = stage.getViewport().getCamera().position.x - deltaXYVector.x;
                float y = stage.getViewport().getCamera().position.y - deltaXYVector.y;
                if(isCanDatThingsOnDirt) {
                    switch (creatVLLD.type){
                        case DuongTrong -> {
                            BuyBlank blank = new BuyBlank(x, y,stage);
                            blank.setZIndex(2000);
                            VLLDs.add(blank);
                            GameState.soBlankRoad--;
                        }
                        case DuongThang -> {
                            BuyRoad a = new BuyRoad(x, y,stage);
                            a.setZIndex(2000);
                            a.direction = MRoad.direction;
                            VLLDs.add(a);
                            GameState.soRoad--;
                        }
                        case NgaRe -> {
                            BuyRoadRe a = new BuyRoadRe(x, y,stage);
                            a.setZIndex(2000);
                            a.direc = MRoadRe.direc;
                            a.type = MRoadRe.type;
                            VLLDs.add(a);
                            GameState.soReRoad--;
                        }
                        case CanhRoad -> {
                            BuyCanhRoad a = new BuyCanhRoad(x+16, y+16,stage);
                            a.setZIndex(2000);
                            a.setRotation(MCanhRoad.getRotation());
                            VLLDs.add(a);
                            GameState.soCanhRoad--;
                        }
                        case ViaHe -> {
                            BuyViaHe viaHe = new BuyViaHe(x+16, y+16,stage);
                            viaHe.setRotation(MViaHe.getRotation());
                            viaHe.type = MViaHe.type;
                            viaHe.setZIndex(2000);
                            VLLDs.add(viaHe);
                            GameState.soViaHe--;
                        }
                        case VongCung -> {
                            BuyRoadReNgoai a = new BuyRoadReNgoai(x+16, y+16,stage);
                            a.setZIndex(2000);
                            a.setRotation(MRoadReNgoai.getRotation());
                            VLLDs.add(a);
                            GameState.soVongCungNgoai--;
                        }
                    }
                }else if(isCanDatDirt){
                    switch (creatVLLD.type){
                        case Dat -> {
                            BuyDirt dirt = new BuyDirt(x, y,stage);
                            dirt.setZIndex(1);
                            VLLDs.add(dirt);
                            GameState.soDat--;
                        }
                    }
                }else {
                    new FloatingNews(x,y,stage,"Không thể đặt ở đây",Color.RED);
                }
                whatActionIfClickMouse = "move";
                creatVLLD.textureRegion = new TextureRegion(creatVLLD.texture);
                MRoad.setPosition(-3425365,-56754);
                MRoadReNgoai.setPosition(-3425365,-56754);
                MCanhRoad.setPosition(-3425365,-56754);
                MBlank.setPosition(-3425365,-56754);
                MRoadRe.setPosition(-3425365,-56754);
                MDirt.setPosition(-3425365,-56754);
                MViaHe.setPosition(-3425365,-56754);
            }else if(Master.whatActionIfClickMouse.equals("CamXeng")){
                float x = stage.getViewport().getCamera().position.x - deltaXYVector.x;
                float y = stage.getViewport().getCamera().position.y - deltaXYVector.y;
                if(isCanDao){
                    //BuyDirt a = new BuyDirt(x, y,stage);
                    //a.setZIndex(stage.hit(x, y, true).getZIndex()+1);
                    try {
                        MyActor myActor = (MyActor) stage.hit(x,y,true);
                        roadArray.removeValue(myActor.getBound(),true);
                        reArray.removeValue(myActor,true);
                        myActor.remove();
                        if(nhiemvu3== 2){
                            nhiemvu3= 77;
                            GameState.money += 200;
                        }
                    }catch (Exception ignored){
                    }
                    MDirt.setPosition(-32456,-3456889);
                    //VLLDs.add(a);
                    whatActionIfClickMouse = "move";
                    xengButton.textureRegion = new TextureRegion(xengButton.texture);
                }else {
                    new FloatingNews(x,y,stage,"Không thể đào chỗ này",Color.RED);
                }
            }else if(Master.whatActionIfClickMouse.equals("CamChoi")){
                float x = stage.getViewport().getCamera().position.x - deltaXYVector.x;
                float y = stage.getViewport().getCamera().position.y - deltaXYVector.y;
                if(isQuet!=0){
                    //BuyDirt a = new BuyDirt(x, y,stage);
                    //a.setZIndex(stage.hit(x, y, true).getZIndex()+1);
                    try {
                        MyActor myActor = (MyActor) stage.hit(x,y,true);
                        if(myActor instanceof WasteFire){
                            isCoChoi=false;
                            buyBroom.setColor(1,1,1,1);
                            new FloatingNews(Gdx.graphics.getWidth()/2f-200,Gdx.graphics.getHeight()/2f
                                ,noMoveStage,"Chổi đã bị hỏng do cháy.",Color.RED);
                        }else if(myActor instanceof Waste){
                            switch (((Waste) myActor).getCostume()){
                                case 'o' -> GameState.soRacHuuCo++;
                                case 'i' -> GameState.soRacVoCo++;
                                case 'r' -> GameState.soRacTaiChe++;
                                case 'h' -> GameState.soRacNguyHai++;
                            }
                        }
                        myActor.remove();
                    }catch (Exception ignored){}
                    MDirt.setPosition(-32456,-3456889);
                    whatActionIfClickMouse = "move";
                    choiButton.textureRegion = new TextureRegion(choiButton.texture);
                }else {
                    new FloatingNews(x,y,stage,"Không có rác ở đây ",Color.RED);
                }
            }else {
                new AnimationClickMouse(cameraPosition.x - 32, cameraPosition.y - 32, stage);
                clickSound.play(amluong);
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
                if(nhiemvu3 == 1){
                    if(normalCamera.name.length() >= 20){
                        nhiemvu3 = 77;
                        GameState.money += 200;
                    }
                }
            }
        }

        if(isOpenSetting){
            noMoveStage.addActor(button1S);
            noMoveStage.addActor(button2S);
            noMoveStage.addActor(button3S);
            button1S.setPosition(Gdx.graphics.getWidth() * 0.07f, Gdx.graphics.getHeight() * 0.6f-40);
            button2S.setPosition(Gdx.graphics.getWidth() * 0.07f, Gdx.graphics.getHeight() * 0.6f-40-80);
            button3S.setPosition(Gdx.graphics.getWidth() * 0.07f, Gdx.graphics.getHeight() * 0.6f-40-80*2);
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
        if(inCreate){
            if(thuTuNhiemVuTanBinh == 1){
                nhiemVuTanBinh = true;
                thuTuNhiemVuTanBinh = 3;
            }
        }
        if(player.getBound().overlaps(restaurant.getBound())){
            if(player.getY()<restaurant.getY()){
                player.toFront();
                if(player.getY() > restaurant.getY()-5){
                    player.setY(restaurant.getY()-5);
                }
            }else {
                restaurant.toFront();
                restaurant.toFront();
                if(player.getY() < restaurant.getY()+10){
                    player.setY(restaurant.getY()+10);
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
                factoryDoor.toFront();
                if(player.getY() < factoryCenter.getY()+10){
                    player.setY(factoryCenter.getY()+10);
                }
            }
        }
        if(player.getBound().overlaps(trashCenter.getBound())){
            if(player.getY()<trashCenter.getY()){
                player.toFront();
                if(player.getY() > trashCenter.getY()-5){
                    player.setY(trashCenter.getY()-5);
                }
            }else {
                trashCenter.toFront();
                trashDoor.toFront();
                if(player.getY() < trashCenter.getY()+10){
                    player.setY(trashCenter.getY()+10);
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

        xuLyNenMuaVaCamXucNguoiDan();

        stage.act();
        truck.toFront();
        stage.draw();
        for(Waste a : wastes){
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.rect(a.getBound().getX()-(stage.getCamera().position.x-Gdx.graphics.getWidth()/2f), a.getBound().getY()-(stage.getCamera().position.y-Gdx.graphics.getHeight()/2f), a.getBound().getWidth(), a.getBound().getHeight());
            shapeRenderer.end();
        }
        vietChuDuoi();
        if(WLK == 'L'){
            batch.begin();
            batch.draw(sadIcon,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
            batch.end();
        }
        arrow.toFront();
        noMoveStage.draw();
        noMoveStage.act();
        vietChuTren();
    }

    private void denXanhDenDo(){
        if(timeOfDay%(60*30)<60*5){
            isDenDo = true;
        } else {
            isDenDo = false;
        }
    }
    private void vietTypeVLLD(){
        switch (creatVLLD.type){
            case DuongTrong -> layout.setText(game.font3, "Đường trống");
            case DuongThang -> layout.setText(game.font3, "Đường thẳng");
            case NgaRe -> layout.setText(game.font3, "Khúc rẽ trong");
            case ViaHe -> layout.setText(game.font3, "Vỉa hè");
            case VongCung -> layout.setText(game.font3, "Khúc rẽ ngoài");
            case CanhRoad -> layout.setText(game.font3, "Cạnh đường ");
            case Dat -> layout.setText(game.font3, "Đất");
        }
    }
    private void vietChuDuoi(){
        if(this.dark.getColor().a == 0) {
            batch.begin();
            game.font.draw(batch, "" + amountSeed, Gdx.graphics.getWidth() - 100+32, Gdx.graphics.getHeight() - 10);
            game.font.draw(batch, "" + soMayLoc, Gdx.graphics.getWidth() - 150+32, Gdx.graphics.getHeight() - 10);
            game.font.draw(batch, "" + soCamera, Gdx.graphics.getWidth() - 200+32, Gdx.graphics.getHeight() - 10);
            game.font.draw(batch, "" + soBienCam, Gdx.graphics.getWidth() - 250+32, Gdx.graphics.getHeight() - 10);
            game.font.draw(batch, "" + creatVLLD.soVL, Gdx.graphics.getWidth() - 400, Gdx.graphics.getHeight() - 10);
            vietTypeVLLD();
            game.font3.draw(batch, layout, creatVLLD.getX()+creatVLLD.getWidth()/2f- layout.width/2f, Gdx.graphics.getHeight() - 70);
            game.font.draw(batch, String.valueOf(Math.round(AQI)), 0, Gdx.graphics.getHeight() - 20);
            try {
                layout.setText(game.font3, "Camera: " + normalCameras.get(soCuaCameraDangLooking).name);
            } catch (Exception e) {
                layout.setText(game.font3, "Chưa có camera");
            }
            game.font3.draw(batch, layout, cameraLooking.getX()+cameraLooking.getWidth()/2f-layout.width/2f, Gdx.graphics.getHeight() - 70);
            batch.end();
        }
    }
    private void vietChuTren(){
        batch.begin();

        if(thongTinMode){
            if(thongTinNutCay){
                game.fontTextField.draw(batch, "Tắt/bật chế độ trồng cây", 700-20, Gdx.graphics.getHeight() - 120);
            }
            if(thongTinNutML){
                game.fontTextField.draw(batch, "Tắt/bật chế độ đặt máy lọc", 700-80-20, Gdx.graphics.getHeight() - 120);
            }
            if(thongTinNutCam){
                game.fontTextField.draw(batch, "Tắt/bật chế độ đặt camera", 700-80*2-20, Gdx.graphics.getHeight() - 120);
            }
            if(thongTinNutSign){
                game.fontTextField.draw(batch, "Tắt/bật chế độ cắm biển cấm", 700-80*3-20, Gdx.graphics.getHeight() - 120);
            }
            if(thongTinNutSoiCam){
                game.fontTextField.draw(batch, "Soi camera", 700-80*4, Gdx.graphics.getHeight() - 120);
            }
            if(thongTinDat){
                game.font3.draw(batch, "Chỉ đặt được ở khoảng trống (nơi không có gì)",  buyDirt.getX(),buyDirt.getY());
            }
            if(thongTinViaHe){
                game.font3.draw(batch, "Chỉ đặt được trên đất", buyViaHe.getX(), buyViaHe.getY());
            }
            if(thongTinVongCung){
                game.font3.draw(batch, "Chỉ đặt được trên đất", buyRoadReNgoai.getX(), buyRoadReNgoai.getY());
            }
            if(thongTinCanhRoad){
                game.font3.draw(batch, "Chỉ đặt được trên đất", buyCanhRoad.getX(), buyCanhRoad.getY());
            }
            if(thongTinDuongThang){
                game.font3.draw(batch, "Chỉ đặt được trên đất", buyRoad.getX(), buyRoad.getY());
            }
            if(thongTinDuongTrong){
                game.font3.draw(batch, "Chỉ đặt được trên đất", buyBlank.getX(), buyBlank.getY());
            }
            if(thongTinNgaRe){
                game.font3.draw(batch, "Chỉ đặt được trên đất", buyRoadRe.getX(), buyRoadRe.getY());
            }
            if(thongTinDatDuongThang){
                game.font3.draw(batch, "Ấn phím \"r\" để xoay", MRoad.getX()+MRoad.getWidth(), MRoad.getY()+25);
            }
            if(thongTinDatCanhRoad){
                game.font3.draw(batch, "Ấn phím \"r\" để xoay", MCanhRoad.getX()+MCanhRoad.getWidth(), MCanhRoad.getY()+25);
            }
            if(thongTinDatNgaRe){
                game.font3.draw(batch, "Ấn phím \"r\" để xoay",MRoadRe.getX()+MRoadRe.getWidth(), MRoadRe.getY()+25*2+12.5f);
                game.font3.draw(batch, "Ấn phím \"e\" để đổi kiểu ngã rẽ",MRoadRe.getX()+MRoadRe.getWidth(), MRoadRe.getY()+25+12.5f);
            }
            if(thongTinDatVongCung){
                game.font3.draw(batch, "Ấn phím \"r\" để xoay", MRoadReNgoai.getX()+MRoadReNgoai.getWidth(), MRoadReNgoai.getY()+25);
            }
            if(thongTinDatViaHe){
                game.font3.draw(batch, "Ấn phím \"r\" để xoay", MViaHe.getX()+MViaHe.getWidth(), MViaHe.getY()+25*2+12.5f);
                game.font3.draw(batch, "Ấn phím \"e\" để đổi kiểu vỉa hè",MViaHe.getX()+MViaHe.getWidth(), MViaHe.getY()+25+12.5f);
            }
            if(thongTinFac){
                chu1.setPosition(factoryCenter.getX()+factoryCenter.getWidth(), factoryCenter.getY()+factoryCenter.getHeight()/2f+25);
                chu2.setPosition(factoryCenter.getX()+factoryCenter.getWidth(), factoryCenter.getY()+factoryCenter.getHeight()/2f);
                chu1.text = "Nhà máy đa ngành nhất Hà Nội";
                chu2.text = "Hoạt động lâu năm, đóng góp lớn vào lượng khí thải";
            }else if(thongTinHotel){
                chu1.setPosition(hotelCenter.getX()+hotelCenter.getWidth(), hotelCenter.getY()+hotelCenter.getHeight()/2f+12.5f);
                chu1.text = "Khách sạn Hà Nội Daewoo";
            }else if(thongTinSaiUn){
                chu1.setPosition(scienceCenter.getX()+scienceCenter.getWidth(), scienceCenter.getY()+scienceCenter.getHeight()/2f+12.5f);
                chu1.text = "Trụ sở khoa học, nơi bạn làm việc";
            }else if(thongTinTrashCenter){
                chu1.setPosition(trashCenter.getX()+trashCenter.getWidth(), trashCenter.getY()+trashCenter.getHeight()/2f+12.5f);
                chu1.text = "Trung tâm xử lý rác thải";
            }else if(thongTinRestaurant){
                chu1.setPosition(restaurant.getX()+restaurant.getWidth(), restaurant.getY()+restaurant.getHeight()/2f+12.5f);
                chu1.text = "Nhà hàng view hồ Gươm San Dining";
            }else if(thongTinThapRua){
                chu1.setPosition(thapRua.getX()+thapRua.getWidth(), thapRua.getY()+thapRua.getHeight()/2f+12.5f);
                chu1.text = "Tháp Rùa";
            }else if(thongTinThanhDoi){
                chu1.setPosition(calories.getX()-32*2, calories.getY()+calories.getHeight()+25);
                chu1.text = "Thanh đói của player, khi hết thanh player sẽ thua vì đói";
            }else {
                chu1.text = "";
                chu2.text = "";
            }
        }else {
            chu1.text = "";
            chu2.text = "";
        }

        chu1.toFront();
        chu2.toFront();
        if(thongTinMode){
            if(thongTinNutCay){
                game.fontTextField.draw(batch, "Tắt/bật chế độ trồng cây", 700-20, Gdx.graphics.getHeight() - 120);
            }
            if(thongTinNutML){
                game.fontTextField.draw(batch, "Tắt/bật chế độ đặt máy lọc", 700-80-20, Gdx.graphics.getHeight() - 120);
            }
            if(thongTinNutCam){
                game.fontTextField.draw(batch, "Tắt/bật chế độ đặt camera", 700-80*2-20, Gdx.graphics.getHeight() - 120);
            }
            if(thongTinNutSign){
                game.fontTextField.draw(batch, "Tắt/bật chế độ cắm biển cấm", 700-80*3-20, Gdx.graphics.getHeight() - 120);
            }
            if(thongTinNutSoiCam){
                game.fontTextField.draw(batch, "Soi camera", 700-80*4, Gdx.graphics.getHeight() - 120);
            }
        }
        if(hienChiSo){
            game.font3.draw(batch, "Tiền: " + GameState.money,32*2, Gdx.graphics.getHeight()-32*3-(25+8));
            game.font3.draw(batch, "Năng lượng: " + GameState.ernegy,32*12, Gdx.graphics.getHeight()-32*3-(25+8));
            game.font3.draw(batch, "Điểm xanh: " + GameState.greenscore,32*22, Gdx.graphics.getHeight()-32*3-(25+8));
            game.font3.draw(batch, "Dân số: " + GameState.danso,32*2, 32*2);
            game.font3.draw(batch, "Xu hướng người dân: " + GameState.xuhuongdantangorgiam,32*16, 32*2);
        }
        if(hienBangTrash){
            game.font3.draw(batch, "Rác hữu cơ: " + GameState.soRacHuuCo,32*4, Gdx.graphics.getHeight()-32*1-(25+8));
            game.font3.draw(batch, "Rác vô cơ: " + GameState.soRacVoCo,32*22, Gdx.graphics.getHeight()-32*1-(25+8));
            game.font3.draw(batch, "Rác tái chế: " + GameState.soRacTaiChe,32*4, 32*2);
            game.font3.draw(batch, "Rác nguy hại: " + GameState.soRacNguyHai,32*22, 32*2);
            game.font3.draw(batch, "Đổi 10 túi rác hữu cơ lấy 10 điểm xanh",luaChon1NhaRac.getX()+32,Gdx.graphics.getHeight()-32*5-8+25+(64-25)/2f);
            game.font3.draw(batch, "Đổi 2 túi rác nguy hại lấy 5000 năng lượng",luaChon2NhaRac.getX()+32,Gdx.graphics.getHeight()-32*7-8+25+(64-25)/2f);
            game.font3.draw(batch, "Đổi 2 túi rác nguy hại và 1 túi rác tái chế lấy 3 level CNX",luaChon3NhaRac.getX()+32,Gdx.graphics.getHeight()-32*9-8+25+(64-25)/2f);
            game.font3.draw(batch, "Đổi 10 túi rác tái chế lấy 2500$",luaChon4NhaRac.getX()+16,Gdx.graphics.getHeight()-32*11-8+25+(64-25)/2f);
            game.font3.draw(batch, "Đổi 12 túi rác tái chế và 20 túi rác vô cơ để mở khóa thêm 1 chiếc máy lọc",luaChon5NhaRac.getX()+32,Gdx.graphics.getHeight()-32*13-8+25+(64-25)/2f);
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
            game.font3.draw(batch, "Nên mua hoặc nâng cấp: " + GameState.nenMua,32*2, Gdx.graphics.getHeight()-32*9-(25+8*2));
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
        if(hienCongCu){
            game.font3.draw(batch, ": Xẻng giá 300$",buyShovel.getX()+buyShovel.getWidth()/2f+32*2
                ,Gdx.graphics.getHeight()-32*8+25);
            game.font3.draw(batch, ": Chổi giá 300$",buyBroom.getX()+buyBroom.getWidth()/2f+32*2
                ,Gdx.graphics.getHeight()-32*8+25);
        }
        if(hienXayDung){
            game.font3.draw(batch, ": Vỉa hè giá 10$",buyViaHe.getX()+buyViaHe.getWidth()/2f+32*2,buyViaHe.getY()+25);
            game.font3.draw(batch, ": ngã rẽ giá 12$",buyRoadRe.getX()+buyRoadRe.getWidth()/2f+32*2,buyRoadRe.getY()+25);
            game.font3.draw(batch, ": cạnh đường giá 4$",buyCanhRoad.getX()+buyCanhRoad.getWidth()/2f+32*2,buyCanhRoad.getY()+25);
            game.font3.draw(batch, ": Vòng cung ngoài giá 4$",buyRoadReNgoai.getX()+buyRoadReNgoai.getWidth()/2f+32*2,buyRoadReNgoai.getY()+25);
            game.font3.draw(batch, ": Đất giá 3$",buyDirt.getX()+buyDirt.getWidth()/2f+32*2,buyDirt.getY()+25);
            game.font3.draw(batch, ": Đường thẳng giá 12$",buyRoad.getX()+buyRoad.getWidth()/2f+32*2,buyRoad.getY()+25);
            game.font3.draw(batch, ": Đường trống giá 12$",buyBlank.getX()+buyBlank.getWidth()/2f+32*2,buyBlank.getY()+25);
        }
        if(hienXeCo){
            game.font3.draw(batch, ": Xe chở rác giá 800$",buyTrashTruck.getX()+buyTrashTruck.getWidth()/2f+32*2,buyTrashTruck.getY()+25);
            game.font3.draw(batch, ": Xe tắc xi giá 400$",buyTaxi.getX()+buyTaxi.getWidth()/2f+32*2,buyTaxi.getY()+25);
            game.font3.draw(batch, ": Xe cảnh sát giá 700$",buyPolice.getX()+buyPolice.getWidth()/2f+32*2,buyPolice.getY()+25);
        }
        if(isInTurtleMap){
            game.font3.draw(batch, "Những phần có thể nhận đuợc sau khi thắng :",32*8,Gdx.graphics.getHeight() -32*2);
            game.font3.draw(batch , "Được tặng một cái camera", 32*10,Gdx.graphics.getHeight() -32*3-25);
            game.font3.draw(batch , "Được tặng hai mươi điểm xanh", 32*10,Gdx.graphics.getHeight() -32*4-50);
            game.font3.draw(batch , "Được tặng năm mươi năng lượng", 32*10,Gdx.graphics.getHeight() -32*5-75);
            game.font3.draw(batch , "Được tặng hai cái biển cấm", 32*10,Gdx.graphics.getHeight() -32*6-100);
            game.font3.draw(batch , "Được tặng ba hạt giống cây", 32*10,Gdx.graphics.getHeight() -32*7-125);
        }
        if(openDailyQuest){
            game.font3.draw(batch, "Nhiệm vụ :" , 32*8 , Gdx.graphics.getHeight()-32*2);
            if(nhiemvu1 == 1 || nhiemvu1 == 4){
                game.font3.draw(batch, "Bắt "  + soNguoiChatCay + " tội phạm đang chặt cây ", 32*5 , Gdx.graphics.getHeight()-32 *4);
            }if(nhiemvu1 == 2 || nhiemvu1 == 5){
                game.font3.draw(batch, "Bắt " + soNguoiDotBien + " tội phạm đang đốt biển cấm  ", 32*5 , Gdx.graphics.getHeight()-32 *4);
            }if(nhiemvu1 == 3 || nhiemvu1 == 6){
                game.font3.draw(batch, "Bắt " + soNguoiDotRac + " tội phạm đang đốt rác ", 32*5 , Gdx.graphics.getHeight()-32 *4);
            }if(nhiemvu1 == 77){
                game.font3.draw(batch, "Nhiệm vụ đã được hoàn thành", 32*5 , Gdx.graphics.getHeight()-32 *4);
            }

            if(nhiemvu2 == 1){
                game.font3.draw(batch, "Trồng " + soCayConLai + " cây xanh ", 32*5 , Gdx.graphics.getHeight()-32 *7);
            }if(nhiemvu2 == 2){
                game.font3.draw(batch, "Trải nghiệm mini game Tháp Rùa  ", 32*5 , Gdx.graphics.getHeight()-32 *7);
            }if(nhiemvu2 == 3){
                game.font3.draw(batch, "Nâng cấp 1 level cho máy lọc không khí ", 32*5 , Gdx.graphics.getHeight()-32 *7);
            }if(nhiemvu2 == 4){
                game.font3.draw(batch, "Nâng cấp 1 level cho giao thông xanh ", 32*5 , Gdx.graphics.getHeight()-32 *7);
            }if(nhiemvu2 == 5){
                game.font3.draw(batch, "Đặt 1 biển cấm  ", 32*5 , Gdx.graphics.getHeight()-32 *7);
            }if(nhiemvu2 == 6){
                game.font3.draw(batch, "Bắt tội phạm bằng camera ", 32*5 , Gdx.graphics.getHeight()-32 *7);
            }if(nhiemvu2 == 77){
                game.font3.draw(batch, "Nhiệm vụ đã được hoàn thành", 32*5 , Gdx.graphics.getHeight()-32 *7);
            }

            if(nhiemvu3 == 1){
                game.font3.draw(batch, "Đặt tên camera chứa 20 kí tự ", 32*5 , Gdx.graphics.getHeight()-32 *10);
            }if(nhiemvu3 == 2){
                game.font3.draw(batch, "Sử dụng xẻng để xúc một vật gì đó  ", 32*5 , Gdx.graphics.getHeight()-32 *10);
            }if(nhiemvu3 == 3){
                game.font3.draw(batch, "Uống 1 cốc bia hơi Hà Nội ", 32*5 , Gdx.graphics.getHeight()-32 *10);
            }if(nhiemvu3 == 4){
                game.font3.draw(batch, "Nhặt 3 túi rác thải nguy hại", 32*5 , Gdx.graphics.getHeight()-32 *10);
            }if(nhiemvu3 == 5){
                game.font3.draw(batch, " Ăn 1 bát phở   ", 32*5 , Gdx.graphics.getHeight()-32 *10);
            }if(nhiemvu3 == 6){
                game.font3.draw(batch, " Ăn que kem tràng tiền ", 32*5 , Gdx.graphics.getHeight()-32 *10);
            }if(nhiemvu3 == 77){
                game.font3.draw(batch, "Nhiệm vụ đã được hoàn thành", 32*5 , Gdx.graphics.getHeight()-32 *10);
            }

        }
        if(openSoTay){
            game.font3.draw(batch, soCauDoGreen + " thẻ xanh cơ bản", 32*3 , 32+20);
            game.font3.draw(batch, soCauDoVui + " thẻ mini quiz", 32*12 , 32+20);
            game.font3.draw(batch, soCauDoShock + " thẻ sự thật sốc", 32*20 , 32+20);
            if(inDoVui){
                if(trongHopDoVui == 1){
                    game.font3.draw(batch , "Xe điện thải ra khí CO? ", 32*11 , Gdx.graphics.getHeight()-32*3);
                }
                if(trongHopDoVui == 2){
                    game.font3.draw(batch , "PM10 nhỏ hơn PM2.5? ", 32*11 , Gdx.graphics.getHeight()-32*3);
                }if(trongHopDoVui == 3) {
                     game.font3.draw(batch, "Cây xanh giúp giảm bụi mịn?", 32 * 9, Gdx.graphics.getHeight() - 32 * 3);
                 } if(trongHopDoVui == 4){
                    game.font3.draw(batch , "AQI dưới 100 được xem là an toàn? ", 32*9, Gdx.graphics.getHeight()-32*3);
                } if(trongHopDoVui == 5){
                    game.font3.draw(batch , "SO2 là khí có mùi trứng thối?", 32*9 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopDoVui == 6){
                    game.font3.draw(batch , "Trời mưa giúp tăng bụi mịn?", 32*9 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopDoVui == 7){
                    game.font3.draw(batch , "Tái chế rác giúp giảm ô nhiễm?", 32*9 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopDoVui == 8){
                    game.font3.draw(batch , "Khí CO có thể nhìn thấy bằng mắt? ", 32*9 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopDoVui == 9){
                    game.font3.draw(batch , "Đi bộ giúp giảm ô nhiễm giao thông? ", 32*9 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopDoVui == 10){
                    game.font3.draw(batch , "AQI cao thường xuất hiện sau mưa?", 32*9 , Gdx.graphics.getHeight()-32*3);
                }
                if(answered){
                    if(answerRight){
                        game.font3.draw(batch , "Chúc mừng , bạn đã trả lời đúng", 32*9 , Gdx.graphics.getHeight()-32*5+16);

                    }else{
                        game.font3.draw(batch , "Bạn đã trả lời sai", 32*11 , Gdx.graphics.getHeight()-32*5+16);
                    }
                    thoiGianHien++;
                }
            }

            if(inGreenCoBan){
                if(trongHopGreen == 1){
                    game.font3.draw(batch , "PM2.5 là hạt bụi siêu nhỏ có thể xâm nhập vào phổi và gây hại tim mạch", 32*2 , Gdx.graphics.getHeight()-32*3);
                }
                if(trongHopGreen == 2){
                    game.font3.draw(batch , "Xe máy cũ có thể thải ra gấp 10 lần khí độc so với xe mới ", 32*3 , Gdx.graphics.getHeight()-32*3);
                }if(trongHopGreen == 3) {
                    game.font3.draw(batch, "Mỗi cây xanh có thể hấp thụ 20–30kg CO₂ mỗi năm.", 32 * 5, Gdx.graphics.getHeight() - 32 * 3);
                } if(trongHopGreen == 4){
                    game.font3.draw(batch , "Khí CO không màu, không mùi nhưng có thể gây tử vong nếu hít nhiều.", 32*3, Gdx.graphics.getHeight()-32*3);
                } if(trongHopGreen == 5){
                    game.font3.draw(batch , "Ozone tầng thấp (O₃) gây cay mắt, khó thở, nhất là vào trưa hè", 32*3 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopGreen == 6){
                    game.font3.draw(batch , "Trồng cây ven đường giúp giảm bụi mịn và làm mát thành phố.", 32*3 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopGreen == 7){
                    game.font3.draw(batch , "AQI > 150 ảnh hưởng xấu đến cả người khỏe mạnh.", 32*5 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopGreen == 8){
                    game.font3.draw(batch , "Nhà máy điện than là nguồn phát thải lớn nhất khí CO₂ tại Việt Nam.", 32*3 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopGreen == 9){
                    game.font3.draw(batch , "Lượng bụi mịn tăng cao vào giờ cao điểm giao thông sáng – chiều. ", 32*3 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopGreen == 10){
                    game.font3.draw(batch , "Thở bằng mũi giúp lọc không khí tốt hơn so với thở miệng.", 32*3 , Gdx.graphics.getHeight()-32*3);
                }
            }

            if(inShock){
                if(trongHopShock== 1){
                    game.font3.draw(batch , "AQI > 300 tương đương hút 25 điếu thuốc/ngày.", 32*3 , Gdx.graphics.getHeight()-32*3);
                }
                if(trongHopShock == 2){
                    game.font3.draw(batch , "Ô nhiễm không khí giết chết hơn 7 triệu người mỗi năm. ", 32*4 , Gdx.graphics.getHeight()-32*3);
                }if(trongHopShock == 3) {
                    game.font3.draw(batch, "93% trẻ em thành thị hít phải không khí độc mỗi ngày.", 32 * 4, Gdx.graphics.getHeight() - 32 * 3);
                } if(trongHopShock == 4){
                    game.font3.draw(batch , "Chất độc từ khí thải xe có thể ảnh hưởng đến trí nhớ.", 32*4, Gdx.graphics.getHeight()-32*3);
                } if(trongHopShock == 5){
                    game.font3.draw(batch , "Trẻ sinh gần nhà máy dễ bị nhẹ cân, chậm phát triển.", 32*4 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopShock == 6){
                    game.font3.draw(batch , "Bụi mịn được xếp vào nhóm chất gây ung thư chắc chắn.", 32*4 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopShock == 7){
                    game.font3.draw(batch , "Việt Nam nằm trong top 10 quốc gia ô nhiễm nhất châu Á.", 32*4 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopShock == 8){
                    game.font3.draw(batch , "1 tấn giấy tái chế giúp giữ lại 17 cây xanh.", 32*7 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopShock == 9){
                    game.font3.draw(batch , "Người đi xe máy không khẩu trang có nguy cơ viêm phổi gấp đôi. ", 32*4 , Gdx.graphics.getHeight()-32*3);
                } if(trongHopShock == 10){
                    game.font3.draw(batch , "Không khí ô nhiễm có thể ảnh hưởng hệ sinh sản.", 32*4 , Gdx.graphics.getHeight()-32*3);
                }
            }

        }
        batch.end();
    }
    private void xuLyNenMuaVaCamXucNguoiDan(){
        if(AQI == GameState.AQICO1){
            GameState.nenMua = "Công nghệ xanh và giao thông xanh";
        }else if(AQI == GameState.AQINO2){
            GameState.nenMua = "Máy lọc không khí";
        }else if(AQI == GameState.AQISO2){
            GameState.nenMua = "Công nghệ xanh và giao thông xanh";
        }else if(AQI == GameState.AQIO3){
            GameState.nenMua = "Cây xanh";
        }else if(AQI == GameState.AQIPM10){
            GameState.nenMua = "Cây xanh";
        }else if(AQI == GameState.AQIPM2_5){
            GameState.nenMua = "Máy lọc không khí";
        }

        if(Master.AQI<=150){
            GameState.camxucnguoidan = "Vui vẻ";
            GameState.lydocamxucnguoidan = "Không khí rất trong lành";
        }else if(Master.AQI<=250){
            GameState.camxucnguoidan = "Không Vui";
            GameState.lydocamxucnguoidan = "Không khí hơi ô nhiễm";
        }else{
            GameState.camxucnguoidan = "Tức giận";
            GameState.lydocamxucnguoidan = "Không khí rất ô nhiễm";
        }
    }
    private void xuLyCNXVaGTX() {
        //xu ly CNX
        if (GameState.ernegy >= 10 && factoryAction) {
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
        if (timeOfDay % 120 == 0 && GameState.ernegy >= 10 && factoryAction && isCNX) {
            GameState.ernegy -= 10;
        }
        if (!buyCNX){
            if (!isCNX) {
                nangCapCNX.setColor(Color.GRAY);
            } else {
                nangCapCNX.setColor(1, 1, 1, 1);
                buyCNX = true;
            }
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
        if(!buyGTX) {
            if (!isGTX) {
                nangCapGTX.setColor(Color.GRAY);
            } else {
                nangCapGTX.setColor(1, 1, 1, 1);
                buyGTX = true;
            }
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
    private void batTatNutMoVaXuLyTrongNutMo(){

        //XỬ LÝ ITEMS
        if(isMoItems){
            noMoveStage.addActor(xengButton);
            noMoveStage.addActor(choiButton);
        }else {
            xengButton.remove();
            choiButton.remove();
        }

        if(whatActionIfClickMouse.equals("CamXeng")){
            if(shovel.getStage() == null){
                noMoveStage.addActor(shovel);
                shovel.toFront();
            }
            shovel.setPosition(mouseNoMoveStage.x,mouseNoMoveStage.y);
            float x = Math.round(mouseNoMoveStage.x/32f)*32+(32-stage.getCamera().position.x%32) - 32;
            float y = Math.round(mouseNoMoveStage.y/32f)*32+(32-stage.getCamera().position.y%32) - 48;
            deltaXYVector.set((float) Gdx.graphics.getWidth() /2 - x, (float) Gdx.graphics.getHeight() /2 - y+2);
            MDirt.setPosition(x, y-2);
            MDirt.toFront();
        }else if(whatActionIfClickMouse.equals("CamChoi")){
            if(broom.getStage() == null){
                noMoveStage.addActor(broom);
                broom.toFront();
            }
            broom.setPosition(mouseNoMoveStage.x,mouseNoMoveStage.y);
            float x = Math.round(mouseNoMoveStage.x/32f)*32+(32-stage.getCamera().position.x%32) - 32;
            float y = Math.round(mouseNoMoveStage.y/32f)*32+(32-stage.getCamera().position.y%32) - 48;
            deltaXYVector.set((float) Gdx.graphics.getWidth() /2 - x, (float) Gdx.graphics.getHeight() /2 - y+2);
            MDirt.setPosition(x, y-2);
            MDirt.toFront();
        }else {
            shovel.remove();
            broom.remove();
        }

        //XỬ LÝ VEHICLES
        if(isMoVehicles){
            noMoveStage.addActor(trashTruckButton);
            noMoveStage.addActor(taxiButton);
            noMoveStage.addActor(policeButton);
        }else {
            trashTruckButton.remove();
            taxiButton.remove();
            policeButton.remove();
        }
        if(trashTruck.getIsUsing()){
            trashTruck.toFront();
            trashTruck.setPosition(player.getX()+16-trashTruck.getWidth()/2f,player.getY()+16-trashTruck.getHeight()/2f);
        }
        if(taxi.getIsUsing()){
            taxi.toFront();
            taxi.setPosition(player.getX()+16-taxi.getWidth()/2f,player.getY()+16-taxi.getHeight()/2f);
        }
        if(police.getIsUsing()){
            police.toFront();
            police.setPosition(player.getX()+16-taxi.getWidth()/2f,player.getY()+16-taxi.getHeight()/2f);
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
            resetDailyQuest();
            if(day%3== 0){
                int ran = MathUtils.random(1,3);
                switch (ran){
                    case 1 -> soCauDoShock ++;
                    case 2 -> soCauDoGreen++;
                    case 3 -> soCauDoVui++;
                }
            }
            soNgayDienRaLeHoi--;
            if(soNgayDienRaLeHoi == 0){
                isNgayTrongCay = true;
                new FloatingNews(0, Gdx.graphics.getHeight()-32,noMoveStage, "Đến ngày hội trồng cây cần trồng " + soCayTieuChuan + " cây", Color.GREEN);
            }
            GameState.money += GameState.danso/20/30;

            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    closeScienceBoard();
                    closeFactoryBoard();
                    closeMenuFood();
                    closeTrashBoard();
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
            if(thuTuNhiemVuTanBinh==1){
                thuTuNhiemVuTanBinh++;
                nhiemVuTanBinh = true;
            }
        }
    }
    private void showBangFactory(float x, float y){
        if(!hienBangFactory&&Math.abs(player.getX()-factoryDoor.getX())<32*6 && Math.abs(player.getY()-factoryDoor.getY()) < 32*6){
            bangFactory.setPosition(x,y);
            bangFactoryCross.setPosition(Gdx.graphics.getWidth()-32*2,Gdx.graphics.getHeight()-32*2);

            line.setHeight(4);
            line2.setHeight(4);
            xayDungButton.setPosition(32*5+192*0-16,Gdx.graphics.getHeight()-32*2-64);
            congCuButton.setPosition(32*6+192*1-16,Gdx.graphics.getHeight()-32*2-64);
            xeCoButton.setPosition(32*7+192*2-16,Gdx.graphics.getHeight()-32*2-64);
            hienBangFactory = true;
            hienChiSo = true;

            line.toFront();
            xayDungButton.toFront();
            congCuButton.toFront();
            xeCoButton.toFront();

        }
    }

    void showMenuFood(){
        menuFood.setPosition(32,32);
        bia.setPosition(32,32);
        iceCream.setPosition(200,32);
        com.setPosition(200,250);
        xienBan.setPosition(550,250);
        menuFoodCross.setPosition(Gdx.graphics.getWidth()-32*2,Gdx.graphics.getHeight()-32*2);
        pho.setPosition(400,32);
        menuFood.toBack();

    }

    public void closeMenuFood(){
        menuFood.setPosition(32000,32000);
        bia.setPosition(32000,3200);
        iceCream.setPosition(20000,32000);
        menuFoodCross.setPosition(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        pho.setPosition(40000,3200);
        xienBan.setPosition(32000,32000);
        com.setPosition(32000,3200);

    }

    private void moXayDung(){
        dongXeCo();
        dongCongCu();
        hienXayDung = true;

        buyViaHe.setPosition(32*3-buyViaHe.getWidth()/2f,Gdx.graphics.getHeight()-32*9-buyViaHe.getHeight()/2f);
        buyRoadRe.setPosition(32*17-buyRoadRe.getWidth()/2f,Gdx.graphics.getHeight()-32*9-buyRoadRe.getHeight()/2f);
        buyRoadReNgoai.setPosition(32*3-buyRoadReNgoai.getWidth()/2f,Gdx.graphics.getHeight()-32*11-buyRoadReNgoai.getHeight()/2f);
        buyCanhRoad.setPosition(32*17-buyCanhRoad.getWidth()/2f,Gdx.graphics.getHeight()-32*7-buyCanhRoad.getHeight()/2f);
        buyBlank.setPosition(32*17-buyBlank.getWidth()/2f,Gdx.graphics.getHeight()-32*11-buyBlank.getHeight()/2f);
        buyDirt.setPosition(32*3-buyDirt.getWidth()/2f,Gdx.graphics.getHeight()-32*13-buyDirt.getHeight()/2f);
        buyRoad.setPosition(32*17-buyRoad.getWidth()/2f,Gdx.graphics.getHeight()-32*13-buyRoad.getHeight()/2f);

        buyRoad.toFront();
        buyRoadRe.toFront();
        buyCanhRoad.toFront();
        buyViaHe.toFront();
        buyRoadReNgoai.toFront();
        buyBlank.toFront();
        buyDirt.toFront();
    }

    private void moCongCu(){
        dongXayDung();
        dongXeCo();
        hienCongCu = true;

        noMoveStage.addActor(buyShovel);
        noMoveStage.addActor(buyBroom);

        buyShovel.toFront();
        buyBroom.toFront();
    }
    private void moXeCo(){
        dongXayDung();
        dongCongCu();
        hienXeCo = true;

        buyTrashTruck.setPosition(32*5,Gdx.graphics.getHeight()-32*7);
        buyTaxi.setPosition(32*5,Gdx.graphics.getHeight()-32*8);
        buyPolice.setPosition(32*5,Gdx.graphics.getHeight()-32*9);

        buyTrashTruck.toFront();
        buyTaxi.toFront();
        buyPolice.toFront();
    }
    private void dongXayDung(){
        hienXayDung = false;

        buyViaHe.setPosition(-2134,-9823);
        buyRoadRe.setPosition(-2134,-9823);
        buyRoadReNgoai.setPosition(-2134,-9823);
        buyCanhRoad.setPosition(-2134,-9823);
        buyBlank.setPosition(-2134,-9823);
        buyDirt.setPosition(-2134,-9823);
        buyRoad.setPosition(-2134,-9823);
    }

    private void dongCongCu(){
        hienCongCu = false;

        buyShovel.remove();
        buyBroom.remove();
    }
    private void dongXeCo(){
        hienXeCo = false;

        buyTrashTruck.setPosition(-4356,-46232);
        buyTaxi.setPosition(-4356,-46232);
        buyPolice.setPosition(-4356,-46232);
    }

    private void dongThongtin(){

        dongCheTao();
        isOpenSetting = false;
        dongCaiDat();
        lineThongTin.setHeight(0);
        lineThongTin2.setHeight(0);
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
        lineThongTin2.setHeight(4);
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
        if(thuTuNhiemVuTanBinh==2){
            nhiemVuTanBinh = true;
            thuTuNhiemVuTanBinh++;

        }

        dongThongtin();
        dongNghienCuu();
        hienCheTao = true;

        button1C.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.6f);
        button1C.setSize(600, 40);
        button1C.toFront();



        button2C.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.6f-40);
        button2C.setSize(600, 40);
        button2C.toFront();



        button3C.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.6f - 40*2);
        button3C.setSize(600, 40);
        button3C.toFront();

        button4C.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.6f - 40*3);
        button4C.setSize(600, 40);
        button4C.toFront();

        button5C.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.6f - 40*4);
        button5C.setSize(600, 40);
        button5C.toFront();


        button6C.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.6f - 40*5);
        button6C.setSize(600, 40);
        button6C.toFront();

        button7C.setPosition(Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.6f - 40*6);
        button7C.setSize(600, 40);
        button7C.toFront();
    }

    public void dongCheTao(){
        button1C.setPosition(10000,10000);
        button2C.setPosition(10000,10000);
        button3C.setPosition(10000,10000);
        button4C.setPosition(10000,10000);
        button5C.setPosition(10000,10000);
        button6C.setPosition(10000,10000);
        button7C.setPosition(10000,10000);
        hienCheTao = false;
    }
    public void dongCaiDat(){
        button1S.remove();
        button2S.remove();
        button3S.remove();
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
        new TrafficLight(23*32+16,32*14+8,stage,'L');
    }

    private void tinhThangThua(){
        if((AQI> 300 || amountOfFood < 3)&& WLK == 'K'){
            GameState.event = "YOU LOSE";
            new FloatingNews(random.nextInt(0,32*75)
                ,random.nextInt(0,800)
                , stage,"YOU LOSE"
                ,new Color(random.nextFloat(0,1),random.nextFloat(0,1)
                ,random.nextFloat(0,1),random.nextFloat(0,1)));
            WLK = 'L';
        }
        if(WLK == 'L'){
            showAQI.canhbao.stop();
            dark.toFront();
            dark.setColor(0,0,0,0f);

            dark.toFront();
            dark.setColor(0,0,0,0f);
            winsorloses.add(new Piece(0,0,noMoveStage));
            winsorloses.add(new FloatingNews(random.nextInt(0,Gdx.graphics.getWidth()),random.nextInt(0,Gdx.graphics.getHeight()),noMoveStage ,"LOSE",Color.RED));
            replay.setPosition(Gdx.graphics.getWidth()/2f-replay.getWidth()/2f,Gdx.graphics.getHeight()/2f-replay.getHeight()/2f);
            noMoveStage.addActor(replay);
            replay.toFront();
            WLK = 'L';
        }
        if(AQI<100 && GameState.danso<=100000 && WLK == 'K'){
            WLK = 'W';}
        if(WLK == 'W'){
            if(!GameState.isDaThang){
                stage.addActor(one);
                stage.addActor(redFlag);
                for(int i = 0;i<9*32*60;i++){
                    if(i%32*60==0){
                        new ChaoMungPeople(-i-32,800/2f-48,stage);
                    }
                }
                GameState.isDaThang = true;
            }
            redFlag.setPosition(one.getX()-redFlag.getWidth()+one.getWidth(),one.getY()+one.getHeight());
            showAQI.canhbao.stop();
//            dark = new Dark(0,0,noMoveStage);
//            player.toFront();
//            camera.position.x = 480;
//            camera.position.y = 270;
//            player.setX(480);
//            player.setY(270);
        }
    }
    private void calculAQI(){
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
                        GameState.event = "Tai nạn giao thông";
                        GameState.NO2 += 30;
                        GameState.CO1 += 20;
                        GameState.danso--;
                        new FloatingNews(0,500,noMoveStage,"Tai nạn giao thông chết 1 người",Color.RED).toFront();
                    }
                    case 2,24,26 -> {
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
                        GameState.event = "Có 1 cơn mưa bão, vài tia sét đã đánh trúng đường phố gây ra vài vụ cháy nhỏ";
                        GameState.SO2 += 25;
                        GameState.NO2 += 20;
                        GameState.PM2_5 += 15;
                    }
                    case 9,52,56,78,93 -> {
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
                        GameState.event = "Tai nạn giao thông";
                        GameState.NO2 += 30;
                        GameState.CO1 += 20;
                        GameState.danso--;
                        new FloatingNews(0,500,noMoveStage,"Tai nạn giao thông chết 1 người",Color.RED).toFront();
                    }
                    case 2,24,26,67,68,69,79,89 -> {
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
                        GameState.event = "Có 1 cơn mưa bão, vài tia sét đã đánh trúng đường phố gây ra vài vụ cháy nhỏ";
                        GameState.SO2 += 25;
                        GameState.NO2 += 20;
                        GameState.PM2_5 += 15;
                    }
                    case 9,52,56,78,93,58,57,35 -> {
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
                        GameState.event = "Tai nạn giao thông";
                        GameState.NO2 += 30;
                        GameState.CO1 += 20;
                        GameState.danso--;
                        new FloatingNews(0,500,noMoveStage,"Tai nạn giao thông chết 1 người",Color.RED).toFront();
                    }
                    case 2,24,26,67,68,69,79,89 -> {
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
                        GameState.event = "Có 1 cơn mưa bão, vài tia sét đã đánh trúng đường phố gây ra vài vụ cháy nhỏ";
                        GameState.SO2 += 25;
                        GameState.NO2 += 20;
                        GameState.PM2_5 += 15;
                    }
                    case 9,52,56,78,93,58,57 -> {
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
                        GameState.event = "Sự kiện thể thao lớn";
                        GameState.NO2 += 30;
                        GameState.CO1 += 20;
                        int ran2 = random.nextInt(1,101);
                        if(25<ran2 && ran2<=50 ){
                            GameState.event = "Tai nạn giao thông";
                            GameState.NO2 += 30;
                            GameState.CO1 += 20;
                            GameState.danso-= 5;
                            new FloatingNews(0,500,noMoveStage,"Tai nạn giao thông chết 1 người",Color.RED).toFront();

                        }
                    }
                    case 49,11,68,56,87 -> {
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
                            GameState.event = "Cháy 2 ngôi nhà";
                            GameState.SO2 += 30;
                            GameState.NO2 += 40;
                            GameState.PM2_5 += 50;
                            int ran2 = random.nextInt(1,10);
                            switch (ran2){
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
        timeOfDay++;
    }

    private void taoMoDatKhoi(){
        float x = Math.round(mouseNoMoveStage.x/32f)*32+(32-stage.getCamera().position.x%32) - 32;
        float y = Math.round(mouseNoMoveStage.y/32f)*32+(32-stage.getCamera().position.y%32) - 48;
        deltaXYVector.set((float) Gdx.graphics.getWidth() /2 - x, (float) Gdx.graphics.getHeight() /2 - y+2);
        switch (creatVLLD.type){
            case Dat -> {
                MDirt.setPosition(x, y-2);
                MDirt.toFront();
            }
            case VongCung -> {
                MRoadReNgoai.setPosition(x, y-2);
                MRoadReNgoai.toFront();
                thongTinDatVongCung=thongTinMode;
                if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
                    MRoadReNgoai.setRotation(MRoadReNgoai.getRotation()+90);
                }
            }
            case CanhRoad -> {
                MCanhRoad.setPosition(x, y-2);
                MCanhRoad.toFront();
                thongTinDatCanhRoad=thongTinMode;
                if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
                    MCanhRoad.setRotation(MCanhRoad.getRotation()+90);
                }
            }
            case ViaHe -> {
                MViaHe.setPosition(x, y-2);
                MViaHe.toFront();
                thongTinDatViaHe=thongTinMode;
                if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
                    MViaHe.setRotation(MViaHe.getRotation()+90);
                }
                if(Gdx.input.isKeyJustPressed(Input.Keys.E)){
                    switch (MViaHe.type){
                        case Canh -> MViaHe.type = TypeViaHe.Tam;
                        case Goc -> MViaHe.type = TypeViaHe.Canh;
                        case Tam -> MViaHe.type = TypeViaHe.Goc;
                    }
                }
            }
            case NgaRe -> {
                MRoadRe.setPosition(x, y-2);
                MRoadRe.toFront();
                thongTinDatNgaRe=thongTinMode;
                if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
                    switch (MRoadRe.direc){
                        case 'u'->{MRoadRe.direc = 'l';}
                        case 'l'->{MRoadRe.direc = 'd';}
                        case 'd'->{MRoadRe.direc = 'r';}
                        case 'r'->{MRoadRe.direc = 'u';}

                    }
                }
                if(Gdx.input.isKeyJustPressed(Input.Keys.E)){
                    switch (MRoadRe.type){
                        case Trai -> MRoadRe.type = TypeRoadRe.Phai;
                        case Phai -> MRoadRe.type = TypeRoadRe.CaHai;
                        case CaHai -> MRoadRe.type = TypeRoadRe.Trai;
                    }
                }
            }
            case DuongThang -> {
                MRoad.setPosition(x, y-2);
                MRoad.toFront();
                thongTinDatDuongThang=thongTinMode;
                if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
                    if(MRoad.direction == 'N'){
                        MRoad.direction = 'D';
                    }else {
                        MRoad.direction = 'N';
                    }
                }
            }
            case DuongTrong -> {
                MBlank.setPosition(x, y-2);
                MBlank.toFront();
            }
        }
    }
    private void tanggiamdanso(){
        if(timeOfDay%(2*60)==0){
            createRandomPeople();
        }
        if(AQI<100){
            GameState.xuhuongdantangorgiam = "tăng dân số";
            if(timeOfDay%(24*60)==0){
                GameState.danso += Math.round(GameState.danso*2/100/30);
                int ran = random.nextInt(1,15);
                switch (ran){
                    case 1 ->new FloatingNews(0,500,noMoveStage,"Thành phố quá xinh đẹp nên " + Math.round(GameState.danso*2/100/30) + " người đến",Color.GREEN);
                    case 2 -> new FloatingNews(0,500,noMoveStage,"Không khí trong lành nên " + Math.round(GameState.danso*2/100/30) + " người đến",Color.GREEN);
                    case 3 -> new FloatingNews(0,500,noMoveStage,"Có lễ hội nên " + Math.round(GameState.danso*2/100/30) + " người đến",Color.GREEN);
                    case 4 -> new FloatingNews(0,500,noMoveStage," Thành phố tiến tiến nên " + Math.round(GameState.danso*2/100/30) + " người đến",Color.GREEN);
                    case 5 -> new FloatingNews(0,500,noMoveStage,"Thành phố sạch sẽ nên " + Math.round(GameState.danso*2/100/30) + " người đến",Color.GREEN);
                    case 6 -> new FloatingNews(0,500,noMoveStage,"Ronando chuyển đến nên " + Math.round(GameState.danso*2/100/30) + " người đi theo",Color.GREEN);
                    case 7 -> new FloatingNews(0,500,noMoveStage,"Messi chuyển đến nên " + Math.round(GameState.danso*2/100/30) + " người  đi theo",Color.GREEN);
                    case 8 -> new FloatingNews(0,500,noMoveStage,"M pa pê chuyển đến nên " + Math.round(GameState.danso*2/100/30) + " người  đi theo",Color.GREEN);
                    case 9 -> new FloatingNews(0,500,noMoveStage,"Haland chuyển đến nên  " + Math.round(GameState.danso*2/100/30) + " người  đi theo",Color.GREEN);
                    case 10 -> new FloatingNews(0,500,noMoveStage,"Thích Minh Toại chuyển đến nên " + Math.round(GameState.danso*2/100/30) + " người  đi theo",Color.GREEN);
                    case 11 -> new FloatingNews(0,500,noMoveStage,"Có bãi biển đẹp nên  " + Math.round(GameState.danso*2/100/30) + " người  tham quan",Color.GREEN);
                    case 12 -> new FloatingNews(0,500,noMoveStage," Giá đất rẻ nên " + Math.round(GameState.danso*2/100/30) + " người đến ở",Color.GREEN);
                    case 13 -> new FloatingNews(0,500,noMoveStage,"Nền kinh tế phát triển nên " + Math.round(GameState.danso*2/100/30) + " người đến ",Color.GREEN);
                    case 14 -> new FloatingNews(0,500,noMoveStage," Con Sông Hồng tuyệt sắc " + Math.round(GameState.danso*2/100/30) + " người  đến",Color.GREEN);
                    case 15 -> new FloatingNews(0,500,noMoveStage," Công nghệ phát triển  nên " + Math.round(GameState.danso*2/100/30) + " người  đến",Color.GREEN);

                }
            }
        }else if(AQI<=200){
            GameState.xuhuongdantangorgiam = "giảm dân số";
        }else if(AQI>200){
            GameState.xuhuongdantangorgiam = "giảm dân số";
            if(timeOfDay%(24*60)==0){
                GameState.danso -= Math.round(GameState.danso*5/100/30);
                int ran = random.nextInt(1,10);
                switch (ran) {
                    case 1 ->new FloatingNews(0, 500, noMoveStage, "Thành phố quá bẩn nên " + Math.round(GameState.danso * 2 / 100 / 30) + " người rời đi", Color.RED);
                    case 2 ->new FloatingNews(0, 500, noMoveStage, "Messi rời đi nên " + Math.round(GameState.danso * 2 / 100 / 30) + " người rời đi", Color.RED);
                    case 3 ->new FloatingNews(0, 500, noMoveStage, "Ronando rời đi nên " + Math.round(GameState.danso * 2 / 100 / 30) + "người rời đi", Color.RED);
                    case 4 ->new FloatingNews(0, 500, noMoveStage, "Không khí ô nhiễm nặng " + Math.round(GameState.danso * 2 / 100 / 30) + " người rời đi", Color.RED);
                    case 5->new FloatingNews(0, 500, noMoveStage, "Nội thất giảm sút nên " + Math.round(GameState.danso * 2 / 100 / 30) + " người rời đi", Color.RED);
                    case 6 ->new FloatingNews(0, 500, noMoveStage, "Tiền thuê nhà tăng lên  " + Math.round(GameState.danso * 2 / 100 / 30) + " người rời đi", Color.RED);
                    case 7 ->new FloatingNews(0, 500, noMoveStage, "Có " + Math.round(GameState.danso * 2 / 100 / 30) + " người chuyển nhà", Color.RED);
                    case 8 ->new FloatingNews(0, 500, noMoveStage, "Có viện bảo tàng mới mở nên " + Math.round(GameState.danso * 2 / 100 / 30) + " người chết", Color.RED);
                    case 9 ->new FloatingNews(0, 500, noMoveStage, "Lạm phát nên " + Math.round(GameState.danso * 2 / 100 / 30) + " người rời đi", Color.RED);
                    case 10 ->new FloatingNews(0, 500, noMoveStage, "Biến đổi khí hậu nên " + Math.round(GameState.danso * 2 / 100 / 30) + " ngườio rời đi", Color.RED);


                }
            }
        }
    }

    void luongThucAn(){
        if(timeOfDay%60 == 0){
            amountOfFood--;
        }
    }
    private void createRandomPeople(){
        switch (random.nextInt(1,10)){
            case 1 -> {
                switch (random.nextInt(1,6)){
                    case 1 -> new People1(14*32,32,stage,true);
                    case 2 -> new People2(14*32,32,stage,true);
                    case 3 -> new People3(14*32,32,stage,true);
                    case 4 -> new People4(14*32,32,stage,true);
                    case 5 -> new People5(14*32,32,stage,true);
                }
            }
            case 2 -> {
                switch (random.nextInt(1,6)){
                    case 1 -> new People1(29*32,16*32,stage,true);
                    case 2 -> new People2(29*32,16*32,stage,true);
                    case 3 -> new People3(29*32,16*32,stage,true);
                    case 4 -> new People4(29*32,16*32,stage,true);
                    case 5 -> new People5(29*32,16*32,stage,true);
                }
            }
            case 3 -> {
                switch (random.nextInt(1,6)){
                    case 1 -> new People1(33*32,32*5,stage,true);
                    case 2 -> new People2(33*32,32*5,stage,true);
                    case 3 -> new People3(33*32,32*5,stage,true);
                    case 4 -> new People4(33*32,32*5,stage,true);
                    case 5 -> new People5(33*32,32*5,stage,true);
                }
            }
            case 4 -> {
                switch (random.nextInt(1,6)){
                    case 1 -> new People1(32*47,32*2,stage,true);
                    case 2 -> new People2(32*47,32*2,stage,true);
                    case 3 -> new People3(32*47,32*2,stage,true);
                    case 4 -> new People4(32*47,32*2,stage,true);
                    case 5 -> new People5(32*47,32*2,stage,true);
                }
            }
            case 5 -> {
                switch (random.nextInt(1,6)){
                    case 1 -> new People1(32*49,32*8,stage,true);
                    case 2 -> new People2(32*49,32*8,stage,true);
                    case 3 -> new People3(32*49,32*8,stage,true);
                    case 4 -> new People4(32*49,32*8,stage,true);
                    case 5 -> new People5(32*49,32*8,stage,true);
                }
            }
            case 6 -> {
                switch (random.nextInt(1,6)){
                    case 1 -> new People1(32*46,32*16,stage,true);
                    case 2 -> new People2(32*46,32*16,stage,true);
                    case 3 -> new People3(32*46,32*16,stage,true);
                    case 4 -> new People4(32*46,32*16,stage,true);
                    case 5 -> new People5(32*46,32*16,stage,true);
                }
            }
            case 7 -> {
                switch (random.nextInt(1,6)){
                    case 1 -> new People1(32*55,32*16,stage,true);
                    case 2 -> new People2(32*55,32*16,stage,true);
                    case 3 -> new People3(32*55,32*16,stage,true);
                    case 4 -> new People4(32*55,32*16,stage,true);
                    case 5 -> new People5(32*55,32*16,stage,true);
                }
            }
            case 8 -> {
                switch (random.nextInt(1,6)){
                    case 1 -> new People1(32*59,32*7,stage,true);
                    case 2 -> new People2(32*59,32*7,stage,true);
                    case 3 -> new People3(32*59,32*7,stage,true);
                    case 4 -> new People4(32*59,32*7,stage,true);
                    case 5 -> new People5(32*559,32*7,stage,true);
                }
            }
            case 9 -> {
                switch (random.nextInt(1,6)){
                    case 1 -> new People1(32*61,32,stage,true);
                    case 2 -> new People2(32*61,32,stage,true);
                    case 3 -> new People3(32*61,32,stage,true);
                    case 4 -> new People4(32*61,32,stage,true);
                    case 5 -> new People5(32*61,32,stage,true);
                }
            }
            case 10 -> {
                switch (random.nextInt(1,6)){
                    case 1 -> new People1(32*63,32*17,stage,true);
                    case 2 -> new People2(32*63,32*17,stage,true);
                    case 3 -> new People3(32*63,32*17,stage,true);
                    case 4 -> new People4(32*63,32*17,stage,true);
                    case 5 -> new People5(32*63,32*17,stage,true);
                }
            }
        }
    }
    private void createCar() {
        if(gio1phan60%180 == 0 && WLK == 'K'){
            Car car = new Car(0,0,stage);//dat x,y cho hop ly vi Car extends MyActor chu vao trong car no dat lai
            cars.add(car);
        }
    }
    private void createParking(float x, float y){
        new RoadPiece(x,y,stage,'_');
        new LetterP(x+32,y,stage);
    }
    private void createHouses(){
        scienceCenter = new ScienceCenter(26*32,32*16,stage);
        scienceDoor = new MordernDoor(scienceCenter.getX()+32,scienceCenter.getY(),stage);
        factoryCenter = new FactoryCenter(31*32, 32*16, stage);
        factoryDoor = new MordernDoor(factoryCenter.getX()+32,factoryCenter.getY(),stage);
        hotelCenter = new HotelCenter(32*32,32*5,stage) ;
        hotelDoor = new MordernDoor(32*33,32*5,stage);
        trashCenter = new TrashCenter(32*12,0,stage);
        trashDoor = new MordernDoor(trashCenter.getX()+32*2,trashCenter.getY(),stage);
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
        for (int i = 0; i < 100; i++) {
            Waste waste = new Waste(random.nextInt(1, 9) * 32, random.nextInt(1, 11) * 32, stage,'0');
        }
    }
    private void racTroiSong(){
        if(random.nextInt(600)==300){
            Waste waste = new Waste(random.nextInt(1180+32, 1180+3*32-10), 800-32, stage,'1');
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
        new House3(1184+32*8,32*16, stage, false);
         new House3(1184+32*9,32*2,stage,true);
         new House2(1184+32*11, 32*8,stage , false);
        new House2(1184+32*25,32*17,stage , true);
        new House1(1184+32*20,32*7,stage,false);
        new House1(1184+32*16, 32*16,stage , true);
        new House1(1184+32*22, 32,stage , true);
        creatCastle(1184+32*30,32*2);

        new People1(32*5+1184,32,stage,true);
        new People1(32*30+ 1184,48,stage,true );

        for (int i = 0; i < 10; i++) {
           // new People(MathUtils.random(0, 2000), MathUtils.random(0, 700), stage);
        }

        Corner corner2 = new Corner(1184 + 15 * 32, 800 / 2f + 48 + 4*32-7*32, stage, "UR");
        BlankRoad blankRoad2 = new BlankRoad(1184 + 16 * 32, 800 / 2f + 48 + 4*32-7*32, stage);
        Corner corner12 = new Corner(1184 + 17 * 32, 800 / 2f + 48 + 4*32-7*32, stage, "UL");

        restaurant = new Restaurant(19*32,6*32,stage);
        rectangleRestaurant = new Rectangle(restaurant.getX()-32*3, restaurant.getY()-32*2, restaurant.getWidth()+ 32*4, restaurant.getHeight() + 32*3);
        restaurant.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(rectangleRestaurant.contains(player.getX(), player.getY())) {
                    if (amountOfFood <= 70) {
                        showMenuFood();
                    }
                }
            }
        });
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



    public void creatCastle(float x , float y ){
        new Castle(x,y,stage);
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
        if(thuTuNhiemVuTanBinh== 4){
            nhiemVuTanBinh= true;
            thuTuNhiemVuTanBinh ++;
        }if(thuTuNhiemVuTanBinh < 4){
            nhiemVuTanBinh = true;
            thuTuNhiemVuTanBinh = 1;
        }
        inCreate = false;
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
    private void closeTrashBoard(){
        bangTrashCross.setPosition(-456432,-458921);
        bangTrash.setPosition(-3456423,-564859);
        giaiThichHuuCo.setPosition(-243652,-45234);
        giaiThichVoCo.setPosition(-243652,-45234);
        giaiThichTaiChe.setPosition(-243652,-45234);
        giaiThichNguyHai.setPosition(-243652,-45234);
        luaChon1NhaRac.setPosition(-243652,-45234);
        luaChon2NhaRac.setPosition(-243652,-45234);
        luaChon3NhaRac.setPosition(-243652,-45234);
        luaChon4NhaRac.setPosition(-243652,-45234);
        luaChon5NhaRac.setPosition(-243652,-45234);
        line.setHeight(0);
        line.setY(Gdx.graphics.getHeight()-32*5-4);
        line2.setHeight(0);
        line2.setY(32*2+8);
        hienBangTrash=false;
    }

    private void closeFactoryBoard(){
        bangFactoryCross.setPosition(-456432,-458921);
        hienBangFactory = false;
        hienChiSo = false;
        dongXayDung();
        dongCongCu();
        dongXeCo();
        bangFactory.setPosition(-543324,-67543434);
        xayDungButton.setPosition(-24355,-54325);
        congCuButton.setPosition(-24355,-54325);
        xeCoButton.setPosition(-24355,-54325);
        line.setHeight(0);
        line2.setHeight(0);
    }
    public void resetDailyQuest(){
        int ran = MathUtils.random(1,6);
        switch (ran){
            case 1-> {
                nhiemvu1 = 1;
                soNguoiChatCay = 3;
            }
            case 2-> {
                nhiemvu1 = 2;
                soNguoiDotBien = 3;
            }
            case 3->{
                nhiemvu1 = 3;
                soNguoiDotRac = 2;
            }
            case 4-> {
                nhiemvu1 = 4;
                soNguoiChatCay =4;
            }
            case 5-> {
                nhiemvu1 = 5;
                soNguoiDotBien = 4;
            }
            case 6-> {
                nhiemvu1 = 6;
                soNguoiDotRac = 3;
            }
        }
        int ran1 = MathUtils.random(1,6);
        switch (ran1){
            case 1-> {
                nhiemvu2 = 1;
                soCayConLai = 5;
            }
            case 2-> nhiemvu2 = 2;
            case 3-> nhiemvu2 = 3;
            case 4-> nhiemvu2 = 4;
            case 5-> nhiemvu2 = 5;
            case 6-> nhiemvu2 = 6;
        }
        int ran2 = MathUtils.random(1,6);
        switch (ran2){
            case 1-> nhiemvu3 = 1;
            case 2-> nhiemvu3 = 2;
            case 3-> nhiemvu3 = 3;
            case 4-> nhiemvu3 = 4;
            case 5-> nhiemvu3 = 5;
            case 6-> nhiemvu3 = 6;
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
        nen.stop();
        batch.dispose();
    }
}

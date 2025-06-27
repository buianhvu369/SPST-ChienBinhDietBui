package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Json;
import spst.com.Cameras.NormalCamera;
import spst.com.House.TruSo;
import spst.com.InFactory.*;
import spst.com.MoPhong.*;
import spst.com.Roads.Car;
import spst.com.Roads.CrossRoad.BlankRoad;
import spst.com.Roads.CrossRoad.Corner;
import spst.com.Roads.CrossWalk;
import spst.com.Roads.RoadWay;
import spst.com.Roads.Tree;
import spst.com.Screen.Master;
import spst.com.Screen.TrashScreen;

public class GameState{
    public static int money = 5000;
    public static int ernegy=200;
    public static int danso = 100000;
    public static String xuhuongdantangorgiam = "tăng dân số";
    public static String event = "";
    public static String camxucnguoidan = "Vui vẻ.";
    public static String lydocamxucnguoidan = "Không khí rất trong lành ";
    public static int levelcongnghexanh = 0;
    public static int levelgiaothongxanh = 0;
    public static int greenscore = 50;
    public static float SO2 = 200;
    public static float NO2 = 200;
    public static float CO1 = 200;
    public static float O3 = 200;
    public static float PM2_5 = 200;
    public static float PM10 = 200;
    public static float AQISO2 = 0;
    public static float AQINO2 = 0;
    public static float AQICO1 = 0;
    public static float AQIO3 = 0;
    public static float AQIPM2_5 = 0;
    public static float AQIPM10 = 0;
    public static int soDat = 0;
    public static int soViaHe = 0;
    public static int soRoad = 0;
    public static int soReRoad = 0;
    public static int soVongCungNgoai = 0;
    public static int soBlankRoad = 0;
    public static int soCanhRoad = 0;
    public static int soRacHuuCo = 0;
    public static int soRacVoCo = 0;
    public static int soRacTaiChe = 0;
    public static int soRacNguyHai = 0;
    public static int soMLtoidacothemua = 2;
    public static int soMayLocBought = 0;
    public static boolean isDaThang = false;
    public static boolean isCoXeng = false;
    public static boolean isCoChoi = false;
    public static boolean isCoRiu = false;
    public static boolean isCoXeRac = false;
    public static boolean isCoTaxi = false;
    public static boolean isCoPolice = false;
    public static boolean isCoElecCar = false;
    public static int day = 1;
    public static int month = 3;
    public static int year = 2025;

    public static String nenMua = "";
    public static void saveGame() {
        SaveGame saveGame = new SaveGame(true);
        Json json = new Json();
        String jsonString = json.toJson(saveGame);

        FileHandle fileHandle = Gdx.files.local("data.json") ;
        fileHandle.writeString(jsonString,false, "UTF-8");
    }
    public static void loadGame() {
        FileHandle file = Gdx.files.local("data.json");
        if (!file.exists()) {
            // do nothing
        } else {
            Json json = new Json();
            SaveGame saveGame =  json.fromJson(SaveGame.class, file.readString("UTF-8"));
            money = saveGame.money;
            ernegy = saveGame.ernegy;
            greenscore = saveGame.greenscore;
            danso = saveGame.danso;
            PM2_5 = saveGame.PM2_5;
            PM10 = saveGame.PM10;
            SO2 = saveGame.SO2;
            NO2 = saveGame.NO2;
            CO1 = saveGame.CO1;
            O3 = saveGame.O3;

            Master.soCamera = saveGame.soCamera;
            Master.soBienCam = saveGame.soBienCam;
            Master.soMayLoc = saveGame.soML;
            Master.amountSeed = saveGame.soSeed;
            Master.sohieucuaMLKKdangchondenangcap = saveGame.sohieucuaMLKKdangchondenangcap;
            Master.soCuaCameraDangLooking = saveGame.soCuaCameraDangLooking;

            Master.isCNX = saveGame.isCNX;
            Master.isGTX = saveGame.isGTX;
            Master.gio1phan60 = saveGame.gio1Phan60;
            Master.timeOfDay = saveGame.timeOfDay;
            day = saveGame.day;
            month = saveGame.month;
            year = saveGame.year;

            Master.WLK = 'K';
            Master.amountOfFood = 100;
            Master.blood.setColor(Master.blood.getColor().r,Master.blood.getColor().g,Master.blood.getColor().b,saveGame.colorREDRiver);

            soVongCungNgoai = saveGame.soVongCungNgoai;
            soDat = saveGame.soDat;
            soBlankRoad = saveGame.soBlankRoad;
            soCanhRoad = saveGame.soCanhRoad;
            soRoad = saveGame.soRoad;
            soReRoad = saveGame.soReRoad;
            soViaHe = saveGame.soViaHe;

            levelcongnghexanh = saveGame.levelcongnghexanh;
            levelgiaothongxanh = saveGame.levelgiaothongxanh;

            soRacHuuCo = saveGame.soRacHuuCo;
            soRacVoCo = saveGame.soRacVoCo;
            soRacTaiChe = saveGame.soRacTaiChe;
            soRacNguyHai = saveGame.soRacNguyHai;

            soMLtoidacothemua = saveGame.soMLtoidacothemua;
            soMayLocBought = saveGame.soMayLocBought;
            isDaThang = saveGame.isDaThang;

            isCoXeng = saveGame.isCoXeng;
            isCoChoi = saveGame.isCoChoi;
            isCoRiu = saveGame.isCoRiu;
            isCoXeRac = saveGame.isCoXeRac;
            isCoTaxi = saveGame.isCoTaxi;
            isCoPolice = saveGame.isCoPolice;

            for(CarMP b : saveGame.carArray){
                Car a = new Car(b.x,b.y,Master.stage);
                Master.cars.add(a);
            }
            for(WasteMP b : saveGame.wasteArray){
                Waste a = new Waste(b.x,b.y,Master.stage,b.cos);
                //Master.wastes.add(a);
            }
            for(TreeMP b : saveGame.treeArray){
                Tree a = new Tree(b.x,b.y,Master.stage);
                a.type = b.type;
                Master.trees.add(a);
            }
            for(MLMP b : saveGame.mayLocArray){
                MayLoc a = new MayLoc(b.x,b.y,Master.stage,27*2,47*2);
                a.name = b.name;
                a.level = b.level;
                Master.MLKKs.add(a);
            }
            for(SignMP b : saveGame.signArray){
                Sign a = new Sign(b.x,b.y,b.myIsCamDotRac,Master.stage);
                Master.signs.add(a);
            }
            for(NormalCameraMP b : saveGame.normalCameraArray){
                NormalCamera a = new NormalCamera(b.x,b.y,Master.stage);
                a.name = b.name;
                Master.normalCameras.add(a);
            }
            for(TaiNguyenMP b : saveGame.VLLDArray){
                switch (b.typeVL){
                    case DuongTrong -> {
                        new BuyBlank(b.x,b.y,Master.stage);
                    }
                    case DuongThang -> {
                        BuyRoad a = new BuyRoad(b.x,b.y,Master.stage);
                        a.direction = b.directionRoad;
                    }
                    case NgaRe -> {
                        BuyRoadRe a = new BuyRoadRe(b.x,b.y,Master.stage);
                        a.direc = b.directionRoadRe;
                        a.type = b.typeRoadRe;
                    }
                    case ViaHe -> {
                        new BuyViaHe(b.x,b.y,Master.stage);
                    }
                    case VongCung -> {
                        BuyRoadReNgoai a = new BuyRoadReNgoai(b.x,b.y,Master.stage);
                        a.setRotation(b.rotationRoadReNgoai);
                    }
                    case Dat -> {
                        new BuyDirt(b.x,b.y,Master.stage);
                    }
                }
            }
        }
    }
    public static void reset(){
        money = 5000;
        ernegy=200;
        greenscore=50;
        danso = 100000;
        PM2_5 = 200;
        PM10 = 200;
        NO2 = 200;
        SO2 = 200;
        CO1 = 200;
        O3 = 200;

        Master.soCamera = 0;
        Master.soBienCam = 0;
        Master.soMayLoc = 0;
        Master.amountSeed = 0;
        Master.sohieucuaMLKKdangchondenangcap = 0;
        Master.soCuaCameraDangLooking = 0;
        Master.amountOfFood = 100;

        Master.hienChiSo = false;
        Master.hienThongTin = false;
        Master.hienNghienCuu = false;
        Master.hienCheTao = false;
        Master.isOpenSetting = false;
        Master.isCNX = false;
        Master.isGTX = false;
        Master.mLKKAction = true;
        Master.factoryAction = true;
        Master.trafficAction = true;
        Master.gio1phan60 = 0;
        Master.timeOfDay = 0;
        day = 1;
        month = 3;
        year = 2025;

        soDat = 0;
        soViaHe = 0;
        soRoad = 0;
        soReRoad = 0;
        soVongCungNgoai = 0;
        soBlankRoad = 0;
        soCanhRoad = 0;

        soRacHuuCo=0;
        soRacVoCo=0;
        soRacTaiChe=0;
        soRacNguyHai=0;

        soMLtoidacothemua = 2;
        soMayLocBought = 0;
        isDaThang = false;

        isCoXeng = false;
        isCoChoi = false;
        isCoRiu = false;
        isCoXeRac = false;
        isCoTaxi = false;
        isCoPolice = false;

        Master.WLK = 'K';
        Master.AQI = 250;
        Master.amountOfFood = 100;
        for(Actor a : Master.winsorloses){
            a.remove();
        }
        Master.winsorloses.clear();
        Master.blood.setColor(1,0,0,0);

        TrashScreen.time=0;
        TrashScreen.speed = 1;
        TrashScreen.sohuucodaphanloai=0;
        TrashScreen.sovocodaphanloai=0;
        TrashScreen.sotaichedaphanloai=0;
        TrashScreen.songuyhaidaphanloai=0;
        TrashScreen.sohuucodara=0;
        TrashScreen.sovocodara=0;
        TrashScreen.sotaichedara=0;
        TrashScreen.songuyhaidara=0;

        Master.cars.clear();
        Master.roads.clear();
        Master.wastes.clear();
        Master.trees.clear();
        Master.MLKKs.clear();
        Master.rices.clear();
        Master.normalCameras.clear();
        float x = Master.player.getX();
        float y = Master.player.getY();
        Master.player.isAlive=true;
        Master.player.isBep=false;
        Master.player = new Player(x,y,Master.stage);
    }
}

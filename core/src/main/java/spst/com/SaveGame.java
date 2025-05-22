package spst.com;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.Array;
import spst.com.Cameras.NormalCamera;
import spst.com.Enums.TypeVL;
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

public class SaveGame{
    Array<CarMP> carArray = new Array<>();
    Array<WasteMP> wasteArray = new Array<>();
    Array<TreeMP> treeArray = new Array<>();
    Array<MLMP> mayLocArray = new Array<>();
    Array<SignMP> signArray = new Array<>();
    Array<NormalCameraMP> normalCameraArray = new Array<>();
    Array<TaiNguyenMP> VLLDArray = new Array<>();

    public int money;
    public int ernegy;
    public int danso;
    public int levelcongnghexanh;
    public int levelgiaothongxanh;
    public int greenscore;
    public float SO2;
    public float NO2;
    public float CO1;
    public float O3;
    public float PM2_5;
    public float PM10;
    public int soRacHuuCo = 0;
    public int soRacVoCo = 0;
    public int soRacTaiChe = 0;
    public int soRacNguyHai = 0;
    public int soDat;
    public int soViaHe;
    public int soRoad;
    public int soReRoad;
    public int soVongCungNgoai;
    public int soBlankRoad;
    public int soCanhRoad;
    public int soCamera;
    public int soML;
    public int soBienCam;
    public int soSeed;
    public int sohieucuaMLKKdangchondenangcap;
    public int soCuaCameraDangLooking;
    public boolean isCNX;
    public boolean isGTX;
    public int day;
    public int gio1Phan60;
    public int timeOfDay;
    public float colorREDRiver;
    SaveGame(){}
    SaveGame(boolean koCanDungCaiNay){
        money = GameState.money;
        ernegy = GameState.ernegy;
        greenscore = GameState.greenscore;
        danso = GameState.danso;
        PM2_5 = GameState.PM2_5;
        PM10 = GameState.PM10;
        SO2 = GameState.SO2;
        NO2 = GameState.NO2;
        CO1 = GameState.CO1;
        O3 = GameState.O3;

        soCamera = Master.soCamera;
        soBienCam = Master.soBienCam;
        soML = Master.soMayLoc;
        soSeed = Master.amountSeed;
        sohieucuaMLKKdangchondenangcap = Master.sohieucuaMLKKdangchondenangcap;
        soCuaCameraDangLooking = Master.soCuaCameraDangLooking;

        isCNX = Master.isCNX;
        isGTX = Master.isGTX;
        day = Master.day;
        gio1Phan60 = Master.gio1phan60;
        timeOfDay = Master.timeOfDay;

        colorREDRiver = Master.blood.getColor().a;

        soVongCungNgoai = GameState.soVongCungNgoai;
        soDat = GameState.soDat;
        soBlankRoad = GameState.soBlankRoad;
        soCanhRoad = GameState.soCanhRoad;
        soRoad = GameState.soRoad;
        soReRoad = GameState.soReRoad;
        soViaHe = GameState.soViaHe;

        soRacHuuCo = GameState.soRacHuuCo;
        soRacVoCo = GameState.soRacVoCo;
        soRacTaiChe = GameState.soRacTaiChe;
        soRacNguyHai = GameState.soRacNguyHai;

        for(Car b : Master.cars){
            CarMP a = new CarMP(b.getX(),b.getY());
            carArray.add(a);
        }
        for(Waste b : Master.wastes){
            WasteMP a = new WasteMP(b.getX(),b.getY());
            wasteArray.add(a);
        }
        for(Tree b : Master.trees){
            TreeMP a = new TreeMP(b.getX(),b.getY());
            treeArray.add(a);
        }
        for(MayLoc b : Master.MLKKs){
            MLMP a = new MLMP(b.getX(),b.getY(),b.name);
            mayLocArray.add(a);
        }
        for(Sign b : Master.signs){
            SignMP a = new SignMP(b.getX(),b.getY(),b.myIsCamDotRac);
            signArray.add(a);
        }
        for(NormalCamera b : Master.normalCameras){
            NormalCameraMP a = new NormalCameraMP(b.getX(),b.getY(),b.name);
            normalCameraArray.add(a);
        }
        for(MyActor b : Master.VLLDs){
            if(b instanceof BuyBlank){
                TaiNguyenMP a = new TaiNguyenMP(b.getX(),b.getY(), TypeVL.DuongTrong);
                VLLDArray.add(a);
            }else if(b instanceof BuyDirt){
                TaiNguyenMP a = new TaiNguyenMP(b.getX(),b.getY(),TypeVL.Dat);
                VLLDArray.add(a);
            }else if(b instanceof BuyRoad){
                TaiNguyenMP a = new TaiNguyenMP(b.getX(),b.getY(),TypeVL.DuongThang);
                a.directionRoad = ((BuyRoad) b).direction;
                VLLDArray.add(a);
            }else if(b instanceof BuyRoadRe){
                TaiNguyenMP a = new TaiNguyenMP(b.getX(),b.getY(),TypeVL.NgaRe);
                a.directionRoadRe = ((BuyRoadRe) b).direc;
                a.typeRoadRe = ((BuyRoadRe) b).type;
                VLLDArray.add(a);
            }else if(b instanceof BuyRoadReNgoai){
                TaiNguyenMP a = new TaiNguyenMP(b.getX(),b.getY(),TypeVL.VongCung);
                a.rotationRoadReNgoai = (int) b.getRotation();
                VLLDArray.add(a);
            }else if(b instanceof BuyViaHe){
                TaiNguyenMP a = new TaiNguyenMP(b.getX(),b.getY(),TypeVL.ViaHe);
                VLLDArray.add(a);
            }
        }
    }
}

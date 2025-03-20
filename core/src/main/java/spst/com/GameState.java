package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import spst.com.Screen.Master;

public class GameState{
    public static int money = 5000;
    public static int ernegy=200;
    public static int danso = 100000;
    public static String xuhuongdantangorgiam = "tăng dân số";
    public static String event = "";
    public static String camxucnguoidan = "Vui vẻ.";
    public static String lydocamxucnguoidan = "Thuế = 0; tiền phạt = 0; số biển cấm đốt rác = 0; LUẬT PHÁP = 0.";
    public static int levelcongnghexanh = 0;
    public static int levelgiaothongxanh = 0;
    public static int greenscore = 50;
    public static float SO2 = 50;
    public static float NO2 = 90;
    public static float CO1 = 10;
    public static float O3 = 80;
    public static float PM2_5 = 100;
    public static float PM10 = 100;
    public static float AQISO2 = 0;
    public static float AQINO2 = 0;
    public static float AQICO1 = 0;
    public static float AQIO3 = 0;
    public static float AQIPM2_5 = 0;
    public static float AQIPM10 = 0;
    public static void saveGame() {
        Preferences preferences = Gdx.app.getPreferences("save");
        preferences.putInteger( "money", money);
        preferences.putFloat( "greenscore", greenscore);
        preferences.putFloat( "AQI", Master.AQI);
        preferences.putFloat( "SO2", SO2);
        preferences.putFloat( "CO1", CO1);
        preferences.putFloat( "NO2", NO2);
        preferences.putFloat( "O3", O3);
        preferences.putFloat( "PM2_5", PM2_5);
        preferences.putFloat( "PM10", PM10);
        preferences.putInteger( "ernegy", ernegy);
        preferences.putInteger( "danso", danso);
        preferences.putString( "xuhuongdantangorgiam", xuhuongdantangorgiam);
        preferences.putInteger( "levelcongnghexanh", levelcongnghexanh);
        preferences.putInteger( "levelgiaothongxanh", levelgiaothongxanh);
        preferences.putString( "event", event);
        preferences.putString( "camxucnguoidan", camxucnguoidan);
        preferences.putString( "lydocamxucnguoidan", lydocamxucnguoidan);
        preferences.putInteger(".", Master.soBienCam);
        preferences.putInteger("1",Master.soMayLoc );
        preferences.putInteger("",Master.soCamera);
        preferences.putInteger("",Master.amountSeed);
        preferences.flush();
    }
    public static void loadGame() {
        Preferences preferences = Gdx.app.getPreferences("save");
        money = preferences.getInteger("money", 0);
        Master.AQI = preferences.getFloat("AQI", 500);
        SO2 = preferences.getFloat("SO2",SO2);
        CO1 = preferences.getFloat("CO1",CO1);
        NO2 = preferences.getFloat("NO2",NO2);
        O3 = preferences.getFloat("O3",O3);
        PM2_5 = preferences.getFloat("PM2_5",PM2_5);
        PM10 = preferences.getFloat("PM10",PM10);
        greenscore = preferences.getInteger("greenscore",0);
        ernegy = preferences.getInteger("ernegy", 0);
        danso = preferences.getInteger("danso", 100000);
        xuhuongdantangorgiam = preferences.getString("xuhuongdantangorgiam", "tăng");
        levelcongnghexanh = preferences.getInteger("levelcongnghexanh",1);
        levelgiaothongxanh = preferences.getInteger("levelgiaothongxanh",1);
        event = preferences.getString("event","");
        camxucnguoidan = preferences.getString("camxucnguoidan","");
        lydocamxucnguoidan = preferences.getString("lydocamxucnguoidan","");
        Master.soBienCam = preferences.getInteger(".", 0);
        Master.amountSeed = preferences.getInteger(".", 0);
        Master.soMayLoc = preferences.getInteger(".", 0);
        Master.soCamera = preferences.getInteger(".", 0);
        System.out.println("Saved Data: " + preferences.get());
    }
    public static void reset(){
        money = 5000;
        ernegy=200;
        danso = 100000;
        PM2_5 = 100;
        PM10 = 150;
        NO2 = 90;
        SO2 = 50;
        CO1 = 10;
        O3 = 80;

        Master.soCamera = 0;
        Master.soBienCam = 0;
        Master.soMayLoc = 0;
        Master.amountSeed = 0;
        Master.sohieucuaMLKKdangchondenangcap = 0;
        Master.soCuaCameraDangLooking = 0;

        Master.hienChiSo = false;
        Master.hienThongTin = false;
        Master.hienNghienCuu = false;
        Master.hienCheTao = false;
        Master.isOpenSetting = false;
        Master.isCNX = false;
        Master.isGTX = false;
        Master.cutting = false;
        Master.mLKKAction = true;
        Master.factoryAction = true;
        Master.trafficAction = true;
        Master.day = 0;
        Master.gio1phan60 = 0;
        Master.timeOfDay = 0;

        Master.WLK = 0;

        Master.blood.setColor(1,0,0,0);

        Master.cars.clear();
        Master.roads.clear();
        Master.wastes.clear();
        Master.trees.clear();
        Master.MLKKs.clear();
        Master.rices.clear();
        Master.normalCameras.clear();
    }
}

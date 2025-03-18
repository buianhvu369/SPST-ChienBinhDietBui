package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import spst.com.Screen.Master;

public class GameState{
    public static int money= 5000;
    public static int ernegy=0;
    public static int danso = 100000;
    public static String xuhuongdantangorgiam = "tăng dân số";
    public static int thue = 0;
    public static int phat = 0;
    public static String event = "";
    public static String camxucnguoidan = "Vui vẻ.";
    public static String lydocamxucnguoidan = "Thuế = 0; tiền phạt = 0; số biển cấm đốt rác = 0; LUẬT PHÁP = 0.";
    public static int levelcongnghexanh = 1;
    public static int levelgiaothongxanh = 1;
    public static int greenscore = 1;
    public static float SO2 = 0;
    public static float NO2 = 0;
    public static float CO1 = 0;
    public static float O3 = 0;
    public static float PM2_5 = 0;
    public static float PM10 = 0;
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
        preferences.putInteger( "thue", thue);
        preferences.putInteger( "phat", phat);
        preferences.putInteger( "levelcongnghexanh", levelcongnghexanh);
        preferences.putInteger( "levelgiaothongxanh", levelgiaothongxanh);
        preferences.putString( "event", event);
        preferences.putString( "camxucnguoidan", camxucnguoidan);
        preferences.putString( "lydocamxucnguoidan", lydocamxucnguoidan);
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
        thue = preferences.getInteger("thue", 0);
        phat = preferences.getInteger("phat", 0);
        levelcongnghexanh = preferences.getInteger("levelcongnghexanh",1);
        levelgiaothongxanh = preferences.getInteger("levelgiaothongxanh",1);
        event = preferences.getString("event","");
        camxucnguoidan = preferences.getString("camxucnguoidan","");
        lydocamxucnguoidan = preferences.getString("lydocamxucnguoidan","");

        System.out.println("Saved Data: " + preferences.get());
    }
}

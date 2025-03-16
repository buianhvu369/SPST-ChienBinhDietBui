package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import spst.com.Screen.Master;

public class GameState{
    public static int money=0;
    public static int ernegy=0;
    public static int woods = 0;
    public static int thue = 0;
    public static int phat = 0;
    public static String event = "Người dân đốt biển cấm đốt rác.";
    public static String camxucnguoidan = "Vui vẻ.";
    public static String lydocamxucnguoidan = "Thuế = 0; tiền phạt = 0; số biển cấm đốt rác = 0; LUẬT PHÁP = 0.";
    public static int levelmaylockhongkhi = 1;
    public static void saveGame() {
        Preferences preferences = Gdx.app.getPreferences("save");
        preferences.putInteger( "money", money);
        preferences.putFloat( "greenscore", Master.AQI);
        preferences.putInteger( "ernegy", ernegy);
        preferences.putInteger( "treeseeds", Master.amountSeed);
        preferences.putInteger( "woods", woods);
        preferences.putInteger( "thue", thue);
        preferences.putInteger( "phat", phat);
        preferences.putInteger( "levelmaylockhongkhi", levelmaylockhongkhi);
        preferences.putString( "event", event);
        preferences.putString( "camxucnguoidan", camxucnguoidan);
        preferences.putString( "lydocamxucnguoidan", lydocamxucnguoidan);
        preferences.flush();
    }
    public static void loadGame() {
        Preferences preferences = Gdx.app.getPreferences("save");
        money = preferences.getInteger("money", 0);
        Master.AQI = preferences.getInteger("greenscore", 500);
        ernegy = preferences.getInteger("ernegy", 0);
        Master.amountSeed = preferences.getInteger("treeseeds", 0);
        woods = preferences.getInteger("woods", 0);
        thue = preferences.getInteger("thue", 0);
        phat = preferences.getInteger("phat", 0);
        levelmaylockhongkhi = preferences.getInteger("levelmaylockhongkhi",1);
        event = preferences.getString("event","");
        camxucnguoidan = preferences.getString("camxucnguoidan","");
        lydocamxucnguoidan = preferences.getString("lydocamxucnguoidan","");

        System.out.println("Saved Data: " + preferences.get());
    }
}

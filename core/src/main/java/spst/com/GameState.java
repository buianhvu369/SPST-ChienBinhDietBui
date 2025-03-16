package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import spst.com.Screen.Master;

public class GameState{
    public static int money=0;
    public static int ernegy=0;
    public static int treeseeds = 0;
    public static int woods = 0;
    public static int thue = 0;
    public static int phat = 0;
    public static void saveGame() {
        Preferences preferences = Gdx.app.getPreferences("save");
        preferences.putInteger( "money", money);
        preferences.putFloat( "greenscore", Master.AQI);
        preferences.putInteger( "ernegy", ernegy);
        preferences.putInteger( "treeseeds", treeseeds);
        preferences.putInteger( "woods", woods);
        preferences.putInteger( "thue", thue);
        preferences.putInteger( "phat", phat);
        preferences.flush();
    }
    public static void loadGame() {
        Preferences preferences = Gdx.app.getPreferences("save");
        money = preferences.getInteger("money", 0);
        Master.AQI = preferences.getInteger("greenscore", 0);
        ernegy = preferences.getInteger("ernegy", 0);
        treeseeds = preferences.getInteger("treeseeds", 0);
        woods = preferences.getInteger("woods", 0);
        thue = preferences.getInteger("thue", 0);
        phat = preferences.getInteger("phat", 0);

        System.out.println("Saved Data: " + preferences.get());
    }
}

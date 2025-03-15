package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class GameState{
    public static int money=0;
    public static int greenscore=0;
    public static int ernegy=0;
    public static void saveGame() {
        Preferences preferences = Gdx.app.getPreferences("save");
        preferences.putInteger( "money", money);
        preferences.putInteger( "greenscore", greenscore);
        preferences.putInteger( "ernegy", ernegy);
        preferences.putFloat( "AQI",Master.AQI );
        preferences.flush();
    }
    public static void loadGame() {
        Preferences preferences = Gdx.app.getPreferences("save");
        money = preferences.getInteger("money", 0);
        greenscore = preferences.getInteger("greenscore", 0);
        ernegy = preferences.getInteger("ernegy", 0);
        Master.AQI = preferences.getInteger("AQI", 250);

        System.out.println("Saved Data: " + preferences.get());
    }
}

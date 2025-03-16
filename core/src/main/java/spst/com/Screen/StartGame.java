package spst.com.Screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import spst.com.Screen.Master;
import spst.com.Screen.MenuScreen;

public class StartGame extends Game {
    GuideScreen guideScreen;
    MenuScreen menuScreen;
    public static BitmapFont font;
    public static BitmapFont font2;
    public static BitmapFont font3;
    Master master;
    @Override
    public void create() {

        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Lonely Cake.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 25;
        fontParameter.color = Color.BLUE;
        font = fontGenerator.generateFont(fontParameter);
        fontGenerator.dispose();

        FreeTypeFontGenerator fontGenerator2 = new FreeTypeFontGenerator(Gdx.files.internal("OpenSans.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter2 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter2.size = 32*2;
        fontParameter2.color = Color.BLACK;
        font2 = fontGenerator2.generateFont(fontParameter2);
        fontGenerator2.dispose();


        FreeTypeFontGenerator fontGenerator3 = new FreeTypeFontGenerator(Gdx.files.internal("vietnamese.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter3 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter3.size = 25;
        fontParameter3.color = Color.BLACK;
        font3 = fontGenerator3.generateFont(fontParameter3);
        fontGenerator3.dispose();

        menuScreen = new MenuScreen(this);

        this.master = new Master(menuScreen.game);
        this.guideScreen = new GuideScreen(this);
        this.menuScreen = new MenuScreen(this);
        setScreen(menuScreen);

    }

    @Override
    public void render() {
        super.render();
    }
}

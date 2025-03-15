package spst.com.Screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import spst.com.Screen.Master;
import spst.com.Screen.MenuScreen;

public class StartGame extends Game {
    Master master;
    GuideScreen guideScreen;
    MenuScreen menuScreen;
    public static BitmapFont font;
    @Override
    public void create() {

        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Lonely Cake.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 25;
        fontParameter.color = Color.BLUE;
        font = fontGenerator.generateFont(fontParameter);
        fontGenerator.dispose();

        this.master = new Master();
        this.guideScreen = new GuideScreen(this);
        this.menuScreen = new MenuScreen(this);
        setScreen(menuScreen);

    }

    @Override
    public void render() {
        super.render();
    }
}

package spst.com;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import spst.com.Screen.GuideScreen;
import spst.com.Screen.Master;
import spst.com.Screen.MenuScreen;

public class StartGame extends Game {
    public GuideScreen guideScreen;
    public MenuScreen menuScreen;
    public static BitmapFont font;
    public static BitmapFont font2;
    public static BitmapFont font3;
    public static BitmapFont fontEvent;
    public static BitmapFont fontTextField;
    public static BitmapFont fontTenNha;
    public static BitmapFont font4;
    public static BitmapFont font5;
    public static BitmapFont font6;
    public Master master;
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


        FreeTypeFontGenerator fontGenerator3 = new FreeTypeFontGenerator(Gdx.files.internal("vietnam.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter3 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter3.size = 25;
        fontParameter3.color = Color.GOLD;
        fontParameter3.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
            + "0123456789"
            + "ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨƠƯỲÝ"
            + "àáâãèéêìíòóôõùúăđĩơưỳý"
            + "ĂÂÊÔƠƯăâêôơư"
            + "ẠẢẤẦẨẪẬẮẰẲẴẶ"
            + "ẸẺẾỀỂỄỆ"
            + "ỊỈÍÌ"
            + "ỌỎỐỒỔỖỘỚỜỞỠỢ"
            + "ỤỦỨỪỬỮỰ"
            + "ỲỶỸỴ"
            + "áàảãạăắằẳẵặâấầẩẫậ"
            + "éèẻẽẹêếềểễệ"
            + "íìỉĩị"
            + "óòỏõọôốồổỗộơớờởỡợ"
            + "úùủũụưứừửữự"
            + "ýỳỷỹỵ"
            + "!@#$%^&*()-_=+[]{};:'\",.<>?/\\|";

        font3 = fontGenerator3.generateFont(fontParameter3);
        fontGenerator3.dispose();

        FreeTypeFontGenerator fontGeneratorEvent = new FreeTypeFontGenerator(Gdx.files.internal("vietnam.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameterEvent = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameterEvent.size = 25;
        fontParameterEvent.color = Color.GOLD;
        fontParameterEvent.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
            + "0123456789"
            + "ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨƠƯỲÝ"
            + "àáâãèéêìíòóôõùúăđĩơưỳý"
            + "ĂÂÊÔƠƯăâêôơư"
            + "ẠẢẤẦẨẪẬẮẰẲẴẶ"
            + "ẸẺẾỀỂỄỆ"
            + "ỊỈÍÌ"
            + "ỌỎỐỒỔỖỘỚỜỞỠỢ"
            + "ỤỦỨỪỬỮỰ"
            + "ỲỶỸỴ"
            + "áàảãạăắằẳẵặâấầẩẫậ"
            + "éèẻẽẹêếềểễệ"
            + "íìỉĩị"
            + "óòỏõọôốồổỗộơớờởỡợ"
            + "úùủũụưứừửữự"
            + "ýỳỷỹỵ"
            + "!@#$%^&*()-_=+[]{};:'\",.<>?/\\|";

        fontEvent = fontGeneratorEvent.generateFont(fontParameterEvent);
        fontGeneratorEvent.dispose();

        FreeTypeFontGenerator fontGeneratorTenNha = new FreeTypeFontGenerator(Gdx.files.internal("vietnam.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameterTenNha = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameterTenNha.size = 10;
        fontParameterTenNha.color = Color.BLACK;
        fontParameterTenNha.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
            + "0123456789"
            + "ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨƠƯỲÝ"
            + "àáâãèéêìíòóôõùúăđĩơưỳý"
            + "ĂÂÊÔƠƯăâêôơư"
            + "ẠẢẤẦẨẪẬẮẰẲẴẶ"
            + "ẸẺẾỀỂỄỆ"
            + "ỊỈÍÌ"
            + "ỌỎỐỒỔỖỘỚỜỞỠỢ"
            + "ỤỦỨỪỬỮỰ"
            + "ỲỶỸỴ"
            + "áàảãạăắằẳẵặâấầẩẫậ"
            + "éèẻẽẹêếềểễệ"
            + "íìỉĩị"
            + "óòỏõọôốồổỗộơớờởỡợ"
            + "úùủũụưứừửữự"
            + "ýỳỷỹỵ"
            + "!@#$%^&*()-_=+[]{};:'\",.<>?/\\|";

        fontTenNha = fontGeneratorTenNha.generateFont(fontParameterTenNha);
        fontGeneratorTenNha.dispose();

        FreeTypeFontGenerator fontGeneratorTextField = new FreeTypeFontGenerator(Gdx.files.internal("vietnam.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameterTextField = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameterTextField.size = 25;
        fontParameterTextField.color = Color.GOLD;
        fontParameterTextField.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
            + "0123456789"
            + "ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨƠƯỲÝ"
            + "àáâãèéêìíòóôõùúăđĩơưỳý"
            + "ĂÂÊÔƠƯăâêôơư"
            + "ẠẢẤẦẨẪẬẮẰẲẴẶ"
            + "ẸẺẾỀỂỄỆ"
            + "ỊỈÍÌ"
            + "ỌỎỐỒỔỖỘỚỜỞỠỢ"
            + "ỤỦỨỪỬỮỰ"
            + "ỲỶỸỴ"
            + "áàảãạăắằẳẵặâấầẩẫậ"
            + "éèẻẽẹêếềểễệ"
            + "íìỉĩị"
            + "óòỏõọôốồổỗộơớờởỡợ"
            + "úùủũụưứừửữự"
            + "ýỳỷỹỵ"
            + "!@#$%^&*()-_=+[]{};:'\",.<>?/\\|";

        fontTextField = fontGeneratorTextField.generateFont(fontParameterTextField);
        fontGeneratorTextField.dispose();

        FreeTypeFontGenerator fontGenerator4 = new FreeTypeFontGenerator(Gdx.files.internal("vietnam.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter4 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter4.size = 25;
        fontParameter4.color = Color.BLACK;
        fontParameter4.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
            + "0123456789"
            + "ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨƠƯỲÝ"
            + "àáâãèéêìíòóôõùúăđĩơưỳý"
            + "ĂÂÊÔƠƯăâêôơư"
            + "ẠẢẤẦẨẪẬẮẰẲẴẶ"
            + "ẸẺẾỀỂỄỆ"
            + "ỊỈÍÌ"
            + "ỌỎỐỒỔỖỘỚỜỞỠỢ"
            + "ỤỦỨỪỬỮỰ"
            + "ỲỶỸỴ"
            + "áàảãạăắằẳẵặâấầẩẫậ"
            + "éèẻẽẹêếềểễệ"
            + "íìỉĩị"
            + "óòỏõọôốồổỗộơớờởỡợ"
            + "úùủũụưứừửữự"
            + "ýỳỷỹỵ"
            + "!@#$%^&*()-_=+[]{};:'\",.<>?/\\|";

        font4 = fontGenerator4.generateFont(fontParameter4);
        fontGenerator4.dispose();

        FreeTypeFontGenerator fontGenerator5 = new FreeTypeFontGenerator(Gdx.files.internal("Lonely Cake.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter5 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter5.size = 20;
        fontParameter5.color = Color.GREEN;
        font5 = fontGenerator5.generateFont(fontParameter5);
        fontGenerator5.dispose();

        FreeTypeFontGenerator fontGenerator6 = new FreeTypeFontGenerator(Gdx.files.internal("vietnam.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter6 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter6.size = 25;
        fontParameter6.color = Color.BLACK;
        fontParameter6.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
            + "0123456789"
            + "ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨƠƯỲÝ"
            + "àáâãèéêìíòóôõùúăđĩơưỳý"
            + "ĂÂÊÔƠƯăâêôơư"
            + "ẠẢẤẦẨẪẬẮẰẲẴẶ"
            + "ẸẺẾỀỂỄỆ"
            + "ỊỈÍÌ"
            + "ỌỎỐỒỔỖỘỚỜỞỠỢ"
            + "ỤỦỨỪỬỮỰ"
            + "ỲỶỸỴ"
            + "áàảãạăắằẳẵặâấầẩẫậ"
            + "éèẻẽẹêếềểễệ"
            + "íìỉĩị"
            + "óòỏõọôốồổỗộơớờởỡợ"
            + "úùủũụưứừửữự"
            + "ýỳỷỹỵ"
            + "!@#$%^&*()-_=+[]{};:'\",.<>?/\\|";

        font6 = fontGenerator6.generateFont(fontParameter6);
        fontGenerator6.dispose();

        menuScreen = new MenuScreen(this);

        this.master = new Master(menuScreen.game);
        this.guideScreen = new GuideScreen(this);
        setScreen(menuScreen);

    }

    @Override
    public void render() {
        super.render();
    }
}

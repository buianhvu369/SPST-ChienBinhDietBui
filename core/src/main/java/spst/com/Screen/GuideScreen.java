package spst.com.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import spst.com.Button.ButtonDirec;
import spst.com.StartGame;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class GuideScreen implements Screen {
    Texture backButtonImage;
    StartGame game;
    Stage stage;
    OrthographicCamera camera;
    String[] guide;
    float y = Gdx.graphics.getHeight();
    ButtonDirec buttonDirecUp;
    ButtonDirec buttonDirecDown;

    public GuideScreen(StartGame game){
        this.game = game;
        stage = new Stage();

        buttonDirecUp = new ButtonDirec(Gdx.graphics.getWidth()-38,Gdx.graphics.getHeight()-26-80,'U',stage);
        buttonDirecDown = new ButtonDirec(Gdx.graphics.getWidth()-38,0,'D',stage);
        buttonDirecDown.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                GuideScreen.this.y+= 50;
            }
        });
        buttonDirecUp.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                GuideScreen.this.y-= 50;
            }
        });
        try{
            guide = Gdx.files.internal("guide.txt").readString(String.valueOf(StandardCharsets.UTF_8)).split("\n");
        }catch (Exception ignored){
          //  guide = "ko đọc được file, vui lòng thử lại sau";
        }
    }
    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        Master.batch = new SpriteBatch();

        backButtonImage = new Texture("back.png");

        TextButton.TextButtonStyle style2 = new TextButton.TextButtonStyle();
        style2.font = StartGame.font;
        style2.fontColor = Color.WHITE;
        style2.up = new TextureRegionDrawable(backButtonImage);
        TextButton backButton = new TextButton( "",style2);
        backButton.setPosition(Gdx.graphics.getWidth()-backButtonImage.getWidth(),
            Gdx.graphics.getHeight() - backButtonImage.getHeight()) ;
        stage.addActor(backButton);
        Gdx.input.setInputProcessor(stage);
        backButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(game.menuScreen);
            }
        });
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLUE);
        camera.update();
        Master.batch.setProjectionMatrix(camera.combined);

        Master.batch.begin();
        for (int i = 0; i < guide.length; i++) {
            switch (i){
                case 6,7,8,9,12,13,15,17 -> game.font3.draw(Master.batch,"      " + guide[i],0,y-i*30);
                case 18,19 -> game.font3.draw(Master.batch,"            " + guide[i],0,y-i*30);
                default -> game.font3.draw(Master.batch,guide[i],0,y-i*30);
            }
        }

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        Master.batch.end();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

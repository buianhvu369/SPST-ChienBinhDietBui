package spst.com.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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
import spst.com.StartGame;

public class GuideScreen implements Screen {
    Texture backButtonImage;
    StartGame game;
    Stage stage;
    OrthographicCamera camera;
    public GuideScreen(StartGame game){
        this.game = game;
        stage = new Stage();
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

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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

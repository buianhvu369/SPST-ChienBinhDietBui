package spst.com.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import spst.com.GameState;

public class MenuScreen implements Screen  {
    GlyphLayout layout;
    StartGame game;
    OrthographicCamera camera;
    Stage stage;
    Texture startButtonImage;
    Texture exitButtonImage;
    Texture continueButtonImage;

    Texture guideButtonImage;
    public MenuScreen(StartGame game){
        this.game = game;
        stage = new Stage();
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        Master.batch = new SpriteBatch();

        startButtonImage = new Texture("start.png");
        continueButtonImage = new Texture("continue.png");
        exitButtonImage = new Texture("exit.png");
        guideButtonImage = new Texture("guide.png");

        layout = new GlyphLayout();

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = StartGame.font;
        style.fontColor = Color.WHITE;
        style.up = new TextureRegionDrawable(startButtonImage);
        TextButton startButton = new TextButton( "",style);
        startButton.setPosition(0,
            Gdx.graphics.getHeight() /2f - startButton.getHeight()/2) ;
        stage.addActor(startButton);
        Gdx.input.setInputProcessor(stage);
        startButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(game.master);
            }
        });

        TextButton.TextButtonStyle style3 = new TextButton.TextButtonStyle();
        style3.font = StartGame.font;
        style3.fontColor = Color.WHITE;
        style3.up = new TextureRegionDrawable(continueButtonImage);
        TextButton continueButton = new TextButton( "",style3);
        continueButton.setPosition(32*7,
            Gdx.graphics.getHeight() /2f - startButton.getHeight()/2) ;
        stage.addActor(continueButton);
        Gdx.input.setInputProcessor(stage);
        continueButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                GameState.loadGame();
                game.setScreen(game.master);
            }
        });

        TextButton.TextButtonStyle style4 = new TextButton.TextButtonStyle();
        style4.font = StartGame.font;
        style4.fontColor = Color.WHITE;
        style4.up = new TextureRegionDrawable(exitButtonImage);
        TextButton exitButton = new TextButton( "",style4);
        exitButton.setPosition(32*14,
            Gdx.graphics.getHeight() /2f - startButton.getHeight()/2) ;
        stage.addActor(exitButton);
        Gdx.input.setInputProcessor(stage);
        exitButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });

        TextButton.TextButtonStyle style5 = new TextButton.TextButtonStyle();
        style5.font = StartGame.font;
        style5.fontColor = Color.WHITE;
        style5.up = new TextureRegionDrawable(guideButtonImage);
        TextButton guideButton = new TextButton( "",style5);
        guideButton.setPosition(32*21,
            Gdx.graphics.getHeight() /2f - startButton.getHeight()/2) ;
        stage.addActor(guideButton);
        Gdx.input.setInputProcessor(stage);
        guideButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(game.guideScreen);
            }
        });
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLUE);
        camera.update();
        Master.batch.setProjectionMatrix(camera.combined);
        Master.batch.begin();
        game.font.draw(Master.batch, layout, Gdx.graphics.getWidth()/2 - layout.width/2,Gdx.graphics.getHeight()/2 + 2*layout.height);
        Master.batch.end();
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


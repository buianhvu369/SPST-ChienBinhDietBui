package spst.com.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import spst.com.Button.Continue;
import spst.com.Button.Exit;
import spst.com.Button.Guide;
import spst.com.Button.Start;
import spst.com.GameState;
import spst.com.Piece;
import spst.com.StartGame;
import spst.com.Utils;

public class MenuScreen implements Screen  {
    GlyphLayout layout;
    public StartGame game;
    OrthographicCamera camera;
    Stage stage;
    Continue continueButton;
    Exit exitButton;
    Guide guideButton;
    Start startButton;
    public static Music nen = Gdx.audio.newMusic(Gdx.files.internal("gioithieu.mp3"));
    public MenuScreen(StartGame game){
        this.game = game;
        stage = new Stage();
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        Master.batch = new SpriteBatch();

        layout = new GlyphLayout();

        startButton = new Start(0,0,stage);
        startButton.setPosition(Gdx.graphics.getWidth()/2f-startButton.getWidth()/2f, 400); ;
        startButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new Master(game));
            }
        });

        continueButton = new Continue(0,0,stage);
        continueButton.setPosition(Gdx.graphics.getWidth()/2f-continueButton.getWidth()/2f, 300); ;
        continueButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                //GameState.loadGame();
                Utils.loadGameData();
                game.setScreen(game.master);
            }
        });

        exitButton = new Exit(0,0,stage);
        exitButton.setPosition(Gdx.graphics.getWidth()/2f-exitButton.getWidth()/2f, 200); ;
        exitButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });

        guideButton = new Guide(0,0,stage);
        guideButton.setPosition(Gdx.graphics.getWidth()/2f-guideButton.getWidth()/2f, 100); ;
        guideButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(game.guideScreen);
            }
        });

        Gdx.input.setInputProcessor(stage);

        nen.isLooping();
        nen.play();
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0,0,0,0);
        camera.update();
        Master.batch.setProjectionMatrix(camera.combined);
        Master.batch.begin();
        game.font.draw(Master.batch, layout, Gdx.graphics.getWidth()/2 - layout.width/2,Gdx.graphics.getHeight()/2 + 2*layout.height);
        Master.batch.end();

        new Piece(0, 0, stage).toBack();
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


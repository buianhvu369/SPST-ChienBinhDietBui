package spst.com.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import spst.com.*;
import spst.com.Button.Continue;
import spst.com.Button.Exit;
import spst.com.Button.Guide;
import spst.com.Button.Start;

import java.nio.charset.StandardCharsets;

import static com.badlogic.gdx.math.MathUtils.random;

public class CotTruyenScreen implements Screen  {
    GlyphLayout layout = new GlyphLayout();
    public StartGame game;
    OrthographicCamera camera;
    Stage stage;
    String[] cottruyen;
    TextButton skip;
    public static Music nen = Gdx.audio.newMusic(Gdx.files.internal("nhaccottruyen.mp3"));
    int time = 0;
    public CotTruyenScreen(StartGame game){
        this.game = game;
        stage = new Stage();

        try{
            cottruyen = Gdx.files.internal("cottruyen.txt").readString(String.valueOf(StandardCharsets.UTF_8)).split("\n");
        }catch (Exception ignored){
            cottruyen = new String[]{"ko đọc được file, vui lòng thử lại sau"};
        }
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        Master.batch = new SpriteBatch();

        Gdx.input.setInputProcessor(stage);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.fontColor = Color.WHITE;
        skip = new TextButton( "SKIP",style);
        skip.setPosition(Gdx.graphics.getWidth()-skip.getWidth(),Gdx.graphics.getHeight()-skip.getHeight()) ;
        stage.addActor(skip);
        Gdx.input.setInputProcessor(stage);
        skip.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                nen.stop();
                game.setScreen(game.menuScreen);
            }
        });
        layout.width = 300;
        layout.height = 40;
        nen.isLooping();
        nen.play();
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0,0,0,0);
        camera.update();
        Master.batch.setProjectionMatrix(camera.combined);

        time++;
        new Piece(0, 0, stage).toBack();
        if(time<60*7){
            Master.batch.begin();
            for(int i = 0; i < 7; i++){
                layout.setText(game.font3,cottruyen[i]);
                game.font3.draw(Master.batch,layout,Gdx.graphics.getWidth()/2f - layout.width/2f,Gdx.graphics.getHeight()/2f + 40*7/2f-i* 40);
            }
            Master.batch.end();
        }
        else if(time<60*(7+4)){
            Master.batch.begin();
            for(int i = 0; i < 4; i++){
                layout.setText(game.font3,cottruyen[i+7]);
                game.font3.draw(Master.batch,layout,Gdx.graphics.getWidth()/2f - layout.width/2f,Gdx.graphics.getHeight()/2f + 40*4/2f-i* 40);
            }
            Master.batch.end();
        }
        else if(time<60*(7+4+6)){
            Master.batch.begin();
            for(int i = 0; i < 6; i++){
                layout.setText(game.font3,cottruyen[i+7+4]);
                game.font3.draw(Master.batch,layout,Gdx.graphics.getWidth()/2f - layout.width/2f,Gdx.graphics.getHeight()/2f + 40*6/2f-i* 40);
            }
            Master.batch.end();
        }else {
            Master.batch.begin();
            if(time%60==30){
                layout.setText(game.font3,"Ấn vào màn hình để tiếp tục");
            }else if (time%60==0){
                layout.setText(game.font3,"");
            }
            game.font3.draw(Master.batch,layout,Gdx.graphics.getWidth()/2f - layout.width/2f,Gdx.graphics.getHeight()/2f + 40/2f);
            Master.batch.end();
            if (Gdx.input.justTouched()) {
                nen.stop();
                game.setScreen(game.menuScreen);
            }
        }
        stage.act(Gdx.graphics.getDeltaTime());
        if (time%60==30){
            skip.remove();
        }else if (time%60==0){
            stage.addActor(skip);
        }
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


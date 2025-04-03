package spst.com.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
import spst.com.Roads.RoadInCotTruyen;

import java.nio.charset.StandardCharsets;

import static com.badlogic.gdx.math.MathUtils.random;

public class CotTruyenScreen implements Screen  {
    GlyphLayout layout = new GlyphLayout();
    public StartGame game;
    OrthographicCamera camera;
    Stage stage;
    String[] cottruyen;
    TextButton skip;
    Player man;
    public static Music nen = Gdx.audio.newMusic(Gdx.files.internal("nhaccottruyen.mp3"));
    int time = 0;
    ShapeRenderer shapeRenderer;

    public CotTruyenScreen(StartGame game){
        this.game = game;
        stage = new Stage();
        shapeRenderer = new ShapeRenderer();
        try{
            cottruyen = Gdx.files.internal("cottruyen.txt").readString(String.valueOf(StandardCharsets.UTF_8)).split("\n");
        }catch (Exception ignored){
            cottruyen = new String[]{"ko đọc được file, vui lòng thử lại sau"};
        }
        float x = 0;
        for (int i = 0; i < 17; i++) {
            new RoadInCotTruyen(x, 0, stage);
            x += 64;
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
        man = new Player(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, stage);
        man.animationRight.setFrameDuration(0.2f);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0.03f, 0.03f, 0.07f, 1.0f);
        camera.update();
        Master.batch.setProjectionMatrix(camera.combined);
        man.setPosition(Gdx.graphics.getWidth() / 2 - man.getWidth() / 2, 64);

        time++;
        float alpha = 1.0f; // Độ trong suốt ban đầu

        Master.batch.begin();

        if (time < 60 * 7) {
            alpha = 1.0f - (float) time / (60 * 7);
            game.font3.setColor(1, 1, 1, alpha);
            for (int i = 0; i < 7; i++) {
                layout.setText(game.font3, cottruyen[i]);
                game.font3.draw(Master.batch, layout, Gdx.graphics.getWidth() / 2f - layout.width / 2f, Gdx.graphics.getHeight() / 2f + 40 * 7 / 2f - i * 40);
            }
            Master.batch.end();
        } else if (time < 60 * (7 + 4)) {
            alpha = 1.0f - (float) (time - 60 * 7) / (60 * 4);
            game.font3.setColor(1, 1, 1, alpha);
            for (int i = 0; i < 4; i++) {
                layout.setText(game.font3, cottruyen[i + 7]);
                game.font3.draw(Master.batch, layout, Gdx.graphics.getWidth() / 2f - layout.width / 2f, Gdx.graphics.getHeight() / 2f + 40 * 4 / 2f - i * 40);
            }
            Master.batch.end();
        } else if (time < 60 * (7 + 4 + 6)) {
            alpha = 1.0f - (float) (time - 60 * (7 + 4)) / (60 * 6);
            game.font3.setColor(1, 1, 1, alpha);
            for (int i = 0; i < 6; i++) {
                layout.setText(game.font3, cottruyen[i + 7 + 4]);
                game.font3.draw(Master.batch, layout, Gdx.graphics.getWidth() / 2f - layout.width / 2f, Gdx.graphics.getHeight() / 2f + 40 * 6 / 2f - i * 40);
            }
            Master.batch.end();
        } else {
            if (time % 60 == 30) {
                layout.setText(game.font3, "Nhấn vào đây để bắt đầu");
            } else if (time % 60 == 0) {
                layout.setText(game.font3, "");
            }
            game.font3.setColor(1, 1, 1, 1.0f);
            game.font3.draw(Master.batch, layout, Gdx.graphics.getWidth() / 2f - layout.width / 2f, Gdx.graphics.getHeight() / 2f + 40 / 2f);

            Master.batch.end();

            if (Gdx.input.justTouched()) {
                nen.stop();
                game.setScreen(game.menuScreen);
            }
        }

        // Hiển thị hoặc ẩn nút SKIP theo thời gian
        stage.act();
        if (time % 60 == 30) {
            skip.remove();
        } else if (time % 60 == 0) {
            stage.addActor(skip);
        }
        stage.draw();

        // trăng đêm
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.circle(870, 460, 50);
        shapeRenderer.end();
    }



//    @Override
//    public void render(float v) {
//        ScreenUtils.clear(0,0,0,0);
//        camera.update();
//        Master.batch.setProjectionMatrix(camera.combined);
//        man.setPosition(Gdx.graphics.getWidth()/2 - man.getWidth()/2, 64);
//
//        time++;
//      //  new Piece(0, 0, stage).toBack();
//        if(time<60*7){
//            Master.batch.begin();
//            for(int i = 0; i < 7; i++){
//                layout.setText(game.font3,cottruyen[i]);
//                game.font3.draw(Master.batch,layout,Gdx.graphics.getWidth()/2f - layout.width/2f,Gdx.graphics.getHeight()/2f + 40*7/2f-i* 40);
//            }
//            Master.batch.end();
//        }
//        else if(time<60*(7+4)){
//            Master.batch.begin();
//            for(int i = 0; i < 4; i++){
//                layout.setText(game.font3,cottruyen[i+7]);
//                game.font3.draw(Master.batch,layout,Gdx.graphics.getWidth()/2f - layout.width/2f,Gdx.graphics.getHeight()/2f + 40*4/2f-i* 40);
//            }
//            Master.batch.end();
//        }
//        else if(time<60*(7+4+6)){
//            Master.batch.begin();
//            for(int i = 0; i < 6; i++){
//                layout.setText(game.font3,cottruyen[i+7+4]);
//                game.font3.draw(Master.batch,layout,Gdx.graphics.getWidth()/2f - layout.width/2f,Gdx.graphics.getHeight()/2f + 40*6/2f-i* 40);
//            }
//            Master.batch.end();
//        }else {
//            Master.batch.begin();
//            if(time%60==30){
//                layout.setText(game.font3,"Ấn vào màn hình để tiếp tục");
//            }else if (time%60==0){
//                layout.setText(game.font3,"");
//            }
//            game.font3.draw(Master.batch,layout,Gdx.graphics.getWidth()/2f - layout.width/2f,Gdx.graphics.getHeight()/2f + 40/2f);
//            Master.batch.end();
//            if (Gdx.input.justTouched()) {
//                nen.stop();
//                game.setScreen(game.menuScreen);
//            }
//        }
//        stage.act(Gdx.graphics.getDeltaTime());
//        if (time%60==30){
//            skip.remove();
//        }else if (time%60==0){
//            stage.addActor(skip);
//        }
//        stage.draw();
//
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//        shapeRenderer.setColor(Color.YELLOW);
//        shapeRenderer.circle(870, 460, 50);
//        shapeRenderer.end();
//    }

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


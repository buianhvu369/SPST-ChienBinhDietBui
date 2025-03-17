package spst.com.Button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import spst.com.MyActor;
import spst.com.Screen.Master;
import spst.com.Screen.StartGame;

public class creatMayLoc extends MyActor {
   Texture button = new Texture("buttonblank.png");
    public creatMayLoc(float x, float y, Stage s) {
        super(x, y, s);
        textureRegion = new TextureRegion(button);
        setSize(64, 64);
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = StartGame.font2;
        style.fontColor = Color.RED;
        style.up = new TextureRegionDrawable(button);
        TextButton startButton = new TextButton("Tạo một máy lọc không khí",style);
        startButton.setSize(200,80);
        startButton.setPosition(x,
            y ) ;
        startButton.setSize(50,800);
        s.addActor(startButton);
        startButton.toFront();
        startButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                Master.soMayLoc ++;
                System.out.println(Master.soMayLoc);
            }
        });
    }
}

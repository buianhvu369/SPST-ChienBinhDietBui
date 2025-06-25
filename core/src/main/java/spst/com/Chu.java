package spst.com;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Chu extends Actor {
    public String text;
    private BitmapFont font;
    private Color myColor;
    public Chu(float x, float y, Stage s, Color color) {
        text = "";
        font = StartGame.fontEvent; // Font mặc định của LibGDX
        font.setColor(color);

        setPosition(x,  y);
        setColor(1, 1, 1, 1); // Đảm bảo alpha ban đầu là 1 (không trong suốt)
        toFront();
        s.addActor(this);
        myColor = color;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        font.setColor(myColor);
        font.draw(batch, text, getX(), getY());
    }
}

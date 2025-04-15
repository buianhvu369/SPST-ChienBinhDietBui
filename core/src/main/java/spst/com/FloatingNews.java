package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class FloatingNews extends Actor {
    private String text;
    private BitmapFont font;
    private Color myColor;
    public FloatingNews(float x,float y,Stage s, String news, Color color) {
        text = news;
        font = StartGame.fontEvent; // Font mặc định của LibGDX
        font.setColor(color);

        setPosition(x,  y);
        setColor(1, 1, 1, 1); // Đảm bảo alpha ban đầu là 1 (không trong suốt)

        // Hiệu ứng di chuyển lên + làm mờ dần + xóa sau 1 giây
        addAction(Actions.sequence(
            Actions.moveBy(0, 30, 1f),  // Bay lên 30 pixel trong 1 giây
            Actions.fadeOut(1f),        // Làm mờ trong 1 giây
            Actions.removeActor()       // Xóa khỏi stage
        ));
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

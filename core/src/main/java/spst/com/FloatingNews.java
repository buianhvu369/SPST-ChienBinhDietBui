package spst.com;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import spst.com.Screen.StartGame;

public class FloatingNews extends Actor {
    private String text;
    private BitmapFont font;

    public FloatingNews(Stage s, String news) {
        text = news;
        font = StartGame.font3; // Font mặc định của LibGDX
        font.setColor(Color.BLACK);

        setPosition(500,  400);
        setColor(1, 1, 1, 1); // Đảm bảo alpha ban đầu là 1 (không trong suốt)

        // Hiệu ứng di chuyển lên + làm mờ dần + xóa sau 1 giây
        addAction(Actions.sequence(
            Actions.moveBy(0, 30, 1f),  // Bay lên 30 pixel trong 1 giây
            Actions.fadeOut(1f),        // Làm mờ trong 1 giây
            Actions.removeActor()       // Xóa khỏi stage
        ));
        System.out.println(news);
        toFront();
        s.addActor(this);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        font.setColor(1, 1, 1, getColor().a * parentAlpha);
        font.draw(batch, text, getX(), getY());
    }
}

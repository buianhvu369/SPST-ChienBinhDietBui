package Game.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Utils {
    // 27 x 18
    private static Texture texture = new Texture("tilemap.png");

    public static TextureRegion getRegion(int x, int y, int width, int height) {
        return new TextureRegion(texture, x, y, width, height);
    }
}

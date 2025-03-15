package spst.com;

import com.badlogic.gdx.Game;

public class StartGame extends Game {
    @Override
    public void create() {
        GameState.loadGame();
        setScreen(new Master());
    }

    @Override
    public void render() {
        super.render();
    }
}

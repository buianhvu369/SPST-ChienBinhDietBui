package spst.com;

import com.badlogic.gdx.utils.Array;
import spst.com.Roads.Tree;

public class GameStateTmp {
    public int money = 5000;
    public int ernegy=200;
    public int danso = 100000;
    public Array<Integer> trees;

    public GameStateTmp(){}

    public GameStateTmp(int money, int ernegy, int danso, Array<Integer> trees) {
        this.money = money;
        this.ernegy = ernegy;
        this.danso = danso;
        this.trees = trees;
    }
}

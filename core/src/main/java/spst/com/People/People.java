//package spst.com.People;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.math.MathUtils;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.actions.Actions;
//import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//import spst.com.GameState;
//import spst.com.MyActor;
//import spst.com.Roads.Tree;
//import spst.com.Screen.Master;
//import spst.com.Utils;
//import spst.com.town.Fire;
//
//import static com.badlogic.gdx.math.MathUtils.random;
//
//public class People extends MyActor {
//    boolean isCutting = false;
//    boolean isFiring = false;
//    boolean isFine = false;
//    int time = 0;
//    public People(float x, float y, Stage s) {
//        super(x, y, s);
//        textureRegion = Utils.getRegion( 23*16 + 16* random(0, 3), random(0, 17)*16,16,16);
//        setSize(32, 32);
//        addListener(new ClickListener(){
//            public void clicked(InputEvent event, float x, float y){
//               if(isCutting||isFiring){
//                   GameState.money += 125 ;
//               }else {
//                   GameState.money -= 50;
//               }
//            }
//        });
//    }
//
//    @Override
//    public void act(float delta) {
//        super.act(delta);
//        time ++;
//
//        if(time % 300 == 0){
//            time = 0;
//            isCutting = MathUtils.randomBoolean();
//            isFiring = MathUtils.randomBoolean();
//            if(isCutting){
//                if(!Master.trees.isEmpty()){
//                    System.out.println("Chat cay thoi anh em!");
//                    Tree tree = Master.trees.removeIndex(random(0, Master.trees.size - 1));
//                    tree.isCutDown = true;
//
//                    // Thêm action đó là đợi 5 giây sau thì xóa cây
//                    tree.addAction(Actions.sequence(
//                        Actions.delay(5),
//                        Actions.removeActor()
//                    ));
//                    setPosition(tree.getX() + 32, tree.getY());
//                    System.out.println(GameState.money);
//
//                }
//            } else if(isFiring) {
//                setPosition(random.nextInt(100,200),random.nextInt(30,670));
//                new Fire(getX()+32,getY(),getStage());
//            }
//        }
//    }
//}

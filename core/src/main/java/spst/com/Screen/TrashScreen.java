package spst.com.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import spst.com.*;
import spst.com.Button.Cross;
import spst.com.Button.WhiteButton;
import spst.com.Speeds.ConTrolSpeed;
import spst.com.Volume.ConTrol;
import spst.com.Volume.ThanhControl;

public class TrashScreen implements Screen {
    StartGame game;
    OrthographicCamera camera;
    Stage stage;
    Cross cross;
    Array<Sprite> sprites = new Array<>();
    Array<Sprite> sprites2 = new Array<>();
    Array<Sprite> sprites3 = new Array<>();
    public static int time=0;
    public static char speed = 1;
    Waste giaiThichHuuCo;
    Waste giaiThichVoCo;
    Waste giaiThichTaiChe;
    Waste giaiThichNguyHai;
    WhiteButton luaChon1NhaRac;
    WhiteButton luaChon2NhaRac;
    WhiteButton luaChon3NhaRac;
    WhiteButton luaChon4NhaRac;
    WhiteButton luaChon5NhaRac;
    public static int sohuucodaphanloai=0;
    public static int sovocodaphanloai=0;
    public static int sotaichedaphanloai=0;
    public static int songuyhaidaphanloai=0;
    public static int sohuucodara=0;
    public static int sovocodara=0;
    public static int sotaichedara=0;
    public static int songuyhaidara=0;
    boolean isXong=false;
    Texture background = new Texture("nha may phan loai rac.png");
    Texture chieccamera = new Texture("cameraintrashhouse.png");
    Sprite cam1 = new Sprite(chieccamera);
    Sprite cam2 = new Sprite(chieccamera);
    Sprite cam3 = new Sprite(chieccamera);
    Sprite cam4 = new Sprite(chieccamera);
    ConTrolSpeed conTrolSpeed;
    ThanhControl thanhControl;
    GlyphLayout layout = new GlyphLayout();
    Array<Waste> wastes = new Array<>();
    public TrashScreen(StartGame game){
        this.game = game;
        stage = new Stage();

        camera = new OrthographicCamera();

        cross = new Cross(Gdx.graphics.getWidth()-32,Gdx.graphics.getHeight()-32,stage);
        cross.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(game.master);
            }
        });
        layout.width = 20;
        layout.height = 20;
        thanhControl = new ThanhControl(25,Gdx.graphics.getHeight()-64+10,stage);
        conTrolSpeed = new ConTrolSpeed(52,Gdx.graphics.getHeight()-64,stage);

        giaiThichHuuCo = new Waste(32*14,Gdx.graphics.getHeight()/2f+32*4+10,stage,'o');
        giaiThichHuuCo.setSize(64,64);
        Master.wastes.removeValue(giaiThichHuuCo,true);
        giaiThichVoCo = new Waste(32*27,Gdx.graphics.getHeight()/2f+10,stage,'i');
        giaiThichVoCo.setSize(64,64);
        Master.wastes.removeValue(giaiThichVoCo,true);
        giaiThichTaiChe = new Waste(32*14,Gdx.graphics.getHeight()/2f-32*4+10,stage,'r');
        giaiThichTaiChe.setSize(64,64);
        Master.wastes.removeValue(giaiThichTaiChe,true);
        giaiThichNguyHai = new Waste(32*27,Gdx.graphics.getHeight()/2f-32*8+10,stage,'h');
        giaiThichNguyHai.setSize(64,64);
        Master.wastes.removeValue(giaiThichNguyHai,true);

        luaChon1NhaRac = new WhiteButton(32,Gdx.graphics.getHeight()-32*4,stage);
        luaChon1NhaRac.setSize(32*11,32*2);
        luaChon2NhaRac = new WhiteButton(32,Gdx.graphics.getHeight()-32*6,stage);
        luaChon2NhaRac.setSize(32*11,32*2);
        luaChon3NhaRac = new WhiteButton(32,Gdx.graphics.getHeight()-32*8,stage);
        luaChon3NhaRac.setSize(32*11,32*2);
        luaChon4NhaRac = new WhiteButton(32,Gdx.graphics.getHeight()-32*10,stage);
        luaChon4NhaRac.setSize(32*11,32*2);
        luaChon5NhaRac = new WhiteButton(32,Gdx.graphics.getHeight()-32*12,stage);
        luaChon5NhaRac.setSize(32*11,32*2);

        giaiThichHuuCo.toFront();
        giaiThichVoCo.toFront();
        giaiThichTaiChe.toFront();
        giaiThichNguyHai.toFront();
        luaChon1NhaRac.toFront();
        luaChon2NhaRac.toFront();
        luaChon3NhaRac.toFront();
        luaChon4NhaRac.toFront();
        luaChon5NhaRac.toFront();

        luaChon1NhaRac.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(sohuucodaphanloai>=10){
                    GameState.greenscore+=10;
                    GameState.soRacHuuCo-=10;
                    sohuucodaphanloai-=10;
                    sohuucodara-=10;
                }else {
                    new FloatingNews(luaChon1NhaRac.getX(),luaChon1NhaRac.getY(),stage,"Bạn không đủ đồ",Color.RED,TypeEffect.FLOATUP);
                }
            }
        });
        luaChon2NhaRac.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(songuyhaidaphanloai>=2){
                    GameState.ernegy+=2500;
                    GameState.soRacNguyHai-=2;
                    songuyhaidaphanloai-=2;
                    songuyhaidara-=2;

                }else {
                    new FloatingNews(luaChon2NhaRac.getX(),luaChon2NhaRac.getY(),stage,"Bạn không đủ đồ",Color.RED,TypeEffect.FLOATUP);
                }
            }
        });
        luaChon3NhaRac.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(songuyhaidaphanloai>=2 && sotaichedaphanloai>=1){
                    GameState.soRacNguyHai-=2;
                    songuyhaidaphanloai-=2;
                    songuyhaidara-=2;
                    GameState.soRacTaiChe-=1;
                    sotaichedaphanloai--;
                    sotaichedara--;
                    GameState.levelcongnghexanh+=3;
                }else {
                    new FloatingNews(luaChon3NhaRac.getX(),luaChon3NhaRac.getY(),stage,"Bạn không đủ đồ",Color.RED,TypeEffect.FLOATUP);
                }
            }
        });
        luaChon4NhaRac.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(sotaichedaphanloai>=10){
                    GameState.soRacTaiChe-=10;
                    sotaichedaphanloai-=10;
                    sotaichedara-=10;
                    GameState.money+=2500;
                }else {
                    new FloatingNews(luaChon4NhaRac.getX(),luaChon4NhaRac.getY(),stage,"Bạn không đủ đồ",Color.RED,TypeEffect.FLOATUP);
                }
            }
        });
        luaChon5NhaRac.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(sotaichedaphanloai>=12 && sovocodaphanloai>=20){
                    GameState.soRacTaiChe-=12;
                    sotaichedaphanloai-=12;
                    sotaichedara-=12;
                    GameState.soRacVoCo-=20;
                    sovocodaphanloai-=20;
                    sovocodara-=20;
                    GameState.soMLtoidacothemua++;
                }else {
                    new FloatingNews(luaChon5NhaRac.getX(),luaChon5NhaRac.getY(),stage,"Bạn không đủ đồ",Color.RED,TypeEffect.FLOATUP);
                }
            }
        });
        cam1.setSize(32,32);
        cam1.setRotation(0);
        cam1.setPosition(Gdx.graphics.getWidth()/2f-cam1.getWidth()/2f+200-10,Gdx.graphics.getHeight()-32*4+40+10);
        cam2.setSize(32,32);
        cam2.setRotation(0);
        cam2.setPosition(Gdx.graphics.getWidth()/2f-cam2.getWidth()/2f+200+32+40+10,Gdx.graphics.getHeight()-32*8+40+10);
        cam3.setSize(32,32);
        cam3.setRotation(0);
        cam3.setPosition(Gdx.graphics.getWidth()/2f-cam1.getWidth()/2f+200-10,Gdx.graphics.getHeight()-32*12+40+10);
        cam4.setSize(32,32);
        cam4.setRotation(0);
        cam4.setPosition(Gdx.graphics.getWidth()/2f-cam2.getWidth()/2f+200+32+40+10,Gdx.graphics.getHeight()-32*16+40+10);
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        isXong=false;
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.WHITE);
        camera.update();

        time++;
        stage.act();
        if(time%(20/speed)==0){
            Sprite khuc = new Sprite(new Texture("bangchuyen.png"));
            khuc.setRotation(90);
            khuc.setSize(20,40);
            khuc.setPosition(Gdx.graphics.getWidth()/2f+220,Gdx.graphics.getHeight());
            sprites.add(khuc);
            if(time>(20/speed)*7){
                Sprite khuc2 = new Sprite(new Texture("bangchuyen.png"));
                khuc2.setRotation(180);
                khuc2.setSize(20,40);
                khuc2.setPosition(Gdx.graphics.getWidth()/2f+200+20,Gdx.graphics.getHeight()-32*4);
                sprites2.add(khuc2);
            }
            if(time>(20/speed)*13){
                Sprite khuc3 = new Sprite(new Texture("bangchuyen.png"));
                khuc3.setRotation(180);
                khuc3.setSize(20,40);
                khuc3.setPosition(Gdx.graphics.getWidth()/2f+200+20,Gdx.graphics.getHeight()-32*8);
                sprites3.add(khuc3);
            }
            if(time>(20/speed)*20){
                Sprite khuc4 = new Sprite(new Texture("bangchuyen.png"));
                khuc4.setRotation(180);
                khuc4.setSize(20,40);
                khuc4.setPosition(Gdx.graphics.getWidth()/2f+200+20,Gdx.graphics.getHeight()-32*12);
                sprites2.add(khuc4);
            }
            if(time>(20/speed)*26){
                Sprite khuc5 = new Sprite(new Texture("bangchuyen.png"));
                khuc5.setRotation(180);
                khuc5.setSize(20,40);
                khuc5.setPosition(Gdx.graphics.getWidth()/2f+200+20,Gdx.graphics.getHeight()-32*16);
                sprites3.add(khuc5);
            }

        }
        if(GameState.soRacHuuCo==sohuucodaphanloai
            &&GameState.soRacVoCo==sovocodaphanloai
            &&GameState.soRacTaiChe==sotaichedaphanloai
            &&GameState.soRacNguyHai==songuyhaidaphanloai){
            isXong = true;
        }
        if(time%(60/speed)==0&&!isXong){
            boolean  dacorac = false;
            while (!dacorac){
                int ran = MathUtils.random.nextInt(1,5);
                if(ran == 1){
                    if(GameState.soRacHuuCo-sohuucodara>0){
                        Waste a = new Waste(Gdx.graphics.getWidth()/2f+215,Gdx.graphics.getHeight(),stage,'o');
                        Master.wastes.removeValue(a,true);
                        wastes.add(a);
                        sohuucodara++;
                        dacorac=true;
                    }
                }
                if(ran == 2){
                    if(GameState.soRacVoCo-sovocodara>0){
                        Waste a = new Waste(Gdx.graphics.getWidth()/2f+215,Gdx.graphics.getHeight(),stage,'i');
                        Master.wastes.removeValue(a,true);
                        wastes.add(a);
                        sovocodara++;
                        dacorac=true;
                    }
                }
                if(ran == 3){
                    if(GameState.soRacTaiChe-sotaichedara>0){
                        Waste a = new Waste(Gdx.graphics.getWidth()/2f+215,Gdx.graphics.getHeight(),stage,'r');
                        Master.wastes.removeValue(a,true);
                        wastes.add(a);
                        sotaichedara++;
                        dacorac=true;
                    }
                }
                if(ran == 4){
                    if(GameState.soRacNguyHai-songuyhaidara>0){
                        Waste a = new Waste(Gdx.graphics.getWidth()/2f+215,Gdx.graphics.getHeight(),stage,'h');
                        Master.wastes.removeValue(a,true);
                        wastes.add(a);
                        songuyhaidara++;
                        dacorac=true;
                    }
                }
                if(GameState.soRacHuuCo==sohuucodara
                    &&GameState.soRacVoCo==sovocodara
                    &&GameState.soRacTaiChe==sotaichedara
                    &&GameState.soRacNguyHai==songuyhaidara){
                    break;
                }
            }
        }
        for(Sprite a : sprites2){
            a.translateX(-speed);
            if(a.getX()<Gdx.graphics.getWidth()/2f){
                sprites2.removeValue(a,true);
            }
        }
        for(Sprite a : sprites3){
            a.translateX(speed);
            if(a.getX()>Gdx.graphics.getWidth()/2f+400){
                sprites3.removeValue(a,true);
            }
        }
        for(Sprite a : sprites){
            a.translateY(-speed);
            if(a.getY()<-40){
                sprites.removeValue(a,true);
            }
        }
        for(Waste a : wastes){
            if(a.getCostume()=='o'){
                if (Gdx.graphics.getHeight()-32*4+speed+1>a.getY()&&a.getY()>Gdx.graphics.getHeight()-32*4) {
                    a.moveBy(-speed,0);
                    if(a.getX()<Gdx.graphics.getWidth()/2f){
                        sohuucodaphanloai++;
                        wastes.removeValue(a,true);
                        a.remove();
                    }
                }else {
                    a.moveBy(0,-speed);
                }
            }
            if(a.getCostume()=='i'){
                if (Gdx.graphics.getHeight()-32*8+speed+1>a.getY()&&a.getY()>Gdx.graphics.getHeight()-32*8) {
                    a.moveBy(speed,0);
                    if(a.getX()>Gdx.graphics.getWidth()/2f+400){
                        sovocodaphanloai++;
                        wastes.removeValue(a,true);
                        a.remove();
                    }
                }else {
                    a.moveBy(0,-speed);
                }
            }
            if(a.getCostume()=='r'){
                if (Gdx.graphics.getHeight()-32*12+speed+1>a.getY()&&a.getY()>Gdx.graphics.getHeight()-32*12) {
                    a.moveBy(-speed,0);
                    if(a.getX()<Gdx.graphics.getWidth()/2f){
                        sotaichedaphanloai++;
                        wastes.removeValue(a,true);
                        a.remove();
                    }
                }else {
                    a.moveBy(0,-speed);
                }
            }
            if(a.getCostume()=='h'){
                if (Gdx.graphics.getHeight()-32*16+speed+1>a.getY()&&a.getY()>Gdx.graphics.getHeight()-32*16) {
                    a.moveBy(speed,0);
                    if(a.getX()>Gdx.graphics.getWidth()/2f+400){
                        songuyhaidaphanloai++;
                        wastes.removeValue(a,true);
                        a.remove();
                    }
                }else {
                    a.moveBy(0,-speed);
                }
            }
        }
        Master.batch.begin();
        Master.batch.draw(background, 0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        for(Sprite a : sprites2){
            a.draw(Master.batch);
        }
        for(Sprite a : sprites3){
            a.draw(Master.batch);
        }
        for(Sprite a : sprites){
            a.draw(Master.batch);
        }
        if(time>(20/speed)*10){
            cam1.draw(Master.batch);
        }
        if(time>(20/speed)*16){
            cam2.draw(Master.batch);
        }
        if(time>(20/speed)*23){
            cam3.draw(Master.batch);
        }
        if(time>(20/speed)*29){
            cam4.draw(Master.batch);
        }
        Master.batch.end();

        stage.draw();
        Master.batch.begin();
        game.font3.draw(Master.batch, "" + sohuucodaphanloai,giaiThichHuuCo.getX()+giaiThichHuuCo.getWidth()
            , giaiThichHuuCo.getY()+giaiThichHuuCo.getHeight());
        game.font3.draw(Master.batch, "" + sovocodaphanloai,giaiThichVoCo.getX()+giaiThichVoCo.getWidth()
            , giaiThichVoCo.getY()+giaiThichVoCo.getHeight());
        game.font3.draw(Master.batch, "" + sotaichedaphanloai,giaiThichTaiChe.getX()+giaiThichTaiChe.getWidth()
            , giaiThichTaiChe.getY()+giaiThichTaiChe.getHeight());
        game.font3.draw(Master.batch, "" + songuyhaidaphanloai,giaiThichNguyHai.getX()+giaiThichNguyHai.getWidth()
            , giaiThichNguyHai.getY()+giaiThichNguyHai.getHeight());
        layout.setText(game.font7,"Đổi 10 túi rác hữu cơ lấy 10 điểm xanh");
        game.font7.draw(Master.batch, layout
            ,32+(32*10/2f)- layout.width/2f+16,luaChon1NhaRac.getY()+15+32-7.5f);
        layout.setText(game.font7,"Đổi 2 túi rác nguy hại lấy 2500 năng lượng");
        game.font7.draw(Master.batch, layout
            ,32+(32*10/2f)- layout.width/2f+16,luaChon2NhaRac.getY()+15+32-7.5f);
        layout.setText(game.font7,"Đổi 2 túi rác nguy hại và 1 túi rác tái chế");
        game.font7.draw(Master.batch, layout
            ,32+(32*10/2f)- layout.width/2f+16,luaChon3NhaRac.getY()+15+35);
        layout.setText(game.font7,"lấy 3 level CNX");
        game.font7.draw(Master.batch, layout
            ,32+(32*10/2f)- layout.width/2f+16,luaChon3NhaRac.getY()+35-4);
        layout.setText(game.font7,"Đổi 10 túi rác tái chế lấy 2500$");
        game.font7.draw(Master.batch, layout
            ,32+(32*10/2f)- layout.width/2f+16,luaChon4NhaRac.getY()+35);
        layout.setText(game.font7,"Đổi 12 túi rác tái chế và 20 túi rác vô cơ");
        game.font7.draw(Master.batch, layout
            ,32+(32*10/2f)- layout.width/2f+16,luaChon5NhaRac.getY()+15+35);
        layout.setText(game.font7,"để mở khóa thêm 1 chiếc máy lọc");
        game.font7.draw(Master.batch, layout
            ,32+(32*10/2f)- layout.width/2f+16,luaChon5NhaRac.getY()+35-4);
        Master.batch.end();
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

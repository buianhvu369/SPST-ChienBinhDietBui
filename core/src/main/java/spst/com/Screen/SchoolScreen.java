package spst.com.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.async.ThreadUtils;
import spst.com.*;
import spst.com.Button.*;
import spst.com.Button.InItemsButton.CamChoi;
import spst.com.Button.InItemsButton.CamRiu;
import spst.com.Button.InItemsButton.CamXeng;
import spst.com.Button.InItemsButton.OpenItems;
import spst.com.Button.InVehicleButton.LayPolice;
import spst.com.Button.InVehicleButton.LayTaxi;
import spst.com.Button.InVehicleButton.LayTrashTruck;
import spst.com.Button.InVehicleButton.OpenVehicles;
import spst.com.InFactory.*;
import spst.com.InFactory.Items.Ax;
import spst.com.InFactory.Items.Broom;
import spst.com.InFactory.Items.Shovel;
import spst.com.InFactory.Vehicles.Police;
import spst.com.InFactory.Vehicles.Taxi;
import spst.com.InFactory.Vehicles.TrashTruck;

public class SchoolScreen implements Screen {
    StartGame game;
    Class7 class7;
    Class6 class6;
    Stage stage;
    OrthographicCamera camera;
    boolean grade6 = false;
    boolean start = false;
    GlyphLayout layout;
    GlyphLayout layout2;
    GlyphLayout layout3;
    GlyphLayout layout4;
    GlyphLayout layout5;
    WhiteButton question;
    WhiteButton choice1;
    WhiteButton choice2;
    WhiteButton choice3;
    WhiteButton choice4;
    Cross cross;
    int thuTuCauHoi = 0;
    char cauTraLoiDung = '1';
    int time = 0;
    boolean isTouch = false;
    public SchoolScreen(StartGame game) {
        this.game = game;
        stage = new Stage();
        class6 = new Class6(300 , 300 , stage) ;
        class7 = new Class7(300 , 100 , stage) ;
        choice1 = new WhiteButton(30000 , 300 , stage);
        choice2 = new WhiteButton(30000 , 300 , stage);
        choice3 = new WhiteButton(30000 , 300 , stage);
        choice4 = new WhiteButton(30000 , 300 , stage);
        question = new WhiteButton(30000 , 300 , stage);
        question.setSize(800 ,75);
        choice1.setSize(600 , 75);
        choice2.setSize(600 , 75);
        choice3.setSize(600 , 75);
        choice4.setSize(600 , 75);

        camera = new OrthographicCamera();
        layout = new GlyphLayout();
        layout2 = new GlyphLayout();
        layout3 = new GlyphLayout();
        layout4 = new GlyphLayout();
        layout5 = new GlyphLayout();
        cross = new Cross(Gdx.graphics.getWidth()-32,Gdx.graphics.getHeight()-32 ,stage);
        layout.width = 20;
        layout.height = 20;
        layout2.width = 20;
        layout2.height = 20;
        layout3.width = 20;
        layout3.height = 20;
        layout4.width = 20;
        layout4.height = 20;
        layout5.width = 20;
        layout5.height = 20;
        thuTuCauHoi = MathUtils.random(1, 10);

        Gdx.input.setInputProcessor(stage);
        stage.addListener(new InputListener() {
            private Actor lastActor = null;

            @Override
            public boolean mouseMoved(InputEvent event, float x, float y) {

                Actor actor = stage.hit(x, y, true);

                if (lastActor != null && lastActor instanceof ButtonActor && lastActor != actor && !isTouch) {
                    lastActor.setColor(1, 1, 1, 1);
                }

                if (actor instanceof ButtonActor && !isTouch) {
                    actor.setColor(0, 1, 1, 1);
                }

                lastActor = actor;

                return super.mouseMoved(event, x, y);
            }
        });


    }


    @Override
    public void show() {
        class6.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                grade6 = true;
                class6.setPosition(100000 ,100000);
                class7.setPosition(10000 ,10000);
                question.setPosition(32*2, Gdx.graphics.getHeight()-32*4);
                choice1.setPosition(32*5, Gdx.graphics.getHeight()-32*7);
                choice2.setPosition(32*5, Gdx.graphics.getHeight()-32*10);
                choice3.setPosition(32*5, Gdx.graphics.getHeight()-32*13);
                choice4.setPosition(32*5, Gdx.graphics.getHeight()-32*16);
                start = false;
            }
        });
        class7.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                grade6 = false;
                start = false;
                class7.setPosition(10000 ,10000);
                class6.setPosition(100000 ,100000);
                question.setPosition(32*2, Gdx.graphics.getHeight()-32*4);
                choice1.setPosition(32*5, Gdx.graphics.getHeight()-32*7);
                choice2.setPosition(32*5, Gdx.graphics.getHeight()-32*10);
                choice3.setPosition(32*5, Gdx.graphics.getHeight()-32*13);
                choice4.setPosition(32*5, Gdx.graphics.getHeight()-32*16);

            }
        });
        choice1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(cauTraLoiDung == 'a' && !isTouch){
                    int ran = MathUtils.random(1, 6);
                    switch (ran) {
                        case 1 -> GameState.money+= 200;
                        case 2 -> GameState.ernegy+= 100;
                        case 3 -> GameState.greenscore+= 20;
                    }
                    choice1.setColor(Color.GREEN);
                }
                if(cauTraLoiDung == 'b'){
                    choice2.setColor(Color.GREEN);
                    choice1.setColor(Color.RED);
                }if(cauTraLoiDung == 'c'){
                    choice3.setColor(Color.GREEN);
                    choice1.setColor(Color.RED);
                }if(cauTraLoiDung == 'd'){
                    choice4.setColor(Color.GREEN);
                    choice1.setColor(Color.RED);
                }
                isTouch =true;
            }
        });
        choice2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(cauTraLoiDung == 'b'&& !isTouch){
                    int ran = MathUtils.random(1, 6);
                    switch (ran) {
                        case 1 -> GameState.money+= 200;
                        case 2 -> GameState.ernegy+= 100;
                        case 3 -> GameState.greenscore+= 20;
                    }
                    choice2.setColor(Color.GREEN);
                }
                if(cauTraLoiDung == 'a'){
                    choice1.setColor(Color.GREEN);
                    choice2.setColor(Color.RED);
                }if(cauTraLoiDung == 'c'){
                    choice3.setColor(Color.GREEN);
                    choice2.setColor(Color.RED);
                }if(cauTraLoiDung == 'd'){
                    choice4.setColor(Color.GREEN);
                    choice2.setColor(Color.RED);
                }
                isTouch =true;

            }

        });
        choice3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(cauTraLoiDung == 'c'&& !isTouch){
                    int ran = MathUtils.random(1, 6);
                    switch (ran) {
                        case 1 -> GameState.money+= 200;
                        case 2 -> GameState.ernegy+= 100;
                        case 3 -> GameState.greenscore+= 20;
                    }
                    choice3.setColor(Color.GREEN);
                }
                if(cauTraLoiDung == 'b'){
                    choice2.setColor(Color.GREEN);
                    choice3.setColor(Color.RED);
                }if(cauTraLoiDung == 'a'){
                    choice1.setColor(Color.GREEN);
                    choice3.setColor(Color.RED);
                }if(cauTraLoiDung == 'd'){
                    choice4.setColor(Color.GREEN);
                    choice3.setColor(Color.RED);
                }
                isTouch =true;
            }
        });
        choice4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(cauTraLoiDung == 'd'&& !isTouch){
                    int ran = MathUtils.random(1, 6);
                    switch (ran) {
                        case 1 -> GameState.money+= 200;
                        case 2 -> GameState.ernegy+= 100;
                        case 3 -> GameState.greenscore+= 20;
                    }
                    choice4.setColor(Color.GREEN);
                }
                if(cauTraLoiDung == 'b'){
                    choice2.setColor(Color.GREEN);
                    choice4.setColor(Color.RED);
                }if(cauTraLoiDung == 'c'){
                    choice3.setColor(Color.GREEN);
                    choice4.setColor(Color.RED);
                }if(cauTraLoiDung == 'a'){
                    choice1.setColor(Color.GREEN);
                    choice4.setColor(Color.RED);
                }
                isTouch =true;
            }
        });
        cross.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(game.master);
            }
        });

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.WHITE);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        if(isTouch){
            time++;
        }if(time == 180){
            time = 0;
            thuTuCauHoi = MathUtils.random(1, 10);
            isTouch =false;
            choice1.setColor(1,1,1,1);
            choice2.setColor(1,1,1,1);
            choice3.setColor(1,1,1,1);
            choice4.setColor(1,1,1,1);
        }
        if(grade6) {
            switch (thuTuCauHoi) {
                case 1 -> {
                    layout.setText(game.font3, "Môi trường bao gồm những thành phần chính nào?");
                    layout2.setText(game.font3, "Không khí, đất, nước, sinh vật");
                    layout3.setText(game.font3, "Chỉ đất và nước");
                    layout4.setText(game.font3, "Chỉ không khí và ánh sáng");
                    layout5.setText(game.font3, "Chỉ sinh vật và con người");
                    cauTraLoiDung = 'a';
                }
                case 2 -> {
                    layout.setText(game.font3, "Không khí chứa thành phần chính nào?");
                    layout2.setText(game.font3, "O2, N2, CO2");
                    layout3.setText(game.font3, "O2, H2, He");
                    layout4.setText(game.font3, "N2, CO2, Ar");
                    layout5.setText(game.font3, "N2, O2, Ar");
                    cauTraLoiDung = 'd';
                }
                case 3 -> {
                    layout.setText(game.font3, "Vai trò của cây xanh trong môi trường là?");
                    layout2.setText(game.font3, "Cung cấp oxy, giữ đất, làm mát không khí");
                    layout3.setText(game.font3, "Gây ô nhiễm");
                    layout4.setText(game.font3, "Tạo khí độc");
                    layout5.setText(game.font3, "Hút oxy");
                    cauTraLoiDung = 'a';
                }
                case 4 -> {
                    layout.setText(game.font3, "Nguyên nhân chính gây ô nhiễm không khí là?");
                    layout2.setText(game.font3, "Sự cháy rừng tự nhiên");
                    layout3.setText(game.font3, "Hoạt động công nghiệp và giao thông");
                    layout4.setText(game.font3, "Mưa nhiều");
                    layout5.setText(game.font3, "Gió thổi mạnh");
                    cauTraLoiDung = 'b';
                }
                case 5 -> {
                    layout.setText(game.font3, "Tác hại của ô nhiễm nguồn nước là?");
                    layout2.setText(game.font3, "Gây bệnh cho người và động vật");
                    layout3.setText(game.font3, "Làm sạch nước");
                    layout4.setText(game.font3, "Tăng sản lượng thủy sản");
                    layout5.setText(game.font3, "Không ảnh hưởng");
                    cauTraLoiDung = 'a';
                }
                case 6 -> {
                    layout.setText(game.font3, "Tầng ozone có vai trò gì?");
                    layout2.setText(game.font3, "Cản bức xạ tử ngoại từ mặt trời");
                    layout3.setText(game.font3, "Cung cấp oxy cho con người");
                    layout4.setText(game.font3, "Làm ấm Trái Đất");
                    layout5.setText(game.font3, "Gây hiệu ứng nhà kính");
                    cauTraLoiDung = 'a';
                }
                case 7 -> {
                    layout.setText(game.font3, "Hiệu ứng nhà kính là gì?");
                    layout2.setText(game.font3, "Hiện tượng giữ nhiệt của Trái Đất do khí nhà kính");
                    layout3.setText(game.font3, "Sự nóng lên của nhà kính thực tế");
                    layout4.setText(game.font3, "Mưa axit");
                    layout5.setText(game.font3, "Sự giảm nhiệt của Trái Đất");
                    cauTraLoiDung = 'a';
                }
                case 8 -> {
                    layout.setText(game.font3, "Nguyên nhân gây hiệu ứng nhà kính chủ yếu là??");
                    layout2.setText(game.font3, "Tăng khí CO2 và CH4 do hoạt động con người");
                    layout3.setText(game.font3, "Giảm lượng cây xanh");
                    layout4.setText(game.font3, "Mưa nhiều");
                    layout5.setText(game.font3, "Thay đổi quỹ đạo Trái Đất");
                    cauTraLoiDung = 'a';
                }
                case 9 -> {
                    layout.setText(game.font3, "Biện pháp giảm ô nhiễm không khí là?");
                    layout2.setText(game.font3, "Tăng xe cá nhân");
                    layout3.setText(game.font3, "Sử dụng năng lượng sạch và phương tiện công cộng");
                    layout4.setText(game.font3, "Đốt rác bừa bãi");
                    layout5.setText(game.font3, "Đổ chất thải ra sông hồ");
                    cauTraLoiDung = 'b';
                }
                case 10 -> {
                    layout.setText(game.font3, "Rác thải nhựa khó phân hủy vì?");
                    layout2.setText(game.font3, "Có cấu trúc phân tử bền vững");
                    layout3.setText(game.font3, "Dễ bị vi khuẩn phân hủy");
                    layout4.setText(game.font3, "Làm từ nguyên liệu tự nhiên");
                    layout5.setText(game.font3, "Không ảnh hưởng");
                    cauTraLoiDung = 'a';
                }
            }
        }else{
            switch (thuTuCauHoi){
                case 1 -> {
                    layout.setText(game.font3, "Môi trường bao gồm những thành phần chính nào?");
                    layout2.setText(game.font3, "Không khí, đất, nước, sinh vật");
                    layout3.setText(game.font3, "Chỉ đất và nước");
                    layout4.setText(game.font3, "Chỉ không khí và ánh sáng");
                    layout5.setText(game.font3, "Chỉ sinh vật và con người");
                    cauTraLoiDung = 'a';
                }
                case 2 -> {
                    layout.setText(game.font3, "Khí gây hiệu ứng nhà kính mạnh nhất là?");
                    layout2.setText(game.font3, "O2");
                    layout3.setText(game.font3, "CO2");
                    layout4.setText(game.font3, "CH4");
                    layout5.setText(game.font3, "N2");
                    cauTraLoiDung = 'c';
                }
                case 3 -> {
                    layout.setText(game.font3, "Mưa axit chủ yếu do khí nào gây ra?");
                    layout2.setText(game.font3, "CO2");
                    layout3.setText(game.font3, "SO2 và NOx");
                    layout4.setText(game.font3, "O2");
                    layout5.setText(game.font3, "H2");
                    cauTraLoiDung = 'b';
                }
                case 4 -> {
                    layout.setText(game.font3, "Tầng ozon bảo vệ Trái Đất khỏi tác hại của?");
                    layout2.setText(game.font3, "Tia tử ngoại (UV)");
                    layout3.setText(game.font3, "Khí CO2");
                    layout4.setText(game.font3, "Bức xạ hồng ngoại");
                    layout5.setText(game.font3, "Tia X");
                    cauTraLoiDung = 'a';
                }
                case 5 -> {
                    layout.setText(game.font3, "Hiện tượng biến đổi khí hậu làm tăng mực nước biển là do?");
                    layout2.setText(game.font3, "Hạn hán kéo dài");
                    layout3.setText(game.font3, "Băng ở hai cực tan chảy");
                    layout4.setText(game.font3, "Mưa nhiều hơn");
                    layout5.setText(game.font3, "Sóng biển yếu");
                    cauTraLoiDung = 'b';
                }
                case 6 -> {
                    layout.setText(game.font3, "Tác hại của ô nhiễm nguồn nước là gì?");
                    layout2.setText(game.font3, "Gây bệnh cho sinh vật và con người");
                    layout3.setText(game.font3, "Tăng năng suất thủy sản");
                    layout4.setText(game.font3, "Giúp làm sạch môi trường");
                    layout5.setText(game.font3, "Tăng độ phì nhiêu đất");
                    cauTraLoiDung = 'a';
                }
                case 7 -> {
                    layout.setText(game.font3, "Nguyên nhân chính của hiệu ứng nhà kính là?");
                    layout2.setText(game.font3, "Tăng lượng cây xanh");
                    layout3.setText(game.font3, "Khí thải CO2 và CH4 từ hoạt động con người");
                    layout4.setText(game.font3, "Mưa nhiều hơn");
                    layout5.setText(game.font3, "Sự thay đổi quỹ đạo Trái Đất");
                    cauTraLoiDung = 'b';
                }
                case 8 -> {
                    layout.setText(game.font3, "Phương pháp xử lý rác thải tốt nhất là?");
                    layout2.setText(game.font3, "Đổ thẳng ra môi trường");
                    layout3.setText(game.font3, "Tái chế và phân loại");
                    layout4.setText(game.font3, "Đốt rác không kiểm soát");
                    layout5.setText(game.font3, "Chôn lấp hết");
                    cauTraLoiDung = 'b';
                }
                case 9 -> {
                    layout.setText(game.font3, "Nguyên nhân chính gây suy thoái đất là?");
                    layout2.setText(game.font3, "Khai thác quá mức và phá rừng bừa bãi");
                    layout3.setText(game.font3, "Trồng cây xanh thường xuyên");
                    layout4.setText(game.font3, "Tưới nước hợp lý");
                    layout5.setText(game.font3, "Dùng phân bón hữu cơ");
                    cauTraLoiDung = 'a';
                }
                case 10 -> {
                    layout.setText(game.font3, "Mưa axit ảnh hưởng đến?");
                    layout2.setText(game.font3, "Chỉ cây trồng");
                    layout3.setText(game.font3, "Cây trồng, thủy sinh và đất đai");
                    layout4.setText(game.font3, "Chỉ động vật trên cạn");
                    layout5.setText(game.font3, "Không ảnh hưởng");
                    cauTraLoiDung = 'b';
                }
            }
        }
        question.setColor(1,1,1,1);

        Master.batch.begin();
        stage.draw();
        stage.act();
        if(start) {
            game.font3.draw(Master.batch, "Bạn học lớp nào :", 350, Gdx.graphics.getHeight() - 40);
        }else{
            game.font3.draw(Master.batch, layout, question.getWidth()/2 - layout.width/2 + question.getX(), question.getY()+ 47);
            game.font3.draw(Master.batch, layout2, choice1.getWidth()/2 - layout2.width/2 + choice1.getX(), choice1.getY()+ 47);
            game.font3.draw(Master.batch, layout3, choice2.getWidth()/2 - layout3.width/2 + choice2.getX(), choice2.getY()+ 47);
            game.font3.draw(Master.batch, layout4, choice3.getWidth()/2 - layout4.width/2 + choice3.getX(), choice3.getY()+ 47);
            game.font3.draw(Master.batch, layout5, choice4.getWidth()/2 - layout5.width/2 + choice4.getX(), choice4.getY()+ 47);

        }


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

package spst.com.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
    BangLop banglop;
    int thuTuCauHoi = 0;
    char cauTraLoiDung = '1';
    int time = 0;
    boolean isTouch = false;
    public SchoolScreen(StartGame game) {
        this.game = game;
        stage = new Stage();
        banglop = new BangLop(0 , 0, stage);

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
        thuTuCauHoi = 1;

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
        Master.batch.begin();
        Master.batch.end();
        if(isTouch){
            time++;
        }if(time == 180){
            time = 0;
            thuTuCauHoi += 1;
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
                case 11 -> {
                    layout.setText(game.font3, "Tảo phát triển mạnh trong nước thải có thể là do:");
                    layout2.setText(game.font3, " Thiếu ánh sáng");
                    layout3.setText(game.font3, "Nhiệt độ quá thấp");
                    layout4.setText(game.font3, "Ô nhiễm chất dinh dưỡng");
                    layout5.setText(game.font3, "Không có vi khuẩn");
                    cauTraLoiDung = 'c';
                }
                case 12 -> {
                    layout.setText(game.font3, "Khí SO₂ gây ra hiện tượng gì?");
                    layout2.setText(game.font3, "Mưa acid");
                    layout3.setText(game.font3, "Nổ lốp xe");
                    layout4.setText(game.font3, " Tăng nấc độ âm thanh");
                    layout5.setText(game.font3, "Ô nhiễm đất");
                    cauTraLoiDung = 'a';
                }
                case 13 -> {
                    layout.setText(game.font3, "Biện pháp giảm ô nhiễm không khí là:");
                    layout2.setText(game.font3, "Dùng năng lượng hóa thạch nhiều hơn");
                    layout3.setText(game.font3, "Lái xe máy với số thấp nhất");
                    layout4.setText(game.font3, "Trồng cây xanh đô thị");
                    layout5.setText(game.font3, "Đốt rác ngoài trời");
                    cauTraLoiDung = 'c';
                }
                case 14 -> {
                    layout.setText(game.font3, "Tái chế là gì?");
                    layout2.setText(game.font3, "Sử dụng lại tài nguyên sau khi xử lý");
                    layout3.setText(game.font3, "Vứt bỏ rác ra môi trường");
                    layout4.setText(game.font3, "Đốt chất thải để giảm thể tích");
                    layout5.setText(game.font3, "Đào kim loại dưới lòng đất");
                    cauTraLoiDung = 'a';
                } case 15 -> {
                    layout.setText(game.font3, "Ô nhiễm nguồn nước có thể gây ra bệnh:");
                    layout2.setText(game.font3, "Cúm");
                    layout3.setText(game.font3, "Tiêu chảy");
                    layout4.setText(game.font3, "Viêm họng");
                    layout5.setText(game.font3, "Bệnh tim mạch");
                    cauTraLoiDung = 'b';
                } case 16 -> {
                    layout.setText(game.font3, "Trong không khí ô nhiễm, tỉ lệ khí CO₂ tăng từ 0,04% lên 0,4%. So với mức bình thường, CO₂ đã tăng:");
                    layout2.setText(game.font3, "1 lần");
                    layout3.setText(game.font3, "5 lần");
                    layout4.setText(game.font3, "10 lần");
                    layout5.setText(game.font3, "100 lần");
                    cauTraLoiDung = 'c';
                } case 17 -> {
                    layout.setText(game.font3, "Khi ánh sáng mặt trời mạnh, phản ứng tạo ozon mặt đất xảy ra nhiều hơn vì:");
                    layout2.setText(game.font3, "Ánh sáng phân hủy CO₂");
                    layout3.setText(game.font3, "Ánh sáng kích hoạt NO₂ tạo O");
                    layout4.setText(game.font3, "O₂ chuyển hóa thành O₃ trực tiếp");
                    layout5.setText(game.font3, "Bụi phản ứng với ánh sáng");
                    cauTraLoiDung = 'b';
                } case 18 -> {
                    layout.setText(game.font3, "Khi không khí bị nghịch nhiệt, lớp không khí lạnh nằm ở:");
                    layout2.setText(game.font3, "Trên cao, giữ khí nóng ở dưới");
                    layout3.setText(game.font3, "Dưới thấp, giữ khí nóng ở trên");
                    layout4.setText(game.font3, "Giữa 2 lớp mây");
                    layout5.setText(game.font3, "Giữa các lớp ozon");
                    cauTraLoiDung = 'b';
                } case 19 -> {
                    layout.setText(game.font3, "Phản ứng tạo ozon (O₃) ở tầng mặt đất là phản ứng:");
                    layout2.setText(game.font3, "Trung hòa");
                    layout3.setText(game.font3, "Phản ứng oxi hóa quang hóa");
                    layout4.setText(game.font3, "Phản ứng nhiệt phân");
                    layout5.setText(game.font3, "Phản ứng trao đổi ion");
                    cauTraLoiDung = 'b';
                } case 20 -> {
                    layout.setText(game.font3, "Hiện tượng nào sau đây là kết quả của ô nhiễm không khí và khí thải SO₂");
                    layout2.setText(game.font3, "Mưa axit");
                    layout3.setText(game.font3, "Sương muối");
                    layout4.setText(game.font3, "Cát bụi đỏ");
                    layout5.setText(game.font3, "Cực quang");
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
                case 11 -> {
                    layout.setText(game.font3, "Môi trường tự nhiên gồm những thành phần nào?");
                    layout2.setText(game.font3, " Khí quyển, thủy quyển, sinh quyển, địa quyển");
                    layout3.setText(game.font3, " Khí quyển, thủy quyển, sinh quyển, vũ trụ");
                    layout4.setText(game.font3, " Sinh quyển, địa quyển, điện quyển, vật quyển");
                    layout5.setText(game.font3, " Khí quyển, thủy quyển, quang quyển, địa quyểnn");
                    cauTraLoiDung = 'a';
                }
                case 12 -> {
                    layout.setText(game.font3, "Hiện tượng nào sau đây là biểu hiện của biến đổi khí hậu??");
                    layout2.setText(game.font3, "Mặt trời sáng xuyên qua mây");
                    layout3.setText(game.font3, "Mùa đông nắng nóng bất thường");
                    layout4.setText(game.font3, "Gió tây nam thổi đều đặn");
                    layout5.setText(game.font3, "Có ngày dài hơn ngày ngắn");
                    cauTraLoiDung = 'b';
                }
                case 13 -> {
                    layout.setText(game.font3, "Đâu là tác động gián tiếp của hiện tượng hiệu ứng nhà kính?");
                    layout2.setText(game.font3, "Tăng tia cực tím gây hại lên da người");
                    layout3.setText(game.font3, " Mực nước biển dâng gây ngập lụt vùng ven biển");
                    layout4.setText(game.font3, "Tăng tốc độ gió tại các vùng núi cao");
                    layout5.setText(game.font3, " Phát thải khí NO₂ từ xe cộ");
                    cauTraLoiDung = 'c';
                }
                case 14 -> {
                    layout.setText(game.font3, "Khí gây hiệu ứng nhà kính mạnh nhất trong tự nhiên là:");
                    layout2.setText(game.font3, " O₂");
                    layout3.setText(game.font3, "CO₂");
                    layout4.setText(game.font3, "CH₄");
                    layout5.setText(game.font3, "H₂O (hơi nước)");
                    cauTraLoiDung = 'd';
                } case 15 -> {
                    layout.setText(game.font3, "Hiện tượng phú dưỡng trong ao hồ chủ yếu do nguyên nhân nào sau đây?");
                    layout2.setText(game.font3, "Sự tăng lượng khí CO₂ trong không khí");
                    layout3.setText(game.font3, "Sự tích tụ chất thải rắn từ công nghiệp");
                    layout4.setText(game.font3, "Sự dư thừa chất dinh dưỡng (N và P) từ phân bón, nước thải");
                    layout5.setText(game.font3, "Sự thay đổi mực nước tự nhiên do băng tan");
                    cauTraLoiDung = 'b';
                } case 16 -> {
                    layout.setText(game.font3, "Để giảm NO₂ từ khí thải xe, người ta sử dụng chất xúc tác chứa:");
                    layout2.setText(game.font3, "Sự tăng lượng khí CO₂ trong không khí");
                    layout3.setText(game.font3, "Sự tích tụ chất thải rắn từ công nghiệp");
                    layout4.setText(game.font3, "Sự dư thừa chất dinh dưỡng (N và P) từ phân bón, nước thải");
                    layout5.setText(game.font3, "Sự thay đổi mực nước tự nhiên do băng tan");
                    cauTraLoiDung = 'b';
                } case 17 -> {
                    layout.setText(game.font3, "Trong các khí gồm CO, NO₂ và SO, nào có thể gây mưa axit khi phản ứng với nước?");
                    layout2.setText(game.font3, "CO");
                    layout3.setText(game.font3, "NO₂ và SO₂");
                    layout4.setText(game.font3, "CO và NO₂");
                    layout5.setText(game.font3, "Chỉ NO₂");
                    cauTraLoiDung = 'b';
                } case 18 -> {
                    layout.setText(game.font3, "Vì sao khí CO rất nguy hiểm dù không có mùi và không màu?");
                    layout2.setText(game.font3, "Nó làm máu đông");
                    layout3.setText(game.font3, "Nó làm giảm oxy máu bằng cách gắn vào hemoglobin");
                    layout4.setText(game.font3, "Nó phá hủy phổi");
                    layout5.setText(game.font3, "Nó gây đau đầu ngay khi hít");
                    cauTraLoiDung = 'b';
                } case 19 -> {
                    layout.setText(game.font3, "Chất nào sau đây không gây mưa axit dù có trong không khí ô nhiễm?");
                    layout2.setText(game.font3, "SO₂");
                    layout3.setText(game.font3, "NO₂");
                    layout4.setText(game.font3, "CO");
                    layout5.setText(game.font3, "NH₃");
                    cauTraLoiDung = 'c';
                } case 20 -> {
                    layout.setText(game.font3, "Ở những nơi có khí thải từ đốt rác, khí nào nguy hiểm nhưng khó phát hiện nhất?");
                    layout2.setText(game.font3, "SO₂");
                    layout3.setText(game.font3, "CO₂");
                    layout4.setText(game.font3, "Dioxin");
                    layout5.setText(game.font3, "H₂O");
                    cauTraLoiDung = 'c';
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

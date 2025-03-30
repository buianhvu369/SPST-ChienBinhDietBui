package spst.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import spst.com.Screen.Master;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Utils {
    // 27 x 18
    private static Texture texture = new Texture("tilemap.png");
    private static Texture texture2 = new Texture("nongthon.png");
    private static Texture texture3 = new Texture("buttons.png");
    public static Texture  texture4 = new Texture("loading.png");

    private static final String FILE_PATH = "gamedata.json"; // Đường dẫn file lưu dữ liệu

    public static TextureRegion getRegion(int x, int y, int width, int height) {
        return new TextureRegion(texture, x, y, width, height);
    }
    public static TextureRegion getRegion2(int x, int y, int width, int height) {
        return new TextureRegion(texture2, x, y, width, height);
    }
    public static TextureRegion getRegionGround(int x, int y, int width, int height) {
        return new TextureRegion(texture2, x, y, width, height);
    }
    public static TextureRegion getRegionButton(int x, int y, int width, int height) {
        return new TextureRegion(texture3, x, y, width, height);
    }
    public static TextureRegion getRegionLoading(int x, int y, int width, int height) {
        return new TextureRegion(texture4, x, y, width, height);
    }

    public static List<Double> calculateAQIList(Map<String, Double> observedData, Map<String, int[]> breakpointsData, int[] indexValues) {
        List<Double> aqiList = new ArrayList<>();
        for (Map.Entry<String, Double> entry : observedData.entrySet()) {
            double concentration = entry.getValue();
            int[] breakpoints = breakpointsData.get(entry.getKey());
            aqiList.add(calculateAQI(concentration, breakpoints, indexValues));
        }
        return aqiList;
    }

    private static Double calculateAQI(double concentration, int[] breakpoints, int[] indexValues) {
        for (int i = 0; i < breakpoints.length - 1; i++) {
            if (concentration >= breakpoints[i] && concentration <= breakpoints[i + 1]) {
                return ((indexValues[i + 1] - indexValues[i]) / (double) (breakpoints[i + 1] - breakpoints[i]))
                    * (concentration - breakpoints[i]) + indexValues[i];
            }
        }
        return null; // Ngoài phạm vi bảng
    }

    static Map<String, int[]> breakpointsData = Map.of(
        "PM2.5", new int[]{0, 25, 50, 80, 150, 250, 350, 500},
        "PM10", new int[]{0, 50, 150, 250, 350, 420, 500, 600},
        "NO2", new int[]{0, 100, 200, 700, 1200, 2340, 3090, 3840},
        "SO2", new int[]{0, 125, 350, 550, 800, 1600, 2100, 2620},
        "CO", new int[]{0, 10000, 30000, 45000, 60000, 90000, 120000, 150000},
        "O3", new int[]{0, 160, 200, 300, 400, 800, 1000, 1200}
    );

    static int[] indexValues = {0, 50, 100, 150, 200, 300, 400, 500};

    public static void updateAQI( double co1, double no2, double pm10, double pm25, double o3, double so2){
        try{
        Map<String, Double> observedData = Map.of(
            "PM2.5", pm25,
            "PM10", pm10,
            "NO2", no2,
            "SO2", so2,
            "CO", co1,
            "O3", o3
        );
        List<Double> aqiList = calculateAQIList(observedData, breakpointsData, indexValues);
       // if(aqiList != null && Collections.max(aqiList) != null) {
        System.out.println("gio thu  " + Master.timeOfDay);
        Master.AQI = Collections.max(aqiList).floatValue();
        GameState.AQIPM2_5 = aqiList.get(0).floatValue();
        GameState.AQIPM10 = aqiList.get(1).floatValue();
        GameState.AQINO2 = aqiList.get(2).floatValue();
        GameState.AQISO2 = aqiList.get(3).floatValue();
        GameState.AQICO1 = aqiList.get(4).floatValue();
        GameState.AQIO3 = aqiList.get(5).floatValue();

        System.out.println("Danh sách AQI: " + aqiList);
        System.out.printf("Chỉ số AQI tổng: %.2f%n", Master.AQI);
        }catch (Exception ignored){}

    }

    public static void saveGameData(GameStateTmp data) {
        Json json = new Json();
        String jsonData = json.toJson(data);

        FileHandle file = Gdx.files.local(FILE_PATH);
        file.writeString(jsonData, false);
    }

    public static void loadGameData() {
        FileHandle file = Gdx.files.local(FILE_PATH);
        if (!file.exists()) {
            // do nothing
        } else {
            Json json = new Json();
            GameStateTmp gameState =  json.fromJson(GameStateTmp.class, file.readString());
            System.out.println("Level: " + gameState.danso);
            System.out.println("Score: " + gameState.money);
            System.out.println("Items: " + gameState.trees);
        }
    }

}

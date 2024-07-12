package com.j4fun.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.j4fun.eNum.UrlTrello;
import com.j4fun.network.httpUtils;

public class TrelloApiExample {
    public static Map<String, Object> jsonToMap(String jsonString) {
     
        Map<String, Object> resultMap = new HashMap<>();
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = parser.parse(jsonString).getAsJsonArray();
        
        if (jsonArray.size() > 0) {
            JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
            Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
            for (Map.Entry<String, JsonElement> entry : entrySet) {
                String key = entry.getKey();
                JsonElement value = entry.getValue();
                resultMap.put(key, value);
            }
        }else {
            JsonElement jsonElement = parser.parse(jsonString);
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
                for (Map.Entry<String, JsonElement> entry : entrySet) {
                    String key = entry.getKey();
                    JsonElement value = entry.getValue();
                    resultMap.put(key, value);
                }
            }
        }
        

        return resultMap;
    }

    // Method để gọi API Trello và lấy danh sách các bảng
    public static String getBoardList(String apiKey, String token) {
        try {
            // Tạo URL endpoint API của Trello
            URL url = new URL("https://api.trello.com/1/members/me/boards?key=" + apiKey + "&token=" + token);

            // Mở kết nối HTTP
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Đọc dữ liệu trả về từ API
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Trả về danh sách bảng dưới dạng chuỗi JSON
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void init() {
        UrlTrello LIST = UrlTrello.LIST;
        UrlTrello CREATE_BOARD = UrlTrello.CREATE_BOARD;
        // Đặt các tham số cần thiết
        String apiKey = "cfc547b10a0c734c846c8637ac315858";
        String token = "ATTAf50b8e2d62e686137f7f778764d75be902506a4c9385195d51e95fa9fe2445a7AC6DA5E7";
        Map map = new HashMap();
        map.put("apiKey",apiKey);
        map.put("token", token);
        map.put("boardName", "Debhub System Automation");
        map.put("boardId", "66180314eccb614cea47b8b0");
    
        String completeUrl = null;
       // map.put("boardId", "6666");
        try {
            completeUrl = LIST.getUrl(map);
            System.out.println( httpUtils.GET(completeUrl));
            Map<String, String> strMap=new HashMap<String, String>();
            
           System.out.println(httpUtils.POST(CREATE_BOARD.getUrl(map),map));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        init();
//        String apiKey = "cfc547b10a0c734c846c8637ac315858";
//        String privateKey = "13967c9c46f43b4ed2abd89fcda32625f9df24bffac695a5b9282461560a398b";
//        String token = "ATTAf50b8e2d62e686137f7f778764d75be902506a4c9385195d51e95fa9fe2445a7AC6DA5E7";
//        String boardList = getBoardList(apiKey, token);
//        JsonParser parser = new JsonParser();
//        Map<String, Object> resultMap = new HashMap<>();
//        JsonArray jsonArray = parser.parse(boardList).getAsJsonArray();
//
//        if (jsonArray.size() > 0) {
//            JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
//            Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
//            for (Map.Entry<String, JsonElement> entry : entrySet) {
//                String key = entry.getKey();
//                JsonElement value = entry.getValue();
//                resultMap.put(key, value);
//            }
//        }
//        System.out.println("Board List: " + boardList);
//        System.out.println(jsonToMap(boardList));
    }
}

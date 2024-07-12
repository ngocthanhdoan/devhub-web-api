package com.j4fun.eNum;

import java.util.HashMap;
import java.util.Map;

public enum UrlTrello {
    MEMBERS_ME_BOARDS(1, "https://api.trello.com/1/members/me/boards?key={apiKey}&token={token}"            ,"GET" , "apiKey", "token"),
    MEMBERS_ME_ACTIONS(2, "https://api.trello.com/1/members/me/actions?key={apiKey}&token={token}"          ,"GET" , "apiKey", "token"),
    BOARDS_ID(3, "https://api.trello.com/1/boards/{boardId}?key={apiKey}&token={token}"                     ,"GET" , "boardId", "apiKey", "token"),
    CARDS_ID(4, "https://api.trello.com/1/cards/{cardId}?key={apiKey}&token={token}"                        ,"GET" , "cardId", "apiKey", "token"),
    CHECKLISTS_ID(5, "https://api.trello.com/1/checklists/{checklistId}?key={apiKey}&token={token}"         ,"GET" , "checklistId", "apiKey", "token"),
    LIST(6,"https://api.trello.com/1/boards/{boardId}/lists?key={apiKey}&token={token}"                     ,"GET" , "boardId", "apiKey", "token"),
    ORGANIZATIONS_ID(7, "https://api.trello.com/1/organizations/{organizationId}?key={apiKey}&token={token}","GET" , "organizationId", "apiKey", "token"),
    CREATE_BOARD(8, "https://api.trello.com/1/boards/?name={boardName}&key={apiKey}&token={token}"         ,"POST", "boardName", "apiKey", "token"),
   
    
    ;

    private final int code;

    private final String description;
    private final String send_method;
    private final Map<String, String> params;

    UrlTrello(int code, String description,String send_method, String... params) {
        this.code = code;
        this.description = description;
        this.send_method = send_method;
        this.params = new HashMap<>();
        for (int i = 0; i < params.length; i++) {
            this.params.put(params[i], "{" + params[i] + "}");
        }

    }

    public void setParam(String key, String value) {
        this.params.put(key, value);
    }

    public String getUrl() {
        String url = this.description;
        for (Map.Entry<String, String> entry : this.params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            url = url.replace("{" + key + "}", value);
        }
        return url;
    }

    public String getUrl(Map params) throws Exception {
        String url = this.description;

        for (Map.Entry<String, String> entry : this.params.entrySet()) {
            String key = entry.getKey();
            String value = null;
            try {
                value = params.get(key).toString();
            } catch (Exception e) {
             throw new Exception("Please check value param ["+entry.getValue()+"]");
            }
            url = url.replace("{" + key + "}", value);
        }
        return url;
    }

    public static void main(String[] args) {
        // Tạo một đối tượng của enum UrlTrello
        UrlTrello url = UrlTrello.MEMBERS_ME_BOARDS;

        // Đặt các tham số cần thiết
        String apiKey = "123456";
        String token = "12344243";
        Map map = new HashMap();
        map.put("apiKey",apiKey);
        map.put("token", token);
        map.put("organizationId", "12222222");
        String completeUrl = null;
        map.put("boardId", "6666");
        try {
            completeUrl = url.getUrl(map);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // In ra URL hoàn chỉnh
        System.out.println("Complete URL: " + completeUrl);
    }
}
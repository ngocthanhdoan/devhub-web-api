package com.j4fun.eNum;

public enum LanguageEnum {
    VIETNAM                  (0 , "VN", "vni"),
    ENGLISH                  (1 , "EN", "enl"),
    FRANCE                   (2 , "FR", "fra"),
    GERMANY                  (3 , "DE", "deu"),
    ITALY                    (4 , "IT", "ita"),
    SPAIN                    (5 , "ES", "spa"),
    JAPAN                    (6 , "JP", "jpn"),
    CHINA                    (7 , "CN", "zho"),
    INDIA                    (8 , "IN", "hin"),
    BRAZIL                   (9 , "BR", "por"),
    MEXICO                   (10, "MX", "spa"),
    RUSSIA                   (11, "RU", "rus"),
    CANADA                   (12, "CA", "eng"),
    AUSTRALIA                (13, "AU", "eng"),
    SOUTH_AFRICA             (14, "ZA", "eng"),
    ;
    private final int    code ;
    private final String key  ;
    private final String value;

    public int getCode()     {
        return code;
    }

    public String getKey()   {
        return key;
    }

    public String getValue() {
        return value;
    }

    LanguageEnum(int code, String key, String value) {
        this.code  = code ;
        this.key   = key  ;
        this.value = value;
    }
 
}

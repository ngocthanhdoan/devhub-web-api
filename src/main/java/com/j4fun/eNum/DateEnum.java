package com.j4fun.eNum;

public enum DateEnum {
    MON                  (1     , "Monday"   ,  "Thứ 2")    ,
    TUE                  (2     , "Tuesday"  ,  "Thứ 3")    ,
    WED                  (3     , "Wednesday",  "Thứ 4")    ,
    THU                  (4     , "Thursday" ,  "Thứ 5")    ,
    FRI                  (5     , "Friday"   ,  "Thứ 6")    ,
    SAT                  (6     , "Saturday" ,  "Thứ 7")    ,
    SUN                  (7     , "Sunday"   ,  "Chủ Nhật") ,
    ;
    private final int    code       ;
    private final String ENL        ;
    private final String VNI        ;
    DateEnum(int i, String ENL, String VNI) {
        this.code=i;
        this.ENL=ENL;
        this.VNI=VNI;
    }
    public int getCode() {
        return code;
    }
    public String getENL() {
        return ENL;
    }
    public String getVNI() {
        return VNI;
    }
    
    public static DateEnum getByCode(int code)      {
        for (DateEnum errorCode : values()) {
            if (errorCode.getCode() == code) {
                return errorCode;
            }
        }
        return null; 
    }
    public static void main(String[] args) {
        String str = "Here is a boy: \uD83D\uDC66\uD83C\uDFFF!";
        System.out.println(str);
    }
}


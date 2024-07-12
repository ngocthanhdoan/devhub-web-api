package com.j4fun.eNum;

public enum CodeEnum {
    VERY_AUTH_TYPE_API                  (501     , "API")                        ,
    VERY_AUTH_TYPE_PUBLIC               (502     , "PUBLIC")                     ,
    VERY_AUTH_TYPE_PRIVATE              (503     , "PRIVATE")                    ,
    // Yah! you'r right!
    SUCCESS                             (0       , "SUCCESS")                    ,
    //ERROR LIST     
    ERROR                               (-1      , "ERROR")                      , 
    ERROR_WARNING                       (-2      , "ERROR_WARNING")              , 
    ERROR_NOT_FOUND                     (404     , "ERROR_NOT_FOUND")            , 
    ERROR_LOCK                          (-3      , "ERROR_LOCK")                 ,
    ERROR_UN_LOCK                       (-4      , "ERROR_UN_LOCK")              ,
    ERROR_OTHER_CODE                    (-5      , "ERROR_OTHER_CODE")           ,    
    //NETWORK & SYSTEM
    ERROR_DATABASE_CONNECTION           (-6      , "ERROR_DATABASE_CONNECTION")  ,
    ERROR_FILE_NOT_FOUND                (-7      , "ERROR_FILE_NOT_FOUND")       ,
    ERROR_INVALID_INPUT                 (-8      , "ERROR_INVALID_INPUT")        ,
    ERROR_NETWORK                       (-9      , "ERROR_NETWORK")              ,
    ERROR_OUT_OF_MEMORY                 (-10     , "ERROR_OUT_OF_MEMORY")        ,
    ERROR_NULL                          (-11     , "ERROR_NULL")                 ,
    //JOB STATUS 
    JOB_RUNNING                         (100     , "JOB_RUNNING")                ,
    JOB_HOLD                            (101     , "JOB_HOLD")                   ,
    JOB_KILL                            (102     , "JOB_KILL")                   ,
    JOB_RESUM                           (103     , "JOB_RESUM")                  ,
    JOB_START                           (104     , "JOB_START")                  ,
    //JOB ERROR
    JOB_ERROR_NOT_FOUND                 (-1404   , "JOB_ERROR_NOT_FOUND")        ,
    //AUTH
    PERMISSION_DENY                     (1100    , "PERMISSION_DENY")            ,
    NOTPASS_AUTH_URL_FUNCTION           (1101    , "NOTPASS_AUTH_URL_FUNCTION")  ,
    NOTPASS_AUTH_FUNCTION_NAME          (1102    , "NOTPASS_AUTH_FUNCTION_NAME") ,
    NOTPASS_AUTH_ROLES_FUNCTION         (1103    , "NOTPASS_AUTH_ROLES_FUNCTION"),
    NOTPASS_AUTH_ACTION_ALLOW           (1104    , "NOTPASS_AUTH_ACTION_ALLOW")  ,
    //ENV
    ENV_NEED_RUN_ON_PROD                (1200    , "ENV_NEED_RUN_ON_PROD")       ,
    ENV_JUST_RUN_ON_STAG                (1201    , "ENV_NEED_RUN_ON_STAG")       ,
    ENV_JUST_RUN_ON_LOCAL               (1202    , "ENV_JUST_RUN_ON_LOCAL")      ,
    //SYSTEM_DATA
    SYS_CREATE_BY_SYSTEM                (1300    , "SYS_CREATE_BY_SYSTEM")       ,
    SYS_CREATE_BY_FUNCTION              (1301    , "SYS_CREATE_BY_FUNCTION")     ,
    SYS_CREATE_BY_BATCH                 (1302    , "SYS_CREATE_BY_BATCH")     ,
    
    ;
    
    private final int    code       ;
    private final String description;
  
    CodeEnum(int code, String description)          {
        this.code        = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
    
    public static String getCode(int code)      {
        for (CodeEnum errorCode : values()) {
            if (errorCode.getCode() == code){
                return errorCode.toString();
            }
        }
        return ERROR_OTHER_CODE.toString(); 
    }
    
    public static CodeEnum getByCode(int code)      {
        for (CodeEnum errorCode : values()) {
            if (errorCode.getCode() == code) {
                return errorCode;
            }
        }
        return ERROR_OTHER_CODE; 
    }
    public static CodeEnum getByDescription(String value)      {
        for (CodeEnum errorCode : values()) {
            if (errorCode.toString().equals(value)) {
                return errorCode;
            }
        }
        return ERROR_OTHER_CODE; 
    }
    public static void main(String[] args)      {
        snapEnumToDb();
    }
    
    public static void snapEnumToDb()           {
        int index=0;
        for (CodeEnum errorCode : values()) {
            index+=0.5;
            //System.out.printf("%2d. [%-5d][%s]%n", index++, errorCode.getCode(), errorCode.toString());
            //Lấy Code Khai Báo EnumNe
            System.out.printf("%-50s (%-5d, \"%-5s\")%-5s", errorCode.toString(), errorCode.getCode(), errorCode.toString(), "");
            System.out.println(",");
        }
    }
}

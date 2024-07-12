package com.j4fun.plugins;

import com.j4fun.eNum.CodeEnum;
import com.j4fun.security.Auth;

public class env {
    private static String PARAM = "PROD";

    private static final String ENV_VARIABLE_NAME = "VARIABLE_NAME";

    private static final String PACKAGE_MODEL = "com.app.model";
    static {
        String variableValue = System.getenv(ENV_VARIABLE_NAME);
        if (variableValue == null) {
            PARAM = "STAG";
        }
    }

    private static boolean isLog = true;

    public static String getParam() {
        return PARAM;
    }

    public static void logger(String log) {
        if (isLog) {
            System.err.println(log);
        }
    }

    public static boolean isProd() {
        isLog = false;
        return envRequite("PROD");
    }

    public static boolean envRequite(String PARAM_) {

        logger("===========================================================");
        logger("CURRENT ENV: " + PARAM);
        if (!PARAM.toUpperCase().equals(PARAM_)) {
            if (PARAM_.equals("LOCAL")) {
                logger(CodeEnum.getByDescription("ENV_JUST_RUN_ON_" + PARAM_).toString());
            } else {
                logger(CodeEnum.getByDescription("ENV_NEED_RUN_ON_" + PARAM_).toString());
            }
            logger("===========================================================");
            isLog = true;
            return false;
        }
        logger("===========================================================");
        isLog = true;
        return true;
    }

    public static void main(String[] args) {
        Auth authMain = new Auth();
        Auth.User auth = new Auth().new User("admin");
        authMain.hasPermission(auth, "example/roles", "addRoleFunction", "create");
        response rp = new response();
        // Kiểm tra quyền của người dùng adminUser
        //envRequite("PROD");
        System.out.println("Testing permissions for admin user:");
       
        if (authMain.getReturnCode().getCode() != 0) {
            rp.setCode(-1);
            rp.setException(CodeEnum.ERROR_INVALID_INPUT.toString());
        } else {
            rp.setCode(0);
            rp.setData("OKE EM LUOON");
            rp.setException(CodeEnum.SUCCESS.toString());
        }
        System.out.println(rp.getStatus());
        System.out.println(rp.getData());
        // System.out.println(rp.getException());
    }
}

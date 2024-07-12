package com.j4fun.plugins;


public class ref {

    private static String log = "ON";
    private Class<?> class_;
    private static void log(Object obj) {
        if (log.equals("ON")) {
            System.out.println(obj);
        }
    }

    private static String getClassName(String refInput) {
        try {
            //log4fun.log(refInput);
            //log(refInput.substring(0, refInput.indexOf("/")));
            return refInput.substring(0, refInput.indexOf("/"));
        } catch (Exception e) {
            return null;
        }

    }

    private static String getMethodName(String refInput) {
        try {
            //log(refInput.substring(refInput.indexOf("/") + 1));
            return refInput.substring(refInput.indexOf("/") + 1);
        } catch (Exception e) {
            return null;
        }

    }

    private static Class<?> getClass(String refInput) {
        try {
            return Class.forName(refInput.substring(0, refInput.indexOf("/")));
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getClassName("com.app.pulgins.ref/getInforMethodRef"));
        System.out.println(getMethodName("com.app.pulgins.ref/getInforMethodRef"));
    }
}

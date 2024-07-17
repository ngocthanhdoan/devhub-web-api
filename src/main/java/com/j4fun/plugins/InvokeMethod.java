package com.j4fun.plugins;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class InvokeMethod {
    public static Object execute(String classNameMethod, Map<String, String> params) throws Exception {
        String[] parts = classNameMethod.split("/");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid classNameMethod format. Expected format: className/methodName");
        }
        String className = parts[0];
        String methodName = parts[1];
        Class<?> clazz = Class.forName(className);
        RefUtils refUtils = new RefUtils(clazz);
        if (!refUtils.hasMethod(methodName)) {
            throw new NoSuchMethodException("Method " + methodName + " not found in class " + className);
        }
        // Chuyển đổi Map sang Object[]
        Object[] paramValues = convertParams(methodName, params, refUtils);

        Method method = refUtils.getMethodByNameAndParams(methodName, paramValues);
        Object instance = clazz.getDeclaredConstructor().newInstance();

        return refUtils.invokeMethod(methodName, instance, paramValues);
    }

    private static Object[] convertParams(String methodName, Map<String, String> params, RefUtils refUtils) throws Exception {
        List<Map<String, String>> methodParams = refUtils.getMethodDetails(methodName).get(methodName);
        System.out.println(methodParams);
        Object[] paramValues = new Object[methodParams.size()];

        for (int i = 0; i < methodParams.size(); i++) {
            Map<String, String> paramInfo = methodParams.get(i);
            String paramName = paramInfo.get("name");
            String paramType = paramInfo.get("type");
            String paramValue = params.get(paramName);

            paramValues[i] = convertParam(paramValue, paramType);
        }

        return paramValues;
    }

    private static Object convertParam(String value, String type) {
        if (value == null) {
            // return null; // or throw an exception if null values are not acceptable
            throw new IllegalArgumentException("Null values are not acceptable ");
        }

        switch (type) {
            case "java.lang.String":
                return value;
            case "int":
            case "java.lang.Integer":
                return Integer.parseInt(value);
            case "long":
            case "java.lang.Long":
                return Long.parseLong(value);
            case "double":
            case "java.lang.Double":
                return Double.parseDouble(value);
            case "float":
            case "java.lang.Float":
                return Float.parseFloat(value);
            case "boolean":
            case "java.lang.Boolean":
                return Boolean.parseBoolean(value);
            case "char":
            case "java.lang.Character":
                return value.charAt(0);
            default:
                throw new IllegalArgumentException("Unsupported parameter type: [" + type + "] with value: [" + value+"]");
        }
    }
public static void main(String[] args) {
	
}
}

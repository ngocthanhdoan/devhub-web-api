package com.j4fun.plugins;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RefUtils {
    private Class<?> class_;

    private Method[] methods;

    private Map<String, List<Map<String, String>>> mapMethod;

    public RefUtils(Class<?> class_) {
        this.class_ = class_;
        this.methods = class_.getDeclaredMethods();
        fetchAllMethods();
    }

    public RefUtils(String className) throws ClassNotFoundException {
        this.class_ = Class.forName(className);
        this.methods = class_.getDeclaredMethods();
        fetchAllMethods();
    }

    private void fetchAllMethods() {
        mapMethod = new HashMap<>();
        if (class_ != null) {
            for (Method method : methods) {
                List<Map<String, String>> paramsList = new ArrayList<>();
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    Map<String, String> paramInfo = new HashMap<>();
                    paramInfo.put("name", parameter.getName());
                    paramInfo.put("type", parameter.getType().getName());
                    paramsList.add(paramInfo);
                }
                mapMethod.put(method.getName(), paramsList);
            }
        }
    }

    public boolean hasMethod(String methodName) {
        return mapMethod.containsKey(methodName);
    }

    public Object invokeMethod(String methodName, Object instance, Object... params) throws Exception {
        if (hasMethod(methodName)) {
            Method method = getMethodByNameAndParams(methodName, params);
            if (method.getReturnType().equals(Void.TYPE)) {
                method.invoke(instance, params);
                System.out.println("Method " + methodName + " executed successfully.");
                return null;
            } else {
                return method.invoke(instance, params);
            }
        } else {
            throw new NoSuchMethodException("Method " + methodName + " not found in class " + class_.getName());
        }
    }

    public Method getMethodByNameAndParams(String methodName, Object[] params) throws NoSuchMethodException {
        for (Method method : methods) {
            if (method.getName().equals(methodName) && matchParameterTypes(method.getParameterTypes(), params)) {
                return method;
            }
        }
        throw new NoSuchMethodException("Method " + methodName + " with specified parameters not found in class " + class_.getName());
    }

    private boolean matchParameterTypes(Class<?>[] paramTypes, Object[] params) {
        if (paramTypes.length != params.length) {
            return false;
        }
        for (int i = 0; i < paramTypes.length; i++) {
            if (params[i] == null) {
                continue;
            }
            if (paramTypes[i].isPrimitive()) {
                if (!getWrapperClass(paramTypes[i]).equals(params[i].getClass())) {
                    return false;
                }
            } else if (!paramTypes[i].isAssignableFrom(params[i].getClass())) {
                return false;
            }
        }
        return true;
    }

    private Class<?> getWrapperClass(Class<?> primitiveClass) {
        if (primitiveClass.equals(int.class)) {
            return Integer.class;
        } else if (primitiveClass.equals(long.class)) {
            return Long.class;
        } else if (primitiveClass.equals(double.class)) {
            return Double.class;
        } else if (primitiveClass.equals(float.class)) {
            return Float.class;
        } else if (primitiveClass.equals(boolean.class)) {
            return Boolean.class;
        } else if (primitiveClass.equals(char.class)) {
            return Character.class;
        } else if (primitiveClass.equals(byte.class)) {
            return Byte.class;
        } else if (primitiveClass.equals(short.class)) {
            return Short.class;
        }
        throw new IllegalArgumentException("Unsupported primitive type: " + primitiveClass.getName());
    }

    public Map<String, List<Map<String, String>>> getMethodDetails(String methodName) {
        if (hasMethod(methodName)) {
            Map<String, List<Map<String, String>>> methodDetails = new HashMap<>();
            methodDetails.put(methodName, mapMethod.get(methodName));
            return methodDetails;
        } else {
            return null;
        }
    }

    public Map<String, List<Map<String, String>>> getAllMethods() {
        return mapMethod;
    }
}

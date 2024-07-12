package com.j4fun.eNum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public enum TypeMapping {
    BYTE            ("byte", java.lang.Byte.class.getName(), Byte.TYPE)                  , 
    CHAR            ("char", java.lang.Character.class.getName(), Character.TYPE)        , 
    SHORT           ("short", java.lang.Short.class.getName(), Short.TYPE)               , 
    INT             ("int", java.lang.Integer.class.getName(),Integer.TYPE)              ,
    BOOLEAN         ("boolean", java.lang.Boolean.class.getName(), Boolean.TYPE)         ,
    LONG            ("long", java.lang.Long.class.getName(), Long.TYPE)                  , 
    DOUBLE          ("double", java.lang.Double.class.getName(), Double.TYPE)            , 
    FLOAT           ("float", java.lang.Float.class.getName(), Float.TYPE)               , 
    STRING          ("String", java.lang.String.class.getName(), "".getClass())          , 
    JAVA_LANG_STRING("java.lang.String", java.lang.String.class.getName(), "".getClass());

    private final           String typeName       ;

    private final           String className      ;

    private final           Class<?> primitiveType;

    private static final    Map<String, TypeMapping> TYPE_MAPPING   = new HashMap<>();

    private static final    Map<String, Class<?>> PRIMITIVE_MAPPING = new HashMap<>();

    static {
        for (TypeMapping typeMapping : TypeMapping.values())               {
            TYPE_MAPPING.put(typeMapping.typeName, typeMapping);
            PRIMITIVE_MAPPING.put(typeMapping.typeName, typeMapping.primitiveType);
        }
    }

    TypeMapping(String typeName, String className, Class<?> primitiveType) {
        this.typeName      = typeName;
        this.className     = className;
        this.primitiveType = primitiveType;
    }

    public String getTypeName()                                            {
        return typeName;
    }

    public String getClassName()                                           {
        return className;
    }

    public Class<?> getPrimitiveType()                                     {
        return primitiveType;
    }

    public static TypeMapping getTypeMapping(String typeName)              {
        return TYPE_MAPPING.get(typeName);
    }

    public static Class<?> getPrimitiveType(String typeName)               {
        return PRIMITIVE_MAPPING.get(typeName);
    }
    public static boolean isNumeric(String str)                            {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && c != '.') {
                return false;
            }
        }
        return true;
    }
    public static void Test() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào tên kiểu dữ liệu: ");
        String input = scanner.nextLine().trim();
        TypeMapping typeMapping = TypeMapping.getTypeMapping(input);
        if (typeMapping != null) {
            System.out.println("Tên kiểu dữ liệu: " + typeMapping.getTypeName());
            System.out.println("Tên lớp: " + typeMapping.getClassName());
            System.out.println("Kiểu nguyên thủy: " + typeMapping.getPrimitiveType());
        } else {
            System.out.println("Không tìm thấy kiểu dữ liệu cho: " + input);
        }
    }

    public static void Test2() {
        // Kiểm tra kiểu dữ liệu
        String typeName = "int";
        TypeMapping typeMapping = TypeMapping.getTypeMapping(typeName);
        if (typeMapping != null) {
            System.out.println("Tên kiểu dữ liệu: " + typeMapping.getTypeName());
            System.out.println("Tên lớp: " + typeMapping.getClassName());
            System.out.println("Kiểu nguyên thủy: " + typeMapping.getPrimitiveType());
        } else {
            System.out.println("Không tìm thấy kiểu dữ liệu cho: " + typeName);
        }

        // Kiểm tra kiểu nguyên thủy
        Class<?> primitiveType = TypeMapping.getPrimitiveType(typeName);
        if (primitiveType != null) {
            System.out.println("Kiểu nguyên thủy của " + typeName + " là: " + primitiveType);
        } else {
            System.out.println("Không tìm thấy kiểu nguyên thủy cho: " + typeName);
        }
    }

    public static void main(String[] args) {
        Test();
    }

}

package com.j4fun.eNum;
import com.j4fun.eNum.TypeMapping;
public enum OutPutEnum {
    STRING                                   (0       ,TypeMapping.STRING.getTypeName(), ""),
    JSON                                     (1       ,TypeMapping.STRING.getTypeName(), ""),
    MAP                                      (3       , "{0}", ""),    
    ;

    OutPutEnum(int type, String value,Object data) {
        // TODO Auto-generated constructor stub
    }
}

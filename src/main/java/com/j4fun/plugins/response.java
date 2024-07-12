package com.j4fun.plugins;
import com.j4fun.eNum.CodeEnum;

public class response {
    //code mapping with @Class: com.j4fun.plugins.code 
    private int code;

    //exception
    private String exception;

    //data
    private Object data;

    //status
    private String status;

    //data_type
    private int data_type;

    //data_lenght
    private int data_lenght;

    public response()                                        {
        this.code        = 0;
        this.data        = "{}";
        this.status      = CodeEnum.getCode(code);
        this.exception   = "";
    }

    public response(int code, String exception, String data) {
        this.code        = code;
        this.data        = data;
        this.status      = CodeEnum.getCode(code);
        this.exception   = exception;
    }

    public response(int code, String data)                   {
        this.code        = code;
        if(code>=0) {
            this.data    = data;
        }
        this.status      = CodeEnum.getCode(code);
    }
    
    public void setCode(int code)                            {
        this.code        = code;
        this.status      = CodeEnum.getCode(code);
    }

    public void setException(String exception)               {
        this.exception   = exception;
    }
    
    public void setData(Object data)                         {
        this.data        = data;
    }
    
    public void setData_type(int data_type)                  {
        this.data_type   = data_type;
    }
    
    public void setData_lenght(int data_lenght)              {
        this.data_lenght = data_lenght;
    }
    
    public String getStatus()                                {
        return status;
    }
    
    public int getCode()                                     {
        return code;
    }
    
    public String getException()                             {
        return exception;
    }
    
    public Object getData()                                  {
        return data;
    }
    
    public int getData_type()                                {
        return data_type;
    }

    public int getData_lenght()                              {
        return data_lenght;
    }
    

    public static void main(String[] args) {
        response rp = new response(2,"khong co gi luon");
        System.out.println(rp);
        System.out.println(rp.getData());
    }
}

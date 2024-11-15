package com.example.my_book_manager_system.comment;

import lombok.Data;

@Data
public class Result {
    private static final String SUCCESS_CODE = "200";
    private static final String ERROR_CODE = "-1";

    private String Code;
    private Object data;
    private String meg;

    public static  Result success(){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        return result;
    }

    public static  Result success(Object data){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }
    public static  Result error(String msg){
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMeg(msg);
        return result;
    }
}

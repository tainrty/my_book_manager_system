package com.example.my_book_manager_system.comment;

import lombok.Data;

@Data
public class Result {
    private static final String SUCCESS_CODE = "200";
    private static final String ERROR_CODE = "-1";

    private String code;  // 注意大小写一致，之前是 Code，应该修改为 code
    private Object data;
    private String msg;  // 注意大小写一致，之前是 meg，应该修改为 msg

    // 无数据的成功返回
    public static Result success() {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        return result;
    }

    // 带数据的成功返回
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setData(data);
        return result;
    }

    // 错误返回（带自定义 code 和 msg）
    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);  // 使用传递的 code
        result.setMsg(msg);     // 使用传递的 msg
        return result;
    }
}

package cn.org.bugcreator.dto;

import lombok.Data;

@Data
public class CommonResponse<T> {
    private int code;       // 状态码
    private String message; // 消息
    private T data;         // 泛型数据

    // 默认构造函数
    public CommonResponse() {}

    // 带参数的构造函数
    public CommonResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 静态方法，用于构建成功响应
    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(200, "Success", data);
    }

    // 静态方法，用于构建失败响应
    public static <T> CommonResponse<T> failure(String message) {
        return new CommonResponse<>(500, message, null);
    }
}

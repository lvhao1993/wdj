package wly.common;

import java.io.Serializable;

/**
 * @ClassName WdjResult
 * @Description TODO
 * @Author lvhao@cloudwalk.cn
 * @Date 2019/4/1 20:57
 * @Version 1.0
 **/
public class WdjResult<T> implements Serializable {
    private static final long serialVersionUID = 9191892693219217387L;
    private static final String RESP_CODE_SUCCESS = "00000000";
    private String code;
    private boolean success;
    private String message;
    private T data;

    public WdjResult() {
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static <T> WdjResult<T> success(T data) {
        WdjResult<T> result = new WdjResult();
        result.setCode("00000000");
        result.setMessage("成功");
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> WdjResult<T> fail(String code, String message, T data) {
        WdjResult<T> result = new WdjResult();
        result.setCode(code);
        result.setData(data);
        result.setMessage(message);
        result.setSuccess(false);
        return result;
    }

    public static <T> WdjResult<T> fail(String code, String message) {
        WdjResult<T> result = new WdjResult();
        result.setCode(code);
        result.setMessage(message);
        result.setSuccess(false);
        result.setData(null);
        return result;
    }
}

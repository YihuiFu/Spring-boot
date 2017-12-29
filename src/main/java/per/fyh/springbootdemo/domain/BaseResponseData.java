package per.fyh.springbootdemo.domain;

public class BaseResponseData<T> {
    private int Code;
    private String Message;

    public String getMessage() {
        return Message;
    }
    public BaseResponseData() {
        Code = 0;
        Message = "";
        Data=null;
    }
    public BaseResponseData(int code, String message) {
        Code = code;
        Message = message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    private T Data;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }
}

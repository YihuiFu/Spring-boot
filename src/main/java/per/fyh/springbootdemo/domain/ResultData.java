package per.fyh.springbootdemo.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultData<T> implements Serializable {
    private static final long serialVersioinUID = 1L;
    private static final int SUCCESS = 0;
    private static final int EXCEPTION = -9999;
    private static final String MSG_SUCCESS = "success";

    /**
     * 返回状态码，0 表示成功
     */
    private int code = SUCCESS;
    /**
     * 返回信息，结合code使用（主要是code!=0的时候使用）
     */
    private String msg = MSG_SUCCESS;
    /**
     * 返回的数据
     */
    private T data;
    public ResultData() {
        super();
    }
    public ResultData(T data) {
        super();
        this.data = data;
    }
    public ResultData(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
    public ResultData(int code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public ResultData(Throwable e) {
        super();
        this.code = EXCEPTION;
    }
}

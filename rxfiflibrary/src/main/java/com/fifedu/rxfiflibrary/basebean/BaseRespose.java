package com.fifedu.rxfiflibrary.basebean;

import java.io.Serializable;

/**
 * des:封装服务器返回数据
 * Created by weidingqiang
 * on 2016.09.9:47
 */
public class BaseRespose<T> implements Serializable {
    public String reason;
    public String error_code;

    public T data;

    public boolean success() {
        return "查询成功".equals(reason);
    }

    @Override
    public String toString() {
        return "BaseRespose{" +
                "code='" + reason + '\'' +
                ", msg='" + error_code + '\'' +
                ", data=" + data +
                '}';
    }
}

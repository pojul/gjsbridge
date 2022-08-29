package com.pojul.gjsbridge;

/**
 * @Description: 类描述
 * @Author: ganqiubo
 * @CreateDate: 2022/8/17 10:41
 */
public abstract class JsFunctionCallBack {
    public String funId;

    public JsFunctionCallBack(String funId) {
        this.funId = funId;
    }

    public abstract void callback(String respData);
}

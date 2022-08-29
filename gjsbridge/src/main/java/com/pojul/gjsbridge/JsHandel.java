package com.pojul.gjsbridge;

import android.util.Log;
import android.webkit.JavascriptInterface;

import com.google.gson.Gson;

/**
 * @Description: 类描述
 * @Author: ganqiubo
 * @CreateDate: 2022/8/16 22:54
 */
public abstract class JsHandel {

    private static final String TAG = "JsHandel";
    private GjsbridgeWebview gjsbridgeWebview;

    public void init(GjsbridgeWebview gjsbridgeWebview){
        this.gjsbridgeWebview = gjsbridgeWebview;
    }

    @JavascriptInterface
    public void call(String dataObj) {
        JsFun jsFun = new Gson().fromJson(dataObj, JsFun.class);
        if(jsFun.funName==null||jsFun.funName.isEmpty()){
            return;
        }
        JsFunctionCallBack jsFunction = new JsFunctionCallBack(jsFun.funId) {
            @Override
            public void callback(String respData) {
                if(gjsbridgeWebview==null){
                    Log.e(TAG, "gjsbridgeWebview has not init");
                    return;
                }
                if(funId==null||funId.isEmpty()){
                    return;
                }
                gjsbridgeWebview.post(() -> {
                    gjsbridgeWebview.loadUrl("javascript:gjsbridgeApiCallBack('"+funId+"', '"+respData+"')");
                });
            }
        };
        jscall(jsFun.funName, jsFun.funData, jsFunction);
    }

    public abstract void jscall(String funName, String funData, JsFunctionCallBack jsFunction);

}

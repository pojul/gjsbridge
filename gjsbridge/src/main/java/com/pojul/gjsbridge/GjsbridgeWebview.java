package com.pojul.gjsbridge;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @Description: 类描述
 * @Author: ganqiubo
 * @CreateDate: 2022/8/16 22:41
 */
public class GjsbridgeWebview extends WebView {
    public GjsbridgeWebview(@NonNull Context context) {
        super(context);
    }

    public GjsbridgeWebview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GjsbridgeWebview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GjsbridgeWebview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public GjsbridgeWebview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
    }

    public void registHandel(String handelName, JsHandel jsHandel){
        if(jsHandel==null){
            return;
        }
        jsHandel.init(this);
        getSettings().setJavaScriptEnabled(true);
        addJavascriptInterface(jsHandel, handelName);
    }
}

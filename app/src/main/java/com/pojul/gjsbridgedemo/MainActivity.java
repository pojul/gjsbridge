package com.pojul.gjsbridgedemo;

import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.pojul.basemvvm.ui.BaseActivity;
import com.pojul.basemvvm.viewmodel.BaseVM;
import com.pojul.gjsbridge.JsFunctionCallBack;
import com.pojul.gjsbridge.JsHandel;
import com.pojul.gjsbridgedemo.databinding.ActivityMainBinding;
import com.pojul.gjsbridgedemo.nativeapi.VolumnApi;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActVM> {

    private static final String TAG = "WebActivity";

    @Override
    public void initView() {
        binding.webview.registHandel("gjsbridgeApi", new JsHandel() {
            @Override
            public void jscall(String funName, String funData, JsFunctionCallBack jsFunction) {
                if("getVolumn".equals(funName)){
                    VolumnApi volumnApi = new VolumnApi();
                    jsFunction.callback(volumnApi.getVolumn(MainActivity.this));
                    return;
                }else if("showToast".equals(funName) && funData!=null && !funData.isEmpty()){
                    Toast.makeText(MainActivity.this, funData, Toast.LENGTH_LONG).show();
                    return;
                }
                jsFunction.callback("from native");
            }
        });
        binding.webview.loadUrl("http://pojul.gitee.io/web/testjsbridge/");
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BaseVM initViewModel() {
        return new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainActVM.class);
    }
}
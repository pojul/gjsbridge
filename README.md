
#### Android webview与js交互lib库

1、集成： implementation 'io.github.pojul:gjsbridge:1.0.1'

2、布局文件
```xml
	<com.pojul.gjsbridge.GjsbridgeWebview
            android:id="@+id/webview"
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>
```

3、注册js对象
```java
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
		```
h5 demo代码可以直接在 http://pojul.gitee.io/web/testjsbridge/ 浏览器中下载
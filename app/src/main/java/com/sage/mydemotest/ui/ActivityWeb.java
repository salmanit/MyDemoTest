package com.sage.mydemotest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sage.mydemotest.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Sage on 2016/4/7.
 */
public class ActivityWeb extends ActivityBase {

    @ViewInject(R.id.wv)
    WebView wv;

    String url="http://10.0.2.70:8081/ZSEAP/index.html";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        x.view().inject(this);
        init();
    }

    private void init(){

        WebSettings mWebSettings = wv.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setPluginState(WebSettings.PluginState.ON);
        mWebSettings.setSupportZoom(true);
        mWebSettings.setBuiltInZoomControls(true);
        //mWebSettings.setDisplayZoomControls(false);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setUseWideViewPort(true);//将图片调整到适合webview的大小
        mWebSettings.setDefaultTextEncodingName("GBK");
        mWebSettings.setSupportMultipleWindows(true); //多窗口
        mWebSettings.setLoadsImagesAutomatically(true);
        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//支持内容从新布局
        mWebSettings.setDomStorageEnabled(true);
        wv.requestFocusFromTouch();
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        wv.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        if(wv.canGoBack()){
            wv.goBack();
            return;
        }
        super.onBackPressed();
    }
}

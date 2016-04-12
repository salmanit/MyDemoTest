package com.sage.mydemotest.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.sage.mydemotest.widget.HTML5WebView;

public class ActivityHTML5Web extends Activity {
	
	HTML5WebView mWebView;
    String url="http://10.0.2.70:8081/ZSEAP/index.html";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWebView = new HTML5WebView(this);
        
        if (savedInstanceState != null) {
        	mWebView.restoreState(savedInstanceState);
        } else {	
        	//mWebView.loadUrl("http://freebsd.csie.nctu.edu.tw/~freedom/html5/");
//        	mWebView.loadUrl("http://youxi.cn");
        	mWebView.loadUrl(url);
        }
        
        setContentView(mWebView.getLayout());
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	mWebView.saveState(outState);
    }
    
    @Override
    public void onStop() {
    	super.onStop();
    	mWebView.stopLoading();
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView.inCustomView()) {
            	mWebView.hideCustomView();
            	return true;
            }
    	}
    	return super.onKeyDown(keyCode, event);
    }
}
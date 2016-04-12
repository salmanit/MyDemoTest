package com.sage.mydemotest.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.sage.mydemotest.R;
import com.sage.mydemotest.util.Md5EncryptionHelper;

import org.xutils.common.util.LogUtil;

public class Activity1111 extends ActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1111);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setCustomView(R.layout.include_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String original="testappkey1415250311646";
        LogUtil.i("868a4339ea0400aec9b7a4742e06120e"+"==="+ Md5EncryptionHelper.md5(original));
         original="testappkey兑吧";
        LogUtil.i("54432c8d6f76246d5890f05b7df0182f"+"==="+ Md5EncryptionHelper.md5(original));
         original="testappkey";
        LogUtil.i("925e68506cf5a9ac740aedc2bd78f5e4"+"==="+ Md5EncryptionHelper.md5(original));
    }


}

package com.sage.mydemotest.util;

import java.util.HashMap;

/**
 * Created by Sage on 2016/4/11.
 */
public class CreditTool {

    private String key;
    private String value;

    public CreditTool(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String buildUrlWithSign(String  url, HashMap<String ,String> params){
        StringBuilder sb=new StringBuilder(url);
        sb.append(key+"="+value);
        if(params!=null)
        for(String key:params.keySet()){
            sb.append("&"+key+"="+params.get(key));
        }
        return sb.toString();
    }
}

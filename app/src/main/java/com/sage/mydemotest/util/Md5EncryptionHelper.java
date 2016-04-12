package com.sage.mydemotest.util;


import org.xutils.common.util.LogUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      14-11-22 22:48
 * Description: MD5加密工具类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 14-11-22      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class Md5EncryptionHelper {
    public static final String KEY = "srgroup.cn@@admin_it";
    public static final String TAG = Md5EncryptionHelper.class.getSimpleName();

    /**
     * 获取验证码access串
     *
     * @param uuid  设备ID
     * @param phone 手机号
     * @return access
     */
    public static String getAuthCodeAccess(String uuid, String phone) {
        String content = uuid + KEY;
        LogUtil.i("getAuthCodeAccess --> content = " + content + " --> phone = " + phone);
        return getMD5(getMD5(content) + phone);
    }

    /**
     * 获取密码字串的MD5
     *
     * @param content 需要转换的字符串
     * @return String
     */
    public static String getPwdMD5(String content) {
        return getMD5(content);
    }

    /**
     * 获取MD5字符串
     *
     * @param content 需要转换的字符串
     * @return String
     */
    public static String getMD5(String content) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(content.getBytes());
            return "0x" + getHashString(digest);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getHashString(MessageDigest digest) {
        StringBuilder builder = new StringBuilder();
        for (byte b : digest.digest()) {
            builder.append(Integer.toHexString((b >> 4) & 0xf));
            builder.append(Integer.toHexString(b & 0xf));
        }
        return builder.toString();
    }


    public static String md5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
}

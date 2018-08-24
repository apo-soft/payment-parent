package cn.aposoft.ecommerce.wechat.tencent;

import cn.aposoft.ecommerce.wechat.util.LogPortal;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 15:23
 */
public class WechatSignature {
    public enum SignType {
        MD5, HMACSHA256
    }

    /**
     * HmacSHA256加密模式判断签名是否正确
     *
     * @param xml XML格式数据
     * @param key API密钥
     * @return 签名是否正确
     * @throws Exception
     */
    public static boolean verifySignWithHMACSHA256(String xml, String key) throws Exception {
        return verifySign(WechatUtil.xmlToMap(xml), key, SignType.HMACSHA256);
    }

    public static boolean verifySignWithMD5(String xml, String key) throws Exception {
        return verifySign(WechatUtil.xmlToMap(xml), key, SignType.MD5);
    }

    public static boolean verifySignWithHMACSHA256(Map<String, String> data, String key) throws Exception {
        return verifySign(data, key, SignType.HMACSHA256);
    }

    public static boolean verifySignWithMD5(Map<String, String> data, String key) throws Exception {
        return verifySign(data, key, SignType.MD5);
    }


    /**
     * 判断签名是否正确，必须包含sign字段，否则返回false。
     *
     * @param data     Map类型数据
     * @param key      API密钥
     * @param signType 签名方式
     * @return 签名是否正确
     * @throws Exception
     */
    public static boolean verifySign(Map<String, String> data, String key, SignType signType) throws Exception {
        if (!data.containsKey(WechatConstant.SIGN)) {
            return false;
        }
        String sign = data.get(WechatConstant.SIGN);
        return generateSignature(data, key, signType).equals(sign);
    }


    /**
     * 生成签名
     *
     * @param data 待签名数据
     * @param key  API密钥
     * @return 签名
     */
    public static String generateSignatureWithHMACSHA256(final Map<String, String> data, String key) throws Exception {
        return generateSignature(data, key, SignType.HMACSHA256);
    }
    /**
     * 生成签名
     *
     * @param data 待签名数据
     * @param key  API密钥
     * @return 签名
     */
    public static String generateSignatureWithMD5(final Map<String, String> data, String key) throws Exception {
        return generateSignature(data, key, SignType.MD5);
    }
    /**
     * 生成签名信息
     *
     * @param data     要签名的map信息
     * @param key      微信密钥信息
     * @param signType 签名类型
     * @return
     * @throws Exception
     */
    public static String generateSignature(final Map<String, String> data, String key, SignType signType) throws Exception {
        String[] keyArray = sortKey(data);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals(WechatConstant.SIGN)) {
                continue;
            }
            if (data.get(k).trim().length() > 0) // 参数值为空，则不参与签名
                sb.append(k).append("=").append(data.get(k).trim()).append("&");
        }
        sb.append("key=").append(key);
        LogPortal.info("签名字符串：" + sb.toString());
        if (SignType.MD5.equals(signType)) {
            return MD5(sb.toString()).toUpperCase();
        } else if (SignType.HMACSHA256.equals(signType)) {
            return HMACSHA256(sb.toString(), key);
        } else {
            throw new Exception(String.format("Invalid sign_type: %s", signType));
        }
    }

    /**
     * 给map中的key进行排序
     *
     * @param data
     * @return
     */
    private static String[] sortKey(Map<String, String> data) {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        return keyArray;
    }

    /**
     * 生成 MD5
     *
     * @param data 待处理数据
     * @return MD5结果
     */
    public static String MD5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 生成 HMACSHA256
     *
     * @param data 待处理数据
     * @param key  密钥
     * @return 加密结果
     * @throws Exception
     */
    public static String HMACSHA256(String data, String key) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }
}

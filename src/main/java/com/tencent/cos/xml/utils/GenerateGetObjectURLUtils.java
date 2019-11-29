package com.tencent.cos.xml.utils;

import com.appsflyer.share.Constants;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.qcloud.core.auth.AuthConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class GenerateGetObjectURLUtils {

    public interface QCloudAPI {
        long getKeyDuration();

        String getSecretId();

        String getSecretKey();

        @Deprecated
        String getSessionToken();
    }

    public static String getObjectUrl(boolean z, String str, String str2, String str3, String str4) throws CosXmlClientException {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2) || StringUtils.isEmpty(str3) || StringUtils.isEmpty(str4)) {
            throw new CosXmlClientException("appid or bucket or or region or cosPath must not be null");
        }
        if (z) {
            sb.append("https");
            sb.append("://");
        } else {
            sb.append("http");
            sb.append("://");
        }
        if (str2.endsWith("-" + str)) {
            sb.append(str2);
            sb.append(".");
        } else {
            sb.append(str2);
            sb.append("-");
            sb.append(str);
            sb.append(".");
        }
        sb.append("cos");
        sb.append(".");
        sb.append(str3);
        sb.append(".");
        sb.append("myqcloud.com");
        if (!str4.startsWith(Constants.URL_PATH_DELIMITER)) {
            str4 = Constants.URL_PATH_DELIMITER + str4;
        }
        sb.append(URLEncodeUtils.cosPathEncode(str4));
        return sb.toString();
    }

    public static String getRequestUrlWithSign(boolean z, String str, Map<String, String> map, Map<String, String> map2, String str2, String str3, String str4, String str5, long j, QCloudAPI qCloudAPI) throws CosXmlClientException {
        StringBuilder sb = new StringBuilder();
        boolean z2 = z;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        String str9 = str5;
        sb.append(getObjectUrl(z, str2, str3, str4, str5));
        sb.append("?");
        sb.append(getSign(str, map, map2, str5, j, qCloudAPI));
        return sb.toString();
    }

    public static String getObjectUrlWithSign(boolean z, Map<String, String> map, Map<String, String> map2, String str, String str2, String str3, String str4, long j, QCloudAPI qCloudAPI) throws CosXmlClientException {
        StringBuilder sb = new StringBuilder();
        boolean z2 = z;
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        sb.append(getObjectUrl(z, str, str2, str3, str4));
        sb.append("?sign=");
        sb.append(URLEncodeUtils.cosPathEncode(getSign("get", map, map2, str4, j, qCloudAPI)));
        return sb.toString();
    }

    public static String getSign(String str, String str2, Map<String, String> map, Map<String, String> map2, String str3, String str4, String str5, String str6) throws CosXmlClientException {
        StringBuilder sb = new StringBuilder(str.trim().toLowerCase());
        sb.append("\n");
        if (!str2.startsWith(Constants.URL_PATH_DELIMITER)) {
            str2 = Constants.URL_PATH_DELIMITER + str2;
        }
        sb.append(str2);
        sb.append("\n");
        String[] sort = sort(map2, false);
        if (sort != null) {
            sb.append(sort[1]);
        }
        sb.append("\n");
        String[] sort2 = sort(map, true);
        if (map != null) {
            sb.append(sort2[1]);
        }
        sb.append("\n");
        String hmacSha1 = DigestUtils.getHmacSha1("sha1" + "\n" + str3 + "\n" + DigestUtils.getSha1(sb.toString()) + "\n", str6);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AuthConstants.Q_SIGN_ALGORITHM);
        sb2.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb2.append(AuthConstants.SHA1);
        sb2.append("&");
        sb2.append(AuthConstants.Q_AK);
        sb2.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb2.append(str5);
        sb2.append("&");
        sb2.append(AuthConstants.Q_SIGN_TIME);
        sb2.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb2.append(str3);
        sb2.append("&");
        sb2.append(AuthConstants.Q_KEY_TIME);
        sb2.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb2.append(str4);
        sb2.append("&");
        sb2.append(AuthConstants.Q_HEADER_LIST);
        sb2.append(SimpleComparison.EQUAL_TO_OPERATION);
        String str7 = "";
        sb2.append(sort2 != null ? sort2[0] : str7);
        sb2.append("&");
        sb2.append(AuthConstants.Q_URL_PARAM_LIST);
        sb2.append(SimpleComparison.EQUAL_TO_OPERATION);
        if (sort != null) {
            str7 = sort[0];
        }
        sb2.append(str7);
        sb2.append("&");
        sb2.append(AuthConstants.Q_SIGNATURE);
        sb2.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb2.append(hmacSha1);
        return sb2.toString();
    }

    private static String getSign(String str, Map<String, String> map, Map<String, String> map2, String str2, long j, QCloudAPI qCloudAPI) throws CosXmlClientException {
        String secretId = qCloudAPI.getSecretId();
        String secretKey = qCloudAPI.getSecretKey();
        long keyDuration = qCloudAPI.getKeyDuration();
        if (keyDuration <= 0) {
            keyDuration = j;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String str3 = currentTimeMillis + ";" + (keyDuration + currentTimeMillis);
        String hmacSha1 = DigestUtils.getHmacSha1(str3, secretKey);
        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
        return getSign(str, str2, map, map2, currentTimeMillis2 + ";" + (j + currentTimeMillis2), str3, secretId, hmacSha1);
    }

    private static String[] sort(Map<String, String> map, boolean z) throws CosXmlClientException {
        if (map == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (z) {
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put(((String) next.getKey()).toLowerCase().trim(), URLEncodeUtils.cosPathEncode(((String) next.getValue()).trim()));
            }
        } else {
            for (Map.Entry next2 : map.entrySet()) {
                linkedHashMap.put(((String) next2.getKey()).toLowerCase().trim(), ((String) next2.getValue()).toLowerCase().trim());
            }
        }
        ArrayList<Map.Entry> arrayList = new ArrayList<>(linkedHashMap.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, Object>>() {
            public int compare(Map.Entry<String, Object> entry, Map.Entry<String, Object> entry2) {
                return entry.getKey().compareTo(entry2.getKey());
            }
        });
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : arrayList) {
            sb.append((String) entry.getKey());
            sb.append(";");
            sb2.append((String) entry.getKey());
            sb2.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb2.append(entry.getValue());
            sb2.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb2.deleteCharAt(sb2.length() - 1);
        return new String[]{sb.toString(), sb2.toString()};
    }
}

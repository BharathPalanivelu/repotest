package com.tencent.qcloud.core.util;

import com.appsflyer.share.Constants;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class QCloudHttpUtils {
    public static String urlEncodeWithSlash(String str) {
        if (str == null || str.length() <= 0 || str.equals(Constants.URL_PATH_DELIMITER)) {
            return str;
        }
        String[] split = str.split(Constants.URL_PATH_DELIMITER);
        for (int i = 0; i < split.length; i++) {
            split[i] = urlEncodeString(split[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (String append : split) {
            sb.append(append);
            sb.append(Constants.URL_PATH_DELIMITER);
        }
        if (!str.endsWith(Constants.URL_PATH_DELIMITER)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static Map<String, List<String>> getDecodedQueryPair(URL url) {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (url.getQuery() != null) {
            for (String str2 : url.getQuery().split("&")) {
                int indexOf = str2.indexOf(SimpleComparison.EQUAL_TO_OPERATION);
                String urlDecodeString = indexOf > 0 ? urlDecodeString(str2.substring(0, indexOf)) : str2;
                if (!linkedHashMap.containsKey(urlDecodeString)) {
                    linkedHashMap.put(urlDecodeString, new LinkedList());
                }
                if (indexOf > 0) {
                    int i = indexOf + 1;
                    if (str2.length() > i) {
                        str = urlDecodeString(str2.substring(i));
                        ((List) linkedHashMap.get(urlDecodeString)).add(str);
                    }
                }
                str = null;
                ((List) linkedHashMap.get(urlDecodeString)).add(str);
            }
        }
        return linkedHashMap;
    }

    public static long[] parseContentRange(String str) {
        if (QCloudStringUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(SQLBuilder.BLANK);
        int indexOf = str.indexOf("-");
        int indexOf2 = str.indexOf(Constants.URL_PATH_DELIMITER);
        if (lastIndexOf == -1 || indexOf == -1 || indexOf2 == -1) {
            return null;
        }
        return new long[]{Long.parseLong(str.substring(lastIndexOf + 1, indexOf)), Long.parseLong(str.substring(indexOf + 1, indexOf2)), Long.parseLong(str.substring(indexOf2 + 1))};
    }

    public static String urlEncodeString(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String urlDecodeString(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String queryParametersString(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            if (!z) {
                sb.append("&");
            }
            sb.append(((String) next.getKey()) + SimpleComparison.EQUAL_TO_OPERATION + ((String) next.getValue()));
            z = false;
        }
        return sb.toString();
    }
}

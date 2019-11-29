package com.tencent.cos.xml.utils;

import com.appsflyer.share.Constants;
import com.tencent.cos.xml.exception.CosXmlClientException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncodeUtils {
    public static String cosPathEncode(String str) throws CosXmlClientException {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String[] split = str.split(Constants.URL_PATH_DELIMITER);
        int i = 0;
        while (i < split.length - 1) {
            try {
                sb.append(URLEncoder.encode(split[i], "utf-8"));
                sb.append(Constants.URL_PATH_DELIMITER);
                i++;
            } catch (UnsupportedEncodingException e2) {
                throw new CosXmlClientException((Throwable) e2);
            }
        }
        String str2 = "";
        if (!str.endsWith(Constants.URL_PATH_DELIMITER)) {
            if (split.length > 0) {
                str2 = URLEncoder.encode(split[split.length - 1], "utf-8");
            }
            sb.append(str2);
        } else {
            if (split.length > 0) {
                str2 = URLEncoder.encode(split[split.length - 1], "utf-8");
            }
            sb.append(str2);
            sb.append(Constants.URL_PATH_DELIMITER);
        }
        return sb.toString();
    }
}

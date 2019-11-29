package com.salesforce.android.chat.ui.internal.linkpreview;

import com.salesforce.android.service.common.http.HttpFactory;
import com.salesforce.android.service.common.http.HttpUrl;
import com.salesforce.android.service.common.http.HttpUrlBuilder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class URLHelper {
    private static final Pattern PATTERN_URL_ABSOLUTE = Pattern.compile("(?i)^http://|^https://");
    private static final Pattern PATTERN_URL_EXTRACT_DOMAIN_PATH = Pattern.compile("(?i)//([^/]+)((/[^/]*)*)");
    private static final Pattern PATTERN_URL_PROTOCOL_RELATIVE = Pattern.compile("(?i)^\\s*//([^/]*?)(/[^/]*?)*\\s*");
    private static final Pattern PATTERN_URL_RELATIVE = Pattern.compile("(?i)^\\s*(/[^/]*?)*\\s*");

    private URLHelper() {
    }

    static boolean isAbsolute(String str) {
        return PATTERN_URL_ABSOLUTE.matcher(str).find();
    }

    static boolean isRelative(String str) {
        return PATTERN_URL_RELATIVE.matcher(str).find();
    }

    static boolean isProtocolRelative(String str) {
        return PATTERN_URL_PROTOCOL_RELATIVE.matcher(str).find();
    }

    static String parseHost(String str) {
        Matcher matcher = PATTERN_URL_EXTRACT_DOMAIN_PATH.matcher(str);
        if (!matcher.find() || matcher.groupCount() <= 0) {
            return null;
        }
        return matcher.group(1);
    }

    static String parsePath(String str) {
        Matcher matcher = PATTERN_URL_EXTRACT_DOMAIN_PATH.matcher(str);
        if (!matcher.find() || matcher.groupCount() <= 1) {
            return null;
        }
        return matcher.group(2);
    }

    static String createAbsoluteUrl(String str, String str2, String str3) {
        HttpUrl build = HttpFactory.url().parse(str).build();
        if (isProtocolRelative(str2)) {
            str2 = str3 + str2;
        }
        HttpUrlBuilder newBuilder = build.newBuilder(str2);
        if (newBuilder == null) {
            return null;
        }
        return newBuilder.build().toString();
    }
}

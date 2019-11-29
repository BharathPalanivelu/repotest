package com.salesforce.android.chat.ui.internal.linkpreview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FaviconParser {
    private static final Pattern REGEX_HEAD_END = Pattern.compile("(?i)</head>");
    private static final Pattern REGEX_HEAD_START = Pattern.compile("(?i)<head");
    private static final Pattern REGEX_LINK_FAVICON = Pattern.compile("(?i)<link(\\s+\\w+=\"[^\"]+\")*?\\s*(?:rel=\"icon\"|rel=\"shortcut icon\")(\\s+\\w+=\"[^\"]+\")*?\\s*/?>");
    private static final Pattern REGEX_LINK_FAVICON_HREF = Pattern.compile("(?i)href=\"([^\"]+?)\"");
    private static final Pattern REGEX_LINK_SIZE = Pattern.compile("(?i)sizes=\"(\\d+)x(\\d+)");

    FaviconParser() {
    }

    /* access modifiers changed from: package-private */
    public String parse(String str) {
        if (str == null) {
            return null;
        }
        List<String> parseLinkElements = parseLinkElements(parseHead(str));
        if (parseLinkElements != null && parseLinkElements.size() > 0) {
            String parseFavIconHref = parseFavIconHref(pickFaviconLinkElement(parseLinkElements));
            if (parseFavIconHref != null) {
                return parseFavIconHref;
            }
        }
        return null;
    }

    private String parseFavIconHref(String str) {
        Matcher matcher = REGEX_LINK_FAVICON_HREF.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private String pickFaviconLinkElement(List<String> list) {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            Collections.sort(list, new Comparator<String>() {
                public int compare(String str, String str2) {
                    return FaviconParser.this.parseIconSize(str) - FaviconParser.this.parseIconSize(str2);
                }
            });
        }
        return list.get(list.size() - 1);
    }

    /* access modifiers changed from: private */
    public int parseIconSize(String str) {
        Matcher matcher = REGEX_LINK_SIZE.matcher(str);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }

    private List<String> parseLinkElements(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(5);
        Matcher matcher = REGEX_LINK_FAVICON.matcher(str);
        while (matcher.find()) {
            arrayList.add(matcher.group(0));
        }
        return arrayList;
    }

    private String parseHead(String str) {
        Matcher matcher = REGEX_HEAD_START.matcher(str);
        int start = matcher.find() ? matcher.start() : -1;
        Matcher matcher2 = REGEX_HEAD_END.matcher(str);
        int end = matcher2.find() ? matcher2.end() : -1;
        if (start <= -1 || end <= -1) {
            return null;
        }
        return str.substring(start, end);
    }
}

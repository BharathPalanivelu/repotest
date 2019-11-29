package com.salesforce.android.chat.ui.internal.linkpreview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class OGMetadataParser {
    private static final String OG_PROPERTY_DESC = "og:description";
    private static final String OG_PROPERTY_IMAGE = "og:image";
    private static final String OG_PROPERTY_TITLE = "og:title";
    private static final String OG_PROPERTY_URL = "og:url";
    private static final Pattern PATTERN_META_ELEMENT = Pattern.compile("(?i)(?:<meta\\s+[^>]*?(?:property=\\s*\"(og:title)\"|property=\\s*\"(og:description)\"|property=\\s*\"(og:url)\"|property=\\s*\"(og:image)\")[^>]*?>)");
    private static final Pattern PATTERN_OG_CONTENT_ATTRIBUTE = Pattern.compile("(?i)content\\s*=\\s*\"([^\"]+)\"");

    OGMetadataParser() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        if (r3.equals(OG_PROPERTY_TITLE) != false) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.salesforce.android.chat.ui.internal.linkpreview.OGMetadata parse(java.lang.String r10) {
        /*
            r9 = this;
            com.salesforce.android.chat.ui.internal.linkpreview.OGMetadata$Builder r0 = new com.salesforce.android.chat.ui.internal.linkpreview.OGMetadata$Builder
            r0.<init>()
            java.util.regex.Pattern r1 = PATTERN_META_ELEMENT
            java.util.regex.Matcher r10 = r1.matcher(r10)
        L_0x000b:
            boolean r1 = r10.find()
            if (r1 == 0) goto L_0x0072
            r1 = 0
            java.lang.String r2 = r10.group(r1)
            java.lang.String r3 = r9.findGroupMatch(r10)
            if (r3 != 0) goto L_0x001d
            goto L_0x000b
        L_0x001d:
            java.util.regex.Pattern r4 = PATTERN_OG_CONTENT_ATTRIBUTE
            java.lang.String r2 = r9.parseContentAttribute(r2, r4)
            r4 = -1
            int r5 = r3.hashCode()
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r5) {
                case -1137178311: goto L_0x004c;
                case -1127120330: goto L_0x0043;
                case -1020164915: goto L_0x0039;
                case 1029113178: goto L_0x002f;
                default: goto L_0x002e;
            }
        L_0x002e:
            goto L_0x0056
        L_0x002f:
            java.lang.String r1 = "og:description"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0056
            r1 = 1
            goto L_0x0057
        L_0x0039:
            java.lang.String r1 = "og:url"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0056
            r1 = 3
            goto L_0x0057
        L_0x0043:
            java.lang.String r5 = "og:title"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0056
            goto L_0x0057
        L_0x004c:
            java.lang.String r1 = "og:image"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0056
            r1 = 2
            goto L_0x0057
        L_0x0056:
            r1 = -1
        L_0x0057:
            if (r1 == 0) goto L_0x006e
            if (r1 == r8) goto L_0x006a
            if (r1 == r7) goto L_0x0066
            if (r1 == r6) goto L_0x0060
            goto L_0x000b
        L_0x0060:
            if (r2 == 0) goto L_0x000b
            r0.ogUrl(r2)
            goto L_0x000b
        L_0x0066:
            r0.ogImageUrl(r2)
            goto L_0x000b
        L_0x006a:
            r0.ogDescription(r2)
            goto L_0x000b
        L_0x006e:
            r0.ogTitle(r2)
            goto L_0x000b
        L_0x0072:
            com.salesforce.android.chat.ui.internal.linkpreview.OGMetadata r10 = r0.build()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.android.chat.ui.internal.linkpreview.OGMetadataParser.parse(java.lang.String):com.salesforce.android.chat.ui.internal.linkpreview.OGMetadata");
    }

    private String parseContentAttribute(String str, Pattern pattern) {
        if (str == null) {
            return null;
        }
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find() || matcher.groupCount() <= 0) {
            return null;
        }
        return matcher.group(1);
    }

    private String findGroupMatch(Matcher matcher) {
        for (int i = 1; i <= matcher.groupCount(); i++) {
            String group = matcher.group(i);
            if (group != null && !group.isEmpty()) {
                return group;
            }
        }
        return null;
    }
}

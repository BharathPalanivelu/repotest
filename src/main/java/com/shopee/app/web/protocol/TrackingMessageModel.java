package com.shopee.app.web.protocol;

import com.google.a.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class TrackingMessageModel {
    @c(a = "data")
    private final String data;
    @c(a = "pageId")
    private final String pageId;
    @c(a = "page_section")
    private final String pageSection;
    @c(a = "page_type")
    private final String pageType;
    @c(a = "target_type")
    private final String targetType;

    public TrackingMessageModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ TrackingMessageModel copy$default(TrackingMessageModel trackingMessageModel, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = trackingMessageModel.data;
        }
        if ((i & 2) != 0) {
            str2 = trackingMessageModel.pageType;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = trackingMessageModel.targetType;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = trackingMessageModel.pageId;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = trackingMessageModel.pageSection;
        }
        return trackingMessageModel.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.data;
    }

    public final String component2() {
        return this.pageType;
    }

    public final String component3() {
        return this.targetType;
    }

    public final String component4() {
        return this.pageId;
    }

    public final String component5() {
        return this.pageSection;
    }

    public final TrackingMessageModel copy(String str, String str2, String str3, String str4, String str5) {
        j.b(str, "data");
        j.b(str2, "pageType");
        j.b(str3, "targetType");
        j.b(str4, "pageId");
        j.b(str5, "pageSection");
        return new TrackingMessageModel(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackingMessageModel)) {
            return false;
        }
        TrackingMessageModel trackingMessageModel = (TrackingMessageModel) obj;
        return j.a((Object) this.data, (Object) trackingMessageModel.data) && j.a((Object) this.pageType, (Object) trackingMessageModel.pageType) && j.a((Object) this.targetType, (Object) trackingMessageModel.targetType) && j.a((Object) this.pageId, (Object) trackingMessageModel.pageId) && j.a((Object) this.pageSection, (Object) trackingMessageModel.pageSection);
    }

    public int hashCode() {
        String str = this.data;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.pageType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.targetType;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.pageId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.pageSection;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "TrackingMessageModel(data=" + this.data + ", pageType=" + this.pageType + ", targetType=" + this.targetType + ", pageId=" + this.pageId + ", pageSection=" + this.pageSection + SQLBuilder.PARENTHESES_RIGHT;
    }

    public TrackingMessageModel(String str, String str2, String str3, String str4, String str5) {
        j.b(str, "data");
        j.b(str2, "pageType");
        j.b(str3, "targetType");
        j.b(str4, "pageId");
        j.b(str5, "pageSection");
        this.data = str;
        this.pageType = str2;
        this.targetType = str3;
        this.pageId = str4;
        this.pageSection = str5;
    }

    public final String getData() {
        return this.data;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final String getTargetType() {
        return this.targetType;
    }

    public final String getPageId() {
        return this.pageId;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TrackingMessageModel(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, d.d.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x0008
            r11 = r0
            goto L_0x0009
        L_0x0008:
            r11 = r5
        L_0x0009:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r6
        L_0x0010:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r7
        L_0x0017:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r8
        L_0x001e:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0024
            r10 = r0
            goto L_0x0025
        L_0x0024:
            r10 = r9
        L_0x0025:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.web.protocol.TrackingMessageModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, d.d.b.g):void");
    }

    public final String getPageSection() {
        return this.pageSection;
    }
}

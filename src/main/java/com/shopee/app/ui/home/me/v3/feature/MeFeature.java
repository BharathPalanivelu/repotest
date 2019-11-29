package com.shopee.app.ui.home.me.v3.feature;

import com.google.a.a.c;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.tracking.impression.a;
import d.d.b.j;
import java.util.List;

public class MeFeature implements a {
    @c(a = "display_name")
    private final String displayName;
    private String group;
    private int groupLocation;
    private final String icon;
    private int inGroupLocation;
    private boolean isSubFeature;
    private final String name;
    @c(a = "new_badge")
    private final int newBadge;
    @c(a = "new_badge_end_time")
    private final long newBadgeEndTime;
    @c(a = "non_login_access")
    private final int nonLoginAccess;
    @c(a = "redirect_url")
    private final String redirectUrl;
    @c(a = "sub_features")
    private final m subFeatures;
    private int systemLocation;

    public MeFeature(String str, String str2, int i, long j, String str3, String str4, int i2, m mVar, String str5, int i3, int i4, int i5, boolean z) {
        j.b(str, "group");
        j.b(str2, "name");
        j.b(str4, "displayName");
        j.b(str5, "icon");
        this.group = str;
        this.name = str2;
        this.newBadge = i;
        this.newBadgeEndTime = j;
        this.redirectUrl = str3;
        this.displayName = str4;
        this.nonLoginAccess = i2;
        this.subFeatures = mVar;
        this.icon = str5;
        this.groupLocation = i3;
        this.inGroupLocation = i4;
        this.systemLocation = i5;
        this.isSubFeature = z;
    }

    public final String getGroup() {
        return this.group;
    }

    public final void setGroup(String str) {
        j.b(str, "<set-?>");
        this.group = str;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNewBadge() {
        return this.newBadge;
    }

    public final long getNewBadgeEndTime() {
        return this.newBadgeEndTime;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final int getNonLoginAccess() {
        return this.nonLoginAccess;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MeFeature(java.lang.String r19, java.lang.String r20, int r21, long r22, java.lang.String r24, java.lang.String r25, int r26, com.shopee.app.ui.home.me.v3.feature.m r27, java.lang.String r28, int r29, int r30, int r31, boolean r32, int r33, d.d.b.g r34) {
        /*
            r18 = this;
            r0 = r33
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r6 = 0
            goto L_0x000b
        L_0x0009:
            r6 = r21
        L_0x000b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0013
            r3 = 0
            r7 = r3
            goto L_0x0015
        L_0x0013:
            r7 = r22
        L_0x0015:
            r1 = r0 & 16
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x001d
            r9 = r3
            goto L_0x001f
        L_0x001d:
            r9 = r24
        L_0x001f:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0026
            r10 = r20
            goto L_0x0028
        L_0x0026:
            r10 = r25
        L_0x0028:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002e
            r11 = 0
            goto L_0x0030
        L_0x002e:
            r11 = r26
        L_0x0030:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0039
            r1 = 0
            com.shopee.app.ui.home.me.v3.feature.m r1 = (com.shopee.app.ui.home.me.v3.feature.m) r1
            r12 = r1
            goto L_0x003b
        L_0x0039:
            r12 = r27
        L_0x003b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0041
            r13 = r3
            goto L_0x0043
        L_0x0041:
            r13 = r28
        L_0x0043:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0049
            r14 = 0
            goto L_0x004b
        L_0x0049:
            r14 = r29
        L_0x004b:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0051
            r15 = 0
            goto L_0x0053
        L_0x0051:
            r15 = r30
        L_0x0053:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x005a
            r16 = 0
            goto L_0x005c
        L_0x005a:
            r16 = r31
        L_0x005c:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0063
            r17 = 0
            goto L_0x0065
        L_0x0063:
            r17 = r32
        L_0x0065:
            r3 = r18
            r4 = r19
            r5 = r20
            r3.<init>(r4, r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.home.me.v3.feature.MeFeature.<init>(java.lang.String, java.lang.String, int, long, java.lang.String, java.lang.String, int, com.shopee.app.ui.home.me.v3.feature.m, java.lang.String, int, int, int, boolean, int, d.d.b.g):void");
    }

    public final m getSubFeatures() {
        return this.subFeatures;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getGroupLocation() {
        return this.groupLocation;
    }

    public final void setGroupLocation(int i) {
        this.groupLocation = i;
    }

    public final int getInGroupLocation() {
        return this.inGroupLocation;
    }

    public final void setInGroupLocation(int i) {
        this.inGroupLocation = i;
    }

    public final int getSystemLocation() {
        return this.systemLocation;
    }

    public final void setSystemLocation(int i) {
        this.systemLocation = i;
    }

    public final boolean isSubFeature() {
        return this.isSubFeature;
    }

    public final void setSubFeature(boolean z) {
        this.isSubFeature = z;
    }

    public String getTrackingImpressionId() {
        return this.name;
    }

    public o getTrackingImpressionData() {
        o oVar = new o();
        if (this.isSubFeature) {
            oVar.a("group_name", this.group);
            oVar.a("system_name", this.name);
            oVar.a("circle_system_name", this.name);
            oVar.a("circle_location", (Number) Integer.valueOf(this.inGroupLocation));
        } else {
            oVar.a("group_name", this.group);
            oVar.a("in_group_location", (Number) Integer.valueOf(this.inGroupLocation));
            oVar.a("group_location", (Number) Integer.valueOf(this.groupLocation));
            oVar.a("system_location", (Number) Integer.valueOf(this.systemLocation));
            oVar.a("system_name", this.name);
            m mVar = this.subFeatures;
            if (mVar != null) {
                List<MeFeature> b2 = mVar.b();
                if (b2 != null) {
                    i iVar = new i();
                    for (MeFeature trackingImpressionData : b2) {
                        iVar.a((l) trackingImpressionData.getTrackingImpressionData());
                    }
                    oVar.a("sub_features", (l) iVar);
                }
            }
        }
        return oVar;
    }

    public String toString() {
        return "MeFeature(group='" + this.group + "', " + "name='" + this.name + "', " + "newBadge=" + this.newBadge + ", " + "newBadgeEndTime=" + this.newBadgeEndTime + ", " + "redirectUrl='" + this.redirectUrl + "', " + "displayName='" + this.displayName + "', " + "nonLoginAccess=" + this.nonLoginAccess + ", " + "icon='" + this.icon + "')";
    }
}

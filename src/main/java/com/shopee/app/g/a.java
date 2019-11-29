package com.shopee.app.g;

import android.app.Activity;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.ActionContentInfo;
import com.shopee.app.util.ak;
import com.shopee.navigator.NavigationPath;
import com.shopee.navigator.e;

public class a {
    public static void a(ActionContentInfo actionContentInfo, ak akVar, e eVar, SettingConfigStore settingConfigStore) {
        if (!TextUtils.isEmpty(actionContentInfo.getApprl())) {
            eVar.a((Activity) akVar.a(), NavigationPath.a(actionContentInfo.getApprl()));
            return;
        }
        boolean z = true;
        switch (actionContentInfo.getActionRedirectType()) {
            case 1:
                akVar.b(actionContentInfo.getOrderId(), actionContentInfo.getShopId());
                return;
            case 2:
                akVar.h();
                return;
            case 3:
                akVar.F();
                return;
            case 4:
                if (actionContentInfo.getShopId() != ((Integer) com.shopee.app.data.store.ak.a().i().b(0)).intValue()) {
                    z = false;
                }
                akVar.a(z, actionContentInfo.getReturnId());
                return;
            case 5:
                if (actionContentInfo.getShopId() != ((Integer) com.shopee.app.data.store.ak.a().i().b(0)).intValue()) {
                    z = false;
                }
                akVar.a(actionContentInfo.getShopId(), actionContentInfo.getOrderId(), z);
                return;
            case 6:
                akVar.f(3);
                return;
            case 7:
                if (actionContentInfo.getShopId() != ((Integer) com.shopee.app.data.store.ak.a().i().b(0)).intValue()) {
                    z = false;
                }
                akVar.a(z, actionContentInfo.getRefundId(), 7);
                return;
            case 8:
                if (actionContentInfo.getShopId() != ((Integer) com.shopee.app.data.store.ak.a().i().b(0)).intValue()) {
                    z = false;
                }
                akVar.a(z, actionContentInfo.getRefundId(), 8);
                return;
            case 10:
                if (!TextUtils.isEmpty(actionContentInfo.getActionRedirectUrl())) {
                    akVar.a(actionContentInfo.getActionRedirectUrl());
                    return;
                }
                return;
            case 11:
                akVar.a(1, actionContentInfo.getCheckoutId());
                return;
            case 12:
                akVar.u();
                return;
            case 13:
                akVar.a(actionContentInfo.getCheckoutId(), actionContentInfo.getOrderId(), actionContentInfo.getShopId());
                return;
            case 16:
                akVar.a(actionContentInfo.getShopId(), actionContentInfo.getBuyerId(), actionContentInfo.getOrderId());
                return;
            case 18:
                akVar.b(actionContentInfo.getShopId(), actionContentInfo.getItemId());
                return;
            case 19:
                akVar.b(actionContentInfo.getCheckoutId());
                return;
            case 20:
                akVar.j();
                return;
            case 21:
                akVar.J();
                return;
            case 22:
                b(actionContentInfo, akVar, settingConfigStore);
                return;
            case 23:
                akVar.R();
                return;
            case 25:
                a(actionContentInfo, akVar, settingConfigStore);
                return;
            default:
                return;
        }
    }

    private static void a(ActionContentInfo actionContentInfo, ak akVar, SettingConfigStore settingConfigStore) {
        String actionReactNativePath = actionContentInfo.getActionReactNativePath();
        if (!TextUtils.isEmpty(actionReactNativePath)) {
            String[] split = actionReactNativePath.split("\\?");
            akVar.a(split[0].split(Constants.URL_PATH_DELIMITER)[1], split.length == 2 ? split[1] : "", "action");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(com.shopee.app.data.viewmodel.ActionContentInfo r7, com.shopee.app.util.ak r8, com.shopee.app.data.store.SettingConfigStore r9) {
        /*
            java.lang.String r0 = r7.getActionAppPath()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            java.lang.String r7 = r7.getActionAppPath()
            java.lang.String r0 = "\\?"
            java.lang.String[] r0 = r7.split(r0)
            r1 = 0
            r2 = r0[r1]
            r3 = -1
            int r4 = r2.hashCode()
            r5 = 4
            r6 = 1
            switch(r4) {
                case -1411104225: goto L_0x0080;
                case -486619363: goto L_0x0076;
                case 3480: goto L_0x006b;
                case 3052376: goto L_0x0061;
                case 595233003: goto L_0x0056;
                case 1434631203: goto L_0x004c;
                case 1437158422: goto L_0x0042;
                case 1469946593: goto L_0x0038;
                case 1573631039: goto L_0x002e;
                case 1600931328: goto L_0x0024;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x008a
        L_0x0024:
            java.lang.String r4 = "socialAccount"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x008a
            r2 = 3
            goto L_0x008b
        L_0x002e:
            java.lang.String r4 = "editProfile"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x008a
            r2 = 2
            goto L_0x008b
        L_0x0038:
            java.lang.String r4 = "myAccount"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x008a
            r2 = 1
            goto L_0x008b
        L_0x0042:
            java.lang.String r4 = "chatList"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x008a
            r2 = 0
            goto L_0x008b
        L_0x004c:
            java.lang.String r4 = "settings"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x008a
            r2 = 4
            goto L_0x008b
        L_0x0056:
            java.lang.String r4 = "notification"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x008a
            r2 = 8
            goto L_0x008b
        L_0x0061:
            java.lang.String r4 = "chat"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x008a
            r2 = 7
            goto L_0x008b
        L_0x006b:
            java.lang.String r4 = "me"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x008a
            r2 = 9
            goto L_0x008b
        L_0x0076:
            java.lang.String r4 = "homeFeed"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x008a
            r2 = 5
            goto L_0x008b
        L_0x0080:
            java.lang.String r4 = "sellerAssistant"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x008a
            r2 = 6
            goto L_0x008b
        L_0x008a:
            r2 = -1
        L_0x008b:
            java.lang.String r3 = "="
            switch(r2) {
                case 0: goto L_0x0117;
                case 1: goto L_0x0113;
                case 2: goto L_0x010f;
                case 3: goto L_0x010b;
                case 4: goto L_0x0103;
                case 5: goto L_0x00fd;
                case 6: goto L_0x00f9;
                case 7: goto L_0x00c5;
                case 8: goto L_0x0097;
                case 9: goto L_0x0092;
                default: goto L_0x0090;
            }
        L_0x0090:
            goto L_0x011a
        L_0x0092:
            r8.i((java.lang.String) r7)
            goto L_0x011a
        L_0x0097:
            int r7 = r0.length
            if (r7 <= r6) goto L_0x00c1
            r7 = r0[r6]
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00c1
            r7 = r0[r6]
            java.lang.String[] r7 = r7.split(r3)
            int r9 = r7.length
            if (r9 <= 0) goto L_0x00c1
            r9 = r7[r6]
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x00c1
            r7 = r7[r6]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            int r7 = r7.intValue()
            a(r8, r7)
            return
        L_0x00c1:
            a(r8, r5)
            goto L_0x011a
        L_0x00c5:
            int r7 = r0.length
            if (r7 <= r6) goto L_0x00ee
            r7 = r0[r6]
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00ee
            r7 = r0[r6]
            java.lang.String[] r7 = r7.split(r3)
            int r9 = r7.length
            if (r9 <= r6) goto L_0x00ee
            r9 = r7[r6]
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x00ee
            r7 = r7[r6]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            int r1 = r7.intValue()
            r7 = r1
            r1 = 1
            goto L_0x00ef
        L_0x00ee:
            r7 = 0
        L_0x00ef:
            if (r1 == 0) goto L_0x00f5
            r8.d((int) r7)
            goto L_0x011a
        L_0x00f5:
            r8.e()
            goto L_0x011a
        L_0x00f9:
            r8.p()
            goto L_0x011a
        L_0x00fd:
            java.lang.String r7 = "home"
            r8.i((java.lang.String) r7)
            goto L_0x011a
        L_0x0103:
            boolean r7 = r9.showUpgrade()
            r8.a((boolean) r7)
            goto L_0x011a
        L_0x010b:
            r8.T()
            goto L_0x011a
        L_0x010f:
            r8.t()
            goto L_0x011a
        L_0x0113:
            r8.R()
            goto L_0x011a
        L_0x0117:
            r8.e()
        L_0x011a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.g.a.b(com.shopee.app.data.viewmodel.ActionContentInfo, com.shopee.app.util.ak, com.shopee.app.data.store.SettingConfigStore):void");
    }

    private static void a(ak akVar, int i) {
        akVar.e(i);
    }
}

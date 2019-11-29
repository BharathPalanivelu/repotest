package com.shopee.app.util;

import android.graphics.drawable.Drawable;
import com.garena.android.appkit.tools.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.id.R;

public class bn {
    public static String a(int i, boolean z) {
        char c2;
        int hashCode = "ID".hashCode();
        if (hashCode != 2331) {
            if (!(hashCode == 2476 || hashCode == 2552 || hashCode == 2644 || hashCode == 2676)) {
            }
            c2 = 65535;
        } else {
            c2 = 0;
        }
        int i2 = R.string.sp_my_wallet;
        if (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3) {
            if (i == 1 && z) {
                i2 = R.string.my_wallet_shopee_pay;
            }
        } else if (c2 == 4) {
            i2 = (i != 2 || !z) ? R.string.sp_my_wallet_entry_title_TH : R.string.sp_my_airpay_wallet;
        } else if (c2 == 5 && i == 2 && z) {
            i2 = R.string.sp_wallet_shopee_balance;
        }
        return b.e(i2);
    }

    public static Drawable b(int i, boolean z) {
        int hashCode = "ID".hashCode();
        return b.f(R.drawable.ic_me_wallet);
    }

    public static Drawable c(int i, boolean z) {
        int hashCode = "ID".hashCode();
        return b.f(R.drawable.ic_me_seller_balance);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0039, code lost:
        if (r7 == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0055, code lost:
        if (r7 != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0062, code lost:
        if (r7 != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d(int r6, boolean r7) {
        /*
            java.lang.String r0 = "ID"
            int r0 = r0.hashCode()
            r1 = 2331(0x91b, float:3.266E-42)
            if (r0 == r1) goto L_0x001e
            r1 = 2476(0x9ac, float:3.47E-42)
            if (r0 == r1) goto L_0x001c
            r1 = 2552(0x9f8, float:3.576E-42)
            if (r0 == r1) goto L_0x001c
            r1 = 2644(0xa54, float:3.705E-42)
            if (r0 == r1) goto L_0x001c
            r1 = 2676(0xa74, float:3.75E-42)
            if (r0 == r1) goto L_0x001c
            r1 = 2744(0xab8, float:3.845E-42)
        L_0x001c:
            r0 = -1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            r1 = 2131889326(0x7f120cae, float:1.9413312E38)
            r2 = 1
            r3 = 2131888651(0x7f120a0b, float:1.9411943E38)
            if (r0 == 0) goto L_0x0060
            if (r0 == r2) goto L_0x0058
            r4 = 2
            if (r0 == r4) goto L_0x0053
            r5 = 3
            if (r0 == r5) goto L_0x0047
            r5 = 4
            if (r0 == r5) goto L_0x003f
            r4 = 5
            if (r0 == r4) goto L_0x0037
            goto L_0x0065
        L_0x0037:
            if (r6 != r2) goto L_0x0065
            if (r7 == 0) goto L_0x0065
        L_0x003b:
            r3 = 2131889326(0x7f120cae, float:1.9413312E38)
            goto L_0x0065
        L_0x003f:
            if (r6 != r4) goto L_0x0065
            if (r7 == 0) goto L_0x0065
            r3 = 2131889329(0x7f120cb1, float:1.9413318E38)
            goto L_0x0065
        L_0x0047:
            if (r6 != r4) goto L_0x004c
            if (r7 == 0) goto L_0x004c
            goto L_0x003b
        L_0x004c:
            r1 = 2131888653(0x7f120a0d, float:1.9411947E38)
            r3 = 2131888653(0x7f120a0d, float:1.9411947E38)
            goto L_0x0065
        L_0x0053:
            if (r6 != r2) goto L_0x0065
            if (r7 == 0) goto L_0x0065
            goto L_0x003b
        L_0x0058:
            if (r6 != r2) goto L_0x0065
            if (r7 == 0) goto L_0x0065
            r3 = 2131889327(0x7f120caf, float:1.9413314E38)
            goto L_0x0065
        L_0x0060:
            if (r6 != r2) goto L_0x0065
            if (r7 == 0) goto L_0x0065
            goto L_0x003b
        L_0x0065:
            java.lang.String r6 = com.garena.android.appkit.tools.b.e(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.util.bn.d(int, boolean):java.lang.String");
    }

    public static String e(int i, boolean z) {
        char c2;
        String str;
        int hashCode = "ID".hashCode();
        if (hashCode != 2331) {
            if (!(hashCode == 2476 || hashCode == 2552 || hashCode == 2644)) {
            }
            c2 = 65535;
        } else {
            c2 = 0;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        if (c2 != 4 || i != 1 || !z) {
                            return "WALLET";
                        }
                        str = "WALLET_SG";
                    } else if (i != 1 || !z) {
                        return "WALLET";
                    } else {
                        str = "WALLET_PH";
                    }
                } else if (i != 2 || !z) {
                    return "WALLET";
                } else {
                    str = "WALLET_TH";
                }
            } else if (i != 1 || !z) {
                return "WALLET";
            } else {
                str = "WALLET_MY";
            }
        } else if (i != 1 || !z) {
            return "WALLET";
        } else {
            str = "WALLET_ID";
        }
        return str;
    }

    public static String a(long j, int i, boolean z) {
        return au.b(j);
    }

    public static boolean a(UserInfo userInfo, int i, boolean z) {
        return (userInfo.isLoggedIn() && userInfo.isWalletFeatureOn()) || !userInfo.isLoggedIn();
    }
}

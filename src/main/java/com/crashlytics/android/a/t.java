package com.crashlytics.android.a;

import android.os.Bundle;
import com.crashlytics.android.a.ad;
import com.facebook.GraphResponse;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.a.a.a.c;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class t {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f6362a = new HashSet(Arrays.asList(new String[]{"app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "screen_view", "firebase_extra_parameter"}));

    public s a(ad adVar) {
        Bundle bundle;
        String str;
        boolean z = true;
        boolean z2 = ad.b.CUSTOM.equals(adVar.f6285c) && adVar.f6287e != null;
        boolean z3 = ad.b.PREDEFINED.equals(adVar.f6285c) && adVar.f6289g != null;
        if (!z2 && !z3) {
            return null;
        }
        if (z3) {
            bundle = b(adVar);
        } else {
            bundle = new Bundle();
            if (adVar.f6288f != null) {
                a(bundle, adVar.f6288f);
            }
        }
        if (z3) {
            String str2 = (String) adVar.h.get(GraphResponse.SUCCESS_KEY);
            if (str2 == null || Boolean.parseBoolean(str2)) {
                z = false;
            }
            str = a(adVar.f6289g, z);
        } else {
            str = a(adVar.f6287e);
        }
        c.h().a("Answers", "Logging event into firebase...");
        return new s(str, bundle);
    }

    private String a(String str) {
        if (str == null || str.length() == 0) {
            return "fabric_unnamed_event";
        }
        if (f6362a.contains(str)) {
            return "fabric_" + str;
        }
        String replaceAll = str.replaceAll("[^\\p{Alnum}_]+", "_");
        if (replaceAll.startsWith("ga_") || replaceAll.startsWith("google_") || replaceAll.startsWith("firebase_") || !Character.isLetter(replaceAll.charAt(0))) {
            replaceAll = "fabric_" + replaceAll;
        }
        return replaceAll.length() > 40 ? replaceAll.substring(0, 40) : replaceAll;
    }

    private String b(String str) {
        if (str == null || str.length() == 0) {
            return "fabric_unnamed_parameter";
        }
        String replaceAll = str.replaceAll("[^\\p{Alnum}_]+", "_");
        if (replaceAll.startsWith("ga_") || replaceAll.startsWith("google_") || replaceAll.startsWith("firebase_") || !Character.isLetter(replaceAll.charAt(0))) {
            replaceAll = "fabric_" + replaceAll;
        }
        return replaceAll.length() > 40 ? replaceAll.substring(0, 40) : replaceAll;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005c, code lost:
        if (r11.equals(com.google.android.gms.analytics.ecommerce.ProductAction.ACTION_PURCHASE) != false) goto L_0x00ca;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r11, boolean r12) {
        /*
            r10 = this;
            r0 = 0
            java.lang.String r1 = "purchase"
            java.lang.String r2 = "signUp"
            r3 = -1
            r4 = 2
            r5 = 1
            java.lang.String r6 = "login"
            if (r12 == 0) goto L_0x0049
            int r12 = r11.hashCode()
            r7 = -902468296(0xffffffffca356d38, float:-2972494.0)
            if (r12 == r7) goto L_0x0030
            r7 = 103149417(0x625ef69, float:3.1208942E-35)
            if (r12 == r7) goto L_0x0028
            r7 = 1743324417(0x67e90501, float:2.2008074E24)
            if (r12 == r7) goto L_0x0020
            goto L_0x0038
        L_0x0020:
            boolean r12 = r11.equals(r1)
            if (r12 == 0) goto L_0x0038
            r12 = 0
            goto L_0x0039
        L_0x0028:
            boolean r12 = r11.equals(r6)
            if (r12 == 0) goto L_0x0038
            r12 = 2
            goto L_0x0039
        L_0x0030:
            boolean r12 = r11.equals(r2)
            if (r12 == 0) goto L_0x0038
            r12 = 1
            goto L_0x0039
        L_0x0038:
            r12 = -1
        L_0x0039:
            if (r12 == 0) goto L_0x0046
            if (r12 == r5) goto L_0x0043
            if (r12 == r4) goto L_0x0040
            goto L_0x0049
        L_0x0040:
            java.lang.String r11 = "failed_login"
            return r11
        L_0x0043:
            java.lang.String r11 = "failed_sign_up"
            return r11
        L_0x0046:
            java.lang.String r11 = "failed_ecommerce_purchase"
            return r11
        L_0x0049:
            int r12 = r11.hashCode()
            java.lang.String r7 = "share"
            java.lang.String r8 = "search"
            java.lang.String r9 = "invite"
            switch(r12) {
                case -2131650889: goto L_0x00be;
                case -1183699191: goto L_0x00b5;
                case -938102371: goto L_0x00ab;
                case -906336856: goto L_0x00a3;
                case -902468296: goto L_0x009b;
                case -389087554: goto L_0x0091;
                case 23457852: goto L_0x0087;
                case 103149417: goto L_0x007e;
                case 109400031: goto L_0x0076;
                case 196004670: goto L_0x006b;
                case 1664021448: goto L_0x0060;
                case 1743324417: goto L_0x0058;
                default: goto L_0x0056;
            }
        L_0x0056:
            goto L_0x00c9
        L_0x0058:
            boolean r12 = r11.equals(r1)
            if (r12 == 0) goto L_0x00c9
            goto L_0x00ca
        L_0x0060:
            java.lang.String r12 = "startCheckout"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x00c9
            r0 = 2
            goto L_0x00ca
        L_0x006b:
            java.lang.String r12 = "levelStart"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x00c9
            r0 = 10
            goto L_0x00ca
        L_0x0076:
            boolean r12 = r11.equals(r7)
            if (r12 == 0) goto L_0x00c9
            r0 = 5
            goto L_0x00ca
        L_0x007e:
            boolean r12 = r11.equals(r6)
            if (r12 == 0) goto L_0x00c9
            r0 = 8
            goto L_0x00ca
        L_0x0087:
            java.lang.String r12 = "addToCart"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x00c9
            r0 = 1
            goto L_0x00ca
        L_0x0091:
            java.lang.String r12 = "contentView"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x00c9
            r0 = 3
            goto L_0x00ca
        L_0x009b:
            boolean r12 = r11.equals(r2)
            if (r12 == 0) goto L_0x00c9
            r0 = 7
            goto L_0x00ca
        L_0x00a3:
            boolean r12 = r11.equals(r8)
            if (r12 == 0) goto L_0x00c9
            r0 = 4
            goto L_0x00ca
        L_0x00ab:
            java.lang.String r12 = "rating"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x00c9
            r0 = 6
            goto L_0x00ca
        L_0x00b5:
            boolean r12 = r11.equals(r9)
            if (r12 == 0) goto L_0x00c9
            r0 = 9
            goto L_0x00ca
        L_0x00be:
            java.lang.String r12 = "levelEnd"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x00c9
            r0 = 11
            goto L_0x00ca
        L_0x00c9:
            r0 = -1
        L_0x00ca:
            switch(r0) {
                case 0: goto L_0x00eb;
                case 1: goto L_0x00e8;
                case 2: goto L_0x00e5;
                case 3: goto L_0x00e2;
                case 4: goto L_0x00e1;
                case 5: goto L_0x00e0;
                case 6: goto L_0x00dd;
                case 7: goto L_0x00da;
                case 8: goto L_0x00d9;
                case 9: goto L_0x00d8;
                case 10: goto L_0x00d5;
                case 11: goto L_0x00d2;
                default: goto L_0x00cd;
            }
        L_0x00cd:
            java.lang.String r11 = r10.a((java.lang.String) r11)
            return r11
        L_0x00d2:
            java.lang.String r11 = "level_end"
            return r11
        L_0x00d5:
            java.lang.String r11 = "level_start"
            return r11
        L_0x00d8:
            return r9
        L_0x00d9:
            return r6
        L_0x00da:
            java.lang.String r11 = "sign_up"
            return r11
        L_0x00dd:
            java.lang.String r11 = "rate_content"
            return r11
        L_0x00e0:
            return r7
        L_0x00e1:
            return r8
        L_0x00e2:
            java.lang.String r11 = "select_content"
            return r11
        L_0x00e5:
            java.lang.String r11 = "begin_checkout"
            return r11
        L_0x00e8:
            java.lang.String r11 = "add_to_cart"
            return r11
        L_0x00eb:
            java.lang.String r11 = "ecommerce_purchase"
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.a.t.a(java.lang.String, boolean):java.lang.String");
    }

    private Bundle b(ad adVar) {
        Bundle bundle = new Bundle();
        if (ProductAction.ACTION_PURCHASE.equals(adVar.f6289g)) {
            a(bundle, "item_id", (String) adVar.h.get("itemId"));
            a(bundle, "item_name", (String) adVar.h.get("itemName"));
            a(bundle, "item_category", (String) adVar.h.get("itemType"));
            a(bundle, AppMeasurementSdk.ConditionalUserProperty.VALUE, b(adVar.h.get("itemPrice")));
            a(bundle, "currency", (String) adVar.h.get("currency"));
        } else if ("addToCart".equals(adVar.f6289g)) {
            a(bundle, "item_id", (String) adVar.h.get("itemId"));
            a(bundle, "item_name", (String) adVar.h.get("itemName"));
            a(bundle, "item_category", (String) adVar.h.get("itemType"));
            a(bundle, "price", b(adVar.h.get("itemPrice")));
            a(bundle, AppMeasurementSdk.ConditionalUserProperty.VALUE, b(adVar.h.get("itemPrice")));
            a(bundle, "currency", (String) adVar.h.get("currency"));
            bundle.putLong("quantity", 1);
        } else if ("startCheckout".equals(adVar.f6289g)) {
            a(bundle, "quantity", Long.valueOf((long) ((Integer) adVar.h.get("itemCount")).intValue()));
            a(bundle, AppMeasurementSdk.ConditionalUserProperty.VALUE, b(adVar.h.get("totalPrice")));
            a(bundle, "currency", (String) adVar.h.get("currency"));
        } else if ("contentView".equals(adVar.f6289g)) {
            a(bundle, "content_type", (String) adVar.h.get("contentType"));
            a(bundle, "item_id", (String) adVar.h.get("contentId"));
            a(bundle, "item_name", (String) adVar.h.get("contentName"));
        } else if ("search".equals(adVar.f6289g)) {
            a(bundle, "search_term", (String) adVar.h.get(SearchIntents.EXTRA_QUERY));
        } else if (ShareDialog.WEB_SHARE_DIALOG.equals(adVar.f6289g)) {
            a(bundle, "method", (String) adVar.h.get("method"));
            a(bundle, "content_type", (String) adVar.h.get("contentType"));
            a(bundle, "item_id", (String) adVar.h.get("contentId"));
            a(bundle, "item_name", (String) adVar.h.get("contentName"));
        } else if ("rating".equals(adVar.f6289g)) {
            a(bundle, "rating", String.valueOf(adVar.h.get("rating")));
            a(bundle, "content_type", (String) adVar.h.get("contentType"));
            a(bundle, "item_id", (String) adVar.h.get("contentId"));
            a(bundle, "item_name", (String) adVar.h.get("contentName"));
        } else if ("signUp".equals(adVar.f6289g)) {
            a(bundle, "method", (String) adVar.h.get("method"));
        } else if ("login".equals(adVar.f6289g)) {
            a(bundle, "method", (String) adVar.h.get("method"));
        } else if ("invite".equals(adVar.f6289g)) {
            a(bundle, "method", (String) adVar.h.get("method"));
        } else if ("levelStart".equals(adVar.f6289g)) {
            a(bundle, "level_name", (String) adVar.h.get("levelName"));
        } else if ("levelEnd".equals(adVar.f6289g)) {
            a(bundle, "score", a(adVar.h.get("score")));
            a(bundle, "level_name", (String) adVar.h.get("levelName"));
            a(bundle, GraphResponse.SUCCESS_KEY, c((String) adVar.h.get(GraphResponse.SUCCESS_KEY)));
        }
        a(bundle, adVar.f6288f);
        return bundle;
    }

    private void a(Bundle bundle, String str, Long l) {
        if (l != null) {
            bundle.putLong(str, l.longValue());
        }
    }

    private void a(Bundle bundle, String str, Integer num) {
        if (num != null) {
            bundle.putInt(str, num.intValue());
        }
    }

    private void a(Bundle bundle, String str, String str2) {
        if (str2 != null) {
            bundle.putString(str, str2);
        }
    }

    private void a(Bundle bundle, String str, Double d2) {
        Double a2 = a((Object) d2);
        if (a2 != null) {
            bundle.putDouble(str, a2.doubleValue());
        }
    }

    private Double a(Object obj) {
        String valueOf = String.valueOf(obj);
        if (valueOf == null) {
            return null;
        }
        return Double.valueOf(valueOf);
    }

    private Integer c(String str) {
        if (str == null) {
            return null;
        }
        return Integer.valueOf(str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) ? 1 : 0);
    }

    private Double b(Object obj) {
        Long l = (Long) obj;
        if (l == null) {
            return null;
        }
        return Double.valueOf(new BigDecimal(l.longValue()).divide(a.f6276a).doubleValue());
    }

    private void a(Bundle bundle, Map<String, Object> map) {
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            String b2 = b((String) next.getKey());
            if (value instanceof String) {
                bundle.putString(b2, next.getValue().toString());
            } else if (value instanceof Double) {
                bundle.putDouble(b2, ((Double) next.getValue()).doubleValue());
            } else if (value instanceof Long) {
                bundle.putLong(b2, ((Long) next.getValue()).longValue());
            } else if (value instanceof Integer) {
                bundle.putInt(b2, ((Integer) next.getValue()).intValue());
            }
        }
    }
}

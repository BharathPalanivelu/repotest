package com.shopee.app.ui.sharing;

import android.app.Activity;
import com.shopee.app.ui.sharing.base.a;
import d.d.b.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f25343a = new b();

    private b() {
    }

    public final a<?> a(Activity activity, String str, com.shopee.app.ui.sharing.base.b bVar) {
        j.b(activity, "activity");
        j.b(bVar, "shareListener");
        if (str != null) {
            switch (str.hashCode()) {
                case -916346253:
                    if (str.equals("twitter")) {
                        return new com.shopee.app.ui.sharing.d.a(activity, bVar);
                    }
                    break;
                case -870648180:
                    if (str.equals("instagramVideoStory")) {
                        return new com.shopee.app.ui.sharing.instagram.b(activity, bVar);
                    }
                    break;
                case -506280509:
                    if (str.equals("copyInfo")) {
                        return new com.shopee.app.ui.sharing.copyinfo.a(activity, bVar);
                    }
                    break;
                case -506195697:
                    if (str.equals("copyLink")) {
                        return new com.shopee.app.ui.sharing.copylink.a(activity, bVar);
                    }
                    break;
                case -399376659:
                    if (str.equals("facebookMessenger")) {
                        return new com.shopee.app.ui.sharing.a.a(activity, bVar);
                    }
                    break;
                case -363926560:
                    if (str.equals("facebookLink")) {
                        return new com.shopee.app.ui.sharing.facebook.a(activity, bVar);
                    }
                    break;
                case -1034342:
                    if (str.equals("pinterest")) {
                        return new com.shopee.app.ui.sharing.c.a(activity, bVar);
                    }
                    break;
                case 114009:
                    if (str.equals("sms")) {
                        return new com.shopee.app.ui.sharing.sms.a(activity, bVar);
                    }
                    break;
                case 28903346:
                    if (str.equals("instagram")) {
                        return new com.shopee.app.ui.sharing.instagram.a(activity, bVar);
                    }
                    break;
                case 96619420:
                    if (str.equals("email")) {
                        return new com.shopee.app.ui.sharing.email.a(activity, bVar);
                    }
                    break;
                case 112200956:
                    if (str.equals("viber")) {
                        return new com.shopee.app.ui.sharing.e.a(activity, bVar);
                    }
                    break;
                case 1188142444:
                    if (str.equals("lineChat")) {
                        return new com.shopee.app.ui.sharing.b.a(activity, bVar);
                    }
                    break;
                case 1348075619:
                    if (str.equals("instagramStory")) {
                        return new com.shopee.app.ui.sharing.instagram.b(activity, bVar);
                    }
                    break;
                case 1350507497:
                    if (str.equals("instagramVideo")) {
                        return new com.shopee.app.ui.sharing.instagram.a(activity, bVar);
                    }
                    break;
                case 1606844172:
                    if (str.equals("facebookPhoto")) {
                        return new com.shopee.app.ui.sharing.facebook.b(activity, bVar);
                    }
                    break;
                case 1934780818:
                    if (str.equals("whatsapp")) {
                        return new com.shopee.app.ui.sharing.f.a(activity, bVar);
                    }
                    break;
            }
        }
        return null;
    }

    public static final a<?> a(Activity activity, String str, String str2, com.shopee.app.ui.sharing.base.b bVar) {
        j.b(activity, "activity");
        j.b(str2, "shareData");
        j.b(bVar, "shareListener");
        a<?> a2 = f25343a.a(activity, str, bVar);
        if (a2 == null) {
            bVar.onResult(new com.shopee.app.ui.sharing.base.data.a(3, (String) null, 2, (g) null));
        } else {
            a2.a(str2);
        }
        return a2;
    }
}

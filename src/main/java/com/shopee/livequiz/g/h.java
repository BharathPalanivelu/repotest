package com.shopee.livequiz.g;

import a.k;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Toast;
import com.google.a.l;
import com.shopee.livequiz.data.bean.share.CopyLinkBean;
import com.shopee.livequiz.data.bean.share.FacebookShareBean;
import com.shopee.livequiz.data.bean.share.ShareBean;
import com.shopee.livequiz.data.bean.share.ShareImage;
import com.shopee.sdk.b;
import com.shopee.sdk.modules.ui.d.a;
import java.util.concurrent.Callable;

public class h {
    public static void a(final String str, final String str2, final View view, final Activity activity) {
        k.a(new Callable<String>() {
            /* renamed from: a */
            public String call() throws Exception {
                Bitmap a2 = b.a(view);
                if (a2 != null) {
                    return b.a(a2);
                }
                return null;
            }
        }).a(new a.h<String, Void>() {
            /* renamed from: a */
            public Void then(k<String> kVar) throws Exception {
                String f2 = kVar.f();
                if (f2 == null) {
                    return null;
                }
                h.a(str, str2, f2, activity);
                return null;
            }
        }, k.f377b);
    }

    public static void a(String str, String str2, String str3, Activity activity) {
        b.a().h().a(activity, new a.C0474a().a(str).a((l) new ShareBean(str2, new ShareImage((String) null, str3)).toJsonObject()).a(), a());
    }

    public static void b(String str, String str2, String str3, Activity activity) {
        if ("facebookLink".equals(str)) {
            b.a().h().a(activity, new a.C0474a().a(str).a((l) new FacebookShareBean(str3, str2, (String) null).toJsonObject()).a(), a());
        } else if (str3 != null) {
            b.a().h().a(activity, new a.C0474a().a(str).a((l) new ShareBean(str2, new ShareImage(str3, (String) null)).toJsonObject()).a(), a());
        } else {
            b.a().h().a(activity, new a.C0474a().a(str).a((l) new ShareBean(str2, (ShareImage) null).toJsonObject()).a(), a());
        }
    }

    public static void a(String str, Activity activity) {
        b.a().h().a(activity, new a.C0474a().a("copyLink").a((l) new CopyLinkBean(str).toJsonObject()).a(), (com.shopee.sdk.f.b<Integer>) new com.shopee.sdk.f.b<Integer>() {
            public void a(int i, String str) {
            }

            public void a(Integer num) {
                Toast.makeText(com.shopee.livequiz.b.a().c(), e.a().a("t_sp_copy_suc"), 0).show();
            }
        });
    }

    private static com.shopee.sdk.f.b<Integer> a() {
        return new com.shopee.sdk.f.b<Integer>() {
            public void a(Integer num) {
            }

            public void a(int i, String str) {
                if (i == 2) {
                    Toast.makeText(com.shopee.livequiz.b.a().c(), e.a().a("t_sp_fail_install"), 0).show();
                } else if (i == 3) {
                    Toast.makeText(com.shopee.livequiz.b.a().c(), e.a().a("t_sp_fail_upgrade"), 0).show();
                } else {
                    Toast.makeText(com.shopee.livequiz.b.a().c(), e.a().a("t_sp_fail_general"), 0).show();
                }
            }
        };
    }
}

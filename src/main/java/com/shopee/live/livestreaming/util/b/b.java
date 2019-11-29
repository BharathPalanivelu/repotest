package com.shopee.live.livestreaming.util.b;

import android.app.Activity;
import com.google.a.l;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.share.CopyInfoBean;
import com.shopee.live.livestreaming.data.entity.share.CopyLinkBean;
import com.shopee.live.livestreaming.data.entity.share.EmailShareBean;
import com.shopee.live.livestreaming.data.entity.share.FacebookShareBean;
import com.shopee.live.livestreaming.data.entity.share.ShareBean;
import com.shopee.live.livestreaming.data.entity.share.ShareImage;
import com.shopee.live.livestreaming.util.z;
import com.shopee.sdk.modules.ui.d.a;

public class b {
    public static void a(String str, String str2, String str3, Activity activity) {
        com.shopee.sdk.f.b<Integer> a2 = a();
        if ("copyInfo".equals(str)) {
            com.shopee.sdk.b.a().h().a(activity, new a.C0474a().a(str).a((l) new CopyInfoBean(str2).toJsonObject()).a(), (com.shopee.sdk.f.b<Integer>) new com.shopee.sdk.f.b<Integer>() {
                public void a(int i, String str) {
                }

                public void a(Integer num) {
                    z.a(com.shopee.live.livestreaming.b.b().c(), com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_copy_success));
                }
            });
        } else if ("copyLink".equals(str)) {
            com.shopee.sdk.b.a().h().a(activity, new a.C0474a().a(str).a((l) new CopyLinkBean(str2).toJsonObject()).a(), (com.shopee.sdk.f.b<Integer>) new com.shopee.sdk.f.b<Integer>() {
                public void a(int i, String str) {
                }

                public void a(Integer num) {
                    z.a(com.shopee.live.livestreaming.b.b().c(), com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_copy_success));
                }
            });
        } else if ("email".equals(str)) {
            com.shopee.sdk.b.a().h().a(activity, new a.C0474a().a(str).a((l) new EmailShareBean(new ShareImage(str3, (String) null), (String) null, str2).toJsonObject()).a(), a2);
        } else if ("facebookLink".equals(str)) {
            com.shopee.sdk.b.a().h().a(activity, new a.C0474a().a(str).a((l) new FacebookShareBean(str3, str2, (String) null).toJsonObject()).a(), a2);
        } else if (str3 != null) {
            com.shopee.sdk.b.a().h().a(activity, new a.C0474a().a(str).a((l) new ShareBean(str2, new ShareImage(str3, (String) null)).toJsonObject()).a(), a2);
        } else {
            com.shopee.sdk.b.a().h().a(activity, new a.C0474a().a(str).a((l) new ShareBean(str2, (ShareImage) null).toJsonObject()).a(), a2);
        }
    }

    public static void a(String str, String str2, String str3, String str4, Activity activity) {
        com.shopee.sdk.b.a().h().a(activity, new a.C0474a().a(str).a((l) new EmailShareBean(new ShareImage(str4, (String) null), str2, str3).toJsonObject()).a(), a());
    }

    private static com.shopee.sdk.f.b<Integer> a() {
        return new com.shopee.sdk.f.b<Integer>() {
            public void a(Integer num) {
            }

            public void a(int i, String str) {
                if (i == 2) {
                    z.a(com.shopee.live.livestreaming.b.b().c(), com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_fail_install));
                } else if (i == 3) {
                    z.a(com.shopee.live.livestreaming.b.b().c(), com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_fail_general));
                } else {
                    z.a(com.shopee.live.livestreaming.b.b().c(), com.garena.android.appkit.tools.b.e(c.g.live_streaming_share_fail_general));
                }
            }
        };
    }
}

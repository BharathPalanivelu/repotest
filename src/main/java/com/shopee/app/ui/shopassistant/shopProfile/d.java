package com.shopee.app.ui.shopassistant.shopProfile;

import android.text.TextUtils;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.ct;
import com.shopee.app.d.c.cy;
import com.shopee.app.d.c.dz;
import com.shopee.app.d.c.eh;
import com.shopee.app.d.c.ej;
import com.shopee.app.d.c.r;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.network.d.ao;
import com.shopee.app.network.d.au;
import com.shopee.app.network.d.bq;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.ak;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.shop.ShopCover;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d extends q<f> {
    private e A = new g() {
        public void onEvent(a aVar) {
            ((f) d.this.f19220b).n();
            com.shopee.app.ui.home.me.editprofile.e eVar = (com.shopee.app.ui.home.me.editprofile.e) aVar;
            if (eVar.f22356d != null && eVar.f22356d.a().equals(d.this.n.a())) {
                ((f) d.this.f19220b).a(eVar.f22355c);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final bi f25481a;

    /* renamed from: c  reason: collision with root package name */
    private final UserInfo f25482c;

    /* renamed from: d  reason: collision with root package name */
    private final n f25483d;

    /* renamed from: e  reason: collision with root package name */
    private final bt f25484e;

    /* renamed from: f  reason: collision with root package name */
    private final com.shopee.app.d.c.g.d f25485f;

    /* renamed from: g  reason: collision with root package name */
    private final dz f25486g;
    private final r h;
    /* access modifiers changed from: private */
    public SettingConfigStore i;
    /* access modifiers changed from: private */
    public ak j;
    private final cy k;
    private final ej l;
    private final eh m;
    /* access modifiers changed from: private */
    public com.shopee.app.network.g n = new com.shopee.app.network.g();
    /* access modifiers changed from: private */
    public ao o;
    /* access modifiers changed from: private */
    public au p;
    private final i q;
    /* access modifiers changed from: private */
    public String r;
    private e s = new g() {
        public void onEvent(a aVar) {
            ((f) d.this.f19220b).k();
        }
    };
    private e t = new g() {
        public void onEvent(a aVar) {
            ct ctVar = (ct) aVar;
            ((f) d.this.f19220b).a(ctVar.f16725a, ctVar.f16726b);
        }
    };
    private e u = new g() {
        public void onEvent(a aVar) {
            ((f) d.this.f19220b).g();
        }
    };
    private e v = new g() {
        public void onEvent(a aVar) {
            if (((com.shopee.app.h.c.d) aVar).b().equals(d.this.r)) {
                ((f) d.this.f19220b).n();
                ((f) d.this.f19220b).h();
            }
        }
    };
    private e w = new g() {
        public void onEvent(a aVar) {
            d.this.j.a((String) aVar.data, d.this.i);
        }
    };
    private e x = new g() {
        public void onEvent(a aVar) {
            ((f) d.this.f19220b).n();
            ((f) d.this.f19220b).i();
        }
    };
    private e y = new g() {
        public void onEvent(a aVar) {
            String str = (String) aVar.data;
            if (d.this.o != null && str.equals(d.this.o.i().a())) {
                ((f) d.this.f19220b).n();
                d.this.g();
            }
        }
    };
    private e z = new g() {
        public void onEvent(a aVar) {
            String str = (String) aVar.data;
            if (d.this.p != null && str.equals(d.this.p.i().a())) {
                ((f) d.this.f19220b).n();
                d.this.g();
            }
        }
    };

    public d(n nVar, bi biVar, UserInfo userInfo, com.shopee.app.d.c.g.d dVar, bt btVar, ej ejVar, eh ehVar, SettingConfigStore settingConfigStore, ak akVar, cy cyVar, r rVar, dz dzVar) {
        this.f25483d = nVar;
        this.f25481a = biVar;
        this.f25482c = userInfo;
        this.f25484e = btVar;
        this.f25485f = dVar;
        this.i = settingConfigStore;
        this.j = akVar;
        this.m = ehVar;
        this.k = cyVar;
        this.h = rVar;
        this.f25486g = dzVar;
        this.l = ejVar;
        this.q = b.a(this);
    }

    public void e() {
        ((f) this.f19220b).j();
        g();
        int shopId = this.f25482c.getShopId();
        int userId = this.f25482c.getUserId();
        this.o = new ao();
        this.o.a(shopId);
        this.p = new au();
        this.p.a(userId);
    }

    /* access modifiers changed from: private */
    public void g() {
        this.n = new com.shopee.app.network.g();
        this.f25484e.a(this.f25482c.getUserId(), this.f25482c.getShopId(), this.n);
    }

    public void a() {
        this.q.a();
        this.f25483d.a("SHOP_INFO_EDIT_PROFILE_LOCAL_LOAD", this.A);
        this.f25483d.a("UPDATE_SHOP_INFO", this.x);
        this.f25483d.a("SHOP_EDIT_INFO_FETCHED", this.y);
        this.f25483d.a("GET_USER_INFO_LOAD_EDIT", this.z);
        this.f25483d.a("ON_IMAGE_SELECTED_DONE", this.s);
        this.f25483d.a("ON_IMAGE_SELECTED", this.t);
        this.f25483d.a("SET_USER_INFO", this.v);
    }

    public void c() {
        this.q.c();
        this.f25481a.a("EDIT_PROFILE_SUBMIT_PROFILE", this.u);
        this.f25481a.a("PLAY_YOUTUBE_ID", this.w);
    }

    public void d() {
        this.q.d();
        this.f25481a.b("EDIT_PROFILE_SUBMIT_PROFILE", this.u);
        this.f25481a.b("PLAY_YOUTUBE_ID", this.w);
    }

    public void b() {
        this.q.b();
        this.f25483d.b("SHOP_INFO_EDIT_PROFILE_LOCAL_LOAD", this.A);
        this.f25483d.b("UPDATE_SHOP_INFO", this.x);
        this.f25483d.b("SHOP_EDIT_INFO_FETCHED", this.y);
        this.f25483d.b("GET_USER_INFO_LOAD_EDIT", this.z);
        this.f25483d.b("ON_IMAGE_SELECTED_DONE", this.s);
        this.f25483d.b("ON_IMAGE_SELECTED", this.t);
        this.f25483d.b("SET_USER_INFO", this.v);
    }

    private String i(String str) {
        Matcher matcher = Pattern.compile("(?:https?://)?(?:www.)?(?:youtu.be|(?:m.)?youtube.com)/(?:embed/|v/|u/\\\\w/|embed/|watch\\?v=)?([a-zA-Z0-9_-]{11}).*", 2).matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        ((f) this.f19220b).n();
        if (str.equals("150")) {
            com.shopee.app.ui.dialog.a.a(((f) this.f19220b).getContext(), 0, (int) R.string.sp_youtube_video_url_private, 0, (int) R.string.button_ok);
        } else if (str.equals("100")) {
            com.shopee.app.ui.dialog.a.a(((f) this.f19220b).getContext(), 0, (int) R.string.sp_youtube_video_url_delete_invalid, 0, (int) R.string.button_ok);
        } else {
            com.shopee.app.ui.dialog.a.a(((f) this.f19220b).getContext(), 0, (int) R.string.sp_youtube_video_url_invalid, 0, (int) R.string.button_ok);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        ((f) this.f19220b).n();
        String[] split = str.split(",");
        ((f) this.f19220b).a(split[0], split[1]);
    }

    /* access modifiers changed from: package-private */
    public void c(String str) {
        String i2 = i(str);
        if (!TextUtils.isEmpty(i2)) {
            for (ShopCover next : ((f) this.f19220b).m.getShopCovers()) {
                if (next.type.intValue() == 1 && next.video_url.compareTo(i2) == 0) {
                    com.shopee.app.ui.dialog.a.a(((f) this.f19220b).getContext(), 0, (int) R.string.sp_youtube_video_url_duplicate, 0, (int) R.string.button_ok);
                    return;
                }
            }
            ((f) this.f19220b).j();
            this.h.a(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        ((f) this.f19220b).setAvatar(str);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        ((f) this.f19220b).a(com.garena.android.appkit.tools.b.e(R.string.sp_unable_to_load_image));
    }

    /* access modifiers changed from: package-private */
    public void e(String str) {
        ((f) this.f19220b).setCover(str);
    }

    public void f(String str) {
        this.f25485f.a(str);
    }

    private String a(int i2) {
        if (i2 == -100) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        if (i2 != 11) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        }
        return com.garena.android.appkit.tools.b.e(R.string.sp_duplicate_shop_name);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        ((f) this.f19220b).n();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i2 = aVar.f17892a;
            if (i2 == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i2 != 11) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_error_user_name_duplicate);
            }
        }
        ((f) this.f19220b).a(str);
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        ((f) this.f19220b).n();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            str = a(aVar.f17892a);
        }
        ((f) this.f19220b).a(str);
    }

    public void a(String str, String str2, String str3, String str4, List<ShopCover> list, boolean z2) {
        ((f) this.f19220b).j();
        bq bqVar = new bq();
        this.r = bqVar.i().a();
        this.f25486g.a(str, str2, str3, str4, list, z2, bqVar);
    }

    public void a(int i2, String str) {
        this.k.a(Arrays.asList(new Integer[]{Integer.valueOf(i2)}), Arrays.asList(new String[]{str}), false);
    }

    public void g(String str) {
        this.m.a(str);
    }

    public void h(String str) {
        this.l.a(str);
    }
}

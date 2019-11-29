package com.shopee.app.database;

import com.garena.android.appkit.a.a;
import com.shopee.app.application.ar;
import com.shopee.app.database.orm.a.aa;
import com.shopee.app.database.orm.a.ab;
import com.shopee.app.database.orm.a.ac;
import com.shopee.app.database.orm.a.ad;
import com.shopee.app.database.orm.a.c;
import com.shopee.app.database.orm.a.d;
import com.shopee.app.database.orm.a.e;
import com.shopee.app.database.orm.a.f;
import com.shopee.app.database.orm.a.g;
import com.shopee.app.database.orm.a.h;
import com.shopee.app.database.orm.a.i;
import com.shopee.app.database.orm.a.j;
import com.shopee.app.database.orm.a.k;
import com.shopee.app.database.orm.a.n;
import com.shopee.app.database.orm.a.o;
import com.shopee.app.database.orm.a.p;
import com.shopee.app.database.orm.a.q;
import com.shopee.app.database.orm.a.r;
import com.shopee.app.database.orm.a.s;
import com.shopee.app.database.orm.a.t;
import com.shopee.app.database.orm.a.u;
import com.shopee.app.database.orm.a.v;
import com.shopee.app.database.orm.a.w;
import com.shopee.app.database.orm.a.x;
import com.shopee.app.database.orm.a.y;
import com.shopee.app.database.orm.a.z;
import com.shopee.app.h.m;

public class b extends com.garena.android.appkit.a.b {

    /* renamed from: b  reason: collision with root package name */
    private static b f6953b;

    /* renamed from: c  reason: collision with root package name */
    private m f6954c;

    /* access modifiers changed from: protected */
    public String a() {
        return "Shopee";
    }

    public static synchronized b f() {
        b bVar;
        synchronized (b.class) {
            if (f6953b == null) {
                f6953b = new b();
            }
            bVar = f6953b;
        }
        return bVar;
    }

    /* access modifiers changed from: protected */
    public int c() {
        if (this.f6954c == null) {
            this.f6954c = new m();
        }
        return this.f6954c.b();
    }

    /* access modifiers changed from: protected */
    public a a(String str, com.garena.android.appkit.a.b bVar) {
        return new a(ar.a().getApplicationContext(), str, bVar);
    }

    /* access modifiers changed from: protected */
    public void d() {
        a("USER_INFO_DAO", (com.garena.android.appkit.a.a.a) new ad(this.f6685a));
        a("ITEM_DETAIL_DAO", (com.garena.android.appkit.a.a.a) new o(this.f6685a));
        a("MODEL_DAO", (com.garena.android.appkit.a.a.a) new s(this.f6685a));
        a("MODEL_SNAPSHOT_DAO", (com.garena.android.appkit.a.a.a) new t(this.f6685a));
        a("CHAT_MESSAGE_DAO", (com.garena.android.appkit.a.a.a) new i(this.f6685a));
        a("CHAT_TO_OFFER_DAO", (com.garena.android.appkit.a.a.a) new j(this.f6685a));
        a("USER_ACTIVITY_DAO", (com.garena.android.appkit.a.a.a) new c(this.f6685a));
        a("ITEM_COMMENT_DAO", (com.garena.android.appkit.a.a.a) new n(this.f6685a));
        a("CATEGORY_DAO", (com.garena.android.appkit.a.a.a) new g(this.f6685a));
        a("USER_DETAIL_DAO", (com.garena.android.appkit.a.a.a) new v(this.f6685a));
        a("SHOP_INFO_DAO", (com.garena.android.appkit.a.a.a) new aa(this.f6685a));
        a("ORDER_ITEM_DAO", (com.garena.android.appkit.a.a.a) new w(this.f6685a));
        a("ITEM_SNAPSHOT_DAO", (com.garena.android.appkit.a.a.a) new p(this.f6685a));
        a("CHECKOUT_ITEM_DAO", (com.garena.android.appkit.a.a.a) new k(this.f6685a));
        a("ACTION_CONTENT_DAO", (com.garena.android.appkit.a.a.a) new com.shopee.app.database.orm.a.a(this.f6685a));
        a("TRANSACTION_DAO", (com.garena.android.appkit.a.a.a) new ab(this.f6685a));
        a("REC_CONTACT_DAO", (com.garena.android.appkit.a.a.a) new x(this.f6685a));
        a("RETURN_ITEM_DAO", (com.garena.android.appkit.a.a.a) new z(this.f6685a));
        a("USER_BRIEF_DAO", (com.garena.android.appkit.a.a.a) new ac(this.f6685a));
        a("LOCAL_CONTACT_DAO", (com.garena.android.appkit.a.a.a) new q(this.f6685a));
        a("REFUND_DAO", (com.garena.android.appkit.a.a.a) new y(this.f6685a));
        a("CHAT_P2P_DAO", (com.garena.android.appkit.a.a.a) new h(this.f6685a));
        a("OFFER_DAO", (com.garena.android.appkit.a.a.a) new u(this.f6685a));
        a("BLOCK_USER_DAO", (com.garena.android.appkit.a.a.a) new f(this.f6685a));
        a("BI_REPORT_DAO", (com.garena.android.appkit.a.a.a) new e(this.f6685a));
        a("ITEM_ATTRIBUTE_DAO", (com.garena.android.appkit.a.a.a) new com.shopee.app.database.orm.a.m(this.f6685a));
        a("MODEL_ATTR_ID_MAP_DAO", (com.garena.android.appkit.a.a.a) new r(this.f6685a));
        a("ATTRIBUTE_CACHE_DAO", (com.garena.android.appkit.a.a.a) new d(this.f6685a));
        a("ACTION_GROUP_DAO", (com.garena.android.appkit.a.a.a) new com.shopee.app.database.orm.a.b(this.f6685a));
    }

    public x g() {
        return (x) b().get("REC_CONTACT_DAO");
    }

    public q h() {
        return (q) b().get("LOCAL_CONTACT_DAO");
    }

    public ad i() {
        return (ad) b().get("USER_INFO_DAO");
    }

    public o j() {
        return (o) b().get("ITEM_DETAIL_DAO");
    }

    public s k() {
        return (s) b().get("MODEL_DAO");
    }

    public t l() {
        return (t) b().get("MODEL_SNAPSHOT_DAO");
    }

    public i m() {
        return (i) b().get("CHAT_MESSAGE_DAO");
    }

    public j n() {
        return (j) b().get("CHAT_TO_OFFER_DAO");
    }

    public c o() {
        return (c) b().get("USER_ACTIVITY_DAO");
    }

    public n p() {
        return (n) b().get("ITEM_COMMENT_DAO");
    }

    public g q() {
        return (g) b().get("CATEGORY_DAO");
    }

    public v r() {
        return (v) b().get("USER_DETAIL_DAO");
    }

    public aa s() {
        return (aa) b().get("SHOP_INFO_DAO");
    }

    public w t() {
        return (w) b().get("ORDER_ITEM_DAO");
    }

    public p u() {
        return (p) b().get("ITEM_SNAPSHOT_DAO");
    }

    public com.shopee.app.database.orm.a.a v() {
        return (com.shopee.app.database.orm.a.a) b().get("ACTION_CONTENT_DAO");
    }

    public k w() {
        return (k) b().get("CHECKOUT_ITEM_DAO");
    }

    public ab x() {
        return (ab) b().get("TRANSACTION_DAO");
    }

    public z y() {
        return (z) b().get("RETURN_ITEM_DAO");
    }

    public ac z() {
        return (ac) b().get("USER_BRIEF_DAO");
    }

    public void A() {
        f6953b = null;
    }

    public y B() {
        return (y) b().get("REFUND_DAO");
    }

    public h C() {
        return (h) b().get("CHAT_P2P_DAO");
    }

    public u D() {
        return (u) b().get("OFFER_DAO");
    }

    public f E() {
        return (f) b().get("BLOCK_USER_DAO");
    }

    public e F() {
        return (e) b().get("BI_REPORT_DAO");
    }

    public com.shopee.app.database.orm.a.m G() {
        return (com.shopee.app.database.orm.a.m) b().get("ITEM_ATTRIBUTE_DAO");
    }

    public r H() {
        return (r) b().get("MODEL_ATTR_ID_MAP_DAO");
    }

    public d I() {
        return (d) b().get("ATTRIBUTE_CACHE_DAO");
    }

    public com.shopee.app.database.orm.a.b J() {
        return (com.shopee.app.database.orm.a.b) b().get("ACTION_GROUP_DAO");
    }
}

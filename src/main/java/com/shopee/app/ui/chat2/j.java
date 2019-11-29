package com.shopee.app.ui.chat2;

import android.app.Dialog;
import android.net.Uri;
import android.util.Pair;
import android.view.View;
import com.garena.android.appkit.b.i;
import com.garena.android.appkit.f.f;
import com.shopee.app.d.c.Cdo;
import com.shopee.app.d.c.af;
import com.shopee.app.d.c.bm;
import com.shopee.app.d.c.bx;
import com.shopee.app.d.c.bz;
import com.shopee.app.d.c.co;
import com.shopee.app.d.c.di;
import com.shopee.app.d.c.dn;
import com.shopee.app.d.c.dp;
import com.shopee.app.d.c.ds;
import com.shopee.app.d.c.dt;
import com.shopee.app.d.c.du;
import com.shopee.app.d.c.n;
import com.shopee.app.d.c.p;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.StickerPack;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.data.viewmodel.chat.ChatIntention;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.database.orm.bean.chatP2P.DBBlockUser;
import com.shopee.app.h.i;
import com.shopee.app.h.r;
import com.shopee.app.network.d.ao;
import com.shopee.app.network.d.au;
import com.shopee.app.network.d.av;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.b.e;
import com.shopee.app.network.d.k;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.chat2.block.c;
import com.shopee.app.ui.chat2.block.o;
import com.shopee.app.ui.chat2.s;
import com.shopee.app.ui.chat2.send.ChatShortcutView;
import com.shopee.app.ui.common.ae;
import com.shopee.app.ui.common.b.c;
import com.shopee.app.util.ak;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.app.web.protocol.RightItemMessage;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class j extends q<n> implements ChatShortcutView.a, ae.a {
    private Dialog A;
    private a B;
    private SettingConfigStore C;
    private final bm D;
    private final bm E;
    private boolean F = false;
    private boolean G = false;
    private c H;
    /* access modifiers changed from: private */
    public int I;
    /* access modifiers changed from: private */
    public ChatIntention J;
    private ChatIntention K;
    private UserData L;
    private boolean M;
    private boolean N;
    private boolean O = true;
    private int P = -99;
    private int Q = -99;
    private com.shopee.app.tracking.trackingv3.b R;
    private b S = new b();
    private a T = new a();

    /* renamed from: a  reason: collision with root package name */
    boolean f20451a = false;

    /* renamed from: c  reason: collision with root package name */
    List<Long> f20452c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final i f20453d;

    /* renamed from: e  reason: collision with root package name */
    private final af f20454e;

    /* renamed from: f  reason: collision with root package name */
    private final du f20455f;

    /* renamed from: g  reason: collision with root package name */
    private final com.shopee.app.d.c.j f20456g;
    private final RegionConfig h;
    private final Cdo i;
    private final ds j;
    private final co k;
    private final ak l;
    private final dp m;
    private final dt n;
    private final bz o;
    private final o p;
    private final di q;
    private final n r;
    private final s s;
    private final bx t;
    private final p u;
    /* access modifiers changed from: private */
    public int v = 20;
    /* access modifiers changed from: private */
    public ArrayList<ChatMessage> w = new ArrayList<>();
    private dn x;
    private boolean y = false;
    private long z;

    public j(af afVar, du duVar, dn dnVar, com.shopee.app.d.c.j jVar, Cdo doVar, ds dsVar, dp dpVar, dt dtVar, co coVar, o oVar, di diVar, n nVar, bz bzVar, s sVar, SettingConfigStore settingConfigStore, bm bmVar, bm bmVar2, bx bxVar, p pVar, ak akVar, com.garena.sticker.b bVar, RegionConfig regionConfig, com.shopee.app.tracking.trackingv3.b bVar2) {
        this.R = bVar2;
        this.f20453d = com.garena.a.a.a.b.a(this);
        this.k = coVar;
        this.f20454e = afVar;
        this.f20455f = duVar;
        this.f20456g = jVar;
        this.j = dsVar;
        this.x = dnVar;
        this.i = doVar;
        this.n = dtVar;
        this.o = bzVar;
        this.q = diVar;
        this.r = nVar;
        this.t = bxVar;
        this.u = pVar;
        this.l = akVar;
        this.C = settingConfigStore;
        this.p = oVar;
        this.m = dpVar;
        this.D = bmVar;
        this.E = bmVar2;
        this.s = sVar;
        this.h = regionConfig;
    }

    public void a() {
        this.H = new c(((n) this.f19220b).getContext(), (c.a) this.f19220b);
        this.B = new a((View) this.f19220b, this.l, this.C);
        this.f20453d.a();
    }

    public void a(int i2, ChatIntention chatIntention, ChatIntention chatIntention2) {
        this.I = i2;
        this.J = chatIntention;
        this.K = chatIntention2;
    }

    public void e() {
        new e().a(this.I, 0, 21);
        a(0, true);
    }

    public void f() {
        new au().a((List<Integer>) Collections.singletonList(Integer.valueOf(this.I)));
        new av().a(Collections.singletonList(Integer.valueOf(this.I)));
        this.o.a(this.I);
    }

    public void g() {
        k kVar = new k();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.I));
        kVar.a(arrayList, false);
        G();
    }

    public void h() {
        this.t.a();
    }

    public void c() {
        this.N = false;
        this.f20453d.c();
    }

    public void d() {
        this.N = true;
        this.f20453d.d();
        com.shopee.app.c.a.a(((n) this.f19220b).getContext());
    }

    public void b() {
        this.f20456g.a(this.I);
        this.f20453d.b();
    }

    private void a(long j2, boolean z2) {
        this.z = j2;
        this.f20454e.a(this.I, this.v, j2, z2);
    }

    private void G() {
        this.p.a(this.I);
    }

    /* access modifiers changed from: package-private */
    public void i() {
        f();
    }

    /* access modifiers changed from: package-private */
    public void a(ShopDetail shopDetail) {
        if (shopDetail.getUserId() == this.I) {
            ((n) this.f19220b).a(shopDetail);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(UserData userData) {
        if (userData.getUserId() == this.I) {
            this.L = userData;
            ((n) this.f19220b).setUserInfo(userData);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<UserData> list) {
        if (list.size() == 1) {
            UserData userData = list.get(0);
            if (userData.getUserId() == this.I) {
                this.L = userData;
                ((n) this.f19220b).setUserInfo(userData);
                new ao().a(this.L.getShopId());
                C();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        ((n) this.f19220b).b();
    }

    /* access modifiers changed from: package-private */
    public void k() {
        ((n) this.f19220b).s();
    }

    /* access modifiers changed from: package-private */
    public void l() {
        ((n) this.f19220b).p();
    }

    /* access modifiers changed from: package-private */
    public void m() {
        ((n) this.f19220b).o();
    }

    /* access modifiers changed from: package-private */
    public void n() {
        ((n) this.f19220b).r();
    }

    /* access modifiers changed from: package-private */
    public void o() {
        ((n) this.f19220b).q();
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.f20455f.a(0, this.I, this.K, str);
    }

    /* access modifiers changed from: package-private */
    public void a(ChatMessage chatMessage) {
        if (chatMessage.isForThisChat(this.I)) {
            this.w = new ArrayList<>(this.w);
            this.w.add(0, chatMessage);
            this.v++;
            ((n) this.f19220b).v();
            ((n) this.f19220b).a(true, true);
            ((n) this.f19220b).a((List<ChatMessage>) this.w);
            this.J.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ChatMessage chatMessage) {
        if (chatMessage.isForThisChat(this.I)) {
            this.K = new ChatIntention(chatMessage.getItemId(), chatMessage.getShopId(), chatMessage.getOrderId());
            ((n) this.f19220b).a(true, true);
            a(0, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(ChatMessage chatMessage) {
        if (chatMessage.isForThisChat(this.I)) {
            ((n) this.f19220b).setMessageDeleted(true);
            a(0, false);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(ChatMessage chatMessage) {
        this.f20451a = false;
        if (chatMessage.isForThisChat(this.I)) {
            this.v++;
            this.K = new ChatIntention(chatMessage.getItemId(), chatMessage.getShopId(), chatMessage.getOrderId());
            this.f20456g.a(this.I);
            ((n) this.f19220b).a(false, true);
            ((n) this.f19220b).a(chatMessage);
            this.J.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(List<Object> list) {
        this.f20451a = true;
        if (((Integer) list.get(0)).intValue() == this.I || ((Integer) list.get(1)).intValue() == this.I) {
            this.v++;
            this.f20452c.add(Long.valueOf(((Long) list.get(2)).longValue()));
            this.f20456g.a(this.I);
            ((n) this.f19220b).a(false, true);
            this.J.clear();
            this.T.f20459a = true;
            this.T = new a();
            f.a().a(this.T, 500);
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        if (!this.f20451a) {
            a(0, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void q() {
        a((long) hashCode(), true);
    }

    /* access modifiers changed from: package-private */
    public void a(af.b bVar) {
        if (bVar.f16445b == this.z && this.I == bVar.f16449f) {
            if (bVar.f16446c != null && this.J.isEmpty()) {
                ChatMessage chatMessage = bVar.f16446c;
                this.K = new ChatIntention(chatMessage.getItemId(), chatMessage.getShopId(), chatMessage.getOrderId());
            }
            this.k.a(this.J, bVar.f16444a, bVar.f16448e, hashCode(), bVar.f16447d);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(co.a aVar) {
        if (aVar.f16706b == hashCode()) {
            int size = this.w.size();
            this.w = new ArrayList<>(aVar.f16705a);
            int size2 = this.w.size() - size;
            if (size == 0) {
                if (this.O) {
                    ((n) this.f19220b).a((List<ChatMessage>) this.w);
                } else if (!this.S.f20461a) {
                    this.S.f20461a = true;
                    ((n) this.f19220b).postDelayed(this.S, 300);
                }
            } else if (this.y) {
                this.y = false;
                if (size2 > 0) {
                    ((n) this.f19220b).a((List<ChatMessage>) this.w, size2);
                } else {
                    ((n) this.f19220b).i();
                }
            } else if (!this.S.f20461a) {
                this.S.f20461a = true;
                ((n) this.f19220b).postDelayed(this.S, 300);
            }
            this.O = false;
        }
    }

    public void c(List<String> list) {
        this.x.a(0, this.I, this.K, list);
    }

    public void d(List<ItemDetail> list) {
        this.j.a(0, this.I, list);
    }

    public void a(OrderDetail orderDetail) {
        this.m.a(0, this.I, orderDetail);
    }

    public void a(com.garena.sticker.e.b bVar) {
        this.n.a(0, this.I, this.K, bVar);
    }

    public void d(int i2) {
        i.a a2 = com.shopee.app.h.i.a().a(this.I);
        if (a2.a()) {
            this.v += 20;
            a((long) hashCode(), true);
            new e().a(this.I, a2.f17665b, 21);
            this.y = true;
            return;
        }
        ((n) this.f19220b).i();
    }

    /* access modifiers changed from: package-private */
    public void r() {
        a(0, false);
    }

    /* access modifiers changed from: package-private */
    public void s() {
        a((long) hashCode(), false);
    }

    /* access modifiers changed from: package-private */
    public void t() {
        a((long) hashCode(), false);
    }

    /* access modifiers changed from: package-private */
    public void u() {
        UserData userData = this.L;
        if (userData != null) {
            this.H.a(this.I, userData.getUserName());
        }
    }

    /* access modifiers changed from: package-private */
    public void v() {
        G();
    }

    /* access modifiers changed from: package-private */
    public void a(DBBlockUser dBBlockUser) {
        if (dBBlockUser.a() == this.I) {
            ((n) this.f19220b).d();
            if (this.M) {
                r.a().b((int) R.string.sp_unblock_user_successful);
            } else {
                r.a().b((int) R.string.sp_block_user_successful);
            }
            G();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        G();
        this.H.a(aVar);
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<Integer, Integer> pair) {
        if (((Integer) pair.first).intValue() != this.I) {
            return;
        }
        if (((Integer) pair.second).intValue() != 0) {
            this.M = false;
            ((n) this.f19220b).a(false);
            return;
        }
        this.M = true;
        ((n) this.f19220b).a(true);
    }

    /* access modifiers changed from: package-private */
    public void b(Pair<Integer, Pair<Integer, Integer>> pair) {
        if (((Integer) pair.first).intValue() == this.I) {
            this.P = ((Integer) ((Pair) pair.second).first).intValue();
            this.Q = ((Integer) ((Pair) pair.second).second).intValue();
            ((n) this.f19220b).a(this.P, this.Q);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (z2) {
            ((n) this.f19220b).r();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Pair pair) {
        if (((Integer) pair.first).intValue() == 4) {
            RightItemMessage rightItemMessage = (RightItemMessage) pair.second;
            if ("view".equals(rightItemMessage.getKey())) {
                this.l.c(this.I);
            } else if ("report".equals(rightItemMessage.getKey())) {
                UserData userData = this.L;
                if (userData != null) {
                    this.l.k(userData.getShopId());
                }
            } else if ("block".equals(rightItemMessage.getKey())) {
                ((n) this.f19220b).s();
                if (this.M) {
                    UserData userData2 = this.L;
                    if (userData2 != null) {
                        this.H.a(this.I, userData2.getUserName());
                        return;
                    }
                    return;
                }
                UserData userData3 = this.L;
                if (userData3 != null) {
                    this.H.b(this.I, userData3.getUserName());
                }
            } else if ("home".equals(rightItemMessage.getKey())) {
                ((n) this.f19220b).w();
            } else if ("need_help".equals(rightItemMessage.getKey())) {
                this.l.ae();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Pair<Integer, Float> pair) {
        if (pair != null) {
            ((Integer) pair.first).intValue();
            ((Float) pair.second).floatValue();
        }
    }

    /* access modifiers changed from: package-private */
    public void e(ChatMessage chatMessage) {
        this.q.a(chatMessage.getRequestId());
    }

    /* access modifiers changed from: package-private */
    public void f(ChatMessage chatMessage) {
        this.r.a(chatMessage.getRequestId());
    }

    /* access modifiers changed from: package-private */
    public void b(com.garena.sticker.e.b bVar) {
        a(bVar);
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        this.u.a(str);
    }

    /* access modifiers changed from: package-private */
    public void w() {
        ((n) this.f19220b).j();
    }

    /* access modifiers changed from: package-private */
    public void a(ItemDetail itemDetail) {
        this.J.clear();
        d((List<ItemDetail>) Collections.singletonList(itemDetail));
        a(0, false);
    }

    /* access modifiers changed from: package-private */
    public void b(OrderDetail orderDetail) {
        this.J.clear();
        a(orderDetail);
        a(0, false);
    }

    /* access modifiers changed from: package-private */
    public void x() {
        ((n) this.f19220b).k();
    }

    /* access modifiers changed from: package-private */
    public void y() {
        ((n) this.f19220b).b(this.F, this.G);
    }

    /* access modifiers changed from: package-private */
    public void z() {
        ((n) this.f19220b).l();
    }

    /* access modifiers changed from: package-private */
    public void A() {
        UserData userData = this.L;
        if (userData != null && this.P > -99 && this.Q > -99) {
            if (userData.isUserActive()) {
                ((n) this.f19220b).m();
                return;
            }
            ((n) this.f19220b).d(com.garena.android.appkit.tools.b.a(R.string.sp_inactive_hint, UserData.lastSeenTimeWithCeiling2(this.P, this.Q, this.C.getInactiveCeilingDays())));
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ItemDetail itemDetail) {
        UserData userData = this.L;
        if (userData != null && this.P > -99 && this.Q > -99) {
            if (userData.isUserActive()) {
                this.A = this.B.a(this.i, this.I, this.h, itemDetail);
                return;
            }
            ((n) this.f19220b).d(com.garena.android.appkit.tools.b.a(R.string.sp_inactive_hint, UserData.lastSeenTimeWithCeiling2(this.P, this.Q, this.C.getInactiveCeilingDays())));
        }
    }

    /* access modifiers changed from: package-private */
    public void a(q qVar) {
        UserData userData = this.L;
        if (userData != null && this.P > -99 && this.Q > -99) {
            if (userData.isUserActive()) {
                this.A = this.B.a(this.I, qVar.f20842a, qVar.f20843b);
                return;
            }
            ((n) this.f19220b).d(com.garena.android.appkit.tools.b.a(R.string.sp_inactive_hint, UserData.lastSeenTimeWithCeiling2(this.P, this.Q, this.C.getInactiveCeilingDays())));
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        ((n) this.f19220b).a(j2);
    }

    /* access modifiers changed from: package-private */
    public void a(AddCartMessage addCartMessage) {
        String str;
        boolean z2 = false;
        if (addCartMessage != null) {
            boolean isAddOnly = addCartMessage.isAddOnly();
            boolean z3 = isAddOnly;
            str = Uri.encode(String.format(Locale.ENGLISH, "{\"refererItems\":[{\"shopID\":%1$d,\"itemID\":%2$d}],\"source\":\"chat\"}", new Object[]{Integer.valueOf(addCartMessage.shopID), Long.valueOf(addCartMessage.itemID)}));
            z2 = z3;
        } else {
            str = "";
        }
        if (!this.N) {
            Dialog dialog = this.A;
            if (dialog != null) {
                dialog.dismiss();
            }
            if (!z2) {
                ((n) this.f19220b).a(str);
            }
            if (addCartMessage != null) {
                com.google.a.o a2 = com.shopee.app.tracking.trackingv3.b.a(addCartMessage.itemID, (long) addCartMessage.shopID);
                if (addCartMessage.getSelectedModelId() > 0) {
                    a2.a("modelid", (Number) Long.valueOf(addCartMessage.getSelectedModelId()));
                }
                a2.a("price", (Number) Long.valueOf(addCartMessage.price));
                a2.a("quantity", (Number) Integer.valueOf(addCartMessage.getQuantity()));
                this.R.b("action_add_to_cart_success", a2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        if (!this.N) {
            this.B.a(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(final Pair<ItemDetail, VMOffer> pair) {
        this.A = this.B.a(this.i, this.I, (ItemDetail) pair.first, (VMOffer) pair.second, new c.b() {
            public void a(int i, long j, long j2) {
                if (((ItemDetail) pair.first).getId() == j.this.J.getItemId()) {
                    j.this.J.clear();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void f(Pair<ItemDetail, VMOffer> pair) {
        this.A = this.B.b(this.i, this.I, (ItemDetail) pair.first, (VMOffer) pair.second);
    }

    /* access modifiers changed from: package-private */
    public void b(q qVar) {
        this.A = this.B.b(this.I, qVar.f20842a, qVar.f20843b);
    }

    /* access modifiers changed from: package-private */
    public void B() {
        a(0, true);
    }

    /* access modifiers changed from: package-private */
    public void c(com.shopee.app.network.c.d.a aVar) {
        this.B.b(aVar);
        a(0, false);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.I == i2) {
            r.a().b((int) R.string.sp_seller_on_vacation_error);
        }
    }

    public void c(ItemDetail itemDetail) {
        this.A = this.B.a(this.i, this.I, itemDetail, (VMOffer) null);
    }

    public void C() {
        UserData userData = this.L;
        if (userData != null) {
            int shopId = userData.getShopId();
            a(this.I, 0, false);
            a(0, shopId, false);
        }
    }

    private void a(int i2, int i3) {
        if (i2 > 0) {
            com.shopee.app.network.d.h.k kVar = new com.shopee.app.network.d.h.k();
            com.shopee.app.h.o.a().a((az) kVar);
            kVar.a(i2, 0, 1);
        } else if (i3 > 0) {
            com.shopee.app.network.d.h.j jVar = new com.shopee.app.network.d.h.j();
            com.shopee.app.h.o.a().a((az) jVar);
            jVar.a(i3, 0, 1);
        }
    }

    private void a(int i2, int i3, boolean z2) {
        if (i2 == 0) {
            this.D.a(i2, i3, 1, true, z2);
        } else {
            this.E.a(i2, i3, 1, true, z2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (this.I == i2) {
            a(i2, 0, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        UserData userData = this.L;
        if (userData != null && userData.getShopId() == i2) {
            a(0, i2, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(bm.b bVar) {
        if (bVar.f16601b == this.I && bVar.f16600a == 0) {
            if (bVar.f16603d) {
                this.G = bVar.f16602c.isEmpty();
            } else if (bVar.f16602c.isEmpty()) {
                a(this.I, 0);
            }
        } else if (bVar.f16601b == 0 && this.L != null && bVar.f16600a == this.L.getShopId()) {
            if (bVar.f16603d) {
                this.F = bVar.f16602c.isEmpty();
            } else if (bVar.f16602c.isEmpty()) {
                a(0, bVar.f16600a);
            }
        }
        if (this.F && this.G) {
            ((n) this.f19220b).n();
        }
    }

    public void D() {
        this.s.a();
    }

    /* access modifiers changed from: package-private */
    public void a(s.a aVar) {
        ((n) this.f19220b).a(aVar.f20854a, aVar.a());
    }

    /* access modifiers changed from: package-private */
    public void E() {
        this.s.c();
    }

    /* access modifiers changed from: package-private */
    public void e(List<StickerPack> list) {
        ((n) this.f19220b).d(list);
    }

    public void c(String str) {
        if (!((n) this.f19220b).s) {
            ((n) this.f19220b).e(str);
        }
    }

    public void F() {
        this.l.ao();
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20461a;

        private b() {
            this.f20461a = false;
        }

        public void run() {
            ((n) j.this.f19220b).a((List<ChatMessage>) j.this.w);
            this.f20461a = false;
        }
    }

    private class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20459a;

        private a() {
            this.f20459a = false;
        }

        public void run() {
            if (!this.f20459a) {
                new e().a(j.this.I, 0, j.this.v);
            }
        }
    }
}

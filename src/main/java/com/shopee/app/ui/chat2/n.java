package com.shopee.app.ui.chat2;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.s;
import com.garena.android.appkit.b.b;
import com.google.a.o;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.StickerPack;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.data.viewmodel.chat.ChatIntention;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.tracking.ImpressionObserver;
import com.shopee.app.ui.a.y;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.e;
import com.shopee.app.ui.chat.cell.al;
import com.shopee.app.ui.chat2.b.d;
import com.shopee.app.ui.chat2.block.c;
import com.shopee.app.ui.chat2.buy.BuyProductSelectActivity_;
import com.shopee.app.ui.chat2.offer.OfferTabActivity_;
import com.shopee.app.ui.chat2.r;
import com.shopee.app.ui.chat2.send.ChatShortcutView;
import com.shopee.app.ui.chat2.send.e;
import com.shopee.app.ui.common.ae;
import com.shopee.app.ui.common.m;
import com.shopee.app.ui.common.t;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.af;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.tencent.qalsdk.im_open.http;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import twitter4j.HttpResponseCode;

public class n extends FrameLayout implements c.a, r.a {
    private final ChatIntention A;
    private boolean B = true;
    private boolean C = false;
    private boolean D = false;
    private UserData E;
    private boolean F;
    private List<StickerPack> G;
    private d H;
    private ImpressionObserver I;
    private LongSparseArray<Boolean> J = new LongSparseArray<>();
    private List<ChatMessage> K = new ArrayList();
    private RecyclerView.n L = new RecyclerView.n() {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if ((i == 0 || i == 1) && n.this.w.n() == 0) {
                n.this.f();
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f20534a;

    /* renamed from: b  reason: collision with root package name */
    e f20535b;

    /* renamed from: c  reason: collision with root package name */
    TextView f20536c;

    /* renamed from: d  reason: collision with root package name */
    r f20537d;

    /* renamed from: e  reason: collision with root package name */
    TextView f20538e;

    /* renamed from: f  reason: collision with root package name */
    ChatShortcutView f20539f;

    /* renamed from: g  reason: collision with root package name */
    t f20540g;
    t h;
    j i;
    bc j;
    ak k;
    Activity l;
    com.shopee.app.ui.common.r m;
    com.shopee.app.ui.actionbar.a n;
    SettingConfigStore o;
    UserInfo p;
    com.shopee.app.tracking.trackingv3.b q;
    com.shopee.app.a.a.a r;
    protected boolean s = false;
    d.d.a.b<Integer, o> t = new d.d.a.b<Integer, o>() {
        public o a(Integer num) {
            if (num.intValue() < 0 || num.intValue() >= n.this.u.d().size()) {
                return null;
            }
            ChatMessage chatMessage = (ChatMessage) n.this.u.b(num.intValue());
            if (chatMessage.getType() != 4 && chatMessage.getType() != 102) {
                return null;
            }
            if (!(chatMessage.getData() instanceof ItemDetail)) {
                return com.shopee.app.tracking.trackingv3.b.a(chatMessage.getItemId(), (long) chatMessage.getShopId());
            }
            ItemDetail itemDetail = (ItemDetail) chatMessage.getData();
            return com.shopee.app.tracking.trackingv3.b.a(itemDetail.getId(), (long) itemDetail.getShopId());
        }
    };
    /* access modifiers changed from: private */
    public y<ChatMessage> u;
    private ae v;
    /* access modifiers changed from: private */
    public LinearLayoutManager w;
    private ShopDetail x;
    private final int y;
    private final ChatIntention z;

    public n(Context context, int i2, ChatIntention chatIntention) {
        super(context);
        this.y = i2;
        this.z = new ChatIntention(chatIntention);
        this.A = new ChatIntention(chatIntention);
        ((com.shopee.app.ui.chat.b) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.j.a(this.i);
        this.i.a(this);
        this.i.a(this.y, this.z, this.A);
        if (!TextUtils.isEmpty(this.z.getMessage())) {
            this.f20535b.setText(this.z.getMessage());
        }
        this.I = new ImpressionObserver(this.f20534a, (com.shopee.app.tracking.c) null, this.q, new ImpressionObserver.b("item"), (d.d.a.b<? super Integer, o>) this.t);
        this.r.a(this.I);
        this.u = new a(new l(), this.I);
        this.w = new ChatLayoutManager(getContext());
        this.w.b(true);
        this.f20534a.setLayoutManager(this.w);
        this.v = new ae(this.f20534a, this.u);
        this.f20534a.a((RecyclerView.n) this.v);
        this.v.a((ae.a) this.i);
        this.f20534a.setAdapter(this.u);
        this.v.a(this.L);
        ((s) this.f20534a.getItemAnimator()).setSupportsChangeAnimations(false);
        this.i.e();
        this.i.f();
        this.i.D();
        this.i.h();
        this.f20537d.setKeyboardCallback(this);
        Drawable g2 = androidx.core.graphics.drawable.a.g(com.garena.android.appkit.tools.b.f(R.drawable.com_garena_shopee_ic_arrow_down).mutate());
        androidx.core.graphics.drawable.a.a(g2, -1);
        this.f20538e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, g2, (Drawable) null);
        this.f20539f.setVisibility(8);
        this.h.setOnDismissListener(new View.OnClickListener() {
            public void onClick(View view) {
                n.this.h.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImpressionObserver impressionObserver = this.I;
        if (impressionObserver != null) {
            impressionObserver.b();
        }
    }

    public void x_() {
        this.m.a();
    }

    public void b() {
        this.f20535b.j();
        this.f20537d.d();
    }

    public void d() {
        this.m.b();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        g();
        this.f20538e.setVisibility(8);
    }

    public void a(boolean z2, List<String> list) {
        if (z2) {
            this.f20539f.setVisibility(0);
        } else {
            this.f20539f.setVisibility(8);
        }
        this.f20539f.setShortcutList(list);
        this.f20539f.setShortcutListener(this.i);
    }

    public void a(List<ChatMessage> list) {
        if (this.x != null) {
            for (ChatMessage disallowNegotiate : list) {
                disallowNegotiate.setDisallowNegotiate(!this.x.isOfferEnabled());
            }
        }
        if (this.E != null) {
            for (ChatMessage offerAndBuyEnabled : list) {
                offerAndBuyEnabled.setOfferAndBuyEnabled(!this.E.isHolidayModeOn());
            }
        }
        for (ChatMessage next : list) {
            next.setTranslationViewExpanded(com.shopee.app.d.b.b.a(this.J.get(next.getMessageId())));
        }
        al.a().a(list);
        this.u.a(new ArrayList(list));
        f.a(new b(this.K, list), false).a((RecyclerView.a) this.u);
        this.K = new ArrayList(list);
        ArrayList<Long> arrayList = new ArrayList<>();
        if (this.i.f20452c.size() > 0) {
            for (Long longValue : this.i.f20452c) {
                long longValue2 = longValue.longValue();
                for (ChatMessage next2 : list) {
                    if (next2.getMessageId() == longValue2) {
                        a(next2);
                        arrayList.add(Long.valueOf(longValue2));
                    }
                }
            }
        }
        for (Long longValue3 : arrayList) {
            this.i.f20452c.remove(Long.valueOf(longValue3.longValue()));
        }
        if (this.B) {
            if (this.C) {
                g();
                this.C = false;
            } else {
                h();
            }
            this.B = false;
        }
    }

    public void setUserInfo(UserData userData) {
        this.E = userData;
        if (userData.isUserDeletedOrBanned()) {
            this.f20535b.i();
            this.n.c();
            m mVar = new m(getContext());
            mVar.setImageResource(R.drawable.com_garena_shopee_ic_more);
            mVar.setColor(com.garena.android.appkit.tools.b.a(R.color.disable));
            this.n.a((a.b) new a.b("CHAT_USER_DELETED_OR_DISABLED", mVar) {
                public void a() {
                }
            });
        } else {
            this.n.c();
            this.n.a((a.b) new a.b("more", R.drawable.com_garena_shopee_ic_more) {
                public void a() {
                }
            });
            x();
        }
        if (this.E.isHolidayModeOn()) {
            this.f20540g.setVisibility(0);
        } else {
            this.f20540g.setVisibility(8);
        }
        if (this.p.isAutoTranslationEnabled() || this.E.isAutoTranslationEnabled()) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
        this.n.setTitle(String.format("@%s", new Object[]{userData.getUserName()}));
        this.i.g();
    }

    public void a(int i2, int i3) {
        this.n.setSubtitle(UserData.lastSeenTimeWithCeiling(i2, i3, this.o.getInactiveCeilingDays()));
    }

    public void a(List<ChatMessage> list, int i2) {
        this.u.a(new ArrayList(list));
        f.a(new b(this.K, list), false).a((RecyclerView.a) this.u);
        this.K = new ArrayList(list);
    }

    public void a(boolean z2, boolean z3) {
        this.B = z2;
        this.C = z3;
    }

    public void a(ChatMessage chatMessage) {
        String str;
        if (chatMessage.getFromUserId() == this.p.getUserId()) {
            str = this.p.getUsername();
        } else {
            UserData userData = this.E;
            str = userData == null ? "" : userData.getUserName();
        }
        if (this.w.n() > 0) {
            String format = String.format(Locale.getDefault(), chatMessage.getHintText(), new Object[]{str});
            this.f20538e.setVisibility(0);
            this.f20538e.setText(format);
            return;
        }
        a(true, true);
    }

    public void f() {
        if (this.f20538e.getVisibility() == 0) {
            this.f20538e.setVisibility(8);
        }
    }

    public void g() {
        this.f20534a.d(0);
    }

    public void h() {
        this.f20534a.b(0);
        f();
    }

    public void b(List<String> list) {
        this.i.c(list);
    }

    public void i() {
        this.v.b();
    }

    public void a(String str) {
        this.k.e(str);
    }

    public void j() {
        this.k.u();
    }

    public void a(ItemDetail itemDetail) {
        this.i.b(itemDetail);
    }

    public void b(ItemDetail itemDetail) {
        this.i.c(itemDetail);
    }

    public void c(List<ItemDetail> list) {
        this.i.d(list);
        this.f20535b.j();
    }

    public void a(OrderDetail orderDetail) {
        this.i.a(orderDetail);
        this.f20535b.j();
    }

    public void k() {
        UserData userData = this.E;
        if (userData != null) {
            this.k.a(this.y, userData.getShopId(), this.E.getUserName());
        }
    }

    public void b(boolean z2, boolean z3) {
        UserData userData = this.E;
        if (userData == null) {
            return;
        }
        if (!z2 && !z3) {
            this.k.b(this.y, userData.getShopId());
        } else if (z2) {
            this.k.c(this.y, 0);
        } else {
            this.k.c(0, this.E.getShopId());
        }
    }

    private void x() {
        UserData userData = this.E;
        if (userData == null || !userData.isUserDeletedOrBanned()) {
            this.n.a(com.shopee.app.ui.chat.a.d(this.s).a((e.c) new e.c() {
                public void a(int i, Object obj) {
                    com.garena.android.appkit.b.b.a("CLICK", new com.garena.android.appkit.b.a(new Pair(Integer.valueOf(i), obj)), b.a.UI_BUS);
                }
            }).a((e.d) new e.d() {
                public void a(boolean z) {
                    com.garena.android.appkit.b.b.a("ON_SHOW", new com.garena.android.appkit.b.a(Boolean.valueOf(z)), b.a.UI_BUS);
                }
            }).a(getContext()));
            this.f20535b.c(!this.s);
            this.f20536c.setVisibility(this.s ? 0 : 8);
            com.a.a.f b2 = com.a.a.f.a(getContext()).b((int) R.drawable.ic_blockthisuser_orange).c(this.f20536c.getLineHeight()).a().b();
            b2.a(SQLBuilder.BLANK + com.garena.android.appkit.tools.b.e(R.string.sp_chat_blocked_hint)).b().b().a(this.f20536c);
        }
    }

    public void a(boolean z2) {
        this.s = z2;
        x();
    }

    public void b(String str) {
        com.shopee.app.h.r.a().a(str);
    }

    public void c(String str) {
        com.shopee.app.ui.dialog.a.a(getContext(), str, "", com.garena.android.appkit.tools.b.e(R.string.button_ok), (a.C0318a) null);
    }

    public void a(ShopDetail shopDetail) {
        this.x = shopDetail;
        List<ChatMessage> d2 = this.u.d();
        if (d2 != null && !d2.isEmpty()) {
            a(d2);
        }
    }

    public void l() {
        if (this.E != null) {
            ShopDetail shopDetail = this.x;
            if (shopDetail == null || shopDetail.isOfferEnabled()) {
                OfferTabActivity_.a(getContext()).b(this.E.getShopId()).c(this.y).a((int) http.Request_Timeout);
            } else {
                OfferTabActivity_.a(getContext()).b(this.E.getShopId()).a(true).c(this.y).a((int) http.Request_Timeout);
            }
        }
    }

    public void m() {
        if (this.E != null) {
            BuyProductSelectActivity_.a(getContext()).b(this.E.getShopId()).c(this.y).a(HttpResponseCode.NOT_ACCEPTABLE);
        }
    }

    public void d(String str) {
        com.shopee.app.ui.dialog.a.a(getContext(), "", str, 0, (int) R.string.button_cancel);
    }

    public void c(ItemDetail itemDetail) {
        this.i.c(itemDetail);
    }

    public void n() {
        this.D = true;
    }

    public void a(long j2) {
        this.J.put(j2, true);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        if (this.H == null) {
            this.H = com.shopee.app.ui.chat2.b.e.a(getContext());
        }
        this.H.a(this.G);
        this.f20537d.a((View) this.H, 0);
        this.f20537d.c();
    }

    /* access modifiers changed from: package-private */
    public void p() {
        this.f20537d.a((View) com.shopee.app.ui.chat2.send.b.a(getContext(), this.x, this.D), 0);
        this.f20537d.c();
    }

    public void q() {
        b();
        com.shopee.app.c.a.b(this.f20535b.getEditText());
    }

    public void r() {
        this.f20535b.j();
        this.f20537d.e();
    }

    public void s() {
        this.f20535b.j();
        this.f20537d.f();
    }

    public void a(int i2) {
        post(new Runnable() {
            public void run() {
                n.this.h();
                if (!n.this.f20537d.i()) {
                    n.this.f20535b.j();
                }
            }
        });
    }

    public void t() {
        post(new Runnable() {
            public void run() {
                n.this.h();
                n.this.f20535b.j();
            }
        });
    }

    public boolean u() {
        boolean z2 = !this.f20537d.g() && this.f20537d.i();
        if (z2) {
            this.f20537d.h();
            this.f20535b.j();
        }
        return z2;
    }

    public void d(List<StickerPack> list) {
        this.G = list;
        this.f20535b.a(!af.a(this.G));
        d dVar = this.H;
        if (dVar != null) {
            dVar.a(this.G);
        }
    }

    public void v() {
        this.v.d();
    }

    public void setMessageDeleted(boolean z2) {
        this.F = z2;
    }

    public void e(String str) {
        this.f20535b.a(str);
        this.f20535b.a("");
        com.shopee.app.c.a.b(this.f20535b.getEditText());
    }

    public void w() {
        this.k.w();
    }

    private static class a extends com.shopee.app.ui.a.t<ChatMessage> {
        a(com.shopee.app.ui.a.s<ChatMessage> sVar, ImpressionObserver impressionObserver) {
            super(sVar, impressionObserver);
        }

        public void onBindViewHolder(RecyclerView.w wVar, int i) {
            ChatMessage chatMessage = (ChatMessage) a(i);
            if (chatMessage != null) {
                chatMessage.setPosition(i);
            }
            super.onBindViewHolder(wVar, i);
        }

        public void onViewAttachedToWindow(RecyclerView.w wVar) {
            super.onViewAttachedToWindow(wVar);
            if (wVar.itemView instanceof com.shopee.app.ui.chat.cell.ak) {
                ((com.shopee.app.ui.chat.cell.ak) wVar.itemView).f20062a.onResume();
            }
        }

        public void onViewDetachedFromWindow(RecyclerView.w wVar) {
            super.onViewDetachedFromWindow(wVar);
            if (wVar.itemView instanceof com.shopee.app.ui.chat.cell.ak) {
                ((com.shopee.app.ui.chat.cell.ak) wVar.itemView).f20062a.onPause();
            }
        }
    }

    private static class b extends f.a {

        /* renamed from: a  reason: collision with root package name */
        private final List<ChatMessage> f20550a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ChatMessage> f20551b;

        public b(List<ChatMessage> list, List<ChatMessage> list2) {
            this.f20550a = list;
            this.f20551b = list2;
        }

        public int a() {
            return this.f20550a.size();
        }

        public int b() {
            return this.f20551b.size();
        }

        public boolean a(int i, int i2) {
            return this.f20550a.get(i).getGeneratedId().equals(this.f20551b.get(i2).getGeneratedId());
        }

        public boolean b(int i, int i2) {
            return this.f20550a.get(i).equals(this.f20551b.get(i2));
        }
    }
}

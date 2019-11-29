package com.shopee.app.d.c.f;

import android.text.TextUtils;
import android.util.Pair;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.b.b;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.bg;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.store.p;
import com.shopee.app.data.store.x;
import com.shopee.app.data.viewmodel.chat2.ChatItem2;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBUserBrief;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.network.d.ad;
import com.shopee.app.network.d.ai;
import com.shopee.app.network.d.at;
import com.shopee.app.network.d.b.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class g extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final av f16974d;

    /* renamed from: e  reason: collision with root package name */
    private final bg f16975e;

    /* renamed from: f  reason: collision with root package name */
    private final p f16976f;

    /* renamed from: g  reason: collision with root package name */
    private final ChatBadgeStore f16977g;
    private final ah h;
    private final c i;
    private final x j;
    private final UserInfo k;

    protected g(n nVar, bg bgVar, p pVar, ChatBadgeStore chatBadgeStore, ah ahVar, c cVar, x xVar, av avVar, UserInfo userInfo) {
        super(nVar);
        this.f16975e = bgVar;
        this.f16974d = avVar;
        this.f16977g = chatBadgeStore;
        this.j = xVar;
        this.f16976f = pVar;
        this.h = ahVar;
        this.i = cVar;
        this.k = userInfo;
    }

    public void a(int i2, boolean z) {
        b(new a(i2, z));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        long j2;
        DBChatMessage dBChatMessage;
        HashMap<Long, DBItemDetail> hashMap;
        DBOrderDetail dBOrderDetail;
        DBItemDetail dBItemDetail;
        boolean z;
        DBItemDetail dBItemDetail2;
        List<DBChat> a2 = this.f16974d.a(this.f16977g.getUnreadChats(), ((long) (aVar.f16979a + 1)) * 20);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        Iterator<DBChat> it = a2.iterator();
        while (true) {
            j2 = 0;
            if (!it.hasNext()) {
                break;
            }
            DBChat next = it.next();
            if (next.h() > 0) {
                arrayList6.add(Integer.valueOf(next.b()));
                arrayList7.add(Long.valueOf(next.h()));
            }
        }
        HashMap<Integer, DBUserBrief> d2 = this.f16975e.d(arrayList6);
        HashMap<Long, DBChatMessage> d3 = this.f16976f.d(arrayList7);
        boolean z2 = false;
        for (DBChat next2 : a2) {
            if (next2.h() > j2) {
                DBChatMessage dBChatMessage2 = d3.get(Long.valueOf(next2.h()));
                if (dBChatMessage2 != null) {
                    boolean isMyShop = this.k.isMyShop(dBChatMessage2.h());
                    long i2 = dBChatMessage2.i();
                    if (i2 > 0) {
                        arrayList8.add(Long.valueOf(i2));
                    }
                    long m = dBChatMessage2.m();
                    if (m > 0) {
                        arrayList9.add(Long.valueOf(m));
                    }
                    z2 = isMyShop;
                }
                a aVar2 = aVar;
                j2 = 0;
            }
        }
        HashMap<Long, DBOrderDetail> e2 = this.i.e(arrayList9);
        HashMap<Long, DBItemDetail> b2 = this.h.b((List<Long>) arrayList8);
        Iterator<DBChat> it2 = a2.iterator();
        while (it2.hasNext()) {
            DBChat next3 = it2.next();
            if (next3.h() > 0) {
                int b3 = next3.b();
                DBUserBrief dBUserBrief = d2.get(Integer.valueOf(b3));
                if (dBUserBrief == null) {
                    arrayList.add(Integer.valueOf(b3));
                }
                long h2 = next3.h();
                Iterator<DBChat> it3 = it2;
                if (next3.i() > next3.o()) {
                    dBChatMessage = d3.get(Long.valueOf(h2));
                } else {
                    String n = next3.n();
                    if (!TextUtils.isEmpty(n)) {
                        dBChatMessage = this.f16976f.a(n);
                    } else {
                        dBChatMessage = d3.get(Long.valueOf(h2));
                    }
                }
                DBChatMessage dBChatMessage3 = dBChatMessage;
                if (dBChatMessage3 == null) {
                    arrayList2.add(Long.valueOf(h2));
                    hashMap = b2;
                    z = z2;
                    dBItemDetail = null;
                } else {
                    z = this.k.isMyShop(dBChatMessage3.h());
                    long i3 = dBChatMessage3.i();
                    if (i3 > 0) {
                        DBItemDetail dBItemDetail3 = b2.get(Long.valueOf(i3));
                        if (dBItemDetail3 == null) {
                            dBItemDetail2 = dBItemDetail3;
                            hashMap = b2;
                            arrayList4.add(new Pair(Integer.valueOf(dBChatMessage3.h()), Long.valueOf(i3)));
                        } else {
                            dBItemDetail2 = dBItemDetail3;
                            hashMap = b2;
                        }
                    } else {
                        hashMap = b2;
                        dBItemDetail2 = null;
                    }
                    long m2 = dBChatMessage3.m();
                    if (m2 > 0) {
                        DBOrderDetail dBOrderDetail2 = e2.get(Long.valueOf(m2));
                        if (dBOrderDetail2 == null) {
                            arrayList3.add(Long.valueOf(m2));
                        }
                        dBOrderDetail = dBOrderDetail2;
                        dBItemDetail = dBItemDetail2;
                        int a3 = this.j.a(b3);
                        ChatItem2 chatItem2 = new ChatItem2();
                        b.a(next3, dBUserBrief, dBChatMessage3, chatItem2, dBItemDetail, dBOrderDetail, this.f16977g.getChatCount(b3), a3, z);
                        chatItem2.setSearchKeyword("");
                        arrayList5.add(chatItem2);
                        z2 = z;
                        it2 = it3;
                        b2 = hashMap;
                    } else {
                        dBItemDetail = dBItemDetail2;
                    }
                }
                dBOrderDetail = null;
                int a32 = this.j.a(b3);
                ChatItem2 chatItem22 = new ChatItem2();
                b.a(next3, dBUserBrief, dBChatMessage3, chatItem22, dBItemDetail, dBOrderDetail, this.f16977g.getChatCount(b3), a32, z);
                chatItem22.setSearchKeyword("");
                arrayList5.add(chatItem22);
                z2 = z;
                it2 = it3;
                b2 = hashMap;
            }
        }
        Collections.sort(arrayList5, new Comparator<ChatItem2>() {
            /* renamed from: a */
            public int compare(ChatItem2 chatItem2, ChatItem2 chatItem22) {
                return -(chatItem2.getLastMsgTime() - chatItem22.getLastMsgTime());
            }
        });
        this.f16405a.a("CHAT_UNREAD_LIST_LOAD", new com.garena.android.appkit.b.a(arrayList5));
        if (aVar.f16980b) {
            if (!af.a(arrayList)) {
                new at().a(arrayList);
            }
            if (!af.a(arrayList2)) {
                new f().a(arrayList2);
            }
            if (!af.a(arrayList4)) {
                new ad().a(arrayList4);
            }
            if (!af.a(arrayList3)) {
                new com.shopee.app.network.d.h.g().a((List<Long>) arrayList3);
            }
            if (!af.a(arrayList6)) {
                new ai().a(1, arrayList6);
            }
        }
    }

    public static class a extends a.C0253a {

        /* renamed from: a  reason: collision with root package name */
        public final int f16979a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean f16980b;

        public a(int i, boolean z) {
            super("GetUnreadChatListInteractor" + i + z, "use_case4", 500, true);
            this.f16979a = i;
            this.f16980b = z;
        }
    }
}

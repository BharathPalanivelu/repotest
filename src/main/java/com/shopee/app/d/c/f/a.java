package com.shopee.app.d.c.f;

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
import com.shopee.app.network.d.at;
import com.shopee.app.network.d.b.f;
import com.shopee.app.network.d.h.g;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class a extends com.shopee.app.d.c.a.a<C0255a> {

    /* renamed from: d  reason: collision with root package name */
    private final av f16936d;

    /* renamed from: e  reason: collision with root package name */
    private final bg f16937e;

    /* renamed from: f  reason: collision with root package name */
    private final p f16938f;

    /* renamed from: g  reason: collision with root package name */
    private final ChatBadgeStore f16939g;
    private final ah h;
    private final c i;
    private final x j;
    private final UserInfo k;

    /* renamed from: com.shopee.app.d.c.f.a$a  reason: collision with other inner class name */
    public static class C0255a extends a.C0253a {

        /* renamed from: a  reason: collision with root package name */
        public final String f16940a;
    }

    protected a(n nVar, bg bgVar, p pVar, ChatBadgeStore chatBadgeStore, ah ahVar, c cVar, x xVar, av avVar, UserInfo userInfo) {
        super(nVar);
        this.f16937e = bgVar;
        this.f16936d = avVar;
        this.f16939g = chatBadgeStore;
        this.j = xVar;
        this.f16938f = pVar;
        this.h = ahVar;
        this.i = cVar;
        this.k = userInfo;
    }

    /* access modifiers changed from: protected */
    public void a(C0255a aVar) {
        long j2;
        HashMap<Integer, DBUserBrief> hashMap;
        DBOrderDetail dBOrderDetail;
        DBItemDetail dBItemDetail;
        DBItemDetail dBItemDetail2;
        C0255a aVar2 = aVar;
        List<DBChat> a2 = this.f16936d.a();
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
        HashMap<Integer, DBUserBrief> d2 = this.f16937e.d(arrayList6);
        HashMap<Long, DBChatMessage> d3 = this.f16938f.d(arrayList7);
        boolean z = false;
        for (DBChat next2 : a2) {
            if (next2.h() > j2) {
                DBChatMessage dBChatMessage = d3.get(Long.valueOf(next2.h()));
                if (dBChatMessage != null) {
                    z = this.k.isMyShop(dBChatMessage.h());
                    long i2 = dBChatMessage.i();
                    if (i2 > 0) {
                        arrayList8.add(Long.valueOf(i2));
                    }
                    long m = dBChatMessage.m();
                    if (m > 0) {
                        arrayList9.add(Long.valueOf(m));
                    }
                }
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
                DBChatMessage dBChatMessage2 = d3.get(Long.valueOf(h2));
                if (dBChatMessage2 == null) {
                    arrayList2.add(Long.valueOf(h2));
                    hashMap = d2;
                    dBItemDetail = null;
                } else {
                    z = this.k.isMyShop(dBChatMessage2.h());
                    long i3 = dBChatMessage2.i();
                    if (i3 > 0) {
                        DBItemDetail dBItemDetail3 = b2.get(Long.valueOf(i3));
                        if (dBItemDetail3 == null) {
                            dBItemDetail2 = dBItemDetail3;
                            hashMap = d2;
                            arrayList4.add(new Pair(Integer.valueOf(dBChatMessage2.h()), Long.valueOf(i3)));
                        } else {
                            dBItemDetail2 = dBItemDetail3;
                            hashMap = d2;
                        }
                    } else {
                        hashMap = d2;
                        dBItemDetail2 = null;
                    }
                    long m2 = dBChatMessage2.m();
                    if (m2 > 0) {
                        DBOrderDetail dBOrderDetail2 = e2.get(Long.valueOf(m2));
                        if (dBOrderDetail2 == null) {
                            arrayList3.add(Long.valueOf(m2));
                        }
                        dBOrderDetail = dBOrderDetail2;
                        dBItemDetail = dBItemDetail2;
                        int a3 = this.j.a(b3);
                        ChatItem2 chatItem2 = new ChatItem2();
                        b.a(next3, dBUserBrief, dBChatMessage2, chatItem2, dBItemDetail, dBOrderDetail, this.f16939g.getChatCount(b3), a3, z);
                        chatItem2.setSearchKeyword(aVar2.f16940a);
                        arrayList5.add(chatItem2);
                        it2 = it3;
                        d2 = hashMap;
                    } else {
                        dBItemDetail = dBItemDetail2;
                    }
                }
                dBOrderDetail = null;
                int a32 = this.j.a(b3);
                ChatItem2 chatItem22 = new ChatItem2();
                b.a(next3, dBUserBrief, dBChatMessage2, chatItem22, dBItemDetail, dBOrderDetail, this.f16939g.getChatCount(b3), a32, z);
                chatItem22.setSearchKeyword(aVar2.f16940a);
                arrayList5.add(chatItem22);
                it2 = it3;
                d2 = hashMap;
            }
        }
        this.f16405a.a("CHAT_LIST_LOCAL_LOAD_SEARCH", new com.garena.android.appkit.b.a(new Pair(arrayList5, aVar2.f16940a)));
        if (!arrayList.isEmpty()) {
            new at().a(arrayList);
        }
        if (!arrayList2.isEmpty()) {
            new f().a(arrayList2);
        }
        if (!arrayList4.isEmpty()) {
            new ad().a(arrayList4);
        }
        if (!arrayList3.isEmpty()) {
            new g().a((List<Long>) arrayList3);
        }
    }
}

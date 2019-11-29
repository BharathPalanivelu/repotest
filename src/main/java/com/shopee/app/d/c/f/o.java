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
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.data.viewmodel.chat2.ChatItem2;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBUserBrief;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.network.d.ad;
import com.shopee.app.network.d.ai;
import com.shopee.app.network.d.b.f;
import com.shopee.app.network.d.h.g;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class o extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final av f17001d;

    /* renamed from: e  reason: collision with root package name */
    private final bg f17002e;

    /* renamed from: f  reason: collision with root package name */
    private final p f17003f;

    /* renamed from: g  reason: collision with root package name */
    private final ChatBadgeStore f17004g;
    private final ah h;
    private final c i;
    private final x j;
    private final UserInfo k;

    protected o(n nVar, bg bgVar, p pVar, UserInfo userInfo, ChatBadgeStore chatBadgeStore, ah ahVar, c cVar, x xVar, av avVar) {
        super(nVar);
        this.f17002e = bgVar;
        this.f17001d = avVar;
        this.f17003f = pVar;
        this.f17004g = chatBadgeStore;
        this.j = xVar;
        this.h = ahVar;
        this.i = cVar;
        this.k = userInfo;
    }

    public void a(String str, int i2, List<UserData> list, boolean z) {
        b(new a(str, i2, list, z));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        long j2;
        DBChatMessage dBChatMessage;
        HashMap<Long, DBChatMessage> hashMap;
        Iterator<DBChat> it;
        long j3;
        boolean z;
        DBOrderDetail dBOrderDetail;
        DBItemDetail dBItemDetail;
        DBItemDetail dBItemDetail2;
        int a2 = (aVar.f17009c + 1) * 20;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (UserData userData : aVar.f17007a) {
            if (userData.getUserName().contains(aVar.f17008b)) {
                arrayList.add(Integer.valueOf(userData.getUserId()));
                i2++;
                continue;
            }
            if (i2 >= a2) {
                break;
            }
        }
        List<DBChat> a3 = this.f17001d.a(arrayList, (long) a2);
        List<T> a4 = af.a(a3, new af.b<Long, DBChat>() {
            /* renamed from: a */
            public Long map(DBChat dBChat) {
                return Long.valueOf(dBChat.h());
            }
        });
        HashMap<Integer, DBUserBrief> d2 = this.f17002e.d(arrayList);
        HashMap<Long, DBChatMessage> d3 = this.f17003f.d(a4);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<DBChat> it2 = a3.iterator();
        while (true) {
            j2 = 0;
            if (!it2.hasNext()) {
                break;
            }
            DBChatMessage dBChatMessage2 = d3.get(Long.valueOf(it2.next().h()));
            if (dBChatMessage2 != null) {
                long i3 = dBChatMessage2.i();
                if (i3 > 0) {
                    arrayList2.add(Long.valueOf(i3));
                }
                long m = dBChatMessage2.m();
                if (m > 0) {
                    arrayList3.add(Long.valueOf(m));
                }
            }
        }
        HashMap<Long, DBOrderDetail> e2 = this.i.e(arrayList3);
        HashMap<Long, DBItemDetail> b2 = this.h.b((List<Long>) arrayList2);
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        Iterator<DBChat> it3 = a3.iterator();
        while (it3.hasNext()) {
            DBChat next = it3.next();
            if (next.h() > j2) {
                int b3 = next.b();
                DBUserBrief dBUserBrief = d2.get(Integer.valueOf(b3));
                long h2 = next.h();
                if (next.i() > next.o()) {
                    dBChatMessage = d3.get(Long.valueOf(h2));
                } else {
                    String n = next.n();
                    if (!TextUtils.isEmpty(n)) {
                        dBChatMessage = this.f17003f.a(n);
                    } else {
                        dBChatMessage = d3.get(Long.valueOf(h2));
                    }
                }
                if (dBChatMessage == null) {
                    arrayList4.add(Long.valueOf(h2));
                    it = it3;
                    hashMap = d3;
                    j3 = j2;
                    dBItemDetail = null;
                    dBOrderDetail = null;
                    z = false;
                } else {
                    boolean isMyShop = this.k.isMyShop(dBChatMessage.h());
                    long i4 = dBChatMessage.i();
                    if (i4 > 0) {
                        it = it3;
                        DBItemDetail dBItemDetail3 = b2.get(Long.valueOf(i4));
                        if (dBItemDetail3 == null) {
                            dBItemDetail2 = dBItemDetail3;
                            hashMap = d3;
                            arrayList6.add(new Pair(Integer.valueOf(dBChatMessage.h()), Long.valueOf(i4)));
                        } else {
                            dBItemDetail2 = dBItemDetail3;
                            hashMap = d3;
                        }
                    } else {
                        it = it3;
                        hashMap = d3;
                        dBItemDetail2 = null;
                    }
                    long m2 = dBChatMessage.m();
                    j3 = 0;
                    if (m2 > 0) {
                        DBOrderDetail dBOrderDetail2 = e2.get(Long.valueOf(m2));
                        if (dBOrderDetail2 == null) {
                            arrayList5.add(Long.valueOf(m2));
                        }
                        dBOrderDetail = dBOrderDetail2;
                        z = isMyShop;
                        dBItemDetail = dBItemDetail2;
                    } else {
                        z = isMyShop;
                        dBItemDetail = dBItemDetail2;
                        dBOrderDetail = null;
                    }
                }
                int a5 = this.j.a(b3);
                ChatItem2 chatItem2 = new ChatItem2();
                b.a(next, dBUserBrief, dBChatMessage, chatItem2, dBItemDetail, dBOrderDetail, this.f17004g.getChatCount(b3), a5, z);
                chatItem2.setSearchKeyword(aVar.f17008b);
                arrayList7.add(chatItem2);
                j2 = j3;
                it3 = it;
                d3 = hashMap;
            }
        }
        Collections.sort(arrayList7, new Comparator<ChatItem2>() {
            /* renamed from: a */
            public int compare(ChatItem2 chatItem2, ChatItem2 chatItem22) {
                return -(chatItem2.getLastMsgTime() - chatItem22.getLastMsgTime());
            }
        });
        this.f16405a.a().cI.a(arrayList7).a();
        if (aVar.f17010d) {
            if (!af.a(arrayList)) {
                new ai().a(1, arrayList);
            }
            if (!arrayList4.isEmpty()) {
                new f().a(arrayList4);
            }
            if (!arrayList6.isEmpty()) {
                new ad().a(arrayList6);
            }
            if (!arrayList5.isEmpty()) {
                new g().a((List<Long>) arrayList5);
            }
        }
    }

    public static class a extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List<UserData> f17007a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f17008b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f17009c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final boolean f17010d;

        public a(String str, int i, List<UserData> list, boolean z) {
            super("SearchChatForQueryInteractor", "use_case" + ((int) (Math.random() * 100.0d)) + 10, 0, false);
            this.f17008b = str;
            this.f17007a = list;
            this.f17009c = i;
            this.f17010d = z;
        }
    }
}

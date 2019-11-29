package com.shopee.app.d.c.f;

import android.text.TextUtils;
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
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class e extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final av f16961d;

    /* renamed from: e  reason: collision with root package name */
    private final bg f16962e;

    /* renamed from: f  reason: collision with root package name */
    private final p f16963f;

    /* renamed from: g  reason: collision with root package name */
    private final ChatBadgeStore f16964g;
    private final ah h;
    private final c i;
    private final x j;
    private final UserInfo k;

    protected e(n nVar, bg bgVar, p pVar, ChatBadgeStore chatBadgeStore, ah ahVar, c cVar, x xVar, av avVar, UserInfo userInfo) {
        super(nVar);
        this.f16962e = bgVar;
        this.f16961d = avVar;
        this.f16964g = chatBadgeStore;
        this.j = xVar;
        this.f16963f = pVar;
        this.h = ahVar;
        this.i = cVar;
        this.k = userInfo;
    }

    public void a(int i2) {
        b(new a(i2));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        long j2;
        DBChatMessage dBChatMessage;
        long j3;
        DBOrderDetail dBOrderDetail;
        DBItemDetail dBItemDetail;
        List<DBChat> b2 = this.f16961d.b(((long) (aVar.f16966a + 1)) * 20);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        Iterator<DBChat> it = b2.iterator();
        while (true) {
            j2 = 0;
            if (!it.hasNext()) {
                break;
            }
            DBChat next = it.next();
            if (next.h() > 0) {
                arrayList2.add(Integer.valueOf(next.b()));
                arrayList3.add(Long.valueOf(next.h()));
            }
        }
        HashMap<Integer, DBUserBrief> d2 = this.f16962e.d(arrayList2);
        HashMap<Long, DBChatMessage> d3 = this.f16963f.d(arrayList3);
        boolean z = false;
        for (DBChat next2 : b2) {
            if (next2.h() > 0) {
                DBChatMessage dBChatMessage2 = d3.get(Long.valueOf(next2.h()));
                if (dBChatMessage2 != null) {
                    z = this.k.isMyShop(dBChatMessage2.h());
                    long i2 = dBChatMessage2.i();
                    if (i2 > 0) {
                        arrayList4.add(Long.valueOf(i2));
                    }
                    long m = dBChatMessage2.m();
                    if (m > 0) {
                        arrayList5.add(Long.valueOf(m));
                    }
                }
            }
        }
        HashMap<Long, DBOrderDetail> e2 = this.i.e(arrayList5);
        HashMap<Long, DBItemDetail> b3 = this.h.b((List<Long>) arrayList4);
        for (DBChat next3 : b2) {
            if (next3.h() > j2) {
                int b4 = next3.b();
                DBUserBrief dBUserBrief = d2.get(Integer.valueOf(b4));
                long h2 = next3.h();
                if (next3.i() > next3.o()) {
                    dBChatMessage = d3.get(Long.valueOf(h2));
                } else {
                    String n = next3.n();
                    if (!TextUtils.isEmpty(n)) {
                        dBChatMessage = this.f16963f.a(n);
                    } else {
                        dBChatMessage = d3.get(Long.valueOf(h2));
                    }
                }
                DBChatMessage dBChatMessage3 = dBChatMessage;
                DBOrderDetail dBOrderDetail2 = null;
                if (dBChatMessage3 != null) {
                    z = this.k.isMyShop(dBChatMessage3.h());
                    long i3 = dBChatMessage3.i();
                    j3 = 0;
                    DBItemDetail dBItemDetail2 = i3 > 0 ? b3.get(Long.valueOf(i3)) : null;
                    long m2 = dBChatMessage3.m();
                    if (m2 > 0) {
                        dBOrderDetail2 = e2.get(Long.valueOf(m2));
                    }
                    dBOrderDetail = dBOrderDetail2;
                    dBItemDetail = dBItemDetail2;
                } else {
                    j3 = 0;
                    dBItemDetail = null;
                    dBOrderDetail = null;
                }
                int a2 = this.j.a(b4);
                ChatItem2 chatItem2 = new ChatItem2();
                b.a(next3, dBUserBrief, dBChatMessage3, chatItem2, dBItemDetail, dBOrderDetail, this.f16964g.getChatCount(b4), a2, z);
                chatItem2.setSearchKeyword("");
                arrayList.add(chatItem2);
                j2 = j3;
            }
        }
        Collections.sort(arrayList, new Comparator<ChatItem2>() {
            /* renamed from: a */
            public int compare(ChatItem2 chatItem2, ChatItem2 chatItem22) {
                return -(chatItem2.getLastMsgTime() - chatItem22.getLastMsgTime());
            }
        });
        this.f16405a.a("CHAT_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(arrayList));
    }

    public static class a extends a.C0253a {

        /* renamed from: a  reason: collision with root package name */
        public final int f16966a;

        public a(int i) {
            super("GetChatListLocalInteractor", "use_case4", 500, true);
            this.f16966a = i;
        }
    }
}

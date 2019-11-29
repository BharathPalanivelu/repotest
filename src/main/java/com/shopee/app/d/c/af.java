package com.shopee.app.d.c;

import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ar;
import com.shopee.app.data.store.j;
import com.shopee.app.data.store.p;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chat.ChatOfferMessage;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.chatP2P.DBOffer;
import com.shopee.app.network.d.c.c;
import com.shopee.app.util.n;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class af extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final n f16436d;

    /* renamed from: e  reason: collision with root package name */
    private final p f16437e;

    /* renamed from: f  reason: collision with root package name */
    private final UserInfo f16438f;

    /* renamed from: g  reason: collision with root package name */
    private final ar f16439g;
    private final j h;
    private final com.shopee.app.tracking.a i;
    private final SettingConfigStore j;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<ChatMessage> f16444a;

        /* renamed from: b  reason: collision with root package name */
        public long f16445b;

        /* renamed from: c  reason: collision with root package name */
        public ChatMessage f16446c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f16447d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f16448e = false;

        /* renamed from: f  reason: collision with root package name */
        public int f16449f;
    }

    public af(n nVar, p pVar, com.shopee.app.tracking.a aVar, ar arVar, j jVar, SettingConfigStore settingConfigStore, UserInfo userInfo) {
        super(nVar);
        this.f16436d = nVar;
        this.f16437e = pVar;
        this.f16439g = arVar;
        this.i = aVar;
        this.h = jVar;
        this.j = settingConfigStore;
        this.f16438f = userInfo;
    }

    public void a(int i2, int i3, long j2, boolean z) {
        b(new a(i2, i3, j2, z));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        a aVar2 = aVar;
        boolean z = true;
        List<DBChatMessage> a2 = this.f16437e.a(aVar2.f16440a, aVar2.f16441b + 1);
        a(a2, a2.size() >= aVar2.f16441b + 1);
        ArrayList arrayList = new ArrayList();
        ChatMessage chatMessage = null;
        ArrayList arrayList2 = new ArrayList();
        for (DBChatMessage next : a2) {
            ChatMessage a3 = com.shopee.app.d.b.a.a(next, this.f16438f.isMyShop(next.h()));
            if (chatMessage == null) {
                chatMessage = a3;
            }
            if (a3.getType() == 3) {
                ChatOfferMessage chatOfferMessage = (ChatOfferMessage) a3;
                if (chatOfferMessage.getOfferId() > 0) {
                    DBOffer b2 = this.f16439g.b(chatOfferMessage.getOfferId());
                    if (b2 == null) {
                        arrayList.add(Long.valueOf(chatOfferMessage.getOfferId()));
                    } else {
                        if (b2.k() == z && aVar2.f16443d) {
                            arrayList.add(Long.valueOf(chatOfferMessage.getOfferId()));
                        }
                        VMOffer vMOffer = new VMOffer();
                        VMOffer.map(b2, vMOffer);
                        chatOfferMessage.setOffer(vMOffer);
                    }
                }
                if (chatOfferMessage.isMyShop() || chatOfferMessage.getOfferStatus() != 2) {
                    ChatMessage chatMessage2 = new ChatMessage();
                    chatMessage2.setSystemMessage(true);
                    chatMessage2.setData(a3);
                    chatMessage2.setShopId(chatOfferMessage.getShopId());
                    chatMessage2.setItemId(chatOfferMessage.getItemId());
                    chatMessage2.setGeneratedId("offer_" + a3.getGeneratedId());
                    chatMessage2.setType(100);
                    chatMessage2.setModelId(chatOfferMessage.getModelId());
                    arrayList2.add(chatMessage2);
                } else {
                    ChatMessage chatMessage3 = new ChatMessage();
                    chatMessage3.setSystemMessage(z);
                    chatMessage3.setShopId(chatOfferMessage.getShopId());
                    chatMessage3.setItemId(chatOfferMessage.getItemId());
                    chatMessage3.setData(a3);
                    chatMessage3.setGeneratedId("offer_" + a3.getGeneratedId());
                    chatMessage3.setModelId(chatOfferMessage.getModelId());
                    chatMessage3.setType(101);
                    arrayList2.add(chatMessage3);
                }
            }
            if (!a3.isRemote() && a3.getSendStatus() == 4) {
                ChatMessage chatMessage4 = new ChatMessage();
                chatMessage4.setSystemMessage(true);
                chatMessage4.setData(a3);
                chatMessage4.setShopId(a3.getShopId());
                chatMessage4.setItemId(a3.getItemId());
                chatMessage4.setOrderId(a3.getOrderId());
                chatMessage4.setText(next.r());
                chatMessage4.setGeneratedId("error_" + a3.getGeneratedId());
                chatMessage4.setType(100);
                arrayList2.add(chatMessage4);
            }
            arrayList2.add(a3);
            z = true;
        }
        if (!com.shopee.app.util.af.a(arrayList)) {
            new c().a(arrayList);
        }
        b bVar = new b();
        bVar.f16444a = arrayList2;
        bVar.f16445b = aVar2.f16442c;
        bVar.f16446c = chatMessage;
        bVar.f16447d = aVar2.f16443d;
        boolean z2 = true;
        if (a2.size() < aVar2.f16441b + 1) {
            z2 = false;
        }
        bVar.f16448e = z2;
        bVar.f16449f = aVar2.f16440a;
        this.f16436d.a("CHAT_MESSAGE_LOAD", new com.garena.android.appkit.b.a(bVar));
    }

    private void a(List<DBChatMessage> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        List<String> a2 = this.h.a();
        ArrayList arrayList2 = new ArrayList();
        for (String compile : a2) {
            try {
                arrayList2.add(Pattern.compile(compile, 2));
            } catch (Exception unused) {
            }
        }
        int i2 = 0;
        while (true) {
            if (i2 >= list.size()) {
                i2 = -1;
                break;
            } else if (list.get(i2).u()) {
                break;
            } else {
                i2++;
            }
        }
        if (!z && i2 == -1 && this.j.showFirstMessageScam()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                DBChatMessage dBChatMessage = list.get(i3);
                if (!dBChatMessage.t()) {
                    if (dBChatMessage.g() != 0) {
                        dBChatMessage.h(1);
                    } else if (!com.shopee.app.d.b.a.a(dBChatMessage, this.f16438f.isMyShop(dBChatMessage.h())).isRemote() || i2 != -1) {
                        dBChatMessage.h(1);
                    } else {
                        dBChatMessage.h(3);
                        i2 = i3;
                    }
                    arrayList.add(dBChatMessage);
                }
            }
        }
        if (i2 != -1) {
            int i4 = i2;
            int i5 = i4;
            while (i4 >= 0) {
                DBChatMessage dBChatMessage2 = list.get(i4);
                if (i5 - i4 >= 10) {
                    if (!dBChatMessage2.t()) {
                        a(dBChatMessage2, (List<Pattern>) arrayList2);
                        arrayList.add(dBChatMessage2);
                    }
                    if (!dBChatMessage2.u()) {
                        i4--;
                    }
                } else if (!dBChatMessage2.u()) {
                    i4--;
                }
                i5 = i4;
                i4--;
            }
            int i6 = i2;
            int i7 = i6;
            while (i6 < list.size()) {
                DBChatMessage dBChatMessage3 = list.get(i6);
                if (i6 - i7 >= 10) {
                    if (!dBChatMessage3.t()) {
                        a(dBChatMessage3, (List<Pattern>) arrayList2);
                        arrayList.add(dBChatMessage3);
                    }
                    if (!dBChatMessage3.u()) {
                        i6++;
                    }
                } else if (!dBChatMessage3.u()) {
                    i6++;
                }
                i7 = i6;
                i6++;
            }
        }
        if (i2 == -1) {
            int i8 = -1;
            for (int i9 = 0; i9 < list.size(); i9++) {
                DBChatMessage dBChatMessage4 = list.get(i9);
                if (i8 == -1 || i8 - i9 >= 10) {
                    if (!dBChatMessage4.u()) {
                        if (!dBChatMessage4.t()) {
                            a(dBChatMessage4, (List<Pattern>) arrayList2);
                            arrayList.add(dBChatMessage4);
                            if (!dBChatMessage4.u()) {
                            }
                        }
                    }
                    i8 = i9;
                }
            }
        }
        this.f16437e.a((List<DBChatMessage>) arrayList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.shopee.app.database.orm.bean.DBChatMessage r5, java.util.List<java.util.regex.Pattern> r6) {
        /*
            r4 = this;
            int r0 = r5.g()
            r1 = 1
            if (r0 != 0) goto L_0x003f
            com.shopee.app.appuser.UserInfo r0 = r4.f16438f
            int r2 = r5.h()
            boolean r0 = r0.isMyShop(r2)
            com.shopee.app.data.viewmodel.chat.ChatMessage r0 = com.shopee.app.d.b.a.a((com.shopee.app.database.orm.bean.DBChatMessage) r5, (boolean) r0)
            boolean r2 = r0.isRemote()
            if (r2 == 0) goto L_0x003f
            java.util.Iterator r6 = r6.iterator()
        L_0x001f:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x003f
            java.lang.Object r2 = r6.next()
            java.util.regex.Pattern r2 = (java.util.regex.Pattern) r2
            java.lang.String r3 = r0.getText()
            java.lang.String r3 = r3.toLowerCase()
            java.util.regex.Matcher r2 = r2.matcher(r3)
            boolean r2 = r2.find()
            if (r2 == 0) goto L_0x001f
            r6 = 1
            goto L_0x0040
        L_0x003f:
            r6 = 0
        L_0x0040:
            if (r6 == 0) goto L_0x005c
            r6 = 3
            r5.h(r6)
            com.shopee.app.tracking.a r6 = r4.i
            int r0 = r5.d()
            int r1 = r5.e()
            java.lang.String r5 = r5.p()
            int r2 = com.garena.android.appkit.tools.a.a.a()
            r6.a((int) r0, (int) r1, (java.lang.String) r5, (int) r2)
            goto L_0x005f
        L_0x005c:
            r5.h(r1)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.d.c.af.a(com.shopee.app.database.orm.bean.DBChatMessage, java.util.List):void");
    }

    public static class a extends a.C0253a {

        /* renamed from: a  reason: collision with root package name */
        public int f16440a;

        /* renamed from: b  reason: collision with root package name */
        public int f16441b;

        /* renamed from: c  reason: collision with root package name */
        public long f16442c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f16443d;

        public a(int i, int i2, long j, boolean z) {
            super("GetChatMessagesInteractor" + i + i2 + j + z, "use_case2", 500, true);
            this.f16440a = i;
            this.f16441b = i2;
            this.f16442c = j;
            this.f16443d = z;
        }
    }
}

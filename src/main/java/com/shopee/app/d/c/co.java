package com.shopee.app.d.c;

import android.util.Pair;
import com.facebook.imagepipeline.memory.BitmapPoolType;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.c.c;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.chat.ChatIntention;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBUserBrief;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.network.d.ad;
import com.shopee.app.network.d.h.g;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class co extends com.shopee.app.d.c.a.a<b> {

    /* renamed from: d  reason: collision with root package name */
    private final n f16701d;

    /* renamed from: e  reason: collision with root package name */
    private final ah f16702e;

    /* renamed from: f  reason: collision with root package name */
    private final ao f16703f;

    /* renamed from: g  reason: collision with root package name */
    private final c f16704g;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<ChatMessage> f16705a;

        /* renamed from: b  reason: collision with root package name */
        public int f16706b;
    }

    public co(n nVar, c cVar, ah ahVar, ao aoVar) {
        super(nVar);
        this.f16701d = nVar;
        this.f16702e = ahVar;
        this.f16703f = aoVar;
        this.f16704g = cVar;
    }

    public void a(ChatIntention chatIntention, List<ChatMessage> list, boolean z, int i, boolean z2) {
        b(new b(chatIntention, list, z, i, z2));
    }

    /* access modifiers changed from: protected */
    public void a(b bVar) {
        ArrayList<ChatMessage> arrayList = new ArrayList<>(bVar.f16708b);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ChatMessage chatMessage = null;
        int i = 0;
        for (ChatMessage chatMessage2 : arrayList) {
            if (chatMessage == null) {
                chatMessage = chatMessage2;
            }
            if (i >= 1) {
                ChatMessage chatMessage3 = (ChatMessage) arrayList.get(i - 1);
                if (!(chatMessage3.getType() == 3 || chatMessage3.getType() == 4 || chatMessage3.getType() == 5 || chatMessage3.getType() == 2 || chatMessage3.hasSameIntention(chatMessage2))) {
                    if (chatMessage3.isItemIntention()) {
                        arrayList2.add(a(chatMessage3));
                        arrayList3.add(new Pair(Integer.valueOf(chatMessage3.getShopId()), Long.valueOf(chatMessage3.getItemId())));
                    } else if (chatMessage3.isOrderIntention()) {
                        arrayList2.add(b(chatMessage3));
                        if (chatMessage3.getOrderId() > 0) {
                            arrayList4.add(Long.valueOf(chatMessage3.getOrderId()));
                        }
                    }
                }
            }
            i++;
            if (chatMessage2.isScamContent()) {
                arrayList2.add(c(chatMessage2));
            }
            if (!chatMessage2.isRemote() && chatMessage2.isBlacklistCensored()) {
                arrayList2.add(d(chatMessage2));
            }
            arrayList2.add(chatMessage2);
        }
        ChatMessage chatMessage4 = new ChatMessage();
        chatMessage4.setGeneratedId(BitmapPoolType.DUMMY);
        chatMessage4.setItemId(bVar.f16707a.getItemId());
        chatMessage4.setShopId(bVar.f16707a.getShopId());
        chatMessage4.setOrderId(bVar.f16707a.getOrderId());
        if (i != 0) {
            if (!chatMessage4.hasSameIntention(chatMessage)) {
                if (chatMessage4.isItemIntention()) {
                    arrayList2.add(0, a(chatMessage4));
                    arrayList3.add(new Pair(Integer.valueOf(chatMessage4.getShopId()), Long.valueOf(chatMessage4.getItemId())));
                } else if (chatMessage4.isOrderIntention()) {
                    arrayList2.add(0, b(chatMessage4));
                    if (chatMessage4.getOrderId() > 0) {
                        arrayList4.add(Long.valueOf(chatMessage4.getOrderId()));
                    }
                }
            }
            if (bVar.f16709c) {
                arrayList2.remove(arrayList2.size() - 1);
            } else {
                ChatMessage chatMessage5 = (ChatMessage) arrayList2.get(arrayList2.size() - 1);
                if (!(chatMessage5.getType() == 3 || chatMessage5.getType() == 4 || chatMessage5.getType() == 5 || chatMessage5.getType() == 2 || chatMessage5.hasServerError())) {
                    if (chatMessage5.isItemIntention()) {
                        arrayList2.add(a(chatMessage5, "top_message"));
                        arrayList3.add(new Pair(Integer.valueOf(chatMessage5.getShopId()), Long.valueOf(chatMessage5.getItemId())));
                    } else if (chatMessage5.isOrderIntention()) {
                        arrayList2.add(b(chatMessage5, "top_message"));
                        if (chatMessage5.getOrderId() > 0) {
                            arrayList4.add(Long.valueOf(chatMessage5.getOrderId()));
                        }
                    }
                }
            }
        } else if (chatMessage4.isItemIntention()) {
            arrayList2.add(a(chatMessage4));
            arrayList3.add(new Pair(Integer.valueOf(chatMessage4.getShopId()), Long.valueOf(chatMessage4.getItemId())));
        } else if (chatMessage4.isOrderIntention()) {
            arrayList2.add(b(chatMessage4));
            if (chatMessage4.getOrderId() > 0) {
                arrayList4.add(Long.valueOf(chatMessage4.getOrderId()));
            }
        }
        if (bVar.i) {
            if (!af.a(arrayList3)) {
                new ad().a(arrayList3);
            }
            if (!af.a(arrayList4)) {
                new g().a((List<Long>) arrayList4);
            }
        }
        a aVar = new a();
        aVar.f16705a = arrayList2;
        aVar.f16706b = bVar.f16710d;
        this.f16701d.a("CHAT_MESSAGE_POST_PROCESS", new com.garena.android.appkit.b.a(aVar));
    }

    private ChatMessage a(ChatMessage chatMessage) {
        return a(chatMessage, "product_" + chatMessage.getGeneratedId());
    }

    private ChatMessage a(ChatMessage chatMessage, String str) {
        ItemDetail itemDetail = new ItemDetail();
        DBItemDetail a2 = this.f16702e.a(chatMessage.getItemId());
        if (a2 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f16703f.b(a2.a()));
            com.shopee.app.d.b.b.a(a2, (List<IModelDetail>) arrayList, itemDetail);
        } else {
            com.shopee.app.d.b.b.a(DBItemDetail.a(chatMessage.getShopId(), chatMessage.getItemId(), R.string.sp_product_name_placeholder), (List<IModelDetail>) new ArrayList(), itemDetail);
        }
        ChatMessage chatMessage2 = new ChatMessage();
        chatMessage2.setSystemMessage(true);
        chatMessage2.setData(itemDetail);
        chatMessage2.setText(String.valueOf(itemDetail.getItemName()));
        chatMessage2.setGeneratedId(str);
        chatMessage2.setType(102);
        if (chatMessage.isRemote()) {
            chatMessage2.setSendStatus(3);
        } else {
            chatMessage2.setSendStatus(chatMessage.getSendStatus());
        }
        return chatMessage2;
    }

    private ChatMessage b(ChatMessage chatMessage) {
        return b(chatMessage, "order_" + chatMessage.getGeneratedId());
    }

    private ChatMessage b(ChatMessage chatMessage, String str) {
        OrderDetail orderDetail = new OrderDetail();
        DBOrderDetail b2 = this.f16704g.b(chatMessage.getOrderId());
        if (b2 != null) {
            com.shopee.app.d.b.b.a(b2, (DBUserBrief) null, orderDetail);
        }
        ChatMessage chatMessage2 = new ChatMessage();
        chatMessage2.setSystemMessage(true);
        chatMessage2.setData(orderDetail);
        chatMessage2.setText(orderDetail.getSerialNumber());
        chatMessage2.setGeneratedId(str);
        chatMessage2.setType(103);
        if (chatMessage.isRemote()) {
            chatMessage2.setSendStatus(3);
        } else {
            chatMessage2.setSendStatus(chatMessage.getSendStatus());
        }
        return chatMessage2;
    }

    private ChatMessage c(ChatMessage chatMessage) {
        ChatMessage chatMessage2 = new ChatMessage();
        chatMessage2.setSystemMessage(true);
        chatMessage2.setData("SCAM");
        chatMessage2.setText("Safety tip: Always chat and complete transactions inside Shopee to protect yourself from scams.");
        chatMessage2.setGeneratedId("scam_" + chatMessage.getGeneratedId());
        chatMessage2.setShopId(chatMessage.getShopId());
        chatMessage2.setType(100);
        return chatMessage2;
    }

    private ChatMessage d(ChatMessage chatMessage) {
        ChatMessage chatMessage2 = new ChatMessage();
        chatMessage2.setSystemMessage(true);
        chatMessage2.setData("BLACK_LIST");
        chatMessage2.setGeneratedId("black_list_" + chatMessage.getGeneratedId());
        chatMessage2.setType(100);
        return chatMessage2;
    }

    public static class b extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final ChatIntention f16707a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final List<ChatMessage> f16708b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final boolean f16709c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final int f16710d;
        /* access modifiers changed from: private */
        public final boolean i;

        public b(ChatIntention chatIntention, List<ChatMessage> list, boolean z, int i2, boolean z2) {
            super("PostProcessChatMessagesInteractor" + list.size() + z2, "use_case", 0, false);
            this.f16707a = chatIntention;
            this.f16708b = list;
            this.f16709c = z;
            this.f16710d = i2;
            this.i = z2;
        }
    }
}

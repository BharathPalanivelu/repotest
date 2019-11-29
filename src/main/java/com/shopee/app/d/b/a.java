package com.shopee.app.d.b;

import com.garena.android.appkit.tools.b;
import com.shopee.app.data.store.bg;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.data.viewmodel.chat.ChatOfferMessage;
import com.shopee.app.database.orm.bean.DBUserBrief;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.id.R;

public class a {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v33, resolved type: com.shopee.app.data.viewmodel.chat.ChatImageMessage} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v39, resolved type: com.shopee.app.data.viewmodel.chat.ChatImageMessage} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v40, resolved type: com.shopee.app.data.viewmodel.chat.ChatImageMessage} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v41, resolved type: com.shopee.app.data.viewmodel.chat.ChatImageMessage} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v42, resolved type: com.shopee.app.data.viewmodel.chat.ChatImageMessage} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0072, code lost:
        r0 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0073, code lost:
        r7 = r1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x049c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.shopee.app.data.viewmodel.chat.ChatMessage a(com.shopee.app.database.orm.bean.DBChatMessage r11, boolean r12) {
        /*
            com.shopee.app.data.viewmodel.chat.ChatMessage r0 = new com.shopee.app.data.viewmodel.chat.ChatMessage
            r0.<init>()
            int r1 = r11.g()
            int r2 = r11.g()
            r3 = 2131889250(0x7f120c62, float:1.9413158E38)
            r4 = 2131887780(0x7f1206a4, float:1.9410177E38)
            java.lang.String r5 = "⛔ "
            r6 = 1
            r7 = 0
            switch(r2) {
                case 0: goto L_0x0435;
                case 1: goto L_0x0395;
                case 2: goto L_0x02d0;
                case 3: goto L_0x027b;
                case 4: goto L_0x02d0;
                case 5: goto L_0x0197;
                case 6: goto L_0x010f;
                case 7: goto L_0x001a;
                case 8: goto L_0x008e;
                case 9: goto L_0x0032;
                default: goto L_0x001a;
            }
        L_0x001a:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.String r1 = com.garena.android.appkit.tools.b.e(r4)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            r0.setText(r12)
            goto L_0x048c
        L_0x0032:
            com.shopee.app.data.viewmodel.chat.ChatMessage r12 = new com.shopee.app.data.viewmodel.chat.ChatMessage
            r12.<init>()
            r12.setSystemMessage(r6)
            int r2 = r11.d()     // Catch:{ Exception -> 0x0076 }
            com.shopee.app.data.viewmodel.UserData r2 = b(r2)     // Catch:{ Exception -> 0x0076 }
            com.squareup.wire.Wire r3 = com.shopee.app.network.f.f18486a     // Catch:{ Exception -> 0x0076 }
            byte[] r6 = r11.c()     // Catch:{ Exception -> 0x0076 }
            byte[] r8 = r11.c()     // Catch:{ Exception -> 0x0076 }
            int r8 = r8.length     // Catch:{ Exception -> 0x0076 }
            java.lang.Class<com.shopee.protocol.shop.ChatNotificationInfo> r9 = com.shopee.protocol.shop.ChatNotificationInfo.class
            com.squareup.wire.Message r3 = r3.parseFrom(r6, r7, r8, r9)     // Catch:{ Exception -> 0x0076 }
            com.shopee.protocol.shop.ChatNotificationInfo r3 = (com.shopee.protocol.shop.ChatNotificationInfo) r3     // Catch:{ Exception -> 0x0076 }
            if (r2 == 0) goto L_0x0072
            boolean r2 = r2.isMe()     // Catch:{ Exception -> 0x0076 }
            if (r2 == 0) goto L_0x0068
            java.lang.String r2 = r3.notification_for_sender     // Catch:{ Exception -> 0x0076 }
            r12.setText(r2)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r2 = r3.notification_for_sender     // Catch:{ Exception -> 0x0076 }
            r12.setHintText(r2)     // Catch:{ Exception -> 0x0076 }
            goto L_0x0072
        L_0x0068:
            java.lang.String r2 = r3.notification_for_receiver     // Catch:{ Exception -> 0x0076 }
            r12.setText(r2)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r2 = r3.notification_for_receiver     // Catch:{ Exception -> 0x0076 }
            r12.setHintText(r2)     // Catch:{ Exception -> 0x0076 }
        L_0x0072:
            r0 = r12
        L_0x0073:
            r7 = r1
            goto L_0x048c
        L_0x0076:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.String r1 = com.garena.android.appkit.tools.b.e(r4)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            r0.setText(r12)
            goto L_0x048c
        L_0x008e:
            com.shopee.app.data.viewmodel.chat.ChatMessage r12 = new com.shopee.app.data.viewmodel.chat.ChatMessage
            r12.<init>()
            com.squareup.wire.Wire r2 = com.shopee.app.network.f.f18486a     // Catch:{ Exception -> 0x00f7 }
            byte[] r8 = r11.c()     // Catch:{ Exception -> 0x00f7 }
            byte[] r9 = r11.c()     // Catch:{ Exception -> 0x00f7 }
            int r9 = r9.length     // Catch:{ Exception -> 0x00f7 }
            java.lang.Class<com.shopee.protocol.shop.ChatWebViewInfo> r10 = com.shopee.protocol.shop.ChatWebViewInfo.class
            com.squareup.wire.Message r2 = r2.parseFrom(r8, r7, r9, r10)     // Catch:{ Exception -> 0x00f7 }
            com.shopee.protocol.shop.ChatWebViewInfo r2 = (com.shopee.protocol.shop.ChatWebViewInfo) r2     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r2 = r2.url     // Catch:{ Exception -> 0x00f7 }
            r12.setData(r2)     // Catch:{ Exception -> 0x00f7 }
            r12.setSystemMessage(r6)     // Catch:{ Exception -> 0x00f7 }
            int r2 = r11.d()     // Catch:{ Exception -> 0x00f7 }
            com.shopee.app.data.viewmodel.UserData r2 = b(r2)     // Catch:{ Exception -> 0x00f7 }
            r8 = 2131889350(0x7f120cc6, float:1.9413361E38)
            if (r2 == 0) goto L_0x00dc
            boolean r3 = r2.isMe()     // Catch:{ Exception -> 0x00f7 }
            if (r3 == 0) goto L_0x00cc
            r2 = 2131889363(0x7f120cd3, float:1.9413387E38)
            java.lang.String r2 = com.garena.android.appkit.tools.b.e(r2)     // Catch:{ Exception -> 0x00f7 }
            r12.setText(r2)     // Catch:{ Exception -> 0x00f7 }
            goto L_0x00eb
        L_0x00cc:
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r2 = r2.getUserName()     // Catch:{ Exception -> 0x00f7 }
            r3[r7] = r2     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r2 = com.garena.android.appkit.tools.b.a(r8, r3)     // Catch:{ Exception -> 0x00f7 }
            r12.setText(r2)     // Catch:{ Exception -> 0x00f7 }
            goto L_0x00eb
        L_0x00dc:
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r3 = com.garena.android.appkit.tools.b.e(r3)     // Catch:{ Exception -> 0x00f7 }
            r2[r7] = r3     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r2 = com.garena.android.appkit.tools.b.a(r8, r2)     // Catch:{ Exception -> 0x00f7 }
            r12.setText(r2)     // Catch:{ Exception -> 0x00f7 }
        L_0x00eb:
            r2 = 2131887772(0x7f12069c, float:1.941016E38)
            java.lang.String r2 = com.garena.android.appkit.tools.b.e(r2)     // Catch:{ Exception -> 0x00f7 }
            r12.setHintText(r2)     // Catch:{ Exception -> 0x00f7 }
            goto L_0x0072
        L_0x00f7:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.String r1 = com.garena.android.appkit.tools.b.e(r4)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            r0.setText(r12)
            goto L_0x048c
        L_0x010f:
            com.shopee.app.data.viewmodel.chat.ChatStickerMessage r12 = new com.shopee.app.data.viewmodel.chat.ChatStickerMessage
            r12.<init>()
            com.squareup.wire.Wire r2 = com.shopee.app.network.f.f18486a     // Catch:{ Exception -> 0x017f }
            byte[] r8 = r11.c()     // Catch:{ Exception -> 0x017f }
            byte[] r9 = r11.c()     // Catch:{ Exception -> 0x017f }
            int r9 = r9.length     // Catch:{ Exception -> 0x017f }
            java.lang.Class<com.shopee.protocol.shop.ChatStickerInfo> r10 = com.shopee.protocol.shop.ChatStickerInfo.class
            com.squareup.wire.Message r2 = r2.parseFrom(r8, r7, r9, r10)     // Catch:{ Exception -> 0x017f }
            com.shopee.protocol.shop.ChatStickerInfo r2 = (com.shopee.protocol.shop.ChatStickerInfo) r2     // Catch:{ Exception -> 0x017f }
            java.lang.String r8 = r2.packid     // Catch:{ Exception -> 0x017f }
            r12.setPackId(r8)     // Catch:{ Exception -> 0x017f }
            java.lang.String r8 = r2.stickerid     // Catch:{ Exception -> 0x017f }
            r12.setStickerId(r8)     // Catch:{ Exception -> 0x017f }
            java.lang.String r2 = r2.format     // Catch:{ Exception -> 0x017f }
            r12.setFormat(r2)     // Catch:{ Exception -> 0x017f }
            int r2 = r11.d()     // Catch:{ Exception -> 0x017f }
            com.shopee.app.data.viewmodel.UserData r2 = b(r2)     // Catch:{ Exception -> 0x017f }
            r8 = 2131889349(0x7f120cc5, float:1.941336E38)
            if (r2 == 0) goto L_0x0164
            boolean r3 = r2.isMe()     // Catch:{ Exception -> 0x017f }
            if (r3 == 0) goto L_0x0154
            r2 = 2131889362(0x7f120cd2, float:1.9413385E38)
            java.lang.String r2 = com.garena.android.appkit.tools.b.e(r2)     // Catch:{ Exception -> 0x017f }
            r12.setText(r2)     // Catch:{ Exception -> 0x017f }
            goto L_0x0173
        L_0x0154:
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x017f }
            java.lang.String r2 = r2.getUserName()     // Catch:{ Exception -> 0x017f }
            r3[r7] = r2     // Catch:{ Exception -> 0x017f }
            java.lang.String r2 = com.garena.android.appkit.tools.b.a(r8, r3)     // Catch:{ Exception -> 0x017f }
            r12.setText(r2)     // Catch:{ Exception -> 0x017f }
            goto L_0x0173
        L_0x0164:
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x017f }
            java.lang.String r3 = com.garena.android.appkit.tools.b.e(r3)     // Catch:{ Exception -> 0x017f }
            r2[r7] = r3     // Catch:{ Exception -> 0x017f }
            java.lang.String r2 = com.garena.android.appkit.tools.b.a(r8, r2)     // Catch:{ Exception -> 0x017f }
            r12.setText(r2)     // Catch:{ Exception -> 0x017f }
        L_0x0173:
            r2 = 2131887771(0x7f12069b, float:1.9410158E38)
            java.lang.String r2 = com.garena.android.appkit.tools.b.e(r2)     // Catch:{ Exception -> 0x017f }
            r12.setHintText(r2)     // Catch:{ Exception -> 0x017f }
            goto L_0x0072
        L_0x017f:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.String r1 = com.garena.android.appkit.tools.b.e(r4)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            r0.setText(r12)
            goto L_0x048c
        L_0x0197:
            com.shopee.app.data.viewmodel.chat.ChatOrderMessage r12 = new com.shopee.app.data.viewmodel.chat.ChatOrderMessage
            r12.<init>()
            com.squareup.wire.Wire r2 = com.shopee.app.network.f.f18486a     // Catch:{ Exception -> 0x0263 }
            byte[] r8 = r11.c()     // Catch:{ Exception -> 0x0263 }
            byte[] r9 = r11.c()     // Catch:{ Exception -> 0x0263 }
            int r9 = r9.length     // Catch:{ Exception -> 0x0263 }
            java.lang.Class<com.shopee.protocol.shop.ChatOrderInfo> r10 = com.shopee.protocol.shop.ChatOrderInfo.class
            com.squareup.wire.Message r2 = r2.parseFrom(r8, r7, r9, r10)     // Catch:{ Exception -> 0x0263 }
            com.shopee.protocol.shop.ChatOrderInfo r2 = (com.shopee.protocol.shop.ChatOrderInfo) r2     // Catch:{ Exception -> 0x0263 }
            java.lang.Integer r8 = r2.shopid     // Catch:{ Exception -> 0x0263 }
            int r8 = com.shopee.app.d.b.b.a((java.lang.Integer) r8)     // Catch:{ Exception -> 0x0263 }
            r12.setShopId(r8)     // Catch:{ Exception -> 0x0263 }
            java.lang.Long r8 = r2.orderid     // Catch:{ Exception -> 0x0263 }
            long r8 = com.shopee.app.d.b.b.a((java.lang.Long) r8)     // Catch:{ Exception -> 0x0263 }
            r12.setOrderId(r8)     // Catch:{ Exception -> 0x0263 }
            java.lang.Long r8 = r2.checkoutid     // Catch:{ Exception -> 0x0263 }
            long r8 = com.shopee.app.d.b.b.a((java.lang.Long) r8)     // Catch:{ Exception -> 0x0263 }
            r12.setCheckoutId(r8)     // Catch:{ Exception -> 0x0263 }
            java.lang.String r8 = r2.ordersn     // Catch:{ Exception -> 0x0263 }
            java.lang.String r8 = com.shopee.app.d.b.b.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0263 }
            r12.setOrderSN(r8)     // Catch:{ Exception -> 0x0263 }
            java.lang.Long r8 = r2.total_price     // Catch:{ Exception -> 0x0263 }
            long r8 = com.shopee.app.d.b.b.a((java.lang.Long) r8)     // Catch:{ Exception -> 0x0263 }
            r12.setTotalPrice(r8)     // Catch:{ Exception -> 0x0263 }
            java.lang.String r8 = r2.currency     // Catch:{ Exception -> 0x0263 }
            java.lang.String r8 = com.shopee.app.d.b.b.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0263 }
            r12.setCurrency(r8)     // Catch:{ Exception -> 0x0263 }
            java.lang.String r8 = r2.order_status     // Catch:{ Exception -> 0x0263 }
            java.lang.String r8 = com.shopee.app.d.b.b.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0263 }
            r12.setOrderStatus(r8)     // Catch:{ Exception -> 0x0263 }
            java.util.List<java.lang.String> r8 = r2.item_image     // Catch:{ Exception -> 0x0263 }
            if (r8 != 0) goto L_0x01f8
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x0263 }
            r8.<init>()     // Catch:{ Exception -> 0x0263 }
            goto L_0x01fa
        L_0x01f8:
            java.util.List<java.lang.String> r8 = r2.item_image     // Catch:{ Exception -> 0x0263 }
        L_0x01fa:
            r12.setImageList(r8)     // Catch:{ Exception -> 0x0263 }
            java.lang.Integer r8 = r2.list_type     // Catch:{ Exception -> 0x0263 }
            int r8 = com.shopee.app.d.b.b.a((java.lang.Integer) r8)     // Catch:{ Exception -> 0x0263 }
            r12.setListType(r8)     // Catch:{ Exception -> 0x0263 }
            java.lang.Boolean r8 = r2.has_request_refund     // Catch:{ Exception -> 0x0263 }
            if (r8 != 0) goto L_0x020c
            r2 = -1
            goto L_0x0217
        L_0x020c:
            java.lang.Boolean r2 = r2.has_request_refund     // Catch:{ Exception -> 0x0263 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0263 }
            if (r2 == 0) goto L_0x0216
            r2 = 1
            goto L_0x0217
        L_0x0216:
            r2 = 0
        L_0x0217:
            r12.setReturnRequested(r2)     // Catch:{ Exception -> 0x0263 }
            int r2 = r11.d()     // Catch:{ Exception -> 0x0263 }
            com.shopee.app.data.viewmodel.UserData r2 = b(r2)     // Catch:{ Exception -> 0x0263 }
            r8 = 2131889348(0x7f120cc4, float:1.9413357E38)
            if (r2 == 0) goto L_0x0248
            boolean r3 = r2.isMe()     // Catch:{ Exception -> 0x0263 }
            if (r3 == 0) goto L_0x0238
            r2 = 2131889360(0x7f120cd0, float:1.9413381E38)
            java.lang.String r2 = com.garena.android.appkit.tools.b.e(r2)     // Catch:{ Exception -> 0x0263 }
            r12.setText(r2)     // Catch:{ Exception -> 0x0263 }
            goto L_0x0257
        L_0x0238:
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0263 }
            java.lang.String r2 = r2.getUserName()     // Catch:{ Exception -> 0x0263 }
            r3[r7] = r2     // Catch:{ Exception -> 0x0263 }
            java.lang.String r2 = com.garena.android.appkit.tools.b.a(r8, r3)     // Catch:{ Exception -> 0x0263 }
            r12.setText(r2)     // Catch:{ Exception -> 0x0263 }
            goto L_0x0257
        L_0x0248:
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0263 }
            java.lang.String r3 = com.garena.android.appkit.tools.b.e(r3)     // Catch:{ Exception -> 0x0263 }
            r2[r7] = r3     // Catch:{ Exception -> 0x0263 }
            java.lang.String r2 = com.garena.android.appkit.tools.b.a(r8, r2)     // Catch:{ Exception -> 0x0263 }
            r12.setText(r2)     // Catch:{ Exception -> 0x0263 }
        L_0x0257:
            r2 = 2131887769(0x7f120699, float:1.9410154E38)
            java.lang.String r2 = com.garena.android.appkit.tools.b.e(r2)     // Catch:{ Exception -> 0x0263 }
            r12.setHintText(r2)     // Catch:{ Exception -> 0x0263 }
            goto L_0x0072
        L_0x0263:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.String r1 = com.garena.android.appkit.tools.b.e(r4)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            r0.setText(r12)
            goto L_0x048c
        L_0x027b:
            com.shopee.app.data.viewmodel.chat.ChatOfferMessage r2 = new com.shopee.app.data.viewmodel.chat.ChatOfferMessage
            r2.<init>()
            com.squareup.wire.Wire r3 = com.shopee.app.network.f.f18486a     // Catch:{ Exception -> 0x02b8 }
            byte[] r6 = r11.c()     // Catch:{ Exception -> 0x02b8 }
            byte[] r8 = r11.c()     // Catch:{ Exception -> 0x02b8 }
            int r8 = r8.length     // Catch:{ Exception -> 0x02b8 }
            java.lang.Class<com.shopee.protocol.shop.ChatOfferInfo> r9 = com.shopee.protocol.shop.ChatOfferInfo.class
            com.squareup.wire.Message r3 = r3.parseFrom(r6, r7, r8, r9)     // Catch:{ Exception -> 0x02b8 }
            com.shopee.protocol.shop.ChatOfferInfo r3 = (com.shopee.protocol.shop.ChatOfferInfo) r3     // Catch:{ Exception -> 0x02b8 }
            com.shopee.app.d.b.b.a((com.shopee.protocol.shop.ChatOfferInfo) r3, (com.shopee.app.data.viewmodel.chat.ChatOfferMessage) r2)     // Catch:{ Exception -> 0x02b8 }
            int r6 = r11.d()     // Catch:{ Exception -> 0x02b8 }
            java.lang.Integer r8 = r3.offerStatus     // Catch:{ Exception -> 0x02b8 }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r12 = a(r2, r6, r8, r12)     // Catch:{ Exception -> 0x02b8 }
            r2.setText(r12)     // Catch:{ Exception -> 0x02b8 }
            java.lang.Integer r12 = r3.offerStatus     // Catch:{ Exception -> 0x02b8 }
            int r12 = r12.intValue()     // Catch:{ Exception -> 0x02b8 }
            java.lang.String r12 = a((int) r12)     // Catch:{ Exception -> 0x02b8 }
            r2.setHintText(r12)     // Catch:{ Exception -> 0x02b8 }
            r7 = r1
            r0 = r2
            goto L_0x048c
        L_0x02b8:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.String r1 = com.garena.android.appkit.tools.b.e(r4)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            r0.setText(r12)
            goto L_0x048c
        L_0x02d0:
            com.shopee.app.data.viewmodel.chat.ChatProductMessage r12 = new com.shopee.app.data.viewmodel.chat.ChatProductMessage
            r12.<init>()
            com.squareup.wire.Wire r2 = com.shopee.app.network.f.f18486a     // Catch:{ Exception -> 0x037d }
            byte[] r8 = r11.c()     // Catch:{ Exception -> 0x037d }
            byte[] r9 = r11.c()     // Catch:{ Exception -> 0x037d }
            int r9 = r9.length     // Catch:{ Exception -> 0x037d }
            java.lang.Class<com.shopee.protocol.shop.ChatProductInfo> r10 = com.shopee.protocol.shop.ChatProductInfo.class
            com.squareup.wire.Message r2 = r2.parseFrom(r8, r7, r9, r10)     // Catch:{ Exception -> 0x037d }
            com.shopee.protocol.shop.ChatProductInfo r2 = (com.shopee.protocol.shop.ChatProductInfo) r2     // Catch:{ Exception -> 0x037d }
            java.lang.String r8 = r2.price     // Catch:{ Exception -> 0x037d }
            r12.setPrice(r8)     // Catch:{ Exception -> 0x037d }
            java.lang.Long r8 = r2.itemid     // Catch:{ Exception -> 0x037d }
            long r8 = r8.longValue()     // Catch:{ Exception -> 0x037d }
            r12.setItemId(r8)     // Catch:{ Exception -> 0x037d }
            java.lang.Integer r8 = r2.shopid     // Catch:{ Exception -> 0x037d }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x037d }
            r12.setShopId(r8)     // Catch:{ Exception -> 0x037d }
            java.lang.String r8 = r2.name     // Catch:{ Exception -> 0x037d }
            r12.setName(r8)     // Catch:{ Exception -> 0x037d }
            java.lang.String r8 = r2.thumbUrl     // Catch:{ Exception -> 0x037d }
            r12.setThumbUrl(r8)     // Catch:{ Exception -> 0x037d }
            java.lang.String r8 = r2.price_before_discount     // Catch:{ Exception -> 0x037d }
            r12.setPriceBeforeDiscount(r8)     // Catch:{ Exception -> 0x037d }
            java.lang.Long r8 = r2.snapshopid     // Catch:{ Exception -> 0x037d }
            if (r8 != 0) goto L_0x0315
            java.lang.Long r8 = r2.itemid     // Catch:{ Exception -> 0x037d }
            goto L_0x0317
        L_0x0315:
            java.lang.Long r8 = r2.snapshopid     // Catch:{ Exception -> 0x037d }
        L_0x0317:
            long r8 = r8.longValue()     // Catch:{ Exception -> 0x037d }
            r12.setSnapshotId(r8)     // Catch:{ Exception -> 0x037d }
            java.lang.String r8 = r2.modelname     // Catch:{ Exception -> 0x037d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x037d }
            if (r8 != 0) goto L_0x032b
            java.lang.String r8 = r2.modelname     // Catch:{ Exception -> 0x037d }
            r12.setModelName(r8)     // Catch:{ Exception -> 0x037d }
        L_0x032b:
            java.lang.Integer r2 = r2.quantity     // Catch:{ Exception -> 0x037d }
            int r2 = a((java.lang.Integer) r2)     // Catch:{ Exception -> 0x037d }
            r12.setProductCount(r2)     // Catch:{ Exception -> 0x037d }
            int r2 = r11.d()     // Catch:{ Exception -> 0x037d }
            com.shopee.app.data.viewmodel.UserData r2 = b(r2)     // Catch:{ Exception -> 0x037d }
            r8 = 2131889347(0x7f120cc3, float:1.9413355E38)
            if (r2 == 0) goto L_0x0362
            boolean r3 = r2.isMe()     // Catch:{ Exception -> 0x037d }
            if (r3 == 0) goto L_0x0352
            r2 = 2131889361(0x7f120cd1, float:1.9413383E38)
            java.lang.String r2 = com.garena.android.appkit.tools.b.e(r2)     // Catch:{ Exception -> 0x037d }
            r12.setText(r2)     // Catch:{ Exception -> 0x037d }
            goto L_0x0371
        L_0x0352:
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x037d }
            java.lang.String r2 = r2.getUserName()     // Catch:{ Exception -> 0x037d }
            r3[r7] = r2     // Catch:{ Exception -> 0x037d }
            java.lang.String r2 = com.garena.android.appkit.tools.b.a(r8, r3)     // Catch:{ Exception -> 0x037d }
            r12.setText(r2)     // Catch:{ Exception -> 0x037d }
            goto L_0x0371
        L_0x0362:
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x037d }
            java.lang.String r3 = com.garena.android.appkit.tools.b.e(r3)     // Catch:{ Exception -> 0x037d }
            r2[r7] = r3     // Catch:{ Exception -> 0x037d }
            java.lang.String r2 = com.garena.android.appkit.tools.b.a(r8, r2)     // Catch:{ Exception -> 0x037d }
            r12.setText(r2)     // Catch:{ Exception -> 0x037d }
        L_0x0371:
            r2 = 2131887770(0x7f12069a, float:1.9410156E38)
            java.lang.String r2 = com.garena.android.appkit.tools.b.e(r2)     // Catch:{ Exception -> 0x037d }
            r12.setHintText(r2)     // Catch:{ Exception -> 0x037d }
            goto L_0x0072
        L_0x037d:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.String r1 = com.garena.android.appkit.tools.b.e(r4)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            r0.setText(r12)
            goto L_0x048c
        L_0x0395:
            com.shopee.app.data.viewmodel.chat.ChatImageMessage r12 = new com.shopee.app.data.viewmodel.chat.ChatImageMessage
            r12.<init>()
            com.squareup.wire.Wire r2 = com.shopee.app.network.f.f18486a     // Catch:{ Exception -> 0x041e }
            byte[] r8 = r11.c()     // Catch:{ Exception -> 0x041e }
            byte[] r9 = r11.c()     // Catch:{ Exception -> 0x041e }
            int r9 = r9.length     // Catch:{ Exception -> 0x041e }
            java.lang.Class<com.shopee.protocol.shop.ChatImageInfo> r10 = com.shopee.protocol.shop.ChatImageInfo.class
            com.squareup.wire.Message r2 = r2.parseFrom(r8, r7, r9, r10)     // Catch:{ Exception -> 0x041e }
            com.shopee.protocol.shop.ChatImageInfo r2 = (com.shopee.protocol.shop.ChatImageInfo) r2     // Catch:{ Exception -> 0x041e }
            java.lang.String r8 = r2.imageUrl     // Catch:{ Exception -> 0x041e }
            r12.setImageUrl(r8)     // Catch:{ Exception -> 0x041e }
            java.lang.String r8 = r2.thumbUrl     // Catch:{ Exception -> 0x041e }
            r12.setThumbUrl(r8)     // Catch:{ Exception -> 0x041e }
            java.lang.Integer r8 = r2.thumbWidth     // Catch:{ Exception -> 0x041e }
            if (r8 != 0) goto L_0x03bd
            r8 = 0
            goto L_0x03c3
        L_0x03bd:
            java.lang.Integer r8 = r2.thumbWidth     // Catch:{ Exception -> 0x041e }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x041e }
        L_0x03c3:
            r12.setThumbWidth(r8)     // Catch:{ Exception -> 0x041e }
            java.lang.Integer r8 = r2.thumbHeight     // Catch:{ Exception -> 0x041e }
            if (r8 != 0) goto L_0x03cc
            r2 = 0
            goto L_0x03d2
        L_0x03cc:
            java.lang.Integer r2 = r2.thumbHeight     // Catch:{ Exception -> 0x041e }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x041e }
        L_0x03d2:
            r12.setThumbHeight(r2)     // Catch:{ Exception -> 0x041e }
            int r2 = r11.d()     // Catch:{ Exception -> 0x041e }
            com.shopee.app.data.viewmodel.UserData r2 = b(r2)     // Catch:{ Exception -> 0x041e }
            r8 = 2131888050(0x7f1207b2, float:1.9410724E38)
            if (r2 == 0) goto L_0x0403
            boolean r3 = r2.isMe()     // Catch:{ Exception -> 0x041e }
            if (r3 == 0) goto L_0x03f3
            r2 = 2131888051(0x7f1207b3, float:1.9410726E38)
            java.lang.String r2 = com.garena.android.appkit.tools.b.e(r2)     // Catch:{ Exception -> 0x041e }
            r12.setText(r2)     // Catch:{ Exception -> 0x041e }
            goto L_0x0412
        L_0x03f3:
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x041e }
            java.lang.String r2 = r2.getUserName()     // Catch:{ Exception -> 0x041e }
            r3[r7] = r2     // Catch:{ Exception -> 0x041e }
            java.lang.String r2 = com.garena.android.appkit.tools.b.a(r8, r3)     // Catch:{ Exception -> 0x041e }
            r12.setText(r2)     // Catch:{ Exception -> 0x041e }
            goto L_0x0412
        L_0x0403:
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x041e }
            java.lang.String r3 = com.garena.android.appkit.tools.b.e(r3)     // Catch:{ Exception -> 0x041e }
            r2[r7] = r3     // Catch:{ Exception -> 0x041e }
            java.lang.String r2 = com.garena.android.appkit.tools.b.a(r8, r2)     // Catch:{ Exception -> 0x041e }
            r12.setText(r2)     // Catch:{ Exception -> 0x041e }
        L_0x0412:
            r2 = 2131887767(0x7f120697, float:1.941015E38)
            java.lang.String r2 = com.garena.android.appkit.tools.b.e(r2)     // Catch:{ Exception -> 0x041e }
            r12.setHintText(r2)     // Catch:{ Exception -> 0x041e }
            goto L_0x0072
        L_0x041e:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.String r1 = com.garena.android.appkit.tools.b.e(r4)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            r0.setText(r12)
            goto L_0x048c
        L_0x0435:
            com.squareup.wire.Wire r12 = com.shopee.app.network.f.f18486a     // Catch:{ Exception -> 0x0476 }
            byte[] r2 = r11.c()     // Catch:{ Exception -> 0x0476 }
            byte[] r3 = r11.c()     // Catch:{ Exception -> 0x0476 }
            int r3 = r3.length     // Catch:{ Exception -> 0x0476 }
            java.lang.Class<com.shopee.protocol.shop.ChatTextInfo> r6 = com.shopee.protocol.shop.ChatTextInfo.class
            com.squareup.wire.Message r12 = r12.parseFrom(r2, r7, r3, r6)     // Catch:{ Exception -> 0x0476 }
            com.shopee.protocol.shop.ChatTextInfo r12 = (com.shopee.protocol.shop.ChatTextInfo) r12     // Catch:{ Exception -> 0x0476 }
            java.lang.String r2 = r12.text     // Catch:{ Exception -> 0x0476 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0476 }
            com.shopee.app.data.viewmodel.chat.ChatMessageTranslationInfo$Companion r2 = com.shopee.app.data.viewmodel.chat.ChatMessageTranslationInfo.Companion     // Catch:{ Exception -> 0x0476 }
            com.shopee.app.data.viewmodel.chat.ChatMessageTranslationInfo r2 = r2.from(r12)     // Catch:{ Exception -> 0x0476 }
            r0.setTranslationInfo(r2)     // Catch:{ Exception -> 0x0476 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0476 }
            r2.<init>()     // Catch:{ Exception -> 0x0476 }
            java.lang.String r3 = "%1$s: "
            r2.append(r3)     // Catch:{ Exception -> 0x0476 }
            java.lang.String r12 = r12.text     // Catch:{ Exception -> 0x0476 }
            java.lang.String r3 = "%"
            java.lang.String r6 = "%%"
            java.lang.String r12 = r12.replaceAll(r3, r6)     // Catch:{ Exception -> 0x0476 }
            r2.append(r12)     // Catch:{ Exception -> 0x0476 }
            java.lang.String r12 = r2.toString()     // Catch:{ Exception -> 0x0476 }
            r0.setHintText(r12)     // Catch:{ Exception -> 0x0476 }
            goto L_0x0073
        L_0x0476:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.String r1 = com.garena.android.appkit.tools.b.e(r4)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            r0.setText(r12)
        L_0x048c:
            com.shopee.app.d.b.b.a((com.shopee.app.database.orm.bean.DBChatMessage) r11, (com.shopee.app.data.viewmodel.chat.ChatMessage) r0)
            r0.setType(r7)
            int r12 = r11.d()
            com.shopee.app.data.viewmodel.UserData r12 = b(r12)
            if (r12 == 0) goto L_0x04a3
            java.lang.String r12 = r12.getPortrait()
            r0.setFromUserAvatar(r12)
        L_0x04a3:
            int r11 = r11.q()
            r0.setOpt(r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.d.b.a.a(com.shopee.app.database.orm.bean.DBChatMessage, boolean):com.shopee.app.data.viewmodel.chat.ChatMessage");
    }

    private static String a(int i) {
        if (i != 0) {
            if (i == 1) {
                return b.e(R.string.sp_chat_hint_make_offer_msg);
            }
            if (i != 2) {
                if (i != 3) {
                    return i != 4 ? "" : b.e(R.string.sp_chat_hint_cancel_offer_msg);
                }
                return b.e(R.string.sp_chat_hint_decline_offer_msg);
            }
        }
        return b.e(R.string.sp_chat_hint_accept_offer_msg);
    }

    private static String a(ChatOfferMessage chatOfferMessage, int i, int i2, boolean z) {
        if (z) {
            return a(chatOfferMessage, new bh().a(i).i(), i2);
        }
        return a(chatOfferMessage, i2);
    }

    private static String a(ChatOfferMessage chatOfferMessage, int i) {
        if (i != 0) {
            if (i == 1) {
                return b.a(R.string.sp_you_offer_n_price_x_n_quantity, chatOfferMessage.getPriceString(), String.valueOf(chatOfferMessage.getQuantity()));
            } else if (i != 2) {
                if (i != 3) {
                    return i != 4 ? "" : b.e(R.string.sp_you_cancel_offer);
                }
                return b.e(R.string.sp_your_offer_declined);
            }
        }
        return b.e(R.string.sp_your_order_accepted);
    }

    private static String a(ChatOfferMessage chatOfferMessage, String str, int i) {
        if (i == 1) {
            return b.a(R.string.sp_a_offer_n_x_n, str, chatOfferMessage.getPriceString(), String.valueOf(chatOfferMessage.getQuantity()));
        } else if (i == 2) {
            return b.e(R.string.sp_you_accept_offer);
        } else {
            if (i == 3) {
                return b.e(R.string.sp_you_decline_offer);
            }
            if (i != 4) {
                return "";
            }
            return b.a(R.string.sp_a_cancel_order, str);
        }
    }

    private static UserData b(int i) {
        DBUserInfo a2 = new bh().a(i);
        if (a2 != null) {
            UserData userData = new UserData();
            b.a(a2, userData);
            return userData;
        }
        DBUserBrief b2 = new bg().b(i);
        if (b2 == null) {
            return null;
        }
        UserData userData2 = new UserData();
        b.a(b2, userData2);
        return userData2;
    }

    public static int a(Integer num) {
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }
}

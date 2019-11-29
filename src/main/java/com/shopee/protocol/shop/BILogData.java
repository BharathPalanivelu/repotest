package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BILogData extends Message {
    public static final Integer DEFAULT_CMD = 0;
    public static final String DEFAULT_CMDNAME = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_EVENT_TIME = 0;
    public static final Long DEFAULT_EVENT_TIME_I64 = 0L;
    public static final String DEFAULT_IP = "";
    public static final Boolean DEFAULT_IS_NEW_ACCOUNT = false;
    public static final Boolean DEFAULT_IS_SHADOW = false;
    public static final Boolean DEFAULT_IS_WEB = false;
    public static final List<ItemModel> DEFAULT_MODEL = Collections.emptyList();
    public static final List<ItemModelExtInfo> DEFAULT_MODELEXT = Collections.emptyList();
    public static final List<OrderItem> DEFAULT_ORDER_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_SHOPID = 0;
    public static final List<Snapshot> DEFAULT_SNAPSHOT = Collections.emptyList();
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 13)
    public final Return _return;
    @ProtoField(tag = 8)
    public final Account acc;
    @ProtoField(tag = 9)
    public final AccountExtInfo accext;
    @ProtoField(tag = 25)
    public final Checkout checkout;
    @ProtoField(tag = 26)
    public final CheckoutInfo checkoutext;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer cmd;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String cmdname;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer event_time;
    @ProtoField(tag = 24, type = Message.Datatype.INT64)
    public final Long event_time_i64;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String ip;
    @ProtoField(tag = 21, type = Message.Datatype.BOOL)
    public final Boolean is_new_account;
    @ProtoField(tag = 27, type = Message.Datatype.BOOL)
    public final Boolean is_shadow;
    @ProtoField(tag = 15, type = Message.Datatype.BOOL)
    public final Boolean is_web;
    @ProtoField(tag = 17)
    public final Item item;
    @ProtoField(tag = 18)
    public final ItemExtInfo itemext;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModel.class, tag = 19)
    public final List<ItemModel> model;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModelExtInfo.class, tag = 20)
    public final List<ItemModelExtInfo> modelext;
    @ProtoField(tag = 10)
    public final Order order;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderItem.class, tag = 12)
    public final List<OrderItem> order_items;
    @ProtoField(tag = 11)
    public final OrderExtInfo orderext;
    @ProtoField(tag = 22)
    public final Refund refund;
    @ProtoField(tag = 23)
    public final RefundExtInfo refundext;
    @ProtoField(tag = 14)
    public final ReturnInfo returnext;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(label = Message.Label.REPEATED, messageType = Snapshot.class, tag = 16)
    public final List<Snapshot> snapshot;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;

    public BILogData(Integer num, String str, Integer num2, Integer num3, String str2, String str3, Integer num4, Account account, AccountExtInfo accountExtInfo, Order order2, OrderExtInfo orderExtInfo, List<OrderItem> list, Return returnR, ReturnInfo returnInfo, Boolean bool, List<Snapshot> list2, Item item2, ItemExtInfo itemExtInfo, List<ItemModel> list3, List<ItemModelExtInfo> list4, Boolean bool2, Refund refund2, RefundExtInfo refundExtInfo, Long l, Checkout checkout2, CheckoutInfo checkoutInfo, Boolean bool3) {
        this.cmd = num;
        this.cmdname = str;
        this.userid = num2;
        this.shopid = num3;
        this.country = str2;
        this.ip = str3;
        this.event_time = num4;
        this.acc = account;
        this.accext = accountExtInfo;
        this.order = order2;
        this.orderext = orderExtInfo;
        this.order_items = immutableCopyOf(list);
        this._return = returnR;
        this.returnext = returnInfo;
        this.is_web = bool;
        this.snapshot = immutableCopyOf(list2);
        this.item = item2;
        this.itemext = itemExtInfo;
        this.model = immutableCopyOf(list3);
        this.modelext = immutableCopyOf(list4);
        this.is_new_account = bool2;
        this.refund = refund2;
        this.refundext = refundExtInfo;
        this.event_time_i64 = l;
        this.checkout = checkout2;
        this.checkoutext = checkoutInfo;
        this.is_shadow = bool3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private BILogData(com.shopee.protocol.shop.BILogData.Builder r31) {
        /*
            r30 = this;
            r0 = r31
            r1 = r30
            java.lang.Integer r2 = r0.cmd
            java.lang.String r3 = r0.cmdname
            java.lang.Integer r4 = r0.userid
            java.lang.Integer r5 = r0.shopid
            java.lang.String r6 = r0.country
            java.lang.String r7 = r0.ip
            java.lang.Integer r8 = r0.event_time
            com.shopee.protocol.shop.Account r9 = r0.acc
            com.shopee.protocol.shop.AccountExtInfo r10 = r0.accext
            com.shopee.protocol.shop.Order r11 = r0.order
            com.shopee.protocol.shop.OrderExtInfo r12 = r0.orderext
            java.util.List<com.shopee.protocol.shop.OrderItem> r13 = r0.order_items
            com.shopee.protocol.shop.Return r14 = r0._return
            com.shopee.protocol.shop.ReturnInfo r15 = r0.returnext
            r29 = r1
            java.lang.Boolean r1 = r0.is_web
            r16 = r1
            java.util.List<com.shopee.protocol.shop.Snapshot> r1 = r0.snapshot
            r17 = r1
            com.shopee.protocol.shop.Item r1 = r0.item
            r18 = r1
            com.shopee.protocol.shop.ItemExtInfo r1 = r0.itemext
            r19 = r1
            java.util.List<com.shopee.protocol.shop.ItemModel> r1 = r0.model
            r20 = r1
            java.util.List<com.shopee.protocol.shop.ItemModelExtInfo> r1 = r0.modelext
            r21 = r1
            java.lang.Boolean r1 = r0.is_new_account
            r22 = r1
            com.shopee.protocol.shop.Refund r1 = r0.refund
            r23 = r1
            com.shopee.protocol.shop.RefundExtInfo r1 = r0.refundext
            r24 = r1
            java.lang.Long r1 = r0.event_time_i64
            r25 = r1
            com.shopee.protocol.shop.Checkout r1 = r0.checkout
            r26 = r1
            com.shopee.protocol.shop.CheckoutInfo r1 = r0.checkoutext
            r27 = r1
            java.lang.Boolean r1 = r0.is_shadow
            r28 = r1
            r1 = r29
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r30.setBuilder(r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.BILogData.<init>(com.shopee.protocol.shop.BILogData$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BILogData)) {
            return false;
        }
        BILogData bILogData = (BILogData) obj;
        if (!equals((Object) this.cmd, (Object) bILogData.cmd) || !equals((Object) this.cmdname, (Object) bILogData.cmdname) || !equals((Object) this.userid, (Object) bILogData.userid) || !equals((Object) this.shopid, (Object) bILogData.shopid) || !equals((Object) this.country, (Object) bILogData.country) || !equals((Object) this.ip, (Object) bILogData.ip) || !equals((Object) this.event_time, (Object) bILogData.event_time) || !equals((Object) this.acc, (Object) bILogData.acc) || !equals((Object) this.accext, (Object) bILogData.accext) || !equals((Object) this.order, (Object) bILogData.order) || !equals((Object) this.orderext, (Object) bILogData.orderext) || !equals((List<?>) this.order_items, (List<?>) bILogData.order_items) || !equals((Object) this._return, (Object) bILogData._return) || !equals((Object) this.returnext, (Object) bILogData.returnext) || !equals((Object) this.is_web, (Object) bILogData.is_web) || !equals((List<?>) this.snapshot, (List<?>) bILogData.snapshot) || !equals((Object) this.item, (Object) bILogData.item) || !equals((Object) this.itemext, (Object) bILogData.itemext) || !equals((List<?>) this.model, (List<?>) bILogData.model) || !equals((List<?>) this.modelext, (List<?>) bILogData.modelext) || !equals((Object) this.is_new_account, (Object) bILogData.is_new_account) || !equals((Object) this.refund, (Object) bILogData.refund) || !equals((Object) this.refundext, (Object) bILogData.refundext) || !equals((Object) this.event_time_i64, (Object) bILogData.event_time_i64) || !equals((Object) this.checkout, (Object) bILogData.checkout) || !equals((Object) this.checkoutext, (Object) bILogData.checkoutext) || !equals((Object) this.is_shadow, (Object) bILogData.is_shadow)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.cmd;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.cmdname;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.userid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.ip;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num4 = this.event_time;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Account account = this.acc;
        int hashCode8 = (hashCode7 + (account != null ? account.hashCode() : 0)) * 37;
        AccountExtInfo accountExtInfo = this.accext;
        int hashCode9 = (hashCode8 + (accountExtInfo != null ? accountExtInfo.hashCode() : 0)) * 37;
        Order order2 = this.order;
        int hashCode10 = (hashCode9 + (order2 != null ? order2.hashCode() : 0)) * 37;
        OrderExtInfo orderExtInfo = this.orderext;
        int hashCode11 = (hashCode10 + (orderExtInfo != null ? orderExtInfo.hashCode() : 0)) * 37;
        List<OrderItem> list = this.order_items;
        int i3 = 1;
        int hashCode12 = (hashCode11 + (list != null ? list.hashCode() : 1)) * 37;
        Return returnR = this._return;
        int hashCode13 = (hashCode12 + (returnR != null ? returnR.hashCode() : 0)) * 37;
        ReturnInfo returnInfo = this.returnext;
        int hashCode14 = (hashCode13 + (returnInfo != null ? returnInfo.hashCode() : 0)) * 37;
        Boolean bool = this.is_web;
        int hashCode15 = (hashCode14 + (bool != null ? bool.hashCode() : 0)) * 37;
        List<Snapshot> list2 = this.snapshot;
        int hashCode16 = (hashCode15 + (list2 != null ? list2.hashCode() : 1)) * 37;
        Item item2 = this.item;
        int hashCode17 = (hashCode16 + (item2 != null ? item2.hashCode() : 0)) * 37;
        ItemExtInfo itemExtInfo = this.itemext;
        int hashCode18 = (hashCode17 + (itemExtInfo != null ? itemExtInfo.hashCode() : 0)) * 37;
        List<ItemModel> list3 = this.model;
        int hashCode19 = (hashCode18 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<ItemModelExtInfo> list4 = this.modelext;
        if (list4 != null) {
            i3 = list4.hashCode();
        }
        int i4 = (hashCode19 + i3) * 37;
        Boolean bool2 = this.is_new_account;
        int hashCode20 = (i4 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Refund refund2 = this.refund;
        int hashCode21 = (hashCode20 + (refund2 != null ? refund2.hashCode() : 0)) * 37;
        RefundExtInfo refundExtInfo = this.refundext;
        int hashCode22 = (hashCode21 + (refundExtInfo != null ? refundExtInfo.hashCode() : 0)) * 37;
        Long l = this.event_time_i64;
        int hashCode23 = (hashCode22 + (l != null ? l.hashCode() : 0)) * 37;
        Checkout checkout2 = this.checkout;
        int hashCode24 = (hashCode23 + (checkout2 != null ? checkout2.hashCode() : 0)) * 37;
        CheckoutInfo checkoutInfo = this.checkoutext;
        int hashCode25 = (hashCode24 + (checkoutInfo != null ? checkoutInfo.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_shadow;
        if (bool3 != null) {
            i2 = bool3.hashCode();
        }
        int i5 = hashCode25 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<BILogData> {
        public Return _return;
        public Account acc;
        public AccountExtInfo accext;
        public Checkout checkout;
        public CheckoutInfo checkoutext;
        public Integer cmd;
        public String cmdname;
        public String country;
        public Integer event_time;
        public Long event_time_i64;
        public String ip;
        public Boolean is_new_account;
        public Boolean is_shadow;
        public Boolean is_web;
        public Item item;
        public ItemExtInfo itemext;
        public List<ItemModel> model;
        public List<ItemModelExtInfo> modelext;
        public Order order;
        public List<OrderItem> order_items;
        public OrderExtInfo orderext;
        public Refund refund;
        public RefundExtInfo refundext;
        public ReturnInfo returnext;
        public Integer shopid;
        public List<Snapshot> snapshot;
        public Integer userid;

        public Builder() {
        }

        public Builder(BILogData bILogData) {
            super(bILogData);
            if (bILogData != null) {
                this.cmd = bILogData.cmd;
                this.cmdname = bILogData.cmdname;
                this.userid = bILogData.userid;
                this.shopid = bILogData.shopid;
                this.country = bILogData.country;
                this.ip = bILogData.ip;
                this.event_time = bILogData.event_time;
                this.acc = bILogData.acc;
                this.accext = bILogData.accext;
                this.order = bILogData.order;
                this.orderext = bILogData.orderext;
                this.order_items = BILogData.copyOf(bILogData.order_items);
                this._return = bILogData._return;
                this.returnext = bILogData.returnext;
                this.is_web = bILogData.is_web;
                this.snapshot = BILogData.copyOf(bILogData.snapshot);
                this.item = bILogData.item;
                this.itemext = bILogData.itemext;
                this.model = BILogData.copyOf(bILogData.model);
                this.modelext = BILogData.copyOf(bILogData.modelext);
                this.is_new_account = bILogData.is_new_account;
                this.refund = bILogData.refund;
                this.refundext = bILogData.refundext;
                this.event_time_i64 = bILogData.event_time_i64;
                this.checkout = bILogData.checkout;
                this.checkoutext = bILogData.checkoutext;
                this.is_shadow = bILogData.is_shadow;
            }
        }

        public Builder cmd(Integer num) {
            this.cmd = num;
            return this;
        }

        public Builder cmdname(String str) {
            this.cmdname = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder ip(String str) {
            this.ip = str;
            return this;
        }

        public Builder event_time(Integer num) {
            this.event_time = num;
            return this;
        }

        public Builder acc(Account account) {
            this.acc = account;
            return this;
        }

        public Builder accext(AccountExtInfo accountExtInfo) {
            this.accext = accountExtInfo;
            return this;
        }

        public Builder order(Order order2) {
            this.order = order2;
            return this;
        }

        public Builder orderext(OrderExtInfo orderExtInfo) {
            this.orderext = orderExtInfo;
            return this;
        }

        public Builder order_items(List<OrderItem> list) {
            this.order_items = checkForNulls(list);
            return this;
        }

        public Builder _return(Return returnR) {
            this._return = returnR;
            return this;
        }

        public Builder returnext(ReturnInfo returnInfo) {
            this.returnext = returnInfo;
            return this;
        }

        public Builder is_web(Boolean bool) {
            this.is_web = bool;
            return this;
        }

        public Builder snapshot(List<Snapshot> list) {
            this.snapshot = checkForNulls(list);
            return this;
        }

        public Builder item(Item item2) {
            this.item = item2;
            return this;
        }

        public Builder itemext(ItemExtInfo itemExtInfo) {
            this.itemext = itemExtInfo;
            return this;
        }

        public Builder model(List<ItemModel> list) {
            this.model = checkForNulls(list);
            return this;
        }

        public Builder modelext(List<ItemModelExtInfo> list) {
            this.modelext = checkForNulls(list);
            return this;
        }

        public Builder is_new_account(Boolean bool) {
            this.is_new_account = bool;
            return this;
        }

        public Builder refund(Refund refund2) {
            this.refund = refund2;
            return this;
        }

        public Builder refundext(RefundExtInfo refundExtInfo) {
            this.refundext = refundExtInfo;
            return this;
        }

        public Builder event_time_i64(Long l) {
            this.event_time_i64 = l;
            return this;
        }

        public Builder checkout(Checkout checkout2) {
            this.checkout = checkout2;
            return this;
        }

        public Builder checkoutext(CheckoutInfo checkoutInfo) {
            this.checkoutext = checkoutInfo;
            return this;
        }

        public Builder is_shadow(Boolean bool) {
            this.is_shadow = bool;
            return this;
        }

        public BILogData build() {
            return new BILogData(this);
        }
    }
}

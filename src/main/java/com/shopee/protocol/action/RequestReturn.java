package com.shopee.protocol.action;

import com.shopee.protocol.shop.BankAccountInfo;
import com.shopee.protocol.shop.BuyerAddress;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RequestReturn extends Message {
    public static final Boolean DEFAULT_AUTO_APPROVE_RETURN_PROCESSING = false;
    public static final String DEFAULT_BUYER_IMAGES = "";
    public static final String DEFAULT_BUYER_PHONE_NUMBER = "";
    public static final String DEFAULT_BUYER_REAL_NAME = "";
    public static final String DEFAULT_EMAIL = "";
    public static final List<Long> DEFAULT_ITEMID = Collections.emptyList();
    public static final List<ItemModelId> DEFAULT_ITEMS = Collections.emptyList();
    public static final List<Long> DEFAULT_MODELID = Collections.emptyList();
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Boolean DEFAULT_PHYSICAL_RETURN_ALLOWED = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_RETURN_CHANNEL_ID = 0;
    public static final List<ReturnItem> DEFAULT_RETURN_ITEMS = Collections.emptyList();
    public static final Integer DEFAULT_RETURN_REASON = 0;
    public static final Integer DEFAULT_RETURN_SOLUTION = 0;
    public static final Integer DEFAULT_SELLER_DUE_DATE = 0;
    public static final String DEFAULT_SHIPPING_CARRIER = "";
    public static final Integer DEFAULT_SHIPPING_METHOD = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TEXT_REASON = "";
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_TRACKING_NUMBER = "";
    public static final Boolean DEFAULT_WAREHOUSE_VALIDATION = false;
    public static final Boolean DEFAULT_WITH_RESOLUTION_CENTER = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 27, type = Message.Datatype.BOOL)
    public final Boolean auto_approve_return_processing;
    @ProtoField(tag = 12)
    public final BankAccountInfo bank_account;
    @ProtoField(tag = 11)
    public final BackendParam bparam;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String buyer_images;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String buyer_phone_number;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String buyer_real_name;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT64)
    public final List<Long> itemid;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModelId.class, tag = 10)
    public final List<ItemModelId> items;
    @ProtoField(label = Message.Label.REPEATED, tag = 9, type = Message.Datatype.INT64)
    public final List<Long> modelid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 26, type = Message.Datatype.BOOL)
    public final Boolean physical_return_allowed;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer return_channel_id;
    @ProtoField(tag = 19)
    public final BuyerAddress return_delivery_address;
    @ProtoField(label = Message.Label.REPEATED, messageType = ReturnItem.class, tag = 25)
    public final List<ReturnItem> return_items;
    @ProtoField(tag = 15)
    public final BuyerAddress return_pickup_address;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer return_reason;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer return_solution;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer seller_due_date;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String shipping_carrier;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer shipping_method;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String text_reason;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String tracking_number;
    @ProtoField(tag = 28, type = Message.Datatype.BOOL)
    public final Boolean warehouse_validation;
    @ProtoField(tag = 23, type = Message.Datatype.BOOL)
    public final Boolean with_resolution_center;

    public RequestReturn(String str, Integer num, Long l, List<Long> list, String str2, Integer num2, String str3, String str4, List<Long> list2, List<ItemModelId> list3, BackendParam backendParam, BankAccountInfo bankAccountInfo, Integer num3, String str5, BuyerAddress buyerAddress, String str6, Integer num4, Integer num5, BuyerAddress buyerAddress2, String str7, String str8, String str9, Boolean bool, Integer num6, List<ReturnItem> list4, Boolean bool2, Boolean bool3, Boolean bool4) {
        this.requestid = str;
        this.shopid = num;
        this.orderid = l;
        this.itemid = immutableCopyOf(list);
        this.email = str2;
        this.return_reason = num2;
        this.token = str3;
        this.text_reason = str4;
        this.modelid = immutableCopyOf(list2);
        this.items = immutableCopyOf(list3);
        this.bparam = backendParam;
        this.bank_account = bankAccountInfo;
        this.seller_due_date = num3;
        this.buyer_images = str5;
        this.return_pickup_address = buyerAddress;
        this.tracking_number = str6;
        this.return_channel_id = num4;
        this.shipping_method = num5;
        this.return_delivery_address = buyerAddress2;
        this.shipping_carrier = str7;
        this.buyer_real_name = str8;
        this.buyer_phone_number = str9;
        this.with_resolution_center = bool;
        this.return_solution = num6;
        this.return_items = immutableCopyOf(list4);
        this.physical_return_allowed = bool2;
        this.auto_approve_return_processing = bool3;
        this.warehouse_validation = bool4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private RequestReturn(com.shopee.protocol.action.RequestReturn.Builder r32) {
        /*
            r31 = this;
            r0 = r32
            r1 = r31
            java.lang.String r2 = r0.requestid
            java.lang.Integer r3 = r0.shopid
            java.lang.Long r4 = r0.orderid
            java.util.List<java.lang.Long> r5 = r0.itemid
            java.lang.String r6 = r0.email
            java.lang.Integer r7 = r0.return_reason
            java.lang.String r8 = r0.token
            java.lang.String r9 = r0.text_reason
            java.util.List<java.lang.Long> r10 = r0.modelid
            java.util.List<com.shopee.protocol.action.ItemModelId> r11 = r0.items
            com.shopee.protocol.action.BackendParam r12 = r0.bparam
            com.shopee.protocol.shop.BankAccountInfo r13 = r0.bank_account
            java.lang.Integer r14 = r0.seller_due_date
            java.lang.String r15 = r0.buyer_images
            r30 = r1
            com.shopee.protocol.shop.BuyerAddress r1 = r0.return_pickup_address
            r16 = r1
            java.lang.String r1 = r0.tracking_number
            r17 = r1
            java.lang.Integer r1 = r0.return_channel_id
            r18 = r1
            java.lang.Integer r1 = r0.shipping_method
            r19 = r1
            com.shopee.protocol.shop.BuyerAddress r1 = r0.return_delivery_address
            r20 = r1
            java.lang.String r1 = r0.shipping_carrier
            r21 = r1
            java.lang.String r1 = r0.buyer_real_name
            r22 = r1
            java.lang.String r1 = r0.buyer_phone_number
            r23 = r1
            java.lang.Boolean r1 = r0.with_resolution_center
            r24 = r1
            java.lang.Integer r1 = r0.return_solution
            r25 = r1
            java.util.List<com.shopee.protocol.action.ReturnItem> r1 = r0.return_items
            r26 = r1
            java.lang.Boolean r1 = r0.physical_return_allowed
            r27 = r1
            java.lang.Boolean r1 = r0.auto_approve_return_processing
            r28 = r1
            java.lang.Boolean r1 = r0.warehouse_validation
            r29 = r1
            r1 = r30
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r31.setBuilder(r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.RequestReturn.<init>(com.shopee.protocol.action.RequestReturn$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestReturn)) {
            return false;
        }
        RequestReturn requestReturn = (RequestReturn) obj;
        if (!equals((Object) this.requestid, (Object) requestReturn.requestid) || !equals((Object) this.shopid, (Object) requestReturn.shopid) || !equals((Object) this.orderid, (Object) requestReturn.orderid) || !equals((List<?>) this.itemid, (List<?>) requestReturn.itemid) || !equals((Object) this.email, (Object) requestReturn.email) || !equals((Object) this.return_reason, (Object) requestReturn.return_reason) || !equals((Object) this.token, (Object) requestReturn.token) || !equals((Object) this.text_reason, (Object) requestReturn.text_reason) || !equals((List<?>) this.modelid, (List<?>) requestReturn.modelid) || !equals((List<?>) this.items, (List<?>) requestReturn.items) || !equals((Object) this.bparam, (Object) requestReturn.bparam) || !equals((Object) this.bank_account, (Object) requestReturn.bank_account) || !equals((Object) this.seller_due_date, (Object) requestReturn.seller_due_date) || !equals((Object) this.buyer_images, (Object) requestReturn.buyer_images) || !equals((Object) this.return_pickup_address, (Object) requestReturn.return_pickup_address) || !equals((Object) this.tracking_number, (Object) requestReturn.tracking_number) || !equals((Object) this.return_channel_id, (Object) requestReturn.return_channel_id) || !equals((Object) this.shipping_method, (Object) requestReturn.shipping_method) || !equals((Object) this.return_delivery_address, (Object) requestReturn.return_delivery_address) || !equals((Object) this.shipping_carrier, (Object) requestReturn.shipping_carrier) || !equals((Object) this.buyer_real_name, (Object) requestReturn.buyer_real_name) || !equals((Object) this.buyer_phone_number, (Object) requestReturn.buyer_phone_number) || !equals((Object) this.with_resolution_center, (Object) requestReturn.with_resolution_center) || !equals((Object) this.return_solution, (Object) requestReturn.return_solution) || !equals((List<?>) this.return_items, (List<?>) requestReturn.return_items) || !equals((Object) this.physical_return_allowed, (Object) requestReturn.physical_return_allowed) || !equals((Object) this.auto_approve_return_processing, (Object) requestReturn.auto_approve_return_processing) || !equals((Object) this.warehouse_validation, (Object) requestReturn.warehouse_validation)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.orderid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        List<Long> list = this.itemid;
        int i3 = 1;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.email;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.return_reason;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str3 = this.token;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.text_reason;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        List<Long> list2 = this.modelid;
        int hashCode9 = (hashCode8 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<ItemModelId> list3 = this.items;
        int hashCode10 = (hashCode9 + (list3 != null ? list3.hashCode() : 1)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode11 = (hashCode10 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        BankAccountInfo bankAccountInfo = this.bank_account;
        int hashCode12 = (hashCode11 + (bankAccountInfo != null ? bankAccountInfo.hashCode() : 0)) * 37;
        Integer num3 = this.seller_due_date;
        int hashCode13 = (hashCode12 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str5 = this.buyer_images;
        int hashCode14 = (hashCode13 + (str5 != null ? str5.hashCode() : 0)) * 37;
        BuyerAddress buyerAddress = this.return_pickup_address;
        int hashCode15 = (hashCode14 + (buyerAddress != null ? buyerAddress.hashCode() : 0)) * 37;
        String str6 = this.tracking_number;
        int hashCode16 = (hashCode15 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num4 = this.return_channel_id;
        int hashCode17 = (hashCode16 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.shipping_method;
        int hashCode18 = (hashCode17 + (num5 != null ? num5.hashCode() : 0)) * 37;
        BuyerAddress buyerAddress2 = this.return_delivery_address;
        int hashCode19 = (hashCode18 + (buyerAddress2 != null ? buyerAddress2.hashCode() : 0)) * 37;
        String str7 = this.shipping_carrier;
        int hashCode20 = (hashCode19 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.buyer_real_name;
        int hashCode21 = (hashCode20 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.buyer_phone_number;
        int hashCode22 = (hashCode21 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Boolean bool = this.with_resolution_center;
        int hashCode23 = (hashCode22 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num6 = this.return_solution;
        int hashCode24 = (hashCode23 + (num6 != null ? num6.hashCode() : 0)) * 37;
        List<ReturnItem> list4 = this.return_items;
        if (list4 != null) {
            i3 = list4.hashCode();
        }
        int i4 = (hashCode24 + i3) * 37;
        Boolean bool2 = this.physical_return_allowed;
        int hashCode25 = (i4 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.auto_approve_return_processing;
        int hashCode26 = (hashCode25 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.warehouse_validation;
        if (bool4 != null) {
            i2 = bool4.hashCode();
        }
        int i5 = hashCode26 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<RequestReturn> {
        public Boolean auto_approve_return_processing;
        public BankAccountInfo bank_account;
        public BackendParam bparam;
        public String buyer_images;
        public String buyer_phone_number;
        public String buyer_real_name;
        public String email;
        public List<Long> itemid;
        public List<ItemModelId> items;
        public List<Long> modelid;
        public Long orderid;
        public Boolean physical_return_allowed;
        public String requestid;
        public Integer return_channel_id;
        public BuyerAddress return_delivery_address;
        public List<ReturnItem> return_items;
        public BuyerAddress return_pickup_address;
        public Integer return_reason;
        public Integer return_solution;
        public Integer seller_due_date;
        public String shipping_carrier;
        public Integer shipping_method;
        public Integer shopid;
        public String text_reason;
        public String token;
        public String tracking_number;
        public Boolean warehouse_validation;
        public Boolean with_resolution_center;

        public Builder() {
        }

        public Builder(RequestReturn requestReturn) {
            super(requestReturn);
            if (requestReturn != null) {
                this.requestid = requestReturn.requestid;
                this.shopid = requestReturn.shopid;
                this.orderid = requestReturn.orderid;
                this.itemid = RequestReturn.copyOf(requestReturn.itemid);
                this.email = requestReturn.email;
                this.return_reason = requestReturn.return_reason;
                this.token = requestReturn.token;
                this.text_reason = requestReturn.text_reason;
                this.modelid = RequestReturn.copyOf(requestReturn.modelid);
                this.items = RequestReturn.copyOf(requestReturn.items);
                this.bparam = requestReturn.bparam;
                this.bank_account = requestReturn.bank_account;
                this.seller_due_date = requestReturn.seller_due_date;
                this.buyer_images = requestReturn.buyer_images;
                this.return_pickup_address = requestReturn.return_pickup_address;
                this.tracking_number = requestReturn.tracking_number;
                this.return_channel_id = requestReturn.return_channel_id;
                this.shipping_method = requestReturn.shipping_method;
                this.return_delivery_address = requestReturn.return_delivery_address;
                this.shipping_carrier = requestReturn.shipping_carrier;
                this.buyer_real_name = requestReturn.buyer_real_name;
                this.buyer_phone_number = requestReturn.buyer_phone_number;
                this.with_resolution_center = requestReturn.with_resolution_center;
                this.return_solution = requestReturn.return_solution;
                this.return_items = RequestReturn.copyOf(requestReturn.return_items);
                this.physical_return_allowed = requestReturn.physical_return_allowed;
                this.auto_approve_return_processing = requestReturn.auto_approve_return_processing;
                this.warehouse_validation = requestReturn.warehouse_validation;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder itemid(List<Long> list) {
            this.itemid = checkForNulls(list);
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder return_reason(Integer num) {
            this.return_reason = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder text_reason(String str) {
            this.text_reason = str;
            return this;
        }

        public Builder modelid(List<Long> list) {
            this.modelid = checkForNulls(list);
            return this;
        }

        public Builder items(List<ItemModelId> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder bank_account(BankAccountInfo bankAccountInfo) {
            this.bank_account = bankAccountInfo;
            return this;
        }

        public Builder seller_due_date(Integer num) {
            this.seller_due_date = num;
            return this;
        }

        public Builder buyer_images(String str) {
            this.buyer_images = str;
            return this;
        }

        public Builder return_pickup_address(BuyerAddress buyerAddress) {
            this.return_pickup_address = buyerAddress;
            return this;
        }

        public Builder tracking_number(String str) {
            this.tracking_number = str;
            return this;
        }

        public Builder return_channel_id(Integer num) {
            this.return_channel_id = num;
            return this;
        }

        public Builder shipping_method(Integer num) {
            this.shipping_method = num;
            return this;
        }

        public Builder return_delivery_address(BuyerAddress buyerAddress) {
            this.return_delivery_address = buyerAddress;
            return this;
        }

        public Builder shipping_carrier(String str) {
            this.shipping_carrier = str;
            return this;
        }

        public Builder buyer_real_name(String str) {
            this.buyer_real_name = str;
            return this;
        }

        public Builder buyer_phone_number(String str) {
            this.buyer_phone_number = str;
            return this;
        }

        public Builder with_resolution_center(Boolean bool) {
            this.with_resolution_center = bool;
            return this;
        }

        public Builder return_solution(Integer num) {
            this.return_solution = num;
            return this;
        }

        public Builder return_items(List<ReturnItem> list) {
            this.return_items = checkForNulls(list);
            return this;
        }

        public Builder physical_return_allowed(Boolean bool) {
            this.physical_return_allowed = bool;
            return this;
        }

        public Builder auto_approve_return_processing(Boolean bool) {
            this.auto_approve_return_processing = bool;
            return this;
        }

        public Builder warehouse_validation(Boolean bool) {
            this.warehouse_validation = bool;
            return this;
        }

        public RequestReturn build() {
            return new RequestReturn(this);
        }
    }
}

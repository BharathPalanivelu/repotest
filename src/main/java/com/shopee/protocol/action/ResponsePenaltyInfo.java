package com.shopee.protocol.action;

import com.shopee.protocol.shop.ItemAudit;
import com.shopee.protocol.shop.ShopMetricOrder;
import com.shopee.protocol.shop.ShopPenaltyHistoricalLog;
import com.shopee.protocol.shop.ShopPenaltyScoring;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponsePenaltyInfo extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Integer DEFAULT_NUM_RECORD = 0;
    public static final List<ShopPenaltyHistoricalLog> DEFAULT_PENALTY_HISTORY_LIST = Collections.emptyList();
    public static final List<ShopPenaltyScoring> DEFAULT_PENALTY_SCORING_LIST = Collections.emptyList();
    public static final List<PunishmentInfo> DEFAULT_PUNISHMENT_LIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final List<PenaltyTransifyInfo> DEFAULT_TRANSIFY_INFO = Collections.emptyList();
    public static final List<ItemAudit> DEFAULT_VIOLATION_ITEMS = Collections.emptyList();
    public static final List<ShopMetricOrder> DEFAULT_VIOLATION_ORDERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer num_record;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopPenaltyHistoricalLog.class, tag = 3)
    public final List<ShopPenaltyHistoricalLog> penalty_history_list;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopPenaltyScoring.class, tag = 5)
    public final List<ShopPenaltyScoring> penalty_scoring_list;
    @ProtoField(label = Message.Label.REPEATED, messageType = PunishmentInfo.class, tag = 4)
    public final List<PunishmentInfo> punishment_list;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = PenaltyTransifyInfo.class, tag = 9)
    public final List<PenaltyTransifyInfo> transify_info;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemAudit.class, tag = 6)
    public final List<ItemAudit> violation_items;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopMetricOrder.class, tag = 7)
    public final List<ShopMetricOrder> violation_orders;

    public ResponsePenaltyInfo(String str, Integer num, List<ShopPenaltyHistoricalLog> list, List<PunishmentInfo> list2, List<ShopPenaltyScoring> list3, List<ItemAudit> list4, List<ShopMetricOrder> list5, Integer num2, List<PenaltyTransifyInfo> list6) {
        this.requestid = str;
        this.errcode = num;
        this.penalty_history_list = immutableCopyOf(list);
        this.punishment_list = immutableCopyOf(list2);
        this.penalty_scoring_list = immutableCopyOf(list3);
        this.violation_items = immutableCopyOf(list4);
        this.violation_orders = immutableCopyOf(list5);
        this.num_record = num2;
        this.transify_info = immutableCopyOf(list6);
    }

    private ResponsePenaltyInfo(Builder builder) {
        this(builder.requestid, builder.errcode, builder.penalty_history_list, builder.punishment_list, builder.penalty_scoring_list, builder.violation_items, builder.violation_orders, builder.num_record, builder.transify_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponsePenaltyInfo)) {
            return false;
        }
        ResponsePenaltyInfo responsePenaltyInfo = (ResponsePenaltyInfo) obj;
        if (!equals((Object) this.requestid, (Object) responsePenaltyInfo.requestid) || !equals((Object) this.errcode, (Object) responsePenaltyInfo.errcode) || !equals((List<?>) this.penalty_history_list, (List<?>) responsePenaltyInfo.penalty_history_list) || !equals((List<?>) this.punishment_list, (List<?>) responsePenaltyInfo.punishment_list) || !equals((List<?>) this.penalty_scoring_list, (List<?>) responsePenaltyInfo.penalty_scoring_list) || !equals((List<?>) this.violation_items, (List<?>) responsePenaltyInfo.violation_items) || !equals((List<?>) this.violation_orders, (List<?>) responsePenaltyInfo.violation_orders) || !equals((Object) this.num_record, (Object) responsePenaltyInfo.num_record) || !equals((List<?>) this.transify_info, (List<?>) responsePenaltyInfo.transify_info)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<ShopPenaltyHistoricalLog> list = this.penalty_history_list;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<PunishmentInfo> list2 = this.punishment_list;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<ShopPenaltyScoring> list3 = this.penalty_scoring_list;
        int hashCode5 = (hashCode4 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<ItemAudit> list4 = this.violation_items;
        int hashCode6 = (hashCode5 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<ShopMetricOrder> list5 = this.violation_orders;
        int hashCode7 = (hashCode6 + (list5 != null ? list5.hashCode() : 1)) * 37;
        Integer num2 = this.num_record;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i4 = (hashCode7 + i2) * 37;
        List<PenaltyTransifyInfo> list6 = this.transify_info;
        if (list6 != null) {
            i3 = list6.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponsePenaltyInfo> {
        public Integer errcode;
        public Integer num_record;
        public List<ShopPenaltyHistoricalLog> penalty_history_list;
        public List<ShopPenaltyScoring> penalty_scoring_list;
        public List<PunishmentInfo> punishment_list;
        public String requestid;
        public List<PenaltyTransifyInfo> transify_info;
        public List<ItemAudit> violation_items;
        public List<ShopMetricOrder> violation_orders;

        public Builder() {
        }

        public Builder(ResponsePenaltyInfo responsePenaltyInfo) {
            super(responsePenaltyInfo);
            if (responsePenaltyInfo != null) {
                this.requestid = responsePenaltyInfo.requestid;
                this.errcode = responsePenaltyInfo.errcode;
                this.penalty_history_list = ResponsePenaltyInfo.copyOf(responsePenaltyInfo.penalty_history_list);
                this.punishment_list = ResponsePenaltyInfo.copyOf(responsePenaltyInfo.punishment_list);
                this.penalty_scoring_list = ResponsePenaltyInfo.copyOf(responsePenaltyInfo.penalty_scoring_list);
                this.violation_items = ResponsePenaltyInfo.copyOf(responsePenaltyInfo.violation_items);
                this.violation_orders = ResponsePenaltyInfo.copyOf(responsePenaltyInfo.violation_orders);
                this.num_record = responsePenaltyInfo.num_record;
                this.transify_info = ResponsePenaltyInfo.copyOf(responsePenaltyInfo.transify_info);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder penalty_history_list(List<ShopPenaltyHistoricalLog> list) {
            this.penalty_history_list = checkForNulls(list);
            return this;
        }

        public Builder punishment_list(List<PunishmentInfo> list) {
            this.punishment_list = checkForNulls(list);
            return this;
        }

        public Builder penalty_scoring_list(List<ShopPenaltyScoring> list) {
            this.penalty_scoring_list = checkForNulls(list);
            return this;
        }

        public Builder violation_items(List<ItemAudit> list) {
            this.violation_items = checkForNulls(list);
            return this;
        }

        public Builder violation_orders(List<ShopMetricOrder> list) {
            this.violation_orders = checkForNulls(list);
            return this;
        }

        public Builder num_record(Integer num) {
            this.num_record = num;
            return this;
        }

        public Builder transify_info(List<PenaltyTransifyInfo> list) {
            this.transify_info = checkForNulls(list);
            return this;
        }

        public ResponsePenaltyInfo build() {
            return new ResponsePenaltyInfo(this);
        }
    }
}

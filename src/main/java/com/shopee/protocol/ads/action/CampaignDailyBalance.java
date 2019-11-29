package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CampaignDailyBalance extends Message {
    public static final Long DEFAULT_CAMPAIGNID = 0L;
    public static final Long DEFAULT_DAILY_BALANCE = 0L;
    public static final Long DEFAULT_HISTORY_BALANCE = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long campaignid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long daily_balance;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long history_balance;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long mtime;

    public CampaignDailyBalance(Long l, Long l2, Long l3, Long l4) {
        this.campaignid = l;
        this.daily_balance = l2;
        this.mtime = l3;
        this.history_balance = l4;
    }

    private CampaignDailyBalance(Builder builder) {
        this(builder.campaignid, builder.daily_balance, builder.mtime, builder.history_balance);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CampaignDailyBalance)) {
            return false;
        }
        CampaignDailyBalance campaignDailyBalance = (CampaignDailyBalance) obj;
        if (!equals((Object) this.campaignid, (Object) campaignDailyBalance.campaignid) || !equals((Object) this.daily_balance, (Object) campaignDailyBalance.daily_balance) || !equals((Object) this.mtime, (Object) campaignDailyBalance.mtime) || !equals((Object) this.history_balance, (Object) campaignDailyBalance.history_balance)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.campaignid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.daily_balance;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.mtime;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.history_balance;
        if (l4 != null) {
            i2 = l4.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CampaignDailyBalance> {
        public Long campaignid;
        public Long daily_balance;
        public Long history_balance;
        public Long mtime;

        public Builder() {
        }

        public Builder(CampaignDailyBalance campaignDailyBalance) {
            super(campaignDailyBalance);
            if (campaignDailyBalance != null) {
                this.campaignid = campaignDailyBalance.campaignid;
                this.daily_balance = campaignDailyBalance.daily_balance;
                this.mtime = campaignDailyBalance.mtime;
                this.history_balance = campaignDailyBalance.history_balance;
            }
        }

        public Builder campaignid(Long l) {
            this.campaignid = l;
            return this;
        }

        public Builder daily_balance(Long l) {
            this.daily_balance = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder history_balance(Long l) {
            this.history_balance = l;
            return this;
        }

        public CampaignDailyBalance build() {
            return new CampaignDailyBalance(this);
        }
    }
}

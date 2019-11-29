package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;

public final class AdsBlackListKeywordDBModel extends Message {
    public static final Long DEFAULT_CTIME = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_KEYWORD = "";
    public static final Long DEFAULT_MTIME = 0L;
    public static final String DEFAULT_OPERATOR = "";
    public static final Integer DEFAULT_STATUS = 1;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;

    public AdsBlackListKeywordDBModel(Long l, String str, String str2, Long l2, Long l3, Integer num) {
        this.id = l;
        this.keyword = str;
        this.operator = str2;
        this.ctime = l2;
        this.mtime = l3;
        this.status = num;
    }

    private AdsBlackListKeywordDBModel(Builder builder) {
        this(builder.id, builder.keyword, builder.operator, builder.ctime, builder.mtime, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdsBlackListKeywordDBModel)) {
            return false;
        }
        AdsBlackListKeywordDBModel adsBlackListKeywordDBModel = (AdsBlackListKeywordDBModel) obj;
        if (!equals((Object) this.id, (Object) adsBlackListKeywordDBModel.id) || !equals((Object) this.keyword, (Object) adsBlackListKeywordDBModel.keyword) || !equals((Object) this.operator, (Object) adsBlackListKeywordDBModel.operator) || !equals((Object) this.ctime, (Object) adsBlackListKeywordDBModel.ctime) || !equals((Object) this.mtime, (Object) adsBlackListKeywordDBModel.mtime) || !equals((Object) this.status, (Object) adsBlackListKeywordDBModel.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.keyword;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.operator;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l2 = this.ctime;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.mtime;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.status;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AdsBlackListKeywordDBModel> {
        public Long ctime;
        public Long id;
        public String keyword;
        public Long mtime;
        public String operator;
        public Integer status;

        public Builder() {
        }

        public Builder(AdsBlackListKeywordDBModel adsBlackListKeywordDBModel) {
            super(adsBlackListKeywordDBModel);
            if (adsBlackListKeywordDBModel != null) {
                this.id = adsBlackListKeywordDBModel.id;
                this.keyword = adsBlackListKeywordDBModel.keyword;
                this.operator = adsBlackListKeywordDBModel.operator;
                this.ctime = adsBlackListKeywordDBModel.ctime;
                this.mtime = adsBlackListKeywordDBModel.mtime;
                this.status = adsBlackListKeywordDBModel.status;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public AdsBlackListKeywordDBModel build() {
            return new AdsBlackListKeywordDBModel(this);
        }
    }

    public enum PaidAdsBlacklistKeywordStatus implements ProtoEnum {
        DELETED(0),
        ACTIVE(1);
        
        private final int value;

        private PaidAdsBlacklistKeywordStatus(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}

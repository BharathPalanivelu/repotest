package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class HintRecord extends Message {
    public static final Integer DEFAULT_CATID = 0;
    public static final String DEFAULT_CAT_NAME = "";
    public static final String DEFAULT_KEYWORD = "";
    public static final HintKeywordSourceType DEFAULT_KEYWORD_SOURCE_TYPE = HintKeywordSourceType.SearchLog;
    public static final HintRecordType DEFAULT_RECORD_TYPE = HintRecordType.RegularSearch;
    public static final Integer DEFAULT_RNUM = 0;
    public static final String DEFAULT_TRACKINGID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String cat_name;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 6)
    public final HintData data;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String keyword;
    @ProtoField(tag = 8, type = Message.Datatype.ENUM)
    public final HintKeywordSourceType keyword_source_type;
    @ProtoField(tag = 5, type = Message.Datatype.ENUM)
    public final HintRecordType record_type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer rnum;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String trackingid;

    public HintRecord(String str, Integer num, Integer num2, String str2, HintRecordType hintRecordType, HintData hintData, String str3, HintKeywordSourceType hintKeywordSourceType) {
        this.keyword = str;
        this.rnum = num;
        this.catid = num2;
        this.cat_name = str2;
        this.record_type = hintRecordType;
        this.data = hintData;
        this.trackingid = str3;
        this.keyword_source_type = hintKeywordSourceType;
    }

    private HintRecord(Builder builder) {
        this(builder.keyword, builder.rnum, builder.catid, builder.cat_name, builder.record_type, builder.data, builder.trackingid, builder.keyword_source_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HintRecord)) {
            return false;
        }
        HintRecord hintRecord = (HintRecord) obj;
        if (!equals((Object) this.keyword, (Object) hintRecord.keyword) || !equals((Object) this.rnum, (Object) hintRecord.rnum) || !equals((Object) this.catid, (Object) hintRecord.catid) || !equals((Object) this.cat_name, (Object) hintRecord.cat_name) || !equals((Object) this.record_type, (Object) hintRecord.record_type) || !equals((Object) this.data, (Object) hintRecord.data) || !equals((Object) this.trackingid, (Object) hintRecord.trackingid) || !equals((Object) this.keyword_source_type, (Object) hintRecord.keyword_source_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.keyword;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.rnum;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.catid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.cat_name;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        HintRecordType hintRecordType = this.record_type;
        int hashCode5 = (hashCode4 + (hintRecordType != null ? hintRecordType.hashCode() : 0)) * 37;
        HintData hintData = this.data;
        int hashCode6 = (hashCode5 + (hintData != null ? hintData.hashCode() : 0)) * 37;
        String str3 = this.trackingid;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        HintKeywordSourceType hintKeywordSourceType = this.keyword_source_type;
        if (hintKeywordSourceType != null) {
            i2 = hintKeywordSourceType.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<HintRecord> {
        public String cat_name;
        public Integer catid;
        public HintData data;
        public String keyword;
        public HintKeywordSourceType keyword_source_type;
        public HintRecordType record_type;
        public Integer rnum;
        public String trackingid;

        public Builder() {
        }

        public Builder(HintRecord hintRecord) {
            super(hintRecord);
            if (hintRecord != null) {
                this.keyword = hintRecord.keyword;
                this.rnum = hintRecord.rnum;
                this.catid = hintRecord.catid;
                this.cat_name = hintRecord.cat_name;
                this.record_type = hintRecord.record_type;
                this.data = hintRecord.data;
                this.trackingid = hintRecord.trackingid;
                this.keyword_source_type = hintRecord.keyword_source_type;
            }
        }

        public Builder keyword(String str) {
            this.keyword = str;
            return this;
        }

        public Builder rnum(Integer num) {
            this.rnum = num;
            return this;
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder cat_name(String str) {
            this.cat_name = str;
            return this;
        }

        public Builder record_type(HintRecordType hintRecordType) {
            this.record_type = hintRecordType;
            return this;
        }

        public Builder data(HintData hintData) {
            this.data = hintData;
            return this;
        }

        public Builder trackingid(String str) {
            this.trackingid = str;
            return this;
        }

        public Builder keyword_source_type(HintKeywordSourceType hintKeywordSourceType) {
            this.keyword_source_type = hintKeywordSourceType;
            return this;
        }

        public HintRecord build() {
            checkRequiredFields();
            return new HintRecord(this);
        }
    }
}

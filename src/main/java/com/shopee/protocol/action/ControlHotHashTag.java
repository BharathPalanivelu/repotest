package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ControlHotHashTag extends Message {
    public static final List<HotHashTagBoostInfo> DEFAULT_BOOST_INFO = Collections.emptyList();
    public static final String DEFAULT_COUNTRY = "";
    public static final List<HotHashTagCtrDataInfo> DEFAULT_DATA_INFO = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = HotHashTagBoostInfo.class, tag = 6)
    public final List<HotHashTagBoostInfo> boost_info;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(label = Message.Label.REPEATED, messageType = HotHashTagCtrDataInfo.class, tag = 4)
    public final List<HotHashTagCtrDataInfo> data_info;
    @ProtoField(tag = 5)
    public final HotHashTagCtrLimitInfo limit_info;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer type;

    public ControlHotHashTag(String str, Integer num, String str2, List<HotHashTagCtrDataInfo> list, HotHashTagCtrLimitInfo hotHashTagCtrLimitInfo, List<HotHashTagBoostInfo> list2) {
        this.requestid = str;
        this.type = num;
        this.country = str2;
        this.data_info = immutableCopyOf(list);
        this.limit_info = hotHashTagCtrLimitInfo;
        this.boost_info = immutableCopyOf(list2);
    }

    private ControlHotHashTag(Builder builder) {
        this(builder.requestid, builder.type, builder.country, builder.data_info, builder.limit_info, builder.boost_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ControlHotHashTag)) {
            return false;
        }
        ControlHotHashTag controlHotHashTag = (ControlHotHashTag) obj;
        if (!equals((Object) this.requestid, (Object) controlHotHashTag.requestid) || !equals((Object) this.type, (Object) controlHotHashTag.type) || !equals((Object) this.country, (Object) controlHotHashTag.country) || !equals((List<?>) this.data_info, (List<?>) controlHotHashTag.data_info) || !equals((Object) this.limit_info, (Object) controlHotHashTag.limit_info) || !equals((List<?>) this.boost_info, (List<?>) controlHotHashTag.boost_info)) {
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
        Integer num = this.type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<HotHashTagCtrDataInfo> list = this.data_info;
        int i3 = 1;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        HotHashTagCtrLimitInfo hotHashTagCtrLimitInfo = this.limit_info;
        if (hotHashTagCtrLimitInfo != null) {
            i2 = hotHashTagCtrLimitInfo.hashCode();
        }
        int i4 = (hashCode4 + i2) * 37;
        List<HotHashTagBoostInfo> list2 = this.boost_info;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ControlHotHashTag> {
        public List<HotHashTagBoostInfo> boost_info;
        public String country;
        public List<HotHashTagCtrDataInfo> data_info;
        public HotHashTagCtrLimitInfo limit_info;
        public String requestid;
        public Integer type;

        public Builder() {
        }

        public Builder(ControlHotHashTag controlHotHashTag) {
            super(controlHotHashTag);
            if (controlHotHashTag != null) {
                this.requestid = controlHotHashTag.requestid;
                this.type = controlHotHashTag.type;
                this.country = controlHotHashTag.country;
                this.data_info = ControlHotHashTag.copyOf(controlHotHashTag.data_info);
                this.limit_info = controlHotHashTag.limit_info;
                this.boost_info = ControlHotHashTag.copyOf(controlHotHashTag.boost_info);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder data_info(List<HotHashTagCtrDataInfo> list) {
            this.data_info = checkForNulls(list);
            return this;
        }

        public Builder limit_info(HotHashTagCtrLimitInfo hotHashTagCtrLimitInfo) {
            this.limit_info = hotHashTagCtrLimitInfo;
            return this;
        }

        public Builder boost_info(List<HotHashTagBoostInfo> list) {
            this.boost_info = checkForNulls(list);
            return this;
        }

        public ControlHotHashTag build() {
            return new ControlHotHashTag(this);
        }
    }
}

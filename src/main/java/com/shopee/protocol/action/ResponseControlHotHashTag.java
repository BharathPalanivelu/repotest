package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseControlHotHashTag extends Message {
    public static final List<HotHashTagCtrDataInfo> DEFAULT_DATA_INFO = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = HotHashTagCtrDataInfo.class, tag = 4)
    public final List<HotHashTagCtrDataInfo> data_info;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 5)
    public final HotHashTagCtrLimitInfo limit_info;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseControlHotHashTag(String str, Integer num, List<HotHashTagCtrDataInfo> list, HotHashTagCtrLimitInfo hotHashTagCtrLimitInfo) {
        this.requestid = str;
        this.errcode = num;
        this.data_info = immutableCopyOf(list);
        this.limit_info = hotHashTagCtrLimitInfo;
    }

    private ResponseControlHotHashTag(Builder builder) {
        this(builder.requestid, builder.errcode, builder.data_info, builder.limit_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseControlHotHashTag)) {
            return false;
        }
        ResponseControlHotHashTag responseControlHotHashTag = (ResponseControlHotHashTag) obj;
        if (!equals((Object) this.requestid, (Object) responseControlHotHashTag.requestid) || !equals((Object) this.errcode, (Object) responseControlHotHashTag.errcode) || !equals((List<?>) this.data_info, (List<?>) responseControlHotHashTag.data_info) || !equals((Object) this.limit_info, (Object) responseControlHotHashTag.limit_info)) {
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
        List<HotHashTagCtrDataInfo> list = this.data_info;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        HotHashTagCtrLimitInfo hotHashTagCtrLimitInfo = this.limit_info;
        if (hotHashTagCtrLimitInfo != null) {
            i2 = hotHashTagCtrLimitInfo.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseControlHotHashTag> {
        public List<HotHashTagCtrDataInfo> data_info;
        public Integer errcode;
        public HotHashTagCtrLimitInfo limit_info;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseControlHotHashTag responseControlHotHashTag) {
            super(responseControlHotHashTag);
            if (responseControlHotHashTag != null) {
                this.requestid = responseControlHotHashTag.requestid;
                this.errcode = responseControlHotHashTag.errcode;
                this.data_info = ResponseControlHotHashTag.copyOf(responseControlHotHashTag.data_info);
                this.limit_info = responseControlHotHashTag.limit_info;
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

        public Builder data_info(List<HotHashTagCtrDataInfo> list) {
            this.data_info = checkForNulls(list);
            return this;
        }

        public Builder limit_info(HotHashTagCtrLimitInfo hotHashTagCtrLimitInfo) {
            this.limit_info = hotHashTagCtrLimitInfo;
            return this;
        }

        public ResponseControlHotHashTag build() {
            checkRequiredFields();
            return new ResponseControlHotHashTag(this);
        }
    }
}

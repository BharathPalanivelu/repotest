package com.shopee.protocol.action;

import com.shopee.protocol.shop.MultiLangTxt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PenaltyTransifyInfo extends Message {
    public static final Integer DEFAULT_OFFENCE_TYPE = 0;
    public static final List<MultiLangTxt> DEFAULT_TRANSIFY_CONTENT = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer offence_type;
    @ProtoField(label = Message.Label.REPEATED, messageType = MultiLangTxt.class, tag = 2)
    public final List<MultiLangTxt> transify_content;

    public PenaltyTransifyInfo(Integer num, List<MultiLangTxt> list) {
        this.offence_type = num;
        this.transify_content = immutableCopyOf(list);
    }

    private PenaltyTransifyInfo(Builder builder) {
        this(builder.offence_type, builder.transify_content);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PenaltyTransifyInfo)) {
            return false;
        }
        PenaltyTransifyInfo penaltyTransifyInfo = (PenaltyTransifyInfo) obj;
        if (!equals((Object) this.offence_type, (Object) penaltyTransifyInfo.offence_type) || !equals((List<?>) this.transify_content, (List<?>) penaltyTransifyInfo.transify_content)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.offence_type;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<MultiLangTxt> list = this.transify_content;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<PenaltyTransifyInfo> {
        public Integer offence_type;
        public List<MultiLangTxt> transify_content;

        public Builder() {
        }

        public Builder(PenaltyTransifyInfo penaltyTransifyInfo) {
            super(penaltyTransifyInfo);
            if (penaltyTransifyInfo != null) {
                this.offence_type = penaltyTransifyInfo.offence_type;
                this.transify_content = PenaltyTransifyInfo.copyOf(penaltyTransifyInfo.transify_content);
            }
        }

        public Builder offence_type(Integer num) {
            this.offence_type = num;
            return this;
        }

        public Builder transify_content(List<MultiLangTxt> list) {
            this.transify_content = checkForNulls(list);
            return this;
        }

        public PenaltyTransifyInfo build() {
            return new PenaltyTransifyInfo(this);
        }
    }
}

package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class LabelGroup extends Message {
    public static final LabelGroupOp DEFAULT_BIT_OP = LabelGroupOp.AND;
    public static final List<Long> DEFAULT_LABEL_IDS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.ENUM)
    public final LabelGroupOp bit_op;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT64)
    public final List<Long> label_ids;

    public LabelGroup(List<Long> list, LabelGroupOp labelGroupOp) {
        this.label_ids = immutableCopyOf(list);
        this.bit_op = labelGroupOp;
    }

    private LabelGroup(Builder builder) {
        this(builder.label_ids, builder.bit_op);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LabelGroup)) {
            return false;
        }
        LabelGroup labelGroup = (LabelGroup) obj;
        if (!equals((List<?>) this.label_ids, (List<?>) labelGroup.label_ids) || !equals((Object) this.bit_op, (Object) labelGroup.bit_op)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Long> list = this.label_ids;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        LabelGroupOp labelGroupOp = this.bit_op;
        int hashCode2 = hashCode + (labelGroupOp != null ? labelGroupOp.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<LabelGroup> {
        public LabelGroupOp bit_op;
        public List<Long> label_ids;

        public Builder() {
        }

        public Builder(LabelGroup labelGroup) {
            super(labelGroup);
            if (labelGroup != null) {
                this.label_ids = LabelGroup.copyOf(labelGroup.label_ids);
                this.bit_op = labelGroup.bit_op;
            }
        }

        public Builder label_ids(List<Long> list) {
            this.label_ids = checkForNulls(list);
            return this;
        }

        public Builder bit_op(LabelGroupOp labelGroupOp) {
            this.bit_op = labelGroupOp;
            return this;
        }

        public LabelGroup build() {
            return new LabelGroup(this);
        }
    }
}

package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResultAttribute extends Message {
    public static final Long DEFAULT_ATTR_ID = 0L;
    public static final String DEFAULT_VALUE = "";
    public static final List<LanguageAttributeValue> DEFAULT_VALUE_ALIAS = Collections.emptyList();
    public static final Long DEFAULT_VALUE_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long attr_id;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String value;
    @ProtoField(label = Message.Label.REPEATED, messageType = LanguageAttributeValue.class, tag = 4)
    public final List<LanguageAttributeValue> value_alias;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long value_id;

    public ResultAttribute(Long l, Long l2, String str, List<LanguageAttributeValue> list) {
        this.attr_id = l;
        this.value_id = l2;
        this.value = str;
        this.value_alias = immutableCopyOf(list);
    }

    private ResultAttribute(Builder builder) {
        this(builder.attr_id, builder.value_id, builder.value, builder.value_alias);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResultAttribute)) {
            return false;
        }
        ResultAttribute resultAttribute = (ResultAttribute) obj;
        if (!equals((Object) this.attr_id, (Object) resultAttribute.attr_id) || !equals((Object) this.value_id, (Object) resultAttribute.value_id) || !equals((Object) this.value, (Object) resultAttribute.value) || !equals((List<?>) this.value_alias, (List<?>) resultAttribute.value_alias)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.attr_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.value_id;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.value;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<LanguageAttributeValue> list = this.value_alias;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<ResultAttribute> {
        public Long attr_id;
        public String value;
        public List<LanguageAttributeValue> value_alias;
        public Long value_id;

        public Builder() {
        }

        public Builder(ResultAttribute resultAttribute) {
            super(resultAttribute);
            if (resultAttribute != null) {
                this.attr_id = resultAttribute.attr_id;
                this.value_id = resultAttribute.value_id;
                this.value = resultAttribute.value;
                this.value_alias = ResultAttribute.copyOf(resultAttribute.value_alias);
            }
        }

        public Builder attr_id(Long l) {
            this.attr_id = l;
            return this;
        }

        public Builder value_id(Long l) {
            this.value_id = l;
            return this;
        }

        public Builder value(String str) {
            this.value = str;
            return this;
        }

        public Builder value_alias(List<LanguageAttributeValue> list) {
            this.value_alias = checkForNulls(list);
            return this;
        }

        public ResultAttribute build() {
            return new ResultAttribute(this);
        }
    }
}

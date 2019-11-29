package com.shopee.protocol.action;

import com.shopee.protocol.shop.AttributeValue;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class MatchItemAttribute extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_MODELID = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final f DEFAULT_SIGNATURE = f.f32736b;
    public static final List<AttributeValue> DEFAULT_VALUE = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer modelid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f signature;
    @ProtoField(label = Message.Label.REPEATED, messageType = AttributeValue.class, tag = 3)
    public final List<AttributeValue> value;

    public MatchItemAttribute(String str, Integer num, List<AttributeValue> list, f fVar, String str2) {
        this.requestid = str;
        this.modelid = num;
        this.value = immutableCopyOf(list);
        this.signature = fVar;
        this.country = str2;
    }

    private MatchItemAttribute(Builder builder) {
        this(builder.requestid, builder.modelid, builder.value, builder.signature, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MatchItemAttribute)) {
            return false;
        }
        MatchItemAttribute matchItemAttribute = (MatchItemAttribute) obj;
        if (!equals((Object) this.requestid, (Object) matchItemAttribute.requestid) || !equals((Object) this.modelid, (Object) matchItemAttribute.modelid) || !equals((List<?>) this.value, (List<?>) matchItemAttribute.value) || !equals((Object) this.signature, (Object) matchItemAttribute.signature) || !equals((Object) this.country, (Object) matchItemAttribute.country)) {
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
        Integer num = this.modelid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<AttributeValue> list = this.value;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        f fVar = this.signature;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MatchItemAttribute> {
        public String country;
        public Integer modelid;
        public String requestid;
        public f signature;
        public List<AttributeValue> value;

        public Builder() {
        }

        public Builder(MatchItemAttribute matchItemAttribute) {
            super(matchItemAttribute);
            if (matchItemAttribute != null) {
                this.requestid = matchItemAttribute.requestid;
                this.modelid = matchItemAttribute.modelid;
                this.value = MatchItemAttribute.copyOf(matchItemAttribute.value);
                this.signature = matchItemAttribute.signature;
                this.country = matchItemAttribute.country;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder modelid(Integer num) {
            this.modelid = num;
            return this;
        }

        public Builder value(List<AttributeValue> list) {
            this.value = checkForNulls(list);
            return this;
        }

        public Builder signature(f fVar) {
            this.signature = fVar;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public MatchItemAttribute build() {
            return new MatchItemAttribute(this);
        }
    }
}

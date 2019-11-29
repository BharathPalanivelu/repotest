package com.shopee.protocol.action;

import com.shopee.protocol.shop.AttributeInstance;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class ResponseMatchAttribute extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<AttributeInstance> DEFAULT_NARROW_DOWN = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final f DEFAULT_SIGNATURE = f.f32736b;
    public static final List<AttributeInstance> DEFAULT_SUGGEST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = AttributeInstance.class, tag = 4)
    public final List<AttributeInstance> narrow_down;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f signature;
    @ProtoField(label = Message.Label.REPEATED, messageType = AttributeInstance.class, tag = 3)
    public final List<AttributeInstance> suggest;

    public ResponseMatchAttribute(String str, Integer num, List<AttributeInstance> list, List<AttributeInstance> list2, f fVar) {
        this.requestid = str;
        this.errcode = num;
        this.suggest = immutableCopyOf(list);
        this.narrow_down = immutableCopyOf(list2);
        this.signature = fVar;
    }

    private ResponseMatchAttribute(Builder builder) {
        this(builder.requestid, builder.errcode, builder.suggest, builder.narrow_down, builder.signature);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseMatchAttribute)) {
            return false;
        }
        ResponseMatchAttribute responseMatchAttribute = (ResponseMatchAttribute) obj;
        if (!equals((Object) this.requestid, (Object) responseMatchAttribute.requestid) || !equals((Object) this.errcode, (Object) responseMatchAttribute.errcode) || !equals((List<?>) this.suggest, (List<?>) responseMatchAttribute.suggest) || !equals((List<?>) this.narrow_down, (List<?>) responseMatchAttribute.narrow_down) || !equals((Object) this.signature, (Object) responseMatchAttribute.signature)) {
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
        List<AttributeInstance> list = this.suggest;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<AttributeInstance> list2 = this.narrow_down;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode3 + i3) * 37;
        f fVar = this.signature;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseMatchAttribute> {
        public Integer errcode;
        public List<AttributeInstance> narrow_down;
        public String requestid;
        public f signature;
        public List<AttributeInstance> suggest;

        public Builder() {
        }

        public Builder(ResponseMatchAttribute responseMatchAttribute) {
            super(responseMatchAttribute);
            if (responseMatchAttribute != null) {
                this.requestid = responseMatchAttribute.requestid;
                this.errcode = responseMatchAttribute.errcode;
                this.suggest = ResponseMatchAttribute.copyOf(responseMatchAttribute.suggest);
                this.narrow_down = ResponseMatchAttribute.copyOf(responseMatchAttribute.narrow_down);
                this.signature = responseMatchAttribute.signature;
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

        public Builder suggest(List<AttributeInstance> list) {
            this.suggest = checkForNulls(list);
            return this;
        }

        public Builder narrow_down(List<AttributeInstance> list) {
            this.narrow_down = checkForNulls(list);
            return this;
        }

        public Builder signature(f fVar) {
            this.signature = fVar;
            return this;
        }

        public ResponseMatchAttribute build() {
            return new ResponseMatchAttribute(this);
        }
    }
}

package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class HintData extends Message {
    public static final f DEFAULT_CURATED_SEARCH_MODULE_DATA = f.f32736b;
    public static final f DEFAULT_CURATED_SEARCH_MODULE_META = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f curated_search_module_data;
    @ProtoField(tag = 1, type = Message.Datatype.BYTES)
    public final f curated_search_module_meta;

    public HintData(f fVar, f fVar2) {
        this.curated_search_module_meta = fVar;
        this.curated_search_module_data = fVar2;
    }

    private HintData(Builder builder) {
        this(builder.curated_search_module_meta, builder.curated_search_module_data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HintData)) {
            return false;
        }
        HintData hintData = (HintData) obj;
        if (!equals((Object) this.curated_search_module_meta, (Object) hintData.curated_search_module_meta) || !equals((Object) this.curated_search_module_data, (Object) hintData.curated_search_module_data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        f fVar = this.curated_search_module_meta;
        int i2 = 0;
        int hashCode = (fVar != null ? fVar.hashCode() : 0) * 37;
        f fVar2 = this.curated_search_module_data;
        if (fVar2 != null) {
            i2 = fVar2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<HintData> {
        public f curated_search_module_data;
        public f curated_search_module_meta;

        public Builder() {
        }

        public Builder(HintData hintData) {
            super(hintData);
            if (hintData != null) {
                this.curated_search_module_meta = hintData.curated_search_module_meta;
                this.curated_search_module_data = hintData.curated_search_module_data;
            }
        }

        public Builder curated_search_module_meta(f fVar) {
            this.curated_search_module_meta = fVar;
            return this;
        }

        public Builder curated_search_module_data(f fVar) {
            this.curated_search_module_data = fVar;
            return this;
        }

        public HintData build() {
            return new HintData(this);
        }
    }
}

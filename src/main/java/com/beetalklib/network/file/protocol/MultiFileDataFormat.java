package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class MultiFileDataFormat extends Message {
    public static final List<MultiFileDataItemFormat> DEFAULT_FILES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = MultiFileDataItemFormat.class, tag = 1)
    public final List<MultiFileDataItemFormat> Files;

    public MultiFileDataFormat(List<MultiFileDataItemFormat> list) {
        this.Files = immutableCopyOf(list);
    }

    private MultiFileDataFormat(Builder builder) {
        this(builder.Files);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MultiFileDataFormat)) {
            return false;
        }
        return equals((List<?>) this.Files, (List<?>) ((MultiFileDataFormat) obj).Files);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<MultiFileDataItemFormat> list = this.Files;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<MultiFileDataFormat> {
        public List<MultiFileDataItemFormat> Files;

        public Builder() {
        }

        public Builder(MultiFileDataFormat multiFileDataFormat) {
            super(multiFileDataFormat);
            if (multiFileDataFormat != null) {
                this.Files = MultiFileDataFormat.copyOf(multiFileDataFormat.Files);
            }
        }

        public Builder Files(List<MultiFileDataItemFormat> list) {
            this.Files = checkForNulls(list);
            return this;
        }

        public MultiFileDataFormat build() {
            return new MultiFileDataFormat(this);
        }
    }
}

package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class NewMultiFileFormat extends Message {
    public static final List<NewMultiFileItemFormat> DEFAULT_FILES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = NewMultiFileItemFormat.class, tag = 1)
    public final List<NewMultiFileItemFormat> Files;

    public NewMultiFileFormat(List<NewMultiFileItemFormat> list) {
        this.Files = immutableCopyOf(list);
    }

    private NewMultiFileFormat(Builder builder) {
        this(builder.Files);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NewMultiFileFormat)) {
            return false;
        }
        return equals((List<?>) this.Files, (List<?>) ((NewMultiFileFormat) obj).Files);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<NewMultiFileItemFormat> list = this.Files;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<NewMultiFileFormat> {
        public List<NewMultiFileItemFormat> Files;

        public Builder() {
        }

        public Builder(NewMultiFileFormat newMultiFileFormat) {
            super(newMultiFileFormat);
            if (newMultiFileFormat != null) {
                this.Files = NewMultiFileFormat.copyOf(newMultiFileFormat.Files);
            }
        }

        public Builder Files(List<NewMultiFileItemFormat> list) {
            this.Files = checkForNulls(list);
            return this;
        }

        public NewMultiFileFormat build() {
            return new NewMultiFileFormat(this);
        }
    }
}

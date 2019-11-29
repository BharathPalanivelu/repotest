package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CommentTagInfoList extends Message {
    public static final List<CommentTagInfo> DEFAULT_TAGS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CommentTagInfo.class, tag = 1)
    public final List<CommentTagInfo> tags;

    public CommentTagInfoList(List<CommentTagInfo> list) {
        this.tags = immutableCopyOf(list);
    }

    private CommentTagInfoList(Builder builder) {
        this(builder.tags);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CommentTagInfoList)) {
            return false;
        }
        return equals((List<?>) this.tags, (List<?>) ((CommentTagInfoList) obj).tags);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<CommentTagInfo> list = this.tags;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<CommentTagInfoList> {
        public List<CommentTagInfo> tags;

        public Builder() {
        }

        public Builder(CommentTagInfoList commentTagInfoList) {
            super(commentTagInfoList);
            if (commentTagInfoList != null) {
                this.tags = CommentTagInfoList.copyOf(commentTagInfoList.tags);
            }
        }

        public Builder tags(List<CommentTagInfo> list) {
            this.tags = checkForNulls(list);
            return this;
        }

        public CommentTagInfoList build() {
            return new CommentTagInfoList(this);
        }
    }
}

package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ContentData extends Message {
    public static final List<ContentInfo> DEFAULT_CONTENT_INFOS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ContentInfo.class, tag = 1)
    public final List<ContentInfo> content_infos;

    public ContentData(List<ContentInfo> list) {
        this.content_infos = immutableCopyOf(list);
    }

    private ContentData(Builder builder) {
        this(builder.content_infos);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContentData)) {
            return false;
        }
        return equals((List<?>) this.content_infos, (List<?>) ((ContentData) obj).content_infos);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<ContentInfo> list = this.content_infos;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<ContentData> {
        public List<ContentInfo> content_infos;

        public Builder() {
        }

        public Builder(ContentData contentData) {
            super(contentData);
            if (contentData != null) {
                this.content_infos = ContentData.copyOf(contentData.content_infos);
            }
        }

        public Builder content_infos(List<ContentInfo> list) {
            this.content_infos = checkForNulls(list);
            return this;
        }

        public ContentData build() {
            return new ContentData(this);
        }
    }
}

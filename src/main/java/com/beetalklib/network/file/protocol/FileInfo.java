package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class FileInfo extends Message {
    public static final List<FileInfoItem> DEFAULT_ITEMS = Collections.emptyList();
    public static final Long DEFAULT_LASTREADTIME = 0L;
    public static final Long DEFAULT_LASTUPLOADTIME = 0L;
    public static final Integer DEFAULT_UPLOADCOUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long LastReadTime;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long LastUploadTime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer UploadCount;
    @ProtoField(label = Message.Label.REPEATED, messageType = FileInfoItem.class, tag = 4)
    public final List<FileInfoItem> items;

    public FileInfo(Integer num, Long l, Long l2, List<FileInfoItem> list) {
        this.UploadCount = num;
        this.LastUploadTime = l;
        this.LastReadTime = l2;
        this.items = immutableCopyOf(list);
    }

    private FileInfo(Builder builder) {
        this(builder.UploadCount, builder.LastUploadTime, builder.LastReadTime, builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileInfo)) {
            return false;
        }
        FileInfo fileInfo = (FileInfo) obj;
        if (!equals((Object) this.UploadCount, (Object) fileInfo.UploadCount) || !equals((Object) this.LastUploadTime, (Object) fileInfo.LastUploadTime) || !equals((Object) this.LastReadTime, (Object) fileInfo.LastReadTime) || !equals((List<?>) this.items, (List<?>) fileInfo.items)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.UploadCount;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.LastUploadTime;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.LastReadTime;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<FileInfoItem> list = this.items;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<FileInfo> {
        public Long LastReadTime;
        public Long LastUploadTime;
        public Integer UploadCount;
        public List<FileInfoItem> items;

        public Builder() {
        }

        public Builder(FileInfo fileInfo) {
            super(fileInfo);
            if (fileInfo != null) {
                this.UploadCount = fileInfo.UploadCount;
                this.LastUploadTime = fileInfo.LastUploadTime;
                this.LastReadTime = fileInfo.LastReadTime;
                this.items = FileInfo.copyOf(fileInfo.items);
            }
        }

        public Builder UploadCount(Integer num) {
            this.UploadCount = num;
            return this;
        }

        public Builder LastUploadTime(Long l) {
            this.LastUploadTime = l;
            return this;
        }

        public Builder LastReadTime(Long l) {
            this.LastReadTime = l;
            return this;
        }

        public Builder items(List<FileInfoItem> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public FileInfo build() {
            return new FileInfo(this);
        }
    }
}

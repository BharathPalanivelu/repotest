package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class FileInfoItem extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_FROM = 0;
    public static final String DEFAULT_MODEL = "";
    public static final Integer DEFAULT_MSGTYPE = 0;
    public static final Integer DEFAULT_OS = 0;
    public static final Long DEFAULT_UPLOADTIME = 0L;
    public static final Long DEFAULT_USERID = 0L;
    public static final Integer DEFAULT_VERSION = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String Country;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer From;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String Model;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer MsgType;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer OS;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long UploadTime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long UserID;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer Version;

    public FileInfoItem(Long l, Long l2, String str, Integer num, Integer num2, Integer num3, Integer num4, String str2) {
        this.UserID = l;
        this.UploadTime = l2;
        this.Country = str;
        this.From = num;
        this.MsgType = num2;
        this.OS = num3;
        this.Version = num4;
        this.Model = str2;
    }

    private FileInfoItem(Builder builder) {
        this(builder.UserID, builder.UploadTime, builder.Country, builder.From, builder.MsgType, builder.OS, builder.Version, builder.Model);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileInfoItem)) {
            return false;
        }
        FileInfoItem fileInfoItem = (FileInfoItem) obj;
        if (!equals((Object) this.UserID, (Object) fileInfoItem.UserID) || !equals((Object) this.UploadTime, (Object) fileInfoItem.UploadTime) || !equals((Object) this.Country, (Object) fileInfoItem.Country) || !equals((Object) this.From, (Object) fileInfoItem.From) || !equals((Object) this.MsgType, (Object) fileInfoItem.MsgType) || !equals((Object) this.OS, (Object) fileInfoItem.OS) || !equals((Object) this.Version, (Object) fileInfoItem.Version) || !equals((Object) this.Model, (Object) fileInfoItem.Model)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.UserID;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.UploadTime;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.Country;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.From;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.MsgType;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.OS;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.Version;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str2 = this.Model;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FileInfoItem> {
        public String Country;
        public Integer From;
        public String Model;
        public Integer MsgType;
        public Integer OS;
        public Long UploadTime;
        public Long UserID;
        public Integer Version;

        public Builder() {
        }

        public Builder(FileInfoItem fileInfoItem) {
            super(fileInfoItem);
            if (fileInfoItem != null) {
                this.UserID = fileInfoItem.UserID;
                this.UploadTime = fileInfoItem.UploadTime;
                this.Country = fileInfoItem.Country;
                this.From = fileInfoItem.From;
                this.MsgType = fileInfoItem.MsgType;
                this.OS = fileInfoItem.OS;
                this.Version = fileInfoItem.Version;
                this.Model = fileInfoItem.Model;
            }
        }

        public Builder UserID(Long l) {
            this.UserID = l;
            return this;
        }

        public Builder UploadTime(Long l) {
            this.UploadTime = l;
            return this;
        }

        public Builder Country(String str) {
            this.Country = str;
            return this;
        }

        public Builder From(Integer num) {
            this.From = num;
            return this;
        }

        public Builder MsgType(Integer num) {
            this.MsgType = num;
            return this;
        }

        public Builder OS(Integer num) {
            this.OS = num;
            return this;
        }

        public Builder Version(Integer num) {
            this.Version = num;
            return this;
        }

        public Builder Model(String str) {
            this.Model = str;
            return this;
        }

        public FileInfoItem build() {
            return new FileInfoItem(this);
        }
    }
}

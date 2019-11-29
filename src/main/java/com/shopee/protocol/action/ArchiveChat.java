package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ArchiveChat extends Message {
    public static final Integer DEFAULT_ARCHIVE = 0;
    public static final List<Long> DEFAULT_CHATID = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Integer> DEFAULT_USERID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer archive;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> chatid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> userid;

    public ArchiveChat(String str, List<Long> list, Integer num, List<Integer> list2) {
        this.requestid = str;
        this.chatid = immutableCopyOf(list);
        this.archive = num;
        this.userid = immutableCopyOf(list2);
    }

    private ArchiveChat(Builder builder) {
        this(builder.requestid, builder.chatid, builder.archive, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ArchiveChat)) {
            return false;
        }
        ArchiveChat archiveChat = (ArchiveChat) obj;
        if (!equals((Object) this.requestid, (Object) archiveChat.requestid) || !equals((List<?>) this.chatid, (List<?>) archiveChat.chatid) || !equals((Object) this.archive, (Object) archiveChat.archive) || !equals((List<?>) this.userid, (List<?>) archiveChat.userid)) {
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
        List<Long> list = this.chatid;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.archive;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i4 = (hashCode2 + i2) * 37;
        List<Integer> list2 = this.userid;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i5 = i4 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ArchiveChat> {
        public Integer archive;
        public List<Long> chatid;
        public String requestid;
        public List<Integer> userid;

        public Builder() {
        }

        public Builder(ArchiveChat archiveChat) {
            super(archiveChat);
            if (archiveChat != null) {
                this.requestid = archiveChat.requestid;
                this.chatid = ArchiveChat.copyOf(archiveChat.chatid);
                this.archive = archiveChat.archive;
                this.userid = ArchiveChat.copyOf(archiveChat.userid);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder chatid(List<Long> list) {
            this.chatid = checkForNulls(list);
            return this;
        }

        public Builder archive(Integer num) {
            this.archive = num;
            return this;
        }

        public Builder userid(List<Integer> list) {
            this.userid = checkForNulls(list);
            return this;
        }

        public ArchiveChat build() {
            return new ArchiveChat(this);
        }
    }
}

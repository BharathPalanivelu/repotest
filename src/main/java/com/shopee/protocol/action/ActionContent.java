package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class ActionContent extends Message {
    public static final String DEFAULT_ACTION_APP_PATH = "";
    public static final Integer DEFAULT_ACTION_CATE = 0;
    public static final Long DEFAULT_ACTION_ID = 0L;
    public static final String DEFAULT_ACTION_REACTNATIVE_PATH = "";
    public static final Integer DEFAULT_ACTION_REDIRECT_TYPE = 0;
    public static final String DEFAULT_ACTION_REDIRECT_URL = "";
    public static final Integer DEFAULT_ACTION_TYPE = 0;
    public static final String DEFAULT_APPRL = "";
    public static final String DEFAULT_AVATAR_IMAGE = "";
    public static final f DEFAULT_CONTENT = f.f32736b;
    public static final Integer DEFAULT_CREATETIME = 0;
    public static final Integer DEFAULT_GROUPED_COUNT = 0;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final List<String> DEFAULT_IMAGES = Collections.emptyList();
    public static final Integer DEFAULT_ITEM_COUNT = 0;
    public static final f DEFAULT_TITLE = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String action_app_path;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer action_cate;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT64)
    public final Long action_id;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String action_reactnative_path;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer action_redirect_type;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String action_redirect_url;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer action_type;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String apprl;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String avatar_image;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.BYTES)
    public final f content;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer createtime;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer grouped_count;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long groupid;
    @ProtoField(tag = 9)
    public final IdInfo id_info;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> images;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer item_count;
    @ProtoField(tag = 7, type = Message.Datatype.BYTES)
    public final f title;

    public ActionContent(f fVar, Integer num, List<String> list, Long l, Integer num2, Integer num3, f fVar2, Integer num4, IdInfo idInfo, String str, Integer num5, String str2, String str3, Long l2, Integer num6, String str4, String str5) {
        this.content = fVar;
        this.action_redirect_type = num;
        this.images = immutableCopyOf(list);
        this.action_id = l;
        this.createtime = num2;
        this.action_type = num3;
        this.title = fVar2;
        this.item_count = num4;
        this.id_info = idInfo;
        this.action_redirect_url = str;
        this.action_cate = num5;
        this.action_app_path = str2;
        this.action_reactnative_path = str3;
        this.groupid = l2;
        this.grouped_count = num6;
        this.avatar_image = str4;
        this.apprl = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ActionContent(com.shopee.protocol.action.ActionContent.Builder r21) {
        /*
            r20 = this;
            r0 = r21
            r1 = r20
            e.f r2 = r0.content
            java.lang.Integer r3 = r0.action_redirect_type
            java.util.List<java.lang.String> r4 = r0.images
            java.lang.Long r5 = r0.action_id
            java.lang.Integer r6 = r0.createtime
            java.lang.Integer r7 = r0.action_type
            e.f r8 = r0.title
            java.lang.Integer r9 = r0.item_count
            com.shopee.protocol.action.IdInfo r10 = r0.id_info
            java.lang.String r11 = r0.action_redirect_url
            java.lang.Integer r12 = r0.action_cate
            java.lang.String r13 = r0.action_app_path
            java.lang.String r14 = r0.action_reactnative_path
            java.lang.Long r15 = r0.groupid
            r19 = r1
            java.lang.Integer r1 = r0.grouped_count
            r16 = r1
            java.lang.String r1 = r0.avatar_image
            r17 = r1
            java.lang.String r1 = r0.apprl
            r18 = r1
            r1 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r20.setBuilder(r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.ActionContent.<init>(com.shopee.protocol.action.ActionContent$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActionContent)) {
            return false;
        }
        ActionContent actionContent = (ActionContent) obj;
        if (!equals((Object) this.content, (Object) actionContent.content) || !equals((Object) this.action_redirect_type, (Object) actionContent.action_redirect_type) || !equals((List<?>) this.images, (List<?>) actionContent.images) || !equals((Object) this.action_id, (Object) actionContent.action_id) || !equals((Object) this.createtime, (Object) actionContent.createtime) || !equals((Object) this.action_type, (Object) actionContent.action_type) || !equals((Object) this.title, (Object) actionContent.title) || !equals((Object) this.item_count, (Object) actionContent.item_count) || !equals((Object) this.id_info, (Object) actionContent.id_info) || !equals((Object) this.action_redirect_url, (Object) actionContent.action_redirect_url) || !equals((Object) this.action_cate, (Object) actionContent.action_cate) || !equals((Object) this.action_app_path, (Object) actionContent.action_app_path) || !equals((Object) this.action_reactnative_path, (Object) actionContent.action_reactnative_path) || !equals((Object) this.groupid, (Object) actionContent.groupid) || !equals((Object) this.grouped_count, (Object) actionContent.grouped_count) || !equals((Object) this.avatar_image, (Object) actionContent.avatar_image) || !equals((Object) this.apprl, (Object) actionContent.apprl)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        f fVar = this.content;
        int i2 = 0;
        int hashCode = (fVar != null ? fVar.hashCode() : 0) * 37;
        Integer num = this.action_redirect_type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<String> list = this.images;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.action_id;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.createtime;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.action_type;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        f fVar2 = this.title;
        int hashCode7 = (hashCode6 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Integer num4 = this.item_count;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        IdInfo idInfo = this.id_info;
        int hashCode9 = (hashCode8 + (idInfo != null ? idInfo.hashCode() : 0)) * 37;
        String str = this.action_redirect_url;
        int hashCode10 = (hashCode9 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num5 = this.action_cate;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str2 = this.action_app_path;
        int hashCode12 = (hashCode11 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.action_reactnative_path;
        int hashCode13 = (hashCode12 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l2 = this.groupid;
        int hashCode14 = (hashCode13 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num6 = this.grouped_count;
        int hashCode15 = (hashCode14 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str4 = this.avatar_image;
        int hashCode16 = (hashCode15 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.apprl;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode16 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActionContent> {
        public String action_app_path;
        public Integer action_cate;
        public Long action_id;
        public String action_reactnative_path;
        public Integer action_redirect_type;
        public String action_redirect_url;
        public Integer action_type;
        public String apprl;
        public String avatar_image;
        public f content;
        public Integer createtime;
        public Integer grouped_count;
        public Long groupid;
        public IdInfo id_info;
        public List<String> images;
        public Integer item_count;
        public f title;

        public Builder() {
        }

        public Builder(ActionContent actionContent) {
            super(actionContent);
            if (actionContent != null) {
                this.content = actionContent.content;
                this.action_redirect_type = actionContent.action_redirect_type;
                this.images = ActionContent.copyOf(actionContent.images);
                this.action_id = actionContent.action_id;
                this.createtime = actionContent.createtime;
                this.action_type = actionContent.action_type;
                this.title = actionContent.title;
                this.item_count = actionContent.item_count;
                this.id_info = actionContent.id_info;
                this.action_redirect_url = actionContent.action_redirect_url;
                this.action_cate = actionContent.action_cate;
                this.action_app_path = actionContent.action_app_path;
                this.action_reactnative_path = actionContent.action_reactnative_path;
                this.groupid = actionContent.groupid;
                this.grouped_count = actionContent.grouped_count;
                this.avatar_image = actionContent.avatar_image;
                this.apprl = actionContent.apprl;
            }
        }

        public Builder content(f fVar) {
            this.content = fVar;
            return this;
        }

        public Builder action_redirect_type(Integer num) {
            this.action_redirect_type = num;
            return this;
        }

        public Builder images(List<String> list) {
            this.images = checkForNulls(list);
            return this;
        }

        public Builder action_id(Long l) {
            this.action_id = l;
            return this;
        }

        public Builder createtime(Integer num) {
            this.createtime = num;
            return this;
        }

        public Builder action_type(Integer num) {
            this.action_type = num;
            return this;
        }

        public Builder title(f fVar) {
            this.title = fVar;
            return this;
        }

        public Builder item_count(Integer num) {
            this.item_count = num;
            return this;
        }

        public Builder id_info(IdInfo idInfo) {
            this.id_info = idInfo;
            return this;
        }

        public Builder action_redirect_url(String str) {
            this.action_redirect_url = str;
            return this;
        }

        public Builder action_cate(Integer num) {
            this.action_cate = num;
            return this;
        }

        public Builder action_app_path(String str) {
            this.action_app_path = str;
            return this;
        }

        public Builder action_reactnative_path(String str) {
            this.action_reactnative_path = str;
            return this;
        }

        public Builder groupid(Long l) {
            this.groupid = l;
            return this;
        }

        public Builder grouped_count(Integer num) {
            this.grouped_count = num;
            return this;
        }

        public Builder avatar_image(String str) {
            this.avatar_image = str;
            return this;
        }

        public Builder apprl(String str) {
            this.apprl = str;
            return this;
        }

        public ActionContent build() {
            checkRequiredFields();
            return new ActionContent(this);
        }
    }
}

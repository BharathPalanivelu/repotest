package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class UpdateContacts extends Message {
    public static final List<ContactMeta> DEFAULT_ADD_BEETALK = Collections.emptyList();
    public static final List<ContactMeta> DEFAULT_ADD_EMAIL = Collections.emptyList();
    public static final List<ContactMeta> DEFAULT_ADD_FACEBOOKID = Collections.emptyList();
    public static final List<ContactMeta> DEFAULT_ADD_PHONE = Collections.emptyList();
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_DATA_HASH_ID = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final f DEFAULT_DEVICE_FINGERPRINT = f.f32736b;
    public static final String DEFAULT_ITEMID = "";
    public static final Integer DEFAULT_PLATFORM_TYPE = 0;
    public static final List<ContactMeta> DEFAULT_REMOVE_BEETALK = Collections.emptyList();
    public static final List<ContactMeta> DEFAULT_REMOVE_EMAIL = Collections.emptyList();
    public static final List<ContactMeta> DEFAULT_REMOVE_FACEBOOKID = Collections.emptyList();
    public static final List<ContactMeta> DEFAULT_REMOVE_PHONE = Collections.emptyList();
    public static final Integer DEFAULT_REPORT_TIME = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ContactMeta.class, tag = 10)
    public final List<ContactMeta> add_beetalk;
    @ProtoField(label = Message.Label.REPEATED, messageType = ContactMeta.class, tag = 4)
    public final List<ContactMeta> add_email;
    @ProtoField(label = Message.Label.REPEATED, messageType = ContactMeta.class, tag = 3)
    public final List<ContactMeta> add_facebookid;
    @ProtoField(label = Message.Label.REPEATED, messageType = ContactMeta.class, tag = 2)
    public final List<ContactMeta> add_phone;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String data_hash_id;
    @ProtoField(tag = 12, type = Message.Datatype.BYTES)
    public final f device_fingerprint;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String itemid;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer platform_type;
    @ProtoField(label = Message.Label.REPEATED, messageType = ContactMeta.class, tag = 11)
    public final List<ContactMeta> remove_beetalk;
    @ProtoField(label = Message.Label.REPEATED, messageType = ContactMeta.class, tag = 7)
    public final List<ContactMeta> remove_email;
    @ProtoField(label = Message.Label.REPEATED, messageType = ContactMeta.class, tag = 6)
    public final List<ContactMeta> remove_facebookid;
    @ProtoField(label = Message.Label.REPEATED, messageType = ContactMeta.class, tag = 5)
    public final List<ContactMeta> remove_phone;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer report_time;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public UpdateContacts(String str, List<ContactMeta> list, List<ContactMeta> list2, List<ContactMeta> list3, List<ContactMeta> list4, List<ContactMeta> list5, List<ContactMeta> list6, f fVar, String str2, List<ContactMeta> list7, List<ContactMeta> list8, f fVar2, Integer num, String str3, String str4, Integer num2) {
        this.requestid = str;
        this.add_phone = immutableCopyOf(list);
        this.add_facebookid = immutableCopyOf(list2);
        this.add_email = immutableCopyOf(list3);
        this.remove_phone = immutableCopyOf(list4);
        this.remove_facebookid = immutableCopyOf(list5);
        this.remove_email = immutableCopyOf(list6);
        this.deviceid = fVar;
        this.country = str2;
        this.add_beetalk = immutableCopyOf(list7);
        this.remove_beetalk = immutableCopyOf(list8);
        this.device_fingerprint = fVar2;
        this.report_time = num;
        this.itemid = str3;
        this.data_hash_id = str4;
        this.platform_type = num2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private UpdateContacts(com.shopee.protocol.action.UpdateContacts.Builder r20) {
        /*
            r19 = this;
            r0 = r20
            r1 = r19
            java.lang.String r2 = r0.requestid
            java.util.List<com.shopee.protocol.action.ContactMeta> r3 = r0.add_phone
            java.util.List<com.shopee.protocol.action.ContactMeta> r4 = r0.add_facebookid
            java.util.List<com.shopee.protocol.action.ContactMeta> r5 = r0.add_email
            java.util.List<com.shopee.protocol.action.ContactMeta> r6 = r0.remove_phone
            java.util.List<com.shopee.protocol.action.ContactMeta> r7 = r0.remove_facebookid
            java.util.List<com.shopee.protocol.action.ContactMeta> r8 = r0.remove_email
            e.f r9 = r0.deviceid
            java.lang.String r10 = r0.country
            java.util.List<com.shopee.protocol.action.ContactMeta> r11 = r0.add_beetalk
            java.util.List<com.shopee.protocol.action.ContactMeta> r12 = r0.remove_beetalk
            e.f r13 = r0.device_fingerprint
            java.lang.Integer r14 = r0.report_time
            java.lang.String r15 = r0.itemid
            r18 = r1
            java.lang.String r1 = r0.data_hash_id
            r16 = r1
            java.lang.Integer r1 = r0.platform_type
            r17 = r1
            r1 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r19.setBuilder(r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.UpdateContacts.<init>(com.shopee.protocol.action.UpdateContacts$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateContacts)) {
            return false;
        }
        UpdateContacts updateContacts = (UpdateContacts) obj;
        if (!equals((Object) this.requestid, (Object) updateContacts.requestid) || !equals((List<?>) this.add_phone, (List<?>) updateContacts.add_phone) || !equals((List<?>) this.add_facebookid, (List<?>) updateContacts.add_facebookid) || !equals((List<?>) this.add_email, (List<?>) updateContacts.add_email) || !equals((List<?>) this.remove_phone, (List<?>) updateContacts.remove_phone) || !equals((List<?>) this.remove_facebookid, (List<?>) updateContacts.remove_facebookid) || !equals((List<?>) this.remove_email, (List<?>) updateContacts.remove_email) || !equals((Object) this.deviceid, (Object) updateContacts.deviceid) || !equals((Object) this.country, (Object) updateContacts.country) || !equals((List<?>) this.add_beetalk, (List<?>) updateContacts.add_beetalk) || !equals((List<?>) this.remove_beetalk, (List<?>) updateContacts.remove_beetalk) || !equals((Object) this.device_fingerprint, (Object) updateContacts.device_fingerprint) || !equals((Object) this.report_time, (Object) updateContacts.report_time) || !equals((Object) this.itemid, (Object) updateContacts.itemid) || !equals((Object) this.data_hash_id, (Object) updateContacts.data_hash_id) || !equals((Object) this.platform_type, (Object) updateContacts.platform_type)) {
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
        List<ContactMeta> list = this.add_phone;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<ContactMeta> list2 = this.add_facebookid;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<ContactMeta> list3 = this.add_email;
        int hashCode4 = (hashCode3 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<ContactMeta> list4 = this.remove_phone;
        int hashCode5 = (hashCode4 + (list4 != null ? list4.hashCode() : 1)) * 37;
        List<ContactMeta> list5 = this.remove_facebookid;
        int hashCode6 = (hashCode5 + (list5 != null ? list5.hashCode() : 1)) * 37;
        List<ContactMeta> list6 = this.remove_email;
        int hashCode7 = (hashCode6 + (list6 != null ? list6.hashCode() : 1)) * 37;
        f fVar = this.deviceid;
        int hashCode8 = (hashCode7 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<ContactMeta> list7 = this.add_beetalk;
        int hashCode10 = (hashCode9 + (list7 != null ? list7.hashCode() : 1)) * 37;
        List<ContactMeta> list8 = this.remove_beetalk;
        if (list8 != null) {
            i3 = list8.hashCode();
        }
        int i4 = (hashCode10 + i3) * 37;
        f fVar2 = this.device_fingerprint;
        int hashCode11 = (i4 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Integer num = this.report_time;
        int hashCode12 = (hashCode11 + (num != null ? num.hashCode() : 0)) * 37;
        String str3 = this.itemid;
        int hashCode13 = (hashCode12 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.data_hash_id;
        int hashCode14 = (hashCode13 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num2 = this.platform_type;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i5 = hashCode14 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<UpdateContacts> {
        public List<ContactMeta> add_beetalk;
        public List<ContactMeta> add_email;
        public List<ContactMeta> add_facebookid;
        public List<ContactMeta> add_phone;
        public String country;
        public String data_hash_id;
        public f device_fingerprint;
        public f deviceid;
        public String itemid;
        public Integer platform_type;
        public List<ContactMeta> remove_beetalk;
        public List<ContactMeta> remove_email;
        public List<ContactMeta> remove_facebookid;
        public List<ContactMeta> remove_phone;
        public Integer report_time;
        public String requestid;

        public Builder() {
        }

        public Builder(UpdateContacts updateContacts) {
            super(updateContacts);
            if (updateContacts != null) {
                this.requestid = updateContacts.requestid;
                this.add_phone = UpdateContacts.copyOf(updateContacts.add_phone);
                this.add_facebookid = UpdateContacts.copyOf(updateContacts.add_facebookid);
                this.add_email = UpdateContacts.copyOf(updateContacts.add_email);
                this.remove_phone = UpdateContacts.copyOf(updateContacts.remove_phone);
                this.remove_facebookid = UpdateContacts.copyOf(updateContacts.remove_facebookid);
                this.remove_email = UpdateContacts.copyOf(updateContacts.remove_email);
                this.deviceid = updateContacts.deviceid;
                this.country = updateContacts.country;
                this.add_beetalk = UpdateContacts.copyOf(updateContacts.add_beetalk);
                this.remove_beetalk = UpdateContacts.copyOf(updateContacts.remove_beetalk);
                this.device_fingerprint = updateContacts.device_fingerprint;
                this.report_time = updateContacts.report_time;
                this.itemid = updateContacts.itemid;
                this.data_hash_id = updateContacts.data_hash_id;
                this.platform_type = updateContacts.platform_type;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder add_phone(List<ContactMeta> list) {
            this.add_phone = checkForNulls(list);
            return this;
        }

        public Builder add_facebookid(List<ContactMeta> list) {
            this.add_facebookid = checkForNulls(list);
            return this;
        }

        public Builder add_email(List<ContactMeta> list) {
            this.add_email = checkForNulls(list);
            return this;
        }

        public Builder remove_phone(List<ContactMeta> list) {
            this.remove_phone = checkForNulls(list);
            return this;
        }

        public Builder remove_facebookid(List<ContactMeta> list) {
            this.remove_facebookid = checkForNulls(list);
            return this;
        }

        public Builder remove_email(List<ContactMeta> list) {
            this.remove_email = checkForNulls(list);
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder add_beetalk(List<ContactMeta> list) {
            this.add_beetalk = checkForNulls(list);
            return this;
        }

        public Builder remove_beetalk(List<ContactMeta> list) {
            this.remove_beetalk = checkForNulls(list);
            return this;
        }

        public Builder device_fingerprint(f fVar) {
            this.device_fingerprint = fVar;
            return this;
        }

        public Builder report_time(Integer num) {
            this.report_time = num;
            return this;
        }

        public Builder itemid(String str) {
            this.itemid = str;
            return this;
        }

        public Builder data_hash_id(String str) {
            this.data_hash_id = str;
            return this;
        }

        public Builder platform_type(Integer num) {
            this.platform_type = num;
            return this;
        }

        public UpdateContacts build() {
            return new UpdateContacts(this);
        }
    }
}

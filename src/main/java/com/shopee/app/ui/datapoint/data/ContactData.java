package com.shopee.app.ui.datapoint.data;

import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class ContactData {
    private final boolean allContactUploaded;
    private final Integer batchSize;

    public static /* synthetic */ ContactData copy$default(ContactData contactData, Integer num, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            num = contactData.batchSize;
        }
        if ((i & 2) != 0) {
            z = contactData.allContactUploaded;
        }
        return contactData.copy(num, z);
    }

    public final Integer component1() {
        return this.batchSize;
    }

    public final boolean component2() {
        return this.allContactUploaded;
    }

    public final ContactData copy(Integer num, boolean z) {
        return new ContactData(num, z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ContactData) {
                ContactData contactData = (ContactData) obj;
                if (j.a((Object) this.batchSize, (Object) contactData.batchSize)) {
                    if (this.allContactUploaded == contactData.allContactUploaded) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.batchSize;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        boolean z = this.allContactUploaded;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "ContactData(batchSize=" + this.batchSize + ", allContactUploaded=" + this.allContactUploaded + SQLBuilder.PARENTHESES_RIGHT;
    }

    public ContactData(Integer num, boolean z) {
        this.batchSize = num;
        this.allContactUploaded = z;
    }

    public final boolean getAllContactUploaded() {
        return this.allContactUploaded;
    }

    public final Integer getBatchSize() {
        return this.batchSize;
    }
}

package com.shopee.app.network.http.data;

import com.google.a.a.c;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;
import java.util.List;

public final class ListingConfig {
    @c(a = "attrs")
    private final List<ListingAttribute> listingAttrs;

    public static /* synthetic */ ListingConfig copy$default(ListingConfig listingConfig, List<ListingAttribute> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = listingConfig.listingAttrs;
        }
        return listingConfig.copy(list);
    }

    public final List<ListingAttribute> component1() {
        return this.listingAttrs;
    }

    public final ListingConfig copy(List<ListingAttribute> list) {
        j.b(list, "listingAttrs");
        return new ListingConfig(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ListingConfig) && j.a((Object) this.listingAttrs, (Object) ((ListingConfig) obj).listingAttrs);
        }
        return true;
    }

    public int hashCode() {
        List<ListingAttribute> list = this.listingAttrs;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ListingConfig(listingAttrs=" + this.listingAttrs + SQLBuilder.PARENTHESES_RIGHT;
    }

    public ListingConfig(List<ListingAttribute> list) {
        j.b(list, "listingAttrs");
        this.listingAttrs = list;
    }

    public final List<ListingAttribute> getListingAttrs() {
        return this.listingAttrs;
    }

    public static final class ListingAttribute {
        @c(a = "attr_key")
        private final String key;
        @c(a = "value_type")
        private final String type;
        @c(a = "attr_value")
        private final String value;

        public static /* synthetic */ ListingAttribute copy$default(ListingAttribute listingAttribute, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = listingAttribute.key;
            }
            if ((i & 2) != 0) {
                str2 = listingAttribute.type;
            }
            if ((i & 4) != 0) {
                str3 = listingAttribute.value;
            }
            return listingAttribute.copy(str, str2, str3);
        }

        public final String component1() {
            return this.key;
        }

        public final String component2() {
            return this.type;
        }

        public final String component3() {
            return this.value;
        }

        public final ListingAttribute copy(String str, String str2, String str3) {
            j.b(str, "key");
            j.b(str2, "type");
            j.b(str3, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            return new ListingAttribute(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListingAttribute)) {
                return false;
            }
            ListingAttribute listingAttribute = (ListingAttribute) obj;
            return j.a((Object) this.key, (Object) listingAttribute.key) && j.a((Object) this.type, (Object) listingAttribute.type) && j.a((Object) this.value, (Object) listingAttribute.value);
        }

        public int hashCode() {
            String str = this.key;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.type;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.value;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "ListingAttribute(key=" + this.key + ", type=" + this.type + ", value=" + this.value + SQLBuilder.PARENTHESES_RIGHT;
        }

        public ListingAttribute(String str, String str2, String str3) {
            j.b(str, "key");
            j.b(str2, "type");
            j.b(str3, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            this.key = str;
            this.type = str2;
            this.value = str3;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getType() {
            return this.type;
        }

        public final String getValue() {
            return this.value;
        }
    }
}

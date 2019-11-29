package com.shopee.app.network.http.data;

import com.facebook.internal.ServerProtocol;
import com.google.a.a.c;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class ListingUploadControlResponse extends BaseResponse {
    @c(a = "data")
    private final ListingConfig data;
    @c(a = "version")
    private final String version;

    public static /* synthetic */ ListingUploadControlResponse copy$default(ListingUploadControlResponse listingUploadControlResponse, String str, ListingConfig listingConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            str = listingUploadControlResponse.version;
        }
        if ((i & 2) != 0) {
            listingConfig = listingUploadControlResponse.data;
        }
        return listingUploadControlResponse.copy(str, listingConfig);
    }

    public final String component1() {
        return this.version;
    }

    public final ListingConfig component2() {
        return this.data;
    }

    public final ListingUploadControlResponse copy(String str, ListingConfig listingConfig) {
        j.b(str, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        j.b(listingConfig, "data");
        return new ListingUploadControlResponse(str, listingConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListingUploadControlResponse)) {
            return false;
        }
        ListingUploadControlResponse listingUploadControlResponse = (ListingUploadControlResponse) obj;
        return j.a((Object) this.version, (Object) listingUploadControlResponse.version) && j.a((Object) this.data, (Object) listingUploadControlResponse.data);
    }

    public int hashCode() {
        String str = this.version;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ListingConfig listingConfig = this.data;
        if (listingConfig != null) {
            i = listingConfig.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ListingUploadControlResponse(version=" + this.version + ", data=" + this.data + SQLBuilder.PARENTHESES_RIGHT;
    }

    public final String getVersion() {
        return this.version;
    }

    public final ListingConfig getData() {
        return this.data;
    }

    public ListingUploadControlResponse(String str, ListingConfig listingConfig) {
        j.b(str, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        j.b(listingConfig, "data");
        this.version = str;
        this.data = listingConfig;
    }
}

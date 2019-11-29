package com.shopee.app.network.http.data;

import com.google.a.a.c;
import com.google.a.o;
import com.litesuits.orm.db.assit.SQLBuilder;
import d.d.b.j;

public final class JsonDataResponse extends BaseResponse {
    @c(a = "data")
    private final o data;

    public static /* synthetic */ JsonDataResponse copy$default(JsonDataResponse jsonDataResponse, o oVar, int i, Object obj) {
        if ((i & 1) != 0) {
            oVar = jsonDataResponse.data;
        }
        return jsonDataResponse.copy(oVar);
    }

    public final o component1() {
        return this.data;
    }

    public final JsonDataResponse copy(o oVar) {
        j.b(oVar, "data");
        return new JsonDataResponse(oVar);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof JsonDataResponse) && j.a((Object) this.data, (Object) ((JsonDataResponse) obj).data);
        }
        return true;
    }

    public int hashCode() {
        o oVar = this.data;
        if (oVar != null) {
            return oVar.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "JsonDataResponse(data=" + this.data + SQLBuilder.PARENTHESES_RIGHT;
    }

    public JsonDataResponse(o oVar) {
        j.b(oVar, "data");
        this.data = oVar;
    }

    public final o getData() {
        return this.data;
    }
}

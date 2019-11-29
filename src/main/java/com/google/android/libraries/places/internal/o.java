package com.google.android.libraries.places.internal;

import com.android.b.a.h;
import com.android.b.n;
import java.util.Map;
import org.json.JSONObject;

public final class o extends h {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Map f13057a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(int i, String str, JSONObject jSONObject, n.b bVar, n.a aVar, Map map) {
        super(i, str, jSONObject, bVar, aVar);
        this.f13057a = map;
    }

    public final Map<String, String> getHeaders() {
        return this.f13057a;
    }
}

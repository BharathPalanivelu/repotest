package com.linecorp.linesdk.a.a.a;

import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements c<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private final d f15007a = new d();

    /* renamed from: b */
    public final JSONObject a(InputStream inputStream) {
        try {
            return new JSONObject(this.f15007a.a(inputStream));
        } catch (JSONException e2) {
            throw new IOException(e2);
        }
    }
}

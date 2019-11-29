package com.android.b.a;

import com.android.b.l;
import com.android.b.n;
import com.android.b.t;
import java.io.UnsupportedEncodingException;

public abstract class i<T> extends l<T> {
    private static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", new Object[]{PROTOCOL_CHARSET});
    private final n.b<T> mListener;
    private final String mRequestBody;

    /* access modifiers changed from: protected */
    public abstract n<T> parseNetworkResponse(com.android.b.i iVar);

    public i(String str, String str2, n.b<T> bVar, n.a aVar) {
        this(-1, str, str2, bVar, aVar);
    }

    public i(int i, String str, String str2, n.b<T> bVar, n.a aVar) {
        super(i, str, aVar);
        this.mListener = bVar;
        this.mRequestBody = str2;
    }

    /* access modifiers changed from: protected */
    public void deliverResponse(T t) {
        this.mListener.onResponse(t);
    }

    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    public byte[] getPostBody() {
        return getBody();
    }

    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    public byte[] getBody() {
        try {
            if (this.mRequestBody == null) {
                return null;
            }
            return this.mRequestBody.getBytes(PROTOCOL_CHARSET);
        } catch (UnsupportedEncodingException unused) {
            t.d("Unsupported Encoding while trying to get the bytes of %s using %s", this.mRequestBody, PROTOCOL_CHARSET);
            return null;
        }
    }
}

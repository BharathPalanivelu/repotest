package com.c.a.c.a;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public class k extends a<InputStream> {
    public k(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public InputStream a(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    /* access modifiers changed from: protected */
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    public Class<InputStream> d() {
        return InputStream.class;
    }
}

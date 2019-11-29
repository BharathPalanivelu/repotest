package com.shopee.app.ui.image.editor.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.garena.imageeditor.c.b;
import com.squareup.a.w;
import java.io.IOException;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22916a;

    public c(Context context) {
        super(d.a(56, context), d.a(56, context));
        this.f22916a = context;
    }

    public Bitmap a(Uri uri) {
        try {
            return w.a(this.f22916a).a(uri).b(b(), c()).d().h();
        } catch (IOException unused) {
            return null;
        }
    }
}

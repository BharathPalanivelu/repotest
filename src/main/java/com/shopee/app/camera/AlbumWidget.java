package com.shopee.app.camera;

import a.h;
import a.k;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.garena.android.appkit.tools.a.b;
import com.shopee.id.R;
import com.squareup.a.af;
import com.squareup.a.w;
import d.d.b.j;

public final class AlbumWidget extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private final af f15917a = new a(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlbumWidget(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.b(context, "context");
        j.b(attributeSet, "attributeSet");
        k.a(AnonymousClass1.f15918a).a(new h<Uri, Object>(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AlbumWidget f15919a;

            {
                this.f15919a = r1;
            }

            /* renamed from: a */
            public final Void then(k<Uri> kVar) {
                if (kVar == null || !kVar.e()) {
                    w.a(context).a(kVar != null ? kVar.f() : null).a((int) R.drawable.image_default_search).b(b.a.q, b.a.q).f().d().a(this.f15919a.getTarget());
                    StringBuilder sb = new StringBuilder();
                    sb.append("image_search recent album ");
                    sb.append(kVar != null ? kVar.f() : null);
                    com.garena.android.appkit.d.a.b(sb.toString(), new Object[0]);
                } else {
                    com.garena.android.appkit.d.a.a(kVar.g());
                }
                return null;
            }
        }, k.f377b);
    }

    public static final class a implements af {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AlbumWidget f15921a;

        public void a(Drawable drawable) {
        }

        a(AlbumWidget albumWidget) {
            this.f15921a = albumWidget;
        }

        public void b(Drawable drawable) {
            com.garena.android.appkit.d.a.a("image_search recent album bitmap load failed", new Object[0]);
        }

        public void a(Bitmap bitmap, w.d dVar) {
            com.garena.android.appkit.d.a.b("image_search recent album bitmap loaded " + String.valueOf(dVar), new Object[0]);
            this.f15921a.setImageBitmap(bitmap);
        }
    }

    public final af getTarget() {
        return this.f15917a;
    }
}

package com.shopee.app.ui.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.shopee.app.data.viewmodel.GalleryAlbumInfo;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.a.z;
import java.util.List;

public class c extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    ListView f21868a;

    /* renamed from: b  reason: collision with root package name */
    private a f21869b;

    /* renamed from: c  reason: collision with root package name */
    private b f21870c;

    public interface b {
        void a(GalleryAlbumInfo galleryAlbumInfo);
    }

    public c(Context context) {
        super(context);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21869b = new a();
        this.f21868a.setAdapter(this.f21869b);
        setOnClickListener(this);
    }

    public void setData(List<GalleryAlbumInfo> list) {
        this.f21869b.a(list);
        this.f21869b.notifyDataSetChanged();
    }

    public void setAlbumSelectListener(b bVar) {
        this.f21870c = bVar;
    }

    /* access modifiers changed from: package-private */
    public void a(GalleryAlbumInfo galleryAlbumInfo) {
        b bVar = this.f21870c;
        if (bVar != null) {
            bVar.a(galleryAlbumInfo);
        }
        c();
    }

    public void b() {
        setVisibility(0);
    }

    public void c() {
        setVisibility(8);
    }

    public void d() {
        if (getVisibility() == 0) {
            c();
        } else {
            b();
        }
    }

    public void onClick(View view) {
        c();
    }

    private static class a extends z<GalleryAlbumInfo> {
        private a() {
        }

        /* access modifiers changed from: protected */
        public n<GalleryAlbumInfo> a(Context context, int i) {
            return b.a(context);
        }
    }
}

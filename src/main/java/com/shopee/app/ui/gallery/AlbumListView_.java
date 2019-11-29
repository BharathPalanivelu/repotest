package com.shopee.app.ui.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class AlbumListView_ extends c implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f21828b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f21829c = new c();

    public AlbumListView_(Context context) {
        super(context);
        e();
    }

    public AlbumListView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }

    public AlbumListView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e();
    }

    public void onFinishInflate() {
        if (!this.f21828b) {
            this.f21828b = true;
            inflate(getContext(), R.layout.album_list_layout, this);
            this.f21829c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.f21829c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21868a = (ListView) aVar.internalFindViewById(R.id.listView);
        if (this.f21868a != null) {
            this.f21868a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
                /* JADX WARNING: Unknown variable types count: 1 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        com.shopee.app.ui.gallery.AlbumListView_ r2 = com.shopee.app.ui.gallery.AlbumListView_.this
                        android.widget.Adapter r1 = r1.getAdapter()
                        java.lang.Object r1 = r1.getItem(r3)
                        com.shopee.app.data.viewmodel.GalleryAlbumInfo r1 = (com.shopee.app.data.viewmodel.GalleryAlbumInfo) r1
                        r2.a(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.gallery.AlbumListView_.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
        }
        a();
    }
}

package com.shopee.app.ui.gallery.instagram;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {
    private boolean i = false;
    private final c j = new c();

    public g(Context context, int i2, boolean z, String str) {
        super(context, i2, z, str);
        e();
    }

    public static f a(Context context, int i2, boolean z, String str) {
        g gVar = new g(context, i2, z, str);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.instagram_gallery_layout, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.j);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f21946a = (RecyclerView) aVar.internalFindViewById(R.id.recycler_view);
        this.f21947b = (TextView) aVar.internalFindViewById(R.id.album_counter);
        a();
    }
}

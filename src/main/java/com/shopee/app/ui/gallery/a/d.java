package com.shopee.app.ui.gallery.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class d extends c implements a, b {
    private boolean n = false;
    private final c o = new c();

    public d(Context context, int i) {
        super(context, i);
        c();
    }

    public static c a(Context context, int i) {
        d dVar = new d(context, i);
        dVar.onFinishInflate();
        return dVar;
    }

    public void onFinishInflate() {
        if (!this.n) {
            this.n = true;
            inflate(getContext(), R.layout.gallery_view_layout, this);
            this.o.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.o);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21856a = (RecyclerView) aVar.internalFindViewById(R.id.recycler_view);
        this.f21857b = (TextView) aVar.internalFindViewById(R.id.album_filter);
        this.f21858c = (com.shopee.app.ui.gallery.c) aVar.internalFindViewById(R.id.album_list);
        this.f21859d = (TextView) aVar.internalFindViewById(R.id.album_counter);
        this.f21860e = (TextView) aVar.internalFindViewById(R.id.empty_view_label);
        if (this.f21857b != null) {
            this.f21857b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    d.this.b();
                }
            });
        }
        a();
    }
}

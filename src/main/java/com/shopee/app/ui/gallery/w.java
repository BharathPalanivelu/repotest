package com.shopee.app.ui.gallery;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class w extends v implements a, b {
    private boolean m = false;
    private final c n = new c();

    public w(Context context, int i, String str) {
        super(context, i, str);
        f();
    }

    public static v a(Context context, int i, String str) {
        w wVar = new w(context, i, str);
        wVar.onFinishInflate();
        return wVar;
    }

    public void onFinishInflate() {
        if (!this.m) {
            this.m = true;
            inflate(getContext(), R.layout.gallery_view_layout, this);
            this.n.a((a) this);
        }
        super.onFinishInflate();
    }

    private void f() {
        c a2 = c.a(this.n);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22018a = (RecyclerView) aVar.internalFindViewById(R.id.recycler_view);
        this.f22019b = (TextView) aVar.internalFindViewById(R.id.album_filter);
        this.f22020c = (c) aVar.internalFindViewById(R.id.album_list);
        this.f22021d = (TextView) aVar.internalFindViewById(R.id.album_counter);
        this.f22022e = (TextView) aVar.internalFindViewById(R.id.empty_view_label);
        if (this.f22019b != null) {
            this.f22019b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    w.this.c();
                }
            });
        }
        if (this.f22021d != null) {
            this.f22021d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    w.this.d();
                }
            });
        }
        a();
    }
}

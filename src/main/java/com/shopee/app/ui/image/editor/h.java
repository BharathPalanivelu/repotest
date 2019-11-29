package com.shopee.app.ui.image.editor;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.garena.android.appkit.tools.b;
import com.garena.imageeditor.ImageEditView;
import com.garena.imageeditor.a.c.n;
import com.garena.imageeditor.a.c.o;
import com.shopee.app.ui.image.editor.d.d;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Iterator;
import jp.co.cyberagent.android.gpuimage.b;
import jp.co.cyberagent.android.gpuimage.e;

public class h extends HorizontalScrollView implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f22946a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f22947b = d.a(5, getContext());

    /* renamed from: c  reason: collision with root package name */
    private a f22948c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<n> f22949d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<com.shopee.app.ui.image.editor.c.b.a> f22950e;

    public interface a {
        void a(View view, n nVar, ViewGroup viewGroup);
    }

    public h(Context context) {
        super(context);
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f22949d = new ArrayList<>();
        this.f22950e = new ArrayList<>();
        a(b.e(R.string.sp_label_original), n.NONE);
        a("Cantata", n.CANTATA);
        a("Homophony", n.HOMOPHONY);
        a("Chorale", n.CHORALE);
        a("Etude", n.ETUDE);
        a("Fugue", n.FUGUE);
        a("March", n.MARCH);
        a("Nocturne", n.NOCTURNE);
        a("Opera", n.OPERA);
        a("Overture", n.OVERTURE);
        a("Serenade", n.SERENADE);
        a("Symphony", n.SYMPHONY);
        a("Rhapsody", n.RHAPSODY);
        a("Prelude", n.PRELUDE);
        setHorizontalScrollBarEnabled(false);
        this.f22950e.get(0).setActivated(true);
    }

    private void a(String str, n nVar) {
        com.shopee.app.ui.image.editor.c.b.a a2 = com.shopee.app.ui.image.editor.c.b.b.a(getContext());
        a2.setText(str);
        a2.setPreset(nVar);
        a2.setOnClickListener(this);
        this.f22946a.addView(a2);
        this.f22949d.add(nVar);
        this.f22950e.add(a2);
    }

    public void setItemClickListener(a aVar) {
        this.f22948c = aVar;
    }

    public void onClick(View view) {
        if (view instanceof com.shopee.app.ui.image.editor.c.b.a) {
            final com.shopee.app.ui.image.editor.c.b.a aVar = (com.shopee.app.ui.image.editor.c.b.a) view;
            if (!aVar.isActivated()) {
                Iterator<com.shopee.app.ui.image.editor.c.b.a> it = this.f22950e.iterator();
                while (it.hasNext()) {
                    com.shopee.app.ui.image.editor.c.b.a next = it.next();
                    if (next != aVar) {
                        next.setActivated(false);
                    } else {
                        next.setActivated(true);
                    }
                }
                getHandler().post(new Runnable() {
                    public void run() {
                        h.this.smoothScrollTo(Math.max(((aVar.getLeft() + aVar.getRight()) - h.this.getWidth()) / 2, 0), 0);
                    }
                });
                a aVar2 = this.f22948c;
                if (aVar2 != null) {
                    aVar2.a(view, aVar.getPreset(), this.f22946a);
                }
            }
        }
    }

    public void a(n nVar) {
        Iterator<com.shopee.app.ui.image.editor.c.b.a> it = this.f22950e.iterator();
        final com.shopee.app.ui.image.editor.c.b.a aVar = null;
        while (it.hasNext()) {
            com.shopee.app.ui.image.editor.c.b.a next = it.next();
            if (next.getPreset() != nVar) {
                next.setActivated(false);
            } else {
                next.setActivated(true);
                aVar = next;
            }
        }
        if (aVar != null) {
            getHandler().post(new Runnable() {
                public void run() {
                    h.this.smoothScrollTo(Math.max(((aVar.getLeft() + aVar.getRight()) - h.this.getWidth()) / 2, 0), 0);
                }
            });
        }
    }

    public void a(ImageEditView imageEditView) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f22949d.size(); i++) {
            arrayList.add(o.a(getContext(), this.f22949d.get(i)));
        }
        imageEditView.a((ArrayList<e>) arrayList, (b.a<Bitmap>) new b.a<Bitmap>() {

            /* renamed from: b  reason: collision with root package name */
            private int f22956b = 0;

            public void a(Bitmap bitmap) {
                ((com.shopee.app.ui.image.editor.c.b.a) h.this.f22950e.get(this.f22956b)).setIconBitmap(com.garena.cropimage.library.b.a(bitmap, h.this.f22947b));
                this.f22956b = (this.f22956b + 1) % h.this.f22950e.size();
            }
        });
    }

    public void setEnabled(boolean z) {
        Iterator<com.shopee.app.ui.image.editor.c.b.a> it = this.f22950e.iterator();
        while (it.hasNext()) {
            it.next().setEnabled(z);
        }
        super.setEnabled(z);
    }
}

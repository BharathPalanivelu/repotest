package com.shopee.feeds.feedlibrary.editor.text;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.garena.android.appkit.f.f;
import com.garena.android.appkit.tools.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.editor.activity.AbstractEditActivity;
import com.shopee.feeds.feedlibrary.editor.b.a;
import com.shopee.feeds.feedlibrary.editor.b.d;
import com.shopee.feeds.feedlibrary.editor.multitouch.a;
import com.shopee.feeds.feedlibrary.editor.text.TextEditorDialogFragment;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.w;

public class c extends a<b> {
    public c(d dVar) {
        super(dVar);
        a(8);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: a */
    public void f(final b bVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        final d dVar = new d(this.f27913b.getContext());
        dVar.setInfo(bVar);
        this.f27913b.a((View) dVar, (ViewGroup.LayoutParams) layoutParams);
        dVar.setVisibility(4);
        com.shopee.feeds.feedlibrary.editor.multitouch.a aVar = new com.shopee.feeds.feedlibrary.editor.multitouch.a(this.f27913b.getSourceView(), this.f27913b.getDeleteView(), true);
        aVar.a((a.c) new a.c() {
            public void a() {
                e.q();
                final b bVar = (b) c.this.a(bVar.g());
                if (bVar != null) {
                    TextEditorDialogFragment.a((AbstractEditActivity) c.this.f27913b.getContext(), bVar, new TextEditorDialogFragment.a() {
                        public void a(b bVar) {
                            c.this.b(bVar);
                            c.this.f27913b.getTextEditor().a(bVar);
                        }

                        public void a() {
                            ((AbstractEditActivity) c.this.f27913b.getContext()).a(false);
                            f.a().a(new Runnable() {
                                public void run() {
                                    c.this.c(bVar);
                                }
                            }, 100);
                        }

                        public void b() {
                            ((AbstractEditActivity) c.this.f27913b.getContext()).a(true);
                            f.a().a(new Runnable() {
                                public void run() {
                                    c.this.b();
                                }
                            }, 100);
                        }
                    });
                }
            }

            public void a(View view) {
                c.this.b(bVar);
            }

            public void a(int i, int i2, float f2, float f3) {
                b bVar = (b) c.this.a(bVar.g());
                if (bVar != null) {
                    bVar.g(((float) i) / ((float) c.this.f27913b.getMeasuredWidth()));
                    bVar.h(((float) i2) / ((float) c.this.f27913b.getMeasuredHeight()));
                    bVar.i(f2);
                    bVar.j(w.a(f2));
                    bVar.a((int) f3);
                }
            }
        });
        dVar.setOnTouchListener(aVar);
        f.a().a(new Runnable() {
            public void run() {
                if (bVar.h() == BitmapDescriptorFactory.HUE_RED) {
                    dVar.setX((float) b.d(c.C0424c.feeds_text_sticker_edit_text_margin));
                } else {
                    dVar.setX((bVar.h() * ((float) c.this.f27913b.getMeasuredWidth())) - (((float) dVar.getMeasuredWidth()) / 2.0f));
                }
                if (bVar.i() == BitmapDescriptorFactory.HUE_RED) {
                    dVar.setY((float) ((c.this.f27913b.getMeasuredHeight() / 2) - (dVar.getMeasuredHeight() / 2)));
                } else {
                    dVar.setY((bVar.i() * ((float) c.this.f27913b.getMeasuredHeight())) - (((float) dVar.getMeasuredHeight()) / 2.0f));
                }
                dVar.setScaleX(bVar.j());
                dVar.setScaleY(bVar.j());
                dVar.setRotation((float) bVar.l());
                dVar.setVisibility(0);
                e.p();
            }
        });
    }
}

package com.shopee.feeds.feedlibrary.editor.sticker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.shopee.feeds.feedlibrary.editor.activity.AbstractEditActivity;
import com.shopee.feeds.feedlibrary.editor.b.c;
import com.shopee.feeds.feedlibrary.editor.multitouch.a;
import com.shopee.feeds.feedlibrary.editor.sticker.CommentStickerEditorPanel;
import com.shopee.feeds.feedlibrary.editor.sticker.a.f;
import com.shopee.feeds.feedlibrary.editor.sticker.b;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.w;
import java.util.HashMap;
import java.util.Iterator;

public class d extends com.shopee.feeds.feedlibrary.editor.b.a<com.shopee.feeds.feedlibrary.editor.sticker.a.d> {

    /* renamed from: e  reason: collision with root package name */
    private int f28006e;

    /* renamed from: f  reason: collision with root package name */
    private int f28007f;

    /* renamed from: g  reason: collision with root package name */
    private int f28008g;
    private int h;
    private int i;
    private HashMap<c, com.shopee.feeds.feedlibrary.editor.multitouch.a> j = new HashMap<>();
    /* access modifiers changed from: private */
    public c k = null;
    private CommentStickerItemView l = null;
    /* access modifiers changed from: private */
    public a m;
    private com.shopee.feeds.feedlibrary.editor.b.d n = null;

    public interface a {
        void a(int i);
    }

    public void a(a aVar) {
        this.m = aVar;
    }

    public d(com.shopee.feeds.feedlibrary.editor.b.d dVar) {
        super(dVar);
        a(1000);
    }

    public com.shopee.feeds.feedlibrary.editor.multitouch.a e() {
        c cVar = this.k;
        if (cVar == null) {
            return null;
        }
        return this.j.get(cVar);
    }

    public RelativeLayout f() {
        return this.f27913b.getPhotoParentView();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: a */
    public void f(final com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar) {
        final c cVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int q = dVar.q();
        if (q == 1) {
            cVar = new b(this.f27913b.getContext());
            com.shopee.feeds.feedlibrary.editor.sticker.a.c cVar2 = (com.shopee.feeds.feedlibrary.editor.sticker.a.c) dVar;
            ((b) cVar).a((b.a) new b.a() {
                public void a() {
                    d.this.b(dVar);
                }
            }).a(cVar2.n(), cVar2.o());
            e.a("image");
        } else if (q == 2) {
            cVar = new c(this.f27913b.getContext());
            e.a("mention");
        } else if (q == 3) {
            cVar = new e(this.f27913b.getContext());
            e.a("voucher");
        } else if (q == 4) {
            cVar = new CommentStickerItemView(this.f27913b.getContext());
            this.l = (CommentStickerItemView) cVar;
            e.a("comment");
        } else if (q != 5) {
            cVar = new b(this.f27913b.getContext());
            e.a("image");
        } else {
            cVar = new a(this.f27913b.getContext());
            e.a("buyer");
        }
        h.b("%s", "StickerEditor createItemView " + dVar.q());
        cVar.setInfo(dVar);
        this.f27913b.a((View) cVar, (ViewGroup.LayoutParams) layoutParams);
        if (cVar instanceof e) {
            a(true);
        } else if (cVar instanceof CommentStickerItemView) {
            a(false);
        }
        this.n = this.f27913b;
        cVar.setVisibility(4);
        com.shopee.feeds.feedlibrary.editor.multitouch.a aVar = new com.shopee.feeds.feedlibrary.editor.multitouch.a(this.f27913b.getSourceView(), this.f27913b.getDeleteView(), true);
        aVar.c(true);
        aVar.a(cVar);
        if (dVar.q() == 4 || dVar.q() == 3 || dVar.q() == 2 || dVar.q() == 5) {
            aVar.b(true);
        } else {
            aVar.b(false);
        }
        if (dVar.q() == 5) {
            aVar.a(false);
            this.f27913b.p();
        } else {
            aVar.a(true);
        }
        this.j.put(cVar, aVar);
        aVar.a((a.b) new a.b() {
            public void a(c cVar) {
                if (cVar != null) {
                    c unused = d.this.k = cVar;
                }
            }
        });
        aVar.a((a.c) new a.c() {
            public void a() {
                final com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.d) d.this.a(dVar.g());
                if (dVar != null && dVar.q() == 3) {
                    e.b("voucher");
                    com.shopee.feeds.feedlibrary.util.a.a(d.this.f27913b.getContext(), 1, (f) dVar);
                } else if (dVar != null && dVar.q() == 4) {
                    e.b("comment");
                    d.this.c(dVar);
                    ((AbstractEditActivity) d.this.f27913b.getContext()).s().a((CommentStickerEditorPanel.a) new CommentStickerEditorPanel.a() {
                        public void a(com.shopee.feeds.feedlibrary.editor.sticker.a.b bVar) {
                            d.this.d(bVar);
                            d.this.q();
                            d.this.a(false);
                        }

                        public void a() {
                            ((AbstractEditActivity) d.this.f27913b.getContext()).a(false);
                            com.garena.android.appkit.f.f.a().a(new Runnable() {
                                public void run() {
                                    d.this.c(dVar);
                                }
                            }, 100);
                        }

                        public void b() {
                            ((AbstractEditActivity) d.this.f27913b.getContext()).a(true);
                            d.this.b();
                        }
                    }).b((com.shopee.feeds.feedlibrary.editor.sticker.a.b) dVar);
                }
            }

            public void a(View view) {
                d.this.b(dVar);
            }

            public void a(int i, int i2, float f2, float f3) {
                h.b("%s", "onViewShapeChanged " + i + "," + i2 + "," + f2 + "," + f3);
                com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.d) d.this.a(dVar.g());
                if (dVar != null) {
                    dVar.g(((float) i) / ((float) d.this.f27913b.getMeasuredWidth()));
                    dVar.h(((float) i2) / ((float) d.this.f27913b.getMeasuredHeight()));
                    dVar.i(f2);
                    dVar.j(w.a(f2));
                    dVar.a((int) f3);
                }
            }
        });
        cVar.setOnTouchListener(aVar);
        this.k = cVar;
        cVar.setVisibility(4);
        com.garena.android.appkit.f.f.a().a(new Runnable() {
            public void run() {
                c cVar = cVar;
                if (cVar instanceof a) {
                    cVar.setScaleX(dVar.j());
                    cVar.setScaleY(dVar.j());
                    cVar.setRotation((float) dVar.l());
                    ((a) cVar).b();
                    com.garena.android.appkit.f.f.a().a(new Runnable() {
                        public void run() {
                            int x = ((int) cVar.getX()) + (cVar.getMeasuredWidth() / 2);
                            int y = ((int) cVar.getY()) + (cVar.getMeasuredHeight() / 2);
                            com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.d) d.this.a(dVar.g());
                            if (dVar != null) {
                                dVar.g(((float) x) / ((float) d.this.f27913b.getMeasuredWidth()));
                                dVar.h(((float) y) / ((float) d.this.f27913b.getMeasuredHeight()));
                            }
                        }
                    });
                } else {
                    cVar.setX((dVar.h() * ((float) d.this.f27913b.getMeasuredWidth())) - (((float) cVar.getMeasuredWidth()) / 2.0f));
                    cVar.setY((dVar.i() * ((float) d.this.f27913b.getMeasuredHeight())) - (((float) cVar.getMeasuredHeight()) / 2.0f));
                    cVar.setScaleX(dVar.j());
                    cVar.setScaleY(dVar.j());
                    cVar.setRotation((float) dVar.l());
                }
                cVar.setVisibility(0);
                if (d.this.m != null) {
                    d.this.m.a(dVar.q());
                }
                View view = (View) cVar.getParent();
                h.b("%s", "dbempty view " + cVar.getVisibility() + "," + cVar.getMeasuredWidth() + "," + cVar.getScaleY() + "," + cVar.getRotation() + "," + cVar.getParent().toString() + "，" + cVar.getWidth());
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    public void q() {
        CommentStickerItemView commentStickerItemView = this.l;
        if (commentStickerItemView != null) {
            commentStickerItemView.c();
        }
    }

    public void g() {
        if (this.f27913b != null) {
            this.f27913b.p();
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (this.f27913b != null) {
            RelativeLayout photoParentView = this.f27913b.getPhotoParentView();
            if (photoParentView != null) {
                for (int i2 = 0; i2 < photoParentView.getChildCount(); i2++) {
                    View childAt = photoParentView.getChildAt(i2);
                    if ((childAt instanceof e) && childAt.getVisibility() == 0) {
                        com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.d) ((e) childAt).getmInfo();
                        if (Build.VERSION.SDK_INT >= 21) {
                            if (z) {
                                childAt.setTranslationZ(2.01f);
                                dVar.k(2.01f);
                            } else {
                                childAt.setTranslationZ(2.0f);
                                dVar.k(2.0f);
                            }
                        }
                    } else if ((childAt instanceof CommentStickerItemView) && childAt.getVisibility() == 0) {
                        com.shopee.feeds.feedlibrary.editor.sticker.a.b info = ((CommentStickerItemView) childAt).getInfo();
                        if (Build.VERSION.SDK_INT >= 21) {
                            if (z) {
                                childAt.setTranslationZ(2.0f);
                                info.k(2.0f);
                            } else {
                                childAt.setTranslationZ(2.01f);
                                info.k(2.01f);
                            }
                        }
                    }
                }
            }
        }
    }

    public c h() {
        return this.l;
    }

    /* renamed from: b */
    public void a(com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar) {
        int q = dVar.q();
        if (q == 1) {
            int i2 = this.f28006e;
            if (i2 < 50) {
                this.f28006e = i2 + 1;
            } else {
                return;
            }
        } else if (q == 2) {
            int i3 = this.f28007f;
            if (i3 < 50) {
                this.f28007f = i3 + 1;
            } else {
                return;
            }
        } else if (q == 3) {
            int i4 = this.f28008g;
            if (i4 < 1) {
                this.f28008g = i4 + 1;
            } else {
                return;
            }
        } else if (q == 4) {
            int i5 = this.h;
            if (i5 < 1) {
                this.h = i5 + 1;
            } else {
                return;
            }
        } else if (q == 5) {
            int i6 = this.i;
            if (i6 < 1) {
                this.i = i6 + 1;
            } else {
                return;
            }
        } else {
            return;
        }
        super.a(dVar);
    }

    /* renamed from: c */
    public void b(com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar) {
        int q = dVar.q();
        if (q == 1) {
            this.f28006e--;
        } else if (q == 2) {
            this.f28007f--;
        } else if (q == 3) {
            this.f28008g--;
        } else if (q == 4) {
            this.h--;
        } else {
            return;
        }
        super.b(dVar);
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.f28006e = 0;
        this.f28007f = 0;
        this.f28008g = 0;
        this.h = 0;
        this.i = 0;
        super.c();
    }

    public boolean i() {
        return this.f28008g < 1;
    }

    public boolean j() {
        return this.i < 1;
    }

    public boolean k() {
        return this.h < 1;
    }

    public boolean l() {
        return this.f28006e < 50;
    }

    public boolean m() {
        return this.f28007f < 50;
    }

    public boolean n() {
        return this.f28008g > 0 || this.h > 0 || this.f28007f > 0 || this.i > 0;
    }

    public com.shopee.feeds.feedlibrary.editor.sticker.a.b o() {
        Iterator it = this.f27915d.iterator();
        while (it.hasNext()) {
            com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.d) it.next();
            if (dVar.q() == 4) {
                return (com.shopee.feeds.feedlibrary.editor.sticker.a.b) dVar;
            }
        }
        return null;
    }

    public f p() {
        Iterator it = this.f27915d.iterator();
        while (it.hasNext()) {
            com.shopee.feeds.feedlibrary.editor.sticker.a.d dVar = (com.shopee.feeds.feedlibrary.editor.sticker.a.d) it.next();
            if (dVar.q() == 3) {
                return (f) dVar;
            }
        }
        return null;
    }
}
